package com.example.coffeetime.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaTimestamp;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.coffeetime.R;

public class SignIn extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


    }

    public void  registerUser(View view){

        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

}

