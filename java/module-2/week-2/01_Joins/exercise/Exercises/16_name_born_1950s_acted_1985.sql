-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)
SELECT person.person_name, person.birthday, movie.release_date
FROM movie
JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
JOIN person ON movie_actor.actor_id = person.person_id
WHERE person.birthday BETWEEN '1949-12-31' AND '1950-12-31' AND movie.release_date BETWEEN '1984-12-31' AND '1985-12-31'
ORDER BY person.birthday ASC

