package examples.test;

import JSHOP2.*;

class Precondition0 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition0(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionNegation(new PreconditionAtomic(new Predicate(0, 5, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier), 5);
		p[2] = new PreconditionAtomic(new Predicate(1, 5, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		b = new Term[3][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[2] == null)
		{
			boolean b1changed = false;
			while (b[1] == null)
			{
				b[1] = p[1].nextBinding();
				if (b[1] == null)
					return null;
				b1changed = true;
			}
			if ( b1changed ) {
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
			}
			b[2] = p[2].nextBinding();
			if (b[2] == null) b[1] = null;
		}

		Term[] retVal = Term.merge(b, 3);
		b[2] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		b[1] = null;
		b[2] = null;
	}
}

class Precondition1 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition1(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionAtomic(new Predicate(2, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(0), TermList.NIL))), unifier);
		p[2] = new PreconditionAtomic(new Predicate(3, 5, new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(4), TermList.NIL))), unifier);
		b = new Term[3][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[2] == null)
		{
			boolean b1changed = false;
			while (b[1] == null)
			{
				b[1] = p[1].nextBinding();
				if (b[1] == null)
					return null;
				b1changed = true;
			}
			if ( b1changed ) {
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
			}
			b[2] = p[2].nextBinding();
			if (b[2] == null) b[1] = null;
		}

		Term[] retVal = Term.merge(b, 3);
		b[2] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		b[1] = null;
		b[2] = null;
	}
}

class Operator0 extends Operator
{
	public Operator0()
	{
		super(new Predicate(0, 5, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), -1, -1, new TermNumber(1.0));

		Term[] unifier;


		DelAddElement[] delIn = new DelAddElement[1];
		delIn[0] = new DelAddAtomic(new Predicate(1, 5));

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[1];
		unifier = new Term[5];

		unifier[0] = null;
		unifier[1] = null;
		unifier[2] = null;
		unifier[3] = null;
		unifier[4] = null;

		Predicate[] atoms0 = {
			new Predicate(4, 5, new TermList(TermVariable.getVariable(4), TermList.NIL)) };
		addIn[0] = new DelAddForAll(new Precondition1(unifier), atoms0);

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition0(unifier)).setComparator(new CompMore(2));
		p.reset();

		return p;
	}
}

class Precondition2 extends Precondition
{
	Precondition[] p;
	Term[] b;
	int whichClause;

	public Precondition2(Term[] unifier)
	{
		p = new Precondition[2];
		p[0] = new PreconditionAtomic(new Predicate(2, 4, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);

		p[1] = new PreconditionAtomic(new Predicate(3, 4, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))), unifier);

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		while (whichClause < 2)
		{
			b = p[whichClause].nextBinding();
			if (b != null)
				 return b;
			whichClause++;
		}

		return null;
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		whichClause = 0;
	}
}

class Precondition3 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition3(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new Precondition2(unifier);
		p[2] = new PreconditionAtomic(new Predicate(4, 4, new TermList(TermVariable.getVariable(3), TermList.NIL)), unifier);
		b = new Term[3][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[2] == null)
		{
			boolean b1changed = false;
			while (b[1] == null)
			{
				b[1] = p[1].nextBinding();
				if (b[1] == null)
					return null;
				b1changed = true;
			}
			if ( b1changed ) {
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
			}
			b[2] = p[2].nextBinding();
			if (b[2] == null) b[1] = null;
		}

		Term[] retVal = Term.merge(b, 3);
		b[2] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		b[1] = null;
		b[2] = null;
	}
}

class Operator1 extends Operator
{
	public Operator1()
	{
		super(new Predicate(1, 4, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(3), TermList.NIL))))), -1, -1, new TermNumber(1.0));


		DelAddElement[] delIn = new DelAddElement[0];

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[0];

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new Precondition3(unifier)).setComparator(new MyComparator(3));
		p.reset();

		return p;
	}
}

