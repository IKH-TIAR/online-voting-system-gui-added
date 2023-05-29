import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveCandidate extends JFrame implements ActionListener {
    CandidateInfo candidateInfo = new CandidateInfo();
    JFrame frame = new JFrame();
    Container container = new Container();
    JLabel serialLabel = new JLabel();
    JLabel nameLabel = new JLabel();
    JTextField serialTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JButton removeButton = new JButton();
    JButton resetButton = new JButton();
    JButton backButton = new JButton();

    void removeCandidate() {
        if(candidateInfo.serial.isEmpty()){
            JOptionPane.showMessageDialog(this,"No Candidate");
            new AdminMenu();
            return;
        }
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

        removeButton.setText("Remove");
        removeButton.setBounds(60, 120, 150, 30);
        removeButton.setFocusable(false);
        removeButton.addActionListener(this);
        container.add(removeButton);

        resetButton.setText("Reset");
        resetButton.setBounds(240, 120, 150, 30);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        container.add(resetButton);

        backButton.setText("Back");
        backButton.setBounds(145, 180, 150, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        container.add(backButton);


        frame.add(container);
        frame.setTitle("Remove Candidate");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==removeButton){
            String serial = serialTextField.getText();
            String name = nameTextField.getText();
            if(!candidateInfo.serial.contains(serial)){
                JOptionPane.showMessageDialog(this,"No Candidate with this serial");
                serialTextField.setText("");
                nameTextField.setText("");
                return;
            } else if (!candidateInfo.name.contains(name)) {
                JOptionPane.showMessageDialog(this,"No Candidate with this Name");
                serialTextField.setText("");
                nameTextField.setText("");
                return;

            } else if(serial.isEmpty() || name.isEmpty()){
                JOptionPane.showMessageDialog(this,"Missing");
                return;
            }
            int index = candidateInfo.serial.indexOf(serial);
            candidateInfo.serial.remove(index);
            candidateInfo.name.remove(index);
            candidateInfo.list.remove(index);
            JOptionPane.showMessageDialog(this,"Remove Successful");
            serialTextField.setText("");
            nameTextField.setText("");
        }else if (e.getSource()==resetButton) {
            serialTextField.setText("");
            nameTextField.setText("");
        } else if (e.getSource()==backButton) {
            frame.setVisible(false);
            new AdminMenu();
        }

    }
}
