package com.israelferrer.effectiveandroid.ui.views;


import com.israelferrer.effectiveandroid.entities.Test;

import java.util.List;

public interface TopTestsListView {
    void setArticles(List<Test> tests);

    void logout();
}
