
package ch.unizh.ini.jaer.projects.bjoernbeyer.stimulusdisplay;

import javax.swing.table.DefaultTableModel;
import net.sf.jaer.util.Vector2D;

/** Used together with 'StimulusDisplayGUI' to create linear paths that can be
 * attached to paintable Objects for display.
 * @author Bjoern */
public class LinearPathDesignerGUI extends javax.swing.JFrame {
    private DefaultTableModel pathTableModel;
    private StimulusFrame stimFrame;
    private MouseTrajectory linearPath;
    private long elapsedTime = 0;
    
    /**
     * Creates new form LinearPathDesignerGUI
     * @param stimFrame the stimulusFrame class that keeps all the created objects
     */
    public LinearPathDesignerGUI(StimulusFrame stimFrame) {
        initComponents();
        this.stimFrame = stimFrame;
        pathTableModel = (DefaultTableModel) pathPointTable.getModel();
        linearPath = new MouseTrajectory();
        PasteFromClipboard myAd = new PasteFromClipboard(pathPointTable); //For Copy/Past functionality
    }
    
    public LinearPathDesignerGUI() {
        this(new StimulusFrame());
    }

    private void addLinearPathBetweenPoints(Vector2D startPoint, Vector2D endPoint, float speed, int fps) {
        Vector2D dist       = new Vector2D(),
                 curPoint   = new Vector2D();
        dist.setDifference(endPoint, startPoint);
        
        if(dist.length()==0)return;
        
        curPoint.setLocation(startPoint);
        
        float timeSeconds  = (float) dist.length()/speed;
        int numberUpdates  = (int) Math.ceil(timeSeconds*fps);
        long tempDiffNanos = (long)(((float)1/fps)*1e9); //We need the temporal difference between two points in nanoseconds

        dist.div(numberUpdates);
        for(int j =1;j<=numberUpdates;j++) {
            elapsedTime += (long)(j*tempDiffNanos);
            curPoint.add(dist);
            linearPath.add(new MouseTrajectoryPoint(elapsedTime,tempDiffNanos,curPoint.x,curPoint.y));
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pathPointTable = new javax.swing.JTable();
        infoTXT = new javax.swing.JTextArea();
        saveCloseBUT = new javax.swing.JButton();
        clearBUT = new javax.swing.JButton();
        addRowBUT = new javax.swing.JButton();
        deleteRowBUT = new javax.swing.JButton();
        periodicCHECK = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(660, 900));
        setMinimumSize(new java.awt.Dimension(660, 400));
        setPreferredSize(new java.awt.Dimension(660, 450));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pathPointTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "X (relative)", "Y (relative)", "speed (fraction per second)", "sample rate (fps)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        pathPointTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        pathPointTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(pathPointTable);
        if (pathPointTable.getColumnModel().getColumnCount() > 0) {
            pathPointTable.getColumnModel().getColumn(0).setResizable(false);
            pathPointTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            pathPointTable.getColumnModel().getColumn(1).setResizable(false);
            pathPointTable.getColumnModel().getColumn(1).setPreferredWidth(25);
            pathPointTable.getColumnModel().getColumn(2).setResizable(false);
            pathPointTable.getColumnModel().getColumn(2).setPreferredWidth(110);
            pathPointTable.getColumnModel().getColumn(3).setResizable(false);
            pathPointTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        infoTXT.setBackground(new java.awt.Color(240, 240, 240));
        infoTXT.setColumns(20);
        infoTXT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        infoTXT.setLineWrap(true);
        infoTXT.setRows(5);
        infoTXT.setText("Enter up to 20 points that will be connected in consecutive order to form a linear path. The values must be entered in fractions of the current screen size and the sample rate determines how many updates of the object are made each second.\n\nPrefference is given to the sample rate over the speed. This means that a slightly slower speed is chosen if neccesary such that the last frame-update brings the object directly to the target.\n\nIf the checkBox 'make path periodic' is selected, the last point will be connected to the first point in the table with the speed and sample rate as in the last row of the table.");
        infoTXT.setWrapStyleWord(true);
        infoTXT.setAutoscrolls(false);
        infoTXT.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        infoTXT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        infoTXT.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        infoTXT.setEnabled(false);
        infoTXT.setFocusable(false);

        saveCloseBUT.setText("save path & close");
        saveCloseBUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCloseBUTActionPerformed(evt);
            }
        });

        clearBUT.setText("clear table");
        clearBUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBUTActionPerformed(evt);
            }
        });

        addRowBUT.setText("add row");
        addRowBUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowBUTActionPerformed(evt);
            }
        });

        deleteRowBUT.setText("delete row");
        deleteRowBUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowBUTActionPerformed(evt);
            }
        });

        periodicCHECK.setText("make path periodic");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(infoTXT)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearBUT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addRowBUT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteRowBUT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveCloseBUT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(periodicCHECK)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clearBUT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addRowBUT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteRowBUT)
                        .addGap(18, 18, 18)
                        .addComponent(saveCloseBUT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(periodicCHECK)
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearBUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBUTActionPerformed
        for (int i = 0; i < pathTableModel.getRowCount(); i++) {
            for (int j = 0; j < pathTableModel.getColumnCount(); j++) {
                pathTableModel.setValueAt(null, i, j);
            }
        }
        elapsedTime = 0;
    }//GEN-LAST:event_clearBUTActionPerformed

    private void addRowBUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowBUTActionPerformed
        pathTableModel.addRow(new Object[3]);
    }//GEN-LAST:event_addRowBUTActionPerformed

    private void saveCloseBUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCloseBUTActionPerformed
        Vector2D startPoint = new Vector2D(),
                 endPoint   = new Vector2D();   
        
        linearPath.clear();
        
        //We need to add the first point manually, as for cencecutive points the final
        // update will be identical with the next startpoint, but we dont want to have
        // the same point twice. Hence we add the first point here and then the first
        // point in the loop will be the first update with the 'new' speed.
        linearPath.add(new MouseTrajectoryPoint(0,0,(float) pathTableModel.getValueAt(0, 0)  ,(float) pathTableModel.getValueAt(0, 1)));
        
        for (int i = 0; i < pathTableModel.getRowCount()-2; i++) {
            if(pathTableModel.getValueAt(i, 0) == null ||
               pathTableModel.getValueAt(i, 1) == null || 
               pathTableModel.getValueAt(i+1, 0) == null ||
               pathTableModel.getValueAt(i+1, 1) == null ||
               pathTableModel.getValueAt(i, 2) == null ||
               pathTableModel.getValueAt(i, 3) == null) {
                //If any of the above conditions is true it means that a value needed to create the path has not been filled.
                // We just skip one line and try with the next pair.
                continue;
            }
            startPoint.setLocation((float) pathTableModel.getValueAt(i, 0)  ,(float) pathTableModel.getValueAt(i, 1));
            endPoint.setLocation((float) pathTableModel.getValueAt(i+1, 0),(float) pathTableModel.getValueAt(i+1, 1));
            
            float speed = (float) pathTableModel.getValueAt(i, 2);
            int fps;
            if(pathTableModel.getValueAt(i, 3) instanceof Integer){
                fps = (int) pathTableModel.getValueAt(i, 3);
            } else {
                fps = Math.round((float)pathTableModel.getValueAt(i, 3));
            } 
            addLinearPathBetweenPoints(startPoint,endPoint,speed,fps);
        }
        if(periodicCHECK.isSelected()){
            for(int i = pathTableModel.getRowCount()-1; i>0; i--){
                if(pathTableModel.getValueAt(i, 0) == null ||
                   pathTableModel.getValueAt(i, 1) == null || 
                   pathTableModel.getValueAt(i, 2) == null ||
                   pathTableModel.getValueAt(i, 3) == null) {
                    //Now we go backwards through the table. The last row containing data
                    // will be regarded as the last row of the path. Then we link 
                    // this to the first entry and skip the rest of the rows.
                    continue;
                }
                startPoint.setLocation((float) pathTableModel.getValueAt(i, 0)  ,(float) pathTableModel.getValueAt(i, 1));
                endPoint.setLocation((float) pathTableModel.getValueAt(0, 0),(float) pathTableModel.getValueAt(0, 1));

                float speed = (float) pathTableModel.getValueAt(i, 2);
                int fps;
                if(pathTableModel.getValueAt(i, 3) instanceof Integer){
                    fps = (int) pathTableModel.getValueAt(i, 3);
                } else {
                    fps = Math.round((float)pathTableModel.getValueAt(i, 3));
                }

                addLinearPathBetweenPoints(startPoint,endPoint,speed,fps);
                break;
            }
        }
        
        if(!linearPath.isEmpty()) {
            stimFrame.setMousePath(linearPath);
        }

        this.dispose();
    }//GEN-LAST:event_saveCloseBUTActionPerformed

    private void deleteRowBUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRowBUTActionPerformed
        pathTableModel.removeRow(pathTableModel.getRowCount()-1);
    }//GEN-LAST:event_deleteRowBUTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRowBUT;
    private javax.swing.JButton clearBUT;
    private javax.swing.JButton deleteRowBUT;
    private javax.swing.JTextArea infoTXT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pathPointTable;
    private javax.swing.JCheckBox periodicCHECK;
    private javax.swing.JButton saveCloseBUT;
    // End of variables declaration//GEN-END:variables
}