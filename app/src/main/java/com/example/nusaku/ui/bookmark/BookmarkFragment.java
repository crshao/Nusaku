package com.example.nusaku.ui.bookmark;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nusaku.PageAdapter;
import com.example.nusaku.R;
import com.example.nusaku.ui.cari.CariViewModel;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class BookmarkFragment extends Fragment {

    private BookmarkViewModel bookmarkViewModel;

    private TabLayout tablayout;
    private ViewPager viewpager;
    private TabItem tab1,tab2,tab3,tab4;
    public PageAdapter pageadapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bookmarkViewModel = ViewModelProviders.of(this).get(BookmarkViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bookmark, container, false);
        final TextView textView = root.findViewById(R.id.text_bookmark);

        bookmarkViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        // Inflate the layout for this fragment

        tablayout= (TabLayout) root.findViewById(R.id.tablayout);
        tab1 = (TabItem) root.findViewById(R.id.tab1);
        tab2 = (TabItem) root.findViewById(R.id.tab2);
        tab3 = (TabItem) root.findViewById(R.id.tab3);
        tab4 = (TabItem) root.findViewById(R.id.tab4);
        viewpager = root.findViewById(R.id.viewpagerbookmark);

        pageadapter = new PageAdapter(getFragmentManager(), tablayout.getTabCount());
        viewpager.setAdapter(pageadapter);

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0){
                    pageadapter.notifyDataSetChanged();
                }
                else if (tab.getPosition()==1){
                    pageadapter.notifyDataSetChanged();
                }
                else if (tab.getPosition()==2){
                    pageadapter.notifyDataSetChanged();
                }
                else if (tab.getPosition()==3){
                    pageadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        return root;
    }
}