package com.xhwl.xhwlownerapp.activity.view.HomeView.HomeFragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.xhwl.xhwlownerapp.R;
import com.xhwl.xhwlownerapp.activity.view.HomeView.adapter.TraveRecordAdapter;
import com.xhwl.xhwlownerapp.entity.HomeEntity.TravelRecord;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HumanDecencyFragment extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 中海华庭
     */
    private TextView mHomeLocationProject;
    private ListView mTravelRecordList;
    private AutoLinearLayout mHomeTravelRecordLayout;
    private AutoLinearLayout mHomeVisitorInvitationLayout;
    private AutoLinearLayout mHomeDoorCarManager;

    private TravelRecord record;
    private List<TravelRecord> recordList;
    // TODO: Rename parameter arguments, choose names that match
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_human_decency, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        TravelRecord record1 = new TravelRecord("吴嘉怡","东门","10:30","入");
        TravelRecord record2 = new TravelRecord("谢媛球","正门","11:30","出");
        TravelRecord record3 = new TravelRecord("宋文光","南门","16:30","入");
        recordList = new ArrayList<>();
        recordList.add(record1);
        recordList.add(record2);
        recordList.add(record3);


        mHomeLocationProject = (TextView) view.findViewById(R.id.home_location_project);
        mHomeLocationProject.setOnClickListener(this);
        mTravelRecordList = (ListView) view.findViewById(R.id.travel_record_list);
        mHomeTravelRecordLayout = (AutoLinearLayout) view.findViewById(R.id.home_travel_record_layout);
        mHomeTravelRecordLayout.setOnClickListener(this);
        mHomeVisitorInvitationLayout = (AutoLinearLayout) view.findViewById(R.id.home_visitor_invitation_layout);
        mHomeVisitorInvitationLayout.setOnClickListener(this);
        mHomeDoorCarManager = (AutoLinearLayout) view.findViewById(R.id.home_door_car_manager);
        mHomeDoorCarManager.setOnClickListener(this);
        mTravelRecordList.setSelector(new ColorDrawable());//设置默认状态选择器为全透明，不传颜色就是没颜色

        TraveRecordAdapter myAdapter = new TraveRecordAdapter(getActivity(),recordList);
        mTravelRecordList.setAdapter(myAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.home_location_project:
                //项目定位
                break;
            case R.id.home_travel_record_layout:
                //出行记录
                break;
            case R.id.home_visitor_invitation_layout:
                //访客邀请
                break;
            case R.id.home_door_car_manager:
                //门卡管理
                break;
        }
    }
}
