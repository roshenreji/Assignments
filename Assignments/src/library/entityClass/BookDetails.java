package library.entityClass;

public class BookDetails {

	private int id;
	private String name;
	private String authorName;
	private byte quantity;
	private String genre;
	
	
	public BookDetails(int id,String name,String authorName,byte quantity,String genre) {
		this.id=id;
		this.name=name;
		this.authorName=authorName;
		this.quantity=quantity;
		this.genre=genre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public byte getQuantity() {
		return quantity;
	}


	public void setQuantity(byte quantity) {
		this.quantity = quantity;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
