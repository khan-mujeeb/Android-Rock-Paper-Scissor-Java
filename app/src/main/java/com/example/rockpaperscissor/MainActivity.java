package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.play);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this ,Game.class );
                startActivity(intent);
            }
        });

        TextView Player = findViewById(R.id.playerScore);
        TextView Computer = findViewById(R.id.computerScore);

//        Player.setText(finalResult.P1);
//        Computer.setText(finalResult.P2);
        TextView Status = findViewById(R.id.status);

        if(finalResult.result == 1)
            Status.setText("YOU WON");
        else if(finalResult.result == -1)
            Status.setText("YOU LOST");
        else if(finalResult.result == 0)
            Status.setText("GAME TIE");
    }
}