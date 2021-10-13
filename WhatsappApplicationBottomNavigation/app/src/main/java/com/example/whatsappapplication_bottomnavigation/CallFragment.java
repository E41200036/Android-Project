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
 * Use the {@link CallFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CallFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CallFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CallFragment newInstance(String param1, String param2) {
        CallFragment fragment = new CallFragment();
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
    private CallAdapter callAdapter;
    private ArrayList<Call> calls;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_call, container, false);
        addItemCall();
        recyclerView = view.findViewById(R.id.recycler_view_call);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        callAdapter = new CallAdapter(calls);
        recyclerView.setAdapter(callAdapter);
        return view;
    }

    private void addItemCall() {
        calls = new ArrayList<>();
        calls.add(new Call(R.mipmap.img1, R.drawable.ic_baseline_call_made_24, R.drawable.ic_baseline_active_call, "Ibnnu", "Yesterday 15.00"));
        calls.add(new Call(R.mipmap.img2, R.drawable.ic_baseline_call_not_received, R.drawable.ic_baseline_videocam_24, "Joe", "Yesterday 14.00"));
        calls.add(new Call(R.mipmap.img3, R.drawable.ic_baseline_call_made_24, R.drawable.ic_baseline_active_call, "Max", "Yesterday 09.00"));
        calls.add(new Call(R.mipmap.img4, R.drawable.ic_baseline_call_not_received, R.drawable.ic_baseline_videocam_24, "Theng", "Yesterday 16.00"));
        calls.add(new Call(R.mipmap.img5, R.drawable.ic_baseline_call_received_24, R.drawable.ic_baseline_videocam_24, "Dela", "Yesterday 11.00"));
        calls.add(new Call(R.mipmap.img6, R.drawable.ic_baseline_call_made_24, R.drawable.ic_baseline_active_call, "Rome", "Yesterday 00.00"));
    }
}