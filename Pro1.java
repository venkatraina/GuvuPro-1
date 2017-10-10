package Pro_1;

import java.util.*;

public class Pro1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("The Number Of Strings : ");
		int n = in.nextInt();
		String s[] = new String[n];
		System.out.println("Enter The Strings : ");
		for (int i = 0; i < n; i++) {
			s[i] = in.next();
		}
		in.close();
		System.out.println(longestCommonPrefix(s));

	}

	public static String longestCommonPrefix(String ar[]) {
		String a[][] = new String[ar.length][];
		for (int i = 0; i < ar.length; i++) {

			ArrayList<String> al = wordSplitter(ar[i]);
			String a1[] = new String[al.size()];
			for (int j = 0; j < al.size(); j++) {
				a1[j] = al.get(j);
			}
			a[i] = a1;
		}
		String result = "";
		int k = 0;
		int flag = 0;
		OUTER: while (k < a[0].length) {
			String sub = a[0][k++];
			int count = 0;
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					if (sub.equals(a[i][j])) {
						count++;
						break;
					}
				}
				if (count == a.length) {
					flag = 1;
					result = sub;
					break OUTER;
				}
			}
		}
		if (flag == 1) {
			return "The Longest Common Substring is : " + result;
		} else {
			return "There is No Common Prefix ";
		}
	}

	public static ArrayList<String> wordSplitter(String s) {
		ArrayList<String> al = new ArrayList<String>();
		String a = "";
		for (int i = s.length(); i >= 1; i--) {
			a = "";
			for (int j = 0; j < i; j++) {
				a += s.charAt(j) + "";

			}
			al.add(a);
		}
		return al;

	}

}