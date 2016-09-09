package Lab1;

import java.util.Scanner;

public class Retirement {

	public static void main(String[] args) {
		// Creating constants to use for interest values
		int max_interest_ret = 3, max_interest_inv = 20, min_interest = 0, years, draw, annual = 12;
		// Takes user input about savings and years worked
		double ReqIncome, SSI, interest_inv, interest_ret, pv, pmt;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter how many years you plan to work: ");
		years = in.nextInt();

		// using a while loop to ensure that interest rate falls within the
		// prompts rules
		System.out.println("Enter an investment interest rate between 0-20%");
		interest_inv = in.nextInt();
		while (interest_inv < min_interest || interest_inv > max_interest_inv) {
			System.out.println("Error: Please enter a rate from 0-20% ");
			interest_inv = in.nextInt();
		}

		System.out.println("How far out (years) do you want to draw from Social Security: ");
		draw = in.nextInt();
		System.out.println("What is your required income: ");
		ReqIncome = in.nextDouble();

		System.out.println("Enter your expected annual return - 0-3%");

		// using a while loop to ensure that interest rates fall within the
		// prompts rules
		interest_ret = in.nextInt();
		while (interest_ret < min_interest || interest_ret > max_interest_ret) {
			System.out.println("Error: Please enter a rate from 0-3% ");
			interest_ret = in.nextInt();
		}

		System.out.println("What is your expected Monthly SSI: ");
		SSI = in.nextDouble();
		in.close();
		double net_income = ReqIncome - SSI;
		// formulas to calculate pv and pmt
		pv = (net_income) * ((1 - (1 / (Math.pow(1 + (interest_ret * .01) / annual, draw * annual)))))
				/ ((interest_ret * .01) / annual);

		pmt = pv * (((interest_inv * .01) / annual)
				/ ((Math.pow(1 + (interest_inv * .01) / annual, years * annual)) - 1));

		System.out.println("Your total amount of money needed is $ " + Math.round(pv * 100.0)/ 100.0);
		System.out.println("You need to save " + Math.round(pmt * 100.0) / 100.0 + "$" + " each month.");

	}

}
