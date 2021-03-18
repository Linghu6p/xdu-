package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class liveActivity extends AppCompatActivity {
    private UseFunction useFunction;
    private Button liveButton;
    private Button informationButton;
    private Button squareButton;
    private Button messageButton;
    private Button mineButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        useFunction = new UseFunction();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_layout);
        liveButton = (Button) findViewById(R.id.live_p);
        useFunction.setColor(liveButton.getCompoundDrawables(), Color.RED);

        informationButton = (Button) findViewById(R.id.information_p);
        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(liveActivity.this, informationActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        squareButton = (Button) findViewById(R.id.square_p);
        messageButton = (Button) findViewById(R.id.message_p);
        mineButton = (Button) findViewById(R.id.mine_p);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0,0);
    }

}