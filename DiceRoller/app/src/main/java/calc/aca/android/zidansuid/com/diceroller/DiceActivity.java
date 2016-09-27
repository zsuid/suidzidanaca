package calc.aca.android.zidansuid.com.diceroller;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {
    // set the references on the layout
    Button mbutton;
    ImageView mdice;
    TextView mrollNumber;
    ImageView mdice2;
    TextView mrollNumber2;
    TextView mtotal;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;


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

                mrollNumber.setText("The Rolled Number Of The White Dice Is" +rolledNumber);

                mrollNumber2.setText("The Rolled Number Of The Red Dice Is"+rolledNumber2);

                mtotal.setText("the Total Number of The Two Dices Is" + (rolledNumber + rolledNumber2));


                if (rolledNumber == 1 ) {
                    mdice.setImageResource(R.drawable.dice1);

                }else if (rolledNumber==2 ) {
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
                    if (rolledNumber2== 1) {
                        mdice2.setImageResource(R.drawable.a);

                    }else if (rolledNumber2 == 2) {
                        mdice2.setImageResource(R.drawable.b);

                    } else if ( rolledNumber2==3) {
                        mdice2.setImageResource(R.drawable.c);

                    } else if (rolledNumber2==4) {
                        mdice2.setImageResource(R.drawable.d);

                    } else if (rolledNumber2==5) {
                        mdice2.setImageResource(R.drawable.e);

                    } else if (rolledNumber2==6) {
                         mdice2.setImageResource(R.drawable.f);

                    }

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Dice Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://calc.aca.android.zidansuid.com.diceroller/http/host/path")
        );
        AppIndex.AppIndexApi.start(mClient, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Dice Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://calc.aca.android.zidansuid.com.diceroller/http/host/path")
        );
        AppIndex.AppIndexApi.end(mClient, viewAction);
        mClient.disconnect();
    }
}
