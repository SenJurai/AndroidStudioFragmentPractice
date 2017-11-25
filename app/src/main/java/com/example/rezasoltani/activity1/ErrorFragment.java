package com.example.rezasoltani.activity1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ErrorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_error, container, false);

        Bundle data2 = getArguments();
        String error = data2.getString("ERROR");



        TextView txtError = (TextView) view.findViewById(R.id.txtError);
        txtError.setText(error);

        return view;
    }
}