package kimmel.app;

public class MakeChocolateApp {

	public static void main(String[] args) {
		int result = makeChocolate(2, 20, 24);
		System.out.println(result);
	}

	public static int makeChocolate(int small, int big, int goal) {
		if (small + (big * 5) < goal) {
			return -1;
		}
		while (big > 0) {
			if ((big * 5) > goal) {
				big--;
				continue;
			}
			break;
		}
		int smallBarsNeeded = goal - (big * 5);
		if (small < smallBarsNeeded) {
			return -1;
		}
		return smallBarsNeeded;
	}
}
