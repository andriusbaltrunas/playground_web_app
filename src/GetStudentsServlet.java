import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriusbaltrunas on 4/3/2018.
 */
@WebServlet(value = "/")
public class GetStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConectionToDatabase conectionToDatabase = new ConectionToDatabase();
        Connection connection = conectionToDatabase.getConnection();
        List<Student> students = new ArrayList<>();

        if (connection != null) {
            try {
                Statement st = connection.createStatement();
                ResultSet resultSet = st.executeQuery("SELECT * FROM students");
                while (resultSet.next()){
                    Student student = new Student(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("surname"),
                            resultSet.getString("phone"),resultSet.getString("email"));
                    students.add(student);

                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        req.setAttribute("students",students);
        req.getRequestDispatcher("students.jsp").forward(req,resp);

    }
}
