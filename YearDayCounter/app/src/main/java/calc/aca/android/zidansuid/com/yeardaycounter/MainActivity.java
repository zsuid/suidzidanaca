package calc.aca.android.zidansuid.com.yeardaycounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int yearnow = 2016;

        for (int monthnow = 0; monthnow < 13; monthnow++) {
            for (int daynow = 1; daynow <= countDays(monthnow, yearnow); daynow++) {
                System.out.println("Dates Of the Year:" + monthnow + "/" + daynow + "/" + yearnow);
            }
        }
    }
        static int countDays(int month, int year) {
            int count = -1;
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    count = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    count = 30;
                    break;
                case 2:
                    if (year % 4 == 0) {
                        count = 29;
                    } else {
                        count = 28;
                    }

                    if ((year % 100 == 0) && (year % 400 != 0)) {
                        count = 28;
                    }
            }
            return count;
        }

    }





