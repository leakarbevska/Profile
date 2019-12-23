package com.example.a21711436.tp3;

import android.os.Parcel;
import android.os.Parcelable;

public class Profile implements Parcelable {

    private String pseudo, email, phone, age, lastDiploma, moreInfo, programmingLanguages;
    private boolean receiveNewsletter;
    //private boolean htmlCss, android, php, java, javascript, python;

    public Profile(String pseudo, String age, String email, String phone, String lastDiploma, String moreInfo, String programmingLanguages, Boolean receiveNewsletter){
        this.pseudo = pseudo;
        this.email  = email;
        this.phone = phone;
        this.age    = age;
        this.lastDiploma = lastDiploma;
        this.moreInfo = moreInfo;
        this.programmingLanguages = programmingLanguages;
        this.receiveNewsletter = receiveNewsletter;
    }

    protected Profile(Parcel in) {
        pseudo = in.readString();
        email  = in.readString();
        phone  = in.readString();
        age    = in.readString();
        lastDiploma = in.readString();
        moreInfo = in.readString();
        programmingLanguages = in.readString();
        receiveNewsletter = in.readByte() != 0;
        /*htmlCss  = in.readByte() != 0;
        android  = in.readByte() != 0;
        php  = in.readByte() != 0;
        java = in.readByte() != 0;
        javascript = in.readByte() != 0;
        python = in.readByte() != 0;*/
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAge() {
        return age;
    }

    public String getLastDiploma() {
        return lastDiploma;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public String getProgrammingLanguages() {
        return programmingLanguages;
    }

    public boolean isReceiveNewsletter() {
        return receiveNewsletter;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pseudo);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(age);
        dest.writeString(lastDiploma);
        dest.writeString(moreInfo);
        dest.writeString(programmingLanguages);
        dest.writeByte((byte) (receiveNewsletter ? 1 : 0));
        /*dest.writeByte((byte) (htmlCss ? 1 : 0));
        dest.writeByte((byte) (android ? 1 : 0));
        dest.writeByte((byte) (php ? 1 : 0));
        dest.writeByte((byte) (java ? 1 : 0));
        dest.writeByte((byte) (javascript ? 1 : 0));
        dest.writeByte((byte) (python ? 1 : 0));*/
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}
