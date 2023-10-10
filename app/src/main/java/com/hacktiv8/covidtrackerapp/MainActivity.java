package com.hacktiv8.covidtrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mtotalCasesTv;
    private TextView mtotalRecoveryTv;
    private TextView mtotalDeathTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtotalCasesTv = findViewById(R.id.totalCasesTv);
        mtotalRecoveryTv = findViewById(R.id.totalRecoveredTv);
        mtotalDeathTv = findViewById(R.id.totalDeathTv);

        getCovidAll();
    }

    private void getCovidAll() {
        Log.d("CovidTrackerApp", "Sedang mengambil data terbaru COVID-19...");
        Call<Covid> callCovid = RetrofitClient.getInstance().getMyApi().getCovidAll();
        callCovid.enqueue(new Callback<Covid>() {
            @Override
            public void onResponse(Call<Covid> call, Response<Covid> response) {
                Log.d("CovidTrackerApp", "Berhasil mengambil data terbaru COVID-19");

                Covid dataCovid = response.body();
                assert dataCovid != null;
                mtotalCasesTv.setText(String.valueOf(dataCovid.getTotalCases()));
                mtotalRecoveryTv.setText(String.valueOf(dataCovid.getTotalRecovered()));
                mtotalDeathTv.setText(String.valueOf(dataCovid.getTotalDeaths()));

                System.out.println("Total Cases: " + dataCovid.getTotalCases());
                System.out.println("Total Recovered: " + dataCovid.getTotalRecovered());
                System.out.println("Total Deaths: " + dataCovid.getTotalDeaths());


            }

            @Override
            public void onFailure(Call<Covid> call, Throwable t) {
                Log.e("CovidTrackerApp", "Gagal mengambil data COVID-19. Coba lagi nanti.: " + t.getMessage());
            }
        });
    }
}
