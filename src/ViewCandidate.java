import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCandidate extends JFrame implements ActionListener {

    CandidateInfo candidateInfo = new CandidateInfo();
    JFrame frame = new JFrame();
    Container container = new Container();
    JButton backButton = new JButton("Back");

    public void  viewCandidate(){
        container.setLayout(null);
        String[] column={"Serial","Name"};
        if(candidateInfo.serial.isEmpty()){
            JOptionPane.showMessageDialog(this,"No Candidate");
            new AdminMenu();
            return;
        }
        DefaultTableModel model = new DefaultTableModel(column, 0);
        for (int i = 0; i < candidateInfo.serial.size(); i++) {
            String serial = candidateInfo.serial.get(i);
            String name = candidateInfo.name.get(i);
            model.addRow(new Object[]{serial, name});
        }

        backButton.setFocusable(false);
        backButton.addActionListener(this);
        JTable table = new JTable(model);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);


        frame.setTitle("View Candidate");
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            frame.setVisible(false);
            new AdminMenu();
        }
    }
}
