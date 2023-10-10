package com.hacktiv8.covidtrackerapp;

import com.google.gson.annotations.SerializedName;

public class Covid {

    @SerializedName("cases")
    private long totalCases;

    @SerializedName("deaths")
    private long totalDeaths;

    @SerializedName("recovered")
    private long totalRecovered;

    public long getTotalCases() {
        return totalCases;
    }

    public long getTotalDeaths() {
        return totalDeaths;
    }

    public long getTotalRecovered() {
        return totalRecovered;
    }
}
