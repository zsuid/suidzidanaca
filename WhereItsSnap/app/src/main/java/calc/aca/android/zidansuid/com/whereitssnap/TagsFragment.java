package calc.aca.android.zidansuid.com.whereitssnap;

import android.app.Activity;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
/**
 * Created by zidansuid on 9/26/16.
 */

public class TagsFragment extends ListFragment{

    // activity com as a member TagsFragment
    private ActivityComs mActivityComs;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get access to the database
        // Get the list of tags from wis_table_tags
        //Set up SimpleCursorAdapter and bind it to ListView

        DataManager d = new DataManager(getActivity().getApplicationContext());
        Cursor c = d.getTags();

        // Create a new adapter
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_list_item_1, c,
                new String[]{DataManager.TABLE_ROW_TAG},
                new int[]{android.R.id.text1}, 0);

        // Attach the Cursor to the adapter
        setListAdapter(cursorAdapter);
    }
        //Retrieves a Cursor object from SimpleCursorAdapter
        //Creates a string based on the tag that was just clicked
        //Passes the string to MainActivity

    public void onListItemClick(ListView l, View v,
                                int position, long id) {

        // What tag has just been clicked?
        Cursor c = ((SimpleCursorAdapter) l.getAdapter()).getCursor();
        c.moveToPosition(position);


        String clickedTag = c.getString(1);
        // 1 is the position of the string
        Log.e("clickedTag = ", " " + clickedTag);

        mActivityComs.onTagsListItemSelected(clickedTag);
    }
    // handle the creation and destruction of our ActivityComs

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivityComs = (ActivityComs) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityComs = null;
    }


}


