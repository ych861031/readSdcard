package com.example.yangchunghsuan.readsdcard;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permission = ActivityCompat.checkSelfPermission(this,READ_EXTERNAL_STORAGE);
        if (permission!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {READ_EXTERNAL_STORAGE},1);
        }else {
//            File[] file = Environment.getExternalStorageDirectory().listFiles();
//            for (File f:file) {
//                System.out.println(f);
//            }
        }

        //sd卡真實路徑
        File filePath = new File("/storage/9016-4EF8");
        File[] fileList = filePath.listFiles();
        for (int i =0;i<fileList.length;i++){
            String name = fileList[i].getName();

            try{
                if(name.substring(name.length()-3).equals("mp3")){
                    System.out.println(name);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
