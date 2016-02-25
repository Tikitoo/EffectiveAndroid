package com.israelferrer.effectiveandroid.presenters;

import com.israelferrer.effectiveandroid.ui.views.TopTestsListView;

/**
 * Created by icamacho on 8/15/15.
 */
public interface TopTestListPresenter extends Presenter {
    void create();

    void setView(TopTestsListView view);
}
