package com.example.coffeetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.coffeetime.databinding.ActivityStartAppBinding;

public class StartAppActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);
    }

    public void signHome(View view){

        Intent intent = new Intent(this, Menu_Navegation.class);
        startActivity(intent);
    }
}