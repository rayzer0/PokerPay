package com.arcotek.pokerpay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;

import java.math.BigDecimal;
import java.util.ArrayList;


public class MainScreen extends Activity {
    ArrayList<Player> playerList = new ArrayList<>(); //todo find a more elegant solution than declaring playerList outside of oncreate

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button gotoAddPlayer = (Button) findViewById(R.id.goto_add_player);
        ListView listOfPlayers = (ListView) findViewById(R.id.list_of_players);

        Bundle extras = getIntent().getExtras(); //checks to make sure there are extras before trying to overwrite playerList with the one from the intent
        if (extras != null) {
            playerList = getIntent().getParcelableArrayListExtra("player_list");;
        }

        ArrayAdapter<Player> adapter = new ArrayAdapter<Player>(this, R.layout.player_in_list, playerList); //TODO: not showing tostring
        listOfPlayers.setAdapter(adapter);

        gotoAddPlayer.setOnClickListener(new View.OnClickListener() { //goto AddPlayer Activity
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddPlayer.class);
                intent.putParcelableArrayListExtra("player_list", playerList);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
