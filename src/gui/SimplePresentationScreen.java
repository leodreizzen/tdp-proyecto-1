package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textoGithub;
	private JTextField textoEmail;
	private JTextField textoNombre;
	private JLabel labelFecha;
	private JTextField textoApellido;
	private JTextField textoLU;
	private JLabel labelImagen;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setIconImage(new ImageIcon(getClass().getResource("/images/tdp.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
		rellenarPanel();
	}
	
	private void rellenarPanel() {
		textoLU.setText(Integer.toString(studentData.getId()));
		textoApellido.setText(studentData.getLastName());
		textoNombre.setText(studentData.getFirstName());
		textoEmail.setText(studentData.getMail());
		textoGithub.setText(studentData.getGithubURL());
		
		LocalDateTime fechaYHora = LocalDateTime.now();
		String fecha = fechaYHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String hora = fechaYHora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		labelFecha.setText("Esta ventana fue generada el " + fecha + " a las " + hora);
		
		ImageIcon icono = new ImageIcon(getClass().getResource(studentData.getPathPhoto()));
		Image imagenReescalada = icono.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		labelImagen.setIcon(new ImageIcon(imagenReescalada));
	}
	
	
	private void init() {
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{376, 210, 0};
		gbl_contentPane.rowHeights = new int[]{199, 14, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 200));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel labelLU = new JLabel("LU");
		labelLU.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel labelApellido = new JLabel("Apellido");
		labelApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel labelEmail = new JLabel("E-mail");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel labelGithub = new JLabel("Github URL");
		labelGithub.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textoLU = new JTextField();
		textoLU.setEditable(false);
		textoLU.setColumns(11);
		
		textoGithub = new JTextField();
		textoGithub.setEditable(false);
		textoGithub.setColumns(10);
		
		textoEmail = new JTextField();
		textoEmail.setEditable(false);
		textoEmail.setColumns(11);
		
		textoNombre = new JTextField();
		textoNombre.setEditable(false);
		textoNombre.setColumns(11);
		
		textoApellido = new JTextField();
		textoApellido.setEditable(false);
		textoApellido.setColumns(11);
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(labelGithub, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelNombre, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelLU, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelApellido, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelEmail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textoLU, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
							.addComponent(textoEmail, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
							.addComponent(textoGithub, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
						.addComponent(textoApellido, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
						.addComponent(textoNombre, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(textoLU, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelLU))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelApellido, 0, 0, Short.MAX_VALUE)
						.addComponent(textoApellido, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelNombre)
						.addComponent(textoNombre, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(textoEmail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelGithub)
						.addComponent(textoGithub, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(45))
		);
		tabInformation.setLayout(gl_tabInformation);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.weighty = 1.0;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 5);
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		labelImagen = new JLabel("");
		labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelImagen = new GridBagConstraints();
		gbc_labelImagen.weightx = 1.0;
		gbc_labelImagen.fill = GridBagConstraints.BOTH;
		gbc_labelImagen.insets = new Insets(0, 0, 5, 0);
		gbc_labelImagen.gridx = 1;
		gbc_labelImagen.gridy = 0;
		contentPane.add(labelImagen, gbc_labelImagen);
		
		labelFecha = new JLabel(".");
		labelFecha.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_labelFecha = new GridBagConstraints();
		gbc_labelFecha.anchor = GridBagConstraints.WEST;
		gbc_labelFecha.gridwidth = 2;
		gbc_labelFecha.fill = GridBagConstraints.VERTICAL;
		gbc_labelFecha.insets = new Insets(0, 0, 0, 5);
		gbc_labelFecha.gridx = 0;
		gbc_labelFecha.gridy = 1;
		contentPane.add(labelFecha, gbc_labelFecha);
	}
}
