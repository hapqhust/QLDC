package com.hapq.qldc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentChuHo extends ListFragment {
    ChuHoListAdapter adapter;
    ArrayList<ChuHo> listChuHo;

    String URL = "https://demoqldc.000webhostapp.com/get_infor.php";
    String date, time;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chuho, container, false);
        listChuHo = new ArrayList<>();
        adapter = new ChuHoListAdapter(getActivity(), R.layout.listview_ds_chuho, listChuHo);
        setListAdapter(adapter);
        //AddArray();
        Getdata(URL);
        return view;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        String value = "";
        value = ThongBao(value, listChuHo.get(position).getNamePerson());
        intent.putExtra("sms_body", value);
        String s = listChuHo.get(position).getPhone();
        intent.setData(Uri.parse("sms:" + s));
        startActivity(intent);
    }

    private String ThongBao(String value, String name){
        value += "[TH??NG B??O H???P T??? D??N PH???]\n";
        value += "K??nh g???i ??ng/b??: " + name + "\n";
        value += "Nh???m tri???n khai m???t s??? n???i dung quan tr???ng c???a t??? d??n ph???. "
        + "Ban qu???n l?? ???? quy???t ?????nh t??? ch???c bu???i h???p nh?? sau:"+"\n";
        value += "?????a ??i???m: Nh?? v??n h??a c???a t??? d??n ph???.\n";
        value += "Th???i gian: " + time +" ng??y " + date + "\n";
        value += "K??nh mong ??ng/b?? ?????n tham d??? bu???i h???p ?????y ?????.\n";
        return value;
    }

    private void AddArray(){
        listChuHo.add(new ChuHo("Nguy???n V??n A", "13-TQBX", "013485929"));
        listChuHo.add(new ChuHo("Tr???n Th??? B", "14-TQBX", "023485929"));
        listChuHo.add(new ChuHo("Ho??ng ?????c C", "15-TQBX", "033485929"));
        listChuHo.add(new ChuHo("L?? Th??? D", "16-TQBX", "043485929"));
    }

    private void Getdata(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_SHORT).show();
                        for(int i = 0; i <response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                listChuHo.add(new ChuHo(object.getString("HoTen"), object.getString("maHo"), "0969700815"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(jsonArrayRequest);
    }
}
