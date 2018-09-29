package com.dave.mydemo.Lesson1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dave.mydemo.R;

/**
 * @author : dave on 2018/9/12 15:10:29
 * e-mail  : dave.dai@morningtech.com
 * desc    : description
 * version : version
 */
public class FirstActivity extends AppCompatActivity {

    public static final String TAG = "FirstActivity";

    //创建
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //初始化一些总体资源比如setContentView或者加载一些关于这个Activity的全局数据
        Log.e(TAG, "onCreate");

        Button tvJumpSecond = findViewById(R.id.tv_jump_second);
        tvJumpSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });

        Button tvChange = findViewById(R.id.tv_change);
        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLandscape(FirstActivity.this)) {
                    setProtrait();
                } else if (isPortrait(FirstActivity.this)) {
                    setLandscape();
                }
            }
        });
    }

    //启动 但是前台不可见 系统可见
    @Override
    protected void onStart() {
        super.onStart();
        //加载一些当Activity可见时，才需要加载的数据，或者注册一个广播，监听UI的变化来刷新界面
        Log.e(TAG, "onStart");
    }

    //重新运行 前台可见
    @Override
    protected void onResume() {
        super.onResume();
        //进入前台获得焦点
        Log.e(TAG, "onResume");
    }

    //暂停
    @Override
    protected void onPause() {
        super.onPause();
        //退出前台失去焦点 绝对不可以进行太耗时的操作
        Log.e(TAG, "onPause");
    }

    //重新开始
    @Override
    protected void onRestart() {
        super.onRestart();
        //Activity正在重新启动
        Log.e(TAG, "onRestart");
    }

    //停止 不可见状态
    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //做一些释放资源相关的操作
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //自动保存activity中的某些状态数据
        Log.e(TAG, "onSaveInstanceState");
    }

    /**
     * 是横屏？
     */
    public static boolean isLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /**
     * 是竖屏？
     */
    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    /**
     * 设置横屏
     */
    private void setLandscape() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
    }

    /**
     * 设置竖屏
     */
    private void setProtrait() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
