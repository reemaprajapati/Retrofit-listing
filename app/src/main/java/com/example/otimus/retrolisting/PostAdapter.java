package com.example.otimus.retrolisting;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.otimus.retrolisting.model.PostItem;

import java.util.List;

/**
 * Created by Otimus on 10/31/2016.
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {



    List<PostItem> postItems;
    private final OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(PostItem item);
    }

    public PostAdapter(List<PostItem> postItems,OnItemClickListener listener) {
        this.postItems = postItems;
        this.listener=listener;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);
        return new PostHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        holder.bind(postItems.get(position),listener);

        holder.id.setText(toString().valueOf(postItems.get(position).getId()));

        holder.title.setText(postItems.get(position).getTitle());
        holder.body.setText(postItems.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        TextView id,title,body;
        public PostHolder(View itemView) {
            super(itemView);

            id=(TextView)itemView.findViewById(R.id.post_id);
            title=(TextView)itemView.findViewById(R.id.post_title);
            body=(TextView)itemView.findViewById(R.id.body);

        }

        public void bind(final PostItem item, final OnItemClickListener listener){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onItemClick(item);

                    }
                });
        }
    }
}
