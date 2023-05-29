import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VotingMenu extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel menuLabel = new JLabel();
    JButton voteButton= new JButton();
    JButton viewButton = new JButton();
    JButton backButton = new JButton();
    Vote vote = new Vote();

    public VotingMenu(){
        container.setLayout(null);
        menuLabel.setText("Main Menu");
        menuLabel.setBounds(200, 20, 100, 50);
        container.add(menuLabel);

        voteButton.setText("Vote");
        voteButton.setBounds(180, 70, 150, 30);
        voteButton.setFocusable(false);
        voteButton.addActionListener(this);
        container.add(voteButton);

        viewButton.setText("View Candidate");
        viewButton.setBounds(180, 120, 150, 30);
        viewButton.setFocusable(false);
        viewButton.addActionListener(this);
        container.add(viewButton);

        backButton.setText("Back");
        backButton.setBounds(180, 170, 150, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        container.add(backButton);


        frame.add(container);
        frame.setTitle("Voting Menu");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==voteButton){
            frame.setVisible(false);
            vote.vote();
        } else if (e.getSource()==viewButton) {
            frame.setVisible(false);
            new UserViewCandidate();
        } else if (e.getSource()==backButton) {
            frame.setVisible(false);
            new UserMenu();
        }
    }
}
