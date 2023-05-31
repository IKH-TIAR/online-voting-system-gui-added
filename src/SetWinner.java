import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    public class SetWinner extends JFrame implements ActionListener {

        CandidateInfo candidateInfo = new CandidateInfo();
        static String winnerSerial= "";
        static String winnerName = "";
        static int winnerVote;
        JFrame frame = new JFrame();
        Container container = new Container();
        JLabel serialLabel = new JLabel();
        JLabel nameLabel = new JLabel();
        JTextField serialTextField = new JTextField();
        JTextField nameTextField = new JTextField();
        JButton saveButton = new JButton();
        JButton resetButton = new JButton();
        JButton backButton = new JButton();
        JButton viewBackButton = new JButton();
        JLabel winnerSerialLabel = new JLabel();
        JLabel winnerNameLabel = new JLabel();
        JLabel winnerVoteLabel = new JLabel();


        public void  setWinner(){

            if(candidateInfo.serial.isEmpty()){
                JOptionPane.showMessageDialog(this,"No Candidate");
                new AdminMenu();
                return;
            }
            container.setLayout(null);
            serialLabel.setText("Candidate Serial ");
            serialLabel.setBounds(70, 20, 100, 50);
            container.add(serialLabel);

            nameLabel.setText("Candidate Name");
            nameLabel.setBounds(70, 70, 100, 50);
            container.add(nameLabel);

            serialTextField.setBounds(170, 33, 150, 30);
            container.add(serialTextField);

            nameTextField.setBounds(170, 83, 150, 30);
            container.add(nameTextField);

            saveButton.setText("Save");
            saveButton.setBounds(60, 120, 150, 30);
            saveButton.setFocusable(false);
            saveButton.addActionListener(this);
            container.add(saveButton);

            resetButton.setText("Back");
            resetButton.setBounds(240, 120, 150, 30);
            resetButton.setFocusable(false);
            resetButton.addActionListener(this);
            container.add(resetButton);



            frame.add(container);
            frame.setTitle("Set Winner");
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==saveButton){
                String serialText = serialTextField.getText();
                String nameText = nameTextField.getText();
                if(serialText.isEmpty() || nameText.isEmpty()){
                    JOptionPane.showMessageDialog(this,"Missing");
                    return;
                }
                int index = candidateInfo.serial.indexOf(serialText);
                winnerSerial = candidateInfo.serial.get(index);
                winnerName = candidateInfo.name.get(index);
                winnerVote = candidateInfo.list.get(index);
                JOptionPane.showMessageDialog(this,"Save Successful");
                frame.setVisible(false);
                new AdminMenu();
            } else if (e.getSource()==resetButton) {
                frame.setVisible(false);
                new AdminMenu();
            }  else if (e.getSource()==viewBackButton) {
                frame.setVisible(false);
                new Menu();
            }
        }

        void viewWinner(){
            if(winnerSerial.isEmpty()){
                JOptionPane.showMessageDialog(this,"N0 Winner");
                new Menu();
                return;
            }
            container.setLayout(null);

            winnerSerialLabel.setText("Winner Serial "+winnerSerial);
            winnerSerialLabel.setBounds(70, 20, 100, 50);
            container.add(winnerSerialLabel);

            winnerNameLabel.setText("Winner Name "+winnerName);
            winnerNameLabel.setBounds(70, 70, 100, 50);
            container.add(winnerNameLabel);

            winnerVoteLabel.setText("Winner Vote "+winnerVote);
            winnerVoteLabel.setBounds(70, 120, 100, 50);
            container.add(winnerVoteLabel);

            viewBackButton.setText("Back");
            viewBackButton.setBounds(145, 170, 150, 30);
            viewBackButton.setFocusable(false);
            viewBackButton.addActionListener(this);
            container.add(viewBackButton);


            frame.add(container);
            frame.setTitle("Set Candidate");
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
