/*
 Julia asked her students to create some coding challenges.
 Write a query to print the hacker_id, name, and the total number of challenges created by each student.
 Sort your results by the total number of challenges in descending order.
 If more than one student created the same number of challenges, then sort the result by hacker_id.
 If more than one student created the same number of challenges and the count is less than the maximum number of challenges created,
 then exclude those students from the result
 */

SELECT
    h.hacker_id,
    h.name,
    COUNT(c.challenge_id) AS total_challenges
FROM
    Hackers h
        JOIN
    Challenges c ON h.hacker_id = c.hacker_id
GROUP BY
    h.hacker_id, h.name
HAVING
    COUNT(c.challenge_id) = (
        -- Maximum number of challenges created by any hacker
        SELECT MAX(challenge_count)
        FROM (
                 SELECT COUNT(challenge_id) AS challenge_count
                 FROM Challenges
                 GROUP BY hacker_id
             ) AS max_challenges
    )
    OR
    COUNT(c.challenge_id) IN (
        -- Counts that only appear once (unique counts)
        SELECT challenge_count
        FROM (
                 SELECT hacker_id, COUNT(challenge_id) AS challenge_count
                 FROM Challenges
                 GROUP BY hacker_id
             ) AS counts
        GROUP BY challenge_count
        HAVING COUNT(hacker_id) = 1
    )
ORDER BY
    total_challenges DESC,
    h.hacker_id;