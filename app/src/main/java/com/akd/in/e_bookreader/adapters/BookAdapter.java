package com.akd.in.e_bookreader.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.akd.in.e_bookreader.R;

public class BookAdapter extends RecyclerView.Adapter {



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_adapter, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        ((BookViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return BookData.BookTitle.length;
    }

    private class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTxtTitle;
        private ImageView mBookImg;


        public BookViewHolder(View itemView) {
            super(itemView);
            mTxtTitle = itemView.findViewById(R.id.txtBookTitle);
            mBookImg = itemView.findViewById(R.id.bookImg);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mTxtTitle.setText(BookData.BookTitle[position]);
            mBookImg.setImageResource(BookData.BookImage[position]);
        }


        @Override
        public void onClick(View v) {

        }
    }


}