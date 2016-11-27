package com.example.otimus.retrolisting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.otimus.retrolisting.model.CommentItem;
import com.example.otimus.retrolisting.rest.ApiClient;
import com.example.otimus.retrolisting.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Intent intent=getIntent();
        Integer id= (Integer) intent.getSerializableExtra("id");
        Log.d("id",id.toString());
        Toast.makeText(CommentActivity.this, "id="+id, Toast.LENGTH_SHORT).show();

        final RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview_comment);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<List<CommentItem>> call=apiInterface.getComments(id);
        call.enqueue(new Callback<List<CommentItem>>() {
            @Override
            public void onResponse(Call<List<CommentItem>> call, Response<List<CommentItem>> response) {
                recyclerView.setAdapter(new CommentAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<CommentItem>> call, Throwable t) {

            }
        });



    }
}
