package io.github.jjwtan.notebook;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
//import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*
        String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
                                        "Blackberry","Ubuntu", "Windows7",
                                        "Windows8", "Windows10", "Apple",
                                        "Banana", "Orange", "Pear",
                                        "Strawberry", "Cactus"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                                                                android.R.layout.simple_list_item_1,
                                                                values);
        setListAdapter(adapter);
        */

        notes = new ArrayList<Note>();
        notes.add(new Note("This is a new note title", "This is the body of our note",
                            Note.Category.PERSONAL));
        notes.add(new Note("This is a new note title2", "This is the body of our note",
                            Note.Category.FINANCE));
        notes.add(new Note("This is a new note title3 which is very very super super very very LONG long long LOnGG", "This is the body of our note This is the body of our note This is the body of our note This is the body of our note This is the body of our note This is the body of our noteThis is the body of our note",
                            Note.Category.QUOTE));
        notes.add(new Note("This is a new note title4", "This is the body of our note",
                            Note.Category.PERSONAL));
        notes.add(new Note("This is a new note title5", "This is the body of our note",
                Note.Category.TECHNICAL));
        notes.add(new Note("This is a new note title6", "This is the body of our note",
                            Note.Category.FINANCE));
        notes.add(new Note("This is a new note title", "This is the body of our note",
                Note.Category.PERSONAL));
        notes.add(new Note("This is a new note title2", "This is the body of our note",
                Note.Category.FINANCE));
        notes.add(new Note("This is a new note title3", "This is the body of our note",
                Note.Category.QUOTE));
        notes.add(new Note("This is a new note title4", "This is the body of our note",
                Note.Category.PERSONAL));
        notes.add(new Note("This is a new note title5", "This is the body of our note",
                Note.Category.TECHNICAL));
        notes.add(new Note("This is a new note title6", "This is the body of our note",
                Note.Category.FINANCE));
        notes.add(new Note("This is a new note title", "This is the body of our note",
                Note.Category.PERSONAL));
        notes.add(new Note("This is a new note title2", "This is the body of our note",
                Note.Category.FINANCE));
        notes.add(new Note("This is a new note title3", "This is the body of our note",
                Note.Category.QUOTE));
        notes.add(new Note("This is a new note title4", "This is the body of our note",
                Note.Category.PERSONAL));
        notes.add(new Note("This is a new note title5", "This is the body of our note",
                Note.Category.TECHNICAL));
        notes.add(new Note("This is a new note title6", "This is the body of our note",
                Note.Category.FINANCE));


        noteAdapter = new NoteAdapter(getActivity(), notes);

        setListAdapter(noteAdapter);

        //getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.black));
        //getListView().setDividerHeight(5);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        launchNoteDetailActivity(position);
    }

    private void launchNoteDetailActivity(int position) {

        // grab the note information associated with whatever note item we click on
        Note note = (Note) getListAdapter().getItem(position);

        // create a new intent that launches our noteDetailActivity
        Intent intent = new Intent(getActivity(),NoteDetailActivity.class);

        // pass along the information of the note we clicked on to our noteDetailActivity
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getId());

        startActivity(intent);
    }

}













