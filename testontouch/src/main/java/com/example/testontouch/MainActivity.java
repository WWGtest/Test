package com.example.testontouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyView but;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //调用自定义接口
        but.setClickListion(new MyView.IsClickState() {
            @Override
            public void showState(boolean isClick) {
                //根据状态值显示信息
                if (isClick){
                    text.setText("1");
                }else {
                    text.setText("2");
                }
            }
        });

    }

    //初始化控件
    private void initView() {
        but = (MyView) findViewById(R.id.but);
        text = (TextView) findViewById(R.id.text);
    }
}
