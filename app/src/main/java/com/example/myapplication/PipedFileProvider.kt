package com.example.myapplication

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.os.ParcelFileDescriptor
import android.provider.OpenableColumns
import java.io.OutputStream

class PipedFileProvider : ContentProvider() {

    override fun getType(uri: Uri) = "image/png"

    override fun openFile(uri: Uri, mode: String) =
        openPipeHelper(uri, "", null, null) { output, _, _, _, _ ->
            ParcelFileDescriptor.AutoCloseOutputStream(output).use { outputStream ->
                context?.resources?.openRawResource(R.raw.android_robot)?.use { inputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String?>?,
        sortOrder: String?
    ): Cursor {
        val projectionDefaulted =
            projection ?: arrayOf(OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE)

        val cols = arrayOfNulls<String>(projectionDefaulted.size)
        val values = arrayOfNulls<Any>(projectionDefaulted.size)
        var numberOfRelevantColumns = 0
        for (columns in projectionDefaulted) {
            when {
                OpenableColumns.DISPLAY_NAME == columns -> {
                    cols[numberOfRelevantColumns] = OpenableColumns.DISPLAY_NAME
                    values[numberOfRelevantColumns++] = "android_robot.png"
                }
                OpenableColumns.SIZE == columns -> {
                    cols[numberOfRelevantColumns] = OpenableColumns.SIZE
                    values[numberOfRelevantColumns++] =
                        context?.resources?.openRawResource(R.raw.android_robot)?.use {
                            var size = 0
                            it.copyTo(object : OutputStream() {
                                override fun write(p0: Int) {
                                    size++
                                }
                            }, 1000)
                            size
                        }
                }
            }
        }

        return MatrixCursor(cols.copyOf(numberOfRelevantColumns), 1).also {
            it.addRow(values.copyOf(numberOfRelevantColumns))
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Nothing? = null

    override fun onCreate() = true

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ) = -1

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?) = -1
}