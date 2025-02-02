import java.util.*;
class BankAccount{
double balance;
BankAccount()
{
this.balance=1000;
}


void deposit(double amount)
{
balance=balance+amount;
System.out.println(amount+"  Deposited Successfully");
}

void withdraw(double amount)
{
if(balance>amount){
balance=balance-amount;
System.out.println(amount+"  Withdrawn Successfully");
}
else
{
System.out.println("Insufficent balance .Unable to withdraw amount");
}
}


void CheckBalance()
{
System.out.println("your balance is "+balance);
}
}

class ATM{
public static void main(String args[])
{

Scanner sc=new Scanner(System.in);
BankAccount bank=new BankAccount();
int option;
do{
System.out.println("1.check Balance");
System.out.println("2.Deposit");
System.out.println("3.withdraw");
System.out.println("4.Exit");
 option=sc.nextInt();

switch(option)
{
case 1:bank.CheckBalance();
break;
case 2:System.out.println("Enter the amount to be deposited");
int am=sc.nextInt();
bank.deposit(am);
break;
case 3:System.out.println("Enter the amount for withdraw");
int wd=sc.nextInt();
bank.withdraw(wd);
break;
case 4:
System.out.println("Exiting....");
break;
}

}while(option!=5);
}
}

