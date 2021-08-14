package 기출.토스2021하반기;

public class 일번 {
	public static void main(String[] args) {
		float test = (float) 9.2;
		double ceil = Math.ceil(test);
		System.out.println(ceil);
	}

	public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
		// orderAmount : 주문금액
		// taxFreeAmount : 비과세금액
		// serviceFee : 봉사료
		//공급대가 = 주문금액 - 봉사료
		//공급가액 + 부가가치세 = 공급대가
		//과세금액 = 공급가액 - 비과세
		long daega = orderAmount - serviceFee;
		if(daega - taxFreeAmount == 1){
			return 0;
		}
		/*long gaAck = daega - 부가가치세;
		long gwase = gaAck - 비과세

		long answer = 0;*/
		return 0;
	}

	private long getTax(long orderAmount) {
		return (long) Math.ceil(orderAmount * 0.1);
	}

	private long getNonTax(long orderAmount) {
		return orderAmount - getTax(orderAmount);
	}
}
