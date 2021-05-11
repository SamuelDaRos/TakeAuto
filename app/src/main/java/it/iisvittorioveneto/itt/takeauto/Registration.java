package it.iisvittorioveneto.itt.takeauto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.takeauto.R;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Intent intent = this.getIntent();
        Button button= findViewById(R.id.buttonConfirm);
        button.setOnClickListener(v -> {
            EditText email= findViewById(R.id.EmailAddress);
            EditText username= findViewById(R.id.username);
            EditText password= findViewById(R.id.passwordRegistration);
            EditText password2= findViewById(R.id.passwordRegistrationConfirm);
            EditText dateOfBirth= findViewById(R.id.dateOfBirth);
            EditText phoneNumber= findViewById(R.id.Phone);
            EditText identityCard= findViewById(R.id.fiscalCode);

            // TODO
            // controllo se le 2 password corrispondono
            // esito posivito -> passo alla prossima activity e salva l'utente nel database
            // esito negativo -> appare un toast
            // IMPORTANTE: bisogna controllare anche se l'utente non sia già registrato
            // controllo se esiste nel database solo la mail o codice fiscale)

            Intent finalIntent = new Intent(Registration.this, Final_Activity.class);
            startActivity(finalIntent);
        });
    }
}