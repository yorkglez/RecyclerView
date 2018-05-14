package com.pmoviles.fsociety.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolderArtist>{
    private  final Context context;
    private List<Artist> datos;

    public AdapterRecycler(Context context, List<Artist> datos) {
        this.context = context;
        this.datos = datos;
    }


    @NonNull
    @Override

    public ViewHolderArtist onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);

        return new ViewHolderArtist(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArtist holder, int position) {
        Artist artist = datos.get(position);
        holder.txtname.setText(artist.getName());
        holder.texPhone.setText(artist.getName());
        holder.ratingBar.setRating((float)artist.getRating());
        if (artist.CheckImage()){

        }
        else {
            holder.cImage.setImageResource(R.drawable.img_none);
        }
    }



    

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public  static  class ViewHolderArtist extends RecyclerView.ViewHolder {
        @BindView(R.id.nombre_artista)
        TextView txtname;
        @BindView(R.id.rating)
        RatingBar ratingBar;
        @BindView(R.id.telefono)
        TextView texPhone;
        @BindView(R.id.avatar)
        CircleImageView cImage;

        public ViewHolderArtist(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);


        }
    }

}
