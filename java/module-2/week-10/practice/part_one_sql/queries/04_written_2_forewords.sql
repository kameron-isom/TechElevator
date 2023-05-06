-- 4. List the first and last name of all persons, separated by a space, (name the column 'full_name')
--who have written at least 2 forewords.
-- Include the count of forewords written by each person (name the column 'foreword_count').
-- Order by full_name ascending.
-- (7 rows)
SELECT  COUNT(book.foreword_by) AS foreword_count, person.first_name ||' '|| person.last_name AS full_name
FROM person
JOIN book_author ON person.person_id  = book_author.author_id
JOIN book 
ON book_author.book_id= book.book_id
WHERE foreword_by >2
GROUP BY full_name
ORDER BY full_name ASC


