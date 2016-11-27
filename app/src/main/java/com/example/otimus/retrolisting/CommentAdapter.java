package com.example.otimus.retrolisting;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.otimus.retrolisting.model.CommentItem;

import java.util.List;

/**
 * Created by Otimus on 11/6/2016.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

    List<CommentItem> commentItemList;

    public CommentAdapter(List<CommentItem> commentItemList) {
        this.commentItemList = commentItemList;
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcomment,parent,false);
        return new CommentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        holder.name.setText(commentItemList.get(position).getPname());
        holder.email.setText(commentItemList.get(position).getEmail());
        holder.body.setText(commentItemList.get(position).getBody());


    }



    @Override
    public int getItemCount() {
        return commentItemList.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        TextView name, email,body;
        public CommentHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.cname);
            email=(TextView)itemView.findViewById(R.id.cemail);
            body=(TextView)itemView.findViewById(R.id.cbody);

        }
    }


}



