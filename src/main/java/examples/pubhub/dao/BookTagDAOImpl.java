package examples.pubhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;

public class BookTagDAOImpl implements BookTagDAO {

	/**
	 *  This class implements the BookTagDAO and is responsible for querying the 
	 *  database for Book_Tag Objects.
	 */
	Connection conn = null;
	PreparedStatement stmt = null;
	
	
	@Override
	public List<Book> getBooksByTag(String tag_name) {
		
		List<Book> books = new ArrayList<Book>();
		
		try {
			conn = DAOUtilities.getConnection();
			String sql = "SELECT * FROM books WHERE isbn_13 = (SELECT isbn_13 FROM book_tags WHERE tag_name = ?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, tag_name);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				
				book.setIsbn13(rs.getString("isbn_13"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setPublishDate(rs.getDate("publish_date").toLocalDate());
				book.setPrice(rs.getDouble("price"));
				book.setContent(rs.getBytes("content"));
				
				books.add(book);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return books;
	}

	@Override
	public List<BookTag> getAllTagsOnBook(String isbn13) {
		List<BookTag> tags = new ArrayList<BookTag>();
		
		try {
			conn = DAOUtilities.getConnection();
			String sql = "SELECT * FROM book_tags WHERE isbn_13 = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, isbn13);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				BookTag tag = new BookTag(rs.getString("isbn_13"), rs.getString("tag_name"));
				
				tags.add(tag);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tags;
	}

	@Override
	public boolean addTag(String isbn13, String tag_name) {
		
		try {
			conn = DAOUtilities.getConnection();
			String sql = "INSERT INTO book_tags VALUES (?, ?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, isbn13);
			stmt.setString(2, tag_name);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteTagByISBN(String isbn13, String tag_name) {
		try {
			conn = DAOUtilities.getConnection();
			String sql = "DELETE FROM book_tags WHERE isbn_13 = ? AND tag_name = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, isbn13);
			stmt.setString(2, tag_name);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
