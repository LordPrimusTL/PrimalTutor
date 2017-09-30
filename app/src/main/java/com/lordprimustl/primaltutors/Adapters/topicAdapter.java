package com.lordprimustl.primaltutors.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lordprimustl.primaltutors.Models.topic;
import com.lordprimustl.primaltutors.R;

import java.util.List;

/**
 * Created by LordPrimusTL on 9/22/2017.
 */

public class topicAdapter extends BaseAdapter {

    private List<topic> topics;
    private Context context;
    private LayoutInflater inflater;
    public topicAdapter(Context context, List<topic> top)
    {
        this.context = context;
        this.topics = top;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return topics.size();
    }

    @Override
    public Object getItem(int i) {
        return topics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return topics.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder ll;
        if(view == null)
        {
            view = inflater.inflate(R.layout.topic_row,null);
            ll = new ViewHolder();
            ll.name = view.findViewById(R.id.topic_name);
            view.setTag(ll);
        }
        else {
            ll = (ViewHolder) view.getTag();
        }
        ll.name.setText(topics.get(i).getName());
        return view;
    }

    static class ViewHolder {
        TextView name;
    }
}
