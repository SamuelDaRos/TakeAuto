package it.iisvittorioveneto.itt.takeauto;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.takeauto.R;
import static it.iisvittorioveneto.itt.takeauto.Registration.userList;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = this.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(v3 -> {
            EditText username= findViewById(R.id.usernameLogin);
            EditText password= findViewById(R.id.passwordLogin);

            // controllo esistenza utente
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUsername().equals(username.getText().toString()) && userList.get(i).getPassword().equals(password.getText().toString())) {
                    Intent finalIntent = new Intent(Login.this, ParkingActivity.class);
                    startActivity(finalIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "username or password wrong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}