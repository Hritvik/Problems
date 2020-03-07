package fantasticBits.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class OpponentWizard {
	int id;
	int pos_x;
	int pos_y;
	int state;
	int vel_x;
	int vel_y;

	public OpponentWizard(int id, int pos_x, int pos_y, int vel_x, int vel_y, int state) {
		this.id = id;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
		this.state = state;
	}
}

class Wizard {
	int id;
	int pos_x;
	int pos_y;
	int state;
	int vel_x;
	int vel_y;

	public Wizard(int id, int pos_x, int pos_y, int vel_x, int vel_y, int state) {
		this.id = id;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
		this.state = state;
	}

	public void print() {
		System.err.println(id + " :: pos = [" + pos_x + ", " + pos_y + "] :: vel = [" + vel_x + ", " + vel_y
				+ "], state = " + state);
	}
}

class Snaffle {
	int id;
	int pos_x;
	int pos_y;
	int state;
	int vel_x;
	int vel_y;

	Snaffle(int id, int pos_x, int pos_y, int vel_x, int vel_y, int state) {
		this.id = id;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
		this.state = state;
	}

	public Snaffle() {
		// TODO Auto-generated constructor stub
	}

	public void print() {
		System.err.println(id + " :: pos = [" + pos_x + ", " + pos_y + "] :: vel = [" + vel_x + ", " + vel_y
				+ "], state = " + state);
	}
}

class Bludger {
	int id;
	int pos_x;
	int pos_y;
	int state;
	int vel_x;
	int vel_y;

	Bludger(int id, int pos_x, int pos_y, int vel_x, int vel_y, int state) {
		this.id = id;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
	}

	public void print() {
		System.err.println(id + " :: pos = [" + pos_x + ", " + pos_y + "] :: vel = [" + vel_x + ", " + vel_y
				+ "], state = " + state);
	}
}

class Player {
	static int GOAL_TOP_CENTER = 1750;
	static int GOAL_BOTTOM_CENTER = 5750;
	static int GOAL_POLE_RADIUS = 300;
	static int SNAFFLE_RADIUS = 150;

	public static void main(String args[]) {

		int goal_x;
		Scanner in = new Scanner(System.in);
		int myTeamId = in.nextInt(); // if 0 you need to score on the right of
										// the map, if 1 you need to score on
										// the left
		if (myTeamId == 1) {
			goal_x = 0;
		} else {
			goal_x = 16000;
		}

		System.err.println("xxxxx");
		// game loop
		while (true) {
			ArrayList<Wizard> wizards = new ArrayList<>();
			ArrayList<OpponentWizard> opponentWizards = new ArrayList<>();
			ArrayList<Snaffle> snaffles = new ArrayList<>();
			ArrayList<Bludger> bludgers = new ArrayList<>();
			int entities = in.nextInt(); // number of entities still in game
			for (int i = 0; i < entities; i++) {
				int entityId = in.nextInt(); // entity identifier
				String entityType = in.next(); // "WIZARD", "OPPONENT_WIZARD" or
												// "SNAFFLE" (or "BLUDGER" after
												// first league)
				int x = in.nextInt(); // position
				int y = in.nextInt(); // position
				int vx = in.nextInt(); // velocity
				int vy = in.nextInt(); // velocity
				int state = in.nextInt(); // 1 if the wizard is holding a
											// Snaffle, 0 otherwise
				switch (entityType) {
				case "WIZARD": {
					Wizard wizard = new Wizard(entityId, x, y, vx, vy, state);
					wizards.add(wizard);
				}
					break;
				case "OPPONENT_WIZARD": {
					OpponentWizard wizard = new OpponentWizard(entityId, x, y, vx, vy, state);
					opponentWizards.add(wizard);
				}
					break;
				case "SNAFFLE": {
					Snaffle snaffle = new Snaffle(entityId, x, y, vx, vy, state);
					snaffles.add(snaffle);
					break;
				}

				case "BLUDGER": {
					Bludger bludger = new Bludger(entityId, x, y, vx, vy, state);
					bludgers.add(bludger);
					break;
				}
				}

			}
			HashMap<Integer, Snaffle> snaffleMap = findSnafflesForWizards(snaffles, wizards);
			for (int i = 0; i < wizards.size(); i++) {
				wizards.get(i).print();
				if (wizards.get(i).state == 1) {
					System.err.println(i + " :: trying to throw");
					throwInGoalPost(wizards.get(i), goal_x);
				} else {
					Snaffle closestSnaffle = null;
					closestSnaffle = snaffleMap.get(wizards.get(i).id);
					if (closestSnaffle == null) {
						System.out.println("MOVE " + wizards.get(i).pos_x + " " + wizards.get(i).pos_y + " 125");
					} else {
						System.out.println("MOVE " + closestSnaffle.pos_x + " " + closestSnaffle.pos_y + " 125");
					}
				}

			}
		}
	}

