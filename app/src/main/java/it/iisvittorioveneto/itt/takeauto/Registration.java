package it.iisvittorioveneto.itt.takeauto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import com.example.takeauto.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    public static List<User> userList = new ArrayList<>();
    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +           // regex per controllo password
                    "(?=.*[0-9])" +         // almeno 1 cifra
                    "(?=.*[a-z])" +         // almeno una lettera minuscola
                    "(?=.*[A-Z])" +         // almeno una lettera maiuscola
                    "(?=.*[@#$%^&+=])" +    // almeno un carattere speciale
                    "(?=\\S+$)" +           // no spazi
                    ".{6,}" +               // almeno 6 caratteri totali
                    "$");

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

            boolean isCorrect = true;

            // controllo email
            // correttezza sintattica
            if (email.toString().isEmpty()) {
                email.setError("email field can't be empty");
                isCorrect = false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                email.setError("please enter a valid email address");
                isCorrect = false;
            }
            // disponibilità email
            for (int i = 0; i < userList.size() && isCorrect; i++) {
                if (!userList.get(i).getEmail().equals(email.getText().toString())) {
                    email.setError("email already used, please login or use another email address");
                    isCorrect = false;
                }
            }

            // controllo username
            // disponibilità username
            for (int i = 0; i < userList.size() && isCorrect; i++) {
                if (!userList.get(i).getUsername().equals(username.getText().toString())) {
                    username.setError("Username already in use");
                    isCorrect = false;
                }
            }

            // controllo password
            // password sufficientemente sicura, secondo i parametri specificati
            if (password.toString().isEmpty() && isCorrect) {
                password.setError("password field can't be empty");
                isCorrect = false;
            } else if (!PASSWORD_PATTERN.matcher(password.getText().toString()).matches()) {
                password.setError("password too weak");
                isCorrect = false;
            }
            // uguaglianza 2 password inserite
            if (password.getText().toString().equals(confirmPassword.getText().toString()) && isCorrect) {
                // creazione e aggiunta nuovo utente
                User user = new User(
                        email.getText().toString(),
                        username.getText().toString(),
                        password.getText().toString()
                );
                userList.add(user);
                // accesso all'applicazione -> schermata visualizzazione stato veicoli
                Intent finalIntent = new Intent(Registration.this, Login.class);
                startActivity(finalIntent);
            } else {
                confirmPassword.setError("the 2 inserted password don't match");
            }
        });
    }
}

