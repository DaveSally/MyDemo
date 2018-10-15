package com.dave.mydemo.Lesson3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

import com.dave.mydemo.R;

import java.util.ArrayList;
import java.util.List;

import static com.dave.mydemo.Lesson3.FourAdapter.TYPE_COLOR;
import static com.dave.mydemo.Lesson3.FourAdapter.TYPE_IMAGE;
import static com.dave.mydemo.Lesson3.FourAdapter.TYPE_TEXT;

/**
 * @author : dave on 2018/9/28 17:15:34
 * e-mail  : dave.dai@morningtech.com
 * desc    : description
 * version : version
 */
public class FourActivity extends AppCompatActivity {

    private RecyclerView mRvFour;
    private List<FourData> fourData;
    private FourAdapter fourAdapter;

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        initView();
        initData();
    }

    private void initView() {
        mRvFour = findViewById(R.id.rv_four);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRvFour.setLayoutManager(layoutManager);

        fourData = new ArrayList<>();
        fourAdapter = new FourAdapter(this, fourData);
        mRvFour.setAdapter(fourAdapter);

        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRvFour.getAdapter().notifyDataSetChanged();
                mRvFour.scheduleLayoutAnimation();
            }
        });

        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(
                this, R.anim.layout_animation);
        mRvFour.setLayoutAnimation(animationController);
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            if (i == 0) {
                fourData.add(new FourData(TYPE_IMAGE, null));
            } else if (i == 1) {
                fourData.add(new FourData(TYPE_COLOR, null));
            } else {
                fourData.add(new FourData(TYPE_TEXT, "我是第" + i + "调数据"));
            }
        }
    }
}
