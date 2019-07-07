package com.example.homework4_2_1;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleAdapter extends BaseAdapter {

    private List<SamplesList> samplesLists = new ArrayList<>();
    private LayoutInflater inflater;
    private File file = new File(Environment.getExternalStorageDirectory(), "myItemData");

    public SampleAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void addSimples(SamplesList samplesList) {

        samplesLists.add(samplesList);
        notifyDataSetChanged();
    }

    public void removeSimples(int position) {
        samplesLists.remove(position);
        notifyDataSetChanged();
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int finalPosition = position;
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


            Button listButton = view.findViewById(R.id.btn_del);
            listButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addSimples(samplesLists.get(finalPosition));

                    if (file.canWrite()) {
                        try {
                            FileWriter fileWriter = new FileWriter(file);
                            //  fileWriter.write("a");//запись посимвольно
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            bufferedWriter.newLine();//запись построчно
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            ImageView listImageDel = view.findViewById(R.id.delete_img);
            listImageDel.setImageResource(list.getDeleteImg());
            listImageDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeSimples(finalPosition);
                    file.delete();
                }
            });

        }

        return view;
    }
}
