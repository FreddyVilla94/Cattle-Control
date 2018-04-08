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

import com.example.freddy.cattlecontrol.Class.ApiCattleCow;
import com.example.freddy.cattlecontrol.Class.RetrofitClient;
import com.example.freddy.cattlecontrol.Class.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

    // Variable used to hide keyboard
    private ScrollView activitySignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

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
                    registerConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    registerConfirmPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.app_alert, 0);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.sign_up_activity_invalid_passwords_do_not_match), Toast.LENGTH_LONG).show();
                }
                else{
                    Retrofit retrofit = retrofitClient.getClient();
                    User user = new User(registerName.getText().toString(),registerLastname.getText().toString(),
                            registerEmail.getText().toString(),registerUsername.getText().toString(),
                            registerPassword.getText().toString());
                    ApiCattleCow userService = retrofit.create(ApiCattleCow.class);
                    /*Call<List<User>> listCall = userService.getData();
                    listCall.enqueue(new Callback<List<User>>() {
                        @Override
                        public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                            if (response.isSuccessful()) {
                                List<User> userList = new ArrayList<>();
                                userList = response.body();
                                userList.toString();
                            }else{
                                Toast.makeText(getApplicationContext(),"NO",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<User>> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"NO1",Toast.LENGTH_SHORT).show();
                        }
                    });*/
                    userService.createUser(user).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(getApplicationContext(),R.string.login_activity_signing_in,Toast.LENGTH_SHORT).show();
                                Intent intentRegister = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intentRegister);
                            }else{
                                Toast.makeText(getApplicationContext(),R.string.sign_up_activity_error_signing_up,Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                        }
                    });
                }
                break;
            case R.id.register_event:
                break;
            default:
                break;
        }
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
