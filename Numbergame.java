import java.util.*;
class Numbergame{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
Random rd=new Random();
int secretnum=rd.nextInt(100)+1;
int totalattempts=10;
int attempts=0;
System.out.println("welcome to the number guessing game");
System.out.println("you have total of"+ totalattempt s+"attempts");
while(attempts<=totalattempts)
{
System.out.println("Enter the number for guessing");
int num=sc.nextInt();
attempts++;
if(num==secretnum)
{
System.out.println("you have guessed the correct number"+num);
break;
}
else if(num<secretnum)
{
System.out.println("you number is lower than the secret number");
}
else if(num>secretnum)
{
System.out.println("you number is higher than the secret number");
}
}

}}



