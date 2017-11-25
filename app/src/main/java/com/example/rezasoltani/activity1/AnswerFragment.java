package com.example.rezasoltani.activity1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AnswerFragment extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle data = getArguments();
        String answer = data.getString("ANSWER");


        View view = inflater.inflate(R.layout.fragment_answer, container, false);
        TextView txtAnswer = (TextView) view.findViewById(R.id.txtAnswer);
        txtAnswer.setText(answer);

        return view;
    }


}
