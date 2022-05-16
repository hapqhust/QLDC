package com.hapq.qldc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SinhHoatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Function> chucNangList;

    public SinhHoatAdapter(Context context, int layout, ArrayList<Function> chucNangList) {
        this.context = context;
        this.layout = layout;
        this.chucNangList = chucNangList;
    }

    @Override
    public int getCount() {
        return chucNangList.size();
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
        ImageView img;
        TextView txtChucNang, txtMoTa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            //anh xa view
            holder.txtChucNang = (TextView) convertView.findViewById(R.id.textViewFunction);
            holder.txtMoTa = (TextView) convertView.findViewById(R.id.textViewMoTa);
            holder.img = (ImageView) convertView.findViewById(R.id.imageView_flag);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        // Gan gia tri
        Function function = chucNangList.get(position);

        holder.txtChucNang.setText(function.getChucNang());
        holder.txtMoTa.setText(function.getMota());
        holder.img.setImageResource(function.getHinh());

        return convertView;
    }
}
