-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- -- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.
SELECT DISTINCT  genre.genre_name
FROM movie
JOIN movie_genre ON movie_genre.movie_id= movie.movie_id
JOIN movie_actor on movie_actor.movie_id = movie.movie_id
JOIN genre ON movie_genre.genre_id= genre.genre_id
JOIN person ON movie_actor.actor_id = person.person_id
WHERE person_name = 'Christopher Lloyd'
GROUP BY genre.genre_name, movie.title
ORDER by genre_name ASC

