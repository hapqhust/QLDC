package com.hapq.qldc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class HoGD_DiemDanhAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<HoGD> hoGDList;

    public HoGD_DiemDanhAdapter(Context context, int layout, ArrayList<HoGD> hoGD) {
        this.context = context;
        this.layout = layout;
        this.hoGDList = hoGD;
    }

    @Override
    public int getCount() {
        return hoGDList.size();
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
        TextView txtDiaChi, txtIDChuHo, txtIDHoGD;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            //anh xa view
            holder.txtDiaChi = (TextView) convertView.findViewById(R.id.textViewDiaChi);
            holder.txtIDChuHo = (TextView) convertView.findViewById(R.id.textViewIDChuHo);
            holder.txtIDHoGD = (TextView) convertView.findViewById(R.id.textViewIDHoGD);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        // Gan gia tri
        HoGD soNha = hoGDList.get(position);

        holder.txtDiaChi.setText(soNha.getDiaChi());
        holder.txtIDChuHo.setText(soNha.getIdChuHo());
        holder.txtIDHoGD.setText(soNha.getIdHoGD());

        return convertView;
    }
}
