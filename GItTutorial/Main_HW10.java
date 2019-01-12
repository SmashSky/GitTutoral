package HW10;

import java.io.IOException;
import java.util.Scanner;

public class Main_HW10 {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String keyword = sc.next();
			GoogleQuery google = new GoogleQuery(keyword);
			google.query();
		}
		sc.close();
	}
}
