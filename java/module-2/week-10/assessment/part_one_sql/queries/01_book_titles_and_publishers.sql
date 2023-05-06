-- 1. List the titles of all books, the name of the publisher, and the date published. 
-- Order the results by published date, earliest first.
-- (33 rows)
SELECT book.book_title, publisher.publisher_name,book.published_date
FROM book
JOIN publisher on publisher.publisher_id = book.publisher_id
ORDER BY book.published_date ASC
