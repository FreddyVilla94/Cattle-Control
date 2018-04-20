package com.example.freddy.cattlecontrol.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.freddy.cattlecontrol.Class.Farm;
import com.example.freddy.cattlecontrol.R;

import java.util.ArrayList;

/**
 * Created by Freddy on 19/4/2018.
 */

public class AdapterListFarms extends BaseAdapter implements Filterable {

    private static LayoutInflater inflater;
    private Context activity;
    protected ArrayList<Farm> originalItems;
    protected ArrayList<Farm> filteredItems;

    public AdapterListFarms(Context context, ArrayList<Farm> farms) {
        inflater = LayoutInflater.from(context);
        this.activity = context;
        this.originalItems = farms;
        this.filteredItems = farms;
    }

    @Override
    public int getCount() {
        return filteredItems.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            v = inflater.inflate(R.layout.item_farms, null);
        }
        final Farm farms = filteredItems.get(position);

        TextView nameFarm = (TextView) v.findViewById(R.id.textNameFarm);
        TextView sizeFarm = (TextView) v.findViewById(R.id.textSizeFarm);
        TextView typeMeasure = (TextView) v.findViewById(R.id.typeMeasure);
        nameFarm.setText(farms.getName());
        if(farms.getExtension().getMeasure()){
            typeMeasure.setText(R.string.hectares);
        } else {
            typeMeasure.setText(R.string.apples);
        }
        String stringSize = String.valueOf(farms.getExtension().getExtension());
        sizeFarm.setText(stringSize);

        v.setPadding(50,50,50,50);
        return v;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                if (constraint == null || constraint.length() == 0){
                    results.values = originalItems;
                    results.count = originalItems.size();
                }
                else{
                    String filterString = constraint.toString().toLowerCase();

                    ArrayList<Farm> filterResultsData = new ArrayList<>();
                    for (Farm data : originalItems){
                        if (data.getName().toLowerCase().contains(filterString)){
                            filterResultsData.add(data);
                        }
                    }
                    results.values = filterResultsData;
                    results.count = filterResultsData.size();
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredItems = (ArrayList<Farm>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
