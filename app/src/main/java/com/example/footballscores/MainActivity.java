package com.example.footballscores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    /**
     * display score for A
     */
    public void displayForA(int score){
        TextView goal4A = findViewById(R.id.goalA);

        goal4A.setText(String.valueOf(score));
    }

    /**
     *display score for B
     */

    public void displayForB(int score){
        TextView goal4B = findViewById(R.id.goalB);

        goal4B.setText(String.valueOf(score));
    }

    /**
     * these methods increases the score
     */
    int goalA = 0;
    public void goalForA(View view){
        goalA +=1;
        displayForA(goalA);
    }

    int goalB = 0;
    public void goalForB(View view){
        goalB +=1;
        displayForB(goalB);
    }

    /**
     * these functions display the number  of fouls that occurred during the game
     */

    int foulA = 0;
    int foulB = 0;

    //foul for A

    public void displayFoulA(int foul){
        TextView foul4A = findViewById(R.id.foul_A);

        foul4A.setText(String.valueOf(foul));
    }

    public void displayFoulB(int foul){
        TextView foul4B = findViewById(R.id.foul_B);
        foul4B.setText(String.valueOf(foul));
    }

    /**
     * these functions increases the foul occurrence
     */
    public void foulForA(View view){
        foulA += 1;
        displayFoulA(foulA);
    }

    public void foulForB(View view){
        foulB += 1;
        displayFoulB(foulB);
    }

    /**
     * these functions displays penalties played whether scored or missed
     */

    /*
     * Scored*/

    public void displaySPenaltySForA(int score){
        TextView penalty4A = findViewById(R.id.penalty_A);
        penalty4A.setText(String.valueOf(score));
    }

    public void displaySPenaltySForB(int score){
        TextView penalty4B = findViewById(R.id.penalty_B);
        penalty4B.setText(String.valueOf(score));
    }

    public void displayMPenaltySForA(int score){
        TextView penalty4MA = findViewById(R.id.penalty_MA);
        penalty4MA.setText(String.valueOf(score));
    }

    public void displayMPenaltySForB(int score){
        TextView penalty4MB = findViewById(R.id.penalty_MB);
        penalty4MB.setText(String.valueOf(score));
    }
    /**
     * these functions increases the penalty scored or missed
     */

    int penaltyScoredA = 0;
    int penaltyMissedA = 0;

    int penaltyScoredB = 0;
    int penaltyMissedB = 0;

    public void penaltyScoredForA(View view){
        penaltyScoredA +=1;
        goalA +=1;
        displayForA(goalA);
        displaySPenaltySForA(penaltyScoredA);

    }

    public void penaltyMissedForA(View view){
        penaltyMissedA +=1;
        displayMPenaltySForA(penaltyMissedA);

    }
    public void penaltyScoredForB(View view){
        penaltyScoredB +=1;
        goalB +=1;
        displayForB(goalB);
        displaySPenaltySForB(penaltyScoredB);
    }

    public void penaltyMissedForB(View view){
        penaltyMissedB += 1;
        displayMPenaltySForB(penaltyMissedB);


    }


    public void reset(View view){
        goalA = 0;
        goalB = 0;
        foulA = 0;
        foulB = 0;
        penaltyMissedB = 0;
        penaltyScoredA = 0;
        penaltyMissedA = 0;
        penaltyScoredB =0;
        displayForA(goalA);
        displayForB(goalB);
        displayFoulA(foulA);
        displayFoulB(foulB);
        displaySPenaltySForA(penaltyScoredA);
        displayMPenaltySForA(penaltyMissedA);
        displayMPenaltySForB(penaltyMissedB);
        displaySPenaltySForB(penaltyScoredB);


    }
    public void GetSummary(View view ){

        TextView foul4B = findViewById(R.id.foul_B);
        TextView foul4A = findViewById(R.id.foul_A);
        TextView penalty4A = findViewById(R.id.penalty_A);
        TextView penalty4B = findViewById(R.id.penalty_B);
        TextView penalty4MA = findViewById(R.id.penalty_MA);
        TextView penalty4MB = findViewById(R.id.penalty_MB);
        TextView goal4B = findViewById(R.id.goalB);
        TextView goal4A = findViewById(R.id.goalA);

        int foulA = Integer.parseInt(foul4A.getText().toString());
        int foulB = Integer.parseInt(foul4B.getText().toString());
        int penaltySA = Integer.parseInt(penalty4A.getText().toString());
        int penaltySB = Integer.parseInt(penalty4B.getText().toString());
        int penaltyMA = Integer.parseInt(penalty4MA.getText().toString());
        int penaltyMB = Integer.parseInt(penalty4MB.getText().toString());
        int goalA = Integer.parseInt(goal4A.getText().toString());
        int goalB = Integer.parseInt(goal4B.getText().toString());

        Intent intent = new Intent(MainActivity.this, Summary.class);
        intent.putExtra("foul4A",foulA);
        intent.putExtra("foul4B",foulB);
        intent.putExtra("penalty4A",penaltySA);
        intent.putExtra("penalty4B",penaltySB);
        intent.putExtra("penalty4MA",penaltyMA);
        intent.putExtra("penalty4MB",penaltyMB);
        intent.putExtra("goal4A",goalA);
        intent.putExtra("goal4B",goalB);
        intent.putExtra("totalp",penaltyMA+penaltySA);
        intent.putExtra("totalpB",penaltyMB+penaltySB);


        startActivity(intent);



    }

}
