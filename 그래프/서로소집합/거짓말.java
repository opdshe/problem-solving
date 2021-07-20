package 그래프.서로소집합;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 거짓말 {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Integer> truthMembers = new ArrayList<>();
	private static List<List<Integer>> partyMembers = new ArrayList<>();

	public static void main(String[] args) {
		int countOfPeople = scanner.nextInt();
		int countOfParty = scanner.nextInt();
		int countOfTruthMember = scanner.nextInt();
		int[] parents = getParents(countOfPeople);
		for (int i = 0; i < countOfTruthMember; i++) {
			truthMembers.add(scanner.nextInt());
		}
		for (int i = 0; i < countOfParty; i++) {
			partyMembers.add(new ArrayList<>());
			int partyMemberCount = scanner.nextInt();
			int pivot = scanner.nextInt();
			partyMembers.get(i).add(pivot);
			for (int member = 0; member < partyMemberCount - 1; member++) {
				int other = scanner.nextInt();
				partyMembers.get(i).add(other);
				union(parents, pivot, other);
			}
		}
		solution(parents, countOfPeople, countOfParty);
	}

	private static void solution(int[] parents, int countOfPeople, int countOfParty) {
		int count = 0;
		for (List<Integer> partyMember : partyMembers) {
			boolean hasSameParent = false;
			for (Integer member : partyMember) {
				for (Integer truthMember : truthMembers) {
					if (find(parents, member) == find(parents, truthMember)) {
						hasSameParent = true;
						break;
					}
				}
			}
			if (!hasSameParent) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static void initParents(int[] parents, int countOfPeople) {
		for (List<Integer> partyMember : partyMembers) {
			for (Integer member : partyMember) {
				for (Integer truthMember : truthMembers) {
					if (partyMember.contains(truthMember)) {
						union(parents, member, truthMember);
					}
				}
			}
		}
	}

	private static int[] getParents(int countOfPeople) {
		int[] parents = new int[countOfPeople + 1];
		for (int idx = 1; idx <= countOfPeople; idx++) {
			parents[idx] = idx;
		}
		return parents;
	}

	private static void union(int[] parents, int a, int b) {
		int parentA = find(parents, a);
		int parentB = find(parents, b);
		if (parentA < parentB) {
			parents[parentB] = parentA;
		} else {
			parents[parentA] = parentB;
		}
	}

	private static int find(int[] parents, int target) {
		if (parents[target] != target) {
			return parents[target] = find(parents, parents[target]);
		}
		return target;
	}
}
