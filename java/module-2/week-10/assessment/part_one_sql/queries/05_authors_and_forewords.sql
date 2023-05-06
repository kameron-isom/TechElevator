-- 5. List all book titles and the first and last name of the person who wrote the foreword (name the column 'foreword_author') for books that Moishe Reiling was an author.
-- Order by book title (A-Z).
-- Tip: make sure to add a space between the author's first and last names.
-- (5 rows)
SELECT book.book_title, person.first_name|| ' ' || person.last_name AS foreword_author, foreword_by
FROM book
JOIN book_author ON book_author.book_id = book.book_id
JOIN person ON person.person_id = book_author.author_id
WHERE first_name = 'Moishe' AND person.last_name = 'Reiling'
ORDER BY book_title ASC
-- SELECT book.foreword_by, person.first_name
-- FROM book
-- JOIN book_author ON book_author.book_id = book.book_id
-- JOIN person ON person.person_id = book_author.author_id
-- WHERE first_name ='Ranice' OR first_name='Moisha'