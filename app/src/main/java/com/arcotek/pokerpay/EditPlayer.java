package com.arcotek.pokerpay;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;


public class EditPlayer extends ActionBarActivity implements View.OnClickListener {
    Button addBuyin;
    Button addCashOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);

        TextView playerName = (TextView) findViewById(R.id.player_name);
        Button addBuyIn = (Button) findViewById(R.id.add_buy_in);
        Button addCashOut = (Button) findViewById(R.id.add_cash_out);

        Player player = getIntent().getParcelableExtra("player");
        playerName.setText(player.getName());

        addBuyIn.setOnClickListener(this);
        addCashOut.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        final EditText moreMoney = (EditText) findViewById(R.id.more_money);

        BigDecimal moreMoneyAmount = new BigDecimal(moreMoney.getText().toString());
        if (v.getId()==R.id.add_buy_in) { //if buy in button clicked, make the money negative
            moreMoneyAmount.negate();
        }

        Intent intent = new Intent(v.getContext(), MainScreen.class);
        intent.putExtra("more_money", moreMoneyAmount); //TODO cannot send intent with BigDecimal
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_player, menu);
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
