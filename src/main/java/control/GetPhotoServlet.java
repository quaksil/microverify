package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.GetPhoto;
import dbHelpers.SearchQuery;
import model.Photo;

/**
 * Servlet implementation class GetImageServlet
 */

@WebServlet("/view")
public class GetPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public GetPhotoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studentId = Integer.parseInt(request.getParameter("studentId"));
		SearchQuery gp = new SearchQuery();

		try {

			Photo photo = gp.getPhoto(studentId);
			request.setAttribute("photo", photo);

			String page = "/view.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);

		} catch (SQLException ex) {

			throw new ServletException(ex);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
