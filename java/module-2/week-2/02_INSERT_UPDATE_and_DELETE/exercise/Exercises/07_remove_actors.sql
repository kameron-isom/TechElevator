-- 7. Remove the actor appearances in "Avengers: Infinity War" (14 rows)
-- Note: Don't remove the actors themeselves, just make it so it seems no one appeared in the movie.
DELETE FROM movie_actor
WHERE movie_id = 299536
-- SELECT movie.movie_id, person.person_id
-- FROM movie
-- JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
-- JOIN person ON person.person_id = movie_actor.actor_id
-- WHERE movie.title ='Avengers: Infinity War'
