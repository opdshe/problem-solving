package 기출.카카오페이2021인턴;

public class 일번 {

	/*long 확인하기 !!!!!!!!!!!!!!!!!!!!*/


	public static void main(String[] args) {
		solution(1000000000, 50, 99, 100000, 0, 6);
	}

	public static int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
		for (int i = 0; i < months; i++) {
			int aboutMoney = down(money);
			int ratio = getRatio(aboutMoney, threshold, minratio, maxratio, ranksize);
			int minus = (int) ((double) aboutMoney * (double) ratio * (double)0.01);
			money -= minus;
		}
		System.out.println(money);
		return money;
	}

	private static int getRatio(int money, int threshold, int minratio, int maxratio, int ranksize) {
		if (money < threshold) {
			return 0;
		}
		int offset = 0;
		while (minratio + offset < maxratio) {
			if (money >= (threshold + offset * ranksize) && money < threshold + (offset + 1) * ranksize - 1) {
				return minratio + offset;
			}
			offset++;
		}
		return maxratio;
	}

	private static int down(int origin) {
		return Math.round((origin / 100) * 100);
	}
}
