#Library Application
This is a simple project that simulates application for book renting.  
Main goal was to enable CRUD operations with book, book-copy, user.  
There is section for tracking rented books and archive.  

###Features  
For the Book:


- Find book by id
- Find book by title
- Find all books
- Add book
- Edit book by id
- Delete book by id  
***

For the book-copy:   

Idea for the book-copy was next: In your library you can have three same books.  
For example:  
GRR Martin - A Dance with Dragons is one book in our app, but in library we have three copies of that book  
so three users can rent it simultaneously.  
When adding book-copy for certain book, serial number for that book will be added automatically as UUID, using  
UUID generator. This UUID can be easily converted into QR code.

- Find all book-copies
- Find by id
- Find rented book-copies that belongs to a certain book by providing a book id
- Add book-copy for specific book providing a book id
- Delete book-copy

***
For the user:  

- Find all users
- Find user by username
- Find user by id
- Add user
- Edit user details
- Delete user

***  


For the tracking rented books:  
- Find all rented book-copies
- Find all rented copies for specific book by book id
- Find overdue books
- Find copies by user id
- When user rents a copy, it will add it to database
- Delete -> this meant that user has returned book, so it will be deleted and saved automatically into archive

***

For the archive  
This option was meant to be used for statistics.
- Show all archive
- Show all overdue book-copies
- If you don't want to see all overdue books, you can provide number of how many books you want to see  
for example: you wish to see just 3 overdue books  
- Show all renting for specific user 

****
There is some helper methods for statistic:
- Option that will show all rented copies that belongs to certain book
- Option that will show all copies that belong to certain book
