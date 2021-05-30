package it.iisvittorioveneto.itt.takeauto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.takeauto.R;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        EditText startDate1 = findViewById(R.id.editTextStartDate);
        EditText finishDate1 = findViewById(R.id.editTextFinishDate);
        Button button = findViewById(R.id.buttonAddData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate=startDate1.getText().toString();
                String finishDate=finishDate1.getText().toString();
                Intent intent = new Intent(BookingActivity.this, ParkingActivity.class);
                intent.putExtra("startDate", startDate);
                intent.putExtra("finishDate", finishDate);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}