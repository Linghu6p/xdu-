0000package com.example.test.Information;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {
    private List<Information> mInformationList;
    private static final int VIEW_TYPE_CLICK = 1;
    private static final int VIEW_TYPE_INFORMATION = 2;
    private static final int VIEW_TYPE_TIP = 3;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View allView;
        ImageView clickImage;
        TextView clickName;
        ImageView informationView;
        ImageView thingView;
        TextView nameView;
        TextView contextView;
        TextView tipsView;

        public ViewHolder(View view) {
            super(view);
            allView = view;
            clickImage = (ImageView) view.findViewById(R.id.click_image);
            clickName = (TextView) view.findViewById(R.id.click_name);
            informationView = (ImageView) view.findViewById(R.id.information_name_pic);
            thingView = (ImageView) view.findViewById(R.id.information_pic);
            nameView = (TextView) view.findViewById(R.id.information_name);
            contextView = (TextView) view.findViewById(R.id.information_context);
            tipsView = (TextView) view.findViewById(R.id.function_messagr);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mInformationList.get(position).getType() == Information.TYPE_CLICK) {
            return VIEW_TYPE_CLICK;
        } else if (mInformationList.get(position).getType() == Information.TYPE_INFORMATION) {
            return VIEW_TYPE_INFORMATION;
        } else if (mInformationList.get(position).getType() == Information.TYPE_TIP) {
            return VIEW_TYPE_TIP;
        } else {
            return 0;
        }
    }

    public InformationAdapter(List<Information> informationlist) {
        mInformationList = informationlist;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_CLICK:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one,
                        parent, false);
                ViewHolder holder = new ViewHolder(view);
                holder.clickImage.setOnClickListener(new View.OnClickListener() {
                    // 点击事件触发
                    @Override
                    public void onClick(View v) {
                        int position = holder.getAdapterPosition();
                        Information information = mInformationList.get(position);
                        Toast.makeText(v.getContext(),information.getClickName(),Toast.LENGTH_SHORT).show();
                    }
                });
                return holder;
            case VIEW_TYPE_INFORMATION:

                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two,
                        parent, false);
                ViewHolder holder1 = new ViewHolder(view1);
                holder1 = new ViewHolder(view1);
                return holder1;
            case VIEW_TYPE_TIP:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_three,
                        parent, false);
                ViewHolder holder2 = new ViewHolder(view2);
                holder2 = new ViewHolder(view2);
                return holder2;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Information information = mInformationList.get(position);
        if (information.getType() == Information.TYPE_CLICK) {
            holder.clickName.setText(information.getClickName());
            holder.clickImage.setImageResource(information.getClickId());
        } else if (information.getType() == Information.TYPE_INFORMATION) {
            holder.nameView.setText(information.getRootName());
            holder.contextView.setText(information.getRootContext());
            holder.thingView.setImageResource(information.getThingImageId());
            holder.informationView.setImageResource(information.getRootImageId());
        } else if (information.getType() == Information.TYPE_TIP) {
            holder.tipsView.setText(information.getTips());
        }
    }

    @Override
    public int getItemCount() {
        return mInformationList.size();
    }
}
