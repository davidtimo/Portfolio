-- https://forms.office.com/r/75JXTZJ59X

-- David Timothy - 2540122773 - BH01

-- 1
USE indomo;

-- 2
SELECT
th.TransactionID,
mc.CustomerName,
th.CustomerID,
th.StaffID,
th.TransactionDate
FROM transactionheader AS th
JOIN mscustomer AS mc
ON th.CustomerID = mc.CustomerID
WHERE mc.CustomerName LIKE '%g%';

-- 3
SELECT

UPPER(c.CustomerName) AS 'Name',
c.CustomerID as 'ID'

FROM transactionheader as th
JOIN mscustomer as c 
ON c.CustomerID = th.CustomerID
WHERE c.CustomerGender = 'Female';

UNION

SELECT
LOWER(s.StaffName) AS 'Name',
s.StaffID as 'ID'
FROM transactionheader as th

JOIN msstaff as s 
ON s.StaffID = th.StaffID
WHERE s.StaffGender = 'Female';

-- 4
SELECT
th.TransactionID as 'TransactionId',
mc.CustomerID as 'Id',
mc.CustomerName as 'Name',
LOWER(mn.NoodleName) as 'NoodleName',
DATE_FORMAT(th.TransactionDate, '%Y') as 'TransactionYear'

FROM transactionheader as th 
JOIN mscustomer as mc
ON th.CustomerID = mc.CustomerID
JOIN transactiondetail as td
ON th.TransactionID = td.TransactionID
JOIN msnoodle as mn
ON td.NoodleID = mn.NoodleID
WHERE mn.NoodleStock > 350
UNION

SELECT
th.TransactionID as 'TransactionId',
th.StaffID as 'Id',
ms.StaffName as 'Name',
UPPER(mn.NoodleName)  as 'NoodleName',
DATE_FORMAT(th.TransactionDate, '%Y') as 'TransactionYear'



FROM transactionheader as th 
JOIN msstaff as ms
ON th.StaffID = ms.StaffID
JOIN transactiondetail as td
ON th.TransactionID = td.TransactionID
JOIN msnoodle as mn
ON td.NoodleID = mn.NoodleID
WHERE LOCATE('Street', ms.StaffAddress) >= 9;

-- 5

ALTER TABLE mscustomer
ADD customerAge INT,
ADD CONSTRAINT test 
CHECK(customerAge > 7);

-- 6

DELETE FROM msstaff as ms
WHERE MONTH(transactionheader.TransactionDate) = 9 & LENGTH(mscustomer.CustomerName) > 14;


-- 7

SELECT

th.TransactionID,
ms.staffID,
ms.staffName,
mc.CustomerID,
mn.NoodleName,
td.Quantity,
th.TransactionDate

FROM transactionheader as th 
JOIN mscustomer as mc
ON th.CustomerID = mc.CustomerID
JOIN transactiondetail as td
ON th.TransactionID = td.TransactionID
JOIN msnoodle as mn
ON td.NoodleID = mn.NoodleID
JOIN msstaff as ms
ON th.StaffID = ms.StaffID
WHERE mn.NoodleName IN('Ramen Noodle', 'Rice Stick Noodle') AND DATEDIFF('2022-1-6', th.TransactionDate) < 120 AND MONTH(th.TransactionDate) < 9;

-- 8
SELECT
mc.customerID,
CONCAT('Mr./Mrs. ', mc.customerName),
th.TransactionID

FROM transactionheader as th 
JOIN mscustomer as mc
ON th.CustomerID = mc.CustomerID

ORDER BY mc.CustomerID DESC;

-- 9
CREATE VIEW transaction_view
AS
SELECT
RIGHT(th.transactionId, 3),
REPLACE(mc.customerID ,'CU', 'Customer '),
REPLACE(ms.staffid,'ST', 'Staff '),
REPLACE(mn.noodleid,'ND', 'Noodle '),
td.quantity,
th.transactiondate
            
FROM transactionheader as th 
JOIN mscustomer as mc
ON th.CustomerID = mc.CustomerID
JOIN transactiondetail as td
ON th.TransactionID = td.TransactionID
JOIN msnoodle as mn
ON td.NoodleID = mn.NoodleID
JOIN msstaff as ms
ON th.StaffID = ms.StaffID;

-- 10
CREATE VIEW male_staff_report
AS
SELECT
th.transactionID,
REPLACE(ms.staffid,'ST', 'ID '),
ms.staffname,
mc.customerid,
mc.customername,
mn.noodleid,
DATE_FORMAT(th.TransactionDate, '%d %m %Y')

FROM transactionheader as th 
JOIN mscustomer as mc
ON th.CustomerID = mc.CustomerID
JOIN transactiondetail as td
ON th.TransactionID = td.TransactionID
JOIN msnoodle as mn
ON td.NoodleID = mn.NoodleID
JOIN msstaff as ms
ON th.StaffID = ms.StaffID

WHERE(ms.StaffGender = 'Male');