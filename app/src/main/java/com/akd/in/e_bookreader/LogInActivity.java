package com.akd.in.e_bookreader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LogInActivity extends AppCompatActivity {

    private TextView mTxtRegister;
    private CardView mBtnLogin;
    private EditText mEdtUserName, mEdtPassword;
    private ProgressBar mProgrssBar;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mEdtUserName = findViewById(R.id.edtUserName);
        mEdtPassword = findViewById(R.id.edtPassword);

        mTxtRegister = findViewById(R.id.txtRegister);
        mProgrssBar = findViewById(R.id.progressBar);
        mBtnLogin = findViewById(R.id.btnLogin);

        fAuth = FirebaseAuth.getInstance();


        login();
        register();

    }


    private void register() {

        mTxtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
    }

    public void login() {

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEdtUserName.getText().toString().trim();
                String password = mEdtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEdtUserName.setError("Email is required");
                    mEdtUserName.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mEdtPassword.setError("Password is required");
                    return;
                }
                if (password.length() < 6) {
                    mEdtPassword.setError("Password must be greater than 6 chars");
                    return;
                }

                mProgrssBar.setVisibility(View.VISIBLE);


                // authenticate user

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", Activity.MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putBoolean("key_name", true); // Storing boolean - true/false
                            editor.commit();
                            Toast.makeText(LogInActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        } else {
                            Toast.makeText(LogInActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });


    }


}
