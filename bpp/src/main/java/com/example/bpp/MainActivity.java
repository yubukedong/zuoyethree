package com.example.bpp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bpp.bean.Beanone;
import com.example.bpp.model.MainModelceng;
import com.example.bpp.presenter.Mainpresenterceng;
import com.example.bpp.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        initAdd();
    }

    private void initAdd() {
        Mainpresenterceng mainpresenterceng = new Mainpresenterceng(new MainModelceng(), this);
    }

    @Override
    public void onSccess(Beanone beanone) {

    }

    @Override
    public void onError(String str) {

    }
}
