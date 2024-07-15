# Write your MySQL query statement below
SELECT 
    ROUND(SUM(IF(order_date = customer_pref_delivery_date, 1, 0)) * 100 / COUNT(*), 2) AS immediate_percentage
FROM Delivery D1
WHERE order_date = (SELECT MIN(order_date) FROM Delivery D2 WHERE D2.customer_id = D1.customer_id)