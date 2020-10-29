package com.osg.maptest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String url = "nmap://actionPath?parameter=value&appname=NaverMapTest";
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        intent.addCategory(Intent.CATEGORY_BROWSABLE);
//
//        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
//        if (list == null || list.isEmpty()) {
//            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.nhn.android.nmap"));
//            this.startActivity(intent1);
//        } else {
//            startActivity(intent);
//        }

        Retrofit retrofit= new RetrofitHelper().getRetrofit();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<String> call = service.getGeo("숙명여자대학교");

//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
////                Toast.makeText(MainActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
//                Log.i("geo", response.body());
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

        Call<String> call2 = service.getDir("127.1058342,37.359708", "129.075986,35.179470");
        call2.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("dir", response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


    }
}