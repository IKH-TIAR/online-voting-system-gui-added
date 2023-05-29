import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu implements ActionListener {
    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel menuLabel = new JLabel();
    JButton registrationButton= new JButton();
    JButton loginButton = new JButton();
    JButton backButton = new JButton();
    UserRegistration userRegistration = new UserRegistration();
    UserLogin userLogin = new UserLogin();

    public UserMenu(){
        container.setLayout(null);
        menuLabel.setText("User Menu");
        menuLabel.setBounds(200, 20, 100, 50);
        container.add(menuLabel);


        registrationButton.setText("Register");
        registrationButton.setBounds(180, 70, 100, 30);
        registrationButton.setFocusable(false);
        registrationButton.addActionListener(this);
        container.add(registrationButton);

        loginButton.setText("Login");
        loginButton.setBounds(180, 120, 100, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        container.add(loginButton);

        backButton.setText("back");
        backButton.setBounds(180, 170, 100, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        container.add(backButton);


        frame.add(container);
        frame.setTitle("User Menu");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registrationButton){
            frame.setVisible(false);
            userRegistration.registration();
        } else if (e.getSource()==loginButton) {
            frame.setVisible(false);
            userLogin.userLogin();
        } else if(e.getSource()==backButton){
            frame.setVisible(false);
            new Menu();
        }

    }
}

