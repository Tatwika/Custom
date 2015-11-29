package com.example.custom.wildkrafts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main_fragment extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener, AdapterView.OnItemClickListener
{

    Gallery myHorizontalListView;
    MyAdapter myAdapter;
    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;

    private ListView listView1;
    List<lists> rowitems;
    String[] titles=new String[]{"Clothing","Footwear","Bags","Sunglasses","Cosmetics"};
    Integer[] images={R.drawable.clothing,R.drawable.footwear,R.drawable.bags,R.drawable.sunglasses,R.drawable.cosmetics};
    Integer[] arrow={R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next,R.drawable.next};


    TextView popular,category;
String label;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_main);
        Intent intent = getIntent();
        label=intent.getExtras().getString("titlefrag");
        setTitle(label);

        popular=(TextView)findViewById(R.id.popular);
        category=(TextView)findViewById(R.id.category);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myHorizontalListView = (Gallery)findViewById(R.id.horizontallistview);

        myAdapter = new MyAdapter(this);
        myHorizontalListView.setAdapter(myAdapter);

        rowitems = new ArrayList<lists>();
        for (int i = 0; i < titles.length; i++) {
            lists item = new lists(images[i], titles[i],arrow[i]);
            rowitems.add(item);
        }

        listView1 = (ListView) findViewById(R.id.listView2);
        listsAdapter adapter = new listsAdapter(this,R.layout.items_row, rowitems);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(this);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);
    }
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        if (titles[position].equalsIgnoreCase("Clothing")) {
            Intent intent = new Intent(Main_fragment.this, List_Activity.class);
            intent.putExtra("titlelist",titles[position]);
            intent.putExtra("titlefrag", label);

            startActivity(intent);
            finish();

        }
        else
            Toast.makeText(getBaseContext(),titles[position], Toast.LENGTH_SHORT).show();
    }

    public void onBackPressed()
    {
        Intent intent=new Intent(Main_fragment.this,MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
    public void onDrawerItemSelected(View view, int position) {

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class MyAdapter extends BaseAdapter {

        Context context;

        int[] itemsArray = {
        R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten,R.drawable.eleven};

        MyAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return itemsArray.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return itemsArray[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub

            View rowView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.row, null);
            ImageView image=(ImageView)rowView.findViewById(R.id.itemtext);
            image.setImageResource(itemsArray[position]);

            return rowView;
        }


    }

}