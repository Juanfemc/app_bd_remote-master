package com.narvasoft.bd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, direccion;
        ImageView fotoHotel;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre =(TextView)itemView.findViewById(R.id.textViewNombre);
            direccion =(TextView)itemView.findViewById(R.id.textViewServicio);
            fotoHotel =(ImageView)itemView.findViewById(R.id.imageViewHotel);
        }
    }

    public List<Hoteles> hotelList;

    public Adapter(List<Hoteles> hotelList) {
        this.hotelList = hotelList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_hoteles,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(hotelList.get(position).getNombre());
        holder.direccion.setText(hotelList.get(position).getDireccion());
        holder.fotoHotel.setImageResource(hotelList.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }
}