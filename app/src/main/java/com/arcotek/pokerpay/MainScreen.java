package com.arcotek.pokerpay;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainScreen extends ActionBarActivity {
    int playerCount = 0; //no current players yet

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button submitPlayers = (Button) findViewById(R.id.submit);
        final EditText addPlayer = (EditText) findViewById(R.id.new_player);
        final TextView listPlayers = (TextView) findViewById(R.id.text);
        final ArrayList<Player> playerList = new ArrayList<>();

        submitPlayers.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Player newPlayer = new Player(addPlayer.getText().toString());
                playerList.add(newPlayer);
                if (playerList.size()==1) {
                    listPlayers.setText(playerList.get(playerList.size()-1).getName());
                }
                else {
                    listPlayers.append("\n"+playerList.get(playerList.size()-1).getName());
                }
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
