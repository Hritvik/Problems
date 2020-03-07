package fantasticBits;

import java.util.ArrayList;
import java.util.Scanner;

class Entity {
	int id;
	int pos_x;
	int pos_y;
	int state;
	int vel_x;
	int vel_y;
	int mass;
	int radius;

	public void print() {
		System.err.println(id + " :: pos = [" + pos_x + ", " + pos_y + "] :: vel = [" + vel_x + ", " + vel_y
				+ "], state = " + state);
	}
}

class OpponentWizard extends Entity {
	int id;
	int pos_x;
	int pos_y;
	int state;
	int vel_x;
	int vel_y;
	double mass = 1;
	int radius = 400;

	public OpponentWizard(int id, int pos_x, int pos_y, int vel_x, int vel_y, int state) {
		this.id = id;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
		this.state = state;
	}
}

class Wizard extends Entity {
	int id;
	int pos_x;
	int pos_y;
	int state;
	int vel_x;
	int vel_y;
	double mass = 1;
	int radius = 400;

	public Wizard(int id, int pos_x, int pos_y, int vel_x, int vel_y, int state) {
		this.id = id;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
		this.state = state;
	}

	public Wizard() {

	}

}

class Snaffle extends Entity {
	int id;
	int pos_x;
	int pos_y;
	int state;
	int vel_x;
	int vel_y;
	double mass = .5;
	int radius = 150;

	Snaffle(int id, int pos_x, int pos_y, int vel_x, int vel_y, int state) {
		this.id = id;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
		this.state = state;
	}

	public Snaffle() {

	}

}

class Bludger extends Entity {
	int id;
	int pos_x;
	int pos_y;
	int state;
	int vel_x;
	int vel_y;
	double mass = 8;
	int radius = 400;

	Bludger(int id, int pos_x, int pos_y, int vel_x, int vel_y, int state) {
		this.id = id;
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.vel_x = vel_x;
		this.vel_y = vel_y;
	}

}

