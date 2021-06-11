package com.example.valduezaactivityshowchosendate;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

public class DateDialog extends DialogFragment {
	public DatePicker dp;
	public DateDialogListener listener;
	public AlertDialog.Builder builder;
	public View view;
	public LayoutInflater inflater;
	
	public Dialog onCreateDialog(Bundle savedInstanceState){
		builder = new AlertDialog.Builder(getActivity());
		inflater = getActivity().getLayoutInflater();
		view = inflater.inflate(R.layout.layout_items, null);
		
		builder.setView(view)
				.setTitle("")
				.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
					}
				})
				.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						dp = (DatePicker)view.findViewById(R.id.datePicker1);
						String selectedDate = dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear();
						
						try{
							listener.onDateSet(selectedDate);
						}catch(Exception e){
							System.out.println("EXCEPTION at applyTexts: " + e);
						}
					}
				});
		return builder.create();
	}
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			listener = (DateDialogListener) activity;
		}catch(ClassCastException e){
			System.out.println("Exception at onAttach: "+e);
			throw new ClassCastException(activity.toString()+
					"must implement ItemsDialogListener");
		}
	}
	
	public interface DateDialogListener{
		void onDateSet(String selectedItem);
	}
}
