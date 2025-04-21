
public class Book {

	private String title;
	private String author;
	private int numPages;
	private int pubYear;
	private String isbn;
	private double cost;

	public Book(String title, String author, int numPages, int pubYear, String isbn, double cost) {
		super();
		this.title = title;
		this.author = author;
		setNumPages(numPages);
		setPubYear(pubYear);
		setIsbn(isbn);
		setCost(cost);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		if (numPages>0)
			this.numPages = numPages;
		else {
			System.out.println("Invalid number of pages - set to 1");
			this.numPages = 1;
		}
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		
		if(pubYear>0)
			this.pubYear = pubYear;
		else {
			System.out.println("Invalid year - set to 0");
			this.pubYear = 0;
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		if (cost >0)
			this.cost = cost;
		else {
			System.out.println("Invalid cost - set to 0.01");
			cost = 0.01;
		}
	}

	@Override
	public String toString() {
		return "PTP2 [title=" + title + ", author=" + author + ", numPages=" + numPages + ", pubYear=" + pubYear
				+ ", isb=" + isbn + ", cost=" + cost + "]";
	}

}
