package bd.com.hasnat.heteregenousrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bd.com.hasnat.heteregenousrecyclerview.Adapter.ItemAdapter;
import bd.com.hasnat.heteregenousrecyclerview.Model.Advertise;
import bd.com.hasnat.heteregenousrecyclerview.Model.Movie;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private List<Object> objectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemAdapter adapter = new ItemAdapter(objectList);
        generateList();

        recyclerView = findViewById(R.id.list);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void generateList() {
        objectList.add(new Advertise(R.drawable.ad_logo));
        objectList.add(new Movie(R.drawable.three_idiots, "3 Idiots", "Drama/Bollywood"));
        objectList.add(new Movie(R.drawable.life_of_pi, "Life of Pi", "Drama/Fantasy"));
        objectList.add(new Movie(R.drawable.b_h_s, "Big Hero 6", "Drama/Bollywood"));
        objectList.add(new Advertise(R.drawable.ad_logo));
        objectList.add(new Movie(R.drawable.three_idiots, "3 Idiots", "Drama/Bollywood"));
        objectList.add(new Movie(R.drawable.life_of_pi, "Life of Pi", "Drama/Fantasy"));
        objectList.add(new Movie(R.drawable.b_h_s, "Big Hero 6", "Drama/Bollywood"));
        objectList.add(new Advertise(R.drawable.ad_logo));
    }
}
