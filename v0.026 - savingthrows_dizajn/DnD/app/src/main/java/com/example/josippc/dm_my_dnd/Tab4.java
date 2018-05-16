package com.example.josippc.dm_my_dnd;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab4.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab4 newInstance(String param1, String param2) {
        Tab4 fragment = new Tab4();
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
        View view =  inflater.inflate(R.layout.fragment_tab4, container, false);


        if (c.moveToFirst()) {
            do {
                View consLayout = view.findViewById(R.id.constrainttab4);
                final TextView leg_info = view.findViewById(R.id.leg_info);
                final TextView leg_list = view.findViewById(R.id.leg_list);
                final TextView leg_list2 = view.findViewById(R.id.leg_list2);
                final TextView leg_list3 = view.findViewById(R.id.leg_list3);
                final TextView leg_list4 = view.findViewById(R.id.leg_list4);
                final TextView leg_list5 = view.findViewById(R.id.leg_list5);
                final TextView leg_list6 = view.findViewById(R.id.leg_list6);
                final TextView leg_desc = view.findViewById(R.id.leg_descr);
                final TextView leg_desc2 = view.findViewById(R.id.leg_descr2);
                final TextView leg_desc3 = view.findViewById(R.id.leg_descr3);
                final TextView leg_desc4 = view.findViewById(R.id.leg_descr4);
                final TextView leg_desc5 = view.findViewById(R.id.leg_descr5);
                final TextView leg_desc6 = view.findViewById(R.id.leg_descr6);

                if(!c.getString(62).isEmpty())
                {
                    String[] leg_listString = c.getString(63).split(", ");
                    int count = leg_listString.length;

                    //punjenje
                    for(int i=0; i<count; i++){
                        if(c.getString(62) == null || c.getString(62).isEmpty())
                        {
                            break;
                        }
                        else {
                            if (i == 0) {
                                leg_list.append("1." + leg_listString[i]);
                                leg_desc.setText(c.getString(64));
                            } else if (i == 1) {
                                if (c.getString(65) == null || c.getString(65).isEmpty()) {

                                    leg_list2.setVisibility(View.GONE);
                                    leg_desc2.setVisibility(View.GONE);
                                } else {
                                    leg_list2.append("2." + leg_listString[i]);
                                    leg_desc2.setText(c.getString(65));
                                }
                            } else if (i == 2) {

                                if (c.getString(66) == null || c.getString(66).isEmpty()) {
                                    leg_list3.setVisibility(View.GONE);
                                    leg_desc3.setVisibility(View.GONE);
                                } else {
                                    leg_list3.append("3." + leg_listString[i]);
                                    leg_desc3.setText(c.getString(66));
                                }

                            } else if (i == 3) {

                                if (c.getString(67) == null || c.getString(67).isEmpty()) {
                                    leg_list4.setVisibility(View.GONE);
                                    leg_desc4.setVisibility(View.GONE);
                                } else {
                                    leg_list4.append("4." + leg_listString[i]);
                                    leg_desc4.setText(c.getString(67));
                                }
                            } else if (i == 4) {

                                if (c.getString(68) == null || c.getString(68).isEmpty()) {
                                    leg_list5.setVisibility(View.GONE);
                                    leg_desc5.setVisibility(View.GONE);
                                } else {
                                    leg_list5.append("5." + leg_listString[i]);
                                    leg_desc5.setText(c.getString(68));
                                }

                            } else if (i == 5) {

                                if (c.getString(69) == null || c.getString(69).isEmpty()) {
                                    leg_list6.setVisibility(View.GONE);
                                    leg_desc6.setVisibility(View.GONE);
                                } else {
                                    leg_list6.append("6." + leg_listString[i]);
                                    leg_desc6.setText(c.getString(66));
                                }

                            }
                        }

                    }

                    if (c.getString(62) == null || c.getString(62).isEmpty()) {
                        leg_info.setVisibility(View.GONE);
                    } else {
                        leg_info.setText(c.getString(62));
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
