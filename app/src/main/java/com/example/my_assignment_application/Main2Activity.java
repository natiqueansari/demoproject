package com.example.my_assignment_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager mlayoutmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        ArrayList<exampleitem> exampleList=new ArrayList<>();
        exampleList.add(new exampleitem(R.mipmap.auntedplacesexampl1,"GHOST STORIES : 10 MOST HAUNTED PLACES IN THE WORLD","In ghost stories, ghost houses or haunted houses are houses or other buildings that are perceived as home to disembodied spirits of the dead people. These people may have been the former owners or residents of such properties.\n" +
                "\n" +
                "There are several sightings of haunted places around the world. Now let’s have a look at some of the most haunted places across the world. If you are a fan of ghost stories, paranormal activities, and terror, then you can keep reading top 10 haunted places listed below."));
        exampleList.add(new exampleitem(R.mipmap.dubai,"TOP 10 WEIRD FACTS ABOUT DUBAI THAT YOU DON’T KNOW","In many different ways, the city of Dubai is like an oasis in the great Middle Eastern desert. It is an ultra-modern, fully air-conditioned city that is artificial for most of its parts. Yet, the city’s true beauty, beyond its identity as a high ranking tourist destination, can only be realized with time. In other words, you have to stay in Dubai, at least for a few days, to actually know Dubai. After spending some time in the city, you start learning all the amazing and interesting facts which make Dubai a splendid place. One of the most amazing facts to consider is that Dubai was a desert even 50 years ago.\n" +
                "\n" +
                "In recent times, Dubai has emerged as the cultural, commercial and tourist hub of the Middle East. The sparkling modernity of Dubai is indeed breath-taking and is something that attracts people from all over the world.\n" +
                "\n" +
                "The city is adorned with luxurious shopping centers, modern architecture, and an active nightlife. Dubai’s economy is driven by tourism and real estate and, as we know, the city houses the world’s tallest building."));
        exampleList.add(new exampleitem(R.mipmap.stop,"INDIA RANKS AMONG TOP FOURTH IN DEATH RATIO BY SMOKING.","According to the study published in “The Lancet” from the Global Burden of Disease it estimates that the smoking causes more than one in ten deaths worldwide (approx 6.4 million deaths) and 50% of this value is contributed by just four countries China, India, US and Russia.\n" +
                "\n" +
                "The data examined of 195 countries between the period of 1990 and 2015 based on smoking shows that the smoking remains a major risk factor for death and disability even many countries making tobacco polices to reduce the smoking prevalence"));
        mrecyclerView=findViewById(R.id.recyclerView);
        mrecyclerView.setHasFixedSize(true);
        mlayoutmanager=new LinearLayoutManager(this);
        madapter=new ExampleAdapter(exampleList);
        mrecyclerView.setLayoutManager(mlayoutmanager);
        mrecyclerView.setAdapter(madapter);
    }
}
