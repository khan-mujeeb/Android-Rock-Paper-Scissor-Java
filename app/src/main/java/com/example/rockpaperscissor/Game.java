package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {

    int playerScore = 0 , computerScore = 0 ;
    int computerMove , playerMove;
    TextView Player , Computer ;

    //Moves
    int rock(ImageView img) {
        img.setImageResource(R.drawable.rock);
        return 0;
    }

    int  paper(ImageView img) {
        img.setImageResource(R.drawable.paper);
        return 1;
    }

    int scissor(ImageView img) {
        img.setImageResource(R.drawable.scissor);
        return 2;
    }

    // Computer move
    int Display() {
        Random rnd = new Random();
        int n = rnd.nextInt(3);

        if(n==0) {
            return rock(Pc);
        }
        else if(n==1) {
            return paper(Pc);
        }

        else {
            return scissor(Pc);
        }
    }

    // Result
    void Result(int U , int C) {
        if( U==0 && C==1 || U==1 && C==2 || U==2 && C==0 ) {
            computerScore++;
            Computer.setText( computerScore + "");
        }
        else if( U==0 && C==2 || U==1 && C==0 || U==2 && C==1 ) {
            playerScore++;
            Player.setText( playerScore + "" );
        }
    }

    ImageView Rock , Paper , Scissor ;
    ImageView User , Pc;
    ImageView back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        // ScoreCard variable
        Player = findViewById(R.id.score1);
        Computer = findViewById(R.id.score2);

        // Indexing of Player
        User = findViewById(R.id.USER);
        Pc = findViewById(R.id.PC);

        // Move Indexing
        Rock = findViewById(R.id.ROCK);
        Paper = findViewById((R.id.PAPER));
        Scissor = findViewById(R.id.SCISSOR);

        // function to select rock by user
        Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove =  rock(User);
                computerMove =  Display();
                Result( playerMove , computerMove );
            }
        });

        // function to select paper by user
        Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove =  paper(User);
                computerMove =  Display();
                Result( playerMove , computerMove );
            }
        });

        // function to select scissor by user
        Scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerMove =  scissor(User);
                computerMove =  Display();
                Result( playerMove , computerMove );
            }
        });

        back = findViewById(R.id.BACK);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( playerScore > computerScore )
                    finalResult.result = 1;
                else if ( playerScore == computerScore )
                    finalResult.result = 0;
                else
                    finalResult.result = -1;

                finalResult.P1 = playerScore;
                finalResult.P2 = computerScore;

                Intent intent2 = new Intent(Game.this, MainActivity.class);
                startActivity(intent2);
            }
        });



    }
}