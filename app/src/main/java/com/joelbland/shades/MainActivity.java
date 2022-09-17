package com.joelbland.shades;

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

        // Get screen dimensions
        int screenHeight = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        int screenWidth = getWindowManager().getCurrentWindowMetrics().getBounds().width();

        // Set the height for each button
        int buttonHeight = screenHeight / 6;

        // Create the layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout( this );
        gridLayout.setColumnCount( COLUMNS );
        gridLayout.setRowCount( ROWS );
        gridLayout.setBackgroundColor(Color.parseColor("#c89b6d"));

        // Create buttons and add them to gridLayout
        Button [] button = new Button[3];
        for( int i=0; i < 3; i++) {
            button[i] = new Button(this);
            button[i].setText("1");
            button[i].setTextSize(28);
            //button[i].setBackgroundColor(Color.parseColor("#AC7D50"));
            gridLayout.addView(button[i], screenWidth, buttonHeight);
        }
        status = new TextView( this );


        // set up status' characteristics
        status.setWidth(screenWidth);
        status.setHeight(350);
        status.setGravity(View.TEXT_ALIGNMENT_CENTER);
        status.setBackgroundColor( Color.GREEN );
        status.setTextSize(28);
        status.setText("HELLO, Jerry!");
        gridLayout.addView(status);


        // Create the buttons and add them to gridLayout
/*        buttons = new Button[ROWS][COLUMNS];

        for( int row = 0; row < ROWS; row++ ) {
            for( int col = 0; col < COLUMNS; col++ ) {
                buttons[row][col] = new Button( this );
                buttons[row][col].setBackgroundColor(Color.parseColor("#ac7d50"));
                gridLayout.addView( buttons[row][col], screenWidth, buttonHeight );

            }
        }*/

        // Set gridLayout as the View of this Activity
        setContentView( gridLayout );
    }
    private class ButtonHandler implements View.OnClickListener {
        public void onClick( View v ) {

        }
    }
}