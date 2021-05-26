package it.iisvittorioveneto.itt.takeauto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.takeauto.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    public static List<User> userList = new ArrayList<>();
    public static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +           // regex per controllo password
                    "(?=.*[0-9])" +         // almeno 1 cifra
                    "(?=.*[a-z])" +         // almeno una cifra minuscola
                    "(?=.*[A-Z])" +         // almeno una cifra maiuscola
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
            if (email.toString().isEmpty()) {
                Toast.makeText(this, "email field can't be empty", Toast.LENGTH_LONG).show();
                isCorrect = false;
                //email.setError("email field can't be empty"); //TODO sarebbe da aggiungere questo per farlo meglio (se funziona.. provare)
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches()) {
                Toast.makeText(this, "please enter a vald email address", Toast.LENGTH_LONG).show();
                isCorrect = false;
            }

            for (int i = 0; i < userList.size() && isCorrect; i++) {
                if (!userList.get(i).getEmail().equals(email.getText().toString())) {
                    Toast.makeText(this, "The email you entered is already in use, please do login", Toast.LENGTH_LONG).show();
                    isCorrect = false;
                }
            }

            // controllo username
            for (int i = 0; i < userList.size() && isCorrect; i++) {
                if (!userList.get(i).getUsername().equals(username.getText().toString())) {
                    Toast.makeText(this, "The username you entered is already in use", Toast.LENGTH_LONG).show();
                    isCorrect = false;
                }
            }

            // controllo password
            if (password.toString().isEmpty() && isCorrect) {
                Toast.makeText(this, "password field can't be empty", Toast.LENGTH_LONG).show();
                isCorrect = false;
            } else if (!PASSWORD_PATTERN.matcher(password.toString()).matches()) {
                Toast.makeText(this, "password too weak", Toast.LENGTH_LONG).show();
                isCorrect = false;
            }

            if (password.getText().toString().equals(confirmPassword.getText().toString()) && isCorrect) {
                User user = new User(
                        email.getText().toString(),
                        username.getText().toString(),
                        password.getText().toString()
                );
                userList.add(user);
                Intent finalIntent = new Intent(Registration.this, Login.class);
                startActivity(finalIntent);
            } else {
                Toast.makeText(this, "the 2 inserted password don't match", Toast.LENGTH_LONG).show();
            }
        });
    }
}

