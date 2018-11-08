package com.example.lenovo.sandw;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener {

  private int seconds =0;
  private boolean running;
  private boolean wasRunning;



    public StopwatchFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
              //you dont to set  a Fragment Layout instead use a onCreate View

        if(savedInstanceState!=null){//NOTE: Get the previous state of the stopwatch if the activity’s been destroyed and re-created.

            seconds = savedInstanceState.getInt("second");//NOTE: Get the previous state of the stopwatch if the activity’s been destroyed and re-created.
            running = savedInstanceState.getBoolean("running");// Retrieve the values of the seconds and running variables from the Bundle
            wasRunning = savedInstanceState.getBoolean("wasRunning");//Restore the state of the wasRunning variable if the activity is re-created


        }




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(layout);
        Button startButton = (Button) layout.findViewById(R.id.startbutton);
        startButton.setOnClickListener(this);
        Button stopButton = (Button) layout.findViewById(R.id.stopbutton);
        stopButton.setOnClickListener(this);
        Button resetButton = (Button) layout.findViewById(R.id.resetbutton);
        resetButton.setOnClickListener(this);

        return layout;

    }


    public void onclickstart(View view){//This gets called when the Start button is clicked.

        running =true; //start the stopwatch

    }

    public void onclickreset(View view){//This gets called when the reset button is called

        running = false;
        seconds = 0;        // clear

    }


    public void onclickstop(View view){ //this gets called when the stop button is called

        running = false;

    }


    //This is called when Onclick listener is called,(We are calling it because stopwatch is now a Fragment)


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.startbutton:
                    onclickstart(v);
                    break;
                case R.id.stopbutton:
                    onclickstop(v);
                    break;
                case R.id.resetbutton:
                    onclickreset(v);
                    break;
            }
        }







    private void runTimer(View view){//The runTimer() method uses a Handler to increment the seconds and update the text view.


        final TextView timeView = (TextView) view.findViewById(R.id.timeview);//since it is a fragment, this method passes through View.

        final Handler handler = new Handler();
        handler.post(new Runnable() {   //You put the code you want to run in the Handler’s run() method. The post method will run immediately
            //codes are here
            @Override
            public void run() {
                int hours = seconds / 3600;

                int minutes = (seconds % 3600) / 60;

                int secs = seconds % 60;


                String time = String.format("%d:%02d:%02d", hours, minutes, secs); //parsing the integers to strings

                timeView.setText(time);

                if (running) {                       //if the running is true Second is incremented.
                    seconds++;   }

                handler.postDelayed(this, 1000);
            }

        });


    }



}



