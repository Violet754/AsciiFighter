package com.zarkoix.ascfiighter;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.zarkoix.ascfiighter.levelHandler.Level;
import com.zarkoix.ascfiighter.levelHandler.levelLoad;
import com.zarkoix.ascfiighter.levelHandler.levelWrite;

import asciiPanel.AsciiPanel;

public class Main extends JFrame{
	private static final long serialVersionUID = 2060623638149583738L;

	private AsciiPanel terminal;
	
    public Main() throws IOException{
        super();
        terminal = new AsciiPanel();
        terminal.write("ASCfIIghter", 1, 1);
        terminal.write("By: ADAM TOWERS", 1, 23);
        add(terminal);
        pack();
        
    }
 
    public static void main(String[] args) throws IOException {
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        
        app.terminal.clear();
        Level lev = levelWrite.levelForm(levelLoad.getLevel("/Users/Adam/desktop/ASCfIIghter/lvl.txt"));
       levelWrite.levelDraw(app.terminal, lev);
        app.repaint();
        
    }
    
 
    public void repaint(){
        super.repaint();
        terminal.repaint();
    }
}
