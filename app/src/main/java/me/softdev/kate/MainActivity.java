package me.softdev.kate;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] Image = {R.drawable.teacher, R.drawable.doctor, R.drawable.engineering,R.drawable.at};
    String[] Name = {"Teacher", "Doctor", "Engineering", "Athlete"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView Ls = (ListView) findViewById(R.id.Listme);
        CustomAdapter cs = new CustomAdapter();
        Ls.setAdapter(cs);
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
}