	private static HashMap<Integer, Snaffle> findSnafflesForWizards(ArrayList<Snaffle> snaffles,
			ArrayList<Wizard> wizards) {
		HashMap<Integer, Snaffle> map = new HashMap<Integer, Snaffle>();

		ArrayList<Snaffle> snafflesTemp = new ArrayList<Snaffle>();
		snafflesTemp.addAll(snaffles);
		Object[] result1 = closestSnaffleFinder(snafflesTemp, wizards.get(0));
		Snaffle closestSnaffleW0 = (Snaffle) result1[0];
		double min1 = (double) result1[1];
		Object[] result2 = closestSnaffleFinder(snafflesTemp, wizards.get(0));
		Snaffle secondClosestSnaffleW0 = (Snaffle) result2[0];
		snafflesTemp.clear();
		snafflesTemp.addAll(snaffles);
		Object[] result3 = closestSnaffleFinder(snafflesTemp, wizards.get(1));
		Snaffle closestSnaffleW1 = (Snaffle) result3[0];
		double min3 = (double) result3[1];
		Object[] result4 = closestSnaffleFinder(snafflesTemp, wizards.get(1));
		Snaffle secondClosestSnaffleW1 = (Snaffle) result4[0];
		map.put(wizards.get(0).id, closestSnaffleW0);
		map.put(wizards.get(1).id, closestSnaffleW1);
		if (closestSnaffleW0.id == closestSnaffleW1.id) {
			if (min1 > min3) {
				map.put(wizards.get(0).id, secondClosestSnaffleW0);
			} else {
				map.put(wizards.get(1).id, secondClosestSnaffleW1);
			}
		}
		return null;
	}

	public static Object[] closestSnaffleFinder(ArrayList<Snaffle> snaffles, Wizard wizard) {
		double min = 99999;
		Snaffle closestSnaffle = null;
		for (int i = 0; i < snaffles.size(); i++) {
			double tempDist = distanceCalc(wizard.pos_x, wizard.pos_y, snaffles.get(i).pos_x, snaffles.get(i).pos_y);
			System.err.println("distance = " + tempDist);
			if (tempDist < min) {
				min = tempDist;
				closestSnaffle = snaffles.get(i);
				if (snaffles.size() > 1) {
					snaffles.remove(i);
				}
			}
		}
		Object[] result = { closestSnaffle, min };
		return result;
	}

	public static double distanceCalc(int start_x, int start_y, int end_x, int end_y) {
		double diff_x = Math.pow((start_x - end_x), 2);
		double diff_y = Math.pow((start_y - end_y), 2);
		double distance = Math.pow(diff_x + diff_y, .5);
		return distance;
	}

	public static void throwInGoalPost(Wizard wizard, int goal_x) {
		System.out.println("THROW " + goal_x + " " + ((GOAL_TOP_CENTER + GOAL_BOTTOM_CENTER) / 2) + " 500");
	}
}