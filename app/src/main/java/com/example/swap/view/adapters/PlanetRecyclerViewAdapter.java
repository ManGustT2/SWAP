package com.example.swap.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.swap.R;
import com.example.swap.base.BaceRecycleViewAdapter;
import com.example.swap.data.api.model.Planets;
import com.example.swap.view.listeners.ItemClickListener;
import java.util.List;


public class PlanetRecyclerViewAdapter extends BaceRecycleViewAdapter<Planets, PlanetRecyclerViewAdapter.ViewHolder> {

    private ItemClickListener<Planets> mItemClickListener;

    public PlanetRecyclerViewAdapter(ItemClickListener<Planets> itemClickListener) {
        super();
        mItemClickListener = itemClickListener;
    }

    @Override
    public PlanetRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_planet, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlanetRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.bind(getItem(position));

    }

    @Override
    public void update(List<Planets> items) {
        setList(items);
        notifyDataSetChanged();

    }

    @Override
    public void apply(List<Planets> all) {
        setList(all);
        notifyDataSetChanged();

    }

    private Planets getItem(int position) {
        return getList().get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayout;
        private TextView mName;
        private TextView mRotationPeriod;
        private TextView mOrbitalPeriod;
        private TextView mDiametr;
        private View mItemView;

        public ViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.planet_name);
            mRotationPeriod = (TextView) itemView.findViewById(R.id.rotation_period);
            mOrbitalPeriod = (TextView) itemView.findViewById(R.id.orbital_period);
            mDiametr = (TextView) itemView.findViewById(R.id.diameter_planet);

        }


        void bind(final Planets planets) {
            mName.setText(String.valueOf(planets.getName()));
            mRotationPeriod.setText(String.valueOf(planets.getRotation_period()));
            mOrbitalPeriod.setText(String.valueOf(planets.getOrbital_period()));
            mDiametr.setText(String.valueOf(planets.getDiameter()));
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(planets);
                }
            });

            linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mItemClickListener.onItemLongClicked(planets);
                    return true;
                }
            });

        }
    }
}
