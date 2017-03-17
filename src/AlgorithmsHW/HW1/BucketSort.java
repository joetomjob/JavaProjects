package AlgorithmsHW.HW1;
import java.util.Scanner;

public class BucketSort {
	
	public static Double[] insertionSort(Double input[]){
		
		for(int counter = 1;counter<input.length;counter++){
			
			Double element = input[counter];
			int j = counter;
			
			while(j>0 && input[j-1]>element){
				
				input[j] = input[j-1];
				j = j-1;
			}
			
			input[j] = element;
		}
		
		return input;
	}
	
	public static void bucketSort(Double[] inputArray,int noOfBuckets){
		int counter;
		Bucket[] bucketArray = new Bucket[noOfBuckets];
		
		for(counter=0;counter<noOfBuckets;counter++){
			
			bucketArray[counter] = new Bucket();
		}
		
		double width = 1/noOfBuckets;
		System.out.print(width);
		
		for(counter=0;counter<noOfBuckets;counter++){
			
			if(counter==0){
				bucketArray[counter].lowerLimit=0;
				bucketArray[counter].upperLimit=width;
			}else{
				bucketArray[counter].lowerLimit=bucketArray[counter-1].upperLimit;
				bucketArray[counter].upperLimit=bucketArray[counter].lowerLimit+width;
			}
		}
		
		counter=0;
		
		for(int itr=0;itr<noOfBuckets;itr++){
			
			while(counter<noOfBuckets){
			if(inputArray[itr]>=bucketArray[counter].lowerLimit &&
					inputArray[itr]<=bucketArray[counter].upperLimit){
				bucketArray[counter].ll.add(inputArray[itr]);
				counter=0;
				break;
			}else{
				counter++;
			}
		}
	}	
		counter=0;
		
		for(int itr=0;itr<noOfBuckets;itr++){
			
			System.out.println("Size for bucket no :"+itr+" : "+bucketArray[itr].ll.size());
			Double[] bArray = new Double[bucketArray[itr].ll.size()];
			bucketArray[itr].ll.toArray(bArray);
			System.out.println("hello");
			
			for(int itr1=0;itr1<bArray.length;itr1++){
				System.out.print(bArray[itr1]+"@");
			}
			
			Double[] sortedArray = insertionSort(bArray);
			
			for(int itr1=0;itr1<bArray.length;itr1++){
				inputArray[counter]=sortedArray[itr1];
				System.out.println("sorted element : "+sortedArray[itr1]);
				counter++;
			}	
		}
		
		for(int temp=0;temp<inputArray.length;temp++){
			System.out.print(inputArray[temp]+" ");
		}

}
	
	@SuppressWarnings("resource")
	public static void main(String args[]){
		
		Scanner src = new Scanner(System.in);
		int n = src.nextInt();
		Double[] inputArray = new Double[n];
		
		for(int counter=0;counter<n;counter++){
			inputArray[counter]= src.nextDouble();
		}
		
		bucketSort(inputArray,n);
	}
}
