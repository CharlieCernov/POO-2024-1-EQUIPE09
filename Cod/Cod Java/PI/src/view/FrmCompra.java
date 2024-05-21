package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import model.beans.*;
import controller.*;
public class FrmCompra extends JFrame implements ActionListener {

    private Container c;
    private Dimension screen;
    private Evento evento;
    public FrmCompra(Evento evento) {
        this.evento = evento;
        initFrame();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    private int vw(double value) {
        return (int) (getWidth() * value);
    }

    private int vh(double value) {
        return (int) (getHeight() * value);
    }

    public void initFrame() {
        c = getContentPane();
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screen.width, screen.height);//Tamanho da Janela
        setTitle("Comprar Ingresso"); // Título da janela
        c.setLayout(null);
        setLocationRelativeTo(null); // Centraliza
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
