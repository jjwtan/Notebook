package io.github.jjwtan.notebook;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//import android.widget.ArrayAdapter;
import android.widget.AdapterView;
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

        registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        launchNoteDetailActivity(MainActivity.FragmentToLaunch.VIEW, position);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.long_press_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // give me position of whatever note i long press on
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int rowPosition = info.position;

        //returns to us id of whatever we select
        switch (item.getItemId()) {
            //if we press edit
            case R.id.edit:
                //do something here
                launchNoteDetailActivity(MainActivity.FragmentToLaunch.EDIT,rowPosition);
                Log.d("Menu Clicks", "We pressed edit!");
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void launchNoteDetailActivity(MainActivity.FragmentToLaunch ftl, int position) {

        // grab the note information associated with whatever note item we click on
        Note note = (Note) getListAdapter().getItem(position);

        // create a new intent that launches our noteDetailActivity
        Intent intent = new Intent(getActivity(),NoteDetailActivity.class);

        // pass along the information of the note we clicked on to our noteDetailActivity
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getId());

        switch (ftl) {
            case VIEW:
                intent.putExtra(MainActivity.NOOE_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.VIEW);
                break;
            case EDIT:
                intent.putExtra(MainActivity.NOOE_FRAGMENT_TO_LOAD_EXTRA, MainActivity.FragmentToLaunch.EDIT);
                break;
        }
        startActivity(intent);
    }

}













