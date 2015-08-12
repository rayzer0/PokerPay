package com.arcotek.pokerpay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;


public class MainScreen extends Activity {
    static ArrayList<Player> playerList = new ArrayList<>(); //todo find a more elegant solution than declaring playerList outside of oncreate
    static int playerPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button gotoAddPlayer = (Button) findViewById(R.id.goto_add_player);
        ListView listOfPlayers = (ListView) findViewById(R.id.list_of_players);
        Intent intent = getIntent();

        if (intent.hasExtra("player_list") == true) { //if returning from AddPlayer
            playerList = getIntent().getParcelableArrayListExtra("player_list");;
        }
        if (intent.hasExtra("more_money") == true) { //if returning from EditPlayer
            Player editPlayer = playerList.get(playerPosition);
            BigDecimal moreMoney = new BigDecimal(intent.getStringExtra("more_money"));
            editPlayer.setMoney(editPlayer.getMoney().add(moreMoney));
            playerList.set(playerPosition, editPlayer);
        }

        ArrayAdapter<Player> adapter = new ArrayAdapter<Player>(this, R.layout.player_in_list, playerList); //displays playerList
        listOfPlayers.setAdapter(adapter);

        listOfPlayers.setOnItemClickListener(new AdapterView.OnItemClickListener() { //TODO: goto corresponding EditPlayer activity
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,long id) {  //edit player
                playerPosition = position;

                String item = ((TextView)v).getText().toString();
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(v.getContext(), EditPlayer.class);
                intent.putExtra("player", playerList.get(position));
                startActivity(intent);
            }
        });

        gotoAddPlayer.setOnClickListener(new View.OnClickListener() { //goto AddPlayer Activity
            public void onClick(View v) { //add player
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
