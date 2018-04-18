package com.nasnav.cmsatm.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.nasnav.cmsatm.R;
import com.nasnav.cmsatm.fragments.AdditionalMissionsFragment;
import com.nasnav.cmsatm.fragments.BankMissionsFragment;
import com.nasnav.cmsatm.fragments.FixedMissionsFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager tabsViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }


    private void initViews() {
        tabsViewPager = findViewById(R.id.viewpager);
        setupViewPager(tabsViewPager);
        tabLayout = findViewById(R.id.sliding_tabs);

        tabLayout.setupWithViewPager(tabsViewPager);
        setupTabIcons();
        tabsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            int count = 0;

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabsViewPager.setCurrentItem(tab.getPosition());

//                if (tabLayout.getTabAt(0) == tab) {
//                    tabLayout.getTabAt(1).setIcon(R.drawable.back);
//                    tabLayout.getTabAt(2).setIcon(R.drawable.back);
//                } else if (tabLayout.getTabAt(1) == tab) {
//                    tabLayout.getTabAt(0).setIcon(R.drawable.back);
//                    tabLayout.getTabAt(2).setIcon(R.drawable.back);
//                } else if (tabLayout.getTabAt(2) == tab) {
//                    tabLayout.getTabAt(0).setIcon(R.drawable.back);
//                    tabLayout.getTabAt(1).setIcon(R.drawable.back);
//                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }


            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.activity_main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            // action with ID action_refresh was selected
//            case R.id.nav_fav:
//                Toast.makeText(this, "not implemented yet!", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//        }
//
//        return true;
//    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new AdditionalMissionsFragment());
        adapter.addFragment(new BankMissionsFragment());
        adapter.addFragment(new FixedMissionsFragment());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    private void setupTabIcons() {

        tabLayout.getTabAt(0).setText(R.string.additional_missions);
        tabLayout.getTabAt(1).setText(R.string.bank_missions);
        tabLayout.getTabAt(2).setText(R.string.fixed_missions);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_launcher_background);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_launcher_background);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_launcher_background);

        tabLayout.setTabTextColors(Color.parseColor("#a4a4a4"), Color.parseColor("#f8cf2d"));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
//            bundle.putParcelable("product", product);
            switch (position) {
                case 0:
                    AdditionalMissionsFragment additionalMissionsFragment = new AdditionalMissionsFragment();
//                    additionalMissionsFragment.setArguments(bundle);
                    return additionalMissionsFragment;
                case 1:
                    BankMissionsFragment bankMissionsFragment = new BankMissionsFragment();
//                    bankMissionsFragment.setArguments(bundle);
                    return bankMissionsFragment;
                case 2:
                    FixedMissionsFragment fixedMissionsFragment = new FixedMissionsFragment();
//                    fixedMissionsFragment.setArguments(bundle);
                    return fixedMissionsFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }


        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

    }

}
