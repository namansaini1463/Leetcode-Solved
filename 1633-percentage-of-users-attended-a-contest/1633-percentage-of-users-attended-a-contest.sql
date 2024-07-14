# Write your MySQL query statement below


SELECT R.contest_id, ROUND(COUNT(U.user_id)/(SELECT COUNT(*) FROM Users) * 100, 2) AS percentage
FROM Users U
RIGHT JOIN Register R
ON U.user_id = R.user_id
GROUP BY R.contest_id
ORDER BY percentage DESC, R.contest_id ASC