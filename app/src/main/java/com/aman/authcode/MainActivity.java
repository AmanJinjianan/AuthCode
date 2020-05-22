package com.aman.authcode;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup_orientation;
    private TextView tv;
    //RadioGroup控件的初始化
    private RadioGroup.OnCheckedChangeListener radioGrouplisten = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            int id = group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                case R.id.rb_2:
                    tv.setText("S999"+String.valueOf(System.currentTimeMillis()));
                    break;
                case R.id.rb_3:
                    tv.setText("S899"+String.valueOf(System.currentTimeMillis()));
                    break;
                case R.id.rb_7:
                    tv.setText("S499"+String.valueOf(System.currentTimeMillis()));
                    break;
                case R.id.rb_30:
                    tv.setText("S179"+String.valueOf(System.currentTimeMillis()));
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv_code);
        tv.setText("S899"+String.valueOf(System.currentTimeMillis()));

        radioGroup_orientation = (RadioGroup) findViewById(R.id.rg_Orientation);
        radioGroup_orientation.setOnCheckedChangeListener(radioGrouplisten);

        findViewById(R.id.btn_copy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取剪贴板管理器：
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 创建普通字符型ClipData
                ClipData mClipData = ClipData.newPlainText("Label", tv.getText());
                // 将ClipData内容放到系统剪贴板里。
                cm.setPrimaryClip(mClipData);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
