package manager;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import simulation.*;

public class ManagerGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField SpieltagMessenger;
	public Team Heimteam = new Team();
	public Team Auswaertsteam = new Team();
	private Spiel spiel = new Spiel();

	public static void startManagerGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerGUI frame = new ManagerGUI();
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
	private ManagerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSpieltag = new JButton("Spieltag");
		btnSpieltag.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnSpieltag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SpieltagMessenger.setText("Spieltag läuft!");
				spiel.spielsimulation(Heimteam, Auswaertsteam);
			}
		});
		btnSpieltag.setBounds(539, 442, 235, 108);
		contentPane.add(btnSpieltag);
		
		SpieltagMessenger = new JTextField();
		SpieltagMessenger.setEditable(false);
		SpieltagMessenger.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SpieltagMessenger.setBounds(48, 134, 726, 65);
		contentPane.add(SpieltagMessenger);
		SpieltagMessenger.setColumns(50);
	}
	
	public static void updateSimulationGUI(int time, String message){
		String text = time + " Min    " + message;
		SpieltagMessenger.setText(text);
	}
}
