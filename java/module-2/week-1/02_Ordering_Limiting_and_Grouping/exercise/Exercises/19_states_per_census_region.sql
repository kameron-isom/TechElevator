-- 19. The census region and the number of records in the state table (name column 'num_states') for each census region. Exclude ones that don't have a census region.
-- Order the results from highest to lowest.
-- (Note: DC is in a census region, but the territories aren't, so the sum of the counts will equal 51).
-- (4 rows)

SELECT COUNT(*) AS num_states, census_region
FROM state
GROUP BY census_region
HAVING census_region IS NOT NULL
ORDER BY num_states DESC