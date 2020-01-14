package com.blimas.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.blimas.aprendaingles.R;


public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton btnUm, btnDois, btnTres,
                        btnQuatro, btnCinco, btnSeis;

    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        btnUm = view.findViewById(R.id.imageNumeroUm);
        btnDois = view.findViewById(R.id.imageNumeroDois);
        btnTres = view.findViewById(R.id.imageNumeroTres);
        btnQuatro = view.findViewById(R.id.imageNumeroQuatro);
        btnCinco = view.findViewById(R.id.imageNumeroCinco);
        btnSeis = view.findViewById(R.id.imageNumeroSeis);


        //aplica eventos de click em numerosFragment
        btnUm.setOnClickListener(this);
        btnDois.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnQuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);

        return view;
    }

    //metodo passado de forma global dentro da classe
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imageNumeroUm :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                executaSom();
                break;

            case R.id.imageNumeroDois :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                executaSom();
                break;

            case R.id.imageNumeroTres :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                executaSom();
                break;

            case R.id.imageNumeroQuatro :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                executaSom();
                break;

            case R.id.imageNumeroCinco :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                executaSom();
                break;

            case R.id.imageNumeroSeis :
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
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
