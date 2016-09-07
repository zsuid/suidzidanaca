package calc.aca.android.zidansuid.com.bytewriter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWriter extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_byte_writer);
   }


        public static void main(String[] arguments) {
                int[] data = { 137, 89, 82, 181, 50, 220, 103, 20, 0, 59 };
                try {
                        FileOutputStream file = new FileOutputStream("pic.dat");
                        for (int i = 0; i < data.length; i++)
                                file.write(data[i]);
                        file.close();
                } catch (IOException e) {
                        System.out.println("Error - " + e.toString());
                }
        }

}
}