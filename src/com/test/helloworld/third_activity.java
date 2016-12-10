package com.test.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class third_activity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_layout);
		
		Button button1 = (Button)findViewById(R.id.btnShowMessage3);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(third_activity.this, "You clicked ´ó¼ÒºÃ£¡Button 1",
					Toast.LENGTH_SHORT).show();
			}
		});

		Button button2 = (Button)findViewById(R.id.btnFinish3);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
