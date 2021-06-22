package com.example.coffeetime.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaTimestamp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeetime.StartAppActivity;

import com.example.coffeetime.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignIn extends AppCompatActivity {

    EditText et_email, et_password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        et_email  = (EditText) findViewById(R.id.inputUser);
        et_password = (EditText) findViewById(R.id.idPwd);

    }
    public void login(View view){
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(SignIn.this,"Bienvenido",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplication(), StartAppActivity.class);
                            startActivity(intent);
                        } else {

                            if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignIn.this,"Ya esta registrado este usuario",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignIn.this,"Ocurrio algo en el proceso",Toast.LENGTH_SHORT).show();
                            }

                        }

                        // ...
                    }
                });
    }

    public void  registerUser(View view){

        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

}

