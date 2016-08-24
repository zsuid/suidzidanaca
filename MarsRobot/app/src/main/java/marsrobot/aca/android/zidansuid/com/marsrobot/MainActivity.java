package marsrobot.aca.android.zidansuid.com.marsrobot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MarsRobot spirit = new MarsRobot();
        spirit.status = "exploring";
        spirit.speed = 2;
        spirit.temperature =-60;

        spirit.showAttributes();
        System.out.println("Increase Speed To 3.");
        spirit.speed = 3;
        spirit.showAttributes();
        System.out.println("changing tempreture to -90,");
        spirit.temperature = -90;
        spirit.showAttributes();System.out.println("Checking the temoperature.");
        spirit.checkTemperature();
        spirit.showAttributes();
        MarsRobot soul = new MarsRobot();
        soul.status = "exploring";
        soul.speed = 2;
        soul.temperature =-60;
        soul.batteryOn = true;
        soul.windSpeedReading = 101;

        soul.showAttributes();
        System.out.println("Increase Speed to 3.");
        soul.speed = 3;
        soul.showAttributes();
        System.out.println("Changing temperature to -90.");
        soul.temperature = -90;
        soul.showAttributes();
        System.out.println("Checking the temperature.");
        soul.checkTemperature();
        soul.showAttributes();
        System.out.println("Checking to see if robot should remain on.");
        soul.killMarsRobot();

    }

}
