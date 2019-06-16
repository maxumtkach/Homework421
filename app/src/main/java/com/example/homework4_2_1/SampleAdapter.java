package com.example.homework4_2_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class SampleAdapter extends BaseAdapter {

    private List<SamplesList> samplesLists = new ArrayList<>();
    private LayoutInflater inflater;

    public SampleAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void addSimples(SamplesList samplesList) {

        samplesLists.add(samplesList);
    }

    @Override
    public int getCount() {
        return samplesLists.size();
    }

    @Override
    public Object getItem(int position) {
        return samplesLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if (convertView != null) {

            view = convertView;

        } else {

            view = inflater.inflate(R.layout.samples_list_item, parent, false);

            SamplesList list = (SamplesList) getItem(position);

            TextView listNameText = view.findViewById(R.id.sample_name);
            listNameText.setText(list.getName());

            TextView listExampleName = view.findViewById(R.id.sample_example_name);
            listExampleName.setText(list.getExampleName());

            ImageView listImage = view.findViewById(R.id.sample_image);
            listImage.setImageResource(list.getDrawableId());

        }

        return view;
    }
}
