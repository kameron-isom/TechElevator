-- 2. The names and birthdays of actors in "The Fifth Element"
-- Order the results alphabetically (A-Z) by name.
-- (15 rows)



SELECT person.person_name, person.birthday
FROM movie
JOIN movie_actor on movie_actor.movie_id = movie.movie_id
JOIN person ON movie_actor.actor_id = person.person_id
WHERE title= 'The Fifth Element'
ORDER BY person.person_name ASC