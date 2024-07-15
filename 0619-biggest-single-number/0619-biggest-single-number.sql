# Write your MySQL query statement below
-- IFNULL(SELECT num
-- FROM MyNumbers
-- GROUP BY num
-- HAVING COUNT(num) = 1
-- ORDER BY num DESC
-- LIMIT 1
-- , null)

SELECT 
    IFNULL(
        (SELECT num
        FROM MyNumbers
        GROUP BY num
        HAVING COUNT(num) = 1
        ORDER BY num DESC
        LIMIT 1)
        ,null) AS num
