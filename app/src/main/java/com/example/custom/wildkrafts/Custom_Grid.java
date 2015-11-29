package com.example.custom.wildkrafts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tatwika Kashyap on 28-10-2015.
 */
public class Custom_Grid extends BaseAdapter {
    private Context mContext;
    private final String[] name;
    private final int[] Imageid;
    private final String[] actual;
    private final String[] discount;


    public Custom_Grid(Context c, int[] Imageid, String[] name, String[] actual, String[] discount) {
        mContext = c;
        this.Imageid = Imageid;
        this.name = name;
        this.actual = actual;
        this.discount = discount;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);

           } else {
            grid = (View) convertView;
        }
        TextView names = (TextView) grid.findViewById(R.id.gridtext);
        ImageView imageView = (ImageView) grid.findViewById(R.id.gridimg);
        TextView prices = (TextView) grid.findViewById(R.id.actualprice);
        TextView discounts = (TextView) grid.findViewById(R.id.discountprice);
        names.setText(name[position]);
        prices.setText(actual[position]);
        discounts.setText(discount[position]);
        imageView.setImageResource(Imageid[position]);



        return grid;
    }
}
