package com.example.custom.wildkrafts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Buy_Activity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    private ListView listView1;
    TextView name,detail;
    Button buy,shop;
    ImageView image;
    String title,select,list,frag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        Intent intent = getIntent();
        select=intent.getExtras().getString("titleselect");
        list=intent.getExtras().getString("titlelist");
        frag=intent.getExtras().getString("titlefrag");

        setTitle(intent.getExtras().getString("titlebuy"));
        name=(TextView)findViewById(R.id.product);
        detail=(TextView)findViewById(R.id.detail);
        buy=(Button)findViewById(R.id.buy);
        shop=(Button)findViewById(R.id.shop);
        image=(ImageView) findViewById(R.id.image);

        name.setText(intent.getExtras().getString("Name"));
        detail.setText("Total : Rs."+intent.getExtras().getString("Discount"));
        image.setImageResource(intent.getExtras().getInt("Image"));

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

    }



    public void onDrawerItemSelected(View view, int position) {

    }
    public void back(View view)
    {
        Intent intent=new Intent(Buy_Activity.this,Select_item.class);
        intent.putExtra("titleselect",select);
        intent.putExtra("titlelist",list);
        intent.putExtra("titlefrag",frag);

        startActivity(intent);
        finish();
    }
    public void onBackPressed()
    {
        Intent intent=new Intent(Buy_Activity.this,Select_item.class);
        intent.putExtra("titleselect",select);
        intent.putExtra("titlelist",list);
        intent.putExtra("titlefrag",frag);

        startActivity(intent);
        finish();
        super.onBackPressed();


    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mark, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_bookmark) {
            return true;
        }
        else if (id == R.id.action_share) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}



