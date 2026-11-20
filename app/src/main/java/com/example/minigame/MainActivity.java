package com.example.minigame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private Button btnBlue, btnRed, btnResults;
    private int blueScore = 0;
    private int redScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBlue = findViewById(R.id.btnBlue);
        btnRed = findViewById(R.id.btnRed);
        btnResults = findViewById(R.id.btnResults);


        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blueScore += 1;
            }
        });


        btnRed.setOnLongClickListener(this);

        // מעבר למסך התוצאות
        btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                intent.putExtra("BLUE_SCORE", blueScore);
                intent.putExtra("RED_SCORE", redScore);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.btnRed) {
            redScore += 2;
            return true;
        }
        return false;
    }


    @Override
    protected void onResume() {
        super.onResume();
        blueScore = 0;
        redScore = 0;
    }
}