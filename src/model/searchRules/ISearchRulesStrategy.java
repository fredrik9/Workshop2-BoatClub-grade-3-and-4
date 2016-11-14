package model.searchRules;

import java.util.ArrayList;

import model.Member;

public interface ISearchRulesStrategy {

	public ArrayList<Member> search(ArrayList<Member> searchList, String str);
	
}
