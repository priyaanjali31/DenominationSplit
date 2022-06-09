package src.main.java;

import java.util.Arrays;
import java.util.Scanner;

public class DenominationSplitter {
	
	public static void main(String args[]) 
    {
    	Scanner scnr=new Scanner(System.in);
    	
    	System.out.print("Enter the number of denominations available with you:");  
    	double denoNumb = scnr.nextDouble();
    	
    	System.out.println(denoNumb);
    	
    	System.out.print("Enter the denominations available with you");  
    	
    	double[] denominations = new double[(int) denoNumb];
    	for(int i=0; i<denoNumb; i++)  
    	{  
    		denominations[i]=scnr.nextDouble(); 
    		System.out.println(denominations[i]);
    	}
    	
    	denominations = reverseDenomArrayDesc(denominations);
    	
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
      for (int i=0; i<denominations.length; i++)
      {
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
    public static double[] reverseDenomArrayDesc(double[] denomArray){
    	if(denomArray.length>0){
    		Arrays.sort(denomArray);
    		int length = denomArray.length;
    		for(int i = 0;i<length/2;i++){
    			double temp= denomArray[i];
    			denomArray[i] = denomArray[length - i - 1];
    			denomArray[length - i - 1] = temp;
    			
    		}
    	}
    	return denomArray;
    }
}
