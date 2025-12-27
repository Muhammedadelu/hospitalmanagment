import view.MainFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {

                javax.swing.UIManager.setLookAndFeel(
                        javax.swing.UIManager.getSystemLookAndFeelClassName()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Create and show the main window
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}