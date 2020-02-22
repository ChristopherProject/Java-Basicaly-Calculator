import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Riso {
	
	static boolean somma;
	static boolean sottrazione;
	static boolean moltipilicazione;
	static boolean divisione;
	
	static String element;
	static String type;
	
	static boolean worked = false;
	static int gui = 1;
	static int check =  1;
	
	public static void main(String[] args) throws IOException {

		if (gui == 1) {
			try {
				CodeSource codeSource = Riso.class.getProtectionDomain().getCodeSource();
				File jarFile = new File(codeSource.getLocation().toURI().getPath());
				String jarDir = jarFile.getParentFile().getPath();
				
				if (check == 0) {
					gui = 2;
					worked = true;
				} else if (check == 1) {
					Runtime.getRuntime().exec("java -jar " +  jarDir);
					check = 0;
				
				}
			} catch (UnsupportedEncodingException e) {
				CreateDisplays();
			} catch (URISyntaxException e) {
				CreateDisplays();
			}
		}
		else if(worked == true && gui == 2) {
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
	
	static int PretendStringToInt(String numero) {
		int risultato = Integer.parseInt(numero);
		return risultato;
	}
}
