package dima;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Main.operation();
	}

	public static void operation() {
		try {
			ArrayList<Integer> hitScore = new ArrayList<Integer>(22);
			ArrayList<Integer> frameScore = new ArrayList<Integer>(10);
			frameScore.add(null);
			Scanner sc = new Scanner(System.in);
			int strikeNum;

			System.out.println("Input the number of pins knocked down by each ball");

			for (strikeNum = 1; strikeNum <= 21; strikeNum++) {
				int inputNum = sc.nextInt();

				if (BowlingData.Rules(strikeNum, inputNum).equalsIgnoreCase("Ordinary")) {
					hitScore.add(inputNum);
					System.out.println(BowlingData.OrdinaryCalculation(strikeNum, hitScore, frameScore));
				}
				if (BowlingData.Rules(strikeNum, inputNum).equalsIgnoreCase("Spare")) {
					hitScore.add(0);
					strikeNum = strikeNum + 1;
					inputNum = sc.nextInt();
					hitScore.add(inputNum);
					if (inputNum == 10) {
						hitScore.add(0);
						strikeNum = strikeNum + 1;
						hitScore.add(0);
						strikeNum = strikeNum + 1;
						inputNum = sc.nextInt();
						hitScore.add(inputNum);
						strikeNum = strikeNum + 1;
						inputNum = sc.nextInt();
						hitScore.add(inputNum);
						System.out.println(BowlingData.StrikeCalculation(strikeNum, hitScore, frameScore));
					} else
						System.out.println(BowlingData.SpareCalculation(strikeNum, hitScore, frameScore));
				}
				if (BowlingData.Rules(strikeNum, inputNum).equalsIgnoreCase("Strike")) {
					hitScore.add(0);
					strikeNum = strikeNum + 1;
					hitScore.add(0);
					strikeNum = strikeNum + 1;
					inputNum = sc.nextInt();
					hitScore.add(inputNum);
					strikeNum = strikeNum + 1;
					inputNum = sc.nextInt();
					hitScore.add(inputNum);
					System.out.println(BowlingData.StrikeCalculation(strikeNum, hitScore, frameScore));
				}
				if (strikeNum == 19 && inputNum == 10) {
					hitScore.add(0);
					strikeNum = strikeNum + 1;
					inputNum = sc.nextInt();
					hitScore.add(inputNum);
					strikeNum = strikeNum + 1;
					inputNum = sc.nextInt();
					hitScore.add(inputNum);
					System.out.println(BowlingData.StrikeCalculation(strikeNum, hitScore, frameScore));
				}
				if (strikeNum == 20 && inputNum == 10) {
					hitScore.add(0);
					strikeNum = strikeNum + 1;
					inputNum = sc.nextInt();
					hitScore.add(inputNum);
					System.out.println(BowlingData.StrikeCalculation(strikeNum, hitScore, frameScore));
				}
				if (BowlingData.Rules(strikeNum, inputNum).equalsIgnoreCase("Error")) {
					System.out.println("Got ERROR, Game Over! ");
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println("Total Error" + ex.getMessage());
		}
	}
}
