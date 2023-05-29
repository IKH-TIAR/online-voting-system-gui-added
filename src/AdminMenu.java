import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu implements ActionListener {
    ViewCandidate view = new ViewCandidate();
    ViewVote vote = new ViewVote();
    SetWinner winner = new SetWinner();
    RemoveCandidate remove = new RemoveCandidate();
    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel labelText = new JLabel();
    JButton setCandidate = new JButton();
    JButton removeCandidate = new JButton();
    JButton viewCandidate = new JButton();
    JButton setWinner = new JButton();
    JButton viewVote = new JButton();
    JButton backButton = new JButton();

    public  AdminMenu(){
        container.setLayout(null);
        labelText.setText("Welcome Admin");
        labelText.setBounds(210, 20, 100, 50);
        container.add(labelText);

        setCandidate.setText("Set Candidate");
        setCandidate.setBounds(180, 70, 150, 30);
        setCandidate.setFocusable(false);
        setCandidate.addActionListener(this);
        container.add(setCandidate);

        removeCandidate.setText("Remove Candidate");
        removeCandidate.setBounds(180, 120, 150, 30);
        removeCandidate.setFocusable(false);
        removeCandidate.addActionListener(this);
        container.add(removeCandidate);

        viewCandidate.setText("View Candidate");
        viewCandidate.setBounds(180, 170, 150, 30);
        viewCandidate.setFocusable(false);
        viewCandidate.addActionListener(this);
        container.add(viewCandidate);

        setWinner.setText("Set Winner");
        setWinner.setBounds(180, 220, 150, 30);
        setWinner.setFocusable(false);
        setWinner.addActionListener(this);
        container.add(setWinner);

        viewVote.setText("View All Vote");
        viewVote.setBounds(180, 270, 150, 30);
        viewVote.setFocusable(false);
        viewVote.addActionListener(this);
        container.add(viewVote);

        backButton.setText("Back");
        backButton.setBounds(180, 320, 150, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        container.add(backButton);

        frame.add(container);
        frame.setTitle("Admin Menu");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            frame.setVisible(false);
            new Menu();
        } else if (e.getSource()==setCandidate) {
            frame.setVisible(false);
            new SetCandidate();
        } else if (e.getSource()==viewCandidate) {
            frame.setVisible(false);
            view.viewCandidate();
        } else if (e.getSource()==removeCandidate) {
            frame.setVisible(false);
            remove.removeCandidate();
        } else if (e.getSource()==viewVote) {
            frame.setVisible(false);
            vote.viewVote();
        } else if (e.getSource()==setWinner) {
            frame.setVisible(false);
            winner.setWinner();
        }

    }

}
