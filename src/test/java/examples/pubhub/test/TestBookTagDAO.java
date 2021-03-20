package examples.pubhub.test;

import examples.pubhub.dao.*;
import examples.pubhub.model.*;

import java.util.List;

public class TestBookTagDAO {

	public static void main(String[] args) {
		BookTagDAO dao = new BookTagDAOImpl();
		
		List<Book> books = dao.getBooksByTag("fantasy");
		List<BookTag> tags = dao.getAllTagsOnBook("1111111111111");
		
		System.out.println("--- First Test ---");
		
		for (Book b : books)
			System.out.println(b);
		for (BookTag t : tags)
			System.out.println(t);
		
		if (dao.addTag("1111111111111", "adventure"))
			System.out.println("New Tag Inserted!");
		else
			System.out.println("Tag Insert Failed!");

		if (dao.addTag("1111111111111", "sci-fi"))
			System.out.println("New Tag Inserted!");
		else
			System.out.println("Tag Insert Failed!");
		
		System.out.println();
		
		List<Book> books2 = dao.getBooksByTag("adventure");
		List<Book> books3 = dao.getBooksByTag("sci-fi");
		
		List<BookTag> tags2 = dao.getAllTagsOnBook("1111111111111");
		
		System.out.println("--- Second Test ---");
		for (Book b : books2)
			System.out.println(b);
		for (Book b : books3)
			System.out.println(b);
		for (BookTag t : tags2)
			System.out.println(t);
		
		if (dao.deleteTagByISBN("1111111111111", "sci-fi"))
			System.out.println("Tag Deleted Successfully!");
		else
			System.out.println("Tag Deletion Failed!");
		
		if (dao.deleteTagByISBN("1111111111111", "adventure"))
			System.out.println("Tag Deleted Successfully!");
		else
			System.out.println("Tag Deletion Failed!");
		
		System.out.println();
		
		books = dao.getBooksByTag("fantasy");
		books2 = dao.getBooksByTag("adventure");
		books3 = dao.getBooksByTag("sci-fi");
		
		tags = dao.getAllTagsOnBook("1111111111111");
		
		System.out.println("--- Final Test ---");
		for (Book b : books)
			System.out.println(b);
		for (Book b : books2)
			System.out.println(b);
		for (Book b : books3)
			System.out.println(b);
		for (BookTag t : tags)
			System.out.println(t);
	}

}
