package com.example.ba.myjacksondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ba.myjacksondemo.json_tool.JsonUitl;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RequestBody requestBody = new FormBody.Builder()
                .add("mobile", "123456")
                .add("loginPassword", getSignPwd("123"))
                .build();

        Log.d("ssssss", "passw: "+getSignPwd("123"));

        final Request request = new Request.Builder()
                .url("http://120.77.44.70:80/Express/user/User_loginByPwd.action")
                .post(requestBody)
                .build();

        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("sssssss", "错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("sssssss", "onResponse: "+response.body().string());

            }
        });

        MyBean bean=new MyBean();
        bean.setName("里哈哈");
        bean.setAge(10);

        MyBean bt=new MyBean();
        bt.setName("很好");
        bt.setAge(40);

        bean.setBean(bt);

       String s= JsonUitl.getJsonStringFromObj(bean);
        Log.d("ssssss", "onCreate: "+s);
    }

    /**
     * 密码加密
     *
     * @param pwd
     * @return
     */
    public static String getSignPwd(String pwd) {
        try {
            if (pwd == null || "".equals(pwd)) {
                return "";
            }
            MessageDigest md = MessageDigest.getInstance("SHA");
            pwd = toHex(md.digest(pwd.getBytes()));
            return pwd;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String toHex(byte[] buf) {
        if(buf == null) {
            return "";
        } else {
            StringBuffer result = new StringBuffer(2 * buf.length);

            for(int i = 0; i < buf.length; ++i) {
                appendHex(result, buf[i]);
            }

            return result.toString();
        }
    }

    private static void appendHex(StringBuffer sb, byte b) {
        String HEX = "0123456789ABCDEF";
        sb.append("0123456789ABCDEF".charAt(b >> 4 & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }
}
