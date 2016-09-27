package calc.aca.android.zidansuid.com.magic8ball;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static int Num_magic = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onMagic8BallClicked(View view) {
        Toast.makeText(this,getMagic(),Toast.LENGTH_SHORT).show();

    }
    private int getMagic() {
        switch ( (int) (Num_magic * Math.random() +1)) {
            case 1: return R.string.magic1;
            case 2: return R.string.magic2;
            case 3: return R.string.magic3;
            case 4: return R.string.magic4;
            case 5: return R.string.magic5;
            case 6: return R.string.magic7;
            case 7: return R.string.magic8;
            case 8: return R.string.magic9;
            case 9: return R.string.magic10;
            case 10: return R.string.magic1;
            case 11: return R.string.magic1;
            case 12: return R.string.magic1;
            case 13: return R.string.magic1;
            case 14: return R.string.magic1;
            case 15: return R.string.magic1;
            case 16: return R.string.magic1;
            case 17: return R.string.magic1;
            case 18: return R.string.magic1;
            case 19: return R.string.magic1;
            default: return R.string.magic1;



        }
    }
}
