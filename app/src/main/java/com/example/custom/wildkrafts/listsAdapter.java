package com.example.custom.wildkrafts;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tatwika Kashyap on 29-10-2015.
 */
public class listsAdapter extends ArrayAdapter<lists> {

    Context context;
    int layoutResourceId;


        public listsAdapter(Context context, int layoutResourceId, List<lists> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        ImageView arrow;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        lists lists = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.items_row, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.textTitle);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageIcon);
            holder.arrow = (ImageView) convertView.findViewById(R.id.arrow);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtTitle.setText(lists.getTitle());
        holder.arrow.setImageResource(lists.getArrow());

        holder.imageView.setImageResource(lists.getImageId());
        return convertView;
    }
}

