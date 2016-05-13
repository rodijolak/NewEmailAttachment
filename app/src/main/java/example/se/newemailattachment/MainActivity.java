package example.se.newemailattachment;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
     public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        Button addImage = (Button) findViewById(R.id.send);
        addImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Mail m = new Mail("xxxx@gmail.com", "passward");

                String[] toArr = {"xxxx@gmail.com", "xxxx@gmail.com"};
                m.set_to(toArr);
                m.set_from("xxxx@gmail.com");
                m.set_subject("This is an email sent using my Mail JavaMail wrapper from an Android device.");
                m.setBody("Email body.");

                try {

                    // put the file in the sdcard of the AVD using  Android Device Monitor (file explorer)
                   m.addAttachment("/mnt/sdcard/file.csv");

                    if(m.send()) {
                        Toast.makeText(MainActivity.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show();
                    }
                } catch(Exception e) {
                    //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
                    Log.e("MailApp", "Could not send email", e);
                    e.printStackTrace();
                }
            }
        });
    }
}