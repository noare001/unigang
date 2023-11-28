package ueb03;

public class Schaltjahr {

	public static void main(String[] args) {
		schaltjahr(200);
		schaltjahr(4000);
		schaltjahr(2303);
		schaltjahr(34503946);
	}

	public static void schaltjahr(int n) {
	System.out.println(n % 4 == 0 && !(n % 100 == 0 && n % 400 != 0));
	}
}
