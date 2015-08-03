package com.arcotek.pokerpay;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;


public class AddPlayer extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        Button submitPlayer = (Button) findViewById(R.id.new_player_btn);
        final EditText playerName = (EditText) findViewById(R.id.player_name_field);
        final EditText buyInText = (EditText) findViewById(R.id.buy_in_field);

        final ArrayList<Player> playerList = getIntent().getParcelableArrayListExtra("player_list"); //gets current player list (to add to)

        submitPlayer.setOnClickListener(new View.OnClickListener() { //add new player with defined name+money owed pulled from edittexts
            public void onClick(View v) { //adds player with info listed in field on submit
                BigDecimal buyInAmount = new BigDecimal(buyInText.getText().toString());
                Player newPlayer = new Player(playerName.getText().toString(), buyInAmount);
                playerList.add(newPlayer);

                Intent intent = new Intent(v.getContext(), MainScreen.class);
                intent.putParcelableArrayListExtra("player_list", playerList);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_player, menu);
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
