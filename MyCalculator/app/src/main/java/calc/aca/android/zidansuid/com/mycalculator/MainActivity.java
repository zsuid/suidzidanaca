package calc.aca.android.zidansuid.com.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private com.google.android.gms.common.api.GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new com.google.android.gms.common.api.GoogleApiClient.Builder(this).addApi(com.google.android.gms.appindexing.AppIndex.API).build();
    }

    public void onButtonClick(View v) {
        EditText a1 = (EditText) findViewById(R.id.TFnum1);
        EditText a2 = (EditText) findViewById(R.id.TFnum2);

        TextView tot = (TextView) findViewById(R.id.Lresult);

        boolean V = false;

        double num1, num2;
        double ans;
        num1 = Double.parseDouble(a1.getText().toString());
        num2 = Double.parseDouble(a2.getText().toString());
        ans =  Double.parseDouble(a2.getText().toString());

        if (v.getId() == R.id.Badd)
            ans = num1 + num2;

        if (v.getId() == R.id.Bsub)
            ans = num1 - num2;


        if (v.getId() == R.id.Bmult)
            ans = num1 * num2;

        if (v.getId() == R.id.Bdiv)

                ans = num1 / num2;




    }


}
