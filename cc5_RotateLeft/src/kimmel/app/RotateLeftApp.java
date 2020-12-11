package kimmel.app;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RotateLeftApp {

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3 };
		int[] array2 = { 5, 11, 9 };
		int[] array3 = { 7, 0, 0 };
		int[] array4 = { 1, 2, 3, 4 };
		String result = IntStream.of(rotateLeft(array4)).mapToObj(String::valueOf).collect(Collectors.joining(","));
		System.out.println(result);
	}

	public static int[] rotateLeft3(int[] nums) {
		int[] result = { nums[1], nums[2], nums[0] };
		return result;
	}

	public static int[] rotateLeft(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < result.length; i++) {
			if (i == result.length - 1) {
				result[i] = nums[0];
			} else {
				result[i] = nums[i + 1];
			}
		}
		return result;
	}

}
