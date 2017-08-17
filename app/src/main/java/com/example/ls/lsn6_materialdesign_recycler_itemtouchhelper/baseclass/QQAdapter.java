package com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.baseclass;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ls.lsn6_materialdesign_recycler_itemtouchhelper.R;

public class QQAdapter extends Adapter<QQAdapter.MyViewHolder>{
	private List<QQMessage> list;
    private Context context;
	private StartDragListener startDragListener;
	public QQAdapter(List<QQMessage> list,Context context,StartDragListener startDragListener) {
		this.list = list;
		this.startDragListener=startDragListener;
		this.context=context;
	}
	
	class MyViewHolder extends ViewHolder{

		private ImageView iv_logo;
		private TextView tv_name;
		private TextView tv_Msg;
		private TextView tv_time;

		public MyViewHolder(View itemView) {
			super(itemView);
			iv_logo = (ImageView)itemView.findViewById(R.id.iv_logo);
			tv_name = (TextView)itemView.findViewById(R.id.tv_name);
			tv_Msg = (TextView)itemView.findViewById(R.id.tv_lastMsg);
			tv_time = (TextView)itemView.findViewById(R.id.tv_time);
		}
		
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void onBindViewHolder(final MyViewHolder holder, int location) {
		QQMessage qqMessage = list.get(location);
		holder.iv_logo.setImageResource(qqMessage.getLogo());
		holder.tv_name.setText(qqMessage.getName());
		holder.tv_Msg.setText(qqMessage.getLastMsg());
		holder.tv_time.setText(qqMessage.getTime());
		holder.iv_logo.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					startDragListener.StartDragListener(holder);
					return true;
				}
				return false;
			}
		});
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.listitem,null);
		return new MyViewHolder(view);
	}

	

}
