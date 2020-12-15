package kimmel.app;

import java.util.Arrays;
import java.util.List;

public class ReplaceCharsApp {

	public static void main(String[] args) {

		String str = "The fox jumped over the log.";
		String tutor = "Nick is Awesome!";
		System.out.println(replaceVowelsWithUnderscores(tutor));

	}

	public static String replaceVowelsWithUnderscores(String s) {
		Character vowels[] = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		List<Character> al = Arrays.asList(vowels);
		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < sb.length(); i++) {
			if (al.contains(sb.charAt(i))) {
				sb.replace(i, i + 1, "_");
			}
		}
		return sb.toString();
	}

}
