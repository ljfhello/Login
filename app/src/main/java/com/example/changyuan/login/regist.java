package com.example.changyuan.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import static android.R.attr.password;
import static com.example.changyuan.login.R.id.btn_login;

public class regist extends Activity {
    private EditText userName, password,quepass;
    private ImageButton btnQuit;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.regist);
        userName = (EditText) findViewById(R.id.et_zhr);
        password = (EditText) findViewById(R.id.et_mimar);
        quepass=(EditText) findViewById(R.id.et_quer);
        btnQuit = (ImageButton)findViewById(R.id.img_btn);
        button=(Button)findViewById(R.id.btn_regist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(regist.this,"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(regist.this,LoginActivity.class);
                regist.this.startActivity(intent);
            }

        });
    }
}
