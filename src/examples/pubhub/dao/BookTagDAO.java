package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.*;


/**
 * The DAO Interface used to handle queries related to book tags.
 * @author Dominick Wiley
 *
 */
public interface BookTagDAO {
	
	public List<Book> getBooksByTag(String tag_name);
	public List<BookTag> getAllTagsOnBook(String isbn13);
	
	public boolean addTag(String isbn13, String tag_name);
	public boolean deleteTagByISBN(String isbn13, String tag_name);
}
