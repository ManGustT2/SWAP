package com.example.swap.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swap.R;
import com.example.swap.base.BaceRecycleViewAdapter;
import com.example.swap.data.api.model.People;
import com.example.swap.view.listeners.ItemClickListener;

import java.util.List;

public class PeopleRecyclerViewAdapter extends BaceRecycleViewAdapter<People, PeopleRecyclerViewAdapter.ViewHolder> {

    private ItemClickListener<People> mItemClickListener;

    public PeopleRecyclerViewAdapter(ItemClickListener<People> itemClicklLictener){
        super();
        mItemClickListener = itemClicklLictener;
    }

    @Override
    public PeopleRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_people, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PeopleRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.bind(getItem(position));

    }

    @Override
    public void apply(List<People> all) {
        setList(all);
        notifyDataSetChanged();

    }
    private People getItem(int position) {
        return getList().get(position);
    }

    @Override
    public void update(List<People> items) {
        setList(items);
        notifyDataSetChanged();

    }

     class ViewHolder extends RecyclerView.ViewHolder {
         private TextView mName;
         private TextView mHeight;
         private TextView mMass;
         private TextView mHairColor;
         private LinearLayout linearLayout;
         private View mItemView;


         public ViewHolder(View itemView) {
             super(itemView);
             mName = (TextView) itemView.findViewById(R.id.people_name);
             mHeight = (TextView) itemView.findViewById(R.id.people_height);
             mMass = (TextView) itemView.findViewById(R.id.people_mass);
             mHairColor = (TextView) itemView.findViewById(R.id.hair_color);
             linearLayout = (LinearLayout) itemView.findViewById(R.id.llItemContainer);
             mItemView = itemView;
         }

         void bind (final People people){
             mName.setText(String.valueOf(people.getName()));
             mHeight.setText(String.valueOf(people.getHair_color()));
             mMass.setText(String.valueOf(people.getMass()));
             mHairColor.setText(String.valueOf(people.getHair_color()));
             linearLayout.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     mItemClickListener.onItemClick(people);
                 }
             });
             linearLayout.setOnLongClickListener(new View.OnLongClickListener(){
                 @Override
                 public boolean onLongClick(View view) {
                     mItemClickListener.onItemLongClicked(people);
                     return true;
                 }
             });

         }

    }




}
