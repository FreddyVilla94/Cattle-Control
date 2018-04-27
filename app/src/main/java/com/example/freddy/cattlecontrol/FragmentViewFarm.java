package com.example.freddy.cattlecontrol;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.freddy.cattlecontrol.Adapters.AdapterListFarms;
import com.example.freddy.cattlecontrol.Class.Conector;
import com.example.freddy.cattlecontrol.Class.Extension;
import com.example.freddy.cattlecontrol.Class.Farm;
import com.example.freddy.cattlecontrol.Class.User;

import java.util.ArrayList;


public class FragmentViewFarm extends Fragment {

    private View view;
    private User user = new User();
    private ArrayList<Farm> farmArrayList = new ArrayList<>();
    private AdapterListFarms adapterListFarms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_view_farm, container, false);
        user = Conector.getUser();
        Farm farm1 = new Farm("1","Finca TEC", new Extension(30,false));
        Farm farm2 = new Farm("2","Finca TEC", new Extension(30,false));
        Farm farm3 = new Farm("3","Finca TEC", new Extension(30,false));
        farmArrayList.add(farm1);
        farmArrayList.add(farm2);
        farmArrayList.add(farm3);
        user.setFarms(farmArrayList);
        loadFarms();
        return view;
    }

    private void loadFarms() {
        ListView listView = (ListView) view.findViewById(R.id.list_farms);
        adapterListFarms = new AdapterListFarms(getActivity(),user.getFarms());
        listView.setAdapter(adapterListFarms);
    }

}
