-- 2. Select the name of the publisher with the most books published that are not out of print.
-- Select the number of books published by them (name the column 'books_in_print').
-- (1 row)
SELECT publisher.publisher_name,  count(*) AS books_in_print
FROM publisher 
JOIN  book ON publisher.publisher_id= book.publisher_id
WHERE out_of_print IS false
GROUP BY publisher.publisher_name
ORDER BY books_in_print DESC
LIMIT 1
