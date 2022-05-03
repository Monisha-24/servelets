package ServletPrograms;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "grossPayServlet", urlPatterns = {"/grossPayServlet"})
public class grossPayServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");

 //getting details
 String name=request.getParameter("name");
 String empid=request.getParameter("empid");
 double basicPay=Double.parseDouble(request.getParameter("basicPay"));
 double hra=Double.parseDouble(request.getParameter("hra"));
 double da=basicPay/2;
 double grossPay=basicPay+hra+da;

 try (PrintWriter out = response.getWriter()) {
 /* TODO output your page here. You may use following sample code. */

 out.println("<!DOCTYPE html>");
 out.println("<html>");
 out.println("<head>");
 out.println("<title>Servlet grossPayServlet</title>");
 out.println("</head>");
 out.println("<body style='background-color:#99ccff'>");
 out.println("<center><h2>"+"Employee's Gross Pay Details"+ "</h2>");
 out.println("<table border=2 width='300px' height='400px' style='cell-padding:2%;textalign:center;background-color:white;'><tr><td>Name</td><td>"+name+"</td>");
 out.println("<tr><td>Employee ID</td><td>"+empid+"</td>");
 out.println("<tr><td>Basic Pay</td><td>"+basicPay+"</td>");
 out.println("<tr><td>HRA</td><td>"+hra+"</td>");
 out.println("<tr><td>DA</td><td>"+da+"</td>");
 out.println("<tr><td><b>Gross
Pay</b></td><td><b>"+grossPay+"</b></td></table></center>");
 out.println("</body>");
 out.println("</html>");
 }
 }
}