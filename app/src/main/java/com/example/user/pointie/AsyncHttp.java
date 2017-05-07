package com.example.user.pointie;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 7/5/2017.
 */

public class AsyncHttp extends AsyncTask<Void, Void,  ArrayList<String> >
{
    String url;
    ArrayList<String> arraylistitem;
    public AsyncHttp()
    {
        arraylistitem = new ArrayList<String>();
        if(url=="") this.url= new String();
        else this.url = url;
    }


    @Override
    protected   ArrayList<String>  doInBackground(Void ...params)
    {
        String[]  images = {" ", " "};;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("https://gitlab.com/snippets/1661382/raw");
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader rd = null;
        try {
            rd = new BufferedReader
                    (new InputStreamReader(
                            response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String lines = new String();
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = rd.readLine()) != null) {
                    stringBuilder.append(line);
             //   textView.append(line);
            }
            lines = stringBuilder.toString();
            Log.v("Json", lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            JavaType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, ImagePojo.class);

            images=  mapper.readValue(lines, String[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
       if (images==null)
        arraylistitem = new ArrayList<String>( Arrays.asList(images));
        ArrayList<String> s = new ArrayList<String>();
        s.add(lines);
        return s;
       // return arraylistitem;

    }
    @Override
    protected void onPostExecute( ArrayList<String> array) {
        super.onPostExecute(array);
        onResponse(array);
    }
    public void onResponse(ArrayList<String> array) {

    }


}
