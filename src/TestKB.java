import static org.junit.Assert.*;

import org.junit.Test;

public class TestKB {

	
	
	@Test
	public void testKB( )
	{
		KnowledgeBase KB = new KnowledgeBase();
		KB.tell(new HornClause("A","B","C"));
		KB.tell(new HornClause("D","B","C"));
		KB.tell(new HornClause("D"));
		
		
		assertFalse(KB.entails(new HornClause("B")));
		
		
	}
}
