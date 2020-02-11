package com.hfad.dojotrial;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder
{
    private static View mview;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
         mview = itemView;
    }

    public static void setDetails(Context ctx, String title, String image, String description)
    {
        TextView mTitleTv = mview.findViewById(R.id.rTitleTv);
        TextView mDetailTV = mview.findViewById(R.id.rDescriptionTv);
        ImageView mImageTv = mview.findViewById(R.id.rImageTv);

        mTitleTv.setText(title);
        mDetailTV.setText(description);
        Picasso.get().load(image).into(mImageTv);


    }
}
