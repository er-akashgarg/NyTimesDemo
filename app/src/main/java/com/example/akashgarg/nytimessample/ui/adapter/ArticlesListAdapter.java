package com.example.akashgarg.nytimessample.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akashgarg.nytimessample.R;
import com.example.akashgarg.nytimessample.models.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesListAdapter extends RecyclerView.Adapter<ArticlesListAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<ResultsItem> articlesList;

    public ArticlesListAdapter(Context context) {
        this.mContext = context;
        articlesList = new ArrayList<>(0);
        inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = inflater.inflate(R.layout.layout_articlelist_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        bindData(holder, position);
    }

    private void bindData(MyViewHolder holder, int position) {
        ResultsItem item = articlesList.get(position);
        holder.tvArticleName.setText(item.getTitle());
        if (!item.getByline().isEmpty()) {
            holder.tvAtriclesDesc.setText(item.getByline());
            holder.tvAtriclesDesc.setVisibility(View.VISIBLE);
        } else
            holder.tvAtriclesDesc.setVisibility(View.GONE);

        holder.tvAtriclesDate.setText(item.getPublishedDate());
        item = null;
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvAtriclesName)
        TextView tvArticleName;

        @BindView(R.id.tvAtriclesDesc)
        TextView tvAtriclesDesc;

        @BindView(R.id.tvArticleDate)
        TextView tvAtriclesDate;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void updateList(@NonNull List<ResultsItem> result) {
        this.articlesList = result;
        notifyDataSetChanged();
    }

    public void destroyResource() {
        articlesList = null;
        mContext = null;
    }
}
