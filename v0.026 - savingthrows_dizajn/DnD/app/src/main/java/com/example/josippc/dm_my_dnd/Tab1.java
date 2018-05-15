package com.example.josippc.dm_my_dnd;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
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
                    hp.setText(c.getString(7) + "(" + c.getString(8) + "d" + c.getString(9) + ")");
                }
                /*else if (c.getString(10) < 1)
                {

                }*/ else hp.setText(c.getString(7) + "(" + c.getString(8) + "d" + c.getString(9) + "+" + c.getString(10) + ")");


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

                // SAVING THROWS
                final TextView strSTS = view.findViewById(R.id.strSTS_monstera);
                final TextView strST = view.findViewById(R.id.strST_monstera);
                if(c.getString(26) == null || c.getString(26).isEmpty())
                {
                    strST.setVisibility(View.GONE);
                    strSTS.setVisibility(View.GONE);
                }
                else{
                    strST.setText(c.getString(26));
                }

                final TextView dexSTS = view.findViewById(R.id.dexSTS_monstera);
                final TextView dexST = view.findViewById(R.id.dexST_monstera);
                if(c.getString(27) == null || c.getString(27).isEmpty())
                {
                    dexST.setVisibility(View.GONE);
                    dexSTS.setVisibility(View.GONE);
                }
                else{
                    dexST.setText(c.getString(27));
                }

                final TextView conSTS = view.findViewById(R.id.conSTS_monstera);
                final TextView conST = view.findViewById(R.id.conST_monstera);
                if(c.getString(28) == null || c.getString(28).isEmpty())
                {
                    conST.setVisibility(View.GONE);
                    conSTS.setVisibility(View.GONE);
                }
                else{
                    conST.setText(c.getString(28));
                }

                final TextView intSTS = view.findViewById(R.id.intSTS_monstera);
                final TextView intST = view.findViewById(R.id.intST_monstera);
                if(c.getString(29) == null || c.getString(29).isEmpty())
                {
                    intST.setVisibility(View.GONE);
                    intSTS.setVisibility(View.GONE);
                }
                else{
                    intST.setText(c.getString(29));
                }

                final TextView wisSTS = view.findViewById(R.id.wisSTS_monstera);
                final TextView wisST = view.findViewById(R.id.wisST_monstera);
                if(c.getString(30) == null || c.getString(30).isEmpty())
                {
                    wisST.setVisibility(View.GONE);
                    wisSTS.setVisibility(View.GONE);
                }
                else{
                    wisST.setText(c.getString(30));
                }

                final TextView chaSTS = view.findViewById(R.id.chaSTS_monstera);
                final TextView chaST = view.findViewById(R.id.chaST_monstera);
                if(c.getString(31) == null || c.getString(31).isEmpty())
                {
                    chaST.setVisibility(View.GONE);
                    chaSTS.setVisibility(View.GONE);
                }
                else{
                    chaST.setText(c.getString(31));
                }

                // Ako nema nijednog saving throwa, podigni i sakrij horizontal line
                if(strSTS.getVisibility()==View.GONE &&
                        dexSTS.getVisibility()==View.GONE &&
                        conSTS.getVisibility()==View.GONE &&
                        intSTS.getVisibility()==View.GONE &&
                        wisSTS.getVisibility()==View.GONE &&
                        chaSTS.getVisibility()==View.GONE)
                    {
                        final View SavingThrowView = (View) view.findViewById(R.id.view6);
                        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) SavingThrowView.getLayoutParams();
                        lp.setMargins(8,0,8,0);
                        SavingThrowView.setVisibility(View.GONE);
                    }


                // SPEEDS
                final TextView base_speed = view.findViewById(R.id.speed_monstera);
                base_speed.setText(c.getString(21));
               /* final TextView burrow = view.findViewById(R.id.speedburrow_monstera);
                burrow.setText(c.getString(22));
                final TextView climb = view.findViewById(R.id.speedclimb_monstera);
                climb.setText(c.getString(23));
                final TextView fly = view.findViewById(R.id.speedfly_monstera);
                fly.setText(c.getString(24));
                final TextView swim = view.findViewById(R.id.speedswim_monstera);
                swim.setText(c.getString(25));*/


                //sakriva speedove ako ih nema (osim base)
                final TextView burrowt = view.findViewById(R.id.burrow_text);
                final TextView burrow = view.findViewById(R.id.speedburrow_monstera);
                if(c.getString(22) == null || c.getString(22).isEmpty())
                {
                    burrowt.setVisibility(View.GONE);
                    burrow.setVisibility(View.GONE);
                }
                else{
                    burrow.setText(c.getString(22));
                }

                final TextView climbt = view.findViewById(R.id.climb_text);
                final TextView climb = view.findViewById(R.id.speedclimb_monstera);
                if(c.getString(23) == null || c.getString(23).isEmpty())
                {
                    climbt.setVisibility(View.GONE);
                    climb.setVisibility(View.GONE);
                }
                else{
                    climb.setText(c.getString(23));
                }

                final TextView flyt = view.findViewById(R.id.flying_text);
                final TextView fly = view.findViewById(R.id.speedfly_monstera);
                if(c.getString(24) == null || c.getString(24).isEmpty())
                {
                    flyt.setVisibility(View.GONE);
                    fly.setVisibility(View.GONE);
                }
                else{
                    fly.setText(c.getString(24));
                }

                final TextView swimt = view.findViewById(R.id.swim_text);
                final TextView swim = view.findViewById(R.id.speedswim_monstera);
                if(c.getString(25) == null || c.getString(25).isEmpty())
                {
                    swimt.setVisibility(View.GONE);
                   swim.setVisibility(View.GONE);
                }
                else{
                    swim.setText(c.getString(25));
                }



                //Alignment pretvara u puni naziv
                final TextView align = view.findViewById(R.id.alignment_monstera);
                switch(c.getString(4))
                {
                    case "U":
                        align.setText("Unaligned");
                        break;
                    case "LG":
                        align.setText("Lawful Good");
                        break;
                    case "LN":
                        align.setText("Lawful Neutral");
                        break;
                    case "LE":
                        align.setText("Lawful Evil");
                        break;
                    case "CG":
                        align.setText("Chaotic Good");
                        break;
                    case "CN":
                        align.setText("Chaotic Neutral");
                        break;
                    case "CE":
                        align.setText("Chaotic Evil");
                        break;
                    case "Any":
                        align.setText("Any");
                        break;
                    case "!G":
                        align.setText("Any non-good");
                        break;
                    case "!L":
                        align.setText("Any non-lawful");
                        break;
                    case "*C":
                        align.setText("Any chaotic");
                        break;
                    case "*E":
                        align.setText("Any evil");
                        break;
                    case "CG|NE":
                        align.setText("Chaotic Good or Neutral Evil");
                        break;
                    case "N":
                        align.setText("Neutral");
                        break;
                    case "NE":
                        align.setText("Neutral Evil");
                        break;
                    case "NG":
                        align.setText("Neutral Good");
                        break;
                    case "NG|NE":
                        align.setText("Neutral Good or Neutral Evil");
                        break;
                    default:
                        align.setText(c.getString(4));
                }

                final TextView skills_string = view.findViewById(R.id.skills_string);
                final TextView skills_monstera = view.findViewById(R.id.skills_monstera);
                if(c.getString(36) == null || c.getString(36).isEmpty())
                {
                    skills_string.setVisibility(View.GONE);
                    skills_monstera.setVisibility(View.GONE);
                }
                else{
                    skills_monstera.setText(c.getString(36));
                }

                final TextView senses_string = view.findViewById(R.id.senses_string);
                final TextView senses_monstera = view.findViewById(R.id.senses_monstera);
                if(c.getString(37) == null || c.getString(37).isEmpty())
                {
                    senses_string.setVisibility(View.GONE);
                    senses_monstera.setVisibility(View.GONE);
                }
                else{
                    senses_monstera.setText(c.getString(37));
                }

                final TextView lang_string = view.findViewById(R.id.lang_string);
                final TextView lang_monstera = view.findViewById(R.id.lang_monstera);
                if(c.getString(38) == null || c.getString(38).isEmpty())
                {
                    lang_string.setVisibility(View.GONE);
                    lang_monstera.setVisibility(View.GONE);
                }
                else{
                    lang_monstera.setText(c.getString(38));
                }

                if(skills_monstera.getVisibility()==View.GONE &&
                        senses_monstera.getVisibility()==View.GONE &&
                        lang_monstera.getVisibility()==View.GONE)
                {
                    final View SkillsView = (View) view.findViewById(R.id.view10);
                    ConstraintLayout.LayoutParams lp1 = (ConstraintLayout.LayoutParams) SkillsView.getLayoutParams();
                    lp1.setMargins(8,0,8,0);
                    SkillsView.setVisibility(View.GONE);
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
