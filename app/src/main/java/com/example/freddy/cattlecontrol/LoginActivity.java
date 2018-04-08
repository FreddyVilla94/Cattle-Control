package com.example.freddy.cattlecontrol;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Freddy on 7/4/2018.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.login_email) EditText loginEmail;
    @BindView(R.id.login_password) EditText loginPassword;
    @BindView(R.id.btn_login) Button btnLogin;
    @BindView(R.id.register_event) TextView registerEvent;

    // Variable used to hide keyboard
    private ScrollView activityLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        activityLogin = (ScrollView) findViewById(R.id.activity_login);
        activityLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboardOnTouchView(v);
                return false;
            }
        });

        btnLogin.setOnClickListener(this);
        registerEvent.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                if(isNetAvailed()){
                    if(loginEmail.getText().toString().equals("") || loginPassword.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.login_activity_invalid_data), Toast.LENGTH_LONG).show();
                    }else if(!loginEmail.getText().toString().equals("admin") && loginPassword.getText().toString().equals("123")){
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.login_activity_invalid_data), Toast.LENGTH_LONG).show();
                    }else{
                        Intent intentMenu = new Intent(this,MainActivity.class);
                        startActivity(intentMenu);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.login_activity_net_connection), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.register_event:
                Intent intentRegister = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intentRegister);
                break;
            default:
                break;
        }
    }
    private boolean isNetAvailed() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * Hide keyboard when view is touched
     * @param view is the scrollview loginActivity
     */
    public void hideKeyboardOnTouchView(View view) {

        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

    }
}
