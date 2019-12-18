package com.example.a21711436.tp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayInfoActivity extends AppCompatActivity {

    TextView text_summary;
    Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info2);

        text_summary = (TextView) findViewById(R.id.text_summary);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        this.profile  = bundle.getParcelable("profile");

        String newsletter = " ";
        if(profile.isReceiveNewsletter()){
            newsletter = " Agrees to recieve newsletter";
        }else{
            newsletter = " Does not agree to recieve newsletter";
        }

        text_summary.setText(" Pseudo:"+profile.getPseudo()+
                " /n Age: "+profile.getAge()
                +"/n Contact:"+profile.getPhone()+" "+profile.getEmail()
                +"/n Education degree: "+profile.getLastDiploma()
                +"/n Knowledge of the programming languages :"+profile.getProgrammingLanguages()
                +"/n "+newsletter);

    }
}
