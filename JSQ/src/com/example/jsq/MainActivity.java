package com.example.jsq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener{
	private Button bt_0;
	private Button bt_1;
	private Button bt_2;
	private Button bt_3;
	private Button bt_4;
	private Button bt_5;
	private Button bt_6;
	private Button bt_7;
	private Button bt_8;
	private Button bt_9;
	private Button bt_cheng;
	private Button bt_chu;
	private Button bt_jia;
	private Button bt_jian;
	private Button bt_c;
	private Button bt_d;
	private Button bt_dian;
	private Button bt_deng;
	private EditText et_input;
	private boolean clear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ji);
		bt_0 = (Button)findViewById(R.id.bt_0);
		bt_1 = (Button)findViewById(R.id.bt_1);
		bt_2 = (Button)findViewById(R.id.bt_2);
		bt_3 = (Button)findViewById(R.id.bt_3);
		bt_4 = (Button)findViewById(R.id.bt_4);
		bt_5 = (Button)findViewById(R.id.bt_5);
		bt_6 = (Button)findViewById(R.id.bt_6);
		bt_7 = (Button)findViewById(R.id.bt_7);
		bt_8 = (Button)findViewById(R.id.bt_8);
		bt_9 = (Button)findViewById(R.id.bt_9);
		bt_jia = (Button)findViewById(R.id.bt_jia);
		bt_jian = (Button)findViewById(R.id.bt_jian);
		bt_cheng = (Button)findViewById(R.id.bt_cheng);
		bt_chu = (Button)findViewById(R.id.bt_chu);
		bt_deng = (Button)findViewById(R.id.bt_deng);
		bt_dian = (Button)findViewById(R.id.bt_dian);
		bt_c = (Button)findViewById(R.id.bt_c);
		bt_d = (Button)findViewById(R.id.bt_d);
		bt_0.setOnClickListener(this);
		bt_1.setOnClickListener(this);
		bt_2.setOnClickListener(this);
		bt_3.setOnClickListener(this);
		bt_4.setOnClickListener(this);
		bt_5.setOnClickListener(this);
		bt_6.setOnClickListener(this);
		bt_7.setOnClickListener(this);
		bt_8.setOnClickListener(this);
		bt_9.setOnClickListener(this);
		bt_cheng.setOnClickListener(this);
		bt_chu.setOnClickListener(this);
		bt_jia.setOnClickListener(this);
		bt_jian.setOnClickListener(this);
		bt_deng.setOnClickListener(this);
		bt_c.setOnClickListener(this);
		bt_d.setOnClickListener(this);
		bt_dian.setOnClickListener(this);
		et_input = (EditText)findViewById(R.id.input1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String str =et_input.getText().toString();
		switch (v.getId()) {
		case R.id.bt_0:
		case R.id.bt_1:
		case R.id.bt_2:
		case R.id.bt_3:
		case R.id.bt_4:
		case R.id.bt_5:
		case R.id.bt_6:
		case R.id.bt_7:
		case R.id.bt_8:
		case R.id.bt_9:
		case R.id.bt_dian:
			if(clear){
				clear = false;
				str="";
				et_input.setText("");
			}
		et_input.setText(str+((Button)v).getText());
			break;
		case R.id.bt_jia:
		case R.id.bt_jian:
		case R.id.bt_cheng:
		case R.id.bt_chu:
			if(clear){
				clear = false;
				str="";
				et_input.setText("");
			}
			et_input.setText(str+" "+((Button)v).getText()+" ");	
		break;
		case R.id.bt_c:
		clear = false;
		str="";
		et_input.setText("");
			break;
		case R.id.bt_d:
			et_input.setText(str.substring(0, str.length()-1));
			if(clear){
				clear = false;
				str="";
				et_input.setText("");
			}else if(str!=null&&!str.equals("")){
				et_input.setText(str.substring(0, str.length()-1));
			}
			break;
		case R.id.bt_deng:
			getR();
			break;
		default:
			break;
		}
	}
	private void getR() {
		
		String exp = et_input.getText().toString();
		if(exp==null||exp.equals("")){
			return;
		}
		if(!exp.contains(" ")){
			return ;
		}
		if(clear){
			clear =false;
			return ;
		}
		clear = false;
		double su=0;
		String s1 = exp.substring(0, exp.indexOf(" "));
		String op = exp.substring(exp.indexOf(" ")+1, exp.indexOf(" ")+2);
		String s2 = exp.substring(exp.indexOf(" ")+3);
		
		if(!s1.equals("")&&!s2.equals("")){
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			
			if(op.equals("+")){
				su = d1+d2;
			}
			else if(op.equals("-")){
				su = d1-d2;
			}
			else if(op.equals("¡Á")){
				su = d1*d2;
			}
			else if(op.equals("¡Â")){
				if(d2 == 0){
					su=0;
				}
				else{
					su =d1/d2;
				}
			}
			if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("¡Â")){
				int r = (int) su;
				et_input.setText(r+"");
			}
			else{
				et_input.setText(su+"");
			}
		}
			else if(!s1.equals("")&&s2.equals("")){
				et_input.setText(exp);
			}
			else if(s1.equals("")&&!s2.equals("")){
				double d2 = Double.parseDouble(s2);
				if(op.equals("+")){
					su = 0+d2;
				}
				else if(op.equals("-")){
					su = 0-d2;
				}
				else if(op.equals("x")){
					su = 0*d2;
				}
				else if(op.equals("¡Â")){
					
						su =0;
					
				}
				if(!s2.contains(".")){
					int r = (int) su;
					et_input.setText(r+"");
				}
				else{
					et_input.setText(su+"");
				}
			}
			else{
			et_input.setText("");	
			}
		clear =true;
		}
	
}

