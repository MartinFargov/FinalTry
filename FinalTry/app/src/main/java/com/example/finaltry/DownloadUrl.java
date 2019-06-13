package com.example.finaltry;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//retreive data from url using http url connection
public class DownloadUrl {

    public String readUrl(String myUrl) throws IOException {

        String data = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;
        try {

            URL url = new URL(myUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            //reading data from the url
            inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();

            //read each line 1 by 1 using while
            String line = "";
            while ((line = bufferedReader.readLine())!=null){

                stringBuffer.append(line);

            }

            data = stringBuffer.toString();
            bufferedReader.close();

        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            inputStream.close();
            urlConnection.disconnect();

        }

        return data;
    }
}
