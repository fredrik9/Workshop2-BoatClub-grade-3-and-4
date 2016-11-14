package model.searchRules;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import model.Member;

public class CompositeSearch implements ISearchRulesStrategy {

	ArrayList<ISearchRulesStrategy> m_rules;
	ArrayList<String> m_operators;
	ArrayList<String> m_searchFor = new ArrayList<String>();
	ISearchRulesStrategy m_rule;

	public CompositeSearch() {

		m_rules = new ArrayList<ISearchRulesStrategy>();
		m_operators = new ArrayList<String>();
	}

	@Override
	public ArrayList<Member> search(ArrayList<Member> searchList, String str) {

		// list of result and 2 templists to handle the searching
		ArrayList<Member> result = new ArrayList<Member>();
		ArrayList<Member> tempList = new ArrayList<Member>();
		ArrayList<Member> tempList2 = new ArrayList<Member>();
		int i = 0;

		Iterator<ISearchRulesStrategy> iterator = m_rules.iterator();
		for (; iterator.hasNext();) {

			m_rule = iterator.next();
			// the || operator choice
			if (m_operators.get(i).equals("||")) {
				tempList = new ArrayList<Member>(m_rule.search(searchList, m_searchFor.get(i)));
				// no duplicates and adding them together
				tempList2.removeAll(tempList);
				tempList2.addAll(tempList);
			}
			// the && operator choice
			else if (m_operators.get(i).equals("&&")) {
				// removing from the added list
				tempList2 = new ArrayList<Member>(m_rule.search(tempList2, m_searchFor.get(i)));

				if (iterator.hasNext() && m_operators.get(i + 1).equals("||") || !iterator.hasNext()) {
					for (Member member : tempList2) {
						try {
							ByteArrayOutputStream bos = new ByteArrayOutputStream();
							ObjectOutputStream oos = new ObjectOutputStream(bos);
							oos.writeObject(member);
							oos.flush();
							oos.close();
							bos.close();
							byte[] byteData = bos.toByteArray();

							ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
							Member temp;
							temp = (Member) new ObjectInputStream(bais).readObject();
							result.add(temp);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

			}
			i++;
		}

		// if the last operator is not || then it needs to add again
		if (m_operators.get(i - 1).equals("||")) {
			result.removeAll(tempList2);
			result.addAll(tempList2);
		}
		return result;
	}

	public void add(String operator, ISearchRulesStrategy a_rule, String searchFor) {
		m_rules.add(a_rule);
		m_operators.add(operator);
		m_searchFor.add(searchFor);
	}
}
