package iut.calais.iutgg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Belal on 1/23/2018.
 */

public class MatchFragment extends Fragment {
    ArrayList<Match> match = new ArrayList<Match>();
    // Create the adapter to convert the array to views
    MatchAdapter adapter ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        View inflate = inflater.inflate(R.layout.fragment_matchs, null);

        // Attach the adapter to a ListView
        ListView listView = (ListView) inflate.findViewById(R.id.lvItems);

        adapter= new MatchAdapter(this.getActivity(), match);
        listView.setAdapter(adapter);


        OkHttpClient client = new OkHttpClient();


        String url ="https://api.pandascore.co/lol/matches?token=npTnZJLyI_0lSzj8EkbM_tBIYmR6wp36IKyTSe1yfAuP5uPmTrA";

        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    final String myresponse = response.body().string();

                    MatchFragment.this.getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //gestion du MatchFragment
                            Gson gson = new Gson();
                            Match[] matches1 = gson.fromJson(myresponse, Match[].class);
                            match.clear();
                            match.addAll(Arrays.asList(matches1));
                            adapter.notifyDataSetChanged();

                        }
                    });
                }
            }
        });

        return inflate;
    }
}