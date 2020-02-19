package com.example.expandablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NameViewHolder> {
    Context mContext;
    ArrayList<NameModel> arrayList = new ArrayList<>();
    boolean isClick = false;

    public RecyclerViewAdapter(Context mContext, ArrayList<NameModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NameViewHolder holder, final int position) {
        NameModel model = arrayList.get(position);
        holder.txtTitle.setText(model.getTitle());
        //holder.txtSubTitle.setText(model.getSubTitle());


        if (position == 2) {
            holder.expandaleLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.GONE);
            holder.upArrow.setVisibility(View.GONE);
        } else {
            boolean isExpanded = arrayList.get(position).isExpanded();
            holder.expandaleLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            holder.upArrow.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            holder.downArrow.setVisibility(isExpanded ? View.GONE : View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //downArrow.animate().setDuration(200).rotation(180);
                NameModel nameModel = arrayList.get(position);
                nameModel.setExpanded(!nameModel.isExpanded());
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        TextView txtSubTitle;
        LinearLayout expandaleLayout;
        ImageView upArrow, downArrow;
        RecyclerView childRecyclerView;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txt_title);
            //txtSubTitle = itemView.findViewById(R.id.txt_subItem);
            expandaleLayout = itemView.findViewById(R.id.expandableLayout);
            upArrow = itemView.findViewById(R.id.up_arrow);
            downArrow = itemView.findViewById(R.id.down_arrow);
            childRecyclerView = itemView.findViewById(R.id.child_recyclerView);

//            txtTitle.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //downArrow.animate().setDuration(200).rotation(180);
//                    downArrow.setVisibility(View.GONE);
//                    NameModel nameModel = arrayList.get(getAdapterPosition());
//                    nameModel.setExpanded(!nameModel.isExpanded());
//                    notifyItemChanged(getAdapterPosition());
//                }
//            });

        }
    }
}
