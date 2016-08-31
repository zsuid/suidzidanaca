package variables.aca.android.zidansuid.com.tempretureconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mFah;
    TextView mCel;
    TextView mOutputTextView;
    Button mConvertButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFah = (TextView) findViewById(R.id.fahText);
        mCel = (TextView) findViewById(R.id.celText);
        mOutputTextView = (TextView) findViewById(R.id.outputText);
        mConvertButton = (Button) findViewById(R.id.calcButton);

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            String currentFah;
            String currentCell;
            String convertedTemp;
            @Override
            public void onClick(View view) {

                if (!mFah.getText().toString().equals("")){
                    currentFah = mFah.getText().toString();
                    float fahValue = Float.parseFloat(currentFah);
                    fahValue = fahValue -32;
                    fahValue = fahValue / 9;
                    fahValue = fahValue * 5;

                    convertedTemp = String.valueOf(fahValue);

                    mOutputTextView.setText(currentFah + " fahrenheit is " + convertedTemp + " celcius.");
                    mFah.setText("");
                }
               else if(!mCel.getText().toString().equals("")){
                    currentCell = mCel.getText().toString();
                    float celValue = Float.parseFloat(currentCell);
                    celValue = celValue * 9;
                    celValue = celValue / 5;
                    celValue = celValue + 32;

                    convertedTemp = String.valueOf(celValue);

                    mOutputTextView.setText(currentCell + " celcius is " + convertedTemp + " fahrenheit.");
                    mCel.setText("");
                }


            }
        });
        mFah.getText();


        float fah = 86;
        System.out.println(fah + "degree Fahrenhiet is ...");
        // To convert Fahrenheit to celcius
        // begin by subtracting 32
        fah = fah -32;
        // divide the answer by 9
        fah = fah / 9;
        // multiply that answer by 5
        fah = fah * 5;
        System.out.println(fah + "degree celsuis\n");
        float cel = 33;
        System.out.println(fah + "degree celcuis is ...");
        // To convert Celsuis into Fahrenhiet
        // begin by multyplying by 9
        cel = cel * 9;
        // Divide the answer by 5
        cel = cel /5;
        // Add 32 to the answer
        cel = cel + 32;
        System.out.println(cel + "degree Fahrenhiet is ...");

    }
}
