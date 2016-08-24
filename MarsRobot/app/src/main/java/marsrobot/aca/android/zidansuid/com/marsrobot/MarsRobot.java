package marsrobot.aca.android.zidansuid.com.marsrobot;

/**
 * Created by zidansuid on 8/24/16.
 */
public class MarsRobot {
    String status;
    int speed;
    float temperature;
    boolean batteryOn;
    float windSpeedReading;


        void checkTemperature() {
            if (temperature < -80){
                status = "returning home";
                speed = 5;
            }
        }
    void showAttributes() {
        System.out.println("status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature: " + temperature);
    }
    void killMarsRobot() {
        if (batteryOn && windSpeedReading > 100) {
            status = "Robot  is shutting Down.";
            speed = 0;

        }
    }


}
