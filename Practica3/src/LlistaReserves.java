//Esther Batalla
public class LlistaReserves {
    
private int nElem;
    private Reserves[] llista;

    public LlistaReserves (int mida) {
        llista = new Reserves[mida];
        nElem = 0;
    }

 // Mètode per obtenir el número de reserves que té un taller
    public int getNumElem(){
        return nElem;
 }

//Mètode que transforma el contingut de l'objecte LlistaReserves en una cadena de caracters per ser mostrat per pantalla
     public String toString () {
        if(nElem==0){return null;}
        String aux = "Llista Reserves =>";
        for (int i = 0; i<nElem; i++) {
            aux = aux + "\n\t[" + i + "] " + llista[i];
        }
        return aux;
    }

//Mètode que afegeix les dades d'una nova mesura al final de la llista
    public void afegirReserva(Reserves nova) {
        if (nElem < llista.length) {
            llista[nElem] = nova;
            nElem++;
        } else {
            System.out.println("Sha assolit el numero màximd de reserves possibles");
        }
    }
    
    public Reserves[] getLlista() {
        return llista;
    }

    public void setLlista(Reserves[] llista) {
        this.llista = llista;
    }

}
