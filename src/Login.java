import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class Login {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("INICIAR SESION");
		lblIniciarSesion.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblIniciarSesion.setBounds(116, 11, 183, 26);
		frame.getContentPane().add(lblIniciarSesion);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblUsuario.setBounds(57, 139, 86, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblClave = new JLabel("CLAVE:");
		lblClave.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblClave.setBounds(57, 190, 68, 14);
		frame.getContentPane().add(lblClave);
		
		textField = new JTextField();
		textField.setBounds(153, 138, 102, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 189, 102, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String user = textField.getText();
			@SuppressWarnings("deprecation")
			String pass = String.valueOf(passwordField.getText());
			if(user != "" && pass != "") {
				if(pass.equals("12345")){
					Main ventana = new Main();
					ventana.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la contraseña");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
			}
			}});
		btnLogin.setBounds(304, 174, 89, 37);
		frame.getContentPane().add(btnLogin);
		
		
		JLabel lblElCochino = new JLabel("EL COCHINO");
		lblElCochino.setFont(new Font("Serif", Font.ITALIC, 18));
		lblElCochino.setBounds(153, 48, 114, 26);
		frame.getContentPane().add(lblElCochino);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(153, 102, 0));
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		}
	}