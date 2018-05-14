package com.pmoviles.fsociety.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.L og;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView rv;

    //provisional
    public static final List<Artist> datos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        Artist ar = new Artist();
        ar.setName("SHASHA GREY");
        ar.setPhone("69696969");
        ar.setRating(5);
        datos.add(ar);
        ar = new Artist();
        ar.setName("ALEX TEXAS");
        ar.setPhone("555555");
        ar.setRating(4.3);
        datos.add(ar);
        LlenarRecycler();
        //System.out.println("DATOS"+datos.toString());
    }
    public  void  LlenarRecycler(){
        if (datos!=null){
            AdapterRecycler ar = new AdapterRecycler(this,datos);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            rv.setAdapter(ar);
        }
    }
}
