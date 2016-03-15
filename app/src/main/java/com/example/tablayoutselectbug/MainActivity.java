package com.example.tablayoutselectbug;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        for (int i = 0; i < 3; i++) {
            // This crashed in 23.1.1
            //tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_layout));

            TabLayout.Tab tab = tabLayout.newTab();

            // If tab is added like this, the first tab is selected by default
            //tab.setCustomView(R.layout.tab_layout);
            //tabLayout.addTab(tab);

            // If the tab is added like this, the selection doesn't work
            tabLayout.addTab(tab);
            tab.setCustomView(R.layout.tab_layout);
        }

        // This line should switch the first tab to a selected state
        tabLayout.getTabAt(0).select();
    }
}
