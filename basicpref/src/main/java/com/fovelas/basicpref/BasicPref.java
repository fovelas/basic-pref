package com.fovelas.basicpref;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

public final class BasicPref
{
    private static volatile BasicPref instance;
    private final WeakReference<Context> context;
    private final SharedPreferences sharedPref;
    private final SharedPreferences.Editor editor;

    private BasicPref(
        @NonNull Context context
    )
    {
        this.context = new WeakReference<>(context);
        this.sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        this.editor = sharedPref.edit();
    }

    public static BasicPref getInstance(
        @NonNull Context context
    )
    {
        if (instance == null)
        {
            synchronized (BasicPref.class)
            {
                if (instance == null) instance = new BasicPref(context);
            }
        }

        return instance;
    }

    private Context getContext()
    {
        return context.get();
    }

    public void setBoolean(
        @NonNull String key,
        boolean value
    )
    {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void setFloat(
        @NonNull String key,
        float value
    )
    {
        editor.putFloat(key, value);
        editor.apply();
    }

    public void setInt(
        @NonNull String key,
        int value
    )
    {
        editor.putInt(key, value);
        editor.apply();
    }

    public void setLong(
        @NonNull String key,
        long value
    )
    {
        editor.putLong(key, value);
        editor.apply();
    }

    public void setString(
        @NonNull String key,
        @NonNull String value
    )
    {
        editor.putString(key, value);
        editor.apply();
    }

    public boolean getBoolean(
        @NonNull String key,
        boolean defValue
    )
    {
        return sharedPref.getBoolean(key, defValue);
    }

    public float getFloat(
        @NonNull String key,
        float defValue
    )
    {
        return sharedPref.getFloat(key, defValue);
    }

    public int getInt(
        @NonNull String key,
        int defValue
    )
    {
        return sharedPref.getInt(key, defValue);
    }

    public long getLong(
        @NonNull String key,
        long defValue
    )
    {
        return sharedPref.getLong(key, defValue);
    }

    public String getString(
        @NonNull String key,
        @NonNull String defValue
    )
    {
        return sharedPref.getString(key, defValue);
    }

    public void remove(
        @NonNull String key
    )
    {
        editor.remove(key);
        editor.apply();
    }

    public void clear()
    {
        editor.clear();
        editor.apply();
    }
}