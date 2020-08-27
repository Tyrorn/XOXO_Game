package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final int[] mButtonIds={
            R.id.button1,R.id.button2,R.id.button3,
            R.id.button4,R.id.button5,R.id.button6,
            R.id.button7,R.id.button8,R.id.button9,
    };
    private Button[] mButtons = new Button[9];

    public void swap( int t, int[] tester){


        for (int value : tester) {
            int l = t + value;
            if (l >= 0 && l < 9) {
                if (mButtons[l].getText().equals("X")) {
                    mButtons[l].setText("O");
                } else {
                    mButtons[l].setText("X");
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i =0;i<9;i++){
            mButtons[i] = findViewById(mButtonIds[i]);
            final int finalI = i;
            mButtons[i].setOnClickListener(view ->{
                Button b = (Button)view;
                if (finalI%3 == 1){
                    int[] tester = {-3,-1,0,1,+3};
                    swap(finalI, tester);
                }
                else if(finalI%3 ==0){
                    int[] tester = {-3,0,1,3};
                    swap(finalI, tester);
                }
                else{
                    int[] tester={-3,-1,0,3};
                    swap(finalI, tester);
                }
            });
        }
    }
}