class Operator2 extends Operator
{
	public Operator2()
	{
		super(new Predicate(2, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), -1, -1, new TermCall(new List(new TermNumber(2.0), new TermList(TermVariable.getVariable(1), TermList.NIL)), StdLib.power, "StdLib.power"));


		DelAddElement[] delIn = new DelAddElement[0];

		setDel(delIn);

		DelAddElement[] addIn = new DelAddElement[0];

		setAdd(addIn);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		p = (new PreconditionCall(new TermCall(new List(TermVariable.getVariable(1), new TermList(new TermCall(new List(new TermNumber(1.01), new TermList(new TermNumber(2.0), TermList.NIL)), StdLib.plus, "StdLib.plus"), new TermList(new TermNumber(3.5), new TermList(new TermNumber(4.0), TermList.NIL)))), StdLib.less, "StdLib.less"), unifier)).setComparator(null);
		p.reset();

		return p;
	}
}

class Method0 extends Method
{
	public Method0()
	{
		super(new Predicate(1, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(5, 2, new TermList(TermVariable.getVariable(1), TermList.NIL)), unifier)).setComparator(null);
				p.setFirst(true);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method0Branch0";
			default: return null;
		}
	}
}

class Precondition4 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition4(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionAtomic(new Predicate(6, 7, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[2] = new PreconditionAtomic(new Predicate(7, 7, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);
		b = new Term[3][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[2] == null)
		{
			boolean b1changed = false;
			while (b[1] == null)
			{
				b[1] = p[1].nextBinding();
				if (b[1] == null)
					return null;
				b1changed = true;
			}
			if ( b1changed ) {
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
			}
			b[2] = p[2].nextBinding();
			if (b[2] == null) b[1] = null;
		}

		Term[] retVal = Term.merge(b, 3);
		b[2] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		b[1] = null;
		b[2] = null;
	}
}

class Precondition5 extends Precondition
{
	Precondition[] p;
	Term[] b;
	int whichClause;

	public Precondition5(Term[] unifier)
	{
		p = new Precondition[2];
		p[0] = new PreconditionAtomic(new Predicate(7, 7, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);

		p[1] = new PreconditionAtomic(new Predicate(9, 7, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), TermList.NIL)))), unifier);

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		while (whichClause < 2)
		{
			b = p[whichClause].nextBinding();
			if (b != null)
				 return b;
			whichClause++;
		}

		return null;
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		whichClause = 0;
	}
}

class Precondition6 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition6(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new Precondition5(unifier);
		p[2] = new PreconditionCall(new TermCall(new List(new TermNumber(2.0), new TermList(new TermNumber(2.5), new TermList(new TermNumber(2.5), new TermList(new TermNumber(3.1), TermList.NIL)))), StdLib.lessEq, "StdLib.lessEq"), unifier);
		b = new Term[3][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[2] == null)
		{
			boolean b1changed = false;
			while (b[1] == null)
			{
				b[1] = p[1].nextBinding();
				if (b[1] == null)
					return null;
				b1changed = true;
			}
			if ( b1changed ) {
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
			}
			b[2] = p[2].nextBinding();
			if (b[2] == null) b[1] = null;
		}

		Term[] retVal = Term.merge(b, 3);
		b[2] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		b[1] = null;
		b[2] = null;
	}
}

class Precondition7 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition7(Term[] unifier)
	{
		p = new Precondition[3];
		p[1] = new PreconditionCall(new TermCall(new List(TermVariable.getVariable(0), new TermList(new TermList(TermConstant.getConstant(8), new TermList(TermConstant.getConstant(10), new TermList(TermConstant.getConstant(11), TermList.NIL))), TermList.NIL)), StdLib.member, "StdLib.member"), unifier);
		p[2] = new PreconditionCall(new TermCall(new List(new TermNumber(2.0), new TermList(new TermNumber(1.0), TermList.NIL)), StdLib.less, "StdLib.less"), unifier);
		b = new Term[3][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[2] == null)
		{
			boolean b1changed = false;
			while (b[1] == null)
			{
				b[1] = p[1].nextBinding();
				if (b[1] == null)
					return null;
				b1changed = true;
			}
			if ( b1changed ) {
				p[2].reset();
				p[2].bind(Term.merge(b, 2));
			}
			b[2] = p[2].nextBinding();
			if (b[2] == null) b[1] = null;
		}

		Term[] retVal = Term.merge(b, 3);
		b[2] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		b[1] = null;
		b[2] = null;
	}
}

