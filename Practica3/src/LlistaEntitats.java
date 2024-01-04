//Aina Mestre
public class LlistaEntitats {
    
private int nElem;
  private Entitat[] llista;
    
    
    //contructor amb paràmetres
    /**
     * Constructor amb paràmetres
     * @param mida mida de la taula
     */
    public LlistaEntitats (int mida){
        nElem=0;
        llista= new Entitat[mida];
    }
    
    //getter
    /**
     * getter nombre d'elements
     * @return nombre d'elements
     */
    public int getNElem(){
        return nElem;
    }
    
    //copia
    /**
     * mètode de còpia
     * @return còpia de la llista
     */
    public LlistaEntitats copia(){
        LlistaEntitats aux = new LlistaEntitats(nElem);
        return (aux);
    }
    
    //consultar mesura d'una certa posició
    /**
     * mètode que mesura cada posició
     * @param pos
     * @return còpia de la mida en cada posició
     */
    public Entitat mesuraPosicio(int pos){
        if(pos >=0 && pos< nElem){ 
            return (llista[pos].copia());}
        else 
            return null;
    }
    
    //toString
    /**
     * toString
     * @return text
     */
    public String toString(){
        String text = " ";
        for (int i = 0; i < nElem; i++){
            text = text + llista[i] + "\n";
        }
        return (text);
    }
    public void afegir(String nomEntitat, int telefon, String correu) {
        if (nElem < llista.length) {
            llista[nElem] = new Entitat(nomEntitat, telefon, correu);
            nElem++;
        }
    }
    
    public Entitat[] getLlista() {
        return llista;
    }

    public void setLlista(Entitat[] llista) {
        this.llista = llista;
    }

}
