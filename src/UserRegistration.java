import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistration extends JFrame implements ActionListener {
    UserInfo userInfo = new UserInfo();

    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel usernameLabel = new JLabel();
    JLabel passwordLabel = new JLabel();
    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    JButton registrationButton = new JButton();
    JButton backButton = new JButton();


    public void registration(){
        container.setLayout(null);

        usernameLabel.setText("Username");
        usernameLabel.setBounds(70, 20, 100, 50);
        container.add(usernameLabel);

        passwordLabel.setText("Password");
        passwordLabel.setBounds(70, 70, 100, 50);
        container.add(passwordLabel);

        usernameTextField.setBounds(170, 33, 150, 30);
        container.add(usernameTextField);

        passwordTextField.setBounds(170, 83, 150, 30);
        container.add(passwordTextField);

        registrationButton.setText("Register");
        registrationButton.setBounds(60, 120, 150, 30);
        registrationButton.setFocusable(false);
        registrationButton.addActionListener(this);
        container.add(registrationButton);

        backButton.setText("Back");
        backButton.setBounds(240, 120, 150, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        container.add(backButton);


        frame.add(container);
        frame.setTitle("User Registration");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registrationButton){
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            if(username.isEmpty()||password.isEmpty()){
                JOptionPane.showMessageDialog(this, "Missing Field");
                usernameTextField.setText("");
                passwordTextField.setText("");
                return;
            }
            if(userInfo.register_info.containsKey(username)){
                JOptionPane.showMessageDialog(this, "Username Already Exists");
                usernameTextField.setText("");
                passwordTextField.setText("");
                return;
            }
            userInfo.register_info.put(username,password);
            userInfo.not_voted.add(username);
            JOptionPane.showMessageDialog(this, "Registration Complete");
            usernameTextField.setText("");
            passwordTextField.setText("");
            frame.setVisible(false);
            new UserMenu();
        } else if (e.getSource()==backButton) {
            frame.setVisible(false);
            new UserMenu();
        }

    }
}
