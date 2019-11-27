package com.msssolution.convostartertest2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemFragment extends Fragment {

    private static final String TEXT = "text";
    private String mText;
    private TextView titleTextView;

    public static ItemFragment newInstance(String title) {
        ItemFragment itemFragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putString(TEXT, title);
        itemFragment.setArguments(args);
        return itemFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mText = getArguments().getString(TEXT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_item, container, false);
        titleTextView = view.findViewById(R.id.item_title2_text_view);
        titleTextView.setText(mText);
        return view;
    }

}
