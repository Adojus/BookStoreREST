# BookStoreREST
Java web project with RESTful services using Spring Framework

The program stores Book's name, author, barcode, quantity and unit price.
Additionaly, it stores Antique Books with release year property(year<1900) and Science Journals with science index property (0<index<11).

A client can make RESTful calls (POST, PUT, GET) to add a book, to get the book list, to update a book or get the total price of books with chosen barcode.

* To run the program open it in IntelliJ and press 'Run'. To make the the restful calls, download the desktop app Postman.
* To put books use POST call with a body in JSON format({"name" : "bookname", "author" : "authorname"...}) at *localhost:8080/books*
* To get book list use GET call at *localhost:8080/books*
* To get information about a specific book use GET call at *localhost:8080/books/{barcode}*
* To get books grouped by quantity use a GET call at *localhost:8080/books/grouped*.

  For Science Journals and Antique Books use corresponding address instead of *books* - *:8080/scienceJournals*, *:8080/antiqueBooks*.
