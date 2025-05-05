package com.example.budgetmanager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
            private BottomNavigationView bottomnavigationView;
            private FrameLayout frameLayout;


            //fragment

         private DashBoardFragment dashBoardFragment;
         private IncomeFragment incomeFragment;
         private ExpenseFragment expenseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar=findViewById(R.id.my_toolbar);
        toolbar.setTitle("Budget Manager");
        setSupportActionBar(toolbar);


        bottomnavigationView=findViewById(R.id.bottomNavigationbar);
        frameLayout=findViewById(R.id.main_frame);

        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView=findViewById(R.id.naView);
        navigationView.setNavigationItemSelectedListener(this);

        dashBoardFragment= new DashBoardFragment();
        incomeFragment= new IncomeFragment();
        expenseFragment= new ExpenseFragment();

        setFragment(dashBoardFragment);

        bottomnavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.dashboard) {
                    setFragment(dashBoardFragment);
                    bottomnavigationView.setItemBackgroundResource(R.color.dasboard_color);
                    return true;
                } else if (itemId == R.id.income) {
                    setFragment(incomeFragment);
                    bottomnavigationView.setItemBackgroundResource(R.color.income_color);
                    return true;
                } else if (itemId == R.id.expense) {
                    setFragment(expenseFragment);
                    bottomnavigationView.setItemBackgroundResource(R.color.expense_color);
                    return true;
                } else {
                    return false;
                }
            }
        });

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);

        if (drawerLayout.isDrawerOpen(GravityCompat.END)){

            drawerLayout.closeDrawer(GravityCompat.END);
        }else {
            super.onBackPressed();
        }
    }

    public void displaySelectedListener(int itemId) {
        Fragment fragment = null;

        if (itemId == R.id.dashboard) {
            fragment=new DashBoardFragment();
        } else if (itemId == R.id.income) {
            fragment=new IncomeFragment();
        } else if (itemId == R.id.expense) {
            fragment=new ExpenseFragment();
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        displaySelectedListener(item.getItemId());
        return true;
    }
}