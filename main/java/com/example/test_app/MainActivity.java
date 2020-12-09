package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText text = findViewById(R.id.text) ;
        //
        btn1 = findViewById(R.id.call) ;
        btn2 = findViewById(R.id.browser) ;
        btn3 = findViewById(R.id.contact) ;
        btn4 = findViewById(R.id.wifi) ;
        btn5 = findViewById(R.id.app) ;

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL) ;
                String phone = text.getText().toString() ;
                callIntent.setData(Uri.parse("tel:"+phone)) ;
                startActivity(callIntent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NavIntent  = new Intent(Intent.ACTION_VIEW) ;
                String url = text.getText().toString() ;
                NavIntent .setData(Uri.parse("http://"+url)) ;
                startActivity(NavIntent );
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ListIntent = new Intent(Intent.ACTION_PICK);
                ListIntent.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivity(ListIntent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WifiIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(WifiIntent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GestAppIntent = new Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
                startActivity(GestAppIntent);
            }
        });




    }
}
