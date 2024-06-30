import java.util.*;

public class Team_Analytics {

      	
public static int alpha (int[] keys) {
         
		int noFlipSum =0;
		int n = keys.length;
		for(int i = 0; i<n; i++) {
					if((i%2) == 0) {
						noFlipSum += keys[i];
					}
		}
		
	
		int [] rightGain = new int[n/2];
		int [] leftGain = new int[n/2];
		int gainPointer = 0;
		int subLeft;
		int subRight;
		
		for(int i=0; i<n; i++) {
			 if(i%2 == 0) {
				 continue;
			 }
			 else {
				 if(i == n-1) {
					 
					 subRight =0;
					 
					 
				 }
				 else {
					 
					 subRight = keys[i] - keys[i+1];
					 
				 }
				 
				 subLeft = keys[i] - keys[i-1];
				 
				 
				 if(gainPointer == 0) {
					 
					 rightGain[gainPointer] = subRight;
					 leftGain[gainPointer] = subLeft;
				 }
				 
				 else {
					 
					 if(rightGain[gainPointer - 1] >=0) {
						 
						 rightGain[gainPointer] = rightGain[gainPointer - 1] + subRight;
					 }
					 else {
						 rightGain[gainPointer] = subRight;
						 
					 }
					 
					 if(leftGain[gainPointer - 1] >=0) {
						 
						 leftGain[gainPointer] = leftGain[gainPointer - 1] + subLeft;
					 }
					 else {
						 leftGain[gainPointer] = subLeft;
						 
					 }
					 
					 
				 }
				 gainPointer++;
				 
				 
				 
				 
			 }
			 
			 
		
		}
		
		int maxRightGain =0;
		int maxLeftGain = 0;
		
		for(int j =0; j<n/2; j++) {
			
			if(rightGain[j] > maxRightGain) {
				
				maxRightGain = rightGain[j];
			}
			
		}
		
		
		for(int j =0; j<n/2; j++) {
			
			if(leftGain[j] > maxLeftGain) {
				
				maxLeftGain = leftGain[j];
			}
			
		}
		
		int finalMax = Math.max(maxRightGain, maxLeftGain);
		int maxPower = noFlipSum + finalMax;
		
		
		return maxPower;
		
		
		
				
		
		
		
         
		

	}	
	
	
public static int[] alphaRec (int[] keys) {

			
		    int max = alpha(keys);
		    
		    
		    int [] result = new int [2];
			int noFlipSum =0;
			int n = keys.length;
					for(int i = 0; i<n; i++) {
						if((i%2) == 0) {
							noFlipSum += keys[i];
						}
					}
					
			if(max == noFlipSum) {
				
				result[0] = -1;
				result[1] = -1;
				//System.out.println("No reverse needed");
				return result;
				
				
				
			}
			
			else {	
				int start =0;
				while(start<n-1) {
					int end = start+1;
					for(int j = end; j<n;j++) {
						boolean even = true;
						int tmpSum = 0;
						int count =0;
						int pointer = 0;
						while(count <n) {
							
							if(pointer == start) {
								
								for(int m=j; m>=start;m--) {
									
									if(even) {
										tmpSum += keys[m];
										even = false;
										count++;
							
										
									}
									else {
										count++;
										even =true;
										
									}}	
								pointer = j+1;
							}
							
							else {
								if(even) {
									
									tmpSum += keys[pointer];
									pointer++;
									count++;
									even=false;
								}
								else {
									count++;
									pointer++;
									even =true;
									
								}
								
							}
							
							
							
							
						}
						if(tmpSum == max) {
						    int [] result1 = new int [2];
						    result1[0] = start;
						    result1[1] = j;
						    //System.out.println("from index " + result1[0] + " to index " + result1[1]);
						    return result1;
						}

						
						
					}
					
					
					
					start++;
					
				}
				
				
			}
			
			return result;
}
    
    
    
    
    
   
	





	
public static void main (String [] args) {
		int [] test = {1,3,2,4};
		
		System.out.println(alpha(test));
		
		System.out.println(Arrays.toString(alphaRec(test)));
		
		
		
		
		
		
	}
	
	
	
}
