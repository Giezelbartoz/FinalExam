package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLJPanel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Pertemuan_6 extends JFrame {

    static {
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
    }
    private Animator animator;

    /**
     * Membuat form baru
     */
    public Pertemuan_6() {
        initComponents();
        final GLRenderer glrender = new GLRenderer();
        KeyListener mylistener = new KeyListener() {

            public void keyTyped(KeyEvent e) {
                System.out.println("typed" + e.getKeyCode());
            }

            public void keyPressed(KeyEvent e) {
                System.out.println("pressed" + e.getKeyCode());
                glrender.Key_Pressed(e.getKeyCode());
                canvas.repaint();
            }

            public void keyReleased(KeyEvent e) {
                System.out.println("released" + e.getKeyCode());

            }

        };
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        JLabel label = new JLabel();
        canvas = new GLCanvas(createGLCapabilites());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        label.setText("Gunakan Keyboard untuk menggerakkan kamera");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(canvas, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(label))
                .addContainerGap())
        
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(canvas, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Called from within initComponents().
     * hint: to customize the generated code choose 'Customize Code' in the contextmenu
     * of the selected UI Component you wish to cutomize in design mode.
     * @return Returns customized GLCapabilities.
     */
    private GLCapabilities createGLCapabilites() {
        
        GLCapabilities capabilities = new GLCapabilities();
        capabilities.setHardwareAccelerated(true);

        // try to enable 2x anti aliasing - should be supported on most hardware
        capabilities.setNumSamples(2);
        capabilities.setSampleBuffers(true);
        
        return capabilities;
    }
      public static void main(String args[]) {
        // Run this in the AWT event thread to prevent deadlocks and race conditions
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                // switch to system l&f for native font rendering etc.
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

   
    private GLCanvas canvas;
}