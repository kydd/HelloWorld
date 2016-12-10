package com.test.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class second_activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		Intent intent = getIntent();
		
		// 获取字符串值
		String data1 = intent.getStringExtra("extra_data1");
		Log.d("SecondActivity1", data1);

		// 获取整型值
		int data2 = intent.getIntExtra("extra_data2",1);
		Log.d("SecondActivity2", String.valueOf(data2));

		// 获取布尔值
		boolean data3 = intent.getBooleanExtra("extra_data3",false);
		Log.d("SecondActivity3", String.valueOf(data3));
		
		Button button1 = (Button)findViewById(R.id.btnShowMessage2);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(second_activity.this, "这里是第二个窗口的第一个按钮！",
					Toast.LENGTH_SHORT).show();
			}
		});

		Button button2 = (Button)findViewById(R.id.btnFinish);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}
	
	

}
