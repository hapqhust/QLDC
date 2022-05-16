package com.hapq.qldc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.Calendar;

public class FragmentDateCN1 extends Fragment {

    DatePicker datePicker;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_date, container, false);
        datePicker = (DatePicker) view.findViewById(R.id.datePicker);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month  = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);

        datePicker.init(year, month , day , new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                TextView txtDate = (TextView) getActivity().findViewById(R.id.textDateNumber);
                txtDate.setText("" + dayOfMonth +"-" + (month + 1) + "-" + year);
                //Toast.makeText(getActivity(),"" + dayOfMonth +"-" + (month + 1) + "-" + year, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
