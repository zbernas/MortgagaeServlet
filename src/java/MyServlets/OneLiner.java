/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlets;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Random;

public class OneLiner extends HttpServlet {
    private String[] OneLiner = new String[59];
    private int LineItem;
    
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        this.LineItem = -1;
        response.setContentType("text/html");

        String filename = "/WEB-INF/OneLiner.txt";

        ServletContext context = getServletContext();

        InputStream is = context.getResourceAsStream(filename);
        if (is != null) {
            InputStreamReader streamread = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(streamread);
            PrintWriter out = response.getWriter();
            String text;

            while ((text = reader.readLine()) != null) {
                //writer.println(text + "</br>");
                String newLine  = text;
                this.LineItem++;
                this.OneLiner[LineItem] = newLine;
            }
            //this.OneLiner = new String[OneLinerLength];
            //writer.println(OneLiner[1] + "</br>");
            //writer.println(OneLiner.length);
            Random rand = new Random();
            int r = rand.nextInt(59)+0;
            
            out.println(OneLiner[r]);
            out.println("<br><br>click <a href = \"OneLiner\">Next</a> for new one liner");
            
        }
        
    }
}