package com.amar.datafetching;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class SingleUserAdapter extends RecyclerView.Adapter<SingleUserAdapter.SingleUserViewHolder> {

    private Context context;
    private User [] data;
    public SingleUserAdapter(Context context,User [] data)
    {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public SingleUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_user,parent,false);

        return new SingleUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleUserViewHolder holder, int position) {
          final User user = data[position];
          holder.text.setText(user.getLogin());
        Glide.with(holder.image.getContext()).load(user.getAvatarUrl()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, user.getLogin()+" was clicked", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class SingleUserViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text;
        public SingleUserViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgUser);
            text = itemView.findViewById(R.id.txtUser);
        }
    }
}
