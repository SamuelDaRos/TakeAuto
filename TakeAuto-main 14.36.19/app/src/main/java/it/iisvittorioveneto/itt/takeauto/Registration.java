package it.iisvittorioveneto.itt.takeauto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.takeauto.R;

import java.time.LocalDate;

public class Registration extends AppCompatActivity {
    public static Lista lUser = new Lista();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Intent intent = this.getIntent();
        Button button = findViewById(R.id.buttonConfirm);
        button.setOnClickListener(v -> {
            EditText email = findViewById(R.id.emailAddress);
            EditText username = findViewById(R.id.usernameRegistration);
            EditText password = findViewById(R.id.passwordRegistration);
            EditText confirmPassword = findViewById(R.id.passwordRegistrationConfirm);
            EditText dateOfBirth = findViewById(R.id.dateOfBirth);
            EditText phoneNumber = findViewById(R.id.phone);
            EditText fiscalCode = findViewById(R.id.fiscalCode);
            addData();
            boolean nuovo=true;
            int i=0;
            while(i<lUser.getNumElementi()){
                if(lUser.getElemento(i).getUsername().equals(username.getText().toString())){
                    i=lUser.getNumElementi()+1;
                    nuovo=false;
                    Toast.makeText(this, "The username you entered is already in use", Toast.LENGTH_LONG).show();

                }
            }

            if (password.getText().toString().equals(confirmPassword.getText().toString()) && nuovo==true) {
                User user = new User(
                        email.getText().toString(),
                        username.getText().toString(),
                        password.getText().toString(),
                        LocalDate.parse(dateOfBirth.getText()),
                        phoneNumber.getText().toString(),
                        fiscalCode.getText().toString()
                );
                //MainActivity.userList.add(user);
                lUser.inNodoCoda(new Nodo(user));
                Intent finalIntent = new Intent(Registration.this, Login.class);
                startActivity(finalIntent);
            } else {
                Toast.makeText(this, "the 2 inserted password don't match", Toast.LENGTH_LONG).show();
            }


        });
    }

        /*public void addData () {
            Button button = findViewById(R.id.buttonConfirm);
            button.setOnClickListener(v -> {
                EditText email = findViewById(R.id.emailAddress);
                EditText username = findViewById(R.id.usernameRegistration);
                EditText password = findViewById(R.id.passwordRegistration);
                boolean isInserted = myDB.insertDeta(username.getText().toString(), email.getText().toString(), password.getText().toString());
                if (isInserted) {
                    Toast.makeText(Registration.this, "Data Inserted", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(Registration.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }
            );
        }*/
    public void addData(){
        Button button = findViewById(R.id.buttonConfirm);

    }
}

