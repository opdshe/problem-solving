package 비트마스킹;

import java.io.*;
import java.util.Arrays;

public class 집합 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int orderCount = Integer.parseInt(br.readLine());
		boolean[] status = new boolean[21];
		for (int i = 0; i < orderCount; i++) {
			String[] order = br.readLine().split(" ");
			if (order[0].equals("add")) {
				status[Integer.parseInt(order[1])] = true;
			} else if (order[0].equals("check")) {
				bw.write(status[Integer.parseInt(order[1])] ? "1" : "0");
				bw.newLine();
			} else if (order[0].equals("remove")) {
				status[Integer.parseInt(order[1])] = false;
			} else if (order[0].equals("toggle")) {
				status[Integer.parseInt(order[1])] = !status[Integer.parseInt(order[1])];
			} else if (order[0].equals("all")) {
				Arrays.fill(status, true);
			} else if (order[0].equals("empty")) {
				Arrays.fill(status, false);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
