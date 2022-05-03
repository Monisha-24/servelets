package ServletPrograms;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "WeatherReport", urlPatterns = {"/WeatherReport"})
public class WeatherServlet extends HttpServlet {
 HashMap<String,Weather> map=new HashMap<>();
 HashMap<String,String> imgMap=new HashMap<>();
 Weather weather;
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
 try (PrintWriter out = response.getWriter()) {
 /* TODO output your page here. You may use following sample code. */

 imgMap.put("Highly Sunny","highsunny.jpg");
 imgMap.put("Sunny","sunny.jpg");
 imgMap.put("Partially Cloudy","parCloudy.jpg");
 imgMap.put("Cloudy","cloudy.jpg");
 imgMap.put("Icy","icy.jpg");
 imgMap.put("Windy","windy.jpg");
 imgMap.put("Rainy","rainy.png");

 weather=new Weather("Madurai","36\u00B0C","32\u00B0C","Sunny");
 map.put("Madurai",weather);

 weather=new Weather("Chennai","39\u00B0C","36\u00B0C","Sunny");
 map.put("Chennai",weather);

 weather=new Weather("Trichy","35\u00B0C","31\u00B0C","Partially Cloudy");
 map.put("Trichy",weather);

 weather=new Weather("Coimbatore","28\u00B0C","24\u00B0C","Icy");
 map.put("Coimbatore",weather);

 weather=new Weather("Salem","40\u00B0C","36\u00B0C","Highly Sunny");
 map.put("Salem",weather);

 weather=new Weather("Vellore","42\u00B0C","38\u00B0C","Highly Sunny");
 map.put("Vellore",weather);

 weather=new Weather("Tanjore","41\u00B0C","35\u00B0C","Cloudy");

 map.put("Tanjore",weather);

 weather=new Weather("Erode","30\u00B0C","28\u00B0C","Rainy");
 map.put("Erode",weather);

 weather=new Weather("Karur","31\u00B0C","29\u00B0C","Windy");
 map.put("Karur",weather);

 weather=new Weather("Tirupur","30\u00B0C","28\u00B0C","Rainy");
 map.put("Tirupur",weather);
 String city=request.getParameter("cityname");



 out.println("<!DOCTYPE html>");
 out.println("<html>");
 out.println("<head>");
 out.println("<title>Servlet WeatherReport</title>");
 out.println("</head>");
 out.println("<body style='background-color:#ccffff;'>");
 if(map.containsKey(city))
 {
 weather=map.get(city);
 out.println("<center><div><h1>Weather Report</h1>");
 out.println("<h2>"+weather.city+"</h2>");
 out.println("<img width='100px' height='100px' style='border:2px groove grey;borderradius:40%;' src='"+imgMap.get(weather.status)+"'/>");
 out.println("<table border=2 width='300px' height='300px' style='cellpadding:2%;text-align:center;background-color:#ffff80;fontsize:large;'><tr><td>Status</td><td>"+weather.status+"</td>");
 out.println("<tr><td>High temperature 🌡</td><td>"+weather.maxTemp+"</td>");
 out.println("<tr><td>Low temperature
🌡</td><td>"+weather.minTemp+"</td></table><br>");
 out.println("</div></center>");
 }
 out.println("</body>");
 out.println("</html>");
 }
 }
}