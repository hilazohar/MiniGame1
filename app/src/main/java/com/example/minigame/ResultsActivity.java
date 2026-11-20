package com.example.minigame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView tvWinner = findViewById(R.id.tvWinner);
        TextView tvBlueScore = findViewById(R.id.tvBlueScore);
        TextView tvRedScore = findViewById(R.id.tvRedScore);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        int blueScore = intent.getIntExtra("BLUE_SCORE", 0);
        int redScore = intent.getIntExtra("RED_SCORE", 0);

        tvBlueScore.setText("ניקוד שחקן כחול: " + blueScore);
        tvRedScore.setText("ניקוד שחקן אדום: " + redScore);

        if (blueScore > redScore) {
            tvWinner.setText("המנצח: כחול!");
            tvWinner.setTextColor(Color.parseColor("#1976D2"));
        } else if (redScore > blueScore) {
            tvWinner.setText("המנצח: אדום!");
            tvWinner.setTextColor(Color.parseColor("#D32F2F"));
        } else {
            tvWinner.setText("תיקו!");
            tvWinner.setTextColor(Color.parseColor("#424242"));
        }


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}