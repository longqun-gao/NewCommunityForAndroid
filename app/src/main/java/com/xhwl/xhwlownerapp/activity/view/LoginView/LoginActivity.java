package com.xhwl.xhwlownerapp.activity.view.LoginView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.xhwl.xhwlownerapp.R;
import com.xhwl.xhwlownerapp.UIUtils.BaseActivity;
import com.xhwl.xhwlownerapp.activity.view.LoginView.LoginFragment.PasswordFragment;
import com.xhwl.xhwlownerapp.activity.view.LoginView.LoginFragment.YzmFragment;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 密码和短信验证码登录
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 密码
     */
    private TextView mLoginPassword;
    /**
     * 验证码
     */
    private TextView mLoginYzm;
    private ViewPager mLoginViewPager;
    private AutoLinearLayout mLoginWechat;
    private AutoLinearLayout mLoginQq;
    private AutoLinearLayout mLoginWeibo;
    private FragmentManager fragmentManager;//碎片管理者对象
    private List<Fragment> fragmentList;
    private AutoLinearLayout mLoginAgreementAutoLayout;
    /**
     * <u>小七当家用户服务协议</u>
     */
    private TextView mLoginAgreementAutoLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    private void initData() {
        //添加数据源
        fragmentList = new ArrayList<>();
        fragmentList.add(new PasswordFragment());
        fragmentList.add(new YzmFragment());

        //获得管理者对象
        fragmentManager = getSupportFragmentManager();
        //碎片滑动，适配器
        mLoginViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        //点击事件
        mLoginViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onPageSelected(int position) {
                reset();//重置文字颜色
                switch (position) {
                    case 0:
                        mLoginPassword.setTextColor(getResources().getColor(R.color.login_yzm_1));
                        mLoginAgreementAutoLayout.setVisibility(View.GONE);
                        break;
                    case 1:
                        mLoginYzm.setTextColor(getResources().getColor(R.color.login_yzm_1));
                        mLoginAgreementAutoLayout.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mLoginViewPager.setCurrentItem(0);  //初始化显示第一个页面
        mLoginPassword.setTextColor(getResources().getColor(R.color.login_yzm_1));

    }

    //改变图片 字体的颜色为暗色
    @SuppressLint("ResourceAsColor")
    private void reset() {
        //设置图片变为暗色
        mLoginPassword.setTextColor(getResources().getColor(R.color.login_yzm_0));
        mLoginYzm.setTextColor(getResources().getColor(R.color.login_yzm_0));

    }

    private void initView() {
        mLoginPassword = (TextView) findViewById(R.id.login_password);
        mLoginPassword.setOnClickListener(this);
        mLoginYzm = (TextView) findViewById(R.id.login_yzm);
        mLoginYzm.setOnClickListener(this);
        mLoginViewPager = (ViewPager) findViewById(R.id.login_viewPager);
        mLoginWechat = (AutoLinearLayout) findViewById(R.id.login_wechat);
        mLoginWechat.setOnClickListener(this);
        mLoginQq = (AutoLinearLayout) findViewById(R.id.login_qq);
        mLoginQq.setOnClickListener(this);
        mLoginWeibo = (AutoLinearLayout) findViewById(R.id.login_weibo);
        mLoginWeibo.setOnClickListener(this);
        mLoginAgreementAutoLayout = (AutoLinearLayout) findViewById(R.id.login_agreement_autoLayout);
        mLoginAgreementAutoLink = (TextView) findViewById(R.id.login_agreement_autoLink);
        mLoginAgreementAutoLink.setOnClickListener(this);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login_password:
                mLoginViewPager.setCurrentItem(0);
                mLoginPassword.setTextColor(getResources().getColor(R.color.login_yzm_1));
                mLoginYzm.setTextColor(getResources().getColor(R.color.login_yzm_0));
                mLoginAgreementAutoLayout.setVisibility(View.GONE);
                break;
            case R.id.login_yzm:
                mLoginViewPager.setCurrentItem(1);
                mLoginYzm.setTextColor(getResources().getColor(R.color.login_yzm_1));
                mLoginPassword.setTextColor(getResources().getColor(R.color.login_yzm_0));
                mLoginAgreementAutoLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.login_wechat:
                //微信登录
                break;
            case R.id.login_qq:
                //QQ登录
                break;
            case R.id.login_weibo:
                //微博登录
                break;
            case R.id.login_agreement_autoLink:
                //用户协议
                break;
        }
    }
}
