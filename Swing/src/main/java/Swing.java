import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Swing {



    public static void main(String[] args) {
        ForexUs forexUs = new ForexUs();
        ForexAu forexAu = new ForexAu();

        JFrame f=new JFrame("台灣銀行匯率");
        final JTextField au=new JTextField();
        au.setBounds(120,100,250,30);
        JButton a = new JButton("查詢當天澳幣");
        a.setBounds(180,200,120,30);

        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    au.setText(forexAu.getForex());
                }catch (IOException ex){
                    ex.printStackTrace();
                }

            }
        });

        final JTextField us=new JTextField();
        us.setBounds(120,135, 250,30);
        JButton b=new JButton("查詢當天美金");
        b.setBounds(180,235,120,30);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                try {
                    us.setText(forexUs.getForex());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        f.add(a);
        f.add(au);
        f.setSize(500,500);
        f.add(b);
        f.add(us);
        f.setSize(500,500);
        f.getContentPane().setBackground(new Color(0x123445));
        f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);






    }
}
