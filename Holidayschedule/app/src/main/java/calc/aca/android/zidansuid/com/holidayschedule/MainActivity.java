package calc.aca.android.zidansuid.com.holidayschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {


    EditText mdayno;
    TextView mvresult;
    Button mvbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mdayno = (EditText) findViewById(R.id.DayNo);
        mvresult = (TextView) findViewById(R.id.VResult);
        mvbutton = (Button) findViewById(R.id.Vbutton);

        mvbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                HolidaySchedule cal = new HolidaySchedule();


                String day = mdayno.getText().toString();
                if (!day.equals("")) {
                    try {
                        int whichDay = Integer.parseInt(day);
                        if (cal.isHoliday(whichDay)) {
                            mvresult.append("Day Number " + whichDay + "is a holiday" + "\n");

                        } else {
                            mvresult.append("Day Number " + whichDay + "is  not a holiday" + "\n");

                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error: " + nfe.getMessage());
                    }
                }

            }

            class HolidaySchedule {
                BitSet sked;



                public HolidaySchedule() {
                    sked = new BitSet(365);

                    int[] holiday = {1, 15, 50, 148, 185, 246,
                            281, 316, 326, 359};

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

        });
    }
}
