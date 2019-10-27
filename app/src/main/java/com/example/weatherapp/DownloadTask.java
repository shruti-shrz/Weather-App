package com.example.weatherapp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DownloadTask extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... urls) {
        String myurl ="https://api.myjson.com/bins/xiv0c";
        String result = null;
        URL url;
        HttpURLConnection urlconnection = null;

        try {
            url = new URL(myurl);
            urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setReadTimeout(3000);
            urlconnection.setConnectTimeout(3000);
            urlconnection.setRequestMethod("GET");
            urlconnection.setDoInput(true);
            urlconnection.connect();
            InputStream in = urlconnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder stringBuilder = new StringBuilder();

            String s = bufferedReader.readLine();
            while(s != null){
                stringBuilder.append(s);
                s = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            JSONObject jsonbject;
            jsonbject = new JSONObject(result);
           // String weatherinfo = jsonbject.getString("weather");
            JSONArray weatherData = jsonbject.getJSONArray("list");
            JSONObject day1 = weatherData.getJSONObject(0);
            JSONObject t = day1.getJSONObject("temp");
            Double temperature = Double.parseDouble(t.getString("day"));
            int tempin = (int)(temperature-273.15);
            int maxt = (int)((Double.parseDouble(t.getString("max")))-273.15);
            int mint = (int)((Double.parseDouble(t.getString("min")))-273.15);
            JSONArray t2 = day1.getJSONArray("weather");
            JSONObject t3 = t2.getJSONObject(0);
            String t4 = t3.getString("description");
            String pressure = day1.getString("pressure");
            String humidity = day1.getString("humidity");
            String wind = day1.getString("speed");
           Long sunrise = day1.getLong("sunrise");
            Long sunset = day1.getLong("sunset");
            MainActivity.temp.setText(String.valueOf(tempin));
            MainActivity.maxT.setText("Max "+String.valueOf(maxt)+"°C");
            MainActivity.minT.setText("Min "+String.valueOf(mint)+"°C");
            MainActivity.desc.setText(t4);
            MainActivity.pressure.setText(pressure);
            MainActivity.humid.setText(humidity);
            MainActivity.sunset.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise * 1000)));
            MainActivity.sunrise.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset * 1000)));
            MainActivity.wind.setText(wind);
            JSONObject T2 = weatherData.getJSONObject(1);
            JSONObject T = T2.getJSONObject("temp");
            Double temp = Double.parseDouble(T.getString("day"));
            int tempin2 = (int)(temp-273.15);
            int maxt2 = (int)((Double.parseDouble(T.getString("max")))-273.15);
            int mint2 = (int)((Double.parseDouble(T.getString("min")))-273.15);
            String pressure2 = T2.getString("pressure");
            String humidity2 = T2.getString("humidity");
            Long sunrise2 = T2.getLong("sunrise");
            Long sunset2 = T2.getLong("sunset");
            Day2.temp.setText(String.valueOf(tempin2)+"°C");
           Day2.maxT.setText("Max "+String.valueOf(maxt2)+"°C");
            Day2.minT.setText("Min "+String.valueOf(mint2)+"°C");
            Day2.pressure.setText(pressure2);
            Day2.humid.setText(humidity2);
            Day2.sunset.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise2 * 1000)));
            Day2.sunrise.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset2 * 1000)));
            JSONObject T3 = weatherData.getJSONObject(2);
            JSONObject  U = T3.getJSONObject("temp");
            Double temp2 = Double.parseDouble(U.getString("day"));
            int tempin3 = (int)(temp2-273.15);
            int maxt3 = (int)((Double.parseDouble(U.getString("max")))-273.15);
            int mint3 = (int)((Double.parseDouble(U.getString("min")))-273.15);
            String pressure3 = T3.getString("pressure");
            String humidity3 = T3.getString("humidity");
            Long sunrise3 = T3.getLong("sunrise");
            Long sunset3 = T3.getLong("sunset");
            Day3.temp.setText(String.valueOf(tempin3)+"°C");
            Day3.maxT.setText("Max "+String.valueOf(maxt3)+"°C");
            Day3.minT.setText("Min "+String.valueOf(mint3)+"°C");
            Day3.pressure.setText(pressure3);
            Day3.humid.setText(humidity3);
            Day3.sunset.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise3 * 1000)));
            Day3.sunrise.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset3 * 1000)));

            JSONObject T4 = weatherData.getJSONObject(3);
            JSONObject V = T4.getJSONObject("temp");
            Double temp3 = Double.parseDouble(V.getString("day"));
            int tempin4 = (int)(temp3-273.15);
            int maxt4 = (int)((Double.parseDouble(V.getString("max")))-273.15);
            int mint4 = (int)((Double.parseDouble(V.getString("min")))-273.15);
            String pressure4 = T4.getString("pressure");
            String humidity4 = T4.getString("humidity");
            Long sunrise4 = T4.getLong("sunrise");
            Long sunset4 = T4.getLong("sunset");
            Day4.temp.setText(String.valueOf(tempin4)+"°C");
            Day4.maxT.setText("Max "+String.valueOf(maxt4)+"°C");
            Day4.minT.setText("Min "+String.valueOf(mint4)+"°C");
            Day4.pressure.setText(pressure4);
            Day4.humid.setText(humidity4);
            Day4.sunset.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise4 * 1000)));
            Day4.sunrise.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset4 * 1000)));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
