
public class HtmlApp {

	public static void main(String[] args) {

		String html = "<h1>Grocery List</h1>\n" + "<ul>\n" + "    <li>Eggs</li>\n" + "    <li>Milk</li>\n"
				+ "    <li>Butter</li>\n" + "</ul>";

		System.out.println("HTML Converter\n");
		System.out.println("INPUT");
		System.out.println(html + "\n");

		while (html.indexOf("  <") != -1) {

			html = html.replace(" <", "<");
		}

		html = html.replace("<li>", "* ");

		StringBuilder htmlBldr = new StringBuilder(html);

		int beginTagIndex = 0;
		while (beginTagIndex != -1) {
			beginTagIndex = htmlBldr.indexOf("<");
			if (beginTagIndex != -1) {

				int endTagIndex = (htmlBldr.indexOf(">", beginTagIndex + 1));
				htmlBldr.delete(beginTagIndex, endTagIndex + 1);
			}
		}
		html = htmlBldr.toString();

		html = html.replace("\n\n", "\n");
		System.out.println(html);

	}
}
