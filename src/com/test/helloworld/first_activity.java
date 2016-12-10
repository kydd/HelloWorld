package com.test.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
// import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class first_activity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		
		Button button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(first_activity.this, "You clicked 你好！Button 1",
					Toast.LENGTH_LONG).show();
				
				String data1 = "你好！!二号窗体！！Hello SecondActivity";
				int data2 = 8888888;
				boolean data3 = true;
				Intent intent = new Intent(first_activity.this, second_activity.class);
				intent.putExtra("extra_data1", data1);
				intent.putExtra("extra_data2", data2);
				intent.putExtra("extra_data3", data3);
				startActivity(intent);
			}
		});

		// 与第4活动相应
		Button button6 = (Button)findViewById(R.id.button6);
		button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(first_activity.this, "从下级窗体返回获取数据",
						Toast.LENGTH_LONG).show();
				
				Intent intent = new Intent(first_activity.this, fourth_activity.class);
				startActivityForResult(intent, 1);
			}
		});

		Button button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		Button button3 = (Button)findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(first_activity.this, "这里没有任何操作",
						Toast.LENGTH_LONG).show();
			}
		});
		
		Button button4 = (Button)findViewById(R.id.button4);
		button4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.baidu.com"));
				startActivity(intent);
			}
		});

		Button button5 = (Button)findViewById(R.id.button5);
		button5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);
			}
		});
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.add_item:
				Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
				break;
			
			case R.id.remove_item:
				Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
				break;
				
			case R.id.openwindow_item:
//				Intent intent = new Intent(first_activity.this, third_activity.class);
//				startActivity(intent);
				Intent intent = new Intent("com.test.activitytest.ACTION_START");
				intent.addCategory("com.test.activitytest.MY_CATEGORY");
				startActivity(intent);
				break;

			case R.id.finish_item:
				// Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
				finish();
				break;
			
			default:
		}
		return true;
	}
	
	// 重写onActivityResult，用于获取返回的数据
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
			case 1:
			if (resultCode == RESULT_OK) {
				String returnedData = data.getStringExtra("data_return");
				Log.d("FirstActivity", returnedData);
				Log.d("FirstActivity", returnedData);
			}
			break;
			default:
		}
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Toast.makeText(first_activity.this, "我被退回了！！",
				Toast.LENGTH_SHORT).show();
	}
	
}

