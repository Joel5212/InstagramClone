package com.codepath.instagramclone;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    public EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        if(ParseUser.getCurrentUser() != null) //Persistence, if user is logged in then move to Main Activity
        {
            goMainActivity();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);
            }
        });
    }

    private void loginUser(String username, String password)
        {
            Log.i(TAG, "Attempting to login user " + username);
            //TODO: navigate to the main activity if the user has signed in properly
            ParseUser.logInInBackground(username, password, new LogInCallback() { //Executes logic on the background thread and by default this will happen in UI thread which will not allow you to do anything while this operation is runnning
                @Override
                public void done(ParseUser user, ParseException e)
                {

                        if(e != null)
                        {
                            Log.e(TAG, "Issue with login", e);
                            Toast.makeText(LoginActivity.this, "Issue with login!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else
                        {
                            goMainActivity();
                            Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                        }
                }
            });
        }

    private void goMainActivity() {

        Intent i = new Intent(this, MainActivity.class);

        startActivity(i);
        finish();

    }
}