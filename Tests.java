package dima;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class Tests {

	ArrayList<Integer> hitScore;
	ArrayList<Integer> frameScore;

	@Test
	public void testRules() {
		assertEquals("Hit - 1, score - 9 bowls", "ordinary", BowlingData.Rules(1, 9));
		assertEquals("Hit - 6, score - 10 bowls", "spare", BowlingData.Rules(6, 10));
		assertEquals("Hit - 3, score - 10 bowls", "strike", BowlingData.Rules(3, 10));
		assertFalse("Hit - 2, score - 10 bowls is Strike? ", "strike" == BowlingData.Rules(2, 10));
		assertFalse("Hit - 2, score - 10 bowls is Ordinary?", "ordinary" == BowlingData.Rules(2, 10));
		assertFalse("Hit - 3, score - 10 bowls is Spare?", "spare" == BowlingData.Rules(3, 10));
	}
	@Test
	public void testOrdinaryCalculation() {
		hitScore = new ArrayList<Integer>();
		hitScore.add(2);
		hitScore.add(4);
		frameScore = new ArrayList<Integer>();
		int a = BowlingData.OrdinaryCalculation(2,hitScore,frameScore);
		assertEquals(6,a);
	}
	@Test
	public void testSpareCalculation() {
		hitScore = new ArrayList<Integer>();
		hitScore.add(3);
		frameScore = new ArrayList<Integer>();
		frameScore.add(5);
		int a = BowlingData.SpareCalculation(1,hitScore,frameScore);
		assertEquals(18,a);
	}
	@Test
	public void testStrikeCalculation(){
		hitScore = new ArrayList<Integer>();
		hitScore.add(3);
		hitScore.add(5);
		frameScore = new ArrayList<Integer>();
		frameScore.add(1);
		int a = BowlingData.StrikeCalculation(1,hitScore,frameScore);
		assertEquals(19,a);
	}
}
