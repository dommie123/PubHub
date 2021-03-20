package examples.pubhub.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookTagDAO;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;
/**
 * This is the servlet that will be used to tag the books on the website.
 * @author Dominick Wiley
 *
 */
public class TagBookServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3762182116424683967L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String isbn13 = request.getParameter("isbn_13");
		String name = request.getParameter("tag_name");
		
		BookTagDAO dao = DAOUtilities.getBookTagDAO();
		dao.addTag(isbn13, name);
		
		request.getRequestDispatcher("bookPublishingHome.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
