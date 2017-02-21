package com.example.administrator.recylerviewtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.administrator.recylerviewtest.R.id.dogImg;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Dog> dogList;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViews();
    }

    private void initData() {
        dogList=new ArrayList<Dog>();
        dogList.add(new Dog("dog1eeeeeeeeeeeeeeeeeeeeeeeeeed", R.drawable.dog1));
        dogList.add(new Dog("dog2", R.drawable.dog2));
        dogList.add(new Dog("dog3ddddddddddddddd", R.drawable.dog3));
        dogList.add(new Dog("dog4", R.drawable.dog4));
        dogList.add(new Dog("dogfsdggrgrrrrrrrrrrrrrrrrrre", R.drawable.dog5));
        dogList.add(new Dog("dog6", R.drawable.dog6));
        dogList.add(new Dog("dog7", R.drawable.dog7));
        dogList.add(new Dog("dog8", R.drawable.dog8));
        dogList.add(new Dog("dog9", R.drawable.dog9));
        dogList.add(new Dog("dog10", R.drawable.dog10));
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
       // LinearLayoutManager manager=new LinearLayoutManager(this);
        //manager.setOrientation(LinearLayoutManager.HORIZONTAL);
      //  GridLayoutManager manager=new GridLayoutManager(this,3);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(new MyAdapter(this, dogList));

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private  final Context context;
        private ArrayList<Dog> dogList;
        public MyAdapter(Context context,ArrayList<Dog> dogList){
            this.context=context;
            this.dogList=dogList;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
                int img=dogList.get(position).getDogImg();
                String name=dogList.get(position).getName();
                holder.dogImag.setImageResource(img);
                holder.dogName.setText(name);
        }

        @Override
        public int getItemCount() {
            return dogList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView dogImag;
            TextView dogName;
            public MyViewHolder(View itemView) {
                super(itemView);
                dogImag= (ImageView) itemView.findViewById(dogImg);
                dogName = (TextView) itemView.findViewById(R.id.dogName);
            }
        }
    }
}
