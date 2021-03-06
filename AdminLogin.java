
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class AdminLogin extends javax.swing.JFrame {
    int w,h;
   public AdminLogin() {
        initComponents();
        setSize(852,480);
        setLocationRelativeTo(null);
        setResizable(false);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfusername = new javax.swing.JTextField();
        tfpassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btlogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tfusername.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tfusername.setForeground(new java.awt.Color(255, 255, 255));
        tfusername.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        tfusername.setCaretColor(new java.awt.Color(255, 255, 255));
        tfusername.setMargin(new java.awt.Insets(0, 0, 0, 0));
        tfusername.setOpaque(false);
        tfusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfusernameActionPerformed(evt);
            }
        });
        getContentPane().add(tfusername);
        tfusername.setBounds(300, 130, 230, 40);

        tfpassword.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tfpassword.setForeground(new java.awt.Color(255, 255, 255));
        tfpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        tfpassword.setCaretColor(new java.awt.Color(255, 255, 255));
        tfpassword.setOpaque(false);
        tfpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(tfpassword);
        tfpassword.setBounds(300, 230, 230, 40);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage(15).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 230, 50, 40);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage(14).png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 130, 50, 40);

        btlogin.setBackground(new java.awt.Color(0, 0, 0));
        btlogin.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        btlogin.setText("Login");
        btlogin.setOpaque(false);
        btlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btloginActionPerformed(evt);
            }
        });
        getContentPane().add(btlogin);
        btlogin.setBounds(360, 330, 120, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("   Admin Login");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(220, 40, 360, 60);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage (17)1.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 883, 497);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfusernameActionPerformed

    private void tfpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfpasswordActionPerformed

    private void btloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btloginActionPerformed
        String u,p;
        
        u=tfusername.getText();
        p=tfpassword.getText();
        if(u.equals("")||p.equals(""))
        {
        }
        else
        {
            try {
            HttpResponse<String> response= Unirest.get(GlobalData.hostname+"/AdminLogin")
                    .queryString("username",u)
                    .queryString("password",p)
                    .asString();
            
            if (response.getBody().equals("Login Successfull !!!"))
            {
                GlobalData.nameofadmin=u;
                new adminhome().setVisible(true);
            
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Invalid Username/Password");
            
            }
            
                
        }
        
        catch (UnirestException ex) 
        {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
    }//GEN-LAST:event_btloginActionPerformed

    
    public static void main(String args[]) {

        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminLogin().setVisible(true);
                }
            });
            
            //</editor-fold>
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField tfpassword;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
