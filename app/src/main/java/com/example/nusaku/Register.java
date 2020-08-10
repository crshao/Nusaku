package com.example.nusaku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends BaseActivity {

    private final static String TAG = "RegisterActivity";
    private FirebaseAuth mAuth;
    public String email, password, nama, nomorhp;

    @BindView(R.id.email_layout)
    TextInputLayout txtEmail;

    @BindView(R.id.nama_layout)
    TextInputLayout txtNama;

    @BindView(R.id.password_layout)
    TextInputLayout txtPassword;

    @BindView(R.id.nomortelepon_layout)
    TextInputLayout txtNomor;

    @BindView(R.id.daftar)
    Button b1;

    @BindView(R.id.back)
    ImageButton b2;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        setProgressBar(progressBar);
        mAuth = FirebaseAuth.getInstance();
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);

        if (!validate())
            return;

        showProgressBar();

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Register.this, "Terjadi kesalahan pada server.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        hideProgressBar();
                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }

    private boolean validate()
    {
        if(email.isEmpty())
        {
            txtEmail.getEditText().setError("Email harus diisi!");
            txtEmail.getEditText().requestFocus();
            return false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtEmail.setError("Mohon masukkan alamat email yang benar!");
            txtEmail.getEditText().requestFocus();
            return false;
        }

        if(password.isEmpty())
        {
            txtPassword.getEditText().setError("Password harus diisi!");
            txtPassword.getEditText().requestFocus();
            return false;
        }

        if(password.length() < 6)
        {
            txtPassword.setError("Panjang minimal password adalah 6 karakter!");
            txtPassword.getEditText().requestFocus();
            return false;
        }

        return true;
    }

    @OnClick(R.id.daftar)
    void daftar(){
        email = Objects.requireNonNull(txtEmail.getEditText()).getText().toString().trim();
        nama = Objects.requireNonNull(txtNama.getEditText()).getText().toString().trim();
        password = Objects.requireNonNull(txtPassword.getEditText()).getText().toString().trim();
        nomorhp = Objects.requireNonNull(txtNomor.getEditText()).getText().toString().trim();

        createAccount(email, password);
    }

    @OnClick(R.id.back)
    void back(){
        startActivity(new Intent(this , Welcome.class));
    }
}