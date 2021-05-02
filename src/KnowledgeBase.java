import java.util.LinkedList;

public class KnowledgeBase {

	
	LinkedList<HornClause> statements;
	
	public KnowledgeBase()
	{
		statements = new LinkedList<HornClause>( );
		
	}
	
	public void tell(HornClause clause)
	{
		boolean done = true;
		
		while (!done) {
			done = true;
			
			LinkedList<HornClause> toAdd = new LinkedList<HornClause>( );
			for (HornClause C : statements)
			{
				HornClause result = C.unify(clause);
				
				if (result.atoms.size() != 0) {
					toAdd.add(result);
					done = false;
				}
			}
			
			if (toAdd.size() > 0) done = false;
			statements.addAll(toAdd);
		}
		statements.add(clause);
		
	}
	
	public boolean entails(HornClause clause)
	{
		for(HornClause C : statements)
		{
			if (C.unify(clause).atoms.size() == 0) return true;
		}
		
		return false;
	}
	
}
