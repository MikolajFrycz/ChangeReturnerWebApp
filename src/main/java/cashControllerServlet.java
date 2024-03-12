/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

//import Entities.HistoryRecord;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Frycz.Mikolaj.Cw4.prototyp.Controllers.ArgumentController;
import Frycz.Mikolaj.Cw4.prototyp.Controllers.CashController;
import Frycz.Mikolaj.Cw4.prototyp.Exceptions.CustomException;
import Frycz.Mikolaj.Cw4.prototyp.Models.Cash;
import Frycz.Mikolaj.Cw4.prototyp.Views.CashView;
import Repository.historyRepo;
import static Repository.historyRepo.addOperation;
import Repository.parametersRepo;
import Repository.solutionRepo;
import jakarta.servlet.http.Cookie;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 */
@WebServlet(urlPatterns = {"/cash"})
public class cashControllerServlet extends HttpServlet {

    CashView view = new CashView();
    Cash cash = new Cash();        
    CashController cashController = new CashController();
    Boolean canGenerateOperation = true;

    
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
        
        //Refresh values everytime user goes to the main page
        view = new CashView();
        cash = new Cash();
        cashController = new CashController();
        canGenerateOperation = true;    
        Cookie[] cookies = request.getCookies();
        
        response.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        parametersRepo.createTable();
        solutionRepo.createTable();

        // Get parameter values - denominations and change
        String denominations = request.getParameter("denominations");
        String change = request.getParameter("change");
              
        // FirstName or change was not given - send error message
        if (denominations.length() == 0 || change.length() == 0) {
            response.sendError(response.SC_BAD_REQUEST, "You should give two parameters!");
        } else {
                    
        String[] strArray = denominations.split(" ");
        ArgumentController<String> argController = new ArgumentController<String>(List.of(strArray), change);
        try {
            cash.setCoinValues(argController.checkCoins());
            cash.setChange(argController.checkChange());
        } catch (CustomException e) {
            if (cash.getCoinValues() == null) {
                response.sendError(response.SC_BAD_REQUEST, "Wrong parameters entered! - coinValues are null");
                addOperation("Operation ended with an error (null coinValues)");
                canGenerateOperation = false;
            }
            
            else if (cash.getCoinValues().isEmpty()) {
                response.sendError(response.SC_BAD_REQUEST, "Wrong parameters entered! - coinValues is empty");
                addOperation("Operation ended with an error (empty coinValues)");
                canGenerateOperation = false;
            }
            else if (cash.getChange() == 0.0) {
                response.sendError(response.SC_BAD_REQUEST, "Wrong parameters entered! - could not transfer given parameter to change");
                addOperation("Operation ended with an error (Change in wrong format)");
                canGenerateOperation = false;
            }
        }
        
        try {
            cashController.findSolution(cash);
        } catch (CustomException e) {   
            response.sendError(response.SC_BAD_REQUEST, "Could not calculate change from given parameters!");
            canGenerateOperation = false;
        }       
        
        

        
        view.PrintStringResult(out, cash.getSolutionAsString());
        }
        System.out.println(canGenerateOperation);
        if(canGenerateOperation == true) {
            addOperation("Denominations: "+ denominations + ", Change: "+change+", Solution: "+cash.getSolutionAsString());
            
            solutionRepo.insertData(cash);
            parametersRepo.insertData(cash, solutionRepo.findAll().size());
            //HistoryRecord tempRecord = new HistoryRecord();
            //tempRecord.setDenominations(denominations);
            //tempRecord.setChange(cash.getChange());
            //tempRecord.setSolution(cash.getSolutionAsString());
            //historyRepo historyRep = new historyRepo();
            //historyRep.persistObject(tempRecord);
            // Get the current date
            
        }
        
        Date currentDate = new Date();

        // Format the date as desired
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);

        // Create a cookie to store the formatted date
        Cookie dateCookie = new Cookie("currentDate", formattedDate);

        // Add the cookie to the response
        response.addCookie(dateCookie);
        
        out.println("");    
        out.println("Data read from cookies:");    
        out.println("Date of last calculation - " + formattedDate);
        
        
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
