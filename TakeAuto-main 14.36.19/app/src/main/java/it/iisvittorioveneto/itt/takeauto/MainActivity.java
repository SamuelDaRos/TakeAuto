package it.iisvittorioveneto.itt.takeauto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.takeauto.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //static List<User> userList = new ArrayList<User>();

    /*public static List<User> getList() {
        return userList;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Button1 = this.findViewById(R.id.login);
        Button1.setOnClickListener(v -> {
            Intent intentLogin = new Intent(MainActivity.this, Login.class);
            startActivity(intentLogin);
        });

        Button Button2 = this.findViewById(R.id.registration);
        Button2.setOnClickListener(v2 -> {
            Intent registrationIntent = new Intent(MainActivity.this, Registration.class);
            startActivity(registrationIntent);
        });
    }
}