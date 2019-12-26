package com.example.a21711436.tp3;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class InitialInfoActivity extends AppCompatActivity {
    TextView text_email, text_pseudo, text_age, text_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_age    = (TextView) findViewById(R.id.text_age);
        text_pseudo = (TextView) findViewById(R.id.text_pseudo);
        text_email  = (TextView) findViewById(R.id.text_email);
        text_phone  = (TextView) findViewById(R.id.text_phone);
        loadExistingProfileData();
    }

    public void loadExistingProfileData() {
        Profile profile = Profile.loadFromDisk();
        if(profile != null) {
            startDisplayInfoActivity(profile);
        }
    }

    private void startDisplayInfoActivity(Profile profile) {
        Intent intent = new Intent(this, DisplayInfoActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Profile.KEY_PROFILE, (Parcelable) profile);
        startActivity(intent);
        finish();
    }

    /*----------------------------- BUTTON EVENT -----------------------------*/
    public void saveAndContinue(View v){
        if(checkValid()){
            Intent intent = new Intent(this, DetailedInfoActivity.class);

            intent.putExtra("pseudo", text_pseudo.getText().toString());
            intent.putExtra("age", text_age.getText().toString());
            intent.putExtra("email", text_email.getText().toString());
            intent.putExtra("phone", text_phone.getText().toString());

            startActivity(intent);
        }
    }

    /*---------------------------------- UTILS -------------------------------*/
    public void checkProfileAlreadySubmit(){

    }

    public boolean checkValid(){
        String error = getError();
        if(TextUtils.isEmpty(error)){
            return true;
        }else {
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), error, Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
        return false;
    }

    public String getError(){
        String error = "";
        if(TextUtils.isEmpty(text_age.getText().toString())){
            error += "Age cannot be empty!";
        }else{
            try{
                int num = Integer.parseInt(text_age.getText().toString());
                if( num > 120){
                    error += "Age cannot be bigger than 120! ";
                }
            }catch (NumberFormatException e) {
                error += "Age should be an integer! ";
            }
        }if(TextUtils.isEmpty(text_pseudo.getText().toString())){
            error += "Pseudo cannot be empty! ";
        }if(TextUtils.isEmpty(text_email.getText().toString())){
            error += "Email cannot be empty! ";
        }if(TextUtils.isEmpty(text_phone.getText().toString())){
            error += "Phone cannot be empty!";
        }
        return error;
    }
}
