import java.awt.EventQueue;

public class AppMain {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
