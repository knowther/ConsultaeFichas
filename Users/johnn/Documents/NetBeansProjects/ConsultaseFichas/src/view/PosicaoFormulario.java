/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author johnn
 */
public class PosicaoFormulario {
    
    
    public void abrirFormulario(JInternalFrame janela, JDesktopPane desktop) {
    int lDesk = desktop.getWidth();
    int aDesk = desktop.getHeight();
    int lIFrame = janela.getWidth();
    int aIFrame = janela.getHeight();
    janela.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
    desktop.add(janela);
    Font font = janela.getFont();

        String currentTitle = janela.getTitle().trim();
        FontMetrics fm = janela.getFontMetrics(font);
        int frameWidth = janela.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        janela.setTitle(pad + currentTitle);
    janela.setVisible(true);
    
    
}
    
}
