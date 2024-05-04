package view;

import javax.swing.*;

import controller.AppEventos;
import controller.UsuarioController;

import java.awt.event.*;
import java.awt.*;

public class FrmLogin extends JFrame implements ActionListener {
	private JLabel lblMail, lblPass, lblWarnPass;
	private JTextField txtMail;
	private JPasswordField pwdPass;
	private JButton btnLogIn, btnSignUp, btnExit;
	private String tipoUsuario;
	public FrmLogin(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
		Container c = getContentPane();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screen.width * 0.9), (int) (screen.height * 0.9));
		setTitle("Login");
		c.setLayout(null);
		setLocationRelativeTo(null); // Centraliza
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int y = 200, x = 100, x2 = 260, centerX = getWidth() / 2, centerY = getHeight() / 2;
		lblMail = criarLabel("Email", x, y);
		txtMail = criarTxtField(x2, y);

		y += 100;
		lblPass = criarLabel("Senha", x, y);
		lblWarnPass = criarWarningLabel("A senha deve conter pelo menos 8 dígitos.", x2, y + 25);
		pwdPass = criarPassField(x2, y);

		y += 100;
		// largura botão = 140
		btnLogIn = criarButton("Login", centerX - 240, y);
		btnSignUp = criarButton("SignUp", centerX - 70, y);
		btnExit = criarButton("Sair", centerX + 100, y);

		setVisible(true);
	}

	public JTextField criarTxtField(int x, int y) {
		JTextField txt = new JTextField();
		txt.setSize(800, 50);
		txt.setLocation(x, y);
        txt.setFont(new Font("Helvetica", Font.PLAIN, 18));
		add(txt);
		txt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				JTextField textField = (JTextField) e.getSource();
				String text = textField.getText();
			}

			public void keyTyped(KeyEvent e) {
            	JTextField tf = (JTextField) e.getSource();
                String txt = tf.getText();
                
                if(tf == txtMail && txt.length() > 69)
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
				if (pass.length() < 8)
					lblWarnPass.setVisible(true);
				else
					lblWarnPass.setVisible(false);
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
		if(e.getSource() == btnExit){
			System.exit(0);
		}
		if(e.getSource() == btnLogIn) {
			String email = txtMail.getText();
			String senha = String.valueOf(pwdPass.getPassword());
			if(!email.equals("") && !senha.equals("")) {
				if(UsuarioController.fazerLogin(email, senha)) {
					setVisible(false);
				}
				else {
					//Login inválido
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
			}
		}
		if(e.getSource() == btnSignUp) {
			AppEventos.abreCadastro(this, tipoUsuario);
			
		}
	}

}
