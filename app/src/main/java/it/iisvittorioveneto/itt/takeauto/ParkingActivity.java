package it.iisvittorioveneto.itt.takeauto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.takeauto.R;

public class ParkingActivity extends AppCompatActivity {
    public static final int MAX_CAR = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        View[] cars = new View[MAX_CAR];
        cars[0] = findViewById(R.id.car1);
        cars[1] = findViewById(R.id.car2);
        cars[2] = findViewById(R.id.car3);
        cars[3] = findViewById(R.id.car4);

        for (int i = 0; i < MAX_CAR; i++) {
            cars[i].setBackgroundColor(getResources().getColor(R.color.green));
        }
    }
}