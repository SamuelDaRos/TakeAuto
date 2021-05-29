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

            boolean isCorrect;

            // controllo correttezza sintattica email
            isCorrect = checkEmail(email.getText().toString());
            if (!isCorrect) {
                email.setError("please enter a valid email address");
            }
            // controllo disponibilità email
            isCorrect = isEmailAvailable(email.getText().toString());
            if (!isCorrect) {
                email.setError("email already used, please login or use another email address");
            }
            // controllo disponibilità username (che deve essere lungo più di 3 caratteri)
            if (username.getText().toString().length() < 3) {
                isCorrect = isUserAvailable(username.getText().toString());
                if (!isCorrect) {
                    username.setError("Username already in use");
                }
            } else {
                username.setError("please enter a valid username");
            }
            // controllo password sufficientemente sicura, secondo i parametri specificati
            isCorrect = checkPassword(password.getText().toString());
            if (!isCorrect) {
                password.setError("password too weak");
            }
            // controllo uguaglianza 2 password inserite
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

    public boolean checkEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isEmailAvailable(String email) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean isUserAvailable(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}