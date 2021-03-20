package com.codepath.instagramclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts)
    {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Post post = posts.get(position);
       holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        private TextView tvUsername;
        private TextView tvDescription;
        private ImageView ivImage;
        private TextView likes;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivImage = itemView.findViewById(R.id.ivPostImage);




        }

        public void bind(Post post) { //taking data from posts and binding it to our views
            //Bind the post data to the view elements
         /*   btnLikes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  int numLikes = Integer.parseInt(post.getLikes()) ;
                  numLikes++;
                    String stringLikes = String.valueOf(numLikes);
                  likes.append(stringLikes);
                  post.setLikes(stringLikes);
                }
            });
            /*
          */
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());

            ParseFile image = post.getImage();
            if(image != null)
            {
                Glide.with(context).load(post.getImage().getUrl()).into(ivImage);
            }


        }

        /* Within the RecyclerView.Adapter class */

        // Clean all elements of the recycler

    }


}
