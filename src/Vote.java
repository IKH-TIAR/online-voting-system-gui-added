import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vote extends JFrame implements ActionListener {

    CandidateInfo candidateInfo = new CandidateInfo();
    UserLogin userLogin = new UserLogin();
    UserInfo userInfo = new UserInfo();
    String username="";
    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel serialLabel = new JLabel();
    JLabel nameLabel = new JLabel();
    JTextField serialTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JButton voteButton = new JButton();
    JButton backButton = new JButton();

    public void vote(){
        container.setLayout(null);
        if(candidateInfo.serial.isEmpty()){
            JOptionPane.showMessageDialog(this,"No Candidate");
            new VotingMenu();
            return;
        }
        serialLabel.setText("Candidate Serial");
        serialLabel.setBounds(70, 20, 100, 50);
        container.add(serialLabel);

        nameLabel.setText("Candidate Name");
        nameLabel.setBounds(70, 70, 100, 50);
        container.add(nameLabel);

        serialTextField.setBounds(170, 33, 150, 30);
        container.add(serialTextField);

        nameTextField.setBounds(170, 83, 150, 30);
        container.add(nameTextField);

        voteButton.setText("Vote");
        voteButton.setBounds(60, 120, 150, 30);
        voteButton.setFocusable(false);
        voteButton.addActionListener(this);
        container.add(voteButton);

        backButton.setText("Back");
        backButton.setBounds(240, 120, 150, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        container.add(backButton);


        frame.add(container);
        frame.setTitle("Set Candidate");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==voteButton){
            int check = userLogin.checkVoted();
            if(check==1){
                new VotingMenu();
                return;
            }
            String serial = serialTextField.getText();
            String name = nameTextField.getText();
            if(serial.isEmpty() || name.isEmpty()){
                JOptionPane.showMessageDialog(this,"Some Field Missing");
                return;
            }
            int index=candidateInfo.serial.indexOf(serial);
            int voteCount = candidateInfo.list.get(index);
            voteCount+=1;
            candidateInfo.list.set(index,voteCount);
            userLogin.notVoted();
            JOptionPane.showMessageDialog(this,"Vote Complete");
            serialTextField.setText("");
            nameTextField.setText("");
            frame.setVisible(false);
            new VotingMenu();

        } else if (e.getSource()==backButton) {
            frame.setVisible(false);
            new VotingMenu();
        }
    }

    void voteAction(){

    }
}
