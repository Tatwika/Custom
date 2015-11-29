package com.example.custom.wildkrafts;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class Select_item  extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    GridView grid;
    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;
    TextView number;

    String[] name = {"Summer Stripes","Hungry","New Emoji","Flower pattern","Gray Sleeveless","Floral","Black tee","New Blue","Star Wars","Black bow","White work","Shades","Crop top","Cult fiction","Collared top","Soccer tee"};
    int[] imageId = {R.drawable.stripes,R.drawable.hungry,R.drawable.emoji,R.drawable.flower,R.drawable.gray,R.drawable.full,R.drawable.tee,R.drawable.swag,R.drawable.wars,R.drawable.bow,R.drawable.work,R.drawable.shades,R.drawable.crop,R.drawable.cult,R.drawable.collar,R.drawable.soccer};
    String[] actual={"749","999","1599","456","765","399","655","2099","289","1999","1899","2899","3000","599","2799","1099"};
    String[] discount={"500","659","699","299","376","200","380","999","159","999","899","1876","1990","357","1588","543"};
    String label,list,frag;
    float width,height;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_grid);
        Intent intent = getIntent();
        label=intent.getExtras().getString("titleselect");
        list=intent.getExtras().getString("titlelist");
        frag=intent.getExtras().getString("titlefrag");
        setTitle(label);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;


        number=(TextView)findViewById(R.id.number);
        number.setText(name.length+ " items found");
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);


        Custom_Grid adapter = new Custom_Grid(Select_item.this, imageId, name, actual, discount);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                    Intent myIntent = new Intent(Select_item.this,Buy_Activity.class);

                    myIntent.putExtra("titlebuy",name[position]);
                    myIntent.putExtra("Discount",discount[position]);
                    myIntent.putExtra("Image",imageId[position]);
                    myIntent.putExtra("titleselect",label );
                myIntent.putExtra("titlelist",list );
                myIntent.putExtra("titlefrag",frag );



                startActivity(myIntent);
                finish();

            }
        });

    }
    public void onDrawerItemSelected(View view, int position) {

    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    public void sort(View view) {
        final Dialog dialog = new Dialog(Select_item.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = Math.round((width * 10) / 15);
        lp.height = Math.round(height / 3);
        dialog.getWindow().setAttributes(lp);
        Button button = (Button) dialog.findViewById(R.id.button);
        Button button2 = (Button) dialog.findViewById(R.id.button2);
        button.setText("Low to high");
        button2.setText("High to low");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp;
                int tem;
                for (int i = 0; i < name.length; i++) {
                    for (int j = i + 1; j < name.length; j++) {
                        if (Integer.parseInt(discount[j]) < Integer.parseInt(discount[i])) {
                            temp = discount[i];
                            discount[i] = discount[j];
                            discount[j] = temp;
                            temp = actual[i];
                            actual[i] = actual[j];
                            actual[j] = temp;
                            temp = name[i];
                            name[i] = name[j];
                            name[j] = temp;
                            tem = imageId[i];
                            imageId[i] = imageId[j];
                            imageId[j] = tem;
                            Custom_Grid adapter = new Custom_Grid(Select_item.this, imageId, name, actual, discount);
                            grid = (GridView) findViewById(R.id.grid);
                            grid.setAdapter(adapter);

                        }
                    }

                }
                dialog.dismiss();
                number.setText(name.length + " items found");


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp;
                int tem;
                for (int i = 0; i < name.length; i++) {
                    for (int j = i + 1; j < name.length; j++) {
                        if (Integer.parseInt(discount[j]) > Integer.parseInt(discount[i])) {
                            temp = discount[i];
                            discount[i] = discount[j];
                            discount[j] = temp;
                            temp = actual[i];
                            actual[i] = actual[j];
                            actual[j] = temp;
                            temp = name[i];
                            name[i] = name[j];
                            name[j] = temp;
                            tem = imageId[i];
                            imageId[i] = imageId[j];
                            imageId[j] = tem;
                            Custom_Grid adapter = new Custom_Grid(Select_item.this, imageId, name, actual, discount);
                            grid = (GridView) findViewById(R.id.grid);
                            grid.setAdapter(adapter);

                        }
                    }

                }

                dialog.dismiss();
                number.setText(name.length+ " items found");


            }
        });
        dialog.show();


        }
    public void filter(View view)
    { final Dialog dialog = new Dialog(Select_item.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = Math.round((width * 10) / 15);
        lp.height = Math.round(height / 3);
        dialog.getWindow().setAttributes(lp);
        Button button = (Button) dialog.findViewById(R.id.button);
        Button button2 = (Button) dialog.findViewById(R.id.button2);
        button.setText(" < 500 ");
        button2.setText(" > 500 ");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int j = 0, k = 0;
                for (int i = 0; i < name.length; i++) {
                    if (Integer.parseInt(discount[i]) < 500) {
                        j++;
                    }
                }
                String[] nam = new String[j];
                String[] act = new String[j];
                String[] dis = new String[j];
                int[] imI = new int[j];

                for (int i = 0; i < name.length; i++) {
                    if (Integer.parseInt(discount[i]) < 500) {
                        nam[k] = name[i];
                        act[k] = actual[i];
                        dis[k] = discount[i];
                        imI[k] = imageId[i];
                        k++;

                    }
                }

                Custom_Grid adapter = new Custom_Grid(Select_item.this, imI, nam, act, dis);
                grid = (GridView) findViewById(R.id.grid);
                grid.setAdapter(adapter);


                dialog.dismiss();
                number.setText(nam.length + " items found");


            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int j=0,k=0;
                for (int i = 0; i < name.length; i++) {
                    if (Integer.parseInt(discount[i]) > 500) {
                        j++;
                    }
                }
                String[] nam=new String[j];
                String[] act=new String[j];
                String[] dis=new String[j];
                int[] imI=new int[j];

                for (int i = 0; i < name.length; i++) {
                    if (Integer.parseInt(discount[i]) > 500) {
                        nam[k] = name[i];
                        act[k] = actual[i];
                        dis[k] = discount[i];
                        imI[k] = imageId[i];
                        k++;

                    }
                }

                Custom_Grid adapter = new Custom_Grid(Select_item.this, imI, nam, act, dis);
                grid = (GridView) findViewById(R.id.grid);
                grid.setAdapter(adapter);


                dialog.dismiss();
                number.setText(nam.length+ " items found");


            }
        });
        dialog.show();



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
          Intent intent=new Intent(Select_item.this, List_Activity.class);
        intent.putExtra("titlelist",list);
        intent.putExtra("titlefrag",frag);

        startActivity(intent);
        finish();
        super.onBackPressed();

    }
}
