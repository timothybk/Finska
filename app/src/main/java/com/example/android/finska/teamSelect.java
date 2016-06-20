package com.example.android.finska;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class teamSelect extends AppCompatActivity {

    ArrayList teams = new ArrayList();
    ArrayList<String> namesArray = new ArrayList<>();
    ListView listViewSelect;
    int teamNumber = 1;
    private ArrayAdapter<String> mSummaryTeams;

    public teamSelect() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);

        listViewSelect = (ListView) findViewById(
                R.id.listview_teamselect);


        listViewSelect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Team teamCL = (Team) teams.get(position);
                int teamNo = teamCL.getTeamNumber();
                String teamPOne = teamCL.getPlayerOne();
                String teamPTwo = teamCL.getPlayerTwo();
                int teamScore = teamCL.getScore();
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class)
                        .putExtra("team_number", teamNo)
                        .putExtra("team_player_one", teamPOne)
                        .putExtra("team_player_two", teamPTwo)
                        .putExtra("team_score", teamScore);
                startActivity(intent);


            }
        });
    }

    public void teamAccept(View view) {

        EditText playerOneEdit = (EditText) findViewById(R.id.player_name_one);
        String playerOne = playerOneEdit.getText().toString();

        EditText playerTwoEdit = (EditText) findViewById(R.id.player_name_two);
        String playerTwo = playerTwoEdit.getText().toString();

        Team team = new Team();

        team.setPlayers(playerOne, playerTwo);
        team.setTeamNumber(teamNumber);

        teams.add(team);
//        names.add("TEAM " + teamNumber +
//                    "\n" + playerOne +
//                    "\n" + playerTwo);
        String names = team.makeString();

        namesArray.add(names);

        teamNumber += 1;

        mSummaryTeams =
                new ArrayAdapter<>(
                        this,
                        R.layout.list_item_team,
                        R.id.list_item_team_textview,
                        namesArray);

        listViewSelect.setAdapter(mSummaryTeams);




    }

    public void finishTeamSelection(View view) {
        Intent intent = new Intent(this, Start.class);
        intent.putStringArrayListExtra("team_array", namesArray);
        teamSelect.this.startActivity(intent);
    }




}

