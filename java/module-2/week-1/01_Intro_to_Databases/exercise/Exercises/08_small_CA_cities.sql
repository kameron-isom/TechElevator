-- 8. The name and population of cities in California (CA) with a population less than 150,000 people (37 rows)
SELECT city_name, state_abbreviation, population
FROM city
WHERE state_abbreviation ='CA' AND population < 150000 


