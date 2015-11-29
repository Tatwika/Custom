package com.example.custom.wildkrafts;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener, AdapterView.OnItemClickListener {

    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    private ListView listView1;
    List<list> rowitems;
    String[] titles=new String[]{"Women","Men","Kids and Babies","Beauty","Sale","Furniture","Home Furnishing","Kitchenware"};
    Integer[] images={R.drawable.women,R.drawable.men,R.drawable.kids,R.drawable.beauty,R.drawable.sale,R.drawable.furniture,R.drawable.furnish,R.drawable.kitchenware};
    String[] desc={"Clothing,Footwear,Bags","Clothing,Footwear,Bags","Clothing and Toys","Cosmetics","Men,Women and kids","Sofa,Dinner Table","Bath,Home Decor","Glassware,Tableware"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rowitems = new ArrayList<list>();
        for (int i = 0; i < titles.length; i++) {
            list item = new list(images[i], titles[i],desc[i]);
            rowitems.add(item);
        }

        listView1 = (ListView) findViewById(R.id.listView);
        listAdapter adapter = new listAdapter(this,
                R.layout.item_row, rowitems);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(this);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

    }
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
    if(titles[position].equalsIgnoreCase("Women"))
    {
        Intent intent=new Intent(MainActivity.this,Main_fragment.class);
        intent.putExtra("titlefrag",titles[position]);
        startActivity(intent);
        finish();
    }
        else
    Toast.makeText(getBaseContext(),titles[position],Toast.LENGTH_SHORT).show();
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
public void onBackPressed()
{
 finish();
    System.exit(1);
}
}
