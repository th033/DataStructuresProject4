



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
     * Class Name: GUI
     * Class Author: Tyler Hockett
     * **************************
     * Purpose of the Class
     * ineract with the user to load
     * words into the binarytree
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     * Date Changed:10/3/2017
     * 10/7/2017
     * **************************
     * Look At This!
     * 
     * **************************
     */
public class GUI extends javax.swing.JFrame {

    Ladder myLadder=new Ladder();;
    String fullString="";
    File myFile;
    BufferedReader buff;
    String toSeperate="";
    public GUI() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAAnswer = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        txtAdd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        fcLoad = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAAnswer.setColumns(20);
        txtAAnswer.setRows(5);
        jScrollPane1.setViewportView(txtAAnswer);

        btnAdd.setText("Add to Tree");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setText("Text to add:");

        btnPrint.setText("See the Tree");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        fcLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPrint)))
                        .addContainerGap(310, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fcLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fcLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd))
                    .addComponent(btnPrint))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 /**
     * Method Name: btnPrintActionPerformed
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to print the tree to the text area
     * txtAAnswer
     * **************************
     * Date: 10/3/2017 USA
     * **************************
     *
     */
    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        String answer=myLadder.printOut();
        txtAAnswer.setText(answer);
        
    }//GEN-LAST:event_btnPrintActionPerformed
 /**
     * Method Name: fcLoadActionPerformed
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * load the file selected and add it to tree
     * I was struggling with this one since
     * it had been more than a year, and I 
     * had never done it in java
     * **************************
     * Date: 10/7/2017 USA
     * **************************
     *
     */
    private void fcLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcLoadActionPerformed
        FileReader read = null;
        
        try {
            myFile=fcLoad.getSelectedFile();
            read = new FileReader(myFile);
            buff= new BufferedReader(read);
            toLadder();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                read.close();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_fcLoadActionPerformed
 /**
     * Method Name: btnAddActionPerformed
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * pass the text from the txtAdd to the 
     * toLadder method
     * **************************
     * Date: 10/3/2017 USA
     * **************************
     *
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        myLadder.add(stripPunctuation(txtAdd.getText()));        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed
     /**
     * Method Name: toLadder
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * add words to the ladder to be 
     * added to the tree
     * **************************
     * Date: 10/3/2017 USA
     * **************************
     *
     */
    public void toLadder()
    {
        try 
        {
            do
            {
            toSeperate=buff.readLine();
            String[] Words = toSeperate.split("\\s+");
            for(int i=0; i<Words.length;i++)
            {
             myLadder.add(stripPunctuation(Words[i]));
            }
            }while (buff.readLine()!=null);
        } catch (IOException ex) 
        {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     /**
     * Method Name: stripPunctuation
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * this is going to check if the characters
     * in a word are letters and if not it 
     * will remove the character
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     *
     */
    public static String stripPunctuation(String fullString) 
    {
        StringBuilder build = new StringBuilder();
        for (int i=0; i < fullString.length(); i++) 
        {
            if (Character.isLetter(fullString.charAt(i))) 
            {
               build.append(fullString.charAt(i));
            }
        }
        return build.toString();
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnPrint;
    private javax.swing.JFileChooser fcLoad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAAnswer;
    private javax.swing.JTextField txtAdd;
    // End of variables declaration//GEN-END:variables
}
