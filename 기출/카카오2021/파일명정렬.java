package 기출.카카오2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 파일명정렬 {
	public static void main(String[] args) {
		solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
	}

	public static String[] solution(String[] files) {
		List<File> fileList = new ArrayList<>();
		for (int idx = 0; idx < files.length; idx++) {
			File file = toFile(idx, files[idx]);
			fileList.add(file);
		}
		fileList.sort(new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				if (o1.head.toLowerCase().compareTo(o2.head.toLowerCase()) > 0) {
					return 1;
				} else if (o1.head.toLowerCase().compareTo(o2.head.toLowerCase()) == 0) {
					if (Integer.parseInt(o1.number) > Integer.parseInt(o2.number)) {
						return 1;
					} else if (Integer.parseInt(o1.number) == Integer.parseInt(o2.number)) {
						if (o1.idx > o2.idx) {
							return 1;
						}
					}
				}
				return -1;
			}
		});
		String[] answer = fileList.stream()
				.map(File::toString)
				.toArray(String[]::new);
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	private static File toFile(int idx, String origin) {
		StringBuilder head = new StringBuilder();
		StringBuilder number = new StringBuilder();
		String tail = "";
		boolean hasHead = false;
		for (int i = 0; i < origin.length(); i++) {
			char current = origin.charAt(i);
			if (!hasHead && !Character.isDigit(current)) {
				head.append(current);
			} else if (!hasHead && Character.isDigit(current)) {
				hasHead = true;
				number.append(current);
			} else if (Character.isDigit(current)) {
				number.append(current);
			} else {
				tail = origin.substring(i);
				break;
			}
		}
		return new File(idx, head.toString(), number.toString(), tail);
	}

	private static class File {
		private int idx;
		private String head;
		private String number;
		private String tail;

		public File(int idx, String head, String number, String tail) {
			this.idx = idx;
			this.head = head;
			this.number = number;
			this.tail = tail;
		}

		public String toString() {
			return head + number + tail;
		}
	}
}
