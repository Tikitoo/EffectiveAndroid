package com.israelferrer.effectiveandroid.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.israelferrer.effectiveandroid.PresenterHolder;
import com.israelferrer.effectiveandroid.R;
import com.israelferrer.effectiveandroid.entities.Test;
import com.israelferrer.effectiveandroid.presenters.TopTestListPresenter;
import com.israelferrer.effectiveandroid.presenters.TopTestListPresenterImpl;
import com.israelferrer.effectiveandroid.ui.recycler.TestRecyclerAdapter;
import com.israelferrer.effectiveandroid.ui.views.TopTestsListView;

import java.util.List;

import butterknife.Bind;

public class TopTestListActivity extends EffectiveActivity implements RecyclerView
        .OnItemTouchListener, TopTestsListView {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private TopTestListPresenter mPresenter;
    private TestRecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupRecyclerView();
        setPresenter();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    private void setPresenter() {
        mPresenter = createPresenter();
        mPresenter.create();
    }

    private TopTestListPresenter createPresenter() {
        TopTestListPresenter presenter = PresenterHolder.getInstance()
                .getPresenter(TopTestListPresenter.class);
        if (presenter != null) {
            presenter.setView(this);
        } else {
            presenter = new TopTestListPresenterImpl(this);
        }
        return presenter;
    }

    @NonNull
    @Override
    Integer getLayout() {
        return R.layout.activity_article_list;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @Override
    public void setArticles(List<Test> tests) {
        mAdapter = new TestRecyclerAdapter(tests);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void logout() {

    }
}