class Precondition8 extends Precondition
{
	Precondition[] p;
	Term[] b;
	int whichClause;

	public Precondition8(Term[] unifier)
	{
		p = new Precondition[2];
		p[0] = new PreconditionNegation(new PreconditionAtomic(new Predicate(0, 7, new TermList(TermConstant.getConstant(14), TermList.NIL)), unifier), 7);

		p[1] = new PreconditionAtomic(new Predicate(5, 7, new TermList(TermVariable.getVariable(5), TermList.NIL)), unifier);

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		p[0].bind(binding);
		p[1].bind(binding);
	}

	protected Term[] nextBindingHelper()
	{
		while (whichClause < 2)
		{
			b = p[whichClause].nextBinding();
			if (b != null)
				 return b;
			whichClause++;
		}

		return null;
	}

	protected void resetHelper()
	{
		p[0].reset();
		p[1].reset();
		whichClause = 0;
	}
}

class Precondition9 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition9(Term[] unifier)
	{
		p = new Precondition[7];
		p[1] = new PreconditionAtomic(new Predicate(0, 7, new TermList(TermVariable.getVariable(2), TermList.NIL)), unifier);
		p[2] = new Precondition6(unifier);
		p[3] = new PreconditionNegation(new Precondition7(unifier), 7);
		p[4] = new PreconditionCall(new TermCall(new List(new TermList(TermConstant.getConstant(0), new TermList(TermConstant.getConstant(7), new TermList(TermConstant.getConstant(9), TermList.NIL))), new TermList(new TermList(new TermList(TermConstant.getConstant(0), new TermList(TermConstant.getConstant(7), new TermList(TermConstant.getConstant(9), TermList.NIL))), new TermList(TermConstant.getConstant(12), new TermList(TermConstant.getConstant(13), TermList.NIL))), TermList.NIL)), StdLib.member, "StdLib.member"), unifier);
		p[5] = new PreconditionCall(new TermCall(new List(new TermCall(new List(new TermNumber(2.0), new TermList(new TermNumber(2.0), TermList.NIL)), StdLib.mult, "StdLib.mult"), new TermList(new TermList(new TermNumber(2.0), new TermList(new TermNumber(3.0), new TermList(new TermCall(new List(new TermNumber(1.0), new TermList(new TermNumber(3.0), TermList.NIL)), StdLib.plus, "StdLib.plus"), new TermList(new TermNumber(5.0), TermList.NIL)))), TermList.NIL)), StdLib.member, "StdLib.member"), unifier);
		p[6] = new Precondition8(unifier);
		b = new Term[7][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[6] == null)
		{
			boolean b5changed = false;
			while (b[5] == null)
			{
				boolean b4changed = false;
				while (b[4] == null)
				{
					boolean b3changed = false;
					while (b[3] == null)
					{
						boolean b2changed = false;
						while (b[2] == null)
						{
							boolean b1changed = false;
							while (b[1] == null)
							{
								b[1] = p[1].nextBinding();
								if (b[1] == null)
									return null;
								b1changed = true;
							}
							if ( b1changed ) {
								p[2].reset();
								p[2].bind(Term.merge(b, 2));
							}
							b[2] = p[2].nextBinding();
							if (b[2] == null) b[1] = null;
							b2changed = true;
						}
						if ( b2changed ) {
							p[3].reset();
							p[3].bind(Term.merge(b, 3));
						}
						b[3] = p[3].nextBinding();
						if (b[3] == null) b[2] = null;
						b3changed = true;
					}
					if ( b3changed ) {
						p[4].reset();
						p[4].bind(Term.merge(b, 4));
					}
					b[4] = p[4].nextBinding();
					if (b[4] == null) b[3] = null;
					b4changed = true;
				}
				if ( b4changed ) {
					p[5].reset();
					p[5].bind(Term.merge(b, 5));
				}
				b[5] = p[5].nextBinding();
				if (b[5] == null) b[4] = null;
				b5changed = true;
			}
			if ( b5changed ) {
				p[6].reset();
				p[6].bind(Term.merge(b, 6));
			}
			b[6] = p[6].nextBinding();
			if (b[6] == null) b[5] = null;
		}

		Term[] retVal = Term.merge(b, 7);
		b[6] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		p[5].reset();
		p[6].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
		b[5] = null;
		b[6] = null;
	}
}

