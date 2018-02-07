package com.xhwl.xhwlownerapp.activity.view.HomeView.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xhwl.xhwlownerapp.R;
import com.xhwl.xhwlownerapp.entity.HomeEntity.TravelRecord;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class TraveRecordAdapter extends BaseAdapter {
    private List<TravelRecord> recordList;
    private Activity activity;
    private LayoutInflater mInflater;

    public TraveRecordAdapter(Activity context, List<TravelRecord> mList) {
        this.activity = context;
        this.recordList = mList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

     @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.travel_record_adapter, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.TraveName = (TextView) view.findViewById(R.id.travel_record_list_name);
            viewHolder.TraveDoorName = (TextView) view.findViewById(R.id.travel_record_list_doorname);
            viewHolder.TraveTime = (TextView) view.findViewById(R.id.travel_record_list_time);
            viewHolder.TraveOut = (TextView) view.findViewById(R.id.travel_record_list_out);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //设置list的textview显示
        viewHolder.TraveName.setText(recordList.get(i).getTraveName());
        viewHolder.TraveDoorName.setText(recordList.get(i).getTraveDoor());
        viewHolder.TraveTime.setText(recordList.get(i).getTraveTime());
        viewHolder.TraveOut.setText(recordList.get(i).getTreveOut());
        return view;
    }
    public class ViewHolder {
        TextView TraveName,TraveDoorName,TraveTime,TraveOut;
    }
}
