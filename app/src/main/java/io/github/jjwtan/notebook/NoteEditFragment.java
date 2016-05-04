package io.github.jjwtan.notebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteEditFragment extends Fragment {


    public NoteEditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate our fragment edit layout
        View fragmentLayout = inflater.inflate(R.layout.fragment_note_edit, container, false);

        //grab widget reference from layout
        EditText title = (EditText) fragmentLayout.findViewById(R.id.editNoteTitle);
        EditText message = (EditText) fragmentLayout.findViewById(R.id.editNoteMessage);
        ImageButton noteCatButton = (ImageButton) fragmentLayout.findViewById(R.id.editNoteButton);

        //populate widgets with data
        Intent intent = getActivity().getIntent();
        title.setText(intent.getExtras().getString(MainActivity.NOTE_TITLE_EXTRA));
        message.setText(intent.getExtras().getString(MainActivity.NOTE_MESSAGE_EXTRA));

        Note.Category noteCat = (Note.Category) intent.getSerializableExtra(MainActivity.NOTE_CATEGORY_EXTRA);
        noteCatButton.setImageResource(Note.categoryToDrawable(noteCat));

        return fragmentLayout;

    }

}
