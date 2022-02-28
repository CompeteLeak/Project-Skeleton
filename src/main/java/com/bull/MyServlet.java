package com.bull;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// Creating Http Servlet by Extending HttpServlet class
public class MyServlet extends HttpServlet 
{    
    private String mymsg;
//    private static final String GET_URL = "https://ssd-api.jpl.nasa.gov/sb_sat.api";
//    https://api.nasa.gov/planetary/apod
//    curl https://api.unsplash.com/photos/random?count=5 █
    private static final String GET_URL = "https://api.unsplash.com/photos/random?count=5";
    private static final String USER_AGENT = "Mozilla/5.0";
    StringBuffer response1 = new StringBuffer();

    public void init() throws ServletException 
    {      
       mymsg = "Http Servlet Demo";   
    }
    public void doGet(HttpServletRequest request, 
        HttpServletResponse response) throws ServletException, 
        IOException 
    {            
        // Setting up the content type of web page      
        response.setContentType("text/html");
        // Writing the message on the web page   
        
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
              con.getInputStream()));
            String inputLine;

            while ((inputLine = in .readLine()) != null) {
              response1.append(inputLine);
            } in .close();

            // print result
            response.toString();
          } else {
            System.out.println("GET request not worked");
          }

        PrintWriter out = response.getWriter();      
        out.println("<h1>" + response1 + "</h1>");      
        out.println("<p>" + "Am I Back Ending yet?!" + "</p>");   
    }
    public void destroy() 
    {      
       // Leaving empty. Use this if you want to perform  
       //something at the end of Servlet life cycle.   
    }
}