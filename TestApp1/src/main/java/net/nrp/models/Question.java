package net.nrp.models;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import net.nrp.tasks.LoadImageTask;
import java.util.ArrayList;

public class Question {
    public String imageURL;
    public ArrayList<AnswerOption> answerOptions;
    public String correct_AnswerValue;
    private static String errorTag = "Error in Question Object";
    public Bitmap bitmap = null;

    public Bitmap loadImage(ImageView target)
    {
        if(bitmap == null)
        {

            try {
                new LoadImageTask(target,imageURL).execute();

            } catch (Exception e) {
                Log.e(errorTag, "Could not load Bitmap from: " + imageURL);
                e.printStackTrace();
            }
        }

        return bitmap;
    }
}
