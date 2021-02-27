package com.example.oneaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_);
        TextView text1 = this.findViewById(R.id.creditsText);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v3){
                Intent intentcredits = new Intent(Final_Activity.this, credits.class);
                startActivity(intentcredits);
            }
        });
    }
}