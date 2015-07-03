/**
 * This application implements the if and switch constructs
 * 
 * @author User1
 *
 */
package com.kevinphair.ocja.exercises;

/**
 * Given a score, work out the grade - A,B,C,D or F(ail).
 * Then, reverse this and from the grade show the score ranges 
 * which result in that grade.
 * 
 */
public class GradeApp {

	public static void main(String[] args) {

		String grade = "";
		String result = "";
		int score = 0;

		score = 70;

		if (score > 100 || score < 0)	{	grade = "";	}
		else if (score >= 85) 			{	grade = "A";	}
		else if (score >= 70) 			{	grade = "B";	}
		else if (score >= 55) 			{	grade = "C";	}
		else if (score >= 40) 			{	grade = "D";	}
		else 							{	grade = "F";	}

		if (grade != "") {
			switch(grade.toUpperCase()) {
				case "A": result = "85-100"; break;
				case "B": result = "70-84"; break;
				case "C": result = "55-69"; break;
				case "D": result = "40-54"; break;
				default:  result = "0-53"; break;
			}
			System.out.println("The grade for score " + score + " is '" + grade + "'");
			System.out.println("The passing scores for grade " + grade + " are " + result + ".");
		} else {
			System.out.println("An invalid score was supplied ('" + score + "')");
		}

	}

}
