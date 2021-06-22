package com.example.coffeetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.coffeetime.databinding.ActivityStartAppBinding;
import com.squareup.picasso.Picasso;

public class StartAppActivity extends AppCompatActivity {

    String url = "https://i.ibb.co/Wt6bXJ1/combo.png";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);
        imageView = findViewById(R.id.imageView);
        Picasso.get()
                .load(url)
                .into(imageView);
    }

    public void signHome(View view){

        Intent intent = new Intent( this, Menu_Navegation.class);
        startActivity(intent);
    }
}