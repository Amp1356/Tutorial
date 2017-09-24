/**
*Author:Aaron Porter
*Version:1.0
*Date: March 21, 2016
*Purpose: To find the mean value in the array of numbers.
*/
import java.util.Scanner;
public class Median{

  /**
  *Returns: Nothing
  *Purpose: This swaps the value at the index labeled i with the value at the index labeled j.
  *
  *Parameter: Array of Integers  This is the array that will be used in the swaping.
  *Parameter: int  This is one of the two values needed for swaping i.
  *Parameter: int This is the second number needed for swaping labeled j.
  */
  public static void swap(int[]arr, int i, int j){
    int temp;
    temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }

  /**
  *Returns: Integer
  *Purpose: This will organize the array and place all numbers lower than the pivot value in front.
  *
  *Parameter: Array of Integers  This is the array that will be used.
  *Parameter: int  This is the index for the left most value in the array.
  *Parameter: int  This is the index for the right most value in the array.
  */
  public static int partition(int []arr, int left, int right){
    int pivot = arr[right];
    int pivindex=right;
    int holder;
    if(right<=1){
       if(arr[right]<arr[left]){
         swap(arr, right, left);
         return right;
         }
       else{
         return right;
         }
    }
    for(int i=right-1; i>left; i--){
       if(arr[pivindex]<arr[i]){
         swap(arr, i, pivindex);
	 pivindex=i;
       }
       else if(arr[pivindex]>arr[i]){
         partition(arr,left, i);
         if(arr[pivindex]<arr[i]){
            swap(arr, i, pivindex);
            pivindex=i;
         }
       }
     }
     System.out.println("Array value: "+pivindex+" "+arr[pivindex]);
     return pivindex;
  }

  /**
  *Returns: Integer
  *Purpose: Searches for the smallest value at the kth spot in the array.
  *
  *Parameter: Array of Integers  This is the array that will be used.
  *Parameter: int  This is the index for the left most value in the array.
  *Parameter: int  This is the index for the right most value in the array.
  *Parameter: int  This is the value middle number that we are looking for in the array.
  */
  public static int kthSmallest(int [] arr, int left, int right, int k){
    int value;
    int difference;
    int finalK;
    value= partition(arr, left, right);
    System.out.println("Partition value: "+value);
    if(k==value){
	return arr[value-1];
    }
    else if(value> k){
        difference=value-k;
        System.out.println("Difference of the greater value: "+k);
        finalK=kthSmallest(arr, left, value-1, k);
        return finalK;
    }
    else{
        difference=k-value;
        System.out.println("Difference of the lower value: "+k);
        finalK=kthSmallest(arr,value, right, k);
        return finalK;
    }
  }

  public static void main(String args[]){
    int counter=0;
    int zero= 0;
    int []array;
    int kValue;
    int result;
    Scanner input= new Scanner(System.in);
    array=new int[100];
    while(input.hasNextInt()){
      array[counter]=input.nextInt();
      counter=counter+1;
    }
    kValue=counter/2;
    if(counter%2==1){
      kValue=kValue+1;
    }
    result=kthSmallest(array, zero, counter-1,kValue);
    System.out.println("Median: "+result);
    for(int i=0; i<counter; i++){
       System.out.println(array[i]);
    }
  }
}
