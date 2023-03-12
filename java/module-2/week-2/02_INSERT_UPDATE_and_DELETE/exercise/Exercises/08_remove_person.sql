-- 8. Remove "Penn Jillette" from the person table 
-- You'll have to remove data from another table before you can make him "disappear" (Get it? Because he's a magician...) (1 row each)
DELETE FROM movie_actor
WHERE actor_id = (SELECT person_id FROM person WHERE person_name= 'Pen Jillette');

DELETE FROM person 
WHERE person_name = 'Pen Jillette'


-- SELECT person.person_name, movie_actor.actor_id
-- FROM person
-- JOIN movie_actor ON person.person_id = movie_actor.actor_id
-- WHERE person_name = 'Penn Jillette'