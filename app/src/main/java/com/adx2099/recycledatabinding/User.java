package com.adx2099.recycledatabinding;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class User {

    public String name;
    public String email;
    public int imageId;

    public User(String name, String email, int imageId) {
        this.name = name;
        this.email = email;
        this.imageId = imageId;
    }
    @BindingAdapter("android:imageUrl")
    public static void loadImage(View view, int imageId){
        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), imageId));

    }
}
