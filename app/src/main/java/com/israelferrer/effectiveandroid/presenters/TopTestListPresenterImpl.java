package com.israelferrer.effectiveandroid.presenters;

import com.israelferrer.effectiveandroid.entities.Test;
import com.israelferrer.effectiveandroid.ui.views.TopTestsListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by icamacho on 8/15/15.
 */
public class TopTestListPresenterImpl implements TopTestListPresenter {
    private TopTestsListView mView;
    private List<Test> mTests;

    public TopTestListPresenterImpl(TopTestsListView topTestsListView) {
        mView = topTestsListView;
    }

    @Override
    public void create() {
        if (mTests == null) {
            mTests = new ArrayList<>();
            mTests.addAll(addData());
            mView.setArticles(mTests);
        } else {
            mView.setArticles(mTests);
        }
    }

    private List<Test> addData() {
        List<Test> tests = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Test test = new Test();
            test.id = i + "";
            test.name = "dfa" + i;
            test.gender = new Random().nextInt(2) == 1 ? "男" : "女";
            tests.add(test);
        }
        return tests;
    }

    @Override
    public void setView(TopTestsListView view) {
        mView = view;
    }
}
