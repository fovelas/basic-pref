package com.fovelas.basicpref;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public final class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BasicPref.getInstance(MainActivity.this).setString("example_key", "this is value");
        String value = BasicPref.getInstance(MainActivity.this).getString("example_key", "default value");
        System.out.println(value);
    }
}