package com.paliarmo.gbnote.fragments;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paliarmo.gbnote.R;
import com.paliarmo.gbnote.models.ENote;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteEditFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteEditFragment extends Fragment {

    private static final String ARG_NOTE = "noteParam";


    private ENote editNote = null;

    public NoteEditFragment() {

    }

    public static NoteEditFragment newInstance(ENote note) {
        NoteEditFragment fragment = new NoteEditFragment();
        Bundle args = new Bundle();
        if (note != null) {
            args.putParcelable(ARG_NOTE, note);
        }
        fragment.setArguments(args);
        return fragment;
    }

    public void setNote(ENote editNote) {
        this.editNote = editNote;
        updateUIState();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            editNote = getArguments().getParcelable(ARG_NOTE);
        }
        updateUIState();
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActionBar toolbar = getActivity().getActionBar();
        setHasOptionsMenu(true);
    }

    private void updateUIState() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_edit, container, false);
    }

}