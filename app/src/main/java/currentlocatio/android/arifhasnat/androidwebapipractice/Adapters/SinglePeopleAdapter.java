package currentlocatio.android.arifhasnat.androidwebapipractice.Adapters;
import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import currentlocatio.android.arifhasnat.androidwebapipractice.Models.SinglePeopleModel;
import currentlocatio.android.arifhasnat.androidwebapipractice.R;

/**
 * Created by Arif hasnat on 5/28/2016.
 */
public class SinglePeopleAdapter extends RecyclerView.Adapter<SinglePeopleAdapter.SinglePeopleHolder>{



    Context context;

    public ArrayList<SinglePeopleModel> singlePeopleModels;

    public SinglePeopleAdapter(ArrayList<SinglePeopleModel> singlePeopleModels) {
        this.singlePeopleModels = singlePeopleModels;
    }

    @Override
    public SinglePeopleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleperson, null);
        SinglePeopleHolder viewData = new SinglePeopleHolder(itemLayoutView);
        return viewData;

    }

    @Override
    public void onBindViewHolder(SinglePeopleHolder holder, int position) {

        SinglePeopleModel singlePeopleModel=singlePeopleModels.get(position);

        holder.name.setText(singlePeopleModel.name);
        holder.height.setText(singlePeopleModel.height);
        holder.mass.setText(singlePeopleModel.mass);
        holder.hairColor.setText(singlePeopleModel.hairColor);
        holder.eyeColor.setText(singlePeopleModel.eyeColor);
/*
        holder.birthyear.setText(singlePeopleModel.birthYear);
        holder.gendar.setText(singlePeopleModel.gender);
        holder.homeworld.setText(singlePeopleModel.homeWorld);
        holder.created.setText(singlePeopleModel.createdAt);
        holder.edited.setText(singlePeopleModel.edited);

        String film;

        for (int i = 0; i <singlePeopleModel.films.size() ; i++) {

            film=singlePeopleModel.films.get(i);
        }
        //holder.films.setText(film);
       // holder.url.setImageResource(singlePeopleModel.url.);
        Picasso.with(context)
                .load(singlePeopleModel.url)
                .resize(50, 50)
                .centerCrop()
                .into(holder.url);
*/



    }

    @Override
    public int getItemCount() {
        return singlePeopleModels.size();
    }

    public class SinglePeopleHolder extends RecyclerView.ViewHolder {


        TextView name,height,mass,hairColor,eyeColor,birthyear,gendar,homeworld,created,edited,films;
        public ImageView url;
        public SinglePeopleHolder(View itemView) {
            super(itemView);

            name= (TextView) itemView.findViewById(R.id.textViewName);
            height= (TextView) itemView.findViewById(R.id.textView2);
            mass= (TextView) itemView.findViewById(R.id.textView3);
            hairColor= (TextView) itemView.findViewById(R.id.textView4);
            eyeColor= (TextView) itemView.findViewById(R.id.textView5);
        /*    birthyear= (TextView) itemView.findViewById(R.id.textView6);
            gendar= (TextView) itemView.findViewById(R.id.textView7);
            homeworld= (TextView) itemView.findViewById(R.id.textView8);
            created= (TextView) itemView.findViewById(R.id.textView9);
            edited= (TextView) itemView.findViewById(R.id.textView10);
            films= (TextView) itemView.findViewById(R.id.textView13);
            url= (ImageView) itemView.findViewById(R.id.imageView);*/






        }
    }
}
