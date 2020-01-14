package com.blimas.aprendaingles.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.blimas.aprendaingles.Fragments.BichosFragment;
import com.blimas.aprendaingles.Fragments.NumerosFragment;
import com.blimas.aprendaingles.Fragments.VogaisFragment;
import com.blimas.aprendaingles.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        smartTabLayout = findViewById(R.id.smartTabLayout);

        getSupportActionBar().setElevation(0);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems
                        .with(this)
                        .add("Bichos", BichosFragment.class)
                        .add("Números", NumerosFragment.class)
                        .add("Vogais", VogaisFragment.class)
                            .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);




    }

}
