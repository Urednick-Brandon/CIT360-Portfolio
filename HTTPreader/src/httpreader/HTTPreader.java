/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpreader;

/**
 *
 * @author Brandon Urednick
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
 

public class HTTPreader
{
  public static void main(String[] args)
  throws Exception
  {
    new HTTPreader();
  }
   
  public HTTPreader()
  {
    try
    {
      String myUrl = "http://www.android.com/";
      //String myUrl = "http://www.uweystcg.com";
      // if your url can contain weird characters you will want to 
      // encode it here, something like this:
      // myUrl = URLEncoder.encode(myUrl, "UTF-8");
 
      String results = doHttpUrlConnectionAction(myUrl);
      System.out.println(results);
    }
    catch (Exception e)
    {
      // deal with the exception in your "controller"
    }
  }
   
  private String doHttpUrlConnectionAction(String desiredUrl)
  throws Exception
  {
    URL url = null;
    BufferedReader reader = null;
    StringBuilder stringBuilder;
 
    try
    {
      // create the HttpURLConnection
      url = new URL(desiredUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       
      
      connection.setRequestMethod("GET");
      
      
      connection.setReadTimeout(15*1000);
      connection.connect();
 
      // read the output from the server
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      stringBuilder = new StringBuilder();
 
      String line = null;
      while ((line = reader.readLine()) != null)
      {
        stringBuilder.append(line + "\n");
      }
      return stringBuilder.toString();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
    finally
    {
        
      if (reader != null)
      {
        try
        {
          reader.close();
        }
        catch (IOException ioe)
        {
          ioe.printStackTrace();
        }
      }
    }
  }
}