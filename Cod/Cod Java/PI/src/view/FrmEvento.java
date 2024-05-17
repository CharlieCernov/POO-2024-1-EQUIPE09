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
		JLabel lblEv = new JLabel(evento.toString());
		lblEv.setLocation(20, 20);
		lblEv.setSize(500,50);
        add(lblEv);

        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

    /**
     * Retorna porcentagem da largura da tela
     * @param value valor de 0 a 1 representando a porcentagem, 0.6 = 60%, 0.25 = 25%
     * @return Porcentagem da largura do frame
     */
    private int vw(double value){
        return (int)(getWidth()*value);
    }
    /**
     * Retorna porcentagem da altura da tela
     * @param value valor de 0 a 1 representando a porcentagem, 0.6 = 60%, 0.25 = 25%
     * @return Porcentagem da altura do frame
     */
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
