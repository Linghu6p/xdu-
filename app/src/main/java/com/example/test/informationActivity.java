package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import com.example.test.Information.Information;
import com.example.test.Information.InformationAdapter;

import java.util.ArrayList;
import java.util.List;

public class informationActivity extends AppCompatActivity {
    private UseFunction useFunction;
    private Button liveButton;
    private Button informationButton;
    private Button squareButton;
    private Button messageButton;
    private Button mineButton;
    private InformationAdapter adapter;
    private List<Information> mInformation = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        useFunction = new UseFunction();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.inf_layout);

        ininInformation();//加载界面信息
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.live_main);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Information information = mInformation.get(position);
                if (information.getType() == Information.TYPE_CLICK) {
                    //Log.d("Linghu", Integer.toString(information.getType()));
                    return 1;
                } else if (information.getType() == Information.TYPE_INFORMATION) {
                    return 3;
                } else if (information.getType() == Information.TYPE_TIP) {
                    return 3;
                } else {
                    return 0;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new InformationAdapter(mInformation);
        InformationAdapter adapter = new InformationAdapter(mInformation);
        recyclerView.setAdapter(adapter);


        informationButton = (Button) findViewById(R.id.information_p);
        useFunction.setColor(informationButton.getCompoundDrawables(), Color.RED);//当在该界面 下面图标设为红色
        liveButton = (Button) findViewById(R.id.live_p);
        liveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(informationActivity.this, liveActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }


    private void ininInformation() {
        Information information = new Information("组队",
                R.drawable.ic_fas_fa_users, Information.TYPE_CLICK);
        mInformation.add(information);
        Information information1 = new Information("二手",
                R.drawable.ic_far_fa_handshake, Information.TYPE_CLICK);
        mInformation.add(information1);
        Information information2 = new Information("招聘",
                R.drawable.ic_fas_fa_chart_line, Information.TYPE_CLICK);
        mInformation.add(information2);
        Information information3 = new Information("失物招领",
                R.drawable.ic_md_record_voice_over, Information.TYPE_CLICK);
        mInformation.add(information3);
        Information information4 = new Information("快递代取",
                R.drawable.ic_fas_fa_truck, Information.TYPE_CLICK);
        mInformation.add(information4);
        Information information5 = new Information("外卖代购",
                R.drawable.ic_md_directions_run, Information.TYPE_CLICK);
        mInformation.add(information5);
        Information information7 = new Information("信息综合发布", Information.TYPE_TIP);
        mInformation.add(information7);
        Information information6 = new Information(
                "张狗蛋", R.drawable.test, "我要出售二手书",
                R.drawable.testbook, Information.TYPE_INFORMATION);
        mInformation.add(information6);
        mInformation.add(information6);
        mInformation.add(information6);
        mInformation.add(information6);
        mInformation.add(information6);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}