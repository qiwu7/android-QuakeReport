package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mRequestUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mRequestUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mRequestUrl == null || mRequestUrl.isEmpty()) {
            return null;
        }
        return QueryUtils.fetchEarthquakeData(mRequestUrl);
    }
}
