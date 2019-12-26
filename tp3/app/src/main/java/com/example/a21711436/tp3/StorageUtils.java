package com.example.a21711436.tp3;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.json.JSONObject;

public class StorageUtils {
    private static final String SHARED_PREF_NAME = "mainBundle";

    public static void saveObjectToDisk(String key, Object o) {
        SharedPreferences prefs = AppClass.getInstance().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(key, new Gson().toJson(o)).apply();
    }

    public static void deleteObjectFromDisk(String key) {
        SharedPreferences prefs = AppClass.getInstance().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(key, null).apply();
    }

    public static Object loadFromDisk(String key, Class classObj) {
        SharedPreferences prefs = AppClass.getInstance().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Gson().fromJson(prefs.getString(key,""), classObj);
    }
}
