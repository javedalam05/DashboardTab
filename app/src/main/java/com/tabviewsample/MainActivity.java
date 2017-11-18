package com.tabviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.custom.views.TabView;

public class MainActivity extends AppCompatActivity implements TabView.ButtonClickLisner {

    TabView row1;
    TabView row2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        row1 = (TabView) findViewById(R.id.tab_view_1);
        row2 = (TabView) findViewById(R.id.tab_view_2);

        row1.setButtonClickLisner(this);
        row2.setButtonClickLisner(this);
    }

    @Override
    public void firstButtonClick(int tag) {
        switch (tag) {
            case 1:
                Toast.makeText(this, "click tab 1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "click tab 3", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    @Override
    public void secondButtonClick(int tag) {
        switch (tag) {
            case 1:
                Toast.makeText(this, "click tab 2", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "click tab 4", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
