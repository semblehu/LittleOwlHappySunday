package com.happysunday.littleowlapp.littleowl.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.happysunday.littleowlapp.littleowl.R;
import com.happysunday.littleowlapp.littleowl.activities.ImageListAdapter;
import com.happysunday.littleowlapp.littleowl.activities.MainActivity;


import java.util.ArrayList;

import butterknife.ButterKnife;

public class ProfileFragment extends BaseFragment{


    public static String[] eatFoodyImages = {
            "https://assets.hongkiat.com/uploads/children-book-covers/yummy-lucy-cousin.jpg",
            "http://www.adazing.com/wp-content/uploads/2012/05/what-the-ladybug-heard.jpg",
            "http://pleated-jeans.com/wp-content/uploads/2017/10/ypa-8.jpg",
            "http://www.kidscanpress.com/sites/default/files/products/child_soldier.jpg",
            "https://i.cbc.ca/1.3294931.1446148297!/fileImage/httpImage/image.jpg_gen/derivatives/original_620/where-do-babies-come-from-book-cover.jpg",
    };
    private static final int NUM_GRID_COLUMNS = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ButterKnife.bind(this, view);

        ( (MainActivity)getActivity()).updateToolbarTitle("Profile");


        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {

        GridView grid = (GridView) getView().findViewById(R.id.gridView);
        grid.setAdapter(new ImageListAdapter(getActivity().getApplicationContext(),eatFoodyImages));
    }




}