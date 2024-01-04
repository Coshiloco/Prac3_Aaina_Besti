//Lucas Domínguez
class Tallers extends Activitats {
    private String hora;
    private int durada;
    private int capacitat;
    private String usuarisRegistrats;
    private int totalValoracions;
    private double puntuacio;
    private double sumaPuntuaciones;
    

    // Constructor
    public Tallers(String nom, String lloc, String codiPostal, int data, Entitat entitat,
                   String hora, String usuarisRegistrats, int durada, int capacitat) {
        super(nom, lloc, codiPostal, data, entitat);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
        this.usuarisRegistrats = usuarisRegistrats;
        sumaPuntuaciones = 0.0;
        totalValoracions=0;
        puntuacio=0;
    }


    // Actualització puntuació taller
    public void actualizarPuntuacio(int nuevaValoracio) {
        totalValoracions++;
        sumaPuntuaciones = sumaPuntuaciones + nuevaValoracio;
       puntuacio = sumaPuntuaciones /totalValoracions;
    }
    
    
    public static String generateRandomHora() {
        String hora = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 10; i++) {
            hora += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return hora;
    }
    
    public static int generateRandomDurada() {
        int durada = 0;
        for (int i = 0; i < 9; i++) {
            durada += (int) (Math.random() * 10);
        }
        return durada;
    }
    
    public static int generateRandomCapacitat() {
        int capacitat = 0;
        for (int i = 0; i < 9; i++) {
            capacitat += (int) (Math.random() * 10);
        }
        return capacitat;
    }
    
    public static String generateRandomUsuarisRegistrats() {
        String usuarisRegistrats = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 10; i++) {
            usuarisRegistrats += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return usuarisRegistrats;
    }
    
    public static int generateRandomTotalValoracions() {
        int totalValoracions = 0;
        for (int i = 0; i < 9; i++) {
            totalValoracions += (int) (Math.random() * 10);
        }
        return totalValoracions;
    }
    
    public static double generateRandomPuntuacio() {
        double puntuacio = 0;
        for (int i = 0; i < 9; i++) {
            puntuacio += (int) (Math.random() * 10);
        }
        return puntuacio;
    }
    
    public static double generateRandomSumaPuntuaciones() {
        double sumaPuntuaciones = 0;
        for (int i = 0; i < 9; i++) {
            sumaPuntuaciones += (int) (Math.random() * 10);
        }
        return sumaPuntuaciones;
    }

    // Getters y setters específicos

    public double getPuntuacio(){
        return puntuacio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public String SetUsuarisRegistrats() {
        return usuarisRegistrats;
    }

    public void SetUsuarisRegistrats(String usuarisRegistrats) {
        this.usuarisRegistrats = usuarisRegistrats;
    }
    public String getCodiTaller() {
        return getCodi();
    }
}