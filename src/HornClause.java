import java.util.LinkedList;

public class HornClause {

	LinkedList<Atom> atoms;
	
	
	public HornClause(HornClause copy)
	{
		this.atoms = new LinkedList<Atom>( );
		this.atoms.addAll(copy.atoms);
	}
	
	public HornClause(Atom ...atoms)
	{
		this.atoms = new LinkedList<Atom>( );
		for (int i = 0; i < atoms.length; i++)
		{
			this.atoms.add( atoms[i]);
		}
	}
	
	public HornClause(String ...atoms)
	{
		this.atoms = new LinkedList<Atom>( );
		for (int i = 0; i < atoms.length; i++)
		{
			this.atoms.add( new Atom(atoms[i]));
		}
	}
	
	public HornClause unify( HornClause other)
	{
		// if this is a,b,c  and the other is a,c
		// unify turns into: b
		
		HornClause result = new HornClause( this );
		result.atoms.removeAll(other.atoms);
		
		return result;
	}
	
	
	public String toString( )
	{
		StringBuffer buff = new StringBuffer( );
		for (Atom a : this.atoms)
		{
			if (buff.length() > 0) buff.append("^");
			buff.append(a.name);
		}
		
		return buff.toString();
	}
}
