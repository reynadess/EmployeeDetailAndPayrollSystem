CREATE SCHEMA employee_payroll;

USE employee_payroll;

CREATE TABLE employee (
employeeId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
employeeName VARCHAR(100) NOT NULL,
employeePassword VARCHAR(100) NOT NULL,
employeeRole ENUM('Admin','Employee') NOT NULL DEFAULT 'Employee',
DOB DATE NOT NULL,
totalSalary INT NOT NULL,
phoneNo VARCHAR(10) NOT NULL,
emailId VARCHAR(50) NOT NULL,
employeeStatus ENUM('active', 'inactive') NOT NULL DEFAULT 'active',
createdOn TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
createdBy INT NOT NULL,
modifiedOn TIMESTAMP DEFAULT NULL,
modifiedBy INT DEFAULT NULL
);

ALTER TABLE employee AUTO_INCREMENT = 1000;

CREATE TABLE attendance (
	employeeId INT NOT NULL,
    loginDate DATE NOT NULL DEFAULT (CURRENT_DATE()),
    PRIMARY KEY (employeeId, loginDate),
    FOREIGN KEY (employeeId) REFERENCES employee(employeeId)
);

CREATE TABLE pay_slip_generation (
	employeeId INT NOT NULL,
    paySlipId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    paymentDate DATE NOT NULL, 
    baseSalary INT NOT NULL,
    housingRentAllowance INT NOT NULL,
    travellingAllowance INT NOT NULL,
    grossSalary INT NOT NULL,
    employeeProvidientFund INT NOT NULL,
    lossOfPay INT NOT NULL,
    netSalary INT NOT NULL,
    FOREIGN KEY (employeeId) REFERENCES employee(employeeId)
);

CREATE TABLE salary_percentage (
    baseSalary INT NOT NULL,
    housingRentAllowance INT NOT NULL,
    travellingAllowance INT NOT NULL,
    employeeProvidientFund INT NOT NULL
);

INSERT INTO employee(employeeName, employeePassword, employeeRole, DOB, totalSalary, phoneNo, emailId, createdBy) VALUES ("Admin", "8c6976e5b541415bde98bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918", "Admin", "2006-01-01", 500000,"1234567890", "admin@medplus.com", 1000);

INSERT INTO salary_percentage (baseSalary, housingRentAllowance, travellingAllowance, employeeProvidientFund) VALUES (60, 20, 8, 12);

CREATE TABLE employee_payroll.month_working_days(
	monthYear DATE NOT NULL PRIMARY KEY,
    workingDays INT NOT NULL
);

ALTER TABLE employee_payroll.salary_percentage
ADD dearnessAllowance INT NOT NULL,
ADD otherAllowance INT NOT NULL;

ALTER TABLE employee_payroll.salary_percentage
MODIFY COLUMN otherAllowance DOUBLE;

INSERT INTO employee_payroll.salary_percentage (
baseSalary, housingRentAllowance, travellingAllowance, dearnessAllowance, employeeProvidientFund, otherAllowance
) VALUES 
( 60, 20, 14, 10, 12, 10.66666
);