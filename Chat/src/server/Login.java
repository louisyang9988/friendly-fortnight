import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 *
 * @author Yang
 */
public class Login implements ActionListener{
  Frame f;
  TextField t;
  JButton b;
    public Login()
    {
    f = new Frame();
    f.setSize(100, 100);
    t = new TextField();
    b =new JButton("Submit");
    b.addActionListener(this);
    f.add(t);
    f.add(b);
    f.setVisible(true);
    
    
    
    
    
    }
    
   
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
     
      f.setVisible(false);  ; //To change body of generated methods, choose Tools | Templates.
    }
    
}
    
    
    
    
    
    
    
    