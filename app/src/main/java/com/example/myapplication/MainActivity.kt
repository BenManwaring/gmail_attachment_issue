package com.example.myapplication

import android.content.ClipData
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val uri = Uri.Builder()
                .scheme("content")
                .authority("com.example.myapplication.android.robot")
                .appendPath("android_robot.png")
                .build()

            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("hello@google.com"))
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Do you like my robot?")
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Please find attached my robot image!")
            sendIntent.putExtra(Intent.EXTRA_STREAM, uri)
            sendIntent.type = "image/png"
            sendIntent.clipData = ClipData.newUri(contentResolver, "android_robot.png", uri)
            sendIntent.addFlags(
                Intent.FLAG_GRANT_READ_URI_PERMISSION
                        or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                        or Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION
                        or Intent.FLAG_GRANT_PREFIX_URI_PERMISSION
            )

            startActivity(sendIntent)
        }
    }
}