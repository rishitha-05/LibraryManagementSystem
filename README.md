# LibraryManagementSystem

A simple **console-based Library Management System** implemented in Java.  
This project allows you to manage books in a library with basic operations like adding, removing, searching, issuing, and returning books.

---

## Features

- **Add Book** – Add a new book with title and author. Each book gets a unique ID automatically.  
- **Remove Book** – Remove a book using its unique ID.  
- **Search Book** – Search for books by keyword in title or author.  
- **Display All Books** – List all books with their current status (Available/Issued).  
- **Issue Book** – Issue a book using its ID.  
- **Return Book** – Return an issued book using its ID.  

---

## Technologies Used

- Java (JDK 8+)
- Console-based application
- Collections (`ArrayList`) for managing book records

---
---
## Sample Input
<pre>
1
Java Basics
Herbert Schildt
1
Python 101
Guido van Rossum
4
3
Java
5
1
4
6
1
2
2
4
0
</pre>
---
---
## Sample Output

<pre>
Book added successfully: 1 | Java Basics | Herbert Schildt | Available
Book added successfully: 2 | Python 101 | Guido van Rossum | Available

--- Display Books ---
1 | Java Basics | Herbert Schildt | Available
2 | Python 101 | Guido van Rossum | Available

--- Search Results (Java) ---
1 | Java Basics | Herbert Schildt | Available

Book issued: 1 | Java Basics | Herbert Schildt | Issued

--- Display Books ---
1 | Java Basics | Herbert Schildt | Issued
2 | Python 101 | Guido van Rossum | Available

Book returned: 1 | Java Basics | Herbert Schildt | Available
Book with ID 2 removed.

--- Display Books ---
1 | Java Basics | Herbert Schildt | Available

Exiting... Goodbye!

</pre>
---
