package com.joelbland.shades;

import android.graphics.Point;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    private Button [][] buttons;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        // setContentView( R.layout.activity_main );
        buildGuiByCode( );
    }

    public void buildGuiByCode( ) {
        int ROWS = 3;
        int COLUMNS = 1;

        // Get screen dimensions
        int screenHeight = getWindowManager().getCurrentWindowMetrics().getBounds().height();
        int screenWidth = getWindowManager().getCurrentWindowMetrics().getBounds().width();
        int buttonHeight = screenHeight / 6;

        // Create the layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout( this );
        gridLayout.setColumnCount( COLUMNS );
        gridLayout.setRowCount( ROWS );
        gridLayout.setBackgroundColor(Color.parseColor("#c89b6d"));

        // Create the buttons and add them to gridLayout
        buttons = new Button[ROWS][COLUMNS];
        for( int row = 0; row < ROWS; row++ ) {
            for( int col = 0; col < COLUMNS; col++ ) {
                buttons[row][col] = new Button( this );
                gridLayout.addView( buttons[row][col], screenWidth, buttonHeight );
            }
        }

        // Set gridLayout as the View of this Activity
        setContentView( gridLayout );
    }
}