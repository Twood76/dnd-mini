package com.example.josippc.dm_my_dnd;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.IOException;
import android.database.Cursor;
import android.database.SQLException;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
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
        View view =  inflater.inflate(R.layout.fragment_tab1, container, false);

        if (c.moveToFirst()) {
            do {
                TextView ime = view.findViewById(R.id.ime_monstera);
                ime.setText(c.getString(1));
                final TextView typeMonster = view.findViewById(R.id.type_monster);
                typeMonster.setText(c.getString(2));
                final TextView size = view.findViewById(R.id.size_monster);
                size.setText(c.getString(3));
                final TextView exp = view.findViewById(R.id.exp_monstera);
                exp.setText(c.getString(12));
                final TextView cr = view.findViewById(R.id.CR_monstera);
                cr.setText(c.getString(11));
                final TextView hp = view.findViewById(R.id.HP_monstera);
                if(c.getString(10) == null){
                    hp.setText(c.getString(7) + " (" + c.getString(8) + "d" + c.getString(9) + ")");
                }else hp.setText(c.getString(7) + " (" + c.getString(8) + "d" + c.getString(9) + " + " + c.getString(10) + ")");


                final TextView ac = view.findViewById(R.id.Ac_monstera);
                ac.setText(c.getString(6));

                final TextView str = view.findViewById(R.id.str_monstera);
                str.setText(c.getString(15));
                final TextView dex = view.findViewById(R.id.dex_monstera);
                dex.setText(c.getString(16));
                final TextView con = view.findViewById(R.id.con_monstera);
                con.setText(c.getString(17));
                final TextView intel = view.findViewById(R.id.int_monstera);
                intel.setText(c.getString(18));
                final TextView wis = view.findViewById(R.id.wis_monstera);
                wis.setText(c.getString(19));
                final TextView cha = view.findViewById(R.id.cha_monstera);
                cha.setText(c.getString(20));

                final TextView strST = view.findViewById(R.id.strST_monstera);
                strST.setText(c.getString(26));
                final TextView dexST = view.findViewById(R.id.dexST_monstera);
                dexST.setText(c.getString(27));
                final TextView conST = view.findViewById(R.id.conST_monstera);
                conST.setText(c.getString(28));
                final TextView intST = view.findViewById(R.id.intST_monstera);
                intST.setText(c.getString(29));
                final TextView wisST = view.findViewById(R.id.wisST_monstera);
                wisST.setText(c.getString(30));
                final TextView chaST = view.findViewById(R.id.chaST_monstera);
                chaST.setText(c.getString(31));

                final TextView base_speed = view.findViewById(R.id.speed_monstera);
                base_speed.setText(c.getString(21));
                final TextView burrow = view.findViewById(R.id.speedburrow_monstera);
                burrow.setText(c.getString(22));
                final TextView climb = view.findViewById(R.id.speedclimb_monstera);
                climb.setText(c.getString(23));
                final TextView fly = view.findViewById(R.id.speedfly_monstera);
                fly.setText(c.getString(24));
                final TextView swim = view.findViewById(R.id.speedswim_monstera);
                swim.setText(c.getString(25));

                final TextView align = view.findViewById(R.id.alignment_monstera);
                align.setText(c.getString(4));

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