import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Menu extends JFrame implements ActionListener{
    SetWinner viewWinner = new SetWinner();
    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel menuLabel = new JLabel();
    JButton adminButton= new JButton();
    JButton userButton = new JButton();
    JButton winnerButton = new JButton();

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==adminButton){
            new AdminLoginFrame();
            frame.setVisible(false);
        } else if (e.getSource()==userButton) {
            new UserMenu();
            frame.setVisible(false);
        }else if(e.getSource()==winnerButton){
            viewWinner.viewWinner();
            frame.setVisible(false);
        }
    }
   public Menu(){
        container.setLayout(null);
        menuLabel.setText("Main Menu");
        menuLabel.setBounds(200, 20, 100, 50);
        container.add(menuLabel);


        adminButton.setText("Admin");
        adminButton.setBounds(180, 70, 100, 30);
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);
        container.add(adminButton);

    userButton.setText("User");
    userButton.setBounds(180, 120, 100, 30);
    userButton.setFocusable(false);
    userButton.addActionListener(this);
    container.add(userButton);

       winnerButton.setText("Winner");
       winnerButton.setBounds(180, 170, 100, 30);
       winnerButton.setFocusable(false);
       winnerButton.addActionListener(this);
       container.add(winnerButton);


        frame.add(container);
        frame.setTitle("Online Voting System");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}