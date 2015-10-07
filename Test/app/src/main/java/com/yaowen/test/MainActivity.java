package com.yaowen.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button lockUnlock;
    private EditText editText;
    private boolean value = false;
    public String testText = "HelloWorld!!!!!!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//加载布局文件
        editText = (EditText) findViewById(R.id.editText);//初始化editText
        editText.setText(testText);//设置editText内容为“HelloWorld！！！！”
        lockUnlock = (Button) findViewById(R.id.lockUnlock);//初始化lockUnlock按钮
        lockUnlock.setOnClickListener(this);//添加lockUnlock按钮的监听响应

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lockUnlock:
                if (value) {
                    value = false;
                    lockUnlock.setText("锁定");
                    Toast.makeText(this, "editText已经被锁定，您不能修改其内容！",
                            Toast.LENGTH_SHORT).show();
                    //editText.setFocusable(false);

                } else {
                    value = true;
                    lockUnlock.setText("解锁");
                    Toast.makeText(this, "editText已经成功解锁，您可以修改其内容！",
                            Toast.LENGTH_SHORT).show();
                    //editText.setFocusable(true);
                }
                //创建构造方法lockUnlock方法，传入一个value的参数；
                lockUnlock(value);
                break;
            default:
                break;
        }
    }

    private void lockUnlock(boolean value) {
        if (value) {

            //这里实现了EditText的锁定
            editText.setFilters(new InputFilter[]{
                    new InputFilter() {
                        @Override
                        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                            //这里实现了EditText的锁定，无法修改其内容；
                            return source.length() < 1 ? dest.subSequence(dstart, dend) : "";
                        }
                    }
            });
            //editText.clearFocus();
            //editText.setInputType(InputType.TYPE_NULL);//EditText始终不弹出软件键盘
        } else {
            editText.setFilters(new InputFilter[]{
                    new InputFilter() {
                        @Override
                        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                            //这里实现了EditText的解除锁定，可以修改其内容；
                            return null;
                        }
                    }
            });
        }
    }
}
