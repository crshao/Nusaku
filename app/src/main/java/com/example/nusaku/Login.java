package com.example.nusaku;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends BaseActivity implements View.OnClickListener {
    private final static String TAG = "EmailPassword";
    private FirebaseAuth mAuth;
    private static final int RC_SIGN_IN = 9001;
    static final int GOOGLE_SIGN_IN = 123;
    private GoogleSignInClient mGoogleSignInClient;
    String email, password;

    @BindView(R.id.back)
    ImageButton b2;

    @BindView(R.id.email_layout)
    TextInputLayout txtEmail;

    @BindView(R.id.password_layout)
    TextInputLayout txtPassword;

    @BindView(R.id.masuk)
    MaterialButton btn_sign_in;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        setProgressBar(progressBar);
//        updateUI(currentUser);
    }

    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);

        if(email.isEmpty())
        {
            txtEmail.getEditText().setError("Email harus diisi!");
            txtEmail.getEditText().requestFocus();
            return ;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtEmail.setError("Mohon masukkan alamat email yang benar!");
            txtEmail.getEditText().requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            txtPassword.getEditText().setError("Password harus diisi!");
            txtPassword.getEditText().requestFocus();
            return ;
        }

        if(password.length() < 6)
        {
            txtPassword.setError("Panjang minimal password adalah 6 karakter!");
            txtPassword.getEditText().requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        showProgressBar();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "User belum terdaftar/Password salah!",
                                    Toast.LENGTH_SHORT).show();
                            hideProgressBar();
//                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                            updateUI(null);

//                            // [START_EXCLUDE]
//                            checkForMultiFactorFailure(task.getException());
//                            // [END_EXCLUDE]
                        }
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }

    @OnClick(R.id.masuk)
    void masuk(){
        email = txtEmail.getEditText().getText().toString().trim();
        password = txtPassword.getEditText().getText().toString().trim();
        signIn(email, password);
    }

    @OnClick(R.id.back)
    void back(){
        startActivity(new Intent(this , Welcome.class));
    }

    @Override
    public void onClick(View v) {
    }
}

