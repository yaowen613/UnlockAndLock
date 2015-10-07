package com.yaowen.test;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TestActivity extends Activity implements View.OnClickListener {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        editText= (EditText) findViewById(R.id.editText_test);
        editText.setText("HelloWorld!!!!");
        //editText.clearFocus();
        Button btn1= (Button) this.findViewById(R.id.btn1);
        Button btn2= (Button) this.findViewById(R.id.btn2);
        //editText.setInputType(InputType.TYPE_NULL);
     //editText.setInputType(InputType.TYPE_CLASS_TEXT);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:{
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                break;}
            case R.id.btn2:{

                editText.setInputType(InputType.TYPE_NULL);
                editText.setFocusable(true);
                editText.setCursorVisible(true);
                editText.setFocusableInTouchMode(true);
                break;}
            default:
                break;
        }
    }
}
