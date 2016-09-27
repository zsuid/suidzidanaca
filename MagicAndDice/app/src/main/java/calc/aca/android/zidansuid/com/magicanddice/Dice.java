package calc.aca.android.zidansuid.com.magicanddice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Dice extends AppCompatActivity {


    // set the references on the layout
            Button mbutton;
    ImageView mdice;
    TextView mrollNumber;
    ImageView mdice2;
    TextView mrollNumber2;
    TextView mtotal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        mbutton = (Button) findViewById(R.id.mbutton);
        mdice = (ImageView) findViewById(R.id.mdice);
        mrollNumber = (TextView) findViewById(R.id.mrollNumber);
        mdice2 = (ImageView) findViewById(R.id.mdice2);
        mrollNumber2 = (TextView) findViewById(R.id.mrollNumber2);
        mtotal = (TextView) findViewById(R.id.mtotal);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random r = new Random();
                Random r1 = new Random();

                int rolledNumber;
                int rolledNumber2;

                rolledNumber = r.nextInt(6) + 1;
                rolledNumber2 = r1.nextInt(6) + 1;

                mrollNumber.setText("The Rolled Number Of The White Dice Is" + rolledNumber);

                mrollNumber2.setText("The Rolled Number Of The Yellow Dice Is" + rolledNumber2);

                mtotal.setText("the Total Number of The Two Dices Is" + (rolledNumber + rolledNumber2));


                if (rolledNumber == 1) {
                    mdice.setImageResource(R.drawable.dice1);

                } else if (rolledNumber == 2) {
                    mdice.setImageResource(R.drawable.dice2);


                } else if (rolledNumber == 3) {
                    mdice.setImageResource(R.drawable.dice3);


                } else if (rolledNumber == 4) {
                    mdice.setImageResource(R.drawable.dice4);

                } else if (rolledNumber == 5) {
                    mdice.setImageResource(R.drawable.dice5);

                } else if (rolledNumber == 6) {
                    mdice.setImageResource(R.drawable.dice6);

                }
                if (rolledNumber2 == 1) {
                    mdice2.setImageResource(R.drawable.a);

                } else if (rolledNumber2 == 2) {
                    mdice2.setImageResource(R.drawable.b);

                } else if (rolledNumber2 == 3) {
                    mdice2.setImageResource(R.drawable.c);

                } else if (rolledNumber2 == 4) {
                    mdice2.setImageResource(R.drawable.d);

                } else if (rolledNumber2 == 5) {
                    mdice2.setImageResource(R.drawable.e);

                } else if (rolledNumber2 == 6) {
                    mdice2.setImageResource(R.drawable.f);

                }

            }
        });


    }
}