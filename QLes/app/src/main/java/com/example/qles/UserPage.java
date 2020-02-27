package com.example.qles;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserPage extends AppCompatActivity{

    ListView listView;
   

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);

        listView = (ListView) findViewById(R.id.listView);
        downloadJSON("http://10.0.2.2:8080/qles-api/mysql_connect_leerling.php");
    }

    private void downloadJSON(final String urlWebService) {

        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
               super.onPreExecute();
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                try {
                    loadIntoListView(s);
                }   catch (JSONException e) {
                    e.printStackTrace();
                }
                }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                    } catch (Exception e) {
                            return null;
                        }
                    }
                }
             DownloadJSON getJSON = new DownloadJSON();
             getJSON.execute();
        }

        private void loadIntoListView(String json) throws JSONException {
            JSONArray jsonArray;
            jsonArray = new JSONArray(json);
            String[] stocks = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            stocks[i] = obj.getString("vak") + " -> " + obj.getString("begindatum") + " / " + obj.getString("einddatum")+ " van " + obj.getString("aantal kwartieren") + " kwartier(en).";
            
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stocks);
        listView.setAdapter(arrayAdapter);
    }
}

