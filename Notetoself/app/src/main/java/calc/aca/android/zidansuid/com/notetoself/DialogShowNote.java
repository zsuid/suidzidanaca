package calc.aca.android.zidansuid.com.notetoself;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zidansuid on 9/15/16.
 */
public class DialogShowNote extends DialogFragment {

    private Note mNote;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // All the other code goes here
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_show_note, null);

        TextView txtTitle = (TextView) dialogView.findViewById(R.id.txtTitle);

        TextView txtDescription = (TextView) dialogView.findViewById(R.id.txtDescription);

        txtTitle.setText(mNote.getTitle());
        txtDescription.setText(mNote.getDescription());

        ImageView ivImportant = (ImageView) dialogView.findViewById(R.id.imageViewImportant);

        ImageView ivTodo = (ImageView) dialogView.findViewById(R.id.imageViewTodo);
        ImageView ivIdea = (ImageView) dialogView.findViewById(R.id.imageViewIdea);

        if (!mNote.isImportant()){
            ivImportant.setVisibility(View.GONE);
        }

        if (!mNote.isTodo()){
            ivTodo.setVisibility(View.GONE);
        }

        if (!mNote.isIdea()){
            ivIdea.setVisibility(View.GONE);
        }
        Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);

        builder.setView(dialogView).setMessage("Your Note");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();





    }


    // Receive a note from the MainActivity
    public void sendNoteSelected(Note noteSelected) {
        mNote = noteSelected;
    }

}

