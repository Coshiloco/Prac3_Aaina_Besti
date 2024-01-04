//Esther Batalla
public class Reserves {
    
    private int codiReserva;
    private Usuario Usuari;
    private String codiTaller;
    private int valoracio;
    private Tallers x;

   
    /**
	 * Constructor que rep les dades per paràmetre
	 * Per a rebre la data en el constructor es fa servir la classe Taller i el mètode dataMesura(), que s'inclou dins de la classe
	 * @param codiReserva
	 * @param Usuari
	 * @param codTaller
	 */
    public Reserves (int codi, Usuario Usuari, Tallers Taller){
           if(Taller.getCapacitat() > 0){
            this.x= Taller;
            this.codiReserva = codi;
            this.Usuari = Usuari;
            this.codiTaller = Taller.getCodiTaller();
            this.valoracio = 0;
            Taller.setCapacitat(Taller.getCapacitat() - 1);
           } 
           else {System.out.println("No hi ha plaçes diponibles");}
       
    }
    
    public static int generarCodiReserva(){
        int codi = (int) (Math.random() * 1000000);
        return codi;
    }
    
    public static int generarValoracio(){
        int valoracio = (int) (Math.random() * 10);
        return valoracio;
    }
    
    public static String generarCodiTaller(){
        String codiTaller = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 10; i++) {
            codiTaller += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return codiTaller;
    }
    
    public static Usuario generateRandomUsuario()
    {
        String alies = "Usuario" + (int) (Math.random() * 1000);
        String correu = "correo" + (int) (Math.random() * 1000) + "@gmail.com";
        int cpostal = Usuario.generateRandomCpostal();
        return new Usuario(alies, correu, cpostal);
    }
    
    public static Tallers generateRandomTallers()
    {
        String nom = Tallers.generateRandomName();
        String lloc = Tallers.generateRandomLloc();
        int capacitat = Tallers.generateRandomCapacitat();
        String hora = Tallers.generateRandomHora();
        int durada = Tallers.generateRandomDurada();
        String usuarisRegistrats = Tallers.generateRandomUsuarisRegistrats();
        Entitat entidad = new Entitat(Entitat.generateRandomName(), Entitat.generateRandomTelefon(), Entitat.generateRandomCorreu());
        return new Tallers(nom, lloc, Activitats.generateRandomCodiPostal(), Activitats.generateRandomData(), entidad, hora, usuarisRegistrats, durada, capacitat);
    }
    
    public static Reserves generateRandomReserves()
    {
        int codiReserva = Reserves.generarCodiReserva();
        Usuario usuario = Reserves.generateRandomUsuario();
        Tallers taller = Reserves.generateRandomTallers();
        return new Reserves(codiReserva, usuario, taller);
    }
    
    
    /**
	 * Getter del codi de la reserva
	 * @return codi de la reserva
	 */
	public int getCodiReserva() {
		return this.codiReserva;
    }

    /**
	 * Getter del usuari de la reserva
	 * @return nom de l'usuari que ha fet la reserva
	 */    
    public String getNomUsuariReserva() {
       String nom = Usuari.getAlies();
		return nom;
    }

    /**
	 * Getter codi del taller al que s`ha fet la reserva
	 * @return codi de la reserva
	 */    
    public String getCodiTaller() {
		return this.codiTaller;
    }

    /**
	 * Getter valoracio
	 * @return la valoració que ha realitzat l'usuari de la reserva
	 */    
    public int getValReserva() {
		return this.valoracio;
    }
  
     /**
     * Mètode que afegeix una valoracio al taller feta per l'usuari de la reserva
     */
    public void setValoracio (int val){
        if (val >= 0 && val <= 10){
            this.valoracio = val;
            x.actualizarPuntuacio(val);
        }        
    }

    /**
	 * Mètode que transforma el contingut de l'objecte Reserva en una cadena de caracters per ser mostrat per pantalla
	 */
	public String toString() {
		String aux="Reserva =>";
		aux=aux+"\n\tCodi de la reserva= " + codiReserva + ", Usuari = "+Usuari;
		aux=aux+"\n\tCodi del taller corresponent = " + codiTaller + ", valoraciio = "+valoracio;
		return aux;
	}

    /**
	 *  Mètode que crea un duplicat d'un objecte Reserva
	 * @return un nou objecte amb el mateix contingut
	 */
	public Reserves copiaReserves() {
		Reserves aux = new Reserves(codiReserva, Usuari, x);
		return aux;
	}
 

}

