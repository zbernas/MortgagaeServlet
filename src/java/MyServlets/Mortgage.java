/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import MyServlets.retInt;
import MyServlets.ArrayBuilder;
//import static MyServlets.retInt.PrincipalArr;
//import static MyServlets.retInt.arr_Length;
import java.util.Arrays;

/**
 *
 * @author zacharybernas
 */
@WebServlet(name = "Mortgage", urlPatterns = {"/Mortgage"})
public class Mortgage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double interest = Integer.parseInt(request.getParameter("interest"));
        double principal = Integer.parseInt(request.getParameter("principal"));
        double monthly = Integer.parseInt(request.getParameter("monthly"));
        int numMonths = Integer.parseInt(request.getParameter("numMonths")) * 12;
        //ArrayBuilder builder = new ArrayBuilder();
        //retInt.getValues(interest, principal, monthly, numYears);
        ArrayBuilder arr = new ArrayBuilder(interest, principal, monthly, numMonths);
        arr.setArray();
        arr.CalcLength();
        arr.makeArray();
        
        //int itWorked = retInt.giveNum(principal, numMonth);
        //int[] myArr = retInt.getArray();
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (interest <= 0 || principal <= 0 || monthly <= 0 || numMonths <= 0){
                
                out.println("You did not enter enough information");
                out.println("click <a href = \"Mortgage.html\"> here</a> to go back");
                
            }
            //out.println("Your interest is " + interest + "<br>");
            //out.println("Your principal is " + principal + "<br>");
            //out.println("Your monthly payment is " + monthly + "<br>");
            //out.println("Your number of months is " + numMonth + "<br>");
            else {
            out.println("<font size = '5'>click <a href = \"Mortgage.html\"> here</a> to go back</font><br>");
            out.println("<h1><i><u>Interest Calculations</h1></u></i>");
            out.println("<h3>Calculating For: <br>");
            out.println("<h3>Interest rate/year: " + interest + " <br>");
            out.println("<h3>Starting Principal: " + principal + " <br>");
            out.println("<h3>Payment/Month: " + monthly + " <br>");
            out.println("<h3>Years: " + numMonths/12 + " <br></h3>");
            //out.println("Array length is " + arr.getArrayLength());
            //out.println("Array Values " + Arrays.toString(retInt.PrincipalArr) + "<br>");
            //out.println("Array Values " + Arrays.toString(retInt.InterestArr));
            //out.println("<font size '3'>if my class worked, prinicpal should be " + itWorked + "</font><br>" + Arrays.toString(myArr));
            //out.println("<font size '3'>if my class worked, prinicpal should be " + itWorked + "</font><br>");
            
            
            out.println("<br><table border = \"1\" >"
                    + "<tr><th>Month Number</th>"
                    + "<th>Principal</th>"
                    + "<th>Interest</th></tr>");
            for(int i= 0; i < arr.getArrayLength()-1; i++){
                 out.println(
                    "<tr><td>" + (i + 1) +  "</td>"
                    + "<td>"+ ArrayBuilder.PrincipalArr[i] +"</td>"
                    + "<td>" + ArrayBuilder.InterestArr[i] + "</td></tr>");
                }
            out.println("</table>");
            }
            out.println("Last Payment = " + ArrayBuilder.PrincipalArr[arr.getArrayLength()-1] + "<br>");
            out.println("This includes interest at = " + ArrayBuilder.InterestArr[arr.getArrayLength()-1]);
            
            
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Mortgage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Mortgage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
