package com.example.oneaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Button Button1 = this.findViewById(R.id.login);
            Button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v){
                    Intent intentLogin = new Intent(MainActivity.this, Login.class);
                    startActivity(intentLogin);
                }
            });
            Button Button2 = this.findViewById(R.id.registration);
            Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v2){
                Intent intentRegistration = new Intent(MainActivity.this, Registration.class);
                startActivity(intentRegistration);
            }
        });
}
    }