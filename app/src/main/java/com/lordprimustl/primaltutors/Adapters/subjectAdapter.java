package com.lordprimustl.primaltutors.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lordprimustl.primaltutors.Models.subject;
import com.lordprimustl.primaltutors.R;

import java.util.List;

import static java.lang.System.out;

/**
 * Created by LordPrimusTL on 9/20/2017.
 */

public class subjectAdapter extends BaseAdapter{

    List<subject> sub;
    Context context;
    private LayoutInflater layoutInflater;
    public subjectAdapter(Context context, List<subject> sub)
    {
        this.context = context;
        this.sub = sub;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return sub.size();
    }

    @Override
    public Object getItem(int i) {
        return sub.get(i);
    }

    @Override
    public long getItemId(int i) {
        return sub.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder ll;
        if(view == null)
        {
            view = layoutInflater.inflate(R.layout.subject_row, null);
            ll = new ViewHolder();
            ll.name = view.findViewById(R.id.sub_name);
            view.setTag(ll);
        }
        else {
            ll = (ViewHolder) view.getTag();
        }
        ll.name.setText(sub.get(i).getName());
        return view;
    }

    static class ViewHolder {
        TextView name;
    }
}
