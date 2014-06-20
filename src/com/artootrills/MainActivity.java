package com.artootrills;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;

public class MainActivity extends Activity{

	CustomLayout layout;
	LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	LayoutInflater inflater;
	OnClickListener listener;
	LayoutTransition transition;
	String texts[] = new String[]{
			"Artoo" , "Android Kitkat", "Grameen Foundation" , "Android Programming is Fun",
			"Technology to the Rescue", "Artoo empowers social enterprises to capture, analyze and process information remotely through smartphones / tablets",
			"Brighter India Foundation", 
			};
	CustomTextView view[] = new CustomTextView[7];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		layout = (CustomLayout)findViewById(R.id.custom);
		transition = new LayoutTransition();
		layout.setLayoutTransition(transition);
		listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				transition.setStagger(LayoutTransition.DISAPPEARING, 100);
				layout.removeView(v);
			}
		};
		for(int i=0;i<texts.length;i++)
		{
			view[i] = (CustomTextView) inflater.inflate(R.layout.element, null);
			view[i].setText(texts[i]);
			view[i].setLayoutParams(params);
			view[i].setOnClickListener(listener);
			layout.addView(view[i]);
		}
		/*CustomTextView view1 = (CustomTextView) inflater.inflate(R.layout.element, null);
		view1.setText("ABCD");
		CustomTextView view2 = (CustomTextView) inflater.inflate(R.layout.element, null);

		CustomTextView view3 = (CustomTextView) inflater.inflate(R.layout.element, null);view3.setText("X");
		view2.setText("KSANKNSJNLFJENLWFJNLSDJNCLJUN LJNLEJNV );"
				+ "ENWVLJNE LVJN LEWVJN LEVJN LWEJ VLNJW VLJ WDNLVJ LDJ V"
				+ " VENLWJK LDJV LJ VLW VEL EVL J NKJLV LJV LJ SDLV JN SDvlkj "
				+ "dw vkja elvh alvj halehr vlaher vhla vra"
				+ "a vljake vlkjhea fvljea lrv alrejvh aelrjv n"
				+ "d  JVAKEH VLAEHRV LAEJR VLOjwe cl >SD"
				+ "V JALWJV ALERJV ALERHBNLOAWjnDC .JALNV ;AWJRV"
				+ "ADVH AKJH BV; dAD VKJAE VLAEJR LGVA NEVLCJ AlWEV AVJL C"
				+ "WAJKER NGLJANR GLVJN LQREJVNG ALEJR VNLAJE BVLJB AENR;V");
		CustomTextView view4 = (CustomTextView) inflater.inflate(R.layout.element, null);view3.setText("X");
		view4.setText("Android Programming is very dull and boring."+
				"Android Programming is very dull and boring."+
				"Android Programming is very dull and boring."+
				"Android Programming is very dull and boring."
				);
		CustomTextView view5 = (CustomTextView) inflater.inflate(R.layout.element, null);
		view5.setText("Android Programming is very dull and boring.");
		CustomTextView view6 = (CustomTextView) inflater.inflate(R.layout.element, null);
		view6.setText("Android Programming is very dull and boring.");
		CustomTextView view7 = (CustomTextView) inflater.inflate(R.layout.element, null);
		view7.setText("Android Programming is very dull and boring.");
		CustomTextView view8 = (CustomTextView) inflater.inflate(R.layout.element, null);
		view8.setText("Android Programming is very dull and boring.");
		CustomTextView view9 = (CustomTextView) inflater.inflate(R.layout.element, null);
		view9.setText("Android Programming is very dull and boring.");
		CustomTextView view10 = (CustomTextView) inflater.inflate(R.layout.element, null);
		view10.setText("Android Programming is very dull and boring.");
		CustomTextView view11 = (CustomTextView) inflater.inflate(R.layout.element, null);
		view11.setText("Android Programming is very dull and boring.");
		CustomTextView view12 = (CustomTextView) inflater.inflate(R.layout.element, null);
		view12.setText("Android Programming is very dull and boring.");
		view1.setLayoutParams(params);
		view2.setLayoutParams(params);
		view3.setLayoutParams(params);
		view4.setLayoutParams(params);
		view5.setLayoutParams(params);
		view6.setLayoutParams(params); 
		view7.setLayoutParams(params); 
		view8.setLayoutParams(params); 
		view9.setLayoutParams(params); 
		view10.setLayoutParams(params); 
		view11.setLayoutParams(params);
		view12.setLayoutParams(params);
		view1.setOnClickListener(listener);
		view2.setOnClickListener(listener);
		view3.setOnClickListener(listener);
		view4.setOnClickListener(listener);
		view5.setOnClickListener(listener);
		view6.setOnClickListener(listener);
		view7.setOnClickListener(listener);
		view8.setOnClickListener(listener);
		view9.setOnClickListener(listener);
		view10.setOnClickListener(listener);
		view11.setOnClickListener(listener);
		view12.setOnClickListener(listener);
		layout.addView(view9);
		layout.addView(view10);
		layout.addView(view11);
		layout.addView(view12);
		layout.addView(view5);
		layout.addView(view1);
		layout.addView(view3);
		layout.addView(view2);
		layout.addView(view4);
		layout.addView(view6);
		layout.addView(view7);
		layout.addView(view8);*/
	}

	public void addView(View view)
	{
		EditText edit = (EditText)findViewById(R.id.editText);
		CustomTextView txt = (CustomTextView) inflater.inflate(R.layout.element, null);
		String t = edit.getText().toString();
		int i=0;
		for(i=0;i<t.length();i++)
		{
			if(t.charAt(i)!=38)
			{
				break;
			}
		}
		if(i!=t.length())
		{
			txt.setText(t);txt.setOnClickListener(listener);
			layout.addView(txt);
			transition.setStagger(LayoutTransition.APPEARING, 100);
			layout.setLayoutTransition(transition);
			layout.setScrollY(0);
			edit.setText("");
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
	}

}
