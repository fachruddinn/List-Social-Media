package com.hellorudi.listsocialmedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SocialAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Social> socials = new ArrayList<>();

    // setter hasil generate
    public void setSocials(ArrayList<Social> socials) {
        this.socials = socials;
    }

    // constructor hasil generate
    public SocialAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return socials.size();
    }

    @Override
    public Object getItem(int position) {
        return socials.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_social, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Social social = (Social) getItem(position);
        viewHolder.bind(social);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPicture;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPicture = view.findViewById(R.id.img_picture);
        }
        void bind(Social social) {
            txtName.setText(social.getName());
            txtDescription.setText(social.getDescription());
            imgPicture.setImageResource(social.getPicture());
        }
    }
}
