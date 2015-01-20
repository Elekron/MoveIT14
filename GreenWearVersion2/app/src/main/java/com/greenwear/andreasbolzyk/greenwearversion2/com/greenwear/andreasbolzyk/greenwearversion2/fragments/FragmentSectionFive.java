package com.greenwear.andreasbolzyk.greenwearversion2.com.greenwear.andreasbolzyk.greenwearversion2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.greenwear.andreasbolzyk.greenwearversion2.MainActivity;
import com.greenwear.andreasbolzyk.greenwearversion2.R;

/**
 * Created by andreasbolzyk on 2015-01-20.
 */
public class FragmentSectionFive extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentSectionFive newInstance(int sectionNumber) {
        FragmentSectionFive fragment = new FragmentSectionFive();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentSectionFive() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section5, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
