package com.example.getimei;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.provider.Settings.Secure;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.idTextView);
        String id = Settings.Secure.getString(getContentResolver(), Secure.ANDROID_ID);
        
        textView.setText(id);

    }
    private boolean isPackageInstalled(String packageName, PackageManager packageManager){
        try{
            packageManager.getPackageInfo(packageName,0);
            return true;
        }catch (PackageManager.NameNotFoundException e){
            return false;
        }
    }
}
