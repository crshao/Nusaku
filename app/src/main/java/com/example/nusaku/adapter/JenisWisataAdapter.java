package com.example.nusaku.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nusaku.R;
import com.example.nusaku.models.DestinationTypeData;
import com.example.nusaku.models.JenisWisata;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class JenisWisataAdapter extends RecyclerView.Adapter<JenisWisataAdapter.ViewHolder> {

    private ArrayList<DestinationTypeData> mDestinationType;
    private Context mContext;

    public JenisWisataAdapter(ArrayList<DestinationTypeData> mDestinationType, Context mContext) {
        this.mDestinationType = mDestinationType;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public JenisWisataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jeniswisata, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JenisWisataAdapter.ViewHolder holder, int position) {
        holder.judul.setText(mDestinationType.get(position).getTitle());
//        holder.image.setImageResource(mDestinationType.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mDestinationType.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        MaterialTextView judul;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_item);
            judul = itemView.findViewById(R.id.judul_item);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                DestinationTypeData destinationTypeData = mDestinationType.get(position);
                Toast.makeText(mContext, "Jenis Wisata: " + destinationTypeData.getTitle()
                        , Toast.LENGTH_SHORT);
            });
        }
    }
}
