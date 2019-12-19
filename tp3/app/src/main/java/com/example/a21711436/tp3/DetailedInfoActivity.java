package com.example.a21711436.tp3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class DetailedInfoActivity extends Activity {

    TextView text_profileInfo;
    EditText text_moreInfo;
    CheckBox check_htmlCss, check_android, check_php, check_java, check_javascript, check_python;
    RadioButton radio_bac, radio_highSchool, radio_master, radio_phd;
    Switch switch_newsletter;
    String name, age, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        check_htmlCss = (CheckBox) findViewById(R.id.check_htmlcss);
        check_android = (CheckBox) findViewById(R.id.check_android);
        check_php     = (CheckBox) findViewById(R.id.check_php);
        check_java    = (CheckBox) findViewById(R.id.check_java);
        check_javascript = (CheckBox) findViewById(R.id.check_javascript);
        check_python  = (CheckBox) findViewById(R.id.check_python);

        radio_bac    = (RadioButton) findViewById(R.id.radio_bac);
        radio_highSchool = (RadioButton) findViewById(R.id.radio_highSchool);
        radio_master = (RadioButton) findViewById(R.id.radio_Master);
        radio_phd    = (RadioButton) findViewById(R.id.radio_phd);

        switch_newsletter = (Switch)findViewById(R.id.switch_newsletter);
        text_moreInfo     = (EditText)findViewById(R.id.text_moreInfo);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        this.name  = bundle.getString("pseudo");
        this.age   = bundle.getString("age");
        this.email = bundle.getString("email");
        this.phone = bundle.getString("phone");

        text_profileInfo = (TextView) findViewById(R.id.text_summary);
        text_profileInfo.setText("Profile of "+name+" -"+age+" years");

        //fillInfoIfExist();
    }

    public void validate(View v){
        Intent intent = new Intent(this, DisplayInfoActivity.class);
        intent.putExtra("profile", new Profile(this.name, this.age, this.email, this.phone, getRadioGroupDiplomaValue(), text_moreInfo.getText().toString(), getCheckedProgrammingLanguages(), switch_newsletter.isChecked()));
        startActivity(intent);
    }

    /*---------------------------------- UTILS --------------------------------*/
    public String getCheckedProgrammingLanguages(){
        String result = "";

        if(check_htmlCss.isChecked()){
            result += check_htmlCss.getText().toString()+" ";
        }if(check_android.isChecked()){
            result += check_android.getText().toString()+" ";
        }if(check_php.isChecked()){
            result += check_php.getText().toString()+" ";
        }if(check_java.isChecked()){
            result += check_java.getText().toString()+" ";
        }if(check_javascript.isChecked()){
            result += check_javascript.getText().toString()+" ";
        }if(check_python.isChecked()){
            result += check_python.getText().toString();
        }

        return result;
    }

    public String getRadioGroupDiplomaValue(){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.group_diploma);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        String result = "";
        if(selectedId != -1){
            switch (selectedId) {
                case R.id.radio_bac:
                    result = radio_bac.getText().toString();
                    break;
                case R.id.radio_highSchool:
                    result = radio_highSchool.getText().toString();
                    break;
                case R.id.radio_Master:
                    result = radio_master.getText().toString();
                    break;
                case R.id.radio_phd:
                    result = radio_phd.getText().toString();
                    break;
            }
        }
        return result;
    }


    public void fillInfoIfExist(){
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Profile profile = bundle.getParcelable("profile");
        if(profile != null){
            this.text_moreInfo.setText(profile.getMoreInfo());
        }
    }
}
