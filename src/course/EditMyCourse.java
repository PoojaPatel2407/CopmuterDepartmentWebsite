package course;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditMyCourse
 */
@WebServlet("/EditMyCourse")
public class EditMyCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMyCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String coursenumber = request.getParameter("coursenumber");
		String courseinfo = request.getParameter("courseinfo");
		
		CourseDAO cd = new CourseDAO();
		
		try {
			if(cd.changeCourseInfo(coursenumber, courseinfo) == 1) {
				response.sendRedirect("ListCourses.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
