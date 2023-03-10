-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)
SELECT movie.title, person.person_name
FROM movie 
JOIN person ON person.person_id = movie.director_id
JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
WHERE movie.director_id = movie_actor.actor_id
ORDER BY movie.title ASC
