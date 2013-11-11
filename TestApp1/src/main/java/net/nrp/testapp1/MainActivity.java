package net.nrp.testapp1;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    public View.OnClickListener close = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
    public View.OnClickListener question = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent questionIntent = new Intent(MainActivity.this,QuestionActivity.class);
            MainActivity.this.startActivity((questionIntent));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
    }
    //Hello There!!

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void initializeViews()
    {
        /*To Do: Implement settings and profile buttons*/
        Button bstart = (Button)findViewById(R.id.btnStartGame);
        //Button bsettings = (Button)findViewById(R.id.btnSetting);
        Button bexit = (Button)findViewById(R.id.btnExitApp);
        //Button bprofile = (Button)findViewById(R.id.btnProfile);
        bexit.setOnClickListener(close);
        bstart.setOnClickListener(question);
    }

    
}
