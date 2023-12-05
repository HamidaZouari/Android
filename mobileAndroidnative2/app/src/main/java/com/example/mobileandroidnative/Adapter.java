package com.example.mobileandroidnative;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private final Context mContext;

    private ArrayList<ModelCard> items;
    ImageView imageView;
    TextView textView;
    public Adapter(ArrayList<ModelCard> items,Context context){this.items=items;mContext=context;}

    public class UserViewHolder extends RecyclerView.ViewHolder {
        int id;
        ImageView imageView;
        TextView textView;
        public UserViewHolder(View v) {
            super(v);
           // imageView = v.findViewById(R.id.imageView1);
            textView = v.findViewById(R.id.itemtextview1);

        }
        public void setId(int id) {
            this.id = id;
        }
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
int i=position;
String name=items.get(position).getName();
//int image =items.get(position).getImageView();
//holder.imageView.setImageResource(image);
holder.textView.setText(name);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

private ImageView imageView;
private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //imageView=itemView.findViewById(R.id.imageView1);
            textView=itemView.findViewById(R.id.itemtextview1);


        }

        public void setData(int resource, String name) {
            //imageView.setImageResource(resource);
            textView.setText(name);
        }
    }
}
