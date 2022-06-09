# GMail attahcment issue
When sending a piped file, Gmail closes the pipe and sends a currupted file instead.

## Steps to reproduce
1. Install this app.
2. Install and setup GMail with an email account.
3. Open this app and tap "Send File" button.
4. Chose to use GMail to send the file if multiple apps available.
5. Send the email containing the file.

## Expected results
The email is send containing the image of the android robot

## Actual results
### Using com.google.android.gm_2022.04.03.445234996.Release-63212521.apk or earlier version
The email succesfully contains the image correctly.
![Screenshot 2022-06-09 at 12 43 12](https://user-images.githubusercontent.com/24303118/172838818-0a0bf4e0-cbae-4281-b0af-9025e4c2c73d.png)


### Using com.google.android.gm_2022.04.17.446880209.Release-63240686.apk or later version
The email contains a currpted file in place of the image.

#### Example
![Screenshot 2022-06-09 at 12 42 26](https://user-images.githubusercontent.com/24303118/172838838-e48e951b-e62c-4b89-a823-789edcb72283.png)
