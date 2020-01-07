package ten.ten;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button b1;
	EditText et;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.button1);
		et=(EditText)findViewById(R.id.editText1);
		tv=(TextView)findViewById(R.id.textView1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String mynumber=et.getText().toString();
				if(mynumber.trim().length()==0)
				{
					tv.setText("No number");
					tv.setTextColor(Color.BLUE);
				}
				else if (!(mynumber.length()==10)) {
					
					tv.setText(""+"wrong number");
					tv.setTextColor(Color.CYAN);
				}
				else
				{
					String CallNumber="tel:"+mynumber;
				Intent obj=new Intent(Intent.ACTION_CALL);
				obj.setData(Uri.parse(CallNumber));
				startActivity(obj);
				
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
