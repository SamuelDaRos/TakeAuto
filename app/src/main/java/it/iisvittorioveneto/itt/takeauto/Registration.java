package it.iisvittorioveneto.itt.takeauto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.takeauto.R;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Registration extends AppCompatActivity {
    public static List<User> userList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonConfirm.setOnClickListener(v -> {
            EditText email = findViewById(R.id.emailAddress);
            EditText username = findViewById(R.id.usernameLogin);
            EditText password = findViewById(R.id.passwordRegistration);
            EditText confirmPassword = findViewById(R.id.passwordRegistrationConfirm);

            boolean condizione1=true;

            // controllo username
            for (int i = 0; i < userList.size(); i++) {
                if (!userList.get(i).getUsername().equals(username.getText().toString())) {
                    Toast.makeText(this, "The username you entered is already in use", Toast.LENGTH_LONG).show();
                    condizione1=false;
                }
            }
            //controllo email

            for (int i = 0; i < userList.size(); i++) {
                if (!userList.get(i).getEmail().equals(email.getText().toString())) {
                    Toast.makeText(this, "The email you entered is already in use, please do login", Toast.LENGTH_LONG).show();
                    condizione1=false;
                }
            }

            // controllo 2 password inserite che siano uguali
            if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                User user = new User(
                        email.getText().toString(),
                        username.getText().toString(),
                        password.getText().toString()
                );
                if(condizione1==true) {
                    userList.add(user);
                    Intent finalIntent = new Intent(Registration.this, Login.class);
                    startActivity(finalIntent);
                }
                } else {
                Toast.makeText(this, "the 2 inserted password don't match", Toast.LENGTH_LONG).show();
            }
        });
    }
}

