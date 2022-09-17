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
        // Call the buildGuiByCode method to create the GUI.
        buildGuiByCode( );
    }

    public void buildGuiByCode( ) {
        int ROWS = 3;
        int COLUMNS = 1;

        String goldIs = getResources().getString(R.string.gold_is);
        String plumIs = getResources().getString(R.string.plum_is);
        String blueIs = getResources().getString(R.string.blue_is);
        String GOLD = getResources().getString(R.string.GOLD);
        String PLUM = getResources().getString(R.string.PLUM);
        String BLUE = getResources().getString(R.string.BLUE);
        String buttonBackground = getResources().getString(R.string.button_background);
        String viewBackground = getResources().getString(R.string.view_background);

        // Get screen dimensions
        int screenHeight = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        int screenWidth = getWindowManager().getCurrentWindowMetrics().getBounds().width();

        // Set the height for each button
        int buttonHeight = screenHeight / 6;

        // Create the layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout( this );
        gridLayout.setColumnCount( COLUMNS );
        gridLayout.setRowCount( ROWS );
        gridLayout.setBackgroundColor(Color.parseColor(viewBackground));

        // Create buttons and add them to gridLayout
        Button [] button = new Button[3];

        for( int i=0; i < 3; i++) {
            button[i] = new Button(this);
            button[i].setTextSize(28);
            //button[i].setBackgroundColor(Color.parseColor(buttonBackground));
            gridLayout.addView(button[i], screenWidth, buttonHeight);
        }

        // Set each button text
        button[0].setText(PLUM);
        button[1].setText(BLUE);
        button[2].setText(GOLD);

        // Create a TextView to show the output
        status = new TextView( this );
        // set up status' characteristics
        status.setWidth(screenWidth);
        status.setHeight(350);
        status.setGravity(Gravity.CENTER);
        status.setBackgroundColor(Color.parseColor(buttonBackground));
        status.setTextSize(14);

        // if button press 1 = then, else
        System.out.println(">>>***---!!!DEBUG!!!---***<<<");
        System.out.println(goldIs);
        System.out.println("^^^***---!!!DEBUG!!!---***^^^");
        status.setText("");

        // Add the TextView to the GridLayout
        gridLayout.addView(status);

        // Set gridLayout as the View of this Activity
        setContentView( gridLayout );
    }


}