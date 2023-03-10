-- 6. The genres of "The Wizard of Oz" sorted in alphabetical order (A-Z).
-- (3 rows)
SELECT  genre.genre_name
FROM movie
JOIN movie_genre ON movie_genre.movie_id = movie.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
WHERE movie.movie_id='630'
ORDER BY title ASC
