
public class BookNode {
	int ISBNno;
	String BookName;
	String AuthorName;
	BookNode next;
	
	BookNode(int ISBNno, String BookName, String AuthorName) {
		this.AuthorName = AuthorName;
		this.BookName = BookName;
		this.ISBNno = ISBNno;
		next = null;
	}
}
