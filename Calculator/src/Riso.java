import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Riso {
	
	static boolean somma;
	static boolean sottrazione;
	static boolean moltipilicazione;
	static boolean divisione;
	
	static String element;
	static String type;
	
	public static void main(String[] args) throws IOException {
		MyGui();
		esecuzione();
	}
	
	static void MyGui() {
		
		   //Create jpannel and jlabel
		   JPanel jp = new JPanel();
	       JLabel jl = new JLabel();
	       JLabel jl2 = new JLabel();
	       //delcale buttons
		   JButton bottoneSomma = new JButton("Somma");
		   JButton bottoneSottrazione = new JButton("Sottrai");
		   JButton bottoneMoltiplicazione = new JButton("Moltiplica");
		   JButton bottoneDivisione = new JButton("Divisione");
		   //max char text
	       JTextField dato = new JTextField(2);
	       JTextField dato2 = new JTextField(2);
	       //inseriment button
	       JButton conferma = new JButton("Calcola!");
	       //window title
	       JFrame window = new JFrame("Calculator-v0.2");
	       window.setVisible(true);
	       window.setSize(400, 200);
	       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       //add text pannel
	       jp.add(dato);
	       jp.add(dato2);
	            //create second pannel group button
	            JPanel panel = new JPanel();
	      		window.getContentPane().add(panel, BorderLayout.SOUTH);
	    		panel.add(bottoneSomma);
	    		panel.add(bottoneSottrazione);
	    		panel.add(bottoneMoltiplicazione);
	    		panel.add(bottoneDivisione);
	    			
		dato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = dato.getText();
				jl.setText(input);
			}
		});

		
		dato2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input2 = dato2.getText();
				jl2.setText(input2);
			}
		});
		
		jp.add(conferma);
		
		JLabel TextInWindow = new JLabel("NOT SELECTED");
		window.add(TextInWindow, BorderLayout.NORTH);
		TextInWindow.setForeground(Color.RED);
		
		bottoneSomma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiting(1);
				somma = true;
				sottrazione = false;
				moltipilicazione = false;
				divisione = false;
				TextInWindow.setText("Somma"); 
				TextInWindow.setForeground(Color.GREEN);
			}
		});
		bottoneSottrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiting(1);
				somma = false;
				sottrazione = true;
				moltipilicazione = false;
				divisione = false;
				TextInWindow.setText("Sottrazione"); 
				TextInWindow.setForeground(Color.GREEN);
			}
		});
		bottoneMoltiplicazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiting(1);
				somma = false;
				sottrazione = false;
				moltipilicazione = true;
				divisione = false;
				TextInWindow.setText("Moltiplicazione");
				TextInWindow.setForeground(Color.GREEN);
			}
		});
		bottoneDivisione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Waiting(1);
				somma = false;
				sottrazione = false;
				moltipilicazione = false;
				divisione = true;
				TextInWindow.setText("Divisione");
				TextInWindow.setForeground(Color.GREEN);
			}
		});
		
		conferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String input = dato.getText();
				String input2 = dato2.getText();
				
				if(somma == false && sottrazione == false && moltipilicazione == false && divisione == false) {
					jl.setText("Nessuna Opzione Selezionata.");	
				}
				if(somma ==true) {
					jl.setText(input + " + " + input2 +  " = " + somma(PretendStringToInt(input) , PretendStringToInt(input2)));
				}
				if(sottrazione ==true) {
					jl.setText(input + " - " + input2 +  " = " + sottrazione(PretendStringToInt(input) , PretendStringToInt(input2)));
				}
				if(moltipilicazione ==true) {
					jl.setText(input + " * " + input2 +  " = " +  moltipilicazione(PretendStringToInt(input) , PretendStringToInt(input2)));
				}
				if(divisione ==true) {
					jl.setText(input + " / " + input2 +  " = " +  divisione(PretendStringToInt(input) , PretendStringToInt(input2)));
				} 
			}
		});

		jp.add(jl);
		window.add(jp);
	}
	
	static void esecuzione() {
		 onPre();
			try  {
				System.out.println("Inserisci il primo numero: ");
				Scanner scanner = new Scanner(System.in);
				String stringa1 = scanner.nextLine();
				
				System.out.println("Inserisci il secondo numero: ");
				Scanner scanner2 = new Scanner(System.in);
				String stringa2 = scanner2.nextLine();
				
				if(element == null || element == "") {
					System.out.println("Errore Inserimento Non Definito!");
				}
				
				System.out.println("[System] -> Syntax Type of (" + type + ") " + stringa1 + " " + element + " " + stringa2);
				
				if(somma ==true) {
					System.out.println("Risultato (Somma) "+ somma(PretendStringToInt(stringa1) , PretendStringToInt(stringa2)));
				}
				if(sottrazione ==true) {
					System.out.println("Risultato (Sottrazione) "+ sottrazione(PretendStringToInt(stringa1) , PretendStringToInt(stringa2)));
				}
				if(moltipilicazione ==true) {
					System.out.println("Risultato (Moltiplicazione) "+ moltipilicazione(PretendStringToInt(stringa1) , PretendStringToInt(stringa2)));
				}
				if(divisione ==true) {
					System.out.println("Risultato (Divisione) "+ divisione(PretendStringToInt(stringa1) , PretendStringToInt(stringa2)));
				}
			}catch(Exception e) {
				System.out.println("\n[System] -> Errore, impossibile Eseguire La Seguente Operazione");
				CreateDisplays();
				System.exit(0);
		}
	}
	
	static void CreateDisplays() {
		String a = "Program Has Been Crashed";
		JOptionPane.showMessageDialog(null, a, "Warnings!", 1);
		System.exit(0);
	}
	
	static int somma(int numero1, int numero2) {
		int risultato;
		return risultato = numero1 + numero2;
	}
	
	static int sottrazione(int numero1, int numero2) {
		int risultato;
		return risultato = numero1 - numero2;
	}
	
	static int moltipilicazione(int numero1, int numero2) {
		int risultato;
		return risultato = numero1 * numero2;
	}
	
	static int divisione(int numero1, int numero2) {
		int risultato;
		return risultato = numero1 / numero2;
	}
	
	static void onPre() {
		System.out.println(" ____            _     _____                                     \r\n"
				+ "|  _ \\          | |   |  __ \\                                    \r\n"
				+ "| |_) | ___  ___| |_  | |__) | __ ___   __ _ _ __ __ _ _ __ ___  \r\n"
				+ "|  _ < / _ \\/ __| __| |  ___/ '__/ _ \\ / _` | '__/ _` | '_ ` _ \\ \r\n"
				+ "| |_) |  __/\\__ \\ |_  | |   | | | (_) | (_| | | | (_| | | | | | |\r\n"
				+ "|____/ \\___||___/\\__| |_|   |_|  \\___/ \\__, |_|  \\__,_|_| |_| |_|\r\n"
				+ "                                         __/ |                   \r\n"
				+ "                                        |___/                    ");
		
		System.out.println("1)Somma\n2)sottrazione\n3)moltipilicazione\n4)divisione\n");
		System.out.println("Seleziona Una Voce:");
		Scanner scanner = new Scanner(System.in);
		String select = scanner.nextLine();
		
		if(select.equals("1")) {
			somma = true;
			System.out.println("\n[System] -> Configurato Su Somma\n");
		}else if(select.equals("2")) {
			sottrazione = true;
			System.out.println("\n[System] -> Configurato Su sottrazione\n");
		}
		else if(select.equals("3")) {
			moltipilicazione = true;
			System.out.println("\n[System] -> Configurato Su moltipilicazione\n");
		}
		else if(select.equals("4")) {
			divisione = true;
			System.out.println("\n[System] -> Configurato Su divisione\n");
		}
		
		if(somma) {
			element = "+";
			type = "Somma";
		}else if(sottrazione) {
			element = "-";
			type = "Sottrazione";
		}else if(moltipilicazione) {
			element = "*";
			type = "Moltiplicazione";
		}else if(divisione) {
			element = "/";
			type = "Divisione";
		}
	}
	
	static void Waiting(int sec) {
		try {
			Thread.sleep(1000* sec);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static int PretendStringToInt(String numero) {
		int risultato = Integer.parseInt(numero);
		return risultato;
	}
}
