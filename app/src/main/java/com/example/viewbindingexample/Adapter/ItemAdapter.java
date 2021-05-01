package com.example.viewbindingexample.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.viewbindingexample.Model.ItemModel;
import com.example.viewbindingexample.R;
import com.example.viewbindingexample.databinding.ItemBinding;

import java.net.URL;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemHolder> {

    ArrayList<ItemModel> itemModelArrayList;
    Context context;

    // make constructor for ItemAdapter
    public ItemAdapter(ArrayList<ItemModel> itemModelArrayList, Context context) {
        this.itemModelArrayList = itemModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return new itemHolder(ItemBinding.inflate(layoutInflater));
    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {

        holder.binding.textViewCountry.setText(itemModelArrayList.get(position).getCountry() + "");
        holder.binding.textViewDescription.setText(itemModelArrayList.get(position).getDescription() + "");

        //set image from url
        try {
            URL url = new URL(itemModelArrayList.get(position).getImage() + "");
            Log.d("image_url", url + "");
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round);
            Glide.with(context).load(url).apply(options).into(holder.binding.imageView);

        } catch (Exception e) {
            Log.d("Error", e + "");
        }

        holder.binding.imageViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemModelArrayList.size();
    }

    class itemHolder extends RecyclerView.ViewHolder {
        ItemBinding binding;

        itemHolder(ItemBinding b) {

            super(b.getRoot());
            binding = b;
        }

    }

    class menuClickListener implements PopupMenu.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.change_image:
                    Toast.makeText(context, "Change image select", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.more:
                    Toast.makeText(context, "More select", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    }

    public void showMenu(View view) {

        PopupMenu popupMenu = new PopupMenu(context, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new menuClickListener());
        popupMenu.show();

    }

}
