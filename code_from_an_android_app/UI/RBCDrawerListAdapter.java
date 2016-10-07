package com.example.tmutabazi.rbc.UI;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmutabazi.rbc.R;

import java.util.ArrayList;

public class RBCDrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<RBCDrawerItem> RBCDrawerItems;

    public RBCDrawerListAdapter(Context context, ArrayList<RBCDrawerItem> RBCDrawerItems){
        this.context = context;
        this.RBCDrawerItems = RBCDrawerItems;
    }

    @Override
    public int getCount() {
        return RBCDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return RBCDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

        imgIcon.setImageResource(RBCDrawerItems.get(position).getIcon());
        txtTitle.setText(RBCDrawerItems.get(position).getTitle());

        // displaying count
        // check whether it set visible or not
        if(RBCDrawerItems.get(position).getCounterVisibility()){
            txtCount.setText(RBCDrawerItems.get(position).getCount());
        }else{
            // hide the counter view
            txtCount.setVisibility(View.GONE);
        }

        return convertView;
    }

}