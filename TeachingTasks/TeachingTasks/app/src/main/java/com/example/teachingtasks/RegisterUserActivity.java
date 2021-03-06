package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class RegisterUserActivity extends AppCompatActivity implements View.OnClickListener {

    EditText newUsername, newPassword;
    CheckBox showPass;
    Button createButton;
    RegisterUserDBHelper mydb;
    ArrayList<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mydb = new RegisterUserDBHelper(this);

        users = mydb.getAllUsers();

        //Sets the initial Content View
        setContentView(R.layout.activity_main);

        //Assign variables to UI components
        newUsername = (EditText) findViewById(R.id.newUserNameEditText);
        newPassword = (EditText) findViewById(R.id.newPasswordEditText);
        showPass = (CheckBox) findViewById(R.id.showPasswordCheckBox);
        createButton = (Button) findViewById(R.id.createButton);

        //Easy quick fix to making login default screen
        //Must change the default main class to UserSelectActivity
        Button cancelButton = (Button) findViewById(R.id.editButton);
        cancelButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mydb.close();
                Intent selectUserIntent = new Intent(RegisterUserActivity.this,UserSelectActivity.class);
                RegisterUserActivity.this.startActivity(selectUserIntent);
            }
        });

        //Set EventHandlers
        createButton.setOnClickListener(this);
        showPass.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        //Checks the ID and calls the appropriate EventHandler
        switch (v.getId()){
            case R.id.showPasswordCheckBox: new ShowPassEventHandler().onCheck(showPass, newPassword); break;
            case R.id.createButton: mydb.close(); new CreateUserEventHandler().onClick(this, newUsername, newPassword); break;
            default: return;
        }
    }
}
