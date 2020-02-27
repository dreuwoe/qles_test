package com.example.qles;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user touches the button start*/
    public void Login(View view) {
     /*  try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.3.5/qles_werkwent","QLES", "Qles");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from qles_table_gebruiker");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3));
            }
            con.close();
        } catch(Exception e){
                System.out.println(e);
            }*/

            Intent UserPageIntent = new Intent(MainActivity.this,
                    UserPage.class);
            startActivity(UserPageIntent);
    }

    /** Called when the user touches the button registreren*/
    public void Registreren (View view) {
        {
            Intent RegisterPageIntent = new Intent(MainActivity.this,
                    RegisterPage.class);
            startActivity(RegisterPageIntent);
        }
   }
    /** Called when the user touches the button Website*/
    public void ToWebsite (View view) {
        Intent ToWebsiteIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.werkwent.nl"));
        startActivity(ToWebsiteIntent);
    }
   }



