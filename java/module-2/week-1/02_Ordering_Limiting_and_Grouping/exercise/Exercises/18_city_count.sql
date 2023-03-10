-- 18. The count of the number of cities (name column 'num_cities') and the state abbreviation for each state and territory (exclude state abbreviation DC).
-- Order the results by state abbreviation.
-- (55 rows)
SELECT state_abbreviation, COUNT (*)  AS num_cities 
FROM city
GROUP BY state_abbreviation
HAVING state_abbreviation != 'DC'
ORDER BY state_abbreviation 


