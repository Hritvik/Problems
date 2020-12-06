package Samsung;

import java.util.ArrayList;
import java.util.Scanner;
//1
//5 3 5
//1 2 4 6 0
//1 2 3
//5
//
//
//1
//6 4 5
//1 2 4 6 9 8
//1 2 3 4
//91
//
//1
//6 2 5
//0 1 3 5 7 9
//1 2 4
//28
//
//1
//5 2 10
//1 2 6 7 8
//2 3
//981
public class OldSmartphone_Done {
	private static ArrayList<Integer> digits = new ArrayList<Integer>();
	private static ArrayList<Integer> numbers = new ArrayList<Integer>();
	private static ArrayList<Integer> operators = new ArrayList<Integer>();
	private static int maxTouches = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int T = Integer.parseInt(sc.nextLine());
			while (T-- > 0) {
				String[] temp = sc.nextLine().split(" ");
				int O = Integer.parseInt(temp[2]);
				maxTouches = O;
				temp = sc.nextLine().split(" ");
				for (int i = 0; i < temp.length; i++) {
					int digit = Integer.parseInt(temp[i]);
					digits.add(digit);
				}
				temp = sc.nextLine().split(" ");
				for (int i = 0; i < temp.length; i++) {
					int operator = Integer.parseInt(temp[i]);
					operators.add(operator);
				}
				int required = Integer.parseInt(sc.nextLine());
				numberGenerator();
				recursive(required, 0, 0, "", "= ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

	private static void recursive(int required, int number, int touchCount, String indent, String expression) {
//		logger(number + " :: " + expression + " :: " + touchCount + "(" + maxTouches + ")", indent);
		if (required == number) {
			maxTouches = touchCount;
			logger("expression " + expression, indent);
		} else if (touchCount < maxTouches) {
			indent += " ";
			for (int j = 0; j < numbers.size(); j++) {
				for (int i = 0; i < operators.size(); i++) {
					boolean flag = false;
					if (numbers.get(j) != 0) {
						int newTouchCount = touchCount + ("" + numbers.get(j)).length() + 1;
						int newNumber = 0;
						String newExpression = "";
						if (newTouchCount <= maxTouches) {
							if (!expression.equals("= ")) {
								switch (operators.get(i)) {
								case 1:
									newNumber = number + numbers.get(j);
									newExpression = expression + " + " + numbers.get(j);
									flag = true;
									break;
								case 2:
									newNumber = number - numbers.get(j);
									newExpression = expression + " - " + numbers.get(j);
									flag = true;
									break;
								case 3:
									if (numbers.get(j) != 1) {
										newNumber = number * numbers.get(j);
										newExpression = expression + " * " + numbers.get(j);
										flag = true;
									}
									break;
								case 4:
									if (numbers.get(j) != 1) {
										newNumber = number / numbers.get(j);
										newExpression = expression + " / " + numbers.get(j);
										flag = true;
									}
									break;
								}
							} else {
								newExpression = expression + numbers.get(j);
								newNumber = numbers.get(j);
								flag =true;
							}
							if (flag && newNumber < 1000 && newNumber > 0) {
								recursive(required, newNumber, newTouchCount, indent, newExpression);
							} else {
							}
						} else {
//							logger("can't type " + numbers.get(j), indent);
						}
					}
				}
			}
		}
	}

	private static void numberGenerator() {
		for (int i = 0; i < 1000; i++) {
			if (possible(i)) {
				numbers.add(i);
			}
		}
	}

	private static boolean possible(int number) {
		if (number == 0 && !digits.contains(0)) {
			return false;
		}
		while (number > 0) {
			int digit = number % 10;
			if (!digits.contains(digit)) {
				return false;
			}
			number = number / 10;
		}
		return true;
	}

	private static void logger(String input, String indent) {
		System.out.println(indent + input);
	}
}