class Method1 extends Method
{
	public Method1()
	{
		super(new Predicate(1, 7, new TermList(new TermList(TermVariable.getVariable(0), TermVariable.getVariable(1)), TermList.NIL)));
		TaskList[] subsIn = new TaskList[2];

		subsIn[0] = createTaskList0();
		subsIn[1] = createTaskList1();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 7, new TermList(new TermNumber(1.0), new TermList(new TermList(TermConstant.getConstant(8), TermList.NIL), new TermList(TermVariable.getVariable(4), TermList.NIL)))), false, true));

		return retVal;
	}

	TaskList createTaskList1()
	{
		TaskList retVal;

		retVal = new TaskList(3, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 7, new TermList(TermVariable.getVariable(5), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(4), TermList.NIL)))), false, true));
		retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(1, 7, new TermList(TermVariable.getVariable(2), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(3), new TermList(TermVariable.getVariable(6), TermList.NIL))))), false, true));
		retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(2, 7, TermList.NIL), false, false));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition4(unifier)).setComparator(null);
			break;
			case 1:
				p = (new Precondition9(unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method1Branch0";
			case 1: return "Method1Branch1";
			default: return null;
		}
	}
}

class Precondition10 extends Precondition
{
	Precondition[] p;
	Term[][] b;

	public Precondition10(Term[] unifier)
	{
		p = new Precondition[5];
		p[1] = new PreconditionAtomic(new Predicate(15, 4, new TermList(TermConstant.getConstant(8), new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(new TermNumber(1.5), new TermList(new TermNumber(2.0), new TermList(new TermNumber(2.0), TermList.NIL))), StdLib.mult, "StdLib.mult"), TermList.NIL))))), unifier);
		p[2] = new PreconditionNegation(new PreconditionAtomic(new Predicate(17, 4, new TermList(TermConstant.getConstant(16), TermList.NIL)), unifier), 4);
		p[3] = new PreconditionAssign(new TermList(new TermNumber(12.0), new TermList(new TermCall(new List(new TermNumber(12.0), new TermList(new TermNumber(6.0), new TermList(new TermNumber(5.0), TermList.NIL))), StdLib.div, "StdLib.div"), new TermList(new TermList(TermVariable.getVariable(0), new TermList(TermConstant.getConstant(0), new TermList(TermConstant.getConstant(7), TermConstant.getConstant(9)))), TermList.NIL))), unifier, 2);
		p[4] = new PreconditionAssign(new TermList(TermConstant.getConstant(18), new TermList(new TermCall(new List(new TermNumber(29.0), new TermList(new TermNumber(-12.5), new TermList(new TermCall(new List(new TermNumber(2.0), new TermList(new TermNumber(2.0), new TermList(new TermNumber(3.0), TermList.NIL))), StdLib.power, "StdLib.power"), new TermList(TermVariable.getVariable(1), new TermList(new TermCall(new List(new TermNumber(2.0), new TermList(new TermNumber(12.0), new TermList(new TermNumber(5.0), TermList.NIL))), StdLib.minus, "StdLib.minus"), TermList.NIL))))), StdLib.plus, "StdLib.plus"), TermList.NIL)), unifier, 3);
		b = new Term[5][];
		b[0] = unifier;
		b[0] = Term.merge( b, 1 );

		setFirst(false);
	}

	public void bind(Term[] binding)
	{
		b[0] = binding;
		b[0] = Term.merge( b, 1 );
		p[1].bind(binding);
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
	}

	protected Term[] nextBindingHelper()
	{
		while (b[4] == null)
		{
			boolean b3changed = false;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding();
						if (b[1] == null)
							return null;
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset();
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding();
					if (b[2] == null) b[1] = null;
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset();
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding();
				if (b[3] == null) b[2] = null;
				b3changed = true;
			}
			if ( b3changed ) {
				p[4].reset();
				p[4].bind(Term.merge(b, 4));
			}
			b[4] = p[4].nextBinding();
			if (b[4] == null) b[3] = null;
		}

		Term[] retVal = Term.merge(b, 5);
		b[4] = null;
		return retVal;
	}

	protected void resetHelper()
	{
		p[1].reset();
		p[2].reset();
		p[3].reset();
		p[4].reset();
		b[1] = null;
		b[2] = null;
		b[3] = null;
		b[4] = null;
	}
}

