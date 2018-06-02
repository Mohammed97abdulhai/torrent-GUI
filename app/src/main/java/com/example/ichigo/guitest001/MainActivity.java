package com.example.ichigo.guitest001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items = new ArrayList<>();
    List<String> listitems= Arrays.asList("test001","test002", "test003","test004","test005");
    ViewAdapter listadapter = new ViewAdapter(this,items);
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items.addAll(listitems);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(listadapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    { switch(item.getItemId()) {
        case R.id.bookmsrk:
        {
            Intent i=new Intent(Intent.ACTION_GET_CONTENT);
            i.setType("application/x-bittorrent");
            startActivityForResult(i, 1);
        }
        return(true);
        case R.id.search_but:
            //add the function to perform here
            return(true);
    }
        return(super.onOptionsItemSelected(item));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        switch(requestCode){

            case 1:

                if(resultCode==RESULT_OK){

                    String pathHolder = data.getData().getPath();
                    Intent i=new Intent(this,Add_torrent.class);
                    i.putExtra("F",pathHolder);
                    startActivityForResult(i,2);
                }
                break;
            case 2:
                if(resultCode == RESULT_OK) {
                    Log.i("info", "nothing");
                    items.add(data.getExtras().getString("F"));
                    listadapter.notifyItemInserted(items.size() - 1);
                }
            break;

        }
    }

}
