package com.msssolution.convostartertest2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {

    private List<Menu> menuList;
    public static ArrayList<String> titleArray;
    public static ArrayList<String> descArray;

    public static Fragment newInstance() {
        return new RecyclerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);

        titleArray = new ArrayList<>();
        titleArray.add("Awkward");
        titleArray.add("Caring");
        titleArray.add("NASA");
        titleArray.add("Physics");
        titleArray.add("Geology");
        titleArray.add("Star Wars");
        titleArray.add("Star Trek");

        descArray = new ArrayList<>();
        descArray.add("Description 1");
        descArray.add("Description 2");
        descArray.add("Description 3");
        descArray.add("Description 4");
        descArray.add("Description 5");
        descArray.add("Description 6");
        descArray.add("Description 7");

        menuList = new ArrayList<>();
        for(int i=0; i < titleArray.size(); i++){
            menuList.add(new Menu(
                    i,
                    titleArray.get(i),
                    descArray.get(i)
            ));
        }

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter());

        return view;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView titleTextView, descTextView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.card_view, container, false));
            cardView = itemView.findViewById(R.id.card_container);
            titleTextView = itemView.findViewById(R.id.item_title_text_view);
            descTextView = itemView.findViewById(R.id.item_desc_text_view);
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            Menu menu = menuList.get(position);
            holder.titleTextView.setText(menu.getTitle());
            holder.descTextView.setText(menu.getDescription());
        }

        @Override
        public int getItemCount() {
            if(menuList != null){
                return menuList.size();
            } else{
                return 0;
            }
        }
    }
}
