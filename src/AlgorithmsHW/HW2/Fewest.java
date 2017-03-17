import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fewest {

	static Random r = new Random();
	static int digitCounter=0;
	static int cValue=0;

	
	@SuppressWarnings("unused")
	public static int compute(List<Integer> inputList,int pivot){
		
		int lTotal=0;
		int gTotal=0;
		int eTotal=0;
		
		 List<Integer> lesser = new ArrayList<Integer>();
		 List<Integer> Greater = new ArrayList<Integer>();
		 List<Integer> Equity = new ArrayList<Integer>();
		   
		for(int counter = 0;counter<inputList.size();counter++){
			
			if(inputList.get(counter)<inputList.get(pivot))
			{
				lesser.add(inputList.get(counter));
				lTotal+=inputList.get(counter);
				
			}else if(inputList.get(counter)==inputList.get(pivot))
			{
				Equity.add(inputList.get(counter));
				eTotal+=inputList.get(counter);
				
			}else if(inputList.get(counter)>inputList.get(pivot)){
				
				Greater.add(inputList.get(counter));
				gTotal+=inputList.get(counter);	
			}
		}
		
		if(gTotal>cValue){
			int pIndex =  r.nextInt(Greater.size());
			System.out.println("Size of List greater: "+Greater.size());
			System.out.println("value of pIndex : "+pIndex);
			compute(Greater,pIndex);
			
		}else if(gTotal<=cValue){
			cValue = cValue-gTotal;
			digitCounter += Greater.size();
			
			int counter=0;
			int temp=0;
			while(counter<Equity.size())
			{
				temp+=Equity.get(counter);
				if(temp>cValue){
					return ++digitCounter;
				}else{
					// doubt
					counter++;
					digitCounter++;
				}
			}
			
			cValue = cValue-eTotal;	
			int pIndex =  r.nextInt(lesser.size());
			System.out.println("Size of List lesser: "+lesser.size());
			System.out.println("value of pIndex : "+pIndex);
			compute(lesser,pIndex);
		}
		
		return digitCounter;
	}
	
	@SuppressWarnings("resource")
	public static void main(String args[]){
		
		Scanner src = new Scanner(System.in);
		int n = src.nextInt();
		cValue = src.nextInt();
		
		List<Integer> inputList = new ArrayList<Integer>();
		
		for(int counter=0;counter<n;counter++){
			int input = src.nextInt();
			inputList.add(input);
		}
		
		int pivotIndex = r.nextInt(inputList.size());
		System.out.println("Size of List : "+inputList.size());
		System.out.println("value of pivot: "+pivotIndex);
		System.out.println(compute(inputList,pivotIndex));
	}
}
