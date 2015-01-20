package com.greenwear.andreasbolzyk.greenwearversion2.com.greenwear.andreasbolzyk.greenwearversion2.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.greenwear.andreasbolzyk.greenwearversion2.MainActivity;
import com.greenwear.andreasbolzyk.greenwearversion2.R;
import com.greenwear.andreasbolzyk.greenwearversion2.com.greenwear.andreasbolzyk.greenwearversion2.ZoomActivity;

/**
 * Created by andreasbolzyk on 2015-01-19.
 */
public class FragmentSectionOne extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentSectionOne newInstance(int sectionNumber) {
        FragmentSectionOne fragment = new FragmentSectionOne();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentSectionOne() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section1, container, false);
        ImageButton button = (ImageButton) rootView.findViewById(R.id.zoom_);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(),ZoomActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}