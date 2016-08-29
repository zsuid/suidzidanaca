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
        EditText a1 = (EditText)findViewById(R.id.TFnum1);
        EditText a2 = (EditText)findViewById(R.id.TFnum2);

        TextView tv = (TextView)findViewById(R.id.Lresult);

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
            if (num2 == 0)
               flag = true;
            else
        ans = num1 / num2;

        tv.setText(ans+"");




    }
}
