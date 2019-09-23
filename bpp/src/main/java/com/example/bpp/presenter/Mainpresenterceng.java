package com.example.bpp.presenter;

import com.example.bpp.bean.Beanone;
import com.example.bpp.model.MainModel;
import com.example.bpp.view.MainView;

public class Mainpresenterceng implements Mainpresenter, MainView {
    private MainModel mainModel;
    private MainView mainView;

    public Mainpresenterceng(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void getData() {
        mainModel.getData(this);
    }

    @Override
    public void onSccess(Beanone beanone) {
        mainView.onSccess(beanone);
    }

    @Override
    public void onError(String str) {
        mainView.onError(str);
    }
}
