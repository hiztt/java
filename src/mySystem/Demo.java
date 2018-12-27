package mySystem;

public class Demo {
	public static void main(String[] args) {
		ManageSystem test = new ManageSystem();
		System.out.println("-------------------------------------------");
		System.out.println("");
		test.init_system();
		System.out.println("");
		test.menu();
	}
}
