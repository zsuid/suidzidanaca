package calc.aca.android.zidansuid.com.accessscopethisandstatic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fighter aFighter = new Fighter();
        Bomber aBomber = new Bomber();

// Can't do this AlienShip is abstract -
// Literally speaking as well as in code
// AlienShip alienShip = new AlienShip(500);

// But our objects of the subclasses can still do
// everything the AlienShip is meant to do

        aBomber.shipName = "Newell Bomber";
        aFighter.shipName = "Meier Fighter";
// And because of the overridden constructor
// That still calls the super constructor
// They have unique properties
        Log.i("aFighter Shield:", ""+ aFighter.getShieldStrength());
        Log.i("aBomber Shield:", ""+ aBomber.getShieldStrength());

// As well as certain things in certain ways
// That are unique to the subclass
        aBomber.fireWeapon();
        aFighter.fireWeapon();

// Take down those alien ships
// Focus on the bomber it has a weaker shield
        aBomber.hitDetected();
        aBomber.hitDetected();
        aBomber.hitDetected();
        aBomber.hitDetected();


        // every time we do this the constructor runs
        AlienShip girlShip = new AlienShip();
        AlienShip boyShip = new AlienShip();
// Look no objects but using the static method
        Log.i("numShips: ", "" + AlienShip.getNumShips());
// This works because shipName is public
        girlShip.shipName = "Corrine Yu";
        boyShip.shipName = "Andre LaMothe";
// This won't work because shieldStrength is private
// girlship.shieldStrength = 999;

// But we have a public getter
        Log.i("girlShip shieldStrngth: ", "" + girlShip.getShieldStrength());

        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());

// And we can't do this because it's private
// boyship.setShieldStrength(1000000);
// lets shoot some ships
        girlShip.hitDetected();
        Log.i("girlShip shieldStrngth: ", "" + girlShip.getShieldStrength());

        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());

        boyShip.hitDetected();
        boyShip.hitDetected();
        boyShip.hitDetected();

        Log.i("girlShip shieldStrngth: ", "" + girlShip.getShieldStrength());

        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());

        boyShip.hitDetected(); //ahhh

        Log.i("girlShip shieldStrngth: ", "" + girlShip.getShieldStrength());

        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());
        Log.i("numShips: ", "" +    AlienShip.getNumShips());

    }
}
