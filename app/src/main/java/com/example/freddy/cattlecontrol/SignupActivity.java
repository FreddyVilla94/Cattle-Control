package com.example.freddy.cattlecontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freddy.cattlecontrol.Class.RetrofitClient;
import com.example.freddy.cattlecontrol.Class.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    RetrofitClient retrofitClient;
    @BindView(R.id.register_name) EditText registerName;
    @BindView(R.id.register_lastname) EditText registerLastname;
    @BindView(R.id.register_email) EditText registerEmail;
    @BindView(R.id.register_username) EditText registerUsername;
    @BindView(R.id.register_password) EditText registerPassword;
    @BindView(R.id.register_confirm_password) EditText registerConfirmPassword;
    @BindView(R.id.btn_register) Button registerBtn;
    @BindView(R.id.login_event) TextView registerEvent;
    static boolean existe = false;
    // Variable used to hide keyboard
    private ScrollView activitySignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        retrofitClient = new RetrofitClient();
        activitySignup = (ScrollView) findViewById(R.id.sign_up_activity);
        activitySignup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboardOnTouchView(v);
                return false;
            }
        });
        registerBtn.setOnClickListener(this);
        registerEvent.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                if(registerName.getText().toString().equals("")){
                    registerName.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.sign_up_activity_invalid_name), Toast.LENGTH_LONG).show();
                }else if(registerLastname.getText().toString().equals("")){
                    registerLastname.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.sign_up_activity_invalid_lastname), Toast.LENGTH_LONG).show();
                }else if(registerEmail.getText().toString().equals("")){
                    registerEmail.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.sign_up_activity_invalid_email), Toast.LENGTH_LONG).show();
                }else if(registerUsername.getText().toString().equals("")){
                    registerUsername.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.sign_up_activity_invalid_username), Toast.LENGTH_LONG).show();
                }else if(registerPassword.getText().toString().equals("")){
                    registerPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.sign_up_activity_invalid_password), Toast.LENGTH_LONG).show();
                }else if(registerConfirmPassword.getText().toString().equals("")){
                    registerConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.sign_up_activity_invalid_confirm_password), Toast.LENGTH_LONG).show();
                }else if(!registerPassword.getText().toString().equals(registerConfirmPassword.getText().toString())){
                    registerPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    registerConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.sign_up_activity_invalid_passwords_do_not_match), Toast.LENGTH_LONG).show();
                }
                else{
                    final String username = registerUsername.getText().toString();
                    final String email = registerEmail.getText().toString();

                    Call<ArrayList<User>> arrayListUser =  this.retrofitClient.getService().getUsers();
                    arrayListUser.enqueue(new Callback<ArrayList<User>>() {
                        @Override
                        public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                            ArrayList<User> userArrayList = response.body();
                            if(!validUsernameEmail(username,email,userArrayList)){
                                User user = new User(registerName.getText().toString(), registerLastname.getText().toString(),
                                        registerEmail.getText().toString(), registerUsername.getText().toString(),
                                        registerPassword.getText().toString());
                                //Toast.makeText(getApplicationContext(),user.toString(),Toast.LENGTH_SHORT).show();
                                Call<User> userCall = retrofitClient.getService().createUser(user);
                                userCall.enqueue(new Callback<User>() {
                                    @Override
                                    public void onResponse(Call<User> call, Response<User> response) {
                                        if (response.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), R.string.login_activity_signing_in, Toast.LENGTH_SHORT).show();
                                            Intent intentRegister = new Intent(getApplicationContext(), MainActivity.class);
                                            startActivity(intentRegister);
                                        } else {
                                            Toast.makeText(getApplicationContext(), R.string.sign_up_activity_error_signing_up, Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<User> call, Throwable t) {
                                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                registerEmail.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                                registerUsername.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                                Toast.makeText(getApplicationContext(),"El nombre de usuario o email ya existen",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArrayList<User>> call, Throwable t) {

                        }
                    });
                     /*   User user = new User(registerName.getText().toString(), registerLastname.getText().toString(),
                                registerEmail.getText().toString(), registerUsername.getText().toString(),
                                registerPassword.getText().toString());


                        Call<User> userCall = this.retrofitClient.getService().createUser(user);
                        userCall.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), R.string.login_activity_signing_in, Toast.LENGTH_SHORT).show();
                                    Intent intentRegister = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intentRegister);
                                } else {
                                    Toast.makeText(getApplicationContext(), R.string.sign_up_activity_error_signing_up, Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });*/
                }

                break;
            case R.id.register_event:

                break;
            default:
                break;
        }
    }

    private boolean validUsernameEmail(String username, String email, ArrayList<User> userArrayList) {
        for(int i = 0; i < userArrayList.size(); i++){
            if(username.equals(userArrayList.get(i).getUsername()) || email.equals(userArrayList.get(i).getEmail())){
                return true;
            }
        }
        return false;
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
