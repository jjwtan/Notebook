package io.github.jjwtan.notebook;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NoteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        createAndAddFragment();
    }

    private void createAndAddFragment() {

        //fragment manager manages all our fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //create a new noteviewfragment
        NoteViewFragment noteViewFragment = new NoteViewFragment();

        //setTitle(R.string.viewFragmentTitle);
        //adding the fragment
        fragmentTransaction.add(R.id.note_container, noteViewFragment, "NOTE_VIEW_FRAGMENT");

        //make sure what i did above happens
        fragmentTransaction.commit();
    }
}
