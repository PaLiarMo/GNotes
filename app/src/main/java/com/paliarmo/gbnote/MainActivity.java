package com.paliarmo.gbnote;

import androidx.annotation.NonNull;;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.paliarmo.gbnote.fragments.NoteEditFragment;
import com.paliarmo.gbnote.fragments.NoteListFragment;
import com.paliarmo.gbnote.interfaces.OnNotePicked;
import com.paliarmo.gbnote.models.ENote;


public class MainActivity extends AppCompatActivity implements OnNotePicked {

    private NoteListFragment noteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.note_list_frame, NoteListFragment.newInstance()).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onPicked(ENote note) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_create_note:
                createNewNote();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void createNewNote() {
        int frame_id = findViewById(R.id.note_detail_frame) == null ? R.id.note_list_frame : R.id.note_detail_frame;
        Fragment fragment = getSupportFragmentManager().findFragmentById(frame_id);
        if (fragment == null || fragment instanceof NoteListFragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(frame_id, NoteEditFragment.newInstance(null)).addToBackStack(null).commit();
        }else{
                NoteEditFragment fr = (NoteEditFragment) fragment;
                fr.setNote(null);
        }

    }
}