import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modulenam extends JFrame {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel messageLabel;

    public modulenam() {
        createView();

        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        getContentPane().add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        userField = new JTextField(20);
        userField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userField, gbc);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passLabel, gbc);

        passField = new JPasswordField(20);
        passField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passField, gbc);

        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(30, 144, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new LoginAction());
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        messageLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(messageLabel, gbc);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {
                showWelcomeFrame();
                dispose();
            } else {
                messageLabel.setText("Username/Password salah");
            }
        }
    }

    private void showWelcomeFrame() {
        JFrame welcomeFrame = new JFrame("Welcome");
        welcomeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        welcomeFrame.setSize(400, 300);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(60, 63, 65));
        welcomeFrame.getContentPane().add(panel);

        JLabel welcomeLabel = new JLabel("Login Sukses! Selamat datang!", SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        panel.add(welcomeLabel, BorderLayout.CENTER);

        JButton backButton = new JButton("Kembali");
        backButton.setBackground(new Color(255, 69, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> {
            new modulenam().setVisible(true);
            welcomeFrame.dispose();
        });
        panel.add(backButton, BorderLayout.SOUTH);

        welcomeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new modulenam().setVisible(true);
        });
    }
}
