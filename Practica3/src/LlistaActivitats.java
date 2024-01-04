//Lucas Domínguez
public class LlistaActivitats {
    
private Activitats[] llistaActivitats;
    private int nElem;

    public LlistaActivitats (int mida){
        llistaActivitats = new Activitats[mida];
        nElem = 0;
    }
    public int getNElem(){
            return nElem;
        }
    
    public void afegirActivitat (String nom, String lloc, String codiPostal, int data, Entitat entitat){
        if (nElem < llistaActivitats.length){
            llistaActivitats[nElem] = new Activitats(nom, lloc, codiPostal, data, entitat);
            nElem++;
        }
    }

    public String toString () {
        if(nElem==0){return null;}
        String aux = "Llista Activitats =>";
        for (int i = 0; i<nElem; i++) {
            aux = aux + "\n\t[" + i + "] " + llistaActivitats[i];
        }
        return aux;
    }
    
    public Activitats[] getLlistaActivitats() {
        return llistaActivitats;
    }

    public void setLlistaActivitats(Activitats[] llistaActivitats) {
        this.llistaActivitats = llistaActivitats;
    }
    

}

