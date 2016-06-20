package com.example.android.finska;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        if (intent != null){
            int teamNo = intent.getIntExtra("team_number", 1);
            String teamPOne = intent.getStringExtra("team_player_one");
            String teamPTwo = intent.getStringExtra("team_player_two");
            int teamScore = intent.getIntExtra("team_score", 0);

            ((TextView) findViewById(R.id.detail_team_number)).setText(getString(R.string.team_label) + String.valueOf(teamNo));
            ((TextView) findViewById(R.id.detail_team_player_one)).setText(teamPOne);
            ((TextView) findViewById(R.id.detail_team_player_two)).setText(teamPTwo);
            ((TextView) findViewById(R.id.detail_team_score)).setText(String.valueOf(teamScore));

        }
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

