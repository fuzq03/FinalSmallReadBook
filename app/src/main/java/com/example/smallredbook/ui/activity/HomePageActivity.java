package com.example.smallredbook.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.smallredbook.R;
import com.example.smallredbook.adapter.HomePageViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomePageActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Here", "2222222222222222222");
        setContentView(R.layout.activity_home);
        Log.d("Here", "1111111111111111111");

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //获取navController
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //通过setupWithNavController
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        //这行代码是用于解决底部icon显示为灰色的问题
        bottomNavigationView.setItemIconTintList(null);
        //这行代码用于修改menu图标大小
        bottomNavigationView.setItemIconSize(110);
        Button btn_add = (Button) findViewById(R.id.main_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Log.d("Navigation", "clicked");
//                return false;
//            }
//        });

        //navController.navigate(R.id.action_homeFragment_to_detailFragment);
        

    }
    void openActivity(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
        this.overridePendingTransition(R.anim.enteralpha, R.anim.exitalpha);
    }
}