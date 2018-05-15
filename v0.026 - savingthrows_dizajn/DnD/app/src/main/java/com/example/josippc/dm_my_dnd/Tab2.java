package com.example.josippc.dm_my_dnd;

import android.app.Activity;
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
 * {@link Tab2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab2 newInstance(String param1, String param2) {
        Tab2 fragment = new Tab2();
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
        View view =  inflater.inflate(R.layout.fragment_tab2, container, false);


        if (c.moveToFirst()) {
            do {
                View consLayout = view.findViewById(R.id.constrainttab2);
                final TextView attacksList = view.findViewById(R.id.attacksList);
                final TextView attacksList2 = view.findViewById(R.id.attacksList2);
                final TextView attacksList3 = view.findViewById(R.id.attacksList3);
                final TextView attacksList4 = view.findViewById(R.id.attacksList4);
                final TextView attacksList5 = view.findViewById(R.id.attacksList5);
                final TextView attacksList6 = view.findViewById(R.id.attacksList6);
                final TextView attacksList7 = view.findViewById(R.id.attacksList7);
                final TextView attacksDescription = view.findViewById(R.id.attackDescr);
                final TextView attacksDescription2 = view.findViewById(R.id.attackDescr2);
                final TextView attacksDescription3 = view.findViewById(R.id.attackDescr3);
                final TextView attacksDescription4 = view.findViewById(R.id.attackDescr4);
                final TextView attacksDescription5 = view.findViewById(R.id.attackDescr5);
                final TextView attacksDescription6 = view.findViewById(R.id.attackDescr6);
                final TextView attacksDescription7 = view.findViewById(R.id.attackDescr7);
                if(!c.getString(54).isEmpty())
                {
                    String[] attackListString = c.getString(54).split(", ");
                    int count = attackListString.length;

                    //punjenje
                    for(int i=0; i<count; i++){
                        if(i==0) {
                            attacksList.append(attackListString[i]);
                            attacksDescription.setText(c.getString(55));
                        }
                        else if (i==1){
                            if(c.getString(56) == null || c.getString(56).isEmpty())
                            {

                                attacksList2.setVisibility(View.GONE);
                                attacksDescription2.setVisibility(View.GONE);
                            }else{
                                attacksList2.append(attackListString[i]);
                                attacksDescription2.setText(c.getString(56));
                            }
                        }
                        else if (i==2){

                            if(c.getString(57) == null || c.getString(57).isEmpty())
                            {
                                attacksList3.setVisibility(View.GONE);
                                attacksDescription3.setVisibility(View.GONE);
                            }else{
                                attacksList3.append(attackListString[i]);
                                attacksDescription3.setText(c.getString(57));
                            }

                        }
                        else if (i==3){

                            if(c.getString(58) == null || c.getString(58).isEmpty())
                            {
                                attacksList4.setVisibility(View.GONE);
                                attacksDescription4.setVisibility(View.GONE);
                            }else{
                                attacksList4.append(attackListString[i]);
                                attacksDescription4.setText(c.getString(58));
                            }
                        }

                        else if (i==4){

                            if(c.getString(59) == null || c.getString(59).isEmpty())
                            {
                                attacksList5.setVisibility(View.GONE);
                                attacksDescription5.setVisibility(View.GONE);
                            }else{
                                attacksList5.append(attackListString[i]);
                                attacksDescription5.setText(c.getString(59));
                            }

                        }
                        else if (i==5){

                            if(c.getString(60) == null || c.getString(60).isEmpty())
                            {
                                attacksList6.setVisibility(View.GONE);
                                attacksDescription6.setVisibility(View.GONE);
                            }else{
                                attacksList6.append(attackListString[i]);
                                attacksDescription6.setText(c.getString(60));
                            }

                        }
                        else if (i==6){

                            if(c.getString(61) == null || c.getString(61).isEmpty())
                            {
                                attacksList7.setVisibility(View.GONE);
                                attacksDescription7.setVisibility(View.GONE);
                            }else{
                                attacksList7.append(attackListString[i]);
                                attacksDescription7.setText(c.getString(61));
                            }
                        }

                        TextView novitextview = new TextView(view.getContext());

                        novitextview.setId(i);
                        novitextview.setTextColor(Color.parseColor("#FF290C09"));
                        novitextview.setLayoutParams(new ConstraintLayout.LayoutParams(
                                ConstraintLayout.LayoutParams.FILL_PARENT,
                                ConstraintLayout.LayoutParams.WRAP_CONTENT));
                        ((ConstraintLayout) consLayout).addView(novitextview);

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
