package com.example.ichigo.guitest001;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<String>items;

    public ViewAdapter(Context context, ArrayList<String> items)
    {
        this.context = context;
        this.items = items;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.row_layout,parent,false);
        Item item = new Item(row);
        return item;
    }

    boolean togglebutton = false;
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        ((Item)holder).textView.setText(items.get(position));
        ((Item) holder).rowlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ((Item) holder).textView.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        ((Item) holder).button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(togglebutton) {
                    Toast.makeText(context, "the button has been pressed", Toast.LENGTH_LONG).show();
                    ((Item) holder).button.setImageResource(R.drawable.pause_icon);
                    togglebutton =false;
                }
                else
                {
                    ((Item) holder).button.setImageResource(R.drawable.play_icon);
                    togglebutton = true;
                }
            }
        });

    }


    public int getItemCount() {
        return items.size();
    }



    public  class  Item extends RecyclerView.ViewHolder {
        TextView textView;
        ImageButton button;
        RelativeLayout rowlayout;
        public Item(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.nametext);
            button = (ImageButton) itemView.findViewById(R.id.downloadbutton);
            rowlayout = (RelativeLayout) itemView.findViewById(R.id.rowlayout);
        }
    }
}
