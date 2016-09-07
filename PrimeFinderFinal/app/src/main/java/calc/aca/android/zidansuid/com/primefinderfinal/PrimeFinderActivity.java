package calc.aca.android.zidansuid.com.primefinderfinal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrimeFinderActivity extends AppCompatActivity {

    // this is the input box control where the number will be entered
    // by the user.  I wil initialize it in the onCreate method and
    // access it in the application
    private TextView numberInputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_finder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        numberInputView = (TextView) findViewById(R.id.inputNumber);

        // find our button and initialize our variable
        Button myButton  = (Button) findViewById(R.id.button);
        // add the on click listener to our button
        myButton.setOnClickListener(buttonListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prime_finder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick(View v) {
            String answer = "Yes! Its Prime";
            // get the entered string value from the numberInputView
            String numString = numberInputView.getText().toString();
            // if the user entered a value, go ahead and process it
            // if not, display an error message
            if (numString != null && !numString.isEmpty()) {
                // now parse the String into an int
                // so that it only accepts numbers so there is no possibility of
                // a number format exception
                long num = Long.parseLong(numString);
                if (num%2 == 0) {
                    // it's even so it can't be prime...
                    answer = "Nope!  It's even...";
                } else {
                    // we can start at 3 and we only have to go up to the square root of
                    // the number to check for prime
                    for (int i = 3; i * i <= num; i += 2) {
                        if (num%i == 0) {
                            // it has at least one factor so it can't be prime
                            answer = "Nope! It has factors!";

                            break;
                        }
                    }
                }
            } else {
                // user did not enter a value
                answer = "Hey! I said enter a number!";
            }
            // show answer in toast popup
            Toast.makeText(PrimeFinderActivity.this, answer, Toast.LENGTH_LONG).show();
        }
    };
}