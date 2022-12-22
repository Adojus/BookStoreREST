# BookStoreREST
Java web project with RESTful services using Spring Framework

The program stores Book's name, author, barcode, quantity and unit price.

A client can make RESTful calls (POST, PUT, GET) to add a book, to get the book list, to update a book or get the total price of books with chosen barcode.

To run the program open it in IntelliJ and press 'Run'. To make the the restful calls, download the desktop app Postman.
To put books use POST call with a body in JSON format({"name" : "bookname", "author" : "authorname"...}) at localhost:8080/api/v1/book
To get book list use GET call at localhost:8080/api/v1/book
To get information about a specific book use GET call at localhost:8080/api/v1/book/{barcode}
To get books grouped by quantity use a GET call at localhost:8080/api/v1/grouped
