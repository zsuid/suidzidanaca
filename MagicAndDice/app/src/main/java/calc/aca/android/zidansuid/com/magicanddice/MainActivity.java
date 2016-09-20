package calc.aca.android.zidansuid.com.magicanddice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnMagic).setOnClickListener(new handleButton());
        findViewById(R.id.btnDice).setOnClickListener(new handleButton());

    }

    class handleButton implements View.OnClickListener {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnDice:
                    Intent diceIntent = new Intent(MainActivity.this, Dice.class);
                    startActivity(diceIntent);
                    break;

                case R.id.btnMagic:
                    Intent magicIntent = new Intent(MainActivity.this, MagicEight.class);
                    startActivity(magicIntent);
                    break;
            }
        }
    }
}