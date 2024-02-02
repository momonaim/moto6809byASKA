import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.Border;

public class ROM extends JFrame {
    private JTable table;
    public DefaultTableModel model;
    private Point init;

    public ROM() {
        setUndecorated(true);
        //setResizable(false);
        setTitle("ROM");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(150, 250);
        setLocation(570, 150);
        //setLocationRelativeTo(null);
        
       
        
        // Create the table
        table = new JTable();
        model = new DefaultTableModel(new Object[]{"", ""}, 0){
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        table.setModel(model);

        // Add rows to the table
        for (int i = 0xFC00; i <= 0xFFFF; i++) {
            String hexValue = String.format("%04X", i);
            String decimalValue = String.format("%02X", 0XFF);
            model.addRow(new Object[]{hexValue, decimalValue});
        }
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        //titleBAR
        JPanel t=new JPanel();
        t.setLayout(new BorderLayout());
        t.setBackground(Color.WHITE);
        Border border=BorderFactory.createLineBorder(Color.BLACK);
        t.setBorder(border);
        JLabel j=new JLabel("ROM");
        j.setHorizontalAlignment(JLabel.CENTER);
        t.add(j,BorderLayout.CENTER);
        add(t,BorderLayout.NORTH);
        
        //set the deplacemme avec Mouse drag
         t.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                init = e.getPoint();
                getComponentAt(init);
            }
        });
         t.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getXOnScreen() - init.x;
                int deltaY = e.getYOnScreen() - init.y;
                setLocation(deltaX,deltaY);
            }
        });


        
        
        // Add the table to the frame
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

}

