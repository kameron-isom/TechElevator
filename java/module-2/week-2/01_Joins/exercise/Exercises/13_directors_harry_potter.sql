-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)
SELECT person.person_name, movie.director_id
FROM collection
JOIN movie ON collection.collection_id = movie.movie_id
JOIN person ON person.person_id = movie.director_id
WHERE collection.collection_name = 'Harry Potter Collection'
ORDER BY person.person_name ASC

