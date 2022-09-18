package com.joelbland.shades;

import android.app.Application;
import android.view.Gravity;
import android.view.View;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Space;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainActivity extends AppCompatActivity {
    private TextView status;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main);
        int ROWS = 3;
        int COLUMNS = 1;
        int TV_HEIGHT = 350;
        int BUTTON_TEXTSIZE = 28;
        int TV_TEXTSIZE = 18;

        // Change the App Label (top left) to “HW3 Ex 2” using a strings.xml resource
        this.setTitle(getResources().getString(R.string.appLabel));

        // Get screen dimensions
        int screenHeight = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        int screenWidth = getWindowManager().getCurrentWindowMetrics().getBounds().width();

        // Set the height for each button based on the screen height
        int buttonHeight = screenHeight / (ROWS * 2);

        // Create the layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout( this );
        gridLayout.setColumnCount( COLUMNS );
        gridLayout.setRowCount( ROWS );
        gridLayout.setUseDefaultMargins(true); // use this method so the buttons don't look weird
        gridLayout.setPadding(10,10,10,10);
        // Change the background color to “#C89B6D” using a strings.xml resource
        gridLayout.setBackgroundColor(Color.parseColor(getResources().getString(R.string.view_background)));

        // Create an array of buttons and add them to gridLayout
        Button [] button = new Button[3];

        // Loop through the array and create buttons
        for( int i=0; i < 3; i++) {
            button[i] = new Button(this);
            // Set attributes for each button
            button[i].setId(View.generateViewId());
            // Set a Tag to identify which button is clicked in the OnClickListener
            button[i].setTag("btn" + i);
            button[i].setTextSize(BUTTON_TEXTSIZE);
            // Connect the OnClickListener method to each button
            button[i].setOnClickListener(btnClick);
            // Change the background color to “#AC7D50” using a strings.xml resource
            button[i].setBackgroundColor(Color.parseColor(getResources().getString(R.string.button_background)));
            // Add each button to the GridLayout
            gridLayout.addView(button[i], screenWidth, buttonHeight);
        }

        // Set each button's text
        button[0].setText(getResources().getString(R.string.PLUM));
        button[1].setText(getResources().getString(R.string.BLUE));
        button[2].setText(getResources().getString(R.string.GOLD));

        // Create a TextView to show the output
        status = new TextView( this );
        // Set the TextView attributes
        status.setWidth(screenWidth);
        status.setHeight(TV_HEIGHT);
        status.setGravity(Gravity.CENTER);
        status.setBackgroundColor(Color.parseColor(getResources().getString(R.string.button_background)));
        status.setTextSize(TV_TEXTSIZE);

        // Set the TextView to invisible to begin
        status.setVisibility(View.INVISIBLE);

        // Add the TextView to the GridLayout
        gridLayout.addView(status);

        // Set gridLayout as the View of this Activity
        setContentView( gridLayout );

    }

    // OnClickListener for the buttons
    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Set the TextView to visible
            status.setVisibility(View.VISIBLE);
            // Get the button's Tag from view and set the output string accordingly
            switch((String) view.getTag()){
                case "btn0":
                    status.setText(getResources().getString(R.string.plum_is));
                    break;
                case "btn1":
                    status.setText(getResources().getString(R.string.blue_is));
                    break;
                case "btn2":
                    status.setText(getResources().getString(R.string.gold_is));
                    break;
            }
        }
    };
}