package calc.aca.android.zidansuid.com.accessscopethisandstatic;

import android.util.Log;

/**
 * Created by zidansuid on 9/12/16.
 */

    public class Bomber extends AlienShip {

        public Bomber(){
            super(100);
            // Weak shields for a bomber
            Log.i("Location: ", "Bomber constructor");
        }

        public void fireWeapon(){
            Log.i("Firing weapon: ", "bombs away");
        }
    }


