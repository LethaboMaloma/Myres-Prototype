package com.example.myres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignuppageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);
        //intialise firebase Authorasation
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
    }

    Button signup = findViewById(R.id.button);

    void Signup(View view){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        EditText Email = (EditText) findViewById(R.id.EmailAddress);
        EditText Password = (EditText) findViewById(R.id.Password);
        String email  = Email.getText().toString();
        String password  = Password.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // User registration successful
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(this, "Registration passed.", Toast.LENGTH_SHORT).show();
                        // You can save additional user details to Firestore or other databases here
                    } else {
                        // Registration failed
                        Toast.makeText(this, "Registration failed.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}