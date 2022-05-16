package com.hapq.qldc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChuHoListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<ChuHo> chuhoList;

    public ChuHoListAdapter(Context context, int layout, ArrayList<ChuHo> chuhoList) {
        this.context = context;
        this.layout = layout;
        this.chuhoList = chuhoList;
    }

    @Override
    public int getCount() {
        return chuhoList.size();
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
        TextView txtName, txtIDHo, txtPhone;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            //anh xa view
            holder.txtName = (TextView) convertView.findViewById(R.id.textNameChuHo);
            holder.txtIDHo = (TextView) convertView.findViewById(R.id.textMaIDHo);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.textSDT);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        // Gan gia tri
        ChuHo chuho = chuhoList.get(position);

        holder.txtName.setText(chuho.getNamePerson());
        holder.txtPhone.setText(chuho.getPhone());
        holder.txtIDHo.setText(chuho.getIdHoGD());

        return convertView;
    }
}
