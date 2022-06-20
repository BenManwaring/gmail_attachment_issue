# GMail attachment issue
When sending a piped file, Gmail closes the pipe and sends a corrupted file instead.

## Google issue tracker
~https://issuetracker.google.com/issues/235374656~ - closed as advice was it was the wrong place for this issue
https://issuetracker.google.com/issues/235489985

## Example built APK
[app-debug.apk](README/app-debug.apk)

## Steps to reproduce
1. Install this app.
2. Install and setup GMail with an email account.
3. Open this app and tap "Send File" button.
4. Chose to use GMail to send the file if multiple apps available.
5. Send the email containing the file.

### Video
[Video](README/video.mp4)

## Expected results
The email is send containing the image of the android robot

## Actual results
### Using com.google.android.gm_2022.04.03.445234996.Release-63212521.apk or earlier version
The email successfully contains the image correctly.

#### Example
![From 63212521.png](<README/From 63212521.png>)

#### EML file
[From 63212521.eml](<README/From 63212521.eml>)

#### APK file
*This APK should not be trusted, they are taken from 3rd party source so should not be used with secure Google accounts.*
[com.google.android.gm_2022.04.03.445234996.Release-63212521.apk](README/com.google.android.gm_2022.04.03.445234996.Release-63212521.apk)

### Using com.google.android.gm_2022.04.17.446880209.Release-63240686.apk or later version
The email contains a corrupted file in place of the image.

#### Example
![From 63240686.png](<README/From 63240686.png>)

#### EML file
[From 63240686.eml](<README/From 63240686.eml>)

#### APK file
*This APK should not be trusted, they are taken from 3rd party source so should not be used with secure Google accounts.*
[com.google.android.gm_2022.04.17.446880209.Release-63240686.apk](README/com.google.android.gm_2022.04.17.446880209.Release-63240686.apk)
