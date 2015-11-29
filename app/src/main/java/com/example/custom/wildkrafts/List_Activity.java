package com.example.custom.wildkrafts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tatwika Kashyap on 28-10-2015.
 */
public class List_Activity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener, AdapterView.OnItemClickListener {

    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    private ListView listView1;
    List<lists> rowitems;
    String[] titles=new String[]{"Tops and tees","Jackets","Dresses","Trousers and jeans","Scarf","Ethnic","Skirts"};
    Integer[] images={R.drawable.tops,R.drawable.jacket,R.drawable.dress,R.drawable.trousers,R.drawable.scarf,R.drawable.ethnic,R.drawable.skirts};
    Integer[] arrow={R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next};
    String label,title,frag;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        label=intent.getExtras().getString("titlelist");
        setTitle(label);
        frag=intent.getExtras().getString("titlefrag");


        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rowitems = new ArrayList<lists>();
        for (int i = 0; i < titles.length; i++) {
            lists item = new lists(images[i], titles[i],arrow[i]);
            rowitems.add(item);
        }

        listView1 = (ListView) findViewById(R.id.listView);
        listsAdapter adapter = new listsAdapter(this,
                R.layout.items_row, rowitems);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(this);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

    }
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        if(titles[position].equalsIgnoreCase("Tops and tees"))
        {
            Intent intent = new Intent(List_Activity.this, Select_item.class);
            intent.putExtra("titleselect",titles[position]);
            intent.putExtra("titlelist",label);
            intent.putExtra("titlefrag",frag);
            startActivity(intent);
            finish();

        }
        else
            Toast.makeText(getBaseContext(), titles[position], Toast.LENGTH_SHORT).show();
    }


    public void onDrawerItemSelected(View view, int position) {

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed()
    {
        Intent intent=new Intent(List_Activity.this,Main_fragment.class);
        intent.putExtra("titlefrag",frag);
        startActivity(intent);
        finish();
        super.onBackPressed();

    }
}

