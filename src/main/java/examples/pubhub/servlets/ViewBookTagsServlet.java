package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookTagDAO;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;

public class ViewBookTagsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7532122720397290039L;
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn13 = request.getParameter("isbn13");
		
		BookTagDAO dao = DAOUtilities.getBookTagDAO();
		List<BookTag> tags = dao.getAllTagsOnBook(isbn13);
		
		request.setAttribute("tags", tags);
		
		request.getRequestDispatcher("bookTags.jsp").forward(request, response);
	}
}
