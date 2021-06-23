package com.example.coffeetime;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeetime.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Product> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<Product> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){ return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItem(List<Product> items){ mData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView name, stock, category, price;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.name);
            stock = itemView.findViewById(R.id.stock);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
        }

        public void bindData(final Product item){
            Picasso.get().load(item.getPhotoURI()).into(iconImage);
            name.setText(item.getName());
            stock.setText("Stock: " + item.getStock());
            category.setText("Categoria: " + item.getCategory());
            price.setText("Precio: " + item.getPrice());
        }
    }
}
