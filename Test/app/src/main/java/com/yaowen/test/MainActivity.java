package com.yaowen.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button lockUnlock,testButton;
    private boolean value = false;
    public String testText = "HelloWorld!!!!!!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testButton = (Button) findViewById(R.id.testButton);
        lockUnlock = (Button) findViewById(R.id.lockUnlock);
        lockUnlock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lockUnlock:
                if (value) {
                    value = false;
                    lockUnlock.setText("锁定");
                    Toast.makeText(this, "testButton已经成功激活，其监听功能正常！",
                            Toast.LENGTH_LONG).show();

                } else {
                    value = true;
                    lockUnlock.setText("解锁");
                    Toast.makeText(this, "testButton已经被锁定，该按钮监听功能失效！",
                            Toast.LENGTH_LONG).show();
                }
                lockUnlock(value);
                break;
            default:
                break;
        }
    }

    private void lockUnlock(boolean value) {
        if (value) {
            testButton.setBackgroundResource(R.drawable.lock);
        } else {
            testButton.setBackgroundResource(R.drawable.unlock);
            testButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(MainActivity.this,TestActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
