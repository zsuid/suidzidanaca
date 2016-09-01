package calc.aca.android.zidansuid.com.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v)
    {
        // these are the text fields from emulator screen ,edit text
        EditText a1 = (EditText)findViewById(R.id.LFnum1);
        EditText a2 = (EditText)findViewById(R.id.LFnum2);

        // this is the label result ,text view

        TextView tv = (TextView)findViewById(R.id.Lresult);
        // no division  by 0
        boolean flag = false;
        double num1,num2,ans;
        num1 = Double.parseDouble(a1.getText().toString());
        num2 = Double.parseDouble(a2.getText().toString());

        ans = 0;


        if(v.getId() == R.id.Badd)
             ans = num1 + num2;
        if(v.getId() == R.id.Bsub)
            ans = num1 - num2;
        if(v.getId() == R.id.Bmult)
            ans = num1 * num2;
        if(v.getId() == R.id.Bdiv)
            //division by 0
           if(num2 == 0)
               flag = true;  //divsion by zero error
            else

            ans = num1 / num2;

        tv.setText(ans+"");




    }

}
