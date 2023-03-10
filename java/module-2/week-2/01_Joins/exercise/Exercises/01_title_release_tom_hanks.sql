-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)

SELECT movie.title, movie.release_date
FROM movie
JOIN movie_actor on movie_actor.movie_id = movie.movie_id
JOIN person ON movie_actor.actor_id = person.person_id
WHERE person_name = 'Tom Hanks'
ORDER BY movie.release_date DESC

-- ( SELECT home_page
-- 				FROM person
-- 				WHERE person_name='Tom Hanks')
-- ORDER BY release_date ASC