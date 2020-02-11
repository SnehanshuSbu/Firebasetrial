package com.hfad.dojotrial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("never before offers");

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("data");

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<model, ViewHolder> firebaseRecyclerAdepter =
                new FirebaseRecyclerAdapter<model, ViewHolder>(
                        model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, model mode, int position) {


                        ViewHolder.setDetails(getApplicationContext(), mode.getTitle(), mode.getImage(), mode.getDescription());
                    }

                };
        mRecyclerView.setAdapter(firebaseRecyclerAdepter);
    }
}
