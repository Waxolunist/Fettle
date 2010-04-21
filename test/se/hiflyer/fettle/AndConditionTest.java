package se.hiflyer.fettle;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static se.mockachino.Mockachino.mock;
import static se.mockachino.Mockachino.stubReturn;

public class AndConditionTest {

	@Test
	public void twoWayAnd() {
		Condition cond1 = mock(Condition.class);
		Condition cond2 = mock(Condition.class);

		Condition condition = BasicConditions.and(cond1, cond2);

		assertFalse(condition.isSatisfied());

		stubReturn(true).on(cond1).isSatisfied();
		stubReturn(false).on(cond2).isSatisfied();
		assertFalse(condition.isSatisfied());

		stubReturn(false).on(cond1).isSatisfied();
		stubReturn(true).on(cond2).isSatisfied();
		assertFalse(condition.isSatisfied());

		stubReturn(true).on(cond1).isSatisfied();
		stubReturn(true).on(cond2).isSatisfied();
		assertTrue(condition.isSatisfied());
	}


	@Test
	public void satisfied() {
		Condition cond1 = mock(Condition.class);
		Condition cond2 = mock(Condition.class);
		Condition cond3 = mock(Condition.class);
		Condition condition = BasicConditions.and(cond1, cond2, cond3);

		assertFalse(condition.isSatisfied());

		stubReturn(true).on(cond1).isSatisfied();
		stubReturn(true).on(cond2).isSatisfied();
		stubReturn(true).on(cond3).isSatisfied();

		assertTrue(condition.isSatisfied());
	}

	@Test
	public void notSatisfied() {
		Condition cond1 = mock(Condition.class);
		Condition cond2 = mock(Condition.class);
		Condition cond3 = mock(Condition.class);
		Condition condition = BasicConditions.and(cond1, cond2, cond3);

		assertFalse(condition.isSatisfied());

		stubReturn(true).on(cond1).isSatisfied();
		stubReturn(false).on(cond2).isSatisfied();
		stubReturn(false).on(cond3).isSatisfied();
		assertFalse(condition.isSatisfied());

		stubReturn(false).on(cond1).isSatisfied();
		stubReturn(true).on(cond2).isSatisfied();
		stubReturn(false).on(cond3).isSatisfied();
		assertFalse(condition.isSatisfied());

		stubReturn(false).on(cond1).isSatisfied();
		stubReturn(false).on(cond2).isSatisfied();
		stubReturn(true).on(cond3).isSatisfied();
		assertFalse(condition.isSatisfied());

		stubReturn(true).on(cond1).isSatisfied();
		stubReturn(true).on(cond2).isSatisfied();
		stubReturn(false).on(cond3).isSatisfied();
		assertFalse(condition.isSatisfied());


		stubReturn(true).on(cond1).isSatisfied();
		stubReturn(false).on(cond2).isSatisfied();
		stubReturn(true).on(cond3).isSatisfied();
		assertFalse(condition.isSatisfied());

		stubReturn(false).on(cond1).isSatisfied();
		stubReturn(true).on(cond2).isSatisfied();
		stubReturn(true).on(cond3).isSatisfied();
		assertFalse(condition.isSatisfied());

	}


}