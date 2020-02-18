package com.example.footballscores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class Summary extends AppCompatActivity {

    int foul4A, foul4B, penalty4A, penalty4B, penalty4MA,
    penalty4MB,goal4A,goal4B;
    int totalpA, totalpB;

    TextView SummaryA, SummaryB, Winner;
    Button Share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent summaryIntent = getIntent();

        foul4A = summaryIntent.getIntExtra("foul4A",0);
        foul4B = summaryIntent.getIntExtra("foul4B",0);
        penalty4A = summaryIntent.getIntExtra("penalty4A",0);
        penalty4B = summaryIntent.getIntExtra("penalty4B",0);
        penalty4MA = summaryIntent.getIntExtra("penalty4MA",0);
        penalty4MB = summaryIntent.getIntExtra("penalty4MB",0);
        goal4A = summaryIntent.getIntExtra("goal4A",0);
        goal4B = summaryIntent.getIntExtra("goal4B",0);
         totalpA = summaryIntent.getIntExtra("totalp",0);
         totalpB = summaryIntent.getIntExtra("totalpB",0);

         SummaryA =findViewById(R.id.SummaryA);
         SummaryA.setText(summary1("Team A",foul4A, totalpA, penalty4A,penalty4MA,goal4A));


        SummaryB =findViewById(R.id.SummaryB);
        SummaryB.setText(summary1("Team B",foul4B,totalpB, penalty4B,penalty4MB,goal4B));

        Winner = findViewById(R.id.winner);

        if(goal4B < goal4A){
            Winner.setText("Team A");
        }else if (goal4A == goal4B) {
            Winner.setText("No Winner");
        } else {
            Winner.setText("Team B");
        }


        Share = findViewById(R.id.share);

        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.the_match_summary) );
                intent.putExtra(Intent.EXTRA_TEXT,Summary());
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });




    }

    public String summary1(String Team, int foul, int penalty, int penaltyScored, int penaltymissed, int total_GOALS){



        String matchSummary = Team + " had "+foul+" Fouls and "+ penalty +" Penalties.\n"+
                Team+" Scored "+ penaltyScored+" out of "+ penalty +" Penalties and missed "+ penaltymissed +" out of "+ penalty +" Penalties\n"+
                "The Total goals for "+Team+" is "+ total_GOALS;

        return matchSummary;

    }

    private String Summary(){
       String summary = String.format("At the End Of The Match \n" + SummaryA.getText() + "\n" + SummaryB.getText() + "\n"
               + " And The Winner Was " + Winner.getText());

       return summary;
    }
}
