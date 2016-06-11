package currentlocatio.android.arifhasnat.androidwebapipractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import currentlocatio.android.arifhasnat.androidwebapipractice.Adapters.SinglePeopleAdapter;
import currentlocatio.android.arifhasnat.androidwebapipractice.Library.VolleySingleton;
import currentlocatio.android.arifhasnat.androidwebapipractice.Models.SinglePeopleModel;

public class MainActivity extends AppCompatActivity {

    public ArrayList<SinglePeopleModel>  singleModels;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        mRecyclerView = (RecyclerView) findViewById(R.id.recyle);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)




        singleModels =new ArrayList<>();

        loadData();


    }

    public void loadData(){
        String url= "http://swapi.co/api/people/3/";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET,url, (String)null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        SinglePeopleModel singelePeopleModel =new SinglePeopleModel();
                        try {
                            singelePeopleModel.name=response.getString("name");
                            singelePeopleModel.height=response.getString("height");
                            singelePeopleModel.mass=response.getString("mass");
                            singelePeopleModel.hairColor=response.getString("hair_color");
                            singelePeopleModel.eyeColor=response.getString("eye_color");
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),"sdhgf",Toast.LENGTH_LONG).show();
                        }
                        singleModels.add(singelePeopleModel);

                        mAdapter = new SinglePeopleAdapter(singleModels);
                        mRecyclerView.setAdapter(mAdapter);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });


        VolleySingleton.getInstance(this).addToRequestQueue(jsObjRequest);




    }



}
