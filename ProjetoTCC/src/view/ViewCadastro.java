package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Validador;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;

public class ViewCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtNascimento;
	private JTextField txtEmail;
	private JTextField txtCel;
	private JTextField txtFixo;
	private JTextField txtEnd;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtCPF;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastro frame = new ViewCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewCadastro() {
		setTitle("P\u00E1gina de cadastro de usu\u00E1rio");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewCadastro.class.getResource("/img/LogoA.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(625, 225, 559, 558);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(18, 98, 47, 14);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setToolTipText("Identificador do Usu\u00E1rio (ID)");
		txtID.setBounds(67, 95, 36, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(19, 120, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("Digite seu nome completo");
		txtNome.setBounds(67, 120, 267, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usu\u00E1rio :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(128, 305, 50, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(344, 111, 105, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-Mail :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(19, 145, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cadastro de usu\u00E1rio");
		lblNewLabel_5.setFont(new Font("Courier New", Font.BOLD, 20));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(152, 43, 238, 31);
		contentPane.add(lblNewLabel_5);
		
		txtNascimento = new JTextField();
		txtNascimento.setBounds(448, 114, 73, 20);
		contentPane.add(txtNascimento);
		txtNascimento.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Digite seu E-mail");
		txtEmail.setColumns(10);
		txtEmail.setBounds(67, 145, 267, 20);
		contentPane.add(txtEmail);
		
		JLabel lblNewLabel_6 = new JLabel("Celular :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(19, 173, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		txtCel = new JTextField();
		txtCel.setToolTipText("Informe o numero de seu telefone celular");
		txtCel.setBounds(67, 170, 111, 20);
		contentPane.add(txtCel);
		txtCel.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Fixo :");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(185, 173, 36, 14);
		contentPane.add(lblNewLabel_7);
		
		txtFixo = new JTextField();
		txtFixo.setToolTipText("Informe o numero de seu telefone fixo (residencial/comercial)");
		txtFixo.setBounds(215, 170, 119, 20);
		contentPane.add(txtFixo);
		txtFixo.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Endere\u00E7o :");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(170, 198, 65, 14);
		contentPane.add(lblNewLabel_8);
		
		txtEnd = new JTextField();
		txtEnd.setToolTipText("Digite seu endere\u00E7o (ex: Av. Higien\u00F3polis, 2800)");
		txtEnd.setBounds(238, 195, 96, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Cidade :");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(19, 198, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		txtCidade = new JTextField();
		txtCidade.setToolTipText("Informe a Cidade onde reside");
		txtCidade.setBounds(67, 195, 111, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Estado :");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(344, 198, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		txtEstado = new JTextField();
		txtEstado.setToolTipText("Infome a sigla do estado onde reside (ex: PR, SP, SC, etc..)");
		txtEstado.setBounds(387, 195, 26, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		//Uso do PlainDocumet para limitar os campos
		txtEstado.setDocument(new Validador(2));
		
		JLabel lblCPF = new JLabel("CPF :");
		lblCPF.setForeground(Color.WHITE);
		lblCPF.setBounds(208, 98, 36, 14);
		contentPane.add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setToolTipText("Digite seu CPF");
		txtCPF.setBounds(238, 95, 96, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(182, 302, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Senha :");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(139, 330, 39, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_1 = new JTextField();
		textField_1.setBounds(182, 327, 179, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("  Cadastrar");
		btnNewButton.setIcon(new ImageIcon(ViewCadastro.class.getResource("/img/Sem T\u00EDtulo-1.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(198, 358, 146, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackGround.setIcon(new ImageIcon(ViewCadastro.class.getResource("/img/bgCadastro.png")));
		lblBackGround.setBounds(0, 0, 543, 519);
		contentPane.add(lblBackGround);
	}
}
