package com.dave.mydemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dave.mydemo.LessonOne.FirstActivity;

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
            new DemoInfo(FirstActivity.class)
    };
}