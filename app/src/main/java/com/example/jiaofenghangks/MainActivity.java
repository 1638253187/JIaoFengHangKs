package com.example.jiaofenghangks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 跳过
     */
    private Button mBtnTiao;
    private ImageView mIvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnTiao = (Button) findViewById(R.id.btn_tiao);
        mBtnTiao.setOnClickListener(this);
        mIvTimer = (ImageView) findViewById(R.id.iv_timer);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        mIvTimer.startAnimation(animation);
        mIvTimer.setAnimation(animation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_tiao:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
                 break;
        }
    }
}
