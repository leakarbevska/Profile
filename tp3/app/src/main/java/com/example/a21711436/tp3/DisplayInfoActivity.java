package com.example.a21711436.tp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayInfoActivity extends AppCompatActivity {

    TextView text_summary;
    Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info2);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        this.profile  = bundle.getParcelable("profile");

        text_summary = (TextView) findViewById(R.id.text_summary);
        text_summary.setText("Pseudo: "+profile.getPseudo()
                            +"\nAge: "+profile.getAge()
                            +"\nContact: "+profile.getPhone()
                            +"\nEmail: "+profile.getEmail()
                            +"\nEducation degree: "+profile.getLastDiploma()
                            +"\nKnowledge of the programming languages: "+profile.getProgrammingLanguages()
                            +"\n"+makeNewsletterString()
                            +"\nMore: "+profile.getMoreInfo());

    }

    /*--------------------------------- BUTTON EVENT ----------------------------------*/
    public void edit(View v){
        Intent intent = new Intent(this, DetailedInfoActivity.class);
        intent.putExtra("profile", this.profile);
        intent.putExtra("pseudo",this.profile.getPseudo());
        intent.putExtra("age",this.profile.getAge());
        startActivity(intent);
    }

    /*-------------------------------------- UTILS ----------------------------------------*/
    public String makeNewsletterString(){
        String newsletter = " ";
        if(profile.isReceiveNewsletter()){
            newsletter = " Agrees to recieve newsletter";
        }else{
            newsletter = " Does not agree to recieve newsletter";
        }
        return newsletter;
    }
}
