package com.codepath.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("vic4PwWzdWuND2jwXqyS4xkHWCoIkmGw5nNTy82w")
                .clientKey("WSNCTglsD8Vfbas2kftDodW6VIVTXrcgHCeUp9qs")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}

