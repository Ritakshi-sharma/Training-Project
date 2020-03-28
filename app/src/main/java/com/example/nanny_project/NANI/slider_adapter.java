package com.example.nanny_project.NANI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nanny_project.R;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class slider_adapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public slider_adapter(Context context){
        this.context=context;
    }

    //Array of Images
    public int[] slide_images ={
            R.drawable.slide1,
            R.drawable.slide2,
            R.drawable.slide3
    };
    //Array of Headings
    public String[] slide_headings={
            "Beacome a Nani or Find Your Nearest Nani",
            "Pick Up From Your Home_fragment or Delivery To Your Door",
            "List or Choose a Delicacy"
    };


    //Array of Description
    public String[] slide_description={
            "Lorem ipsum dolor sit amet consectetur adipiscing elit," +
                    " tempor incididunt ut labore et dolore magna aliqua" +
                    " sed do eiusmod",

            "Lorem ipsum dolor sit amet consectetur adipiscing elit," +
                    " tempor incididunt ut labore et dolore magna aliqua" +
                    " sed do eiusmod",

            "Lorem ipsum dolor sit amet consectetur adipiscing elit," +
                    " tempor incididunt ut labore et dolore magna aliqua" +
                    " sed do eiusmod",

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view,  Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImage= (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading= (TextView) view.findViewById(R.id.slide_heading);
        TextView slidedescription= (TextView) view.findViewById(R.id.slide_desc);

        slideImage.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slidedescription.setText(slide_description[position]);

        container.addView(view);
                return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
