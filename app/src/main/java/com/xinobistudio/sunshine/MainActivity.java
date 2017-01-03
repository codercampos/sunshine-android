package com.xinobistudio.sunshine;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main, new PlaceHolderFragment())
                    .commit();
        }
    }

    public static class PlaceHolderFragment extends Fragment{
        public PlaceHolderFragment(){
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            List<String> elements = new ArrayList<>();
            elements.add("Today - Sunny - 88/63");
            elements.add("Monday - Sunny - 88/63");
            elements.add("Thursday - Sunny - 88/63");
            elements.add("Wednesday - Sunny - 88/63");
            elements.add("Thursday - Sunny - 88/63");
            elements.add("Friday - Sunny - 88/63");
            elements.add("Saturday - Sunny - 88/63");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    rootView.getContext(),
                    R.layout.listview_item_layout,
                    R.id.listview_item_textview,
                    elements);
            ListView listView = (ListView)rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(adapter);
            return rootView;
        }
    }
}


