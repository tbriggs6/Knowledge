import static org.junit.Assert.*;

import org.junit.Test;

public class TestHorn {

	@Test
	public void test() {

		HornClause A = new HornClause("A");
		HornClause AB = new HornClause("A","B");
		HornClause ABC = new HornClause("A","B", "C");
		
		System.out.println(AB.unify(ABC));
		System.out.println(ABC.unify(AB));
		System.out.println(AB.unify(A));
		System.out.println(ABC.unify(A));
	}

}
