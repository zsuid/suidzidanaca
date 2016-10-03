package calc.aca.android.zidansuid.com.whereitssnap;

import android.app.Activity;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ListView;

/**
 * Created by zidansuid on 9/26/16.
 */

public class TitlesFragment  extends ListFragment {

    // cursor member to load the photo and instance of our new inerface
    private Cursor mCursor;
    private ActivityComs mActivityComs;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the tag to search for
        String tag = getArguments().getString("Tag");

        // Get an instance of DataManager
        DataManager d = new DataManager(getActivity().getApplicationContext());


        if(tag == "_NO_TAG"){
            // Get all the titles from the database
            mCursor = d.getTitles();
        }else{
            // Get all the titles with a specific related tag
            mCursor = d.getTitlesWithTag(tag);
        }


        // Create a new adapter
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_list_item_1, mCursor,
                new String[] { DataManager.TABLE_ROW_TITLE },
                new int[] { android.R.id.text1 }, 0 );

        // Attach the adapter to the ListView
        setListAdapter(cursorAdapter);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {

        // Move the cursor to the clicked item in the list
        mCursor.moveToPosition(position);

        // What is the database _id of this item?
        int dBID = mCursor.getInt(
                mCursor.getColumnIndex(
                        DataManager.TABLE_ROW_ID));

        // Use the interface to send the clicked _id
        mActivityComs.onTitlesListItemSelected(dBID);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivityComs = (ActivityComs)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityComs = null;
    }

}

