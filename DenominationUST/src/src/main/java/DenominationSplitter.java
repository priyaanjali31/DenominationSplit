package src.main.java;

import java.util.Scanner;

public class DenominationSplitter {
	
	public static void main(String args[]) 
    {
    	Scanner scnr=new Scanner(System.in);
    	
    	System.out.print("Enter the number of denominations available with you:");  
    	int denoNumb = scnr.nextInt();
    	
    	System.out.println(denoNumb);
    	
    	System.out.print("Enter the denominations available with you");  
    	
    	double[] denominations = new double[denoNumb];
    	for(int i=0; i<denoNumb; i++)  
    	{  
    		denominations[i]=scnr.nextInt(); 
    		System.out.println(denominations[i]);
    	}
    	
    	
    	System.out.print("Enter Product price: ");  
    	double productPrice = scnr.nextDouble();
    	
    	System.out.print("Enter Amount given by Customer: ");  
    	double AmountPaid = scnr.nextDouble(); 
    	
    	if(AmountPaid> productPrice) {
    		double amountDifference = AmountPaid - productPrice;
    		splitToChange(denominations,amountDifference);
    	}else
    	{
    		System.out.print("Amount Paid should be greater than product price");  
    	}
      
    }
    public static void splitToChange(double[] denominations,double amount)
    {
     int[] denominationCount = breakdown(denominations, amount);
     
     for (int i=0; i<denominations.length; i++) 
     {
         if (denominationCount[i]>0) 
         {
            System.out.println(denominationCount[i]+" x "+denominations[i]);
         }
      }
    }
    private static int[] breakdown(double[] denominations, double amount) {
      int[] count = new int[denominations.length];
       
      // Loop through each denomination (starting at largest)
       
      for (int i=0; i<denominations.length; i++) {
          
         // Use one of that denomination until we need something smaller
          
         while (amount>=denominations[i]) {
            count[i]++;
            amount -= denominations[i];
         }
      }
      if(amount!= 0.0) {
     	 System.out.println("ALERT::No denomination left for the remianing:::: "+amount);
      }
      return count;
   }
    
}
