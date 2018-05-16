package com.example.josippc.dm_my_dnd;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab3.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab3 newInstance(String param1, String param2) {
        Tab3 fragment = new Tab3();
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

        Bundle b = getActivity().getIntent().getExtras();

        final String monsterId = b.getString("monsterId");

        Cursor c = null;
        DatabaseHelper myDbHelper = new DatabaseHelper(getActivity());
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        String[] args = { monsterId };

        c = myDbHelper.myDataBase.query("monsters", null ,"_id=?", args,  null, null, "Name");
        View view =  inflater.inflate(R.layout.fragment_tab3, container, false);


        if (c.moveToFirst()) {
            do {
                View consLayout = view.findViewById(R.id.constrainttab3);
                final TextView traitsList = view.findViewById(R.id.traitsList);
                final TextView traitsList2 = view.findViewById(R.id.traitsList2);
                final TextView traitsList3 = view.findViewById(R.id.traitsList3);
                final TextView traitsList4 = view.findViewById(R.id.traitsList4);
                final TextView traitsList5 = view.findViewById(R.id.traitsList5);
                final TextView traitsList6 = view.findViewById(R.id.traitsList6);
                final TextView traitsList7 = view.findViewById(R.id.traitsList7);
                final TextView traitsList8 = view.findViewById(R.id.traitsList8);
                final TextView traitsList9 = view.findViewById(R.id.traitsList9);
                final TextView traitsList10 = view.findViewById(R.id.traitsList10);
                final TextView traitsDesc = view.findViewById(R.id.traitsDescr);
                final TextView traitsDesc2 = view.findViewById(R.id.traitsDescr2);
                final TextView traitsDesc3 = view.findViewById(R.id.traitsDescr3);
                final TextView traitsDesc4 = view.findViewById(R.id.traitsDescr4);
                final TextView traitsDesc5 = view.findViewById(R.id.traitsDescr5);
                final TextView traitsDesc6 = view.findViewById(R.id.traitsDescr6);
                final TextView traitsDesc7 = view.findViewById(R.id.traitsDescr7);
                final TextView traitsDesc8 = view.findViewById(R.id.traitsDescr8);
                final TextView traitsDesc9 = view.findViewById(R.id.traitsDescr9);
                final TextView traitsDesc10 = view.findViewById(R.id.traitsDescr10);
                if(!c.getString(54).isEmpty())
                {
                    String[] traitsListString = c.getString(39).split(", ");
                    int count = traitsListString.length;

                    //punjenje
                    for(int i=0; i<count; i++){
                        if(c.getString(40) == null || c.getString(40).isEmpty())
                        {
                            break;
                        }
                        else {
                            if (i == 0) {
                                traitsList.append("1. " + traitsListString[i]);
                                traitsDesc.setText(c.getString(40));
                            } else if (i == 1) {
                                if (c.getString(41) == null || c.getString(41).isEmpty()) {

                                    traitsList2.setVisibility(View.GONE);
                                    traitsDesc2.setVisibility(View.GONE);
                                } else {
                                    traitsList2.append("2." + traitsListString[i]);
                                    traitsDesc2.setText(c.getString(41));
                                }
                            } else if (i == 2) {

                                if (c.getString(42) == null || c.getString(42).isEmpty()) {
                                    traitsList3.setVisibility(View.GONE);
                                    traitsDesc3.setVisibility(View.GONE);
                                } else {
                                    traitsList3.append("3." + traitsListString[i]);
                                    traitsDesc3.setText(c.getString(42));
                                }

                            } else if (i == 3) {

                                if (c.getString(43) == null || c.getString(43).isEmpty()) {
                                    traitsList4.setVisibility(View.GONE);
                                    traitsDesc4.setVisibility(View.GONE);
                                } else {
                                    traitsList4.append("4." + traitsListString[i]);
                                    traitsDesc4.setText(c.getString(43));
                                }
                            } else if (i == 4) {

                                if (c.getString(44) == null || c.getString(44).isEmpty()) {
                                    traitsList5.setVisibility(View.GONE);
                                    traitsDesc5.setVisibility(View.GONE);
                                } else {
                                    traitsList5.append("5." + traitsListString[i]);
                                    traitsDesc5.setText(c.getString(44));
                                }

                            } else if (i == 5) {

                                if (c.getString(45) == null || c.getString(45).isEmpty()) {
                                    traitsList6.setVisibility(View.GONE);
                                    traitsDesc6.setVisibility(View.GONE);
                                } else {
                                    traitsList6.append("6." + traitsListString[i]);
                                    traitsDesc6.setText(c.getString(45));
                                }

                            } else if (i == 6) {

                                if (c.getString(46) == null || c.getString(46).isEmpty()) {
                                    traitsList7.setVisibility(View.GONE);
                                    traitsDesc7.setVisibility(View.GONE);
                                } else {
                                    traitsList7.append("7." + traitsListString[i]);
                                    traitsDesc7.setText(c.getString(46));
                                }

                            } else if (i == 7) {

                                if (c.getString(47) == null || c.getString(47).isEmpty()) {
                                    traitsList8.setVisibility(View.GONE);
                                    traitsDesc8.setVisibility(View.GONE);
                                } else {
                                    traitsList8.append("8." + traitsListString[i]);
                                    traitsDesc8.setText(c.getString(47));
                                }

                            } else if (i == 8) {

                                if (c.getString(48) == null || c.getString(48).isEmpty()) {
                                    traitsList9.setVisibility(View.GONE);
                                    traitsDesc6.setVisibility(View.GONE);
                                } else {
                                    traitsList9.append("9." + traitsListString[i]);
                                    traitsDesc9.setText(c.getString(48));
                                }

                            } else if (i == 9) {

                                if (c.getString(49) == null || c.getString(49).isEmpty()) {
                                    traitsList10.setVisibility(View.GONE);
                                    traitsDesc10.setVisibility(View.GONE);
                                } else {
                                    traitsList10.append("10." + traitsListString[i]);
                                    traitsDesc10.setText(c.getString(49));
                                }
                            }
                        }

                    }
                }

            } while (c.moveToNext());
        }

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
