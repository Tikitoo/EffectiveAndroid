package com.israelferrer.effectiveandroid.ui.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.israelferrer.effectiveandroid.R;
import com.israelferrer.effectiveandroid.entities.Test;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icamacho on 8/9/15.
 */
public class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.TestViewHolder> {
    private List<Test> items;

    public TestRecyclerAdapter(List<Test> items) {
        if (items == null) {
            throw new NullPointerException(
                    "items must not be null");
        }
        this.items = items;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.test_layout, parent, false);
        return new TestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        final Test test = items.get(position);
        holder.bind(test);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Test getItem(int position) {
        return items.get(position);
    }

    final static class TestViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.id)
        TextView id;
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.gender)
        TextView gender;

        public TestViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Test test) {
            id.setText(test.getId());
            name.setText(test.getName());
            gender.setText(test.getGender());
            /*if (!TextUtils.isEmpty(test.getGender())) {
                holder.media.setVisibility(View.VISIBLE);
//            Picasso.with(holder.media.getContext()).load(test.getMediaUrl()).into(holder.media);
            } else {
                holder.media.setVisibility(View.GONE);
            }       */
        }
    }
}
