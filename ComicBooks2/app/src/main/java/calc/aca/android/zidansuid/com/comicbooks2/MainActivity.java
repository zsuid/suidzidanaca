package calc.aca.android.zidansuid.com.comicbooks2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText mUserTitle;
    EditText mUserIssueNumber;
    EditText mUserCondition;
    EditText mUserPrice;
    TextView mResultsText;
    Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserTitle = (EditText) findViewById(R.id.Ctitle);
        mUserIssueNumber = (EditText) findViewById(R.id.Cissue);
        mUserCondition = (EditText) findViewById(R.id.Ccondition);
        mUserPrice = (EditText) findViewById(R.id.Cprice);
        mResultsText = (TextView) findViewById(R.id.ListView);
        mAddButton = (Button) findViewById(R.id.Cbotton);
         // final String[] userStrings = new String[10];

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  String userCode;
                String title;
                String issueNumber;
                String condition;
                Float price;

                title  = mUserTitle.getText().toString();
                issueNumber = mUserIssueNumber.getText().toString();
                condition = mUserCondition.getText().toString();
                price = Float.parseFloat(mUserPrice.getText().toString());


               // mUserInput1.getText();

               // Comic quality = new Comic(UserStrings);


                // Set up hash map
                HashMap quality = new HashMap();

                float price1 = 3.00F;
                quality.put("mint", price1);

                float price2 = 2.00F;
                quality.put("near mint", price2);

                float price3 = 1.50F;
                quality.put("very fine", price3);

                float price4 = 1.00F;
                quality.put("fine", price4);

                float price5 = 0.50F;
                quality.put("good", price5);

                float price6 = 0.25F;
                quality.put("poor", price6);

                // set up a collection
                Comic[] comix = new Comic[4];
                //Add comics to the collection
                comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00F);
                comix[0].setPrice((Float) quality.get(comix[0].condition));


                comix[1] = new Comic("The Incredible Hulk", "181", "near mint", 680.00F);
                comix[1].setPrice((Float) quality.get(comix[1].condition));

                comix[2] = new Comic("Cerebus", "1A", "good", 190.00F);
                comix[2].setPrice((Float) quality.get(comix[2].condition));

                comix[3] = new Comic(title,issueNumber,condition,price);
                comix[3].setPrice((Float) quality.get(comix[3].condition));

                for (int i = 0; i < comix.length; i++) {
                    System.out.println("Title:" + comix[i].title);
                    mResultsText.append("Title:" + comix[i].title + "\n");

                    mResultsText.append("Issue:" + comix[i].issueNumber + "\n");
                    mResultsText.append("Condition:" + comix[i].condition + "\n");
                    mResultsText.append("Price: $" + comix[i].price + "\n");
                }

              }
            });
    }
            class Comic {
                String title;
                String issueNumber;
                String condition;
                Float basePrice;
                Float price;

                Comic(String inTitle, String inIssueNumber, String inCondition, float inBasePrice) {
                    title = inTitle;
                    issueNumber = inIssueNumber;
                    condition = inCondition;
                    basePrice = inBasePrice;
                }

                void setPrice(float factor) {
                    price = basePrice * factor;
                }
            }


        }


