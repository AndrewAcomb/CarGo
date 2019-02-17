package com.example.cargo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Setup extends AppCompatActivity {

    private int numtest = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        Button plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addone();
            }
        });

        Button minus = findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusone();
            }
        });

        Button okbutton = findViewById(R.id.okbutton);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNameSetup();
            }
        });

       Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBacktoMain();
            }
        });

    }

    public void addone(){
        numtest+=1;
        TextView t = (TextView) findViewById(R.id.numRiders);
        t.setText("" + numtest);
    }

    public void minusone(){
        numtest-=1;
        TextView t = (TextView) findViewById(R.id.numRiders);
        t.setText("" + numtest);
    }

    private void goToNameSetup() {
        Intent intent = new Intent(this, namesetup.class);
        startActivity(intent);
    }

    private void goBacktoMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
