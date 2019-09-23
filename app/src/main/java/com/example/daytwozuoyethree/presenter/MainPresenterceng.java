package com.example.daytwozuoyethree.presenter;


import com.example.daytwozuoyethree.bean.Beanone;
import com.example.daytwozuoyethree.model.MainModel;
import com.example.daytwozuoyethree.view.MainView;

public class MainPresenterceng implements MainPresenter, MainView {
    private MainModel mainModel;
    private MainView mainView;

    public MainPresenterceng(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    @Override
    public void getData() {
        mainModel.getData(this);
    }

    @Override
    public void onSeecss(Beanone beanone) {
        mainView.onSeecss(beanone);
    }

    @Override
    public void onError(String str) {
        mainView.onError(str);
    }
}
