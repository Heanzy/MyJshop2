package examples.freecell;

import java.util.LinkedList;
import JSHOP2.*;

public class problem
{
	private static String[] defineConstants()
	{
		String[] problemConstants = new String[0];


		return problemConstants;
	}

	private static void createState0(State s)	{
		s.add(new Predicate(6, 0, new TermList(new TermNumber(0.0), TermList.NIL)));
		s.add(new Predicate(8, 0, new TermList(new TermNumber(5.0), TermList.NIL)));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(1.0), new TermList(TermList.NIL, new TermList(TermList.NIL, TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(1.0), new TermList(TermList.NIL, new TermList(TermList.NIL, TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(1.0), new TermList(TermList.NIL, new TermList(TermList.NIL, TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(1.0), new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(1.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(2.0), new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(1.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(2.0), new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(1.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(2.0), new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(1.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(2.0), new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(2.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(3.0), new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(2.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(3.0), new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(2.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(3.0), new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(2.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(3.0), new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(3.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(4.0), new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(3.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(4.0), new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(3.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(4.0), new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(3.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(4.0), new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(4.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(5.0), new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(4.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(5.0), new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(4.0), TermList.NIL))))));
		s.add(new Predicate(5, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(5.0), new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(4.0), TermList.NIL))))));
	}

	public static LinkedList<Plan> getPlans()
	{
		LinkedList<Plan> returnedPlans = new LinkedList<Plan>();
		TermConstant.initialize(14);

		Domain d = new freecell();

		d.setProblemConstants(defineConstants());

		State s = new State(14, d.getAxioms());

		JSHOP2.initialize(d, s);

		TaskList tl;
		SolverThread thread;

		createState0(s);

		tl = new TaskList(2, true);
		tl.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 0, TermList.NIL), false, true));
		tl.subtasks[1] = new TaskList(4, false);
		tl.subtasks[1].subtasks[0] = new TaskList(5, true);
		tl.subtasks[1].subtasks[0].subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(1.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[0].subtasks[1] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(2.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[0].subtasks[2] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(3.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[0].subtasks[3] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(4.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[0].subtasks[4] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(0), new TermList(new TermNumber(5.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[1] = new TaskList(5, true);
		tl.subtasks[1].subtasks[1].subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(1.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[1].subtasks[1] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(2.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[1].subtasks[2] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(3.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[1].subtasks[3] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(4.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[1].subtasks[4] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(2), new TermList(new TermNumber(5.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[2] = new TaskList(5, true);
		tl.subtasks[1].subtasks[2].subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(1.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[2].subtasks[1] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(2.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[2].subtasks[2] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(3.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[2].subtasks[3] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(4.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[2].subtasks[4] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(3), new TermList(new TermNumber(5.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[3] = new TaskList(4, true);
		tl.subtasks[1].subtasks[3].subtasks[0] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(1.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[3].subtasks[1] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(2.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[3].subtasks[2] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(3.0), TermList.NIL))), false, false));
		tl.subtasks[1].subtasks[3].subtasks[3] = new TaskList(new TaskAtom(new Predicate(2, 0, new TermList(TermConstant.getConstant(4), new TermList(new TermNumber(4.0), TermList.NIL))), false, false));

		thread = new SolverThread(tl, 1);
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