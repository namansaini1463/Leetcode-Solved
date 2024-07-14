# Write your MySQL query statement below
SELECT Prices.product_id, if(SUM(Prices.price * UnitsSold.units)/SUM(UnitsSold.units), ROUND(SUM(Prices.price * UnitsSold.units)/SUM(UnitsSold.units), 2), 0) as average_price
FROM Prices 
LEFT JOIN UnitsSold 
ON 
    Prices.product_id = UnitsSold.product_id AND
    UnitsSold.purchase_date >= Prices.start_date AND
    UnitsSold.purchase_date <= Prices.end_date
GROUP BY Prices.product_id