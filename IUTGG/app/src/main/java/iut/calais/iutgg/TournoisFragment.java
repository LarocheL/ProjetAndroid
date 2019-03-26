package iut.calais.iutgg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Belal on 1/23/2018.
 */

public class TournoisFragment extends Fragment {
    private TextView mTextViewResult;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        View inflate = inflater.inflate(R.layout.fragment_equipes, null);

        mTextViewResult = inflate.findViewById(R.id.text_view_result);
        OkHttpClient client = new OkHttpClient();

        String url ="https://api.pandascore.co/lol/tournaments?token=npTnZJLyI_0lSzj8EkbM_tBIYmR6wp36IKyTSe1yfAuP5uPmTrA";

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

                    TournoisFragment.this.getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myresponse);
                        }
                    });
                }
            }
        });

        return inflate;
    }
}