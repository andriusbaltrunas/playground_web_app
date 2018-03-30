import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andriusbaltrunas on 3/30/2018.
 */

@WebServlet(value = "/myFirstServlet")
public class MyFirstServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = "Andrius";
        String surname = "Baltrunas";

        req.setAttribute("name", name);
        req.setAttribute("surname", surname);

        req.getRequestDispatcher("myFirstJsp.jsp").forward(req, resp);
    }

}
