package testJava;

import validation.ValidationsUtilsImpl;

public class TestJavaApplication {
	public static void main(String[] args) {
		App app = new App(new ValidationsUtilsImpl());
		app.initApp();
	}
}
