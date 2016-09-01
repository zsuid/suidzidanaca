package calc.aca.android.zidansuid.com.wordnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

      TextView  chara;
      TextView  number;
      TextView convertedword;
      Button mConvertButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chara = (TextView)findViewById(R.id.mchar);
        mConvertButton = (Button)findViewById(R.id.conv);
        number = (TextView)findViewById(R.id.mnumber);

        mConvertButton.setOnClickListener(new View.OnClickListener()
        {
            String currentword;
            String convertedword;

            @Override
            public void onClick(View view)
            {
                if (!chara.getText().toString().equals(""))
                {
                    currentword = chara.getText().toString();
                    convertedword = chara.getText().toString();
                    int mnumber = 0;
                    char Char1 = currentword.charAt(0);
                    char Char2 = currentword.charAt(1);
                    switch (Char1) {
                        case 'o':
                            mnumber = 1;
                            break;
                        case 't':
                            if (Char2 == 'w')
                                mnumber = 2;
                            if (Char2 == 'h')
                                mnumber = 3;
                            if (Char2 == 'e')
                                mnumber = 10;
                            break;
                        case 'f':
                            if (Char2 == 'o')
                                mnumber = 4;
                            if (Char2 == 'i')
                                mnumber = 5;
                            break;
                        case 's':
                            if (Char2 == 'i')
                                mnumber = 6;
                            if (Char2 == 'e')
                                mnumber = 7;
                            break;
                        case 'e':
                            if (Char2 == 'i')
                                mnumber = 8;
                            break;
                        case 'n':
                            mnumber = 9;
                    }
                    convertedword = String.valueOf(mnumber);

                    // System.out.println("The number is " + mchar);
                }
                number.setText(convertedword);
            }

        });
    }
}