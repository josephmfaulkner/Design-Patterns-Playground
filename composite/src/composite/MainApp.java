package composite;

import java.awt.EventQueue;

public class MainApp {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					System.out.println("Begin");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
