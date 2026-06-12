# Write your MySQL query statement below
SELECT unique_id,name
FROM Employees e
LEFT JOIN EmployeeUNI ui
ON e.id = ui.id ;