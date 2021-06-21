/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author johnn
 */
public class ModalJframe {
    public static void showModalJFrame(final JFrame window, final Frame owner) {

    if (window == null) {
        throw new IllegalArgumentException();
    }
    window.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
    window.setVisible(true);
    window.setAlwaysOnTop(true);

    final JDialog hiddenDialogForModality = new JDialog(owner, true);
    final class MyWindowCloseListener extends WindowAdapter {
        @Override
        public void windowClosed(final WindowEvent e) {
            window.dispose();
            hiddenDialogForModality.dispose();
        }
    }
    final MyWindowCloseListener myWindowCloseListener = new MyWindowCloseListener();
    window.addWindowListener(myWindowCloseListener);

    final Dimension smallSize = new Dimension(80, 80);
    hiddenDialogForModality.setMinimumSize(smallSize);
    hiddenDialogForModality.setSize(smallSize);
    hiddenDialogForModality.setMaximumSize(smallSize);
    hiddenDialogForModality.setLocation(-smallSize.width * 2, -smallSize.height * 2);
    hiddenDialogForModality.setVisible(true);
    window.removeWindowListener(myWindowCloseListener);
    
}
}