class Player {
	static int GOAL_TOP_CENTER = 1750;
	static int GOAL_BOTTOM_CENTER = 5750;
	static int GOAL_POLE_RADIUS = 300;
	static int SNAFFLE_RADIUS = 150;
	static int BLUDGER_THRUST = 1000;
	static ArrayList<Entity> wizards = null;
	static ArrayList<Entity> opponentWizards = null;
	static ArrayList<Entity> snaffles = null;
	static ArrayList<Entity> bludgers = null;
	static ArrayList<int[]> bludgerPaths = null;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		try {
			int goal_x;
			int myTeamId = in.nextInt();
			if (myTeamId == 1) {
				goal_x = 0;
			} else {
				goal_x = 16000;
			}

			// game loop
			while (true) {
				wizards = new ArrayList<>();
				opponentWizards = new ArrayList<>();
				snaffles = new ArrayList<>();
				bludgers = new ArrayList<>();
				bludgerPaths = new ArrayList<>();
				int entities = in.nextInt(); // number of entities still in game
				for (int i = 0; i < entities; i++) {
					int entityId = in.nextInt(); // entity identifier
					String entityType = in.next(); // "WIZARD",
													// "OPPONENT_WIZARD" or
													// "SNAFFLE" (or "BLUDGER"
													// after
													// first league)
					int x = in.nextInt(); // position
					int y = in.nextInt(); // position
					int vx = in.nextInt(); // velocity
					int vy = in.nextInt(); // velocity
					int state = in.nextInt(); // 1 if the wizard is holding a
												// Snaffle, 0 otherwise
					switch (entityType) {
					case "WIZARD": {
						Entity wizard = new Wizard(entityId, x, y, vx, vy, state);
						wizards.add(wizard);
					}
						break;
					case "OPPONENT_WIZARD": {
						Entity wizard = new OpponentWizard(entityId, x, y, vx, vy, state);
						opponentWizards.add(wizard);
					}
						break;
					case "SNAFFLE": {
						Entity snaffle = new Snaffle(entityId, x, y, vx, vy, state);
						snaffles.add(snaffle);
						break;
					}

					case "BLUDGER": {
						Entity bludger = new Bludger(entityId, x, y, vx, vy, state);
						bludgers.add(bludger);
						break;
					}
					}

				}

				for (int i = 0; i < bludgers.size(); i++) {
					int[] bludgerPath = calcBludgerPath(bludgers.get(i), wizards, opponentWizards);
					bludgerPaths.add(bludgerPath);
				}
				Entity closestSnaffle = new Snaffle();
				closestSnaffle.id = -1;
				for (int i = 0; i < wizards.size(); i++) {
					wizards.get(i).print();
					if (wizards.get(i).state == 1) {
						throwInGoalPost(wizards.get(i), goal_x);
					} else {
						closestSnaffle = closestEntityFinder(wizards.get(i), snaffles, closestSnaffle, bludgerPaths);
						System.out.println("MOVE " + closestSnaffle.pos_x + " " + closestSnaffle.pos_y + " 125");
					}

				}
			}

		} catch (Exception e) {
			in.close();
			e.printStackTrace();
		}
	}

	public static Entity closestEntityFinder(Entity sourceEntity, ArrayList<Entity> targets, Entity blackListedEntity,
			ArrayList<int[]> bludgerPaths) {
		boolean collisionFlag = false;
		double min = 99999;
		Entity closestTarget = null;
		for (int i = 0; i < targets.size(); i++) {
			if (bludgerPaths != null) {
				int[] entityVector = calcEntityPath(sourceEntity, targets.get(i));
				collisionFlag = detectCollision(entityVector, bludgerPaths);
			}
			if (!collisionFlag) {
				if (targets.get(i).id != blackListedEntity.id) {
					double tempDist = calcDistanceBtwEntities(sourceEntity, targets.get(i));
					if (tempDist < min) {
						min = tempDist;
						closestTarget = targets.get(i);
					}
				}
			}
		}
		return closestTarget;
	}

	public static boolean detectCollision(int[] entityVector, ArrayList<int[]> obstructionVectors) {
		for (int i = 0; i < obstructionVectors.size(); i++) {
			int[] obstructionVector = obstructionVectors.get(i);
			int[] collisionPoint = detectPathCollisionPoint(entityVector, obstructionVector);
			if (!(collisionPoint[0] == -1 && collisionPoint[1] == -1)) {
				return false;
			} else {
				// collisionpoint found check for actual collision

			}
		}
		return false;
	}

	public static int[] calcBludgerPath(Entity bludger, ArrayList<Entity> wizards, ArrayList<Entity> opponentWizards) {
		ArrayList<Entity> targets = new ArrayList<>();
		targets.addAll(wizards);
		targets.addAll(opponentWizards);
		Entity blackListedWizard = new Wizard();
		blackListedWizard.id = bludger.state;
		Entity targetWizard = closestEntityFinder(bludger, targets, blackListedWizard, null);
		int[] bludgerPath = calcEntityPath(bludger, targetWizard);
		return bludgerPath;
	}

	public static int[] calcEntityPath(Entity sourceEntity, Entity targetEntity) {
		int m = (targetEntity.pos_y - sourceEntity.pos_y) / (targetEntity.pos_x - sourceEntity.pos_x);
		int c = (targetEntity.pos_y - m * targetEntity.pos_x);
		int[] path = { m, c };
		return path;
	}

	public static int[] detectPathCollisionPoint(int[] path1, int[] path2) {
		int x = (path1[1] - path2[1]) / (path2[0] - path1[0]);
		int y = path1[0] * x + path1[1];
		if (x > -1 && x < 16002 && y > -1 && y < 7502) {
			int[] collisionPoint = { x, y };
			return collisionPoint;
		}
		int[] collisionPoint = { -1, -1 };
		return collisionPoint;
	}

	public static double calcDistanceBtwEntities(Entity sourceEntity, Entity targetEntity) {
		double dist_x_sqr = Math.pow((sourceEntity.pos_x - targetEntity.pos_x), 2);
		double dist_y_sqr = Math.pow((sourceEntity.pos_y - targetEntity.pos_y), 2);
		double distance = Math.pow(dist_x_sqr + dist_y_sqr, .5);
		return distance;
	}

	public static void throwInGoalPost(Entity entity, int goal_x) {
		System.out.println("THROW " + goal_x + " " + ((GOAL_TOP_CENTER + GOAL_BOTTOM_CENTER) / 2) + " 500");
	}
}