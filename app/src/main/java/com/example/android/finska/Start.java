package com.example.android.finska;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Start extends AppCompatActivity {

    ArrayList<String> teamList;
    private ArrayAdapter<String> mTeamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    protected void onResume() {
        super.onResume();


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("team_array")) {
            teamList = intent.getStringArrayListExtra("team_array");

            mTeamList =
                    new ArrayAdapter<>(
                            this,
                            R.layout.list_item_team,
                            R.id.list_item_team_textview,
                            teamList);

            ListView listViewStart = (ListView) findViewById(R.id.listview_start);

            listViewStart.setAdapter(mTeamList);

            listViewStart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    String team = mTeamList.getItem(position);
                    Intent intent = new Intent(getApplicationContext(), DetailActivity.class)
                            .putExtra(Intent.EXTRA_TEXT, team);
                    startActivity(intent);


                }
            });
        }


    }

    //sends application to select team activity when button clicked
    public void selectTeam(View view) {
        Intent intent = new Intent(this, teamSelect.class);
        Start.this.startActivity(intent);

    }
}
