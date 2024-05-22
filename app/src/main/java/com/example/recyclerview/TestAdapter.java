package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {
    private String[] name = {};
    private int[] avatar = {};



    public TestAdapter(TempListItem tempListItem){
        name = tempListItem.getName();
        avatar = tempListItem.getAvatar();



    }

    @NonNull
    @Override
    // در اینجا سه متود وجود دارد که ایمپلمنت میکنه برامون متود اول از هولدر نسخه میسازه
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview , parent , false);
        return new TestAdapter.TestViewHolder(view);
    }
//بعد از اینکه متود بالا دیتا هارو ساخت این متود میاد دیتا هارو ست میکنه
    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        holder.setItems(name[position],avatar[position]);   // پوزیشن اینجا اشاره می کنه به خونه ای که داره می سازه پس دسترسی داره به عدد اون ارایه

    }
//
    @Override
    public int getItemCount() {
        return name.length; ////  یعنی تعداد اسامی مون بشه اندازه اری مون اری هم توی تمپ لیست آیتم
    }

// این قسمت یک نمونه هستش و نگه دارنده ویو ما هست ، که هرزمان که خواستم از روش بسازه و دیتا درونش بریزه

    public class TestViewHolder extends RecyclerView.ViewHolder{
        public TextView txt1;
        public ImageView humen1;
        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt_1);
            humen1 = itemView.findViewById(R.id.humen_1);
        }
        public void setItems(String testString, int id) {
             txt1.setText(testString);
             humen1.setImageResource(id);

        }
    }
}
