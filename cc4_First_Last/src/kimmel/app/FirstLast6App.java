package kimmel.app;

public class FirstLast6App {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 6 };
		int[] array2 = { 6, 1, 2, 3 };
		int[] array3 = { 13, 6, 1, 2, 3 };

		System.out.println(firstLast6(array3));

	}

	public static boolean firstLast6(int[] nums) {
		if (nums[0] == 6) {
			return true;
		}
		if (nums[nums.length - 1] == 6) {
			return true;
		}
		return false;
	}

}
