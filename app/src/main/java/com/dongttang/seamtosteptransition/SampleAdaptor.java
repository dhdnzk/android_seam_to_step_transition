package com.dongttang.seamtosteptransition;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SampleAdaptor extends RecyclerView.Adapter<SampleAdaptor.ViewHolder> {

    private int count;
    private RecyclerViewClickListener recyclerViewClickListener;


    SampleAdaptor(int num, RecyclerViewClickListener recyclerViewClickListener) {

        this.count = num;
        this.recyclerViewClickListener = recyclerViewClickListener;

    }

    @Override
    public SampleAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.view_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SampleAdaptor.ViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return count;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);

            this.textView = itemView.findViewById(R.id.listItemTextView);
            itemView.setOnClickListener(this);

        }

        void bind(int position) {

            textView.setText(String.valueOf(position));

        }

        @Override
        public void onClick(View view) {

            recyclerViewClickListener.onListItemClicked(getAdapterPosition());

        }
    }

    public interface RecyclerViewClickListener {

        void onListItemClicked(int position);

    }

}
