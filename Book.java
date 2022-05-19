//Library Management System
//Linked List
import java.util.*;
public class Book {
	static Scanner scan = new Scanner(System.in);
	static BookNode head;
	int count = 0;
	//function to add book 
	public int addBook(int ISBN, String BName, String AuthorName) { 
		BookNode current = head;
		for(int i = 0; i < count - 1; i++) {
			current = current.next;
		}
		if(count == 0) {
			head = new BookNode(ISBN, BName, AuthorName);
			count++;
		} else {
			current.next = new BookNode(ISBN, BName, AuthorName);
			count++;
		}
		return count;
	}
	//function to search a book
	public boolean search(int ISBN) {
		boolean flag = false;
		BookNode current = head;
		while(current != null) {
			if(current.ISBNno == ISBN) {
				flag = true;
				break;
			} else {
				flag = false;
			}
			current = current.next;
		}
		return flag;
	}
	//function to delete a book
	public void deleteBook(int ISBN, Book book) {
		BookNode previous = head;
		int position = 1;
		while(previous.ISBNno != ISBN) {
			position++;
			previous = previous.next;
		}
		if (position == 1) {
			head = head.next;
		} else {
			count = 1;
			BookNode pointer = head;
			while(count < position - 1) {
				pointer = pointer.next;
				count++;
			}
			BookNode current = pointer.next;
			pointer.next = current.next;
		}
		
	}
	
	public void displayBooks() {
		BookNode current = head;
		System.out.println("ISBN No. \tBook Name \tAuthor Name");
		while(current!= null) {
			System.out.println(current.ISBNno + "\t\t" + current.BookName + "\t\t" + current.AuthorName);
			current = current.next;
		}
	}
	
	public void display(int ISBN) {
		BookNode current = head;
		while(current.next != null) {
			if(current.ISBNno == ISBN) {
				System.out.println("ISBN No.:" + current.ISBNno);
				System.out.println("Book Name: " + current.BookName);
				System.out.println("Author Name: " + current.AuthorName);
			} else {
				System.out.println("Book Not Found!");
			}
			current = current.next;
		}
	}
	
	public int displayNoOfBooks(Book book) {
		BookNode pointer = head;
		int count = 0;
		while(pointer != null) {
			count++;
			pointer = pointer.next;
		}
		System.out.println("No. of books: " + count);
		return count;
	}
	
	public static void main(String[] args) {
		int ch;
		Book book = new Book();
		do {
			System.out.println("~~~~~~~WELCOME TO READERS LIBRARY~~~~~~~ \n1. Add a new Book \n2. Delete a new Book"
					+ "\n3. Search for a book in records \n4. Display details of a book"
					+ "\n5. Display book records"
					+ "\n6. Display no. of books in the record");
			ch = scan.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Add a new Book");
				System.out.println("Enter the ISBN No.");
				int ISBN = scan.nextInt();
				System.out.println("Enter the Book Name: ");
				String bname = scan.next();
				System.out.println("Enter the author Name: ");
				String aname = scan.next();
				book.addBook(ISBN, bname, aname);
				break;
			case 2:
				System.out.println("Delete a book");
				System.out.println("Enter the ISBN No. of the book to be deleted: ");
				ISBN = scan.nextInt();
				boolean flag = book.search(ISBN);
				if(flag) {
					book.deleteBook(ISBN, book);
				} else {
					System.out.println("Book Not Found!");
				}
				book.displayBooks();
				break;
			case 3:
				System.out.println("Search for a book in the records");
				System.out.println("Enter ISBN no. for a book in the records");
				ISBN = scan.nextInt();
				boolean flag1 = book.search(ISBN);
				if(flag1) {
					System.out.println("Book Found!");
					book.display(ISBN);
				} else {
					System.out.println("Book Not Found!");
				}
				break;
			case 4:
				System.out.println("Display details of book");
				System.out.println("Enter the ISBN No. of Book: ");
				ISBN = scan.nextInt();
				boolean check = book.search(ISBN);
				if(check) {
					book.display(ISBN);
				} else {			
					System.out.println("Book Not Found!");
				}
				break;
			case 5:
				book.displayBooks();
				break;
			case 6:
				book.displayNoOfBooks(book);
				break;
				default:
					System.out.println("Invalid Choice: ");
			}
			System.out.println("Do you wish to continue: 0. Exit 1. Continue");
			ch = scan.nextInt();
		} while(ch != 0);
		
	}
	
}

