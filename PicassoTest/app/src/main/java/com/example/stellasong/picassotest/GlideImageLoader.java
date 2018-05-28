package com.example.stellasong.picassotest;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.alley.van.helper.VanImageLoader;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

import static android.widget.Toast.LENGTH_LONG;

public class GlideImageLoader extends ImageLoader implements VanImageLoader {
    private static final String TAG = "GlideImageLoader";

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Picasso.get().load((Uri)path).into(imageView);
    }

    @Override
    public void loadThumbnail(Context context, int resize, ImageView imageView, final Uri uri) {
        final long currentLoadStartTime = System.currentTimeMillis();
        Picasso.get()
                .load(uri)
                .resize(resize, resize)
                .centerCrop()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        long countTime = System.currentTimeMillis() - currentLoadStartTime;
                        if (countTime >= 500) {
                            Log.i(TAG, "Load Too Slow!!!");
                        }
                        Log.i(TAG, "Load file " + uri.toString() + " count time: " + countTime + "ms");
                    }

                    @Override
                    public void onError(Exception e) {
                    }
                });
    }

    @Override
    public void loadAnimatedGifThumbnail(Context context, int resize, ImageView imageView,
                                         Uri uri) {
        Picasso.get()
                .load(uri)
                .resize(resize, resize)
                .centerCrop()
                .into(imageView);
    }

    @Override
    public void loadImage(Context context, int resizeX, int resizeY, ImageView imageView, Uri uri) {
        Picasso.get()
                .load(uri)
                .resize(resizeX, resizeY)
                .into(imageView);
    }

    @Override
    public void loadAnimatedGifImage(Context context, int resizeX, int resizeY, ImageView imageView, Uri uri) {
        Picasso.get()
                .load(uri)
                .resize(resizeX, resizeY)
                .into(imageView);
    }

    @Override
    public boolean supportAnimatedGif() {
        return false;
    }

}
