package 그리디;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 체육복 {
	public int solution(int n, int[] losts, int[] reserves) {
		Set<Integer> lostSet = new HashSet<>();
		Set<Integer> reserveSet = new HashSet<>();
		Set<Integer> duplications = new HashSet<>();

		Arrays.stream(losts).forEach((lost)->lostSet.add(lost));
		Arrays.stream(reserves).forEach((reserve)->reserveSet.add(reserve));
		for(int lost : lostSet){
			if(reserveSet.contains(lost)){
				duplications.add(lost);
			}
		}
		for(int dup : duplications){
			lostSet.remove(dup);
			reserveSet.remove(dup);
		}

		int unvailable = 0;
		for(int lost: lostSet){
			if(reserveSet.contains(lost-1)){
				reserveSet.remove(lost-1);
				continue;
			}
			if(reserveSet.contains(lost+1)){
				reserveSet.remove(lost+1);
				continue;
			}
			unvailable++;
		}

		return n-unvailable;
	}
}
