package model.searchRules;

import java.util.ArrayList;
import java.util.Iterator;

import model.Member;

public class EndsWithString implements ISearchRulesStrategy{

	@Override
	public ArrayList<Member> search(ArrayList<Member> searchList, String str) {
		
		//removes all items that does not match the pattern
		
		ArrayList<Member> tempList = new ArrayList<Member>(searchList);
		
		for (Iterator<Member> iterator = tempList.iterator(); iterator.hasNext(); ) {
			   
			Member member = iterator.next();
			
			if (!(member.getName().matches("(?i).*"+str))) {
				iterator.remove();
			}
		}
		return tempList;
	}
		
	}


