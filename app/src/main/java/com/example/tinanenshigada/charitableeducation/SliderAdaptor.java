package com.example.tinanenshigada.charitableeducation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SliderAdaptor extends PagerAdapter
{
    Context context;
    LayoutInflater inflater;

    public SliderAdaptor(Context context)
    {
        this.context = context;
    }

    public int[] slide_images = {R.drawable.applogo,R.drawable.icon_help,R.drawable.icon_shapred,R.drawable.icon_donate};
    public String[] slide_des = {"START","JOIN COMMUNITY","TAKE CLASSES","DONATE MONEY"};


    @Override
    public int getCount()
    {
        return slide_des.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout,container,false);

        ImageView i = (ImageView) view.findViewById(R.id.imageView2);

        i.setImageResource(slide_images[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
