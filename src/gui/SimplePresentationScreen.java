package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField txtId;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JLabel fecha_hora;
	private JTextField txtGithub;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setIconImage(new ImageIcon(getClass().getResource("/images/tdp.png")).getImage());
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 240));//new Dimension(425, 275)
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informaci\u00C3\u00B3n declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LU:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 11, 46, 14);
		tabInformation.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 36, 58, 14);
		tabInformation.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(10, 61, 58, 14);
		tabInformation.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-Mail:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(10, 86, 46, 14);
		tabInformation.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Github URL:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(10, 111, 73, 14);
		tabInformation.add(lblNewLabel_4);
		
		txtId = new JTextField();
		txtId.setBackground(Color.WHITE);
		txtId.setEditable(false);
		String id = Integer.toString(studentData.getId());
		txtId.setText(id);
		txtId.setBounds(105, 8, 258, 20);
		txtId.setHorizontalAlignment(SwingConstants.LEFT);
		tabInformation.add(txtId);
		txtId.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setEditable(false);
		String apellido = studentData.getLastName();
		txtApellido.setText(apellido);
		txtApellido.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellido.setBounds(105, 34, 258, 20);
		tabInformation.add(txtApellido);
		txtApellido.setColumns(10);
		
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setEditable(false);
		String nombre = studentData.getFirstName();
		txtNombre.setText(nombre);
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setBounds(105, 59, 258, 20);
		tabInformation.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setEditable(false);
		String mail = studentData.getMail();
		txtEmail.setText(mail);
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setBounds(105, 84, 258, 20);
		tabInformation.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtGithub = new JTextField();
		txtGithub.setBackground(Color.WHITE);
		txtGithub.setEditable(false);
		String github = studentData.getGithubURL();
		txtGithub.setText(github);
		txtGithub.setHorizontalAlignment(SwingConstants.LEFT);
		txtGithub.setBounds(105, 109, 258, 20);
		tabInformation.add(txtGithub);
		txtGithub.setColumns(10);
		
		tabbedPane.setEnabledAt(0, true);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
		JLabel lblNewLabel_5 = new JLabel("Esta ventana fue generada el " + fecha.format(LocalDateTime.now()) + " a las: " + hora.format(LocalDateTime.now()));
		contentPane.add(lblNewLabel_5, BorderLayout.SOUTH);
		
		
		fecha_hora = new JLabel();
		fecha_hora.setHorizontalAlignment(SwingConstants.TRAILING);
		fecha_hora.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource("/images/foto.jpg")));
		contentPane.add(fecha_hora, BorderLayout.EAST);
	}
}
