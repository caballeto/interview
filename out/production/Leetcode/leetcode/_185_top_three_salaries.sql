WITH Q AS (SELECT
  DepartmentId,
  Name,
  Salary,
  ROW_NUMBER() over (PARTITION BY DepartmentId ORDER BY Salary DESC) AS Count
FROM Employee GROUP BY DepartmentId, Salary)
SELECT Department.Name AS 'Department', Q.Name AS 'Employee', Employee.Salary FROM Employee
INNER JOIN Department
  ON Department.Id = Employee.DepartmentId
INNER JOIN Q
  ON Q.Salary = Employee.Salary AND Q.DepartmentId = Employee.DepartmentId AND Q.Count <= 3;
