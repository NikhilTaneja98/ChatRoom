
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;

public class joinroom extends javax.swing.JFrame {

    int roomid;
    int w, h;
    String emojispics[] = {"src/emojis/Webp.net-resizeimage(19).png", "src/emojis/Webp.net-resizeimage(20).png", "src/emojis/Webp.net-resizeimage(21).png", "src/emojis/Webp.net-resizeimage(22).png",
        "src/emojis/Webp.net-resizeimage(23).png", "src/emojis/Webp.net-resizeimage(25).png", "src/emojis/Webp.net-resizeimage(26).png",
        "src/emojis/Webp.net-resizeimage(27).png","src/emojis/Webp.net-resizeimage(28).png","src/emojis/Webp.net-resizeimage(18).png"};
    String emojisymbol[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public joinroom(int roomid) {
        initComponents();
        this.roomid = roomid;
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        w = d.width;
        h = d.height;
        setSize(d);
        setResizable(false);
        getroomdetails();
        checkroomjoin();
        getmembersofroom();
        getemojis();
        showmessage.setEditable(false);
        showmessage.setFocusable(false);
        Timer timer = new Timer();
        Thread t1 = new Thread(new MyClass());
        t1.start();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                new Thread(new MyClass()).start();
            }
        }, 5000, 5000);

        joinedmem.setEditable(false);
        joinedmem.setFocusable(false);
        showmessage.setBorder(null);
        jScrollPane1.setBorder(null);
        jScrollPane2.setBorder(null);
        joinedmem.setBorder(null);
        showmessage.setOpaque(true);
        joinedmem.setOpaque(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photo1 = new javax.swing.JLabel();
        category1 = new javax.swing.JLabel();
        joinbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showmessage = new javax.swing.JEditorPane();
        chat = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        attachimg = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        attachdoc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        joinedmem = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        roomname1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);

        photo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(photo1);
        photo1.setBounds(20, 10, 250, 190);

        category1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(category1);
        category1.setBounds(20, 230, 250, 40);

        joinbutton.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        joinbutton.setText("Join");
        joinbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(joinbutton);
        joinbutton.setBounds(290, 10, 160, 30);

        showmessage.setBorder(null);
        jScrollPane1.setViewportView(showmessage);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(290, 50, 1010, 490);

        chat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chat.setOpaque(false);
        chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatActionPerformed(evt);
            }
        });
        getContentPane().add(chat);
        chat.setBounds(290, 550, 820, 60);

        send.setBackground(new java.awt.Color(255, 255, 255));
        send.setForeground(new java.awt.Color(255, 255, 255));
        send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage (3).png"))); // NOI18N
        send.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        send.setBorderPainted(false);
        send.setContentAreaFilled(false);
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        getContentPane().add(send);
        send.setBounds(1110, 550, 64, 60);

        attachimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage (8).png"))); // NOI18N
        attachimg.setContentAreaFilled(false);
        attachimg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachimgActionPerformed(evt);
            }
        });
        getContentPane().add(attachimg);
        attachimg.setBounds(1170, 550, 64, 64);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(290, 620, 990, 60);

        attachdoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage(9).png"))); // NOI18N
        attachdoc.setContentAreaFilled(false);
        attachdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachdocActionPerformed(evt);
            }
        });
        getContentPane().add(attachdoc);
        attachdoc.setBounds(1230, 550, 64, 64);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        joinedmem.setEditable(false);
        joinedmem.setColumns(20);
        joinedmem.setRows(5);
        joinedmem.setBorder(null);
        joinedmem.setOpaque(false);
        jScrollPane2.setViewportView(joinedmem);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 370, 160, 290);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel1.setText("Current Members");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 340, 240, 30);

        roomname1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(roomname1);
        roomname1.setBounds(20, 210, 250, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage(23).jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1500, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void joinbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinbuttonActionPerformed
        try {
            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/joinroom")
                    .queryString("username", GlobalData.nameofuser)
                    .queryString("roomid", roomid)
                    .asString();
            if (response.getBody().equals("no")) {
                joinbutton.setEnabled(false);
                joinbutton.setText("Joined");
                joinedmem.setVisible(true);
                showmessage.setVisible(true);
                chat.setVisible(true);
                send.setVisible(true);
                attachimg.setVisible(true);
                attachdoc.setVisible(true);
                jPanel1.setVisible(true);
                jLabel1.setVisible(true);
                getmembersofroom();
            } else {
                joinbutton.setText("Join");
            }
        } catch (UnirestException ex) {
            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_joinbuttonActionPerformed

    private void chatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatActionPerformed

    }//GEN-LAST:event_chatActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        String msg = chat.getText();
        if(msg.equals(""))
        {
        }
        else
        {
           try {
            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/addtextmsg")
                    .queryString("msg", msg)
                    .queryString("msgtype", "text")
                    .queryString("username", GlobalData.nameofuser)
                    .queryString("roomid", roomid)
                    .asString();
                    chat.setText("");
                    chat.requestFocus();

        } catch (UnirestException ex) {
            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        
    }//GEN-LAST:event_sendActionPerformed

    private void attachimgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachimgActionPerformed
        File f;
        JFileChooser jfc = new JFileChooser("C:\\Users\\acer\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpeg", "jpg", "bmp", "png", "gif");
        jfc.setFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);
        int ans = jfc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            try {
                f = jfc.getSelectedFile();
                HttpResponse<String> response = Unirest.post(GlobalData.hostname + "/addfilemsg")
                        .queryString("username", GlobalData.nameofuser)
                        .queryString("roomid", roomid)
                        .queryString("msgtype", "image")
                        .field("msg", f)
                        .asString();

            } catch (UnirestException ex) {
                Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_attachimgActionPerformed

    private void attachdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachdocActionPerformed
        File f;
        JFileChooser jfc = new JFileChooser("C:\\Users\\acer\\Downloads");
         FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "txt", "doc", "docx", "xsl");
        jfc.setFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);
       
        int ans = jfc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            try {
                f = jfc.getSelectedFile();
                HttpResponse<String> response = Unirest.post(GlobalData.hostname + "/addfilemsg")
                        .queryString("username", GlobalData.nameofuser)
                        .queryString("roomid", roomid)
                        .queryString("msgtype", "file")
                        .field("msg", f)
                        .asString();

            } catch (UnirestException ex) {
                Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_attachdocActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    //new joinroom().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attachdoc;
    private javax.swing.JButton attachimg;
    private javax.swing.JLabel category1;
    private javax.swing.JTextField chat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton joinbutton;
    private javax.swing.JTextArea joinedmem;
    private javax.swing.JLabel photo1;
    private javax.swing.JLabel roomname1;
    private javax.swing.JButton send;
    private javax.swing.JEditorPane showmessage;
    // End of variables declaration//GEN-END:variables

    private void getroomdetails() {
        ImageIcon icon = new ImageIcon("");
        BufferedImage bufferedImage, newimage;

        try {
            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/getroomdetails")
                    .queryString("roomid", roomid)
                    .asString();
            String ans = response.getBody();
            StringTokenizer st = new StringTokenizer(ans, "~~");
            String roomname = st.nextToken();
            String category = st.nextToken();
            String photo = st.nextToken();
            roomname1.setText(roomname);
            category1.setText(category);
            try {
                URL url = new URL(GlobalData.hostname + "/GetResource/" + photo);
                System.out.println("url : " + url);
                bufferedImage = ImageIO.read(url);
                newimage = resizephoto(bufferedImage, photo1.getWidth(), photo1.getHeight());
                icon = new ImageIcon(newimage);
                photo1.setIcon(icon);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (UnirestException ex) {
            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    BufferedImage resizephoto(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    private void checkroomjoin() {
        try {
            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/checkroomjoin")
                    .queryString("roomid", roomid)
                    .queryString("username", GlobalData.nameofuser)
                    .asString();
            if (response.getBody().equals("yes")) {
                joinbutton.setText("Joined");
                joinbutton.setEnabled(false);

            } else {
                joinedmem.setVisible(false);
                showmessage.setVisible(false);
                chat.setVisible(false);
                send.setVisible(false);
                attachimg.setVisible(false);
                attachdoc.setVisible(false);
                jPanel1.setVisible(false);
                jLabel1.setVisible(false);
            }

        } catch (UnirestException ex) {
            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getemojis() {
        JLabel lb[] = new JLabel[emojispics.length];
        int i = 0;

        for (i = 0; i < lb.length; i++) {
            final int j = i;
            try {
                lb[i] = new JLabel();
                BufferedImage img = ImageIO.read(new File(emojispics[i]));
                BufferedImage newimg = resizephoto(img, 50, 50);
                lb[i].setIcon(new ImageIcon(newimg));
                String sm = emojisymbol[j];
                lb[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            String msg = sm;
                            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/addtextmsg")
                                    .queryString("msg", msg)
                                    .queryString("msgtype", "emoji")
                                    .queryString("username", GlobalData.nameofuser)
                                    .queryString("roomid", roomid)
                                    .asString();

                        } catch (UnirestException ex) {
                            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                });
                jPanel1.add(lb[i]);

            } catch (IOException ex) {
                Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void scrollToBottom(JScrollPane scrollPane) {
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }

        };
        verticalBar.addAdjustmentListener(downScroller);
    }

    private void getmembersofroom() {
        String ans1 = "";
        try {
            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/getmembersofroom")
                    .queryString("roomid", roomid)
                    .asString();
            String ans = response.getBody();
            System.out.println("AAAAAAAAAAAAAAAAA" + ans);
            StringTokenizer st = new StringTokenizer(ans, "~~");

            while (st.hasMoreTokens()) {
                String display = st.nextToken();
                System.out.println("TOKENSSS" + display);
                ans1 = ans1 + display + "\n";

            }
            joinedmem.setText(ans1);

        } catch (UnirestException ex) {
            Logger.getLogger(joinroom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class MyClass implements Runnable {

        @Override
        public void run() {
            try {
                HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/fetchmessages")
                        .queryString("roomid", roomid)
                        .asString();
                if (response.getStatus() == 200) {
                    String ans = response.getBody();
                    System.out.println("ans::" + ans);
                    StringTokenizer st = new StringTokenizer(ans, ";;");
                    String msg = "";
                    showmessage.setContentType("text/html");
                    while (st.hasMoreTokens()) {
                        String row = st.nextToken();
                        StringTokenizer col = new StringTokenizer(row, "~~");
                        String message = col.nextToken();
                        String postedby = col.nextToken();
                        String datetime = col.nextToken();
                        String dispname = col.nextToken();
                        String msgtype = col.nextToken();
                        System.out.println("COL" + col);
                        System.out.println("Message" + message);
                        System.out.println("PostedBy" + postedby);
                        System.out.println("DATETIME" + datetime);
                        System.out.println("DISPLAYANME" + dispname);
                        System.out.println("MSGTYPE" + msgtype);
//                    imgsrc = new File("passport.jpg").toURL().toExternalForm();
                        if (msgtype.equals("text")) {
                            if (postedby.equals(GlobalData.nameofuser)) {
                                msg += "<div style='text-align: right;background-color: #FFC0CB;margin-left:200px;margin-bottom: 10px;border: #000 solid medium'><h3><b>" + message + "</b></h3>";
                                msg += "<p>" + dispname + " " + datetime + "</p></div>";
                            } else {
                                msg += "<div style='text-align: left;background-color: #4FFFCE4;margin-right:200px;margin-bottom: 10px;border: #000 solid medium'><h3><b>" + message + "</b></h3>";
                                msg += "<p>" + dispname + " " + datetime + "</p></div>";
                            }
                        } else if (msgtype.equals("image")) {
                            if (postedby.equals(GlobalData.nameofuser)) {
                                msg += "<div style='text-align: right;background-color: #FFC0CB;margin-left:200px;margin-bottom: 10px;border: #000 solid medium'><img src='file:" + message + "' width='200' height='200' />";
                                msg += "<p>" + dispname + " " + datetime + "</p></div>";
                            } else {
                                msg += "<div style='text-align: left;background-color: #4FFFCE4;margin-bottom: 10px;margin-right:200px;border: #000 solid medium'><img src='file:" + message + "' width='200' height='200' />";
                                msg += "<p>" + dispname + " " + datetime + "</p></div>";
                            }
                        } else if (msgtype.equals("emoji")) {
                            for (int i = 0; i < emojisymbol.length; i++) {
                                if (message.equals(emojisymbol[i])) {
                                    if (postedby.equals(GlobalData.nameofuser)) {
                                        msg += "<div style='text-align: right;background-color: #FFC0CB;margin-bottom: 10px;margin-left:200px;border: #000 solid medium'><img src='file:" + emojispics[i] + "' width='50' height='50' />";
                                        msg += "<p>" + dispname + " " + datetime + "</p></div>";
                                    } else {
                                        msg += "<div style='text-align: left;background-color: #4FFFCE4;margin-bottom: 10px;margin-right:200px;border: #000 solid medium'><img src='file:" + emojispics[i] + "' width='50' height='50' />";
                                        msg += "<p>" + dispname + " " + datetime + "</p></div>";
                                    }
                                }

                            }
                        } else if (msgtype.equals("file")) {

                            if (postedby.equals(GlobalData.nameofuser)) {
                                msg += "<div  style='text-align: right;background-color: #FFC0CB;margin-bottom: 10px;margin-left:200px;border: #000 solid medium'><a href=http://'" + message + "'> <img src='file:src/backgroundicons/Webp.net-resizeimage(9).png' width='70' height='70' /></a>";
                                msg += "<p>" + dispname + " " + datetime + "</p></div>";
                            } else {
                                msg += "<div  style='text-align: left;background-color: #4FFFCE4;margin-bottom: 10px;margin-right:200px;border: #000 solid medium'><a href=http://'" + message + "'><img src='file:src/emojis/doc.jfif' width='70' height='70' /></a>";
                                msg += "<p>" + dispname + " " + datetime + "</p></div>";

                            }
                        }
                    }
                    showmessage.setText(msg);
                    showmessage.setEditable(false);
                    showmessage.setFocusable(false);
                    scrollToBottom(jScrollPane1);

                    showmessage.addHyperlinkListener(new HyperlinkListener() {

                        @Override
                        public void hyperlinkUpdate(HyperlinkEvent he) {
                            if (he.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                                URL value = he.getURL();
                                String val = value.toString();
                                String extension = val.substring(val.indexOf("."));
                                String path = val.substring(val.indexOf("/") + 2);
                                System.out.println("Actual URL" + he.getURL());
                                int ans = JOptionPane.showConfirmDialog(rootPane, "do you want to download the file??");
                                if (ans == JOptionPane.YES_OPTION) {
                                    try {
                                        HttpResponse<InputStream> response = Unirest.get(GlobalData.hostname + "/GetResource/" + path)
                                                .asBinary();
                                        InputStream is = response.getBody();
                                        FileOutputStream fos;
                                        System.out.println("responsebody is" + is);
                                        String fname = new Date().getTime() + "" + extension;
                                        fos = new FileOutputStream(System.getProperty("user.home") + "/Downloads/" + fname);
                                        long contentlength = Integer.parseInt(response.getHeaders().getFirst("Content-Length"));
                                        byte b[] = new byte[10000];
                                        int r;
                                        long count = 0;
                                        while (true) {
                                            r = is.read(b, 0, 10000);
                                            fos.write(b, 0, r);
                                            count = count + r;
                                            System.out.println(count * 100 / contentlength + " %");
                                            if (count == contentlength) {
                                                break;
                                            }
                                        }
                                        fos.close();
                                        System.out.println("fikle downloaded");
                                        System.out.println("File Downloaded....");
                                        File f = new File(System.getProperty("user.home") + "\\Downloads\\" + fname);
                                        URI u = f.toURI();
                                        Desktop d = Desktop.getDesktop();
                                        d.browse(u);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        }

                    }
                    );

                }
            } catch (UnirestException ex) {
                ex.printStackTrace();
            }
        }
    }

}