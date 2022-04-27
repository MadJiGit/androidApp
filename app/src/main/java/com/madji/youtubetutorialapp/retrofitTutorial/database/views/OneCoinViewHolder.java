package com.madji.youtubetutorialapp.retrofitTutorial.database.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.madji.youtubetutorialapp.R;

public class OneCoinViewHolder extends RecyclerView.ViewHolder {
    private final TextView _coinNickName;
    private final TextView _coinName;
    private final TextView _amount;
    private final TextView _purchasePrice;
    private final TextView _currentPrice;
    private final TextView _datePurchase;

    private OneCoinViewHolder(View itemView) {
        super(itemView);
        _coinNickName = itemView.findViewById(R.id.coinNickName);
        _coinName = itemView.findViewById(R.id.coinName);
        _amount = itemView.findViewById(R.id.amount);
        _purchasePrice = itemView.findViewById(R.id.purchasePrice);
        _currentPrice = itemView.findViewById(R.id.currentPrice);
        _datePurchase = itemView.findViewById(R.id.datePurchase);
    }

    public void bind(String coinNickName, String coinName,
                     String amount, String purchasePrice,
                     String datePurchase) {
        _coinNickName.setText(coinNickName);
        _coinName.setText(coinName);
        _amount.setText(amount);
        _purchasePrice.setText(purchasePrice);
        _currentPrice.setText("0.00");
        _datePurchase.setText(datePurchase);
    }

    static OneCoinViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_coin_view, parent, false);
        return new OneCoinViewHolder(view);
    }
}
