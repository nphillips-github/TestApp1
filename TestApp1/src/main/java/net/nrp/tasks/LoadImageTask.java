package net.nrp.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class LoadImageTask extends AsyncTask<Integer,Void,Integer> {
    public Bitmap bitmap = null;
    public ImageView iview = null;
    public String from = null;

    public LoadImageTask(ImageView pholder, String url){
        from = url;
        iview = pholder;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //show a progress bar
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        //android.R.drawable =  LoadImageFromWeb("http://www.pagasa.dost.gov.ph/wb/sat_images/satellite.gif");
        try
        {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(from).getContent());
        }
        catch(Exception e)
        {
            Log.d("Async Image",e.getMessage());
        }
        return 0;
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        iview.setImageBitmap(bitmap);
    }
}
