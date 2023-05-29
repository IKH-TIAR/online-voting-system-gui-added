import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame implements ActionListener {
    private Container container;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton backButton;
    UserInfo userInfo = new UserInfo();
    static String username1="";

    public void userLogin(){
        container = getContentPane();
        container.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(50, 20, 100, 30);
        container.add(userLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 70, 100, 30);
        container.add(passwordLabel);

        userTextField = new JTextField();
        userTextField.setBounds(150, 20, 150, 30);
        container.add(userTextField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        container.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 120, 100, 30);
        loginButton.addActionListener(this);
        container.add(loginButton);

        backButton = new JButton("Back");
        backButton.setBounds(200, 120, 100, 30);
        backButton.addActionListener(this);
        container.add(backButton);

        setTitle("Login Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void notVoted(){
        userInfo.not_voted.set(userInfo.not_voted.indexOf(username1),"0");
    }
    public int checkVoted(){
        if(!userInfo.not_voted.contains(username1)){
            JOptionPane.showMessageDialog(this,"You Already Voted");
            return 1;
        }
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton){
            String username = userTextField.getText();
            String password = passwordField.getText();
            username1 = username;
            if(userInfo.register_info.containsKey(username) && userInfo.register_info.get(username).equals(password)){
                JOptionPane.showMessageDialog(this, "Login Successful");
                setVisible(false);
                new VotingMenu();
            }else {
                JOptionPane.showMessageDialog(this, "Wrong Username or Password");
                userTextField.setText("");
                passwordField.setText("");
            }
        } else if (e.getSource()==backButton) {
            setVisible(false);
            new UserMenu();
        }
    }
}
