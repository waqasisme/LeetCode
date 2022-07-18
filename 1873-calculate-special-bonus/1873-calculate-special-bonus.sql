# Write your MySQL query statement below
SELECT e.employee_id, 
CASE 
    WHEN e.employee_id % 2 = 0 OR e.name LIKE 'M%' THEN 0 ELSE e.salary
END AS bonus 
FROM Employees e
ORDER BY e.employee_id 