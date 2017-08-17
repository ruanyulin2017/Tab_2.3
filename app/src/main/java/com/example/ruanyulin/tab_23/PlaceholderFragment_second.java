package com.example.ruanyulin.tab_23;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruanyulin on 17-8-14.
 */

public class PlaceholderFragment_second extends Fragment {

    private RecyclerView recyclerView;
    private View item;
    private List<String> data;
    private RecyclerAdapter recyclerAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    private int flag = 0;
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
                item = view;
                flag = 1;
                break;
            case 2:
                view = inflater.inflate(R.layout.tab42,container,false);
                break;
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle save){
        super.onActivityCreated(save);
        if (flag == 1){
            initData();
            recyclerView = (RecyclerView) item.findViewById(R.id.recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerAdapter = new RecyclerAdapter(getContext(),data);
            recyclerView.setAdapter(recyclerAdapter);
            //recyclerView.setHasFixedSize(false);
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
            swipeRefreshLayout = (SwipeRefreshLayout) item.findViewById(R.id.refresh);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

                @Override
                public void onRefresh() {
                    refresh();
                }
            });
        }


    }
    protected void refresh(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(),"refresh data",Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });

            }
        }).start();
    }
    protected void initData(){
        data = new ArrayList<String>();
        for (int i = 'a';i < 'z' ; i++){
            data.add(" " + (char)i);
        }
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
