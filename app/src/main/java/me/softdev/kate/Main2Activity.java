package me.softdev.kate;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    Toolbar mToolbar = null;
    final public String TAG = "xx";
    int[] Image = {R.drawable.teacher, R.drawable.doctor, R.drawable.engineering,R.drawable.at};
    String[] Name = {"Teacher", "Doctor", "Engineering", "Athlete"};
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView Ls = (ListView) findViewById(R.id.Listme);
        Main2Activity.CustomAdapter cs = new Main2Activity.CustomAdapter();
        Ls.setAdapter(cs);
            mToolbar = (Toolbar) findViewById(R.id.nav_action);
            setSupportActionBar(mToolbar);
            mDrawerLayout = (DrawerLayout)findViewById(R.id.drawableLayout);
            mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.opent,R.string.close);
            mDrawerLayout.addDrawerListener(mToggle);
            mToggle.syncState();
            navigationView = (NavigationView)findViewById(R.id.navigation_view);
            navigationView.setNavigationItemSelectedListener(this);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Image.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout, null);

            ImageView imgview = (ImageView) view.findViewById(R.id.pic1);
            TextView header = (TextView) view.findViewById(R.id.header);

            View root = imgview.getRootView();
            if (i % 2 == 0) {
                root.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            } else {
                root.setBackgroundColor(getResources().getColor(android.R.color.secondary_text_dark_nodisable));
            }
            imgview.setImageResource(Image[i]);
            header.setText(Name[i]);

            return view;
        }
    }

        public boolean onOptionsItemSelected(MenuItem itemss) {
            if(mToggle.onOptionsItemSelected(itemss)){
                Log.e(TAG,itemss.toString());

                return true;

            }
            onNavigationItemSelected(itemss);
            return super.onOptionsItemSelected(itemss);
        }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.e(TAG,item.toString());
        if(item.isChecked()) {
            Intent newAct = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(newAct);
            return true;
        }
        return false;
    }
}



