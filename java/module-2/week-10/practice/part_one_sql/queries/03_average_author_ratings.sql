-- 3. List the first and last name of all authors, separated by a space, (name the column 'author') 
--and the average star rating of their books (name the column 'average_rating').
-- Round average_rating to 2 decimal places.
-- Order by the average rating, lowest first.
-- (16 rows)
SELECT person.first_name ||' ' || person.last_name AS author, ROUND(AVG(book.star_rating),2) AS average_rating
FROM person 
JOIN book_author 
ON person.person_id = book_author.author_id
JOIN book on book_author.book_id = book.book_id
GROUP BY author
ORDER BY AVG (book.star_rating) ASC