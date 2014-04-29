package com.example.gridview.adapters;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.gridview.R;
import com.example.gridview.dao.Comment;


@SuppressLint("NewApi")
public class StaggeredAdapter extends ArrayAdapter<Comment> {

	Comment comment;
	Context mContext;
	public StaggeredAdapter(Context context, int textViewResourceId,
			List<Comment>  objects) {
		super(context, textViewResourceId, objects);
		mContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		comment = getItem(position);
		if (convertView == null) {
			LayoutInflater layoutInflator = LayoutInflater.from(getContext());
			convertView = layoutInflator.inflate(R.layout.row_staggered_demo,
					null);
			holder = new ViewHolder();
			holder.txtHeader = (TextView)convertView .findViewById(R.id.txtNoteHeader);
			holder.txtView = (TextView)convertView .findViewById(R.id.txtNote);
			holder.rlNotes = (RelativeLayout)convertView .findViewById(R.id.rl_notes);
			convertView.setTag(holder);
		}

		holder = (ViewHolder) convertView.getTag();
		if(comment.state){
			holder.rlNotes.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shadow_blue));
		}else{
			holder.rlNotes.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.shadow));
		}
		holder.txtHeader.setText(comment.title);
		holder.txtView.setText(comment.comment);

		return convertView;
	}

	static class ViewHolder {
		TextView txtHeader;
		TextView txtView;
		TextView txtUpdated;
		RelativeLayout rlNotes;
	}
}
