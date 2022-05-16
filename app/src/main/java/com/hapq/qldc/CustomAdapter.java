package com.hapq.qldc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {
    String[] names;
    Context context;
    LayoutInflater inflter;
    String value;

    public CustomAdapter(Context context, String[] names) {
        this.context = context;
        this.names = names;
        inflter = (LayoutInflater.from(context));

    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder{
        CheckedTextView simpleCheckedTextView;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null) {
            view = inflter.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.simpleCheckedTextView = (CheckedTextView) view.findViewById(R.id.simpleCheckedTextView);
            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }


        holder.simpleCheckedTextView.setText(names[position]);
// perform on Click Event Listener on CheckedTextView
        holder.simpleCheckedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.simpleCheckedTextView.isChecked()) {
// set cheek mark drawable and set checked property to false
                    value = "Unchecked";
                    holder.simpleCheckedTextView.setCheckMarkDrawable(null);
                    holder.simpleCheckedTextView.setChecked(false);
                } else {
// set cheek mark drawable and set checked property to true
                    value = "Checked";
                    holder.simpleCheckedTextView.setCheckMarkDrawable(R.drawable.checked);
                    holder.simpleCheckedTextView.setChecked(true);
                }
                Toast.makeText(context, value, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}