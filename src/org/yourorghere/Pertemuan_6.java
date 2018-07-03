package org.yourorghere;
import com.sun.opengl.util.Animator;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLJPanel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Pertemuan_6 extends JFrame implements Runnable{
private Animator animator;
GLRenderer glr;
static boolean isRunning=false;
static GLJPanel thePanel=null;
/** Membuat form baru */
public Pertemuan_6() {
initComponents();
setTitle("Pertemuan 6 - Translasi dan Rotasi Objek");
glr = new GLRenderer();
panel.addGLEventListener(glr);
if (thePanel==null)
thePanel=panel;
}
@Override
public void setVisible(boolean show){
if(!show)
animator.stop();
super.setVisible(show);
if(!show)
animator.start();
}
private void initComponents() {
JLabel label = new JLabel();
panel = new GLJPanel(createGLCapabilites());
//Tombol Rotasi
Btn_Rotasi_Tambah_X = new JButton();
Btn_Rotasi_Tambah_Y = new JButton();
Btn_Rotasi_Tambah_Z = new JButton();
//Tombol Translasi
Btn_Translasi_Tambah_X = new JButton();
Btn_Translasi_Tambah_Y = new JButton();
Btn_Translasi_Tambah_Z = new JButton();
jSlider1 = new JSlider();
jSlider2 = new JSlider();
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
setResizable(false);
label.setFont(new Font("Tahoma", 0, 24)); // Style Font
label.setHorizontalAlignment(SwingConstants.CENTER);
label.setText("Objek Tabung"); // Caption
panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
GroupLayout panelLayout = new GroupLayout(panel);
panel.setLayout(panelLayout);
panelLayout.setHorizontalGroup(
panelLayout.createParallelGroup(Alignment.LEADING)
.addGap(0, 550, Short.MAX_VALUE)
);
panelLayout.setVerticalGroup(
panelLayout.createParallelGroup(Alignment.LEADING)
.addGap(0, 369, Short.MAX_VALUE)
);
Btn_Rotasi_Tambah_X.setText("RX+");
Btn_Rotasi_Tambah_X.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent evt) {
Btn_Rotasi_Tambah_XActionPerformed(evt);
}
});
Btn_Rotasi_Tambah_Y.setText("RY+");
Btn_Rotasi_Tambah_Y.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent evt) {
Btn_Rotasi_Tambah_YActionPerformed(evt);
}
});
Btn_Rotasi_Tambah_Z.setText("RZ+");
Btn_Rotasi_Tambah_Z.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent evt) {
Btn_Rotasi_Tambah_ZActionPerformed(evt);
}
});
Btn_Translasi_Tambah_X.setText("TX+");
Btn_Translasi_Tambah_X.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent evt) {
Btn_Translasi_Tambah_XActionPerformed(evt);
}
});
Btn_Translasi_Tambah_Y.setText("TY+");
Btn_Translasi_Tambah_Y.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent evt) {
Btn_Translasi_Tambah_YActionPerformed(evt);
}
});
Btn_Translasi_Tambah_Z.setText("TZ+");
Btn_Translasi_Tambah_Z.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent evt) {
Btn_Translasi_Tambah_ZActionPerformed(evt);
}
});
jSlider1.setMaximum(360);
jSlider1.setValue(0);
jSlider1.addChangeListener(new ChangeListener() {
public void stateChanged(ChangeEvent evt) {
jSlider1StateChanged(evt);
}
});
jSlider2.setMaximum(360);
jSlider2.setOrientation(JSlider.VERTICAL);
jSlider2.setValue(0);
jSlider2.addChangeListener(new ChangeListener() {
public void stateChanged(ChangeEvent evt) {
jSlider2StateChanged(evt);
}
});
GroupLayout layout = new GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addGroup(layout.createParallelGroup(Alignment.LEADING)
.addComponent(Btn_Rotasi_Tambah_X)
.addComponent(Btn_Rotasi_Tambah_Y)
.addComponent(Btn_Rotasi_Tambah_Z)
.addComponent(Btn_Translasi_Tambah_X)
.addComponent(Btn_Translasi_Tambah_Y)
.addComponent(Btn_Translasi_Tambah_Z))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(Alignment.LEADING)
.addComponent(jSlider1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(label, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
.addGap(18, 18, 18)
.addComponent(jSlider2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
.addGap(26, 26, 26))
);
layout.setVerticalGroup(
layout.createParallelGroup(Alignment.LEADING)
.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
.addGap(18, 18, 18)
.addComponent(label)
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addComponent(Btn_Rotasi_Tambah_X)
.addComponent(Btn_Rotasi_Tambah_Y)
.addComponent(Btn_Rotasi_Tambah_Z)
.addPreferredGap(ComponentPlacement.UNRELATED)
.addComponent(Btn_Translasi_Tambah_X)
.addComponent(Btn_Translasi_Tambah_Y)
.addComponent(Btn_Translasi_Tambah_Z)
.addGap(94, 94, 94))
.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
.addComponent(jSlider2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addGroup(Alignment.LEADING, layout.createSequentialGroup()
.addGap(7, 7, 7)
.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
.addPreferredGap(ComponentPlacement.RELATED)
.addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
);
pack();
}
private void Btn_Rotasi_Tambah_XActionPerformed(ActionEvent evt) {
glr.R_Tambah_X(true);
if(!isRunning)
panel.display();
}
private void Btn_Rotasi_Tambah_YActionPerformed(ActionEvent evt) {
glr.R_Tambah_Y(true);
if(!isRunning)
panel.display();
}
private void Btn_Rotasi_Tambah_ZActionPerformed(ActionEvent evt) {
glr.R_Tambah_Z(true);
if(!isRunning)
panel.display();
}
private void Btn_Translasi_Tambah_XActionPerformed(ActionEvent evt) {
glr.T_Tambah_X(true);
if(!isRunning)
panel.display();
}
private void Btn_Translasi_Tambah_YActionPerformed(ActionEvent evt) {
glr.T_Tambah_Y(true);
if(!isRunning)
panel.display();
}
private void Btn_Translasi_Tambah_ZActionPerformed(ActionEvent evt) {
glr.T_Tambah_Z(true);
if(!isRunning)
panel.display();
}
private void jSlider2StateChanged(ChangeEvent evt) {
glr.setBasicRotation(jSlider1.getValue(),jSlider2.getValue());
if(!isRunning)
panel.display();
}
private void jSlider1StateChanged(ChangeEvent evt) {
glr.setBasicRotation(jSlider1.getValue(),jSlider2.getValue());
if(!isRunning)
panel.display();
}
private GLCapabilities createGLCapabilites() {
GLCapabilities capabilities = new GLCapabilities();
capabilities.setHardwareAccelerated(true);
capabilities.setNumSamples(2);
capabilities.setSampleBuffers(true);
return capabilities;
}
public static void main(String args[]) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try{
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}catch(Exception ex) {
Logger.getLogger(getClass().getName()).log(Level.INFO, "can not enable system look and feel", ex);
}
Pertemuan_6 frame = new Pertemuan_6();
frame.setVisible(true);
}
});
}
public void run() {
while(isRunning)
{
try {
thePanel.display();
Thread.sleep(10); // menggunakan thread dan menggunakan delay waktu
}
catch (InterruptedException ex)
{
System.out.println(ex.getMessage());
}
}
}
private GLJPanel panel;
private JSlider jSlider1;
private JSlider jSlider2;
//Tombol Rotasi Objek
private JButton Btn_Rotasi_Tambah_X;
private JButton Btn_Rotasi_Tambah_Y;
private JButton Btn_Rotasi_Tambah_Z;
//Tombol Translasi Objek
private JButton Btn_Translasi_Tambah_X;
private JButton Btn_Translasi_Tambah_Y;
private JButton Btn_Translasi_Tambah_Z;
}