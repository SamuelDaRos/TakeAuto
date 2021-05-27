package it.iisvittorioveneto.itt.takeauto;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.takeauto.R;

public class ParkingActivity extends AppCompatActivity {
    public static final int MAX_CAR = 4;
    public Car[] cars = new Car[MAX_CAR];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        View[] carsView = new View[MAX_CAR];
        carsView[0] = findViewById(R.id.car1);
        carsView[1] = findViewById(R.id.car2);
        carsView[2] = findViewById(R.id.car3);
        carsView[3] = findViewById(R.id.car4);

        ImageView[] carsImg = new ImageView[MAX_CAR];
        carsImg[0] = findViewById(R.id.imgCar1);
        carsImg[1] = findViewById(R.id.imgCar2);
        carsImg[2] = findViewById(R.id.imgCar3);
        carsImg[3] = findViewById(R.id.imgCar4);

        TextView[] carsState = new TextView[MAX_CAR];
        carsState[0] = findViewById(R.id.car1State);
        carsState[1] = findViewById(R.id.car2State);
        carsState[2] = findViewById(R.id.car3State);
        carsState[3] = findViewById(R.id.car4State);

        for (int i = 0; i < MAX_CAR; i++) {
            carsView[i].setBackgroundColor(getResources().getColor(R.color.green));
        }

        // creazione delle automobili (hardcoded) TODO sviluppi futuri: aggiungere activity per l'inserimento di nuove automobili da parte di un admin
        cars[0] = new Car("Fiat", "Panda 4x4 1000 Sysley", "Benzina");
        cars[1] = new Car("Lancia", "Delta integrale", "benzina");
        cars[2] = new Car("Porche", "911 GT3", "benzina");
        cars[3] = new Car("BMW", "Serie 4 Gran Coupé", "benzina");

        for (int i = 0; i < MAX_CAR; i++) {
            carsState[i].setText(cars[i].toString());
        }
    }

    // metodo che viene eseguito al click di ogni immagine: permette di prenotare l'auto associata all'immagine
    public void onCarImageClick(View view) {
        if (view.getId() == R.id.imgCar1) {
            // TODO chiamate a dialogue
        } else if (view.getId() == R.id.imgCar2) {

        } else if (view.getId() == R.id.imgCar3) {

        } else if (view.getId() == R.id.imgCar4) {

        }
    }
}