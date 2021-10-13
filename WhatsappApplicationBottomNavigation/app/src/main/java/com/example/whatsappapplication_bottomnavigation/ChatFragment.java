package com.example.whatsappapplication_bottomnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private ArrayList<Chat> chats;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_chat);
        addItemChat();
        chatAdapter = new ChatAdapter(chats);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chatAdapter);
        return view;
    }
    void addItemChat() {
        chats = new ArrayList<>();
        chats.add(new Chat("Ibnnu", "Hey ibnu!", "12.00", R.mipmap.img1));
        chats.add(new Chat("Dela", "Hey Dela!", "12.30", R.mipmap.img2));
        chats.add(new Chat("Rome", "Hey Rome!", "16.00", R.mipmap.img3));
        chats.add(new Chat("Lage", "Hey Lage!", "12.00", R.mipmap.img1));
        chats.add(new Chat("Andrian", "Hey Andrian!", "12.30", R.mipmap.img2));
        chats.add(new Chat("Jhon", "Hey Jhon!", "16.00", R.mipmap.img3));
        chats.add(new Chat("Apricot", "Hey Apricot!", "12.00", R.mipmap.img1));
        chats.add(new Chat("Max", "Hey Max!", "12.30", R.mipmap.img2));
        chats.add(new Chat("Theng", "Hey Theng!", "16.00", R.mipmap.img3));
    }
}