package com.example.oneaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        setContentView(R.layout.activity_login);
        Button Button1 = this.findViewById(R.id.login2);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v3){
                Intent intentfinal = new Intent(Login.this, Final_Activity.class);
                startActivity(intentfinal);
            }
        });
    }

}