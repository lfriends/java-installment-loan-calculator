# java-installment-loan-calculator
A java installment loan calculator library
that calculates the monthly installment amounts for a loan.


## Features

- **Loan Calculation:** The program allows users to enter the loan amount, interest rate, and loan duration in months.
- **Monthly Installment Calculation:** It calculates the fixed monthly installment amount.
- **Amortization Schedule:** It generates an amortization schedule that shows the breakdown of each payment, including the principal amount, interest amount, and remaining balance.
- **Due date calculation:** The program calculates the due date for each installment, trying to keep the same day of the month whenever possible. <br>Eg: if you set a *due date* on the 31st of May, it will automatically recalculate the dates as follow:
    - 31st of May
    - 30th of June ... because Jun has 30 days, the program will automatically decrese the *due date* to the 30th of the month.
    - 31st of July


## Getting Started

### Prerequisites

To run the Installment Plan Calculator program, you need to have the following:

- Java Development Kit (JDK) installed on your machine.
- A Java IDE or text editor for editing and running the Java code. 
This is a Netbeans-Ant project.

- A Java IDE 

### Bulding the Project

1. Clone or download the project repository to your local machine.
```shell
git clone https://github.com/lfriends/java-installment-loan-calculator.git
cd java-installment-loan-calculator
```
2. if you use *Apache Ant™*: 
```shell
cd ./java-installment-loan-calculator
ant
```
.OR.

3. Open the project in your preferred IDE or text editor (Eg Netbeans)
3. then run the "Build" or "Run" command


### Runing the Project

You can import the Jar in your project, or make a Loan Plan simulation directrly from a command-line interface:
```shell
java -jar "lfIntallmentPlan.jar"
```


## Example Usage

```shell
java -jar "lfIntallmentPlan.jar"

====== Installment Calculator  ::  github.com/lfriends ======
Please enter the loan amount (Eg 10000):
10000
Please enter the interest rate in % (Eg 4.5):
4.5
Please enter the loan duration inmonts (Eg 12):
12
Please enter the 1st due date (DD/MM/YY .or. DDMMYY) (Eg 31/12/23 .or 311223):
311223
-----------------------------------------------------------------------------
Principal ............... 10.000,00
Interest rate ........... 4,50%
Duration ................ 12 months
Monthly payments ........ 853,79
Intarest paid ........... 245,42
Total paid .............. 10.245,42

Month | Due date  | Installme | Principal | Interest  | Balance   | Debt Paid 
-----------------------------------------------------------------------------
1     | 31/12/23  | 853,79    | 816,29    | 37,50     | 9.183,71  | 816,29    
2     | 31/01/24  | 853,79    | 819,35    | 34,44     | 8.364,37  | 1.635,63  
3     | 29/02/24  | 853,79    | 822,42    | 31,37     | 7.541,95  | 2.458,05  
...   | ...       | ...       | ...       | ...       | ...       | ...       
12    | 30/11/24  | 853,79    | 850,60    | 3,19      | 0,00      | 10.000,00 
-----------------------------------------------------------------------------
Total             | 10.245,42 | 10.000,00 | 245,42    |                      
-----------------------------------------------------------------------------
```


## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code for personal or commercial purposes.

