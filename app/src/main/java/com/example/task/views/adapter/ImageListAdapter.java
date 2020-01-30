package com.example.task.views.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task.R;
import com.example.task.databinding.ItemViewBinding;
import com.example.task.views.uimodel.ImageUIModel;

import java.util.ArrayList;
import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

    private List<ImageUIModel> list = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemViewBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_view, parent, false);
        return new ViewHolder(binding);
    }

    public void setList(List<ImageUIModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ItemViewBinding itemViewBinding;

        public ViewHolder(@NonNull ItemViewBinding itemView) {
            super(itemView.getRoot());
            itemViewBinding = itemView;
        }

        public void bind(ImageUIModel list) {
           Glide.with(itemViewBinding.getRoot()).load(list.getImageUrl()).into(itemViewBinding.ivThumbImage);
           itemViewBinding.tvDesc.setText(list.getImageDesc());
        }
    }
}
