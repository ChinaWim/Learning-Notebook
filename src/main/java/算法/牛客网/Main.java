package 算法.牛客网;

public class Main {


	/**
	 * 0 25 75
	 * 4 18 78
	 * 8 11 81
	 * 12 4 84
	 * @param args
	 */
	public static void main (String [] args) {


		System.out.println(((Object) null).hashCode());
		int money = 100;
int num = 100;

for (int i = 0; i <= 20 ; i ++) {
	for (int j = 0; j <= 34; j++) {
		for (int k = 3; k <= 100; k +=3) {
		if ((5*i + 3* j + k*(1.0/3)) == 100 && (i + j +k) == 100) {
			System.out.println( i +" " + j +" "+ k);
		}
		}
	}
}


}



}