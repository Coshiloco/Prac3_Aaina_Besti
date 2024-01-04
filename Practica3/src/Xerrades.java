//Lucas Domínguez
class Xerrades extends Activitats {
    private String nomPersona;


    // Constructor
    public Xerrades(String nom, String lloc, String codiPostal, int data, Entitat entitat,
                    String nomPersona) {
        super(nom, lloc, codiPostal, data, entitat);
        this.nomPersona = nomPersona;
    }


    // Getters y setters específicos
    public String getnomPersona() {
        return nomPersona;
    }


    public void setnomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }
}

