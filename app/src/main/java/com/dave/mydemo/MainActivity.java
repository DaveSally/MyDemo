package com.dave.mydemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dave.mydemo.Lesson1.FirstActivity;
import com.dave.mydemo.Lesson2.ThirdActivity;
import com.dave.mydemo.Lesson3.FourActivity;

/**
 * @author : dave on 2018/9/12 15:02:32
 * e-mail  : dave.dai@morningtech.com
 * desc    : description
 * version : version
 */
public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] data = getResources().getStringArray(R.array.main_lists);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(MainActivity.this, DEMOS[position].demoClass);
        startActivity(intent);
    }

    /**
     * 把每个activity转成class
     */
    private static class DemoInfo {
        private final Class<? extends android.app.Activity> demoClass;

        public DemoInfo(Class<? extends android.app.Activity> demoClass) {
            this.demoClass = demoClass;
        }
    }

    /**
     * 把每个activity转成xxx.class
     */
    private static final DemoInfo[] DEMOS = {
            new DemoInfo(FirstActivity.class),
            new DemoInfo(ThirdActivity.class),
            new DemoInfo(FourActivity.class)
    };
}