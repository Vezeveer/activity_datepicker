package com.example.valduezaactivityshowchosendate;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PickerActivity extends FragmentActivity implements DateDialog.DateDialogListener {

	private TextView tvSelectedDate;
	private Button button;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvSelectedDate = (TextView) findViewById(R.id.tvSelectedDate);
        
        button = (Button) findViewById(R.id.btnShowAlertDialog);
        button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				openDialog();
			}
		});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void openDialog(){
    	DateDialog dialog = new DateDialog();
    	dialog.show(getSupportFragmentManager(), "Dialog");
    }

    @Override
    public void onDateSet(String selectedDate){
    	TextView tv1 = (TextView)findViewById(R.id.textView1);
    	tv1.setText("Chosen Date:");
    	tvSelectedDate.setText(selectedDate);
    }
    
}
