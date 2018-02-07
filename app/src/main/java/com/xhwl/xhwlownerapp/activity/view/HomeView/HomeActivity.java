package com.xhwl.xhwlownerapp.activity.view.HomeView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xhwl.xhwlownerapp.R;
import com.xhwl.xhwlownerapp.UIUtils.BaseActivity;
import com.xhwl.xhwlownerapp.UIUtils.NoScrollViewPager;
import com.xhwl.xhwlownerapp.activity.view.HomeView.HomeFragment.CarFragment;
import com.xhwl.xhwlownerapp.activity.view.HomeView.HomeFragment.DisburdenFragment;
import com.xhwl.xhwlownerapp.activity.view.HomeView.HomeFragment.GoodLinessFragment;
import com.xhwl.xhwlownerapp.activity.view.HomeView.HomeFragment.HumanDecencyFragment;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mHomeTopMore;
    /**
     * 人行
     */
    private TextView mTopLayoutTitle;
    private ImageView mHomeTopScan;
    private NoScrollViewPager mHomeViewPager;
    private FrameLayout mHomeFrameLayout;
    private ImageView mHomeHumanDecencyImg;
    /**
     * 人来
     */
    private TextView mHomeHumanDecencyText;
    private AutoLinearLayout mHumanDecencyLayout;
    private ImageView mHomeCarImg;
    /**
     * 车往
     */
    private TextView mHomeCarText;
    private AutoLinearLayout mHomeCarLayout;
    private ImageView mHomeOpenDoor;
    private ImageView mHomeDisburdenImg;
    /**
     * 安心
     */
    private TextView mHomeDisburdenText;
    private AutoLinearLayout mHomeDisburdenLayout;
    private TextView mHomeGoodLinessText;
    /**
     * 美好
     */
    private ImageView mHomeGoodLinessImg;
    private AutoLinearLayout mHomeGoodLinessLayout;

    private FragmentManager fragmentManager;//碎片管理者对象
    private List<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initData() {
        reset();
        //添加数据源
        fragmentList = new ArrayList<>();
        fragmentList.add(new HumanDecencyFragment());
        fragmentList.add(new CarFragment());
        fragmentList.add(new DisburdenFragment());
        fragmentList.add(new GoodLinessFragment());
        //获得管理者对象
        fragmentManager = getSupportFragmentManager();
        //碎片滑动，适配器
        mHomeViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });


        mHomeViewPager.setCurrentItem(0);  //初始化显示第一个页面
        mHomeHumanDecencyText.setTextColor(getResources().getColor(R.color.login_yzm_1));
        mHomeHumanDecencyImg.setBackgroundResource(R.drawable.home_bottom_human_decency_1);
    }

    private void initView() {
        mHomeTopMore = (ImageView) findViewById(R.id.home_top_more);
        mHomeTopMore.setOnClickListener(this);
        mTopLayoutTitle = (TextView) findViewById(R.id.top_layout_title);
        mHomeTopScan = (ImageView) findViewById(R.id.home_top_scan);
        mHomeTopScan.setOnClickListener(this);
        mHomeViewPager = (NoScrollViewPager) findViewById(R.id.home_viewPager);
        //设置ViewPager不可左右滑动
        mHomeViewPager.setScanScroll(false);
        mHomeFrameLayout = (FrameLayout) findViewById(R.id.home_frameLayout);
        mHomeHumanDecencyImg = (ImageView) findViewById(R.id.home_human_decency_img);
        mHomeHumanDecencyText = (TextView) findViewById(R.id.home_human_decency_text);
        mHumanDecencyLayout = (AutoLinearLayout) findViewById(R.id.human_decency_layout);
        mHumanDecencyLayout.setOnClickListener(this);
        mHomeCarImg = (ImageView) findViewById(R.id.home_car_img);
        mHomeCarText = (TextView) findViewById(R.id.home_car_text);
        mHomeCarLayout = (AutoLinearLayout) findViewById(R.id.home_car_layout);
        mHomeCarLayout.setOnClickListener(this);
        mHomeOpenDoor = (ImageView) findViewById(R.id.home_open_door);
        mHomeOpenDoor.setOnClickListener(this);
        mHomeDisburdenImg = (ImageView) findViewById(R.id.home_disburden_img);
        mHomeDisburdenLayout = (AutoLinearLayout) findViewById(R.id.home_disburden_layout);
        mHomeDisburdenLayout.setOnClickListener(this);
        mHomeGoodLinessText = (TextView) findViewById(R.id.home_good_liness_text);
        mHomeGoodLinessImg = (ImageView) findViewById(R.id.home_good_liness_img);
        mHomeGoodLinessLayout = (AutoLinearLayout) findViewById(R.id.home_good_liness_layout);
        mHomeGoodLinessLayout.setOnClickListener(this);
        mHomeDisburdenText = (TextView) findViewById(R.id.home_disburden_text);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            default:
                break;
            case R.id.home_top_more:
                //个人中心

                break;
            case R.id.home_top_scan:
                //扫一扫

                break;
            case R.id.human_decency_layout:
                //人来
                reset();
                mHomeViewPager.setCurrentItem(0);
                mHomeHumanDecencyText.setTextColor(getResources().getColor(R.color.login_yzm_1));
                mHomeHumanDecencyImg.setBackgroundResource(R.drawable.home_bottom_human_decency_1);
                break;
            case R.id.home_car_layout:
                //车往
                reset();
                mHomeViewPager.setCurrentItem(1);
                mHomeCarText.setTextColor(getResources().getColor(R.color.login_yzm_1));
                mHomeCarImg.setBackgroundResource(R.drawable.home_bottom_car_1);

                break;
            case R.id.home_open_door:
                //一键蓝牙开门

                break;
            case R.id.home_disburden_layout:
                //安心
                reset();
                mHomeViewPager.setCurrentItem(2);
                mHomeDisburdenText.setTextColor(getResources().getColor(R.color.login_yzm_1));
                mHomeDisburdenImg.setBackgroundResource(R.drawable.home_bottom_disburden_1);
                break;
            case R.id.home_good_liness_layout:
                //美好
                reset();
                mHomeViewPager.setCurrentItem(3);
                mHomeGoodLinessText.setTextColor(getResources().getColor(R.color.login_yzm_1));
                mHomeGoodLinessImg.setBackgroundResource(R.drawable.home_bottom_good_liness_1);

                break;
        }
    }

    //改变图片 字体的颜色为暗色
    @SuppressLint("ResourceAsColor")
    private void reset() {
        //设置图片变为暗色
        //人来
        mHomeHumanDecencyText.setTextColor(getResources().getColor(R.color.info_basic_info));
        mHomeHumanDecencyImg.setBackgroundResource(R.drawable.home_bottom_human_decency);
        //车往
        mHomeCarText.setTextColor(getResources().getColor(R.color.info_basic_info));
        mHomeCarImg.setBackgroundResource(R.drawable.home_bottom_car);
        //安心
        mHomeDisburdenText.setTextColor(getResources().getColor(R.color.info_basic_info));
        mHomeDisburdenImg.setBackgroundResource(R.drawable.home_bottom_disburden);
        //美好
        mHomeGoodLinessText.setTextColor(getResources().getColor(R.color.info_basic_info));
        mHomeGoodLinessImg.setBackgroundResource(R.drawable.home_bottom_good_liness);
    }
}
