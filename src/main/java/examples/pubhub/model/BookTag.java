package examples.pubhub.model;

public class BookTag {
	
	private String isbn13;
	private String tag_name;
	
	// constructor for specifying tag name and the target book
	public BookTag(String isbn13, String tag_name) {
		this.isbn13 = isbn13;
		this.tag_name = tag_name;
	}
	
	// default constructor
	public BookTag() {
		this(null, null);
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	
	@Override
	public String toString() {
		return "\nBookID: " + isbn13 + "\nTag Name: " + tag_name + "\n";
	}
		
}
