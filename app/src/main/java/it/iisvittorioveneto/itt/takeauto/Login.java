package it.iisvittorioveneto.itt.takeauto;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.takeauto.R;

public class Login extends AppCompatActivity {

    public Boolean user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button Button1 = this.findViewById(R.id.login2);
        Button1.setOnClickListener(v3 -> {
            EditText username= findViewById(R.id.username);
            EditText password= findViewById(R.id.Password_login);

            // TODO
            // controllo se username e password si trovano nel database
            // esito positivo -> passa alla prossima activity
            // esito negativo -> appare un toast


            for(int i=0; i< MainActivity.getList().size(); i++){
                if(MainActivity.getList().get(i).getUsername().equals(username.getText().toString()) && MainActivity.getList().get(i).getPassword().equals(password.getText().toString())){
                    user=true;
                    break;
                }
            }
            if(user){
                Intent finalIntent = new Intent(Login.this, Final_Activity.class);
                startActivity(finalIntent);
            }else{
                Toast.makeText(getApplicationContext(), "username or password wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
}