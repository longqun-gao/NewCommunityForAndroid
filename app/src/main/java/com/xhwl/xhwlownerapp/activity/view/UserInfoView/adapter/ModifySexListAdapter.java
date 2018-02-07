package com.xhwl.xhwlownerapp.activity.view.UserInfoView.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.xhwl.xhwlownerapp.R;
import com.xhwl.xhwlownerapp.entity.InfoEntity.SexList;

import java.util.List;

/**
 * Created by Administrator on 2018/1/30.
 */

public class ModifySexListAdapter extends BaseAdapter {
    Activity activity;
    List<SexList> sexList;
    LayoutInflater mInflater;
    private int selectPosition = -1;//用于记录用户选择的变量
    public ModifySexListAdapter(Activity context, List<SexList> mList) {
        this.activity = context;
        this.sexList = mList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sexList.size();
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
            view = mInflater.inflate(R.layout.sex_adapter_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.id_name);
            //viewHolder.select = (RadioButton) view.findViewById(R.id.id_select);
            viewHolder.cb = (CheckBox) view.findViewById(R.id.item_cb);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //设置list的textview显示
        viewHolder.name.setText(sexList.get(i).getSex());
        // 根据isSelected来设置checkbox的选中状况
        viewHolder.cb.setId(i);//对checkbox的id进行重新设置为当前的position
        viewHolder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {//实现checkbox的单选功能,同样适用于radiobutton
                    if (selectPosition != -1) {
                        //找到上次点击的checkbox,并把它设置为false,对重新选择时可以将以前的关掉
                        CheckBox tempCheckBox = (CheckBox) activity.findViewById(selectPosition);
                        if (tempCheckBox != null)
                            tempCheckBox.setChecked(false);
                    }
                    selectPosition = compoundButton.getId();//保存当前选中的checkbox的id值
                }
            }
        });
        if (i == selectPosition)//比对position和当前的temp是否一致
            viewHolder.cb.setChecked(true);
        else
            viewHolder.cb.setChecked(false);
        return view;
    }
    public class ViewHolder {
        TextView name;
        public RadioButton select;
        public CheckBox cb;
    }
}

