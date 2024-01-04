//Alberto Mas
class Visites extends Activitats {
    private boolean audioguia;
    private boolean adaptada;

    // Constructor
    public Visites(String nom, String lloc, String codiPostal, int data, Entitat entitat,
                   boolean audioguia, boolean adaptada) {
        super(nom, lloc, codiPostal, data, entitat);
        this.audioguia = audioguia;
        this.adaptada = adaptada;
    }

    // Getters y setters específicos
    public boolean esAudioguia() {
        return audioguia;
    }

    public void setAudioguia(boolean audioguia) {
        this.audioguia = audioguia;
    }

    public boolean esAdaptada() {
        return adaptada;
    }

    public void setAdaptada(boolean adaptada) {
        this.adaptada = adaptada;
    }
  
}