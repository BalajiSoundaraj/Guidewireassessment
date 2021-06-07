package disp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	List<Integer> lengthStorer = new ArrayList<>();
	public static void main(String args[])
	{
		Solution s = new Solution();
	
		System.out.println(s.solution("azABaabba"));
	//	System.out.println(s.solution("Baab"));
		
	}
	
	public int solution(String S) {
        // write your code in Java SE 8
        int initialIndex = 0;
        int indexInc = 2;
        int smallestLength = 0;
     //   List<Integer> lengthStorer = new ArrayList<>();
        for(int i=0; i<S.length(); i++)
        {
        	
        	if(indexInc<=S.length())
        	{
        		
        		String fragment = S.substring(0, indexInc);
        		 
        		//boolean op = caseChecker(fragment);
        		boolean op = false;
        		
        		if((balanceChecker(fragment)))
        		{
        			op = caseChecker(fragment);
        			if(op)
        			{
        				
        				 lengthStorer.add(fragment.length());
        			}
        		}
        		System.out.println(S.substring(0, indexInc) + "***"+ op);
        	}
        	
        	indexInc++;
        	if(i==S.length()-1)
        	{
        		solution(S.substring(++initialIndex, S.length()));
        	}
        	
        }
        Collections.sort(lengthStorer);
        return lengthStorer.get(0);        
    }

		private boolean balanceChecker(String fragment) {
			// TODO Auto-generated method stub
			char[] fragmenter = fragment.toCharArray();
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for(Character ch: fragmenter)
			{
				char a = Character.toLowerCase(ch);
				
				if(map.containsKey(a))
				{
					map.put(a, map.get(a)+1);
				}
				else
				{
					map.put(a, 0);
				}
			}
			Set<Character> mapIterator =  map.keySet();
			int count = 0;
			boolean validChecker =  true;
			for(Character ch: mapIterator)
			{
				char a = Character.toLowerCase(ch);
				if(map.get(a)>=1 && validChecker)
				{
					validChecker = true;
				}
				else
				{
					validChecker = false;
				}
			}
				
			return validChecker;
			
		}
	
		private boolean caseChecker(String fragment) {
			
			boolean caseFinaliser = false;
			char chToUse = ' ';
			char[] fragArray = fragment.toCharArray();
			Map<Character, Boolean> map = new HashMap<Character, Boolean>();
			for(Character ch: fragArray)
			{
				map.put(Character.toUpperCase(ch), false);
			}
			for(Map.Entry<Character, Boolean> mapIterate: map.entrySet())
			{
				char chToChk = mapIterate.getKey();
				for(int i=0; i<fragment.length(); i++)
				{
					if(fragArray[i]==Character.toLowerCase(chToChk))
					{
						map.put(chToChk, true);	
					}
					else
					{
						map.put(chToChk, false);
					}
				}
			}
			boolean boolChecker = true;
			for(Map.Entry<Character, Boolean> mapIterate: map.entrySet())
			{
				boolChecker = true;
				if(mapIterate.getValue()==true && boolChecker == true)
				{
					
				}
				else
				{
					boolChecker = false;
				}
			}
			System.out.println(map);
			return boolChecker;
			/*
			 * for(int i=0; i<fragment.length(); i++) {
			 * if(Character.isUpperCase(fragArray[i])) { chToUse =
			 * Character.toLowerCase(fragArray[i]); }
			 * if(Character.isLowerCase(fragArray[i])) { chToUse =
			 * Character.toUpperCase(fragArray[i]); } for(int j=0;
			 * j<fragment.length()&&i!=j; j++) { if(chToUse==fragArray[j]) { caseFinaliser =
			 * true; } } } return caseFinaliser;
			 *//*
			 * 
			 * // TODO Auto-generated method stub char[] fragmenter = new
			 * char[fragment.length()]; fragmenter = fragment.toCharArray(); int
			 * upperCaseCount = 0; int lowerCaseCount = 0;
			 * 
			 * for(int i=0; i<fragment.length(); i++) {
			 * 
			 * //
			 * 
			 * 
			 * if(Character.isUpperCase(fragmenter[i])==true) { upperCaseCount++; }
			 * if(Character.isLowerCase(fragmenter[i])==true) { lowerCaseCount++; } } int
			 * maxCount = 0; if(upperCaseCount>lowerCaseCount) {
			 * if(upperCaseCount/lowerCaseCount>=upperCaseCount/2) {
			 * 
			 * } } if(lowerCaseCount>upperCaseCount) {
			 * if(lowerCaseCount/upperCaseCount>=lowerCaseCount/2) {
			 * 
			 * } } if(upperCaseCount==lowerCaseCount) { return true; }
			 * 
			 * 
			 * try { if(upperCaseCount==lowerCaseCount || upperCaseCount/lowerCaseCount>=1
			 * || lowerCaseCount/upperCaseCount >=1) { return true; } } catch(Exception e) {
			 * // do nothing }
			 * 
			 * {
			 * 
			 * } return false;
			 * 
			 */}

		
	
}
