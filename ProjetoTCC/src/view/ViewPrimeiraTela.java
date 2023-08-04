package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.DAO;
import utils.Validador;
import java.awt.Toolkit;

public class ViewPrimeiraTela extends JFrame {

	//Instanciar objetos
	DAO dao = new DAO();
	private Connection con;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmTelaDeAcesso;
	private JTextField txtLogin;
	private JLabel lblSenha;
	private JLabel lblBackGround;
	private JPanel panel;
	private JLabel lblIconeUser;
	private JLabel lblIconeSenha;
	private JButton btnEntrar;
	private JLabel lblStatus;
	private JLabel lblData;
	private JPasswordField txtSenha;
	private JLabel lblRecuperarSenha;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	//INICIO configuação aparencia do NIMBUS
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (InstantiationException ex) {
        	System.err.println(ex);
        } catch (IllegalAccessException ex) {
        	System.err.println(ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }
		
	//FIM CONFIGURAÇÂO NIMBUS
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrimeiraTela window = new ViewPrimeiraTela();
					window.frmTelaDeAcesso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	//INICIO DO CONSTRUTOR
	public ViewPrimeiraTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeAcesso = new JFrame();
		frmTelaDeAcesso.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		frmTelaDeAcesso.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewPrimeiraTela.class.getResource("/img/LogoA.png")));
		frmTelaDeAcesso.setTitle("Tela de acesso");
		frmTelaDeAcesso.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
				setarData();
			}
		});
		frmTelaDeAcesso.setResizable(false);
		frmTelaDeAcesso.setBackground(Color.DARK_GRAY);
		frmTelaDeAcesso.setBounds(650, 250, 450, 450);
		frmTelaDeAcesso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeAcesso.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(132, 115, 58, 25);
		frmTelaDeAcesso.getContentPane().add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setToolTipText("Digite o nome de usu\u00E1rio");
		txtLogin.setBounds(132, 138, 230, 25);
		frmTelaDeAcesso.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		// uso do PlainDocument para limitar os campos.
		txtLogin.setDocument(new Validador(45));
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(132, 180, 46, 14);
		frmTelaDeAcesso.getContentPane().add(lblSenha);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 369, 434, 42);
		frmTelaDeAcesso.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(ViewPrimeiraTela.class.getResource("/img/dboff.png")));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(379, 0, 45, 42);
		panel.add(lblStatus);
		
		lblData = new JLabel("");
		lblData.setForeground(new Color(0, 0, 0));
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(10, 11, 233, 20);
		panel.add(lblData);
		
		lblIconeUser = new JLabel("");
		lblIconeUser.setIcon(new ImageIcon(ViewPrimeiraTela.class.getResource("/img/User Icon.png")));
		lblIconeUser.setBounds(80, 121, 46, 42);
		frmTelaDeAcesso.getContentPane().add(lblIconeUser);
		
		lblIconeSenha = new JLabel("");
		lblIconeSenha.setIcon(new ImageIcon(ViewPrimeiraTela.class.getResource("/img/Locked Icon.png")));
		lblIconeSenha.setBounds(80, 178, 46, 46);
		frmTelaDeAcesso.getContentPane().add(lblIconeSenha);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBackground(new Color(0, 128, 0));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DAO.conectar();
					
					String sql = "select*from usuario where nome_usuario = ? and senha_usuario = ?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, txtLogin.getText());
					stmt.setString(2, new String (txtSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					if (rs.next()) {
						
						ViewSegundaTela exibir = new ViewSegundaTela();
						exibir.setVisible(true);
						frmTelaDeAcesso.setVisible(false);
												
					} else {
						JOptionPane.showMessageDialog(null,  "DADOS INVÁLIDOS", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
					stmt.close();
					con.close();
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}			
				
			}
						
		});
		btnEntrar.setToolTipText("Clique para entrar");
		btnEntrar.setForeground(new Color(0, 0, 0));
		btnEntrar.setBounds(282, 235, 80, 23);
		frmTelaDeAcesso.getContentPane().add(btnEntrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(132, 199, 230, 25);
		frmTelaDeAcesso.getContentPane().add(txtSenha);
		// uso do PlainDocument para limitar os campos
		txtSenha.setDocument(new Validador(4));
		
		lblRecuperarSenha = new JLabel("Esqueceu a senha?");
		lblRecuperarSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRecuperarSenha.setForeground(new Color(255, 0, 0));
		lblRecuperarSenha.setBounds(132, 239, 113, 14);
		frmTelaDeAcesso.getContentPane().add(lblRecuperarSenha);
		
		lblNewLabel = new JLabel("Ainda n\u00E3o tem conta?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBounds(155, 304, 124, 16);
		frmTelaDeAcesso.getContentPane().add(lblNewLabel);
		
		JButton btnNovoCadastro = new JButton("Novo cadastro");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewCadastro cadastro = new ViewCadastro();
				cadastro.setVisible(true);
				frmTelaDeAcesso.setVisible(false);
				
			}
		});
		btnNovoCadastro.setBackground(new Color(192, 192, 192));
		btnNovoCadastro.setForeground(new Color(0, 0, 0));
		btnNovoCadastro.setBounds(161, 324, 113, 23);
		frmTelaDeAcesso.getContentPane().add(btnNovoCadastro);
		
		lblBackGround = new JLabel("");
		lblBackGround.setIcon(new ImageIcon(ViewPrimeiraTela.class.getResource("/img/backgroundtcc.png")));
		lblBackGround.setBounds(0, 0, 434, 411);
		frmTelaDeAcesso.getContentPane().add(lblBackGround);
	} //FIM DO CONSTRUTOR
	
	private void status() {
		try {
			con = DAO.conectar();
			if (con == null) {
				//System.out.println("ERRO DE CONEXÃO");
				lblStatus.setIcon(new ImageIcon(ViewPrimeiraTela.class.getResource("/img/dboff.png")));
			} else {
				//System.out.println("BANCO DE DADOS CONECTADO");
				lblStatus.setIcon(new ImageIcon(ViewPrimeiraTela.class.getResource("/img/dbon.png")));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void setarData() {
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblData.setText(formatador.format(data));
	}
}
