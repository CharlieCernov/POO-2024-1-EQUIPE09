/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import controller.AppEventos;
import controller.UsuarioController;



public class FrmCadastro extends JFrame implements ActionListener {

    private JLabel lblMail, lblPass, lblPass2, lblWarnPass, lblWarnPass2, lblNome, lblNasc, lblDia, lblMes, lblAno;
    private JTextField txtMail, txtNome, txtDia, txtMes, txtAno;
    private JPasswordField pwdPass, pwdPass2;
    private JButton btnSignUp, btnVoltar;
    private JCheckBox chkOrg;
    private String tipoUsuario;

    public FrmCadastro(String tipoUsuario) {
    	this.tipoUsuario = tipoUsuario; // Para Renderizar uma tela cadastro diferente de acordo com o tipo de usuario
        Container c = getContentPane();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (screen.width * 0.9), (int) (screen.height * 0.9));
        setTitle("Cadastro");
        c.setLayout(null);
        setLocationRelativeTo(null); // Centraliza
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int y = 50, x = 100, x2 = 260, centerX = getWidth() / 2, centerY = getHeight() / 2;
        lblMail = criarLabel("Email", x, y);
        txtMail = criarTxtField(x2, y);

        y += 100;
        lblNome = criarLabel("Nome", x, y);
        txtNome = criarTxtField(x2, y);

        y += 100;
        lblPass = criarLabel("Senha", x, y);
        lblWarnPass = criarWarningLabel("A senha deve conter pelo menos 8 dígitos.", x2, y + 25);
        pwdPass = criarPassField(x2, y);

        y += 100;
        lblPass2 = criarLabel("Confirmar Senha", x, y);
        lblWarnPass2 = criarWarningLabel("Não foi possível confirmar a senha, senhas diferentes", x2, y + 25);
        pwdPass2 = criarPassField(x2, y);

        y+= 100;
        chkOrg = criarCheckBox("É um organizador", x, y);
        lblNasc = criarLabel("Data de Nascimento:", (int) (centerX*1.3), y-40);
        lblNasc.setSize(200, lblNasc.getHeight());
        
        lblDia = criarLabel("Dia", centerX, y);
        txtDia = criarTxtField(centerX + 40, y);
        txtDia.setSize(25, txtDia.getHeight());
        lblMes = criarLabel("Mes", txtDia.getWidth()+txtDia.getX()+10, y);
        txtMes = criarTxtField(lblMes.getX()+40, y);
        txtMes.setSize(25, txtMes.getHeight());
        lblAno = criarLabel("Ano", txtMes.getWidth()+txtMes.getX()+10, y);
        txtAno = criarTxtField(lblAno.getX() + 40, y);
        txtAno.setSize(50, txtAno.getHeight());
        
        y += 100;
        // largura botão = 140
        btnSignUp = criarButton("SignUp", centerX - 150, y);
        btnVoltar = criarButton("Voltar", centerX + 10, y);

        setVisible(true);
    }

    public JTextField criarTxtField(int x, int y) {
        JTextField txt = new JTextField();
        txt.setSize(800, 50);
        txt.setLocation(x, y);
        txt.setFont(new Font("Helvetica", Font.PLAIN, 16));
        add(txt);
        txt.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
 
            }

            public void keyTyped(KeyEvent e) {
            	JTextField tf = (JTextField) e.getSource();
                String txt = tf.getText();
                
                if(tf == txtNome && txt.length() > 59 || tf == txtDia && txt.length() > 1 ||
                		tf == txtAno && txt.length() > 3 || tf == txtMes && txt.length() > 1 ||
                		tf == txtMail && txt.length() > 69)
                	tf.setText(txt.substring(0, txt.length()-1));
            }

            public void keyPressed(KeyEvent e) {

            }
        });
        return txt;
    }

    public JPasswordField criarPassField(int x, int y) {
        JPasswordField pwd = new JPasswordField();
        pwd.setSize(800, 50);
        pwd.setLocation(x, y);
        pwd.setFont(new Font("Helvetica", Font.PLAIN, 16));
        add(pwd);
        pwd.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                JPasswordField passField = (JPasswordField) e.getSource();
                String pass = String.valueOf(passField.getPassword());
                if (pass.length() < 8) {
                    lblWarnPass.setVisible(true);
                } else {
                    lblWarnPass.setVisible(false);
                }
                String passPrincipal = String.valueOf(pwdPass.getPassword());

                if (pass.equals(passPrincipal)) {
                    lblWarnPass2.setVisible(false);
                } else {
                    lblWarnPass2.setVisible(true);
                }
                

            }

            public void keyTyped(KeyEvent e) {
                JPasswordField passField = (JPasswordField) e.getSource();
                String pass = String.valueOf(passField.getPassword());
                if(pass.length() > 20)
                	passField.setText(pass.substring(0, pass.length()-1));
            }

            public void keyPressed(KeyEvent e) {

            }
        });
        return pwd;
    }
    public JCheckBox criarCheckBox(String texto, int x, int y) {
    	JCheckBox chk = new JCheckBox(texto);
    	chk.setLocation(x, y);
    	chk.setSize(180, 50);
        chk.setFont(new Font("Helvetica", Font.PLAIN, 18));
        chk.setHorizontalAlignment(SwingConstants.LEFT);
        chk.setVerticalAlignment(SwingConstants.CENTER);
    	add(chk);
    	chk.addActionListener(this);
    	return chk;
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
        lbl.setSize(120, 60);
        lbl.setLocation(x, y);
        lbl.setForeground(Color.BLACK);
        lbl.setFont(new Font("Helvetica", Font.BOLD, 18));
        lbl.setHorizontalAlignment(SwingConstants.LEFT);
        lbl.setVerticalAlignment(SwingConstants.CENTER);
        add(lbl);
        return lbl;
    }

    public JLabel criarWarningLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setSize(800, 80);
        lbl.setLocation(x, y);
        lbl.setForeground(Color.RED);
        lbl.setFont(new Font("Helvetica", Font.PLAIN, 14));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);
        add(lbl);
        lbl.setVisible(false);
        return lbl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVoltar){
            AppEventos.abreLogin(this, tipoUsuario);
        }
        if (e.getSource() == btnSignUp) {
    		//cadastro como cliente
    		String nome = txtNome.getText();
    		String email = txtMail.getText();
    		String senha = String.valueOf(pwdPass.getPassword());
    		boolean organizador = tipoUsuario.equals("Organizador");
        	if(UsuarioController.fazerCadastro(nome, email, senha, organizador)) {
        		//Cadastro realizado
        	}
        	else{
        		//Falha ao cadastrar
        	}
        }
        if(e.getSource() == chkOrg) {
        	if(chkOrg.isSelected()) {
        		txtDia.setEnabled(false);
        		txtMes.setEnabled(false);
        		txtAno.setEnabled(false);
        	}
        	else {
        		txtDia.setEnabled(true);
        		txtMes.setEnabled(true);
        		txtAno.setEnabled(true);
        	}
        }
    }
}
