package com.blimas.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.blimas.aprendaingles.R;

public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageButton btnCao, btnGato, btnLeao,
                        btnMacaco, btnOvelha, btnVaca;


    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_bichos, container, false);


        btnCao = view.findViewById(R.id.imageCao);
        btnGato = view.findViewById(R.id.imageGato);
        btnLeao = view.findViewById(R.id.imageLeao);
        btnMacaco = view.findViewById(R.id.imageMacaco);
        btnOvelha = view.findViewById(R.id.imageOvelha);
        btnVaca = view.findViewById(R.id.imageVaca);

        btnCao.setOnClickListener(this);
        btnGato.setOnClickListener(this);
        btnLeao.setOnClickListener(this);
        btnMacaco.setOnClickListener(this);
        btnOvelha.setOnClickListener(this);
        btnVaca.setOnClickListener(this);

        return view;
    }


    //metodo passado de forma global dentro da classe
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageCao :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                executaSom();
                break;

            case R.id.imageGato :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                executaSom();
                break;

            case R.id.imageLeao :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                executaSom();
                break;

            case R.id.imageMacaco :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                executaSom();
                break;

                case R.id.imageOvelha :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                executaSom();
                break;

            case R.id.imageVaca :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                executaSom();
                break;
        }

    }


    public void executaSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();

            //libera recursos utilizados apos finalizar o som
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
