package calc.aca.android.zidansuid.com.wordnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


      public static void main(String[] args) {
            if (args.length > 0) {
                long num = 0;
                char Char1 = args[0].charAt(0);
                char Char2 = args[0].charAt(1);
                switch (Char1) {
                    case 'o':
                        num = 1L;
                        break;
                    case 't':
                        if (Char2 == 'w')
                            num = 2L;
                        if (Char2 == 'h')
                            num = 3L;
                        if (Char2 == 'e')
                            num = 10L;
                        break;
                    case 'f':
                        if (Char2 == 'o')
                            num = 4L;
                        if (Char2 == 'i')
                            num = 5L;
                        break;
                    case 's':
                        if (Char2 == 'i')
                            num = 6L;
                        if (Char2 == 'e')
                            num = 7L;
                        break;
                    case 'e':
                        if (Char2 == 'i')
                            num = 8L;
                        break;
                    case 'n':
                        num = 9L;
                }
                System.out.println("The number is " + num);
            }
        }
    }

