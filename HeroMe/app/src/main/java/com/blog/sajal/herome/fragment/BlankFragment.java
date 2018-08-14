package com.blog.sajal.herome.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.blog.sajal.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private Button btnAccident, btnGenetic, btnBorn, btnChoos;

    private MainFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        btnAccident = (Button) v.findViewById(R.id.btn_accident);
        btnGenetic = (Button) v.findViewById(R.id.btn_genetic);
        btnBorn = (Button) v.findViewById(R.id.btn_born);
        btnChoos = (Button) v.findViewById(R.id.btn_chose);

        btnChoos.setEnabled(false);
        btnChoos.getBackground().setAlpha(100);
        // Inflate the layout for this fragment

        btnAccident.setOnClickListener(this);
        btnGenetic.setOnClickListener(this);
        btnBorn.setOnClickListener(this);
        btnChoos.setOnClickListener(this);

        btnAccident.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.lightning, 0, 0, 0);
        btnGenetic.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.spider_web, 0, 0, 0);
        btnBorn.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.rocket, 0, 0, 0);

        return v;
    }

    @Override
    public void onClick(View view) {
        btnChoos.setEnabled(true);
        btnChoos.getBackground().setAlpha(255);

        Button btn = (Button) view;

        btnAccident.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.lightning, 0, 0, 0);
        btnGenetic.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.spider_web, 0, 0, 0);
        btnBorn.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.rocket, 0, 0, 0);

        int leftButtonIcon = 0;

        if (btn == btnAccident) {
            leftButtonIcon = R.mipmap.lightning;
        } else if (btn == btnGenetic) {
            leftButtonIcon = R.mipmap.spider_web;
        } else if (btn == btnBorn) {
            leftButtonIcon = R.mipmap.rocket;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftButtonIcon, 0, R.mipmap.item_selected, 0);
    }

    // TODO: Rename method, update argument and hook method into UI event

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);
    }
}
