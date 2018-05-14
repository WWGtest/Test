package com.example.day01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class AddUser extends AppCompatActivity {

    private EditText addusername;
    private EditText addpwd;
    private Button adduser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        addusername = (EditText) findViewById(R.id.addusername);
        addpwd = (EditText) findViewById(R.id.addpwd);
        adduser = (Button) findViewById(R.id.adduser);

        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = addusername.getText().toString().trim();
                String pwd = addpwd.getText().toString().trim();
                Toast.makeText(AddUser.this,pwd,Toast.LENGTH_SHORT).show();

                String url = "http://120.27.23.105/user/reg";

                Toast.makeText(AddUser.this,"点击了",Toast.LENGTH_SHORT).show();
//                DataBean dataBean = new DataBean();
////                if ("0".equals(dataBean.getCode())){
////                    Toast.makeText(AddUser.this,"注册成功",Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(AddUser.this,MainActivity.class);
////                    startActivity(intent);
////                }else if("1".equals(dataBean.getCode())){
////                    Toast.makeText(AddUser.this,dataBean.getMsg(),Toast.LENGTH_SHORT).show();
////                }

                RequestParams params = new RequestParams(url);
                params.addQueryStringParameter("mobile",username);
                params.addQueryStringParameter("password",pwd);
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        //解析result
                        LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
                        if ("0".equals(loginBean.getCode())){
                            Toast.makeText(AddUser.this,"注册成功",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AddUser.this,MainActivity.class);
                            startActivity(intent);
                        }else if("1".equals(loginBean.getCode())){
                            Toast.makeText(AddUser.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
                        }
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
                        Toast.makeText(AddUser.this,"事件结束",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });



    }
}
