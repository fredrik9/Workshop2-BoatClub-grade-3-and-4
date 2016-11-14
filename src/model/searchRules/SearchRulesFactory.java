package model.searchRules;

public class SearchRulesFactory {

	 public ISearchRulesStrategy GetSearchRuleContains() {
		    return new ContainsString();
		  }
	 
	 public ISearchRulesStrategy GetSearchRuleBegins() {
		    return new BeginsWithString();
		  }
	 
	 public ISearchRulesStrategy GetSearchRuleEnds() {
		    return new EndsWithString();
		  }
	
}
