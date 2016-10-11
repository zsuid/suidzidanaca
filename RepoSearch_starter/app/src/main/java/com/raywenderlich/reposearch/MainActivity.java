/*
 * Copyright (c) 2016 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.reposearch;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements DownloadCompleteListener {

  ListFragment mListFragment;
  ProgressDialog mProgressDialog;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    if (findViewById(R.id.fragment_container) != null) {
      if (savedInstanceState != null) {
        return;
      }
      if (isNetworkConnected()) {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

        startDownload();
      } else {
        new AlertDialog.Builder(this)
                .setTitle("No Internet Connection")
                .setMessage("It looks like your internet connection is off. Please turn it " +
                        "on and try again")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                  public void onClick(DialogInterface dialog, int which) {
                  }
                }).setIcon(android.R.drawable.ic_dialog_alert).show();
      }

    }
  }

  private void showListFragment(ArrayList<Repository> repositories) {
    mListFragment = ListFragment.newInstance(repositories);
    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mListFragment).
        commit();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    return id == R.id.action_settings || super.onOptionsItemSelected(item);

  }

  private void startDownload() {
    makeRetrofitCalls();




  }
  private boolean isNetworkConnected() {
    ConnectivityManager connMgr = (ConnectivityManager)
            getSystemService(Context.CONNECTIVITY_SERVICE); // 1
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo(); // 2
    return networkInfo != null && networkInfo.isConnected(); // 3
  }

  private boolean isWifiConnected() {
    ConnectivityManager connMgr = (ConnectivityManager)
            getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    return networkInfo != null && (ConnectivityManager.TYPE_WIFI == networkInfo.getType()) && networkInfo.isConnected();
  }

  @Override
  public void downloadComplete(ArrayList<Repository> repositories) {

    showListFragment(repositories);
    if (mProgressDialog != null) {
      mProgressDialog.hide();
    }


  }

  private void makeRequestWithOkHttp(String url) {
    OkHttpClient client = new OkHttpClient();   // 1
    okhttp3.Request request = new okhttp3.Request.Builder().url(url).build();  // 2

    client.newCall(request).enqueue(new okhttp3.Callback() { // 3
      @Override
      public void onFailure(okhttp3.Call call, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(okhttp3.Call call, okhttp3.Response response)
              throws IOException {
        final String result = response.body().string();  // 4

        MainActivity.this.runOnUiThread(new Runnable() {
          @Override
          public void run() {
            try {
              downloadComplete(Util.retrieveRepositoriesFromResponse(result));  // 5
            } catch (JSONException e) {
              e.printStackTrace();
            }
          }
        });
      }
    });
  }


  private void makeRequestWithVolley(String url) {

    RequestQueue queue = Volley.newRequestQueue(this); // 1

    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new com.android.volley.Response.Listener<String>() { // 2
              @Override
              public void onResponse(String response) {
                try {
                  downloadComplete(Util.retrieveRepositoriesFromResponse(response)); // 3
                } catch (JSONException e) {
                  e.printStackTrace();
                }
              }
            }, new com.android.volley.Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
      }
    });
    queue.add(stringRequest);  // 4

  }
  private void makeRetrofitCalls() {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com") // 1
            .addConverterFactory(GsonConverterFactory.create()) // 2
            .build();

    RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class); // 3

    Call<ArrayList<Repository>> call = retrofitAPI.retrieveRepositories(); // 4

    call.enqueue(new Callback<ArrayList<Repository>>() {  // 5
      @Override
      public void onResponse(Call<ArrayList<Repository>> call,
                             Response<ArrayList<Repository>> response) {
        downloadComplete(response.body());  // 6
      }

      @Override
      public void onFailure(Call<ArrayList<Repository>> call, Throwable t) {
        Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }


}
