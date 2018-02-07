package com.xhwl.xhwlownerapp.activity.view.UserInfoView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xhwl.xhwlownerapp.R;
import com.xhwl.xhwlownerapp.UIUtils.BaseActivity;
import com.xhwl.xhwlownerapp.activity.view.UserInfoView.adapter.ModifySexListAdapter;
import com.xhwl.xhwlownerapp.entity.InfoEntity.SexList;

import java.util.ArrayList;
import java.util.List;

/**
 * 修改性别
 */
public class ModifySexActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mTopBack;
    /**  */
    private TextView mTopTitle;
    private ListView mSexList;
    private List<SexList> sexsList; //用于装载数据的集合
    private SexList selectSex;//用户选择的性别

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_sex);
        initView();
        initDatas();
    }

    private void initView() {
        mTopBack = (ImageView) findViewById(R.id.top_back);
        mTopBack.setOnClickListener(this);
        mTopTitle = (TextView) findViewById(R.id.top_title);
        mSexList = (ListView) findViewById(R.id.sex_list);
        mTopTitle.setText("设置性别");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.top_back:
                break;
        }
    }

    private void initDatas(){
        //初始化ListView适配器的数据
        selectSex = new SexList();
        sexsList = new ArrayList<>();
        SexList brand0 = new SexList("男");
        SexList brand1 = new SexList("女");
        sexsList.add(brand0);
        sexsList.add(brand1);

        final ModifySexListAdapter myAdapter = new ModifySexListAdapter(this,sexsList);
        mSexList.setAdapter(myAdapter);
        mSexList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取选中的参数
                //selectPosition = position;
//                myAdapter.notifyDataSetChanged();
//                selectSex = sexsList.get(position);
                ModifySexListAdapter.ViewHolder viewHolder = (ModifySexListAdapter.ViewHolder) view.getTag();
                viewHolder.cb.toggle();// 把CheckBox的选中状态改为当前状态的反,gridview确保是单一选中
                Toast.makeText(ModifySexActivity.this,"性别："+sexsList.get(position).getSex(), Toast.LENGTH_SHORT).show();
        }
        });
    }


}
