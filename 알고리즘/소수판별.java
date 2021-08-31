package 알고리즘;

public class 소수판별 {
	/**
	 * 약수가 1과 자기자신 뿐인 수가 바로 소수
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPrimeNumber(2));
	}

	private static boolean isPrimeNumber(int target) {
		if (target < 2) {
			return false;
		}
		// target의 제곱근 보다 작은 수까지만 비교하면 됨 O(√N)
		for (int num = 2; num < Math.sqrt(target); num++) {
			if(target % num ==0){
				return false;
			}
		}
		return true;
	}
}
