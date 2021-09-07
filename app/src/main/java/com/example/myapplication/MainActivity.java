package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  RecyclerView recyclerView;
 MyAdapter Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Myapi myapi=retrofit.create(Myapi.class);
        Call<List<Model>> call=myapi.getpostlist();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.body().size()>0){
                    List<Model> modelLis=response.body();
                   Adapter=new MyAdapter(MainActivity.this,modelLis);
                   recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                   recyclerView.setAdapter(Adapter);

                    Toast.makeText(MainActivity.this,""+response,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Empty the data",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}