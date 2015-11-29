package com.example.custom.wildkrafts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tatwika Kashyap on 16-10-2015.
 */
public class listAdapter extends ArrayAdapter<list>{

    Context context;
    int layoutResourceId;


        int color[]={Color.rgb(153,204,255),Color.rgb(160,160,160),Color.rgb(255,204,204),Color.rgb(255,204,153),Color.WHITE,Color.rgb(153,255,153),Color.rgb(255,102,102),Color.WHITE};


    public listAdapter(Context context, int layoutResourceId, List<list> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        list list = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_row, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imgIcon);
            holder.txtDesc = (TextView) convertView.findViewById(R.id.txtDesc);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtTitle.setText(list.getTitle());
        holder.txtDesc.setText(list.getDesc());

        holder.imageView.setImageResource(list.getImageId());
convertView.setBackgroundColor(color[position]);
        return convertView;
    }
}
