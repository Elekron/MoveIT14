package com.greenwear.andreasbolzyk.greenwearversion2.com.greenwear.andreasbolzyk.greenwearversion2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.greenwear.andreasbolzyk.greenwearversion2.MainActivity;
import com.greenwear.andreasbolzyk.greenwearversion2.R;

import java.util.ArrayList;

/**
 * Created by andreasbolzyk on 2015-01-19.
 */
    /**
     * A placeholder fragment containing a simple view.
     */
public class FragmentSectionTwo extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private ListView myListView;
    private String[] strListView;
    private ArrayList<String> myStringArray1 = new ArrayList<String>();
    private EditText editText;
    private String message ="temp";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentSectionTwo newInstance(int sectionNumber) {
        FragmentSectionTwo fragment = new FragmentSectionTwo();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentSectionTwo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_section2, container, false);

        myListView = (ListView)rootView.findViewById(R.id.myListView);

        strListView = getResources().getStringArray(R.array.my_data_list);
        for(int i = 0; i< 1; i++){
            myStringArray1.add(i,strListView[i]);
        }
//        myStringArray1.add("Andreas");
        ArrayAdapter<String> objAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, myStringArray1);
        myListView.setAdapter(objAdapter);

        editText = (EditText) rootView.findViewById(R.id.edit_message);

        Button button = (Button) rootView.findViewById(R.id.addList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = editText.getText().toString();
                myStringArray1.add(message);
                ArrayAdapter<String> objAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, myStringArray1);
                myListView.setAdapter(objAdapter);
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