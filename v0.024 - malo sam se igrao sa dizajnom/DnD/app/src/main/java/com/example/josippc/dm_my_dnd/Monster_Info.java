package com.example.josippc.dm_my_dnd;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.josippc.dm_my_dnd.R.id.allmonsters;
import static com.example.josippc.dm_my_dnd.R.id.textView2;
import static com.example.josippc.dm_my_dnd.R.id.view;

public class Monster_Info extends MonsterView {
    ListView listView ;
    EditText inputSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_info);

        inputSearch = (EditText) findViewById(R.id.inputSearch);

        Cursor c = null;
        Bundle b = getIntent().getExtras();
        final String monsterType = b.getString("buttonText");
        DatabaseHelper myDbHelper = new DatabaseHelper(Monster_Info.this);
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


        String[] args = { monsterType };
        String Allmonsters = getResources().getString(R.string.AllMonsters);
        if (monsterType.equals(Allmonsters))
        {
            c = myDbHelper.myDataBase.query("monsters", null ,null,null,  null, null, "CR");
        }else
        {
            c = myDbHelper.myDataBase.query("monsters", null ,"Type=?", args,  null, null, "CR");
        }


        final ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> item;
        if (c.moveToFirst()) {
            do {
                item = new HashMap<String, String>();
                item.put("line1", c.getString(1));
                item.put("line2"," XP: " + c.getString(12) + "  - CR " + c.getString(11));
                item.put("line3", c.getString(0));
                list.add(item);
            } while (c.moveToNext());
        }
        // U LAYOUT -> "LIST_BLACK_TEXT.XML" MIJENJAMO IZGLED LISTVIEWA, ovdje smo odabrali da liniju1 (monstername) prikazujemo sa line_a textviewom otamo
        // A line2 (exp i cr) sa line_b iz LIST_BLACK_TEXT.xml
        final SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.list_black_text,
                new String[] {"line1", "line2"},
                new int[] {R.id.line_a, R.id.line_b });

        listView = (ListView) findViewById(R.id.ListViewMonsterInfo);





        listView.setAdapter(adapter);
        //listView.setAdapter(new ArrayAdapter<String>(this, R.layout.listrow, textView2)); -ovo bi trebalo spojit xml za mijenjanje boje medjutim ne radi


        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                HashMap<String, Object> obj = (HashMap<String, Object>) adapter.getItem(position);
                String monsterId = (String) obj.get("line3");

                    Intent intent = new Intent(getBaseContext(), DistinctMonster.class);
                    intent.putExtra("monsterId", monsterId);
                    startActivityForResult(intent, 0);

            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }

        });
    }
}
