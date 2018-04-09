package examples.test;

import java.util.LinkedList;
import JSHOP2.*;

public class problem
{
	private static String[] defineConstants()
	{
		String[] problemConstants = new String[3];

		problemConstants[0] = "obj5";
		problemConstants[1] = "obj7";
		problemConstants[2] = "obj8";

		return problemConstants;
	}

	private static void createState0(State s)	{
		s.add(new Predicate(0, 0, new TermList(TermConstant.getConstant(14), TermList.NIL)));
		s.add(new Predicate(7, 0, new TermList(TermConstant.getConstant(14), new TermList(TermConstant.getConstant(8), new TermList(TermConstant.getConstant(10), TermList.NIL)))));
		s.add(new Predicate(9, 0, new TermList(TermConstant.getConstant(14), new TermList(TermConstant.getConstant(8), new TermList(TermConstant.getConstant(11), TermList.NIL)))));
		s.add(new Predicate(2, 0, new TermList(TermConstant.getConstant(11), new TermList(TermConstant.getConstant(20), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(11), new TermList(new TermNumber(6.0), TermList.NIL))));
		s.add(new Predicate(2, 0, new TermList(TermConstant.getConstant(11), new TermList(TermConstant.getConstant(21), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(11), new TermList(new TermNumber(5.0), TermList.NIL))));
		s.add(new Predicate(2, 0, new TermList(TermConstant.getConstant(11), new TermList(TermConstant.getConstant(22), TermList.NIL))));
		s.add(new Predicate(3, 0, new TermList(TermConstant.getConstant(11), new TermList(new TermNumber(2.0), TermList.NIL))));
		s.add(new Predicate(17, 0, new TermList(TermConstant.getConstant(16), TermList.NIL)));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(14), TermList.NIL)));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(20), TermList.NIL)));
		s.add(new Predicate(1, 0, new TermList(new TermNumber(3.0), TermList.NIL)));
		s.add(new Predicate(1, 0, new TermList(new TermNumber(2.0), TermList.NIL)));
		s.add(new Predicate(1, 0, new TermList(new TermNumber(13.0), TermList.NIL)));
		s.add(new Predicate(1, 0, new TermList(new TermNumber(25.0), TermList.NIL)));
		s.add(new Predicate(1, 0, new TermList(new TermNumber(1.5), TermList.NIL)));
		s.add(new Predicate(1, 0, new TermList(new TermNumber(18.0), TermList.NIL)));
	}

	public static LinkedList<Plan> getPlans()
	{
		LinkedList<Plan> returnedPlans = new LinkedList<Plan>();
		TermConstant.initialize(23);

		Domain d = new test();

		d.setProblemConstants(defineConstants());

		State s = new State(20, d.getAxioms());

		JSHOP2.initialize(d, s);

		TaskList tl;
		SolverThread thread;

		createState0(s);

		tl = new TaskList(1, true);
		tl.subtasks[0] = new TaskList(new TaskAtom(new Predicate(1, 0, new TermList(new TermList(TermConstant.getConstant(8), new TermList(TermConstant.getConstant(17), new TermList(TermConstant.getConstant(16), TermList.NIL))), TermList.NIL)), false, false));

		thread = new SolverThread(tl, 12);
		thread.start();

		try {
			while (thread.isAlive())
				Thread.sleep(500);
		} catch (InterruptedException e) {
		}

		returnedPlans.addAll( thread.getPlans() );

		return returnedPlans;
	}

	public static LinkedList<Predicate> getFirstPlanOps() {
		return getPlans().getFirst().getOps();
	}
}