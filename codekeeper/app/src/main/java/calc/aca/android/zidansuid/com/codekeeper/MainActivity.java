package calc.aca.android.zidansuid.com.codekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] userStrings = {"omega", "beta", "omicron"};

        CodeKeeper keeper = new CodeKeeper(userStrings);
    }

    public class CodeKeeper {
        ArrayList list;
        String[] codes = { "alpha", "lambda", "gamma", "delta", "zeta" };

        public CodeKeeper(String[] userCodes) {
            list = new ArrayList();
            // load built-in codes
            for (int i = 0; i < codes.length; i++) {
                addCode(codes[i]);
            }

            // load user codes
            for (int j = 0; j < userCodes.length; j++) {
                addCode(userCodes[j]);
            }

            // display all the codes
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                String output = (String) iterator.next();
                System.out.println(output);
            }
        }

        private void addCode(String code) {
            if (!list.contains(code)) {
                list.add(code);
            }
        }


    }


}
