package control;

import dbHelpers.SearchQuery;
import model.Students;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String queryS = request.getParameter("searchVal");
		StringBuffer utilOutput = new StringBuffer();

		SearchQuery sq = new SearchQuery();

		ArrayList<Students> students = new ArrayList<Students>();
		try {
			students = sq.doSearch(queryS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (students.size() != 0) {

			utilOutput.append("\n <p class='text-success'>Students present in database.</p>");
			request.setAttribute("utilOutput", utilOutput.toString());

		} else {
			utilOutput.append("\n <p class='text-danger'>Student is not present in database.</p>");
			request.setAttribute("utilOutput", utilOutput.toString());

		}

		request.setAttribute("students", students);
		String url = "/searchRead.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
