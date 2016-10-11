package calc.aca.android.zidansuid.com.pong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by zidansuid on 10/11/16.
 */

public class StartUp extends Activity {


        private Button mStartButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.startup);

            mStartButton = (Button) findViewById(R.id.strtBtn);



            mStartButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(StartUp.this,MainActivity.class);
                    startActivity(intent);


                }
            });

        }




}
