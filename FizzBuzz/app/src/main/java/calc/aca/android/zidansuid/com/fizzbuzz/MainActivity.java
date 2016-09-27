package calc.aca.android.zidansuid.com.fizzbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public static void main(String[] args) {
            for(int i = 1; i <= 15; i++) {
                if (((i % 3) == 0) && ((i % 5) == 0))
                    System.out.print("FizzBuzz");
                else if ((i % 3) == 0)
                    System.out.print("Fizz");
                else if ((i % 5) == 0)
                    System.out.print("Buzz");
                else
                    System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }

}
