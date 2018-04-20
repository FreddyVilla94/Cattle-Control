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

import com.example.freddy.cattlecontrol.Class.Conector;
import com.example.freddy.cattlecontrol.Class.RetrofitClient;
import com.example.freddy.cattlecontrol.Class.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Freddy on 7/4/2018.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    RetrofitClient retrofitClient;

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
        retrofitClient = new RetrofitClient();
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
                    }else{
                        this.retrofitClient.getService().getUsers().enqueue(new Callback<ArrayList<User>>() {
                            @Override
                            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                                ArrayList<User> userArrayList = response.body();
                                int position = userIsValid(loginEmail.getText().toString(),loginPassword.getText().toString(), userArrayList);
                                if(position != 0){
                                    //Toast.makeText(getApplicationContext(),userArrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
                                    Intent intentMain = new Intent(getApplicationContext(), MainActivity.class);
                                    Conector.setUser(userArrayList.get(position));
                                    startActivity(intentMain);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(),R.string.login_activity_error_authenfication,Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

                            }
                        });
                        /*
                        Intent intentMenu = new Intent(this,MainActivity.class);
                        startActivity(intentMenu);*/
                    }
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.login_activity_net_connection), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.register_event:
                Intent intentRegister = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intentRegister);
                finish();
                break;
            default:
                break;
        }
    }

    private int userIsValid(String email, String pass, ArrayList<User> body) {
        for (int i = 0; i < body.size(); i++) {
            if ((email.equals(body.get(i).getEmail()) || email.equals(body.get(i).getUsername())) && pass.equals(body.get(i).getPassword())){
                return i;
            }
        }
        return 0;
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
