import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetCandidate extends JFrame implements ActionListener {

    CandidateInfo candidateInfo = new CandidateInfo();
    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel serialLabel = new JLabel();
    JLabel nameLabel = new JLabel();
    JTextField serialTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JButton saveButton = new JButton();
    JButton resetButton = new JButton();
    JButton backButton = new JButton();

    public  SetCandidate(){
        container.setLayout(null);

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
        frame.setTitle("Set Candidate");
        frame.setSize(500, 400);
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
            candidateInfo.serial.add(serialText);
            candidateInfo.name.add(nameText);
            candidateInfo.list.add(0);
            JOptionPane.showMessageDialog(this,"Save Successful");
            serialTextField.setText("");
            nameTextField.setText("");
        } else if (e.getSource()==resetButton) {
            frame.setVisible(false);
            new AdminMenu();
        }
    }
}
