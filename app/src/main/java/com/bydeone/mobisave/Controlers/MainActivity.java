package com.bydeone.mobisave.Controlers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bydeone.mobisave.Models.EmailValidator;
import com.bydeone.mobisave.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Logger for this class.
    private static final String TAG = "MainActivity";
    // The input field where the user enters his email.
    private EditText mEmailLogin;
    // The input field where the user enters his email.
    private Button mBoutonLogin;
    // The validator for the email input field.
    private EmailValidator mEmailValidator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBoutonLogin = (Button) findViewById(R.id.butConnexion);
        mEmailLogin = (EditText) findViewById(R.id.edtvUserName);
        // Setup field validators.
        mEmailValidator = new EmailValidator();
        mEmailLogin.addTextChangedListener(mEmailValidator);

        mBoutonLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == mBoutonLogin){
            if (!mEmailValidator.isValid()) {
                mEmailLogin.setError("Invalid email");
                Log.w(TAG, "Not saving personal information: Invalid email");
                Toast.makeText(this, "username not valid.", Toast.LENGTH_LONG).show();
                return;
            }

        }
    }
}
