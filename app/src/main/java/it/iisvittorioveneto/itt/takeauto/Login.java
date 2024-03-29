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

    User actualUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = this.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(v3 -> {
            EditText user = findViewById(R.id.usernameLogin);
            EditText psw = findViewById(R.id.passwordLogin);
            String username = user.getText().toString();
            String password = psw.getText().toString();

            if (userExist(username, password)) {
                Intent parkingIntent = new Intent(Login.this, ParkingActivity.class);
                startActivity(parkingIntent);
            } else {
                Toast.makeText(getApplicationContext(), "username or password wrong", Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean userExist(String username, String password) {
        for (int i = 0; i < userList.size(); i++) {
            if (!(userList.get(i).getUsername().equals(username) && userList.get(i).getPassword().equals(password))) {
                return false;
            }
        }
        return true;
    }

    public User getActualUser() {
        return this.actualUser;
    }
}