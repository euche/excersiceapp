package com.example.lenovo.sandw;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {


    private  long  WorkoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if(savedInstanceState !=null) {

            WorkoutId = savedInstanceState.getLong("workoutId");

        }
        else{

                StopwatchFragment stopwatchFragment = new StopwatchFragment();
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.stopwatch_container, stopwatchFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();


            }



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);



    }


    @Override
    public void onStart(){

        super.onStart();
        View view = getView();
        TextView title = (TextView) view.findViewById(R.id.textTitle);
        Workout workout = Workout.workouts[(int) WorkoutId];
        title.setText(workout.getName());
        TextView description = (TextView) view.findViewById(R.id.textDescription);
        description.setText(workout.getDescription());


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutId", WorkoutId);// We retrive it from the onCreateView Method Above
    }



    public void setWorkout(long workoutId) { //This is a setter method for the workoutID. The activity will use this method to set the value of the workout ID.


       WorkoutId = workoutId;// or this.WorkoutId = workoutId
    }













}
