//Library Management System
//Linked List
import java.util.*;
public class Library {
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
	public void deleteBook(int ISBN, Library book) {
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
	//function to display list of all books
	public void displayBooks(BookNode head) {
		BookNode current = head;
		System.out.println("ISBN No. \tBook Name \tAuthor Name");
		while(current!= null) {
			System.out.println(current.ISBNno + "\t\t" + current.BookName + "\t\t" + current.AuthorName);
			current = current.next;
		}
	}
	//function to display details of a book
	public void display(int ISBN) {
		BookNode current = head;
		while(current.next != null) {
			if(current.ISBNno == ISBN) {
				System.out.println("ISBN No.:" + current.ISBNno);
				System.out.println("Book Name: " + current.BookName);
				System.out.println("Author Name: " + current.AuthorName);
			} 			
			current = current.next;
		}
	}
	//function to display reverse order/list of books
	public BookNode reverse(BookNode head) {
		if(head == null) {
			return head;
		}
		BookNode current = head;
		BookNode previous = null;
		BookNode next = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
		
	}
	//function to display no. of books
	public int displayNoOfBooks(Library book) {
		BookNode pointer = head;
		int count = 0;
		while(pointer != null) {
			count++;
			pointer = pointer.next;
		}
		System.out.println("No. of books: " + count);
		return count;
	}
	//function to display the middle of the list
	public BookNode middleOfList(BookNode book) {
		if(head == null) {
			return null;
		}
		BookNode slowPtr = head;
		BookNode fastPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}
	//function to return nth book from list
	public BookNode nthBookFromEnd(int n) {
		if(head == null) {
			return null;
		}
		if(n <= 0) {
			throw new IllegalArgumentException("Invalid value of n");
		}
		BookNode mainPtr = head;
		BookNode refPtr = head;
		int count = 0; 
		while(count < n) {
			if(refPtr == null) {
				throw new IllegalArgumentException(n + " is > no. of nodes in the list");
			}
			refPtr = refPtr.next;
			count++;
		}
		while(refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}
	//function to remove duplicates from a singly sorted list
	public void removeDuplicates(Library book) {
		if (head == null) {
			return;
		}
		BookNode current = head;
		while(current != null && current.next != null) {
			if(current.ISBNno == current.next.ISBNno) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}
	//function to insert a book in between in sorted singly linked list
	public BookNode insertInSortedList(int ISBN, String bname, String aname) {
		BookNode newNode = new BookNode(ISBN, bname, aname);
		if(head == null) {
			return newNode;
		}
		BookNode current = head;
		BookNode temp = null;
		while(current != null && current.ISBNno < newNode.ISBNno) {
			temp = current;
			current = current.next;
		}
		newNode.next = current;
		temp.next = newNode;
		return head;
		
	}
	//main method
	public static void main(String[] args) {
		int ch;
		Library book = new Library();
		do {
			System.out.println("~~~~~~~WELCOME TO READERS LIBRARY~~~~~~~ \n1. Add a new Book \n2. Delete a new Book"
					+ "\n3. Search for a book in records \n4. Display details of a book"
					+ "\n5. Display book records"
					+ "\n6. Display no. of books in the record"
					+ "\n7. Display the list of books in reverse order"
					+ "\n8. Display middle nodes in the list"
					+ "\n9. Display nth book from end"
					+ "\n10. Remove duplicates from sorted singly linked list"
					+ "\n11. Insert a book in a sorted singly linked list");
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
				book.displayBooks(head);
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
				book.displayBooks(head);
				break;
			case 6:
				book.displayNoOfBooks(book);
				break;
			case 7:
				System.out.println("Reverse order of book list: ");
				BookNode reverseListHead = book.reverse(head);
				book.displayBooks(reverseListHead);
				break;
			case 8:
				System.out.println("Middle node of the singly linked list: ");
//				int length = book.displayNoOfBooks(book);
//				if(length % 2 == 0) {
//					//if length is even 
//					System.out.println("There are 2 middle nodes. They are: ");
//					int n1 = length / 2;
//					int n2 = n1 + 1;
//					book.display(n1);
//					book.display(n2);
//				} else {
//					//if length is odd
//					int n3 = (length / 2) + 1;
//					System.out.println("The middle node is: ");
//					book.display(n3);
//				}
				BookNode current = book.middleOfList(head);
				int isbn = current.ISBNno;
				book.display(isbn);
				break;
			case 9:
				System.out.println("Nth book from end: N = ?");
				int nthfromend = scan.nextInt();
				BookNode bn = book.nthBookFromEnd(nthfromend);
				isbn = bn.ISBNno;
				book.display(isbn);
				break;
			case 10:
				System.out.println("Removing duplicates from sorted singly linked list: ");
				book.removeDuplicates(book);
				current = book.head;
				book.displayBooks(head);
				break;
			case 11:
				System.out.println("Inserting a booknode in a sorted singly linked list");
				System.out.println("Enter the ISBN no. : ");
				ISBN = scan.nextInt();
				System.out.println("Enter the book name: ");
				bname = scan.next();
				System.out.println("Enter the author name: ");
				aname = scan.next();
				book.insertInSortedList(ISBN, bname, aname);
				book.displayBooks(head);
				break;
				default:
					System.out.println("Invalid Choice: ");
			}
			System.out.println("Do you wish to continue: 0. Exit 1. Continue");
			ch = scan.nextInt();
		} while(ch != 0);
		System.out.println("*************");
	}
	
}

