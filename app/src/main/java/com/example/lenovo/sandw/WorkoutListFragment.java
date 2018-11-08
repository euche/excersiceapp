package com.example.lenovo.sandw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.ListFragment;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ListView;



/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {


    public static interface WorkoutListListener {   // We want the Fragment to interact with Activity without the fragment knowing.
        void itemClicked(long id);             // we are adding the interface to CREATE a Listener to know when FRAGMENT IS CLICKED.
    }


    private WorkoutListListener listener;  //To listen for clicks


    public WorkoutListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {


            names[i] = Workout.workouts[i].getName();
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(                       //Creation of ArrayAdapter.
                inflater.getContext(), android.R.layout.simple_list_item_1,
                names);
        setListAdapter(adapter);


        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onAttach(Activity activity) {               //This is called when the Fragment gets attached to the activity

        super.onAttach(activity);
        this.listener = (WorkoutListListener) activity;


    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) { //Tell the listener when an item in the ListView is clicked.

        if (listener != null) {         //Tell the listener when an item in the ListView is clicked.
            listener.itemClicked(id); ///This method will be created in the activity
        }


    }


}