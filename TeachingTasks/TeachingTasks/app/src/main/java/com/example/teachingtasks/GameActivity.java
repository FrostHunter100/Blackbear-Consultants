package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    TextView username;
    TextView question;
    TextView questionObject;
    ArrayList<Button> taskObject = new ArrayList<>();
    Button taskNavButton, statisticsNavButton, settingsNavButton;
    ConstraintLayout taskObjectLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        taskObjectLayout = (ConstraintLayout) findViewById(R.id.taskObjectLayout);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        question = (TextView) findViewById(R.id.taskQuestion);
        question.setText(getIntent().getStringExtra("EXTRA_QUESTION"));

        questionObject = (TextView) findViewById(R.id.taskQuestionObject);
        questionObject.setText(getIntent().getStringExtra("EXTRA_TASK_OBJECT"));

        Button temp = new Button(this);
        taskObject.add(temp);
        temp.setId(taskObject.size()*1000);
        temp.setGravity(Gravity.CENTER);
        taskObjectLayout.addView(taskObject.get(taskObject.size()-1));

        if(questionObject.getText().toString().equals("2")){
            tryToChangeConstraints();
        }

        /*
        TEMP EVENT HANDLER
         */

        taskObject.get(taskObject.size()-1).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent taskSuccessIntent = new Intent(GameActivity.this, TaskSuccessActivity.class);
                taskSuccessIntent.putExtra("EXTRA_USER", username.getText());
                GameActivity.this.startActivity(taskSuccessIntent);

                return false;
            }
        });





        taskNavButton = (Button) findViewById(R.id.taskNavButton);
        statisticsNavButton = (Button) findViewById(R.id.statisticsNavButton);
        settingsNavButton = (Button) findViewById(R.id.settingsNavButton);
        /*
        TEMP EVENT HANDLERS
         */

        taskNavButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent loginIntent = new Intent(GameActivity.this, LoginActivity.class);
                loginIntent.putExtra("EXTRA_USER", username.getText());
                GameActivity.this.startActivity(loginIntent);
                return false;
            }
        });

        statisticsNavButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent statsIntent = new Intent(GameActivity.this, StatisticsActivity.class);
                GameActivity.this.startActivity(statsIntent);
                return false;
            }
        });

        settingsNavButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent settingsIntent = new Intent(GameActivity.this, SettingsActivity.class);
                GameActivity.this.startActivity(settingsIntent);
                return false;
            }
        });
    }

    private void tryToChangeConstraints() {
        //Change constraints on taskObject
        //Create a duplicate to taskObject with a different text and/or background

//        int idOne = taskObject.get(taskObject.size()-1).getId();
//
//        ConstraintSet topSet = new ConstraintSet();
//        topSet.clone(taskObjectLayout);
//
////        topSet.connect(idOne, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
////        topSet.connect(idOne, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
////        topSet.connect(idOne, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
//
//        Button taskObjTwo = new Button(this);
//        taskObjTwo.setId((taskObject.size()+1)*1000);
//
////        topSet.connect(taskObjTwo.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
////        topSet.connect(taskObjTwo.getId(), ConstraintSet.LEFT, idOne, ConstraintSet.RIGHT, 0);
////        topSet.connect(taskObjTwo.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
////        topSet.connect(taskObjTwo.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
////
////        topSet.connect(idOne, ConstraintSet.RIGHT, taskObjTwo.getId(), ConstraintSet.LEFT, 0);
//
//        int[] ids = {idOne, taskObjTwo.getId()};
//        topSet.createHorizontalChainRtl(idOne, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, ids, new float[1], ConstraintSet.CHAIN_SPREAD);
//        taskObject.add(taskObjTwo);
//
//        taskObjectLayout.addView(taskObjTwo);
//        topSet.applyTo(taskObjectLayout);
    }


    //Button 1:
//    Button button = new Button(this);
//        button.setText("Hello");
//        button.setId(100);           // <-- Important
//        layout.addView(button);
//        set.connect(button.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
//        set.connect(button.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
//        set.connect(button.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
//        set.constrainHeight(button.getId(), 200);
//        set.applyTo(layout);
//
//
//    //Button 2:
//    Button newButton = new Button(this);
//        newButton.setText("Yeeey");
//        layout.addView(newButton);
//        set.connect(newButton.getId(), ConstraintSet.BOTTOM, button.getId(), ConstraintSet.TOP, 0);
//        set.connect(newButton.getId(),ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT,0);
//        set.connect(newButton.getId(),ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,0);
//        set.constrainHeight(newButton.getId(), 200);
//        set.applyTo(layout);

}