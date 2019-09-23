package com.example.daytwozuoyethree;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daytwozuoyethree.adapter.Adapterrlvone;
import com.example.daytwozuoyethree.adapter.FragmentPageAdap;
import com.example.daytwozuoyethree.bean.Beanone;
import com.example.daytwozuoyethree.model.MainModelceng;
import com.example.daytwozuoyethree.presenter.MainPresenterceng;
import com.example.daytwozuoyethree.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRlv;
    private ArrayList<Beanone.ResultsBean> list;
    private Adapterrlvone adapterrlvone;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;
    private TextView mTe;
    private List<Beanone.ResultsBean> results;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mTe = (TextView) findViewById(R.id.te);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRlv.setLayoutManager(staggeredGridLayoutManager);
//        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        list = new ArrayList<>();
        adapterrlvone = new Adapterrlvone(list, this);
        mRlv.setAdapter(adapterrlvone);

        adapterrlvone.setOnItemClickListener(new Adapterrlvone.OnItemClickListener() {
            @Override
            public void OnItemClick(int i) {
                initData();
                page = i;
            }
        });
        initAdd();

    }

    private void initData() {
        Beanone.ResultsBean bean = list.get(page);
        FragmentPageAdap fragmentPageAdap = new FragmentPageAdap(list, bean);
        mVp.setAdapter(fragmentPageAdap);
        mVp.setVisibility(View.VISIBLE);
        mRlv.setVisibility(View.INVISIBLE);
        initAss();
    }

    private void initAss() {
        mTe.setText("第" + 1 + "张/共" + list.size() + "张");
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTe.setText("第" + 1 + "张/共" + list.size() + "张");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initAdd() {
        MainPresenterceng mainPresenterceng = new MainPresenterceng(new MainModelceng(), this);
        mainPresenterceng.getData();
    }

    @Override
    public void onSeecss(Beanone beanone) {
        results = beanone.getResults();
        list.addAll(results);
        adapterrlvone.notifyDataSetChanged();
    }

    @Override
    public void onError(String str) {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }
}
