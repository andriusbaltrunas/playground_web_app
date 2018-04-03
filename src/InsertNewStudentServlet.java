import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by andriusbaltrunas on 4/3/2018.
 */
@WebServlet(value = "/CreateNewStudent")
public class InsertNewStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("createStudent.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        ConectionToDatabase conectionToDatabase = new ConectionToDatabase();
        Connection connection = conectionToDatabase.getConnection();
        if (connection != null) {
            try {
                Statement st = connection.createStatement();
                st.execute("INSERT INTO students(name,surname,phone,email)" +
                        "VALUES('" + name + "','" + surname + "','" + phone + "','" + email + "')");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        resp.sendRedirect("/");
    }


}
