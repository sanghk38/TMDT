package com.example.mymobileapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.mymobileapplication.MainActivity;
import com.example.mymobileapplication.R;
import com.example.mymobileapplication.data.slidePhoto;

import java.util.List;

public class SlidePhotoAdapter extends PagerAdapter {
    private List<slidePhoto> mListSlidePhoto;
    private MainActivity mfragment;

    public SlidePhotoAdapter(List<slidePhoto> mListSlidePhoto, MainActivity mfragment) {
        this.mListSlidePhoto = mListSlidePhoto;
        this.mfragment = mfragment;
    }




    @NonNull

    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_slide_photo,container,false);
        ImageView imgSlidePhoto = view.findViewById(R.id.img_slide_photo);

        slidePhoto slide = mListSlidePhoto.get(position);
        if (slide != null){
            Glide.with(mfragment).load(slide.getResourceId()).into(imgSlidePhoto);
        }
        container.addView(view);

        return view;
    }




    public int getCount() {
        if(mListSlidePhoto != null){
            return mListSlidePhoto.size();
        }
        return 0;
    }


    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
