# Write your MySQL query statement below
SELECT C.customer_id
FROM Customer C
LEFT JOIN Product P
ON C.product_key = P.product_key
GROUP BY C.customer_id
HAVING COUNT(DISTINCT C.product_key) = (SELECT COUNT(DISTINCT product_key) FROM Product)
ORDER BY C.customer_id