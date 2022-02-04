/*1.*/
SELECT COUNT(*) FROM flights;
/*2.*/
SELECT avg(DepDelay), Origin FROM flights GROUP BY Origin;
SELECT avg(ArrDelay), Origin FROM flights GROUP BY Origin;
/*3.*/
SELECT Origin, colYear, colMonth, avg(ArrDelay) FROM flights GROUP BY Origin, colYear, colMonth;
/*4.*/
SELECT City, colYear, colMonth, avg(ArrDelay) FROM flights LEFT JOIN usairports ON usairports.IATA = flights.Origin GROUP BY City, colYear, colMonth;
/*5.*/
SELECT Description, COUNT(Cancelled) FROM flights INNER JOIN carriers ON carriers.CarrierCode = flights.UniqueCarrier WHERE Cancelled > 0 ORDER BY Cancelled;
/*6.*/
SELECT TailNumflights, sum(Distance) FROM flights WHERE tailnum != "NA" ORDER BY sum(Distance) DESC LIMIT 10;
/*7.*/
SELECT Description, avg(ArrDelay) FROM flights INNER JOIN carriers ON carriers.CarrierCode = flights.UniqueCarrier GROUP BY Description HAVING avg(ArrDelay) > 10;


