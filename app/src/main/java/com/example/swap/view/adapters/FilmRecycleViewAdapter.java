package com.example.swap.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.swap.R;
import com.example.swap.base.BaceRecycleViewAdapter;
import com.example.swap.data.api.model.Film;
import com.example.swap.view.listeners.ItemClickListener;

import java.util.List;

/**
 * Created by Администратор on 15.12.2016.
 */
public class FilmRecycleViewAdapter extends BaceRecycleViewAdapter<Film, FilmRecycleViewAdapter.ViewHolder> {
    private ItemClickListener<Film> mItemClickListener;

    public FilmRecycleViewAdapter(ItemClickListener<Film> itemClickListener) {
        super();
        mItemClickListener = itemClickListener;
//        setHasStableIds();
    }

    @Override
    public FilmRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_film, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FilmRecycleViewAdapter.ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

//    @Override
//    public long getItemId(int position) {
//        return super.getItemId(position);
//    }

    @Override
    public void update(List<Film> items) {
        setList(items);
        notifyDataSetChanged();
    }

    private Film getItem(int position) {
        return getList().get(position);
    }

    @Override
    public void apply(List<Film> all) {
        setList(all);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDateReleace;
        private TextView mEpisode;
        private TextView mOpenCrawl;
        private LinearLayout linearLayout;
        private View mItemView;

        ViewHolder(View itemView) {
            super(itemView);
            mEpisode = (TextView) itemView.findViewById(R.id.episode);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mDateReleace = (TextView) itemView.findViewById(R.id.release_date);
            mOpenCrawl = (TextView) itemView.findViewById(R.id.opening_crawl);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.llItemContainer);
            mItemView = itemView;
        }


        void bind(final Film film) {
            mEpisode.setText(String.valueOf(film.getEpisode_id()));
            mTitle.setText(film.getTitle());
            mDateReleace.setText(film.getRelease_date());
            mOpenCrawl.setText(film.getOpening_crawl());
//            mItemView.setOnClickListener();
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(film);
                }
            });
            linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mItemClickListener.onItemLongClicked(film);
                    return true;
                }
            });
        }
    }


}
