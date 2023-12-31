-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)
INSERT INTO  collection(collection_name) VALUES ('Bill Murray Collection');

UPDATE movie SET collection_id = (SELECT collection_id FROM  collection WHERE collection_name= 'Bill Murray Collection')
WHERE movie_id = '1532' ;


SELECT movie.title, movie_actor.actor_id, movie.collection_id, person.person_name
FROM movie 
JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
JOIN person ON person.person_id = movie_actor.actor_id
WHERE person.person_name = 'Bill Murray'