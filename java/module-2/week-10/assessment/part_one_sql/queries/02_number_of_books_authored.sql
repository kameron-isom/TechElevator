-- 2. List the first and last name of all authors (name the column 'author') and the number of books they've written (name the column 'num_books').
-- Order the results by the number of books in descending order (highest first), then by alphabetical order of the author's first name.
-- Tip: make sure to add a space between the author's first and last names.
-- (16 rows)
SELECT person.first_name ||' ' || person.last_name AS author, COUNT(book_title) AS num_books
FROM person
JOIN book_author ON book_author.author_id = person.person_id
JOIN book ON book.book_id = book_author.book_id
GROUP BY author
ORDER BY COUNT(book_title) DESC, author ASC