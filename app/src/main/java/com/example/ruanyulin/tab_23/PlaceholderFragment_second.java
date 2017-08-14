package com.example.ruanyulin.tab_23;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ruanyulin on 17-8-14.
 */

public class PlaceholderFragment_second extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment_second() {
    }




    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment_second newInstance(int sectionNumber) {
        PlaceholderFragment_second fragment = new PlaceholderFragment_second();
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
                view = inflater.inflate(R.layout.tab41,container,false);
                break;
            case 2:
                view = inflater.inflate(R.layout.tab42,container,false);
                break;
        }
        return view;
    }
    public static class SectionsPagerAdapter_second extends FragmentPagerAdapter {

        public SectionsPagerAdapter_second(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment_second.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "tab 41";
                case 1:
                    return "tab 42";
            }
            return null;
        }
    }


}
