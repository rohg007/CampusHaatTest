package com.example.android.campushaattest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.campushaattest.R;
import com.example.android.campushaattest.models.Accomodation;

import java.util.ArrayList;

public class AccomodationAdapter extends RecyclerView.Adapter {

    private ArrayList<Accomodation> dataList;
    private Context context;

    public AccomodationAdapter(ArrayList<Accomodation> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case Accomodation.PG_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pg_card, viewGroup, false);
                return new PgTypeViewHolder(view);

            case Accomodation.HOSTEL_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hostel_card, viewGroup, false);
                return new HostelTypeViewHolder(view);

            case Accomodation.APARTMENT_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.apartment_card, viewGroup, false);
                return new ApartmentTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (dataList.get(position).getType()) {
            case 0:
                return Accomodation.PG_TYPE;
            case 1:
                return Accomodation.HOSTEL_TYPE;
            case 2:
                return Accomodation.APARTMENT_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        Accomodation accomodation = dataList.get(i);
        if (accomodation != null) {
            switch (accomodation.getType()) {
                case Accomodation.PG_TYPE:
                    ((PgTypeViewHolder) viewHolder).pgSize.setText(Integer.toString(accomodation.getRoomCount()));
                    ((PgTypeViewHolder) viewHolder).pgAddress.setText(accomodation.getAddress());
                    break;
                case Accomodation.HOSTEL_TYPE:
                    ((HostelTypeViewHolder) viewHolder).hostelSize.setText(Integer.toString(accomodation.getRoomCount()));
                    ((HostelTypeViewHolder) viewHolder).hostelAddress.setText(accomodation.getAddress());
                    break;
                case Accomodation.APARTMENT_TYPE:
                    ((ApartmentTypeViewHolder) viewHolder).apartmentSize.setText(Integer.toString(accomodation.getRoomCount()));
                    ((ApartmentTypeViewHolder) viewHolder).apartmentAddress.setText(accomodation.getAddress());
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class PgTypeViewHolder extends RecyclerView.ViewHolder {
        TextView pgSize;
        TextView pgAddress;

        public PgTypeViewHolder(@NonNull View itemView) {
            super(itemView);

            pgSize = itemView.findViewById(R.id.pg_room_text_view);
            pgAddress = itemView.findViewById(R.id.pg_address_text_view);
        }
    }

    public static class HostelTypeViewHolder extends RecyclerView.ViewHolder {
        TextView hostelSize;
        TextView hostelAddress;

        public HostelTypeViewHolder(@NonNull View itemView) {
            super(itemView);

            hostelSize = itemView.findViewById(R.id.hostel_room_text_view);
            hostelAddress = itemView.findViewById(R.id.hostel_address_text_view);
        }
    }

    public static class ApartmentTypeViewHolder extends RecyclerView.ViewHolder {
        TextView apartmentSize;
        TextView apartmentAddress;

        public ApartmentTypeViewHolder(@NonNull View itemView) {
            super(itemView);

            apartmentSize = itemView.findViewById(R.id.apartment_room_text_view);
            apartmentAddress = itemView.findViewById(R.id.apartment_address_text_view);
        }
    }
}
