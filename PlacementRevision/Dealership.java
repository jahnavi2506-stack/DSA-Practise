A function is there which tells how many dealerships there are and the total number of cars in each dealership.
Your job is to calculate how many tyres would be there in each dealership.

public class Solution
{
    public static void main(String[] args)
   {
        Scanner sc=new Scanner(System.in);
        int dealership=sc.nextInt();
        while(dealership-->0)
       {
            int cars=sc.nextInt();
            int bikes=sc.nextInt();
            System.out.println(cars*4+bikes*2);           
       }
   }
}