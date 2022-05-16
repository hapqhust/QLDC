package com.hapq.qldc;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
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
import java.util.zip.Inflater;

public class FragmentDiemdanh extends ListFragment {

    HoGD_DiemDanhAdapter adapter;
    ArrayList<HoGD> listHoGD;
    TruyenHoDan truyenFamily;

    String URL = "https://demoqldc.000webhostapp.com/get_infor.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        truyenFamily = (TruyenHoDan) getActivity();
        View view = inflater.inflate(R.layout.fragment_list_diemdanh, container, false);
        listHoGD = new ArrayList<>();
        adapter = new HoGD_DiemDanhAdapter(getActivity(), R.layout.dong_hogd, listHoGD);
        setListAdapter(adapter);
        //AddArray();
        Getdata(URL);
        return view;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        truyenFamily.DataFamily(listHoGD.get(position));
    }

    private void AddArray(){
        listHoGD.add(new HoGD("Số 1 Tạ Quang Bửu, Đại Cồ Việt, Hai Bà Trưng", "13-TQBX", "Nguyễn Văn A"));
        listHoGD.add(new HoGD("Số 2 Tạ Quang Bửu, Đại Cồ Việt, Hai Bà Trưng", "14-TBQX", "Trần Thị B"));
        listHoGD.add(new HoGD("Số 3 Tạ Quang Bửu, Đại Cồ Việt, Hai Bà Trưng", "15-TBQX", "Hoàng Đức C"));
        listHoGD.add(new HoGD("Số 4 Tạ Quang Bửu, Đại Cồ Việt, Hai Bà Trưng", "16-TBQX", "Lê Thị D"));
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
                                listHoGD.add(new HoGD(object.getString("DiaChi"), object.getString("maHo"), object.getString("HoTen")));
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
