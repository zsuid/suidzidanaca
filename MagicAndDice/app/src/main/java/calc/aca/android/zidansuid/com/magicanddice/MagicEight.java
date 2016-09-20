package calc.aca.android.zidansuid.com.magicanddice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MagicEight extends AppCompatActivity {

    public static int Num_magic = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_eight);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onMagic8BallClicked(View view) {
        Toast.makeText(this,getMagic(),Toast.LENGTH_SHORT).show();

    }
    private int getMagic() {
        switch ((int) (Num_magic * Math.random() + 1)) {
            case 1:
                return R.string.magic1;
            case 2:
                return R.string.magic2;
            case 3:
                return R.string.magic3;
            case 4:
                return R.string.magic4;
            case 5:
                return R.string.magic5;
            case 6:
                return R.string.magic7;
            case 7:
                return R.string.magic8;
            case 8:
                return R.string.magic9;
            case 9:
                return R.string.magic10;
            case 10:
                return R.string.magic1;
            case 11:
                return R.string.magic1;
            case 12:
                return R.string.magic1;
            case 13:
                return R.string.magic1;
            case 14:
                return R.string.magic1;
            case 15:
                return R.string.magic1;
            case 16:
                return R.string.magic1;
            case 17:
                return R.string.magic1;
            case 18:
                return R.string.magic1;
            case 19:
                return R.string.magic1;
            default:
                return R.string.magic1;


        }
    }
}
