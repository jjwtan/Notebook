package io.github.jjwtan.notebook;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NoteDetailActivity extends AppCompatActivity {

    public static final String NEW_NOTE_EXTRA = "New Note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        createAndAddFragment();
    }

    private void createAndAddFragment() {

        // grab intent and fragment to launch from out main activity list fragment
        Intent intent = getIntent();

        MainActivity.FragmentToLaunch fragmentToLaunch =
                (MainActivity.FragmentToLaunch) intent.getSerializableExtra(MainActivity.NOOE_FRAGMENT_TO_LOAD_EXTRA);

        //fragment manager manages all our fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (fragmentToLaunch) {
            case EDIT:
                //create a new noteeditfragment
                NoteEditFragment noteEditFragment = new NoteEditFragment();

                setTitle(R.string.edit_fragment_title);
                //adding the fragment
                fragmentTransaction.add(R.id.note_container, noteEditFragment, "NOTE_EDIT_FRAGMENT");


                break;
            case VIEW:
                //create a new noteviewfragment
                NoteViewFragment noteViewFragment = new NoteViewFragment();

                setTitle(R.string.view_fragment_title);
                //adding the fragment
                fragmentTransaction.add(R.id.note_container, noteViewFragment, "NOTE_VIEW_FRAGMENT");

                break;
            case CREATE:
                //create a new noteeditfragment
                NoteEditFragment noteCreateFragment = new NoteEditFragment();

                setTitle(R.string.create_fragment_title);
                Bundle bundle = new Bundle();
                bundle.putBoolean(NEW_NOTE_EXTRA, true);
                noteCreateFragment.setArguments(bundle);

                //adding the fragment
                fragmentTransaction.add(R.id.note_container, noteCreateFragment, "NOTE_CREATE_FRAGMENT");

                break;

        }

        //make sure what i did above happens
        fragmentTransaction.commit();
    }
}
