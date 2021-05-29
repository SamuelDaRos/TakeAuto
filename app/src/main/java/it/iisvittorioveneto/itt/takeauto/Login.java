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
            EditText usern= findViewById(R.id.usernameLogin);
            EditText psw= findViewById(R.id.passwordLogin);
            String username=usern.getText().toString();
            String password=psw.getText().toString();

            if(UserExist(username, password)){
                Intent finalIntent = new Intent(Login.this, ParkingActivity.class);
                startActivity(finalIntent);
            }else{
                Toast.makeText(getApplicationContext(), "username or password wrong", Toast.LENGTH_LONG).show();
            }

        });
    }

    public boolean UserExist(String username, String password){
        boolean exist=true;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username) && userList.get(i).getPassword().equals(password)){
                exist=true;
            } else {
                exist=false;
            }
        }
        return exist;
    }
}