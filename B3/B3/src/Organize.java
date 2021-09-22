import java.util.*;
public class Organize {
	
	public static void org() throws Exception {
		//ArrayList of words in the poem
		ArrayList<String> w = new ArrayList<>();
		
		Poem.getPoemWords(w);
		
		String[] words = w.toArray(new String[0]);
		
		//For finding the getting rid of duplicates
		String[] un = new String[words.length];
		
		for(int i = 0; i < words.length; i++) {
			un[i] = words[i];
		}
		
		for(int i = 0; i < un.length; i++){
	         if(un[i] != null){
	         
	        	 for(int j = i + 1; j < un.length; j++){
	             
	        		 if(un[i].equals(un[j])){
	        			 un[j] = null;
	        		 }
	        	 }
	         }
	     }
		
		//For finding the amount of duplicate words
		int count = 0;
		for(int i = 0; i < un.length; i++) {
			if(un[i] == null) {
				count++;
			}
		}
		
		int nL = un.length - count; //the number of words
		
		//new string of all words
		String[] uni = new String[nL];
		
		int s = 0;
		for(int i = 0; i < un.length; i++) {
			if(un[i] != null) {
				uni[s] = un[i];
				s++;
			}
		}
		
		//finds how many times each word is in the poem
		List<List<String>> occur = new ArrayList<List<String>>();
		
		for(int i = 0; i < uni.length; i++) {
			List<String> temp = new ArrayList<>();
			temp.add(uni[i]);
			String t = uni[i];
			
			int cou = 0;
			
			for(int j = 0; j < words.length; j++) {
				
				if(t.equals(words[j])) {					
					cou++;
				}
			}
			String co = Integer.toString(cou);
			temp.add(co);
			
			occur.add(temp);			
		}
		
		//changes to integer to help organize
		List<List<Integer>> order = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < uni.length; i++) {
			List<Integer> temp = new ArrayList<>();
			temp.add(i);
			temp.add(Integer.parseInt(occur.get(i).get(1)));
			order.add(temp);
		}
		
		sor(order);
		
		//changes back to word and frequency
		List<List<String>> organized = new ArrayList<List<String>>();
		
		for(int i = 0; i < uni.length; i++) {
			List<String> temp = new ArrayList<>();
			temp.addAll(occur.get(order.get(i).get(0)));
			organized.add(temp);
		}
		
		//prints in pairs
		for(int i = 0; i < nL; i ++) {
			System.out.println(organized.get(i));
		}		
		
	}
	
	public static void sor(List<List<Integer>> order) {
		Collections.sort(order, new Comparator<List<Integer>>() {
            
	          @Override              
	          public int compare(List<Integer> entry1, List<Integer> entry2) {
	        	  return entry2.get(1).compareTo(entry1.get(1));
	          }
	        });
	}

}
