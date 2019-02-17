package com.example.cargo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        double Andrew_fare = 0.00;
        double Jenny_fare = 0.00;
        double Zain_fare = 0.00;

        try {
            /// This is for the backend ///

            // setting the_trip
            Trip the_trip = ((makeglobaltrip) this.getApplication()).getSomeVariable();
            // setting the_trip

            Andrew_fare = the_trip.dropOff("Andrew");
            Jenny_fare = the_trip.dropOff("Jenny");
            Zain_fare = the_trip.dropOff("Zain");

            /// This is for the backend ///
        }
        catch(Exception e) {}

        finally {

            Andrew_fare = 0.00;
            Jenny_fare = 0.00;
            Zain_fare = 0.00;

        }


        TextView t = (TextView) findViewById(R.id.testView10);
        t.setText("" + Andrew_fare);

        TextView t = (TextView) findViewById(R.id.textView13);
        t.setText("" + Jenny_fare);

        TextView t = (TextView) findViewById(R.id.textView14);
        t.setText("" + Zain_fare);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Button end = findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStart();
            }
        });
    }

    private void goToStart() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
