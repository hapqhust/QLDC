package com.hapq.qldc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentGDInfor extends Fragment {
    TextView txtHoTen, txtDiaChi, txtID;
    View view;
    ListView listView;
    String[] superStarNames = {"Buổi 1", "Buổi 2", "Buổi 3", "Buổi 4", "Buổi 5"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gd_infor, container, false);
        Anhxa();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), superStarNames);
        listView.setAdapter(customAdapter);
        return view;
    }

    public void SetInfor(HoGD gd){
        txtHoTen.setText(gd.getIdChuHo());
        txtDiaChi.setText(gd.getDiaChi());
        txtID.setText(gd.getIdHoGD());
    }

    private void Anhxa(){
        txtHoTen = (TextView) view.findViewById(R.id.textName);
        txtDiaChi = (TextView) view.findViewById(R.id.textNameDC);
        txtID = (TextView) view.findViewById(R.id.textNameID);
        listView = (ListView) view.findViewById(R.id.list_diemdanh);
    }

}
