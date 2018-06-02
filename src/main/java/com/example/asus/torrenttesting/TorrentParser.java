package com.example.asus.torrenttesting;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.renderscript.ScriptGroup;

import com.example.asus.torrenttesting.base.Torrent;
import com.example.asus.torrenttesting.client.SharedTorrent;
import com.example.asus.torrenttesting.util.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Asus on 5/1/2018.
 */

public class TorrentParser extends AsyncTask<Uri,Void,Torrent>{
    ParserResultUpdateCallback mListener;
    Context context;
    TorrentsManagingService torrentsManagingService;



    public TorrentParser(Context context,TorrentsManagingService torrentsManagingService){

        this.torrentsManagingService = torrentsManagingService;
        this.context=context;
    }

    @Override
    protected Torrent doInBackground(Uri... params) {
        try {

            InputStream in=context.getContentResolver().openInputStream(params[0]);

            byte[] array= Utils.readArrayFromStream(in);
            File dir = new File(Environment.getExternalStorageDirectory(),"/Download/desti");

            SharedTorrent torrent = new SharedTorrent(array,dir);

            torrentsManagingService.start_announcer(torrent);


            return torrent;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Torrent torrent) {
       /* if(torrent!=null)
        mListener.updateResults(torrent);*/
    }

    public void RegisterParser(ParserResultUpdateCallback listener){
        mListener=listener;


    }




        static interface ParserResultUpdateCallback{

        abstract public void updateResults(Torrent torrent);

    }
}
