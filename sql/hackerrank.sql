-- Find the difference between the total number of CITY entries in the table and the number of distinct CITY entries in the table.
SELECT COUNT(CITY) - COUNT(DISTINCT CITY) AS diff FROM STATION;

-- Query the two cities in STATION with the shortest and longest CITY names, as well as their respective lengths (i.e.: number of characters in the name). If there is more than one smallest or largest city, choose the one that comes first when ordered alphabetically.
SELECT CITY, LENGTH(CITY) AS LENGTH FROM STATION
WHERE LENGTH(CITY) = (SELECT MIN(LENGTH(CITY)) FROM STATION)
OR LENGTH(CITY) = (SELECT MAX(LENGTH(CITY)) FROM STATION)
ORDER BY LENGTH(CITY) ASC, CITY ASC
LIMIT 2;

(
    SELECT CITY, LENGTH(CITY) AS LENGTH
    FROM STATION
    WHERE LENGTH(CITY) = (SELECT MIN(LENGTH(CITY)) FROM STATION)
    ORDER BY CITY ASC
        LIMIT 1
)
UNION
(
    SELECT CITY, LENGTH(CITY) AS LENGTH
    FROM STATION
    WHERE LENGTH(CITY) = (SELECT MAX(LENGTH(CITY)) FROM STATION)
    ORDER BY CITY ASC
        LIMIT 1
);

-- Query the list of CITY names starting with vowels (i.e., a, e, i, o, or u) from STATION. Your result cannot contain duplicates.
SELECT DISTINCT CITY FROM STATION
WHERE CITY REGEXP '^[aeiou]'

SELECT DISTINCT CITY FROM STATION
WHERE CITY LIKE 'A%'
   OR CITY LIKE 'E%'
   OR CITY LIKE 'I%'
   OR CITY LIKE 'O%'
   OR CITY LIKE 'U%'