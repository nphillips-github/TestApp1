package net.nrp.testapp1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import net.nrp.models.Question;
import net.nrp.test.TestData;

public class QuestionActivity extends Activity {


    Question main = null;

    public View.OnClickListener answer = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String answerc = (String)view.getTag(R.string.answer_value);
            checkAnswer(answerc);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_lay);
        setupQuestion();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.question, menu);
        return true;
    }

    public void setupQuestion()
    {
        TestData set = new TestData();
        main = set.setupTestQuestion();

        if(main != null)
        {
            ImageView pic = (ImageView)findViewById(R.id.question_pic);
            main.loadImage(pic);

            if(main.answerOptions != null && main.answerOptions.size() > 0)
            {
                Button o1 = (Button)findViewById(R.id.option1);
                Button o2 = (Button)findViewById(R.id.option2);
                Button o3 = (Button)findViewById(R.id.option3);
                Button o4 = (Button)findViewById(R.id.option4);

                if(main.answerOptions.get(0) != null){
                    o1.setText(main.answerOptions.get(0).answerText);
                    o1.setTag(R.string.answer_value,main.answerOptions.get(0).answerValue);
                    o1.setOnClickListener(answer);

                }
                if(main.answerOptions.size() > 1 && main.answerOptions.get(1) != null){
                    o2.setText(main.answerOptions.get(1).answerText);
                    o2.setTag(R.string.answer_value,main.answerOptions.get(1).answerValue);
                    o2.setOnClickListener(answer);
                }
                if(main.answerOptions.size() > 2 && main.answerOptions.get(2) != null){
                    o3.setText(main.answerOptions.get(2).answerText);
                    o3.setTag(R.string.answer_value,main.answerOptions.get(2).answerValue);
                    o3.setOnClickListener(answer);
                }
                if(main.answerOptions.size() > 3 && main.answerOptions.get(3) != null){
                    o4.setText(main.answerOptions.get(3).answerText);
                    o4.setTag(R.string.answer_value,main.answerOptions.get(3).answerValue);
                    o4.setOnClickListener(answer);
                }
            }

        }
    }

    public void checkAnswer(String chosen)
    {
        if(chosen.equals(main.correct_AnswerValue))
        {
            buildDialog(R.string.answered_correctly, R.string.answered_message);
        }
        else
        {
            buildDialog(R.string.answered_wrongly, R.string.answered_message);
        }
    }

    public void buildDialog(Integer title, Integer message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message)
                .setTitle(title)
        .setNegativeButton(R.string.answered_dialog_negative,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        }).setPositiveButton(R.string.answered_dialog_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        })
        ;


        AlertDialog dialog = builder.create();
        dialog.show();

    }


}
