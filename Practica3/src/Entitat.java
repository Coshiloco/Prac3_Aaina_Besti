//Aina Mestre
public class Entitat {
    
	private String nomEntitat;
	private int telefon;
	private String correu;

	/**
	 * constructor amb paràmetres
	 * @param nomEntitat nom de l'entitat
	 * @param telefon telèfon de contacte
	 * @param correu correu electrònic de contacte
	 */
	public Entitat(String nomEntitat, int telefon, String correu) {
		this.nomEntitat=nomEntitat;
		this.telefon=telefon;
		this.correu=correu;
	}

	/**
	 * getter del nom de l'entitat
	 * @return el nom de l'entitat
	 */
	public String getNomEntitat() {
		return nomEntitat;
	}

	/**
	 * getter del telèfon
	 * @return el telèfon
	 */
	public int getTelefon() {
		return telefon;
	}

	/**
	 * getter del correu electrònic
	 * @return el correu electrònic
	 */
	public String getCorreu() {
		return correu;
	}

	/**
	 * setter
	 * @param nomEntitat component nomEntitat
	 */
	public void setNomEntitat(String nomEntitat) {
		this.nomEntitat = nomEntitat;
	}

	/**
	 * setter
	 * @param telefon component nomEntitat
	 */
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	/**
	 * setter
	 * @param correu component correu
	 */
	public void setCorreu(String correu) {
		this.correu = correu;
	}

	//mètode toString
	@Override
	public String toString() {
		String aux="Entitat =>\n\tnom de l'entitat: " + nomEntitat + ", telèfon de contacte: "+ telefon +"\n\tcorreu electrònic de contacte: " + correu;
		
		return aux;
	}
	
	
	// Genrate a public method that generate a random String nomEntitat
	// with a length of 10 characters
	/**
	 * mètode per generar un nom aleatori
	 * @return nom aleatori
	 */
	public static String generateRandomName() {
		String nomEntitat = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < 10; i++) {
			nomEntitat += alphabet.charAt((int) (Math.random() * alphabet.length()));
		}
		return nomEntitat;
	}
	
	
	// Generate a public method that generate a random int telefon
	// with a length of 9 characters
	/**
	 * mètode per generar un telèfon aleatori
	 * @return telèfon aleatori
	 */
	public static int generateRandomTelefon() {
		int telefon = 0;
		for (int i = 0; i < 9; i++) {
			telefon += (int) (Math.random() * 10);
		}
		return telefon;
	}
	
	// Generate a public method that generate a random String correu
	// with a length of 10 characters
	/**
	 * mètode per generar un correu aleatori
	 * @return correu aleatori
	 */
	public static String generateRandomCorreu() {
		String correu = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < 10; i++) {
			correu += alphabet.charAt((int) (Math.random() * alphabet.length()));
		}
		correu += "@gmail.com";
		return correu;
	}
	
	
	
	
	
	

	/**
	 * mètode per crear una còpia
	 * @return còpia de la llista
	 */
	public Entitat copia() {
		Entitat aux = new Entitat(nomEntitat, telefon, correu);
		return aux;
	}
}

