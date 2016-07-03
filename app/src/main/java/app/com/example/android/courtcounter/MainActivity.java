package app.com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String VAR_TEAM_A_SCORE = "team_a_score";
    static final String VAR_TEAM_B_SCORE = "team_b_score";

    private int team_a_score = 0;
    private int team_b_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add3PointsToTeamA(View view) {
        team_a_score += 3;
        displayScoreForTeamA(team_a_score);
    }

    public void add2PointsToTeamA(View view) {
        team_a_score += 2;
        displayScoreForTeamA(team_a_score);
    }

    public void addFreeThrowPointToTeamA(View view) {
        team_a_score += 1;
        displayScoreForTeamA(team_a_score);
    }

    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void add3PointsToTeamB(View view) {
        team_b_score += 3;
        displayScoreForTeamB(team_b_score);
    }

    public void add2PointsToTeamB(View view) {
        team_b_score += 2;
        displayScoreForTeamB(team_b_score);
    }

    public void addFreeThrowPointToTeamB(View view) {
        team_b_score += 1;
        displayScoreForTeamB(team_b_score);
    }

    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset(View view) {
        team_a_score = 0;
        team_b_score = 0;
        displayScoreForTeamA(team_a_score);
        displayScoreForTeamB(team_b_score);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the current game state
        savedInstanceState.putInt(VAR_TEAM_A_SCORE, team_a_score);
        savedInstanceState.putInt(VAR_TEAM_B_SCORE, team_b_score);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        team_a_score = savedInstanceState.getInt(VAR_TEAM_A_SCORE);
        team_b_score = savedInstanceState.getInt(VAR_TEAM_B_SCORE);
        displayScoreForTeamA(team_a_score);
        displayScoreForTeamB(team_b_score);
    }


}
