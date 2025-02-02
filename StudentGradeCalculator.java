import java.util.*;
class StudentGradeCalculator{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of subjects");
int noOfSubjects=sc.nextInt();
int marks[]=new int[noOfSubjects];
int totalmarks=0;

for(int i=0;i<noOfSubjects;i++)
{
System.out.println("Enter the "+(i+1)+" subject marks");
marks[i]=sc.nextInt();
totalmarks=totalmarks+marks[i];
}
 
double averagepercentage=(double)totalmarks/noOfSubjects;

String grade;

if(totalmarks>=90)
grade="A+";
else if(totalmarks>=80)
grade="A";
else if(totalmarks>=70)
grade="B+";
else if(totalmarks>=60)
grade="B";
else if(totalmarks>=50)
grade="C";
else if(totalmarks>=40)
grade="D";
else
grade="F";


System.out.println("Total marks are "+totalmarks);
System.out.println("average percentage "+averagepercentage);
System.out.println("Grade is "+grade);

}
}


