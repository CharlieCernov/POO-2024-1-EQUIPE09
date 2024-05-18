package view;
import javax.swing.*;

import controller.EventoController;
import model.beans.Evento;

import java.awt.event.*;
import java.awt.*;
public class FrmEvento extends JFrame implements ActionListener {
    private Container c;
    private Dimension screen;
    private Evento evento;
	// Visualiza um Evento Selecionado
	public FrmEvento(Evento evento) {
        initFrame();
	int y = 200, x = vw(0.05), x2 = vw(0.22), centerX = getWidth() / 2, centerY = getHeight() / 2;

        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
    public JButton criarButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setLocation(x, y);
        btn.setSize(140, 50);
        btn.setFont(new Font("Helvetica", Font.BOLD, 18));
        add(btn);
        btn.addActionListener(this);
        return btn;
    }
    public JLabel criarLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setSize(vw(0.15), 60);
        lbl.setLocation(x, y);
        lbl.setForeground(Color.BLACK);
        lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
        lbl.setHorizontalAlignment(SwingConstants.LEFT);
        lbl.setVerticalAlignment(SwingConstants.CENTER);
        add(lbl);
        return lbl;
    }
    private int vw(double value){
        return (int)(getWidth()*value);
    }

    private int vh(double value){
        return (int)(getHeight()*value);
    }
    public void initFrame() {
        c = getContentPane();
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screen.width, screen.height);//Tamanho da Janela
        setTitle("Evento"); // Título da janela
        c.setLayout(null);
        setLocationRelativeTo(null); // Centraliza
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
