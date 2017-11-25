package com.example.rezasoltani.activity1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResultFragment extends Fragment {


    TextView txtResultContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        txtResultContent = (TextView) view.findViewById(R.id.txtResultContent);
        return view;

    }

    public void getData(String input)
    {
        //Log.d("TAG", "got " + input);

        txtResultContent.setText(input);

    }



}
