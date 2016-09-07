package calc.aca.android.zidansuid.com.holidayschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HolidaySchedule cal = new HolidaySchedule();
        String day = "2";

        if (!day.equals("")) {
            try {
                int whichDay = Integer.parseInt(day);
                if (cal.isHoliday(whichDay)) {
                    System.out.println("Day number " + whichDay +
                            " is a holiday.");
                } else {
                    System.out.println("Day number " + whichDay +
                            " is not a holiday.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error: " + nfe.getMessage());
            }
        }
    }

    public class HolidaySchedule {
        BitSet sked;

        public HolidaySchedule() {
            sked = new BitSet(365);
            int[] holiday = { 1, 15, 50, 148, 185, 246,
                    281, 316, 326, 359 };

            for (int i = 0; i < holiday.length; i++) {
                addHoliday(holiday[i]);
            }
        }

        public void addHoliday(int dayToAdd) {
            sked.set(dayToAdd);
        }

        public boolean isHoliday(int dayToCheck) {
            return sked.get(dayToCheck);
        }
    }
















}
