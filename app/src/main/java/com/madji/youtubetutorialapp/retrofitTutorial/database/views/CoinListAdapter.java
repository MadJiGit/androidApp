package com.madji.youtubetutorialapp.retrofitTutorial.database.views;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.madji.youtubetutorialapp.retrofitTutorial.database.db_data.OneCoinData;


public class CoinListAdapter extends ListAdapter<OneCoinData, OneCoinViewHolder> {


    public CoinListAdapter(@NonNull DiffUtil.ItemCallback<OneCoinData> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public OneCoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return OneCoinViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull OneCoinViewHolder holder, int position) {
        OneCoinData oneCoinData = getItem(position);
        holder.bind(oneCoinData.getNickName(),
                oneCoinData.getFullName(),
                oneCoinData.getAmount(),
                oneCoinData.getPurchasePrice(),
                oneCoinData.getDataPurchased()
        );
    }

    public static class CoinDiff extends DiffUtil.ItemCallback<OneCoinData> {

        @Override
        public boolean areItemsTheSame(@NonNull OneCoinData oldItem, @NonNull OneCoinData newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull OneCoinData oldItem, @NonNull OneCoinData newItem) {
            return oldItem.getId() == (newItem.getId());
        }
    }
}
