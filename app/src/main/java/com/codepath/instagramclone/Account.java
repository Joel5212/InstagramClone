package com.codepath.instagramclone;

import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseUser;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class Account extends AppCompatActivity {
    private Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        btnLogOut = findViewById(R.id.btnLogOut);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Intent i = new Intent(Account.this, LoginActivity.class);
                startActivity(i);

            }
        });



    }
}