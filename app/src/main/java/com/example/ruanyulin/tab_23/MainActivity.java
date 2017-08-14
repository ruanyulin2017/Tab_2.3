package com.example.ruanyulin.tab_23;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取适配器
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        //设置适配器，将viewpager和fragment绑定
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private View second_fragment;
        private int flag = 0;
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View view = null;
            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1:
                    view = inflater.inflate(R.layout.tab1,container,false);
                    break;
                case 2:
                    view = inflater.inflate(R.layout.tab2,container,false);
                    break;
                case 3:
                    view = inflater.inflate(R.layout.tab3,container,false);
                    break;
                case 4:
                    view = inflater.inflate(R.layout.tab4,container,false);
                    second_fragment = view;
                    flag = 1;
                    break;
            }
            return view;
        }

        @Override
        public void onActivityCreated(Bundle save) {
            super.onActivityCreated(save);
            if (flag == 1) {
                PlaceholderFragment_second.SectionsPagerAdapter_second sectionsPagerAdapter_second;
                sectionsPagerAdapter_second = new PlaceholderFragment_second.SectionsPagerAdapter_second(getChildFragmentManager());
                ViewPager viewPager;
                viewPager = (ViewPager) second_fragment.findViewById(R.id.container1);
                //TextView textView = (TextView) tab.findViewById(R.id.tab_text42);
                viewPager.setAdapter(sectionsPagerAdapter_second);
                TabLayout tabLayout;
                tabLayout = (TabLayout) second_fragment.findViewById(R.id.tabs1);

                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "tab 1";
                case 1:
                    return "tab 2";
                case 2:
                    return "tab 3";
                case 3:
                    return "tab 4";
            }
            return null;
        }
    }


}
