package com.example.day01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {

    private String url = "http://120.27.23.105/user/login";
    private EditText pwd;
    private EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        pwd = findViewById(R.id.pwd);

        RequestParams params = new RequestParams(url);
        params.addQueryStringParameter("username",username.getText().toString().trim());
        params.addQueryStringParameter("password",pwd.getText().toString().trim());
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析result
            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });

    }
}
