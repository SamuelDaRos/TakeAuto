package it.iisvittorioveneto.itt.takeauto;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.takeauto.R;

import static it.iisvittorioveneto.itt.takeauto.Registration.lUser;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button Button1 = this.findViewById(R.id.login2);
        Button1.setOnClickListener(v3 -> {
            EditText username= findViewById(R.id.usernameRegistration);
            EditText password= findViewById(R.id.Password_login);

            int i=0;
            boolean user=false;
            while(i< lUser.getNumElementi()){
                if(lUser.getElemento(i).getUsername().equals(username.getText().toString()) && lUser.getElemento(i).getPassword().equals(password.getText().toString())){
                    i=lUser.getNumElementi()+1;
                    user=true;
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