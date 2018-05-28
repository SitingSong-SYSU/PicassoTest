package com.example.stellasong.picassotest;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.CallSuper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alley.van.VanGogh;
import com.alley.van.helper.VanCropType;
import com.alley.van.helper.VanMediaFilter;
import com.alley.van.helper.VanMediaType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected String TAG = this.getClass().getSimpleName();
    private static final int REQUEST_CODE_CHOOSE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addPicasso();
            }
        });
    }

    public void addPicasso() {
        VanGogh.from(MainActivity.this)
                .choose(VanMediaType.ofAll())
                .countable(false)
                .rowCount(3)
                .cameraVisible(true, getPackageName())
                .withResultSize(1024, 1024)
                .cropEnable(true, VanCropType.CROP_TYPE_RECTANGLE)
                .theme(R.style.VanTheme_Dracula)
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                .thumbnailScale(0.85f)
                .imageLoader(new GlideImageLoader())
                .forResult(REQUEST_CODE_CHOOSE);
    }

}
