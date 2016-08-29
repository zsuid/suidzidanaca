package calc.aca.android.zidansuid.com.birthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // birthday example to show how substring works

    class Birthday {
        public void main(String[] arguments) {
            String birthday = "02/17/1963";
            String month = birthday.substring(0, 2);
            String day = birthday.substring(3, 5);
            String year = birthday.substring(6, 10);
            System.out.println("Birthday: " + birthday);
            System.out.println("Month: " + month);
            System.out.println("Day: " + day);
            System.out.println("Year: " + year);    }
    }




        class SizeSample {
            int height;
            int weight;
            int depth;
        }



        public void main(String[] arguments) {
            SizeSample thing = new SizeSample();
            thing.height = 6;
            thing.weight = 96;
            thing.depth = 7;
            System.out.println("Height: " + thing.height);
            System.out.println("Weight: " + thing.weight);
            System.out.println("Depth: " + thing.depth);
        }






}