class Method2 extends Method
{
	public Method2()
	{
		super(new Predicate(2, 4, TermList.NIL));
		TaskList[] subsIn = new TaskList[1];

		subsIn[0] = createTaskList0();

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 4, new TermList(new TermList(TermVariable.getVariable(2), TermVariable.getVariable(3)), new TermList(new TermCall(new List(new TermNumber(1.0), new TermList(new TermCall(new List(new TermNumber(1.0), new TermList(new TermNumber(1.0), TermList.NIL)), test.calculateMyFunc, "test.calculateMyFunc"), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new Precondition10(unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method2Branch0";
			default: return null;
		}
	}
}

class Method3 extends Method
{
	public Method3()
	{
		super(new Predicate(0, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)));
		TaskList[] subsIn = new TaskList[2];

		subsIn[0] = createTaskList0();
		subsIn[1] = TaskList.empty;

		setSubs(subsIn);
	}

	TaskList createTaskList0()
	{
		TaskList retVal;

		retVal = new TaskList(1, true);
		retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(3, 1, TermList.NIL), false, true));

		return retVal;
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(0, 1, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier)).setComparator(null);
			break;
			case 1:
				p = (new PreconditionNil(1)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Method3Branch0";
			case 1: return "Method3Branch1";
			default: return null;
		}
	}
}

class Axiom0 extends Axiom
{
	public Axiom0()
	{
		super(new Predicate(15, 3, new TermList(TermVariable.getVariable(0), new TermList(new TermList(TermVariable.getVariable(1), new TermList(TermConstant.getConstant(19), new TermList(TermVariable.getVariable(2), TermList.NIL))), new TermList(new TermCall(new List(new TermNumber(1.0), new TermList(new TermNumber(1.0), TermList.NIL)), StdLib.plus, "StdLib.plus"), new TermList(new TermCall(new List(new TermNumber(6.0), new TermList(new TermNumber(1.0), TermList.NIL)), StdLib.power, "StdLib.power"), TermList.NIL))))), 2);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(9, 3, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), new TermList(TermVariable.getVariable(2), TermList.NIL)))), unifier)).setComparator(null);
			break;
			case 1:
				p = (new PreconditionAtomic(new Predicate(15, 3, new TermList(TermVariable.getVariable(1), new TermList(new TermList(TermVariable.getVariable(0), new TermList(TermConstant.getConstant(19), new TermList(TermVariable.getVariable(2), TermList.NIL))), new TermList(new TermNumber(2.0), new TermList(new TermCall(new List(new TermNumber(3.0), new TermList(new TermCall(new List(new TermNumber(1.5), new TermList(new TermNumber(2.0), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.plus, "StdLib.plus"), TermList.NIL))))), unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Axiom0Branch0";
			case 1: return "Axiom0Branch1";
			default: return null;
		}
	}
}

class Axiom1 extends Axiom
{
	public Axiom1()
	{
		super(new Predicate(6, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)), 2);
	}

	public Precondition getIterator(Term[] unifier, int which)
	{
		Precondition p;

		switch (which)
		{
			case 0:
				p = (new PreconditionAtomic(new Predicate(2, 2, new TermList(TermVariable.getVariable(0), new TermList(TermVariable.getVariable(1), TermList.NIL))), unifier)).setComparator(null);
			break;
			case 1:
				p = (new PreconditionAtomic(new Predicate(0, 2, new TermList(TermVariable.getVariable(0), TermList.NIL)), unifier)).setComparator(null);
			break;
			default:
				return null;
		}

		p.reset();

		return p;
	}

	public String getLabel(int which)
	{
		switch (which)
		{
			case 0: return "Axiom1Branch0";
			case 1: return "Axiom1Branch1";
			default: return null;
		}
	}
}

public class test extends Domain
{
	public static MyFunc calculateMyFunc = new MyFunc();

	public test()
	{
		TermVariable.initialize(7);

		constants = new String[20];
		constants[0] = "a";
		constants[1] = "t";
		constants[2] = "q";
		constants[3] = "r";
		constants[4] = "s";
		constants[5] = "v";
		constants[6] = "ax2";
		constants[7] = "b";
		constants[8] = "obj2";
		constants[9] = "c";
		constants[10] = "obj3";
		constants[11] = "obj4";
		constants[12] = "d";
		constants[13] = "e";
		constants[14] = "obj1";
		constants[15] = "ax1";
		constants[16] = "uuu";
		constants[17] = "ttt";
		constants[18] = "www";
		constants[19] = "yyy";

		compoundTasks = new String[3];
		compoundTasks[0] = "m3";
		compoundTasks[1] = "m1";
		compoundTasks[2] = "m2";

		primitiveTasks = new String[4];
		primitiveTasks[0] = "!op0";
		primitiveTasks[1] = "!op1";
		primitiveTasks[2] = "!op2";
		primitiveTasks[3] = "!op4";

		methods = new Method[3][];

		methods[0] = new Method[1];
		methods[0][0] = new Method3();

		methods[1] = new Method[2];
		methods[1][0] = new Method0();
		methods[1][1] = new Method1();

		methods[2] = new Method[1];
		methods[2][0] = new Method2();


		ops = new Operator[4][];

		ops[0] = new Operator[1];
		ops[0][0] = new Operator0();

		ops[1] = new Operator[1];
		ops[1][0] = new Operator1();

		ops[2] = new Operator[1];
		ops[2][0] = new Operator2();

		ops[3] = new Operator[0];

		axioms = new Axiom[20][];

		axioms[0] = new Axiom[0];

		axioms[1] = new Axiom[0];

		axioms[2] = new Axiom[0];

		axioms[3] = new Axiom[0];

		axioms[4] = new Axiom[0];

		axioms[5] = new Axiom[0];

		axioms[6] = new Axiom[1];
		axioms[6][0] = new Axiom1();

		axioms[7] = new Axiom[0];

		axioms[8] = new Axiom[0];

		axioms[9] = new Axiom[0];

		axioms[10] = new Axiom[0];

		axioms[11] = new Axiom[0];

		axioms[12] = new Axiom[0];

		axioms[13] = new Axiom[0];

		axioms[14] = new Axiom[0];

		axioms[15] = new Axiom[1];
		axioms[15][0] = new Axiom0();

		axioms[16] = new Axiom[0];

		axioms[17] = new Axiom[0];

		axioms[18] = new Axiom[0];

		axioms[19] = new Axiom[0];

	}
}