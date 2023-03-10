-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)
-- SELECT movie.title, person.person_name, movie.movie_id
-- FROM movie
-- JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
-- JOIN person ON movie_actor.actor_id = person.person_id
-- WHERE movie.title = 'Back to the Future'
INSERT INTO movie_actor (movie_id, actor_id)
VALUES('105',( SELECT person_id FROM person WHERE person_name = 'Eric Stoltz' ))

