package dima;

import java.util.ArrayList;
import java.util.Scanner;

public class BowlingData {

	public static String Rules(int strikeNum, int inputNum) {
		try {
			if (inputNum >= 0 && inputNum <= 9) {
				return ("ordinary");
			}
			if (inputNum == 10 && (strikeNum % 2) == 0) { 
				return ("spare");
			}
			if (inputNum == 10 && (strikeNum % 2) != 0) { 
				return ("strike");
			}
		} catch (Exception ex) {
			System.out.println("Got error 1"+ex.getMessage());
		}
		return ("ERROR");
	}

	public static Integer OrdinaryCalculation(int strikeNum, ArrayList<Integer> hitScore,
			ArrayList<Integer> frameScore) {
		try {
			if (strikeNum % 2 == 0 && hitScore.size() == 2) {
				frameScore.add(hitScore.get(strikeNum - 2) + hitScore.get(strikeNum - 1));
				return (frameScore.get(frameScore.size() - 1));
			}
			if (strikeNum % 2 == 0 && hitScore.size() >= 4) {
				frameScore.add(hitScore.get(strikeNum - 2) + hitScore.get(strikeNum - 1)
						+ frameScore.get(frameScore.size() - 1));
				return (frameScore.get(frameScore.size() - 1));
			}
		} catch (Exception ex) {
			System.out.println("Got error 2"+ex.getMessage());
		}
		return null;
	}

	public static Integer SpareCalculation(int strikeNum, ArrayList<Integer> hitScore, ArrayList<Integer> frameScore) {
		try {
			if (frameScore.get(frameScore.size() - 1) != null) {
				frameScore.add(10 + frameScore.get(frameScore.size() - 1) + hitScore.get(hitScore.size() - 1));
				return (frameScore.get(frameScore.size() - 1));
			}
			if (frameScore.get(frameScore.size() - 1) == null) {
				frameScore.add(10 + hitScore.get(hitScore.size() - 1));
				return (frameScore.get(frameScore.size() - 1));
			}
		} catch (Exception ex) {
			System.out.println("Got error 3"+ex.getMessage());
		}
		return null;
	}

	public static Integer StrikeCalculation(int strikeNum, ArrayList<Integer> hitScore, ArrayList<Integer> frameScore) {
		try {
			if (frameScore.get(frameScore.size() - 1) != null) {
				frameScore.add(10 + frameScore.get(frameScore.size() - 1) + hitScore.get(hitScore.size() - 2)
						+ hitScore.get(hitScore.size() - 1));
				return (frameScore.get(frameScore.size() - 1));
			}
			if (frameScore.get(frameScore.size() - 1) == null) {
				frameScore.add(10 + hitScore.get(hitScore.size() - 2) + hitScore.get(hitScore.size() - 1));
				return (frameScore.get(frameScore.size() - 1));
			}
		} catch (Exception ex) {
			System.out.println("Got error 4"+ex.getMessage());
		}
		return null;
	}
}
