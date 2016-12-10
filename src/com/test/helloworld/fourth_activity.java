package com.test.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class fourth_activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fourth_layout);
	
		Button button1 = (Button)findViewById(R.id.btnBackMessage4);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("data_return", "Hello FirstActivity888000");
				setResult(RESULT_OK, intent);
				finish();
			}
		});
	}
	
	@Override
	public void onBackPressed() {
//		super.onBackPressed();
		Toast.makeText(fourth_activity.this, "我被退回了！！",
				Toast.LENGTH_SHORT).show();
		Intent intent = new Intent();
		intent.putExtra("data_return", "Hello FirstActivity i am back");
		setResult(RESULT_OK, intent);
		finish(); // 有这句才能让上面的数据真正返回到前一窗体
	}
}
