//Alberto Mas
public class Usuario {
    private String alies;
    private String correu;
    private int cpostal;

    

    public Usuario(String alies, String correu, int cpostal) { // Constructor
        this.alies = alies;
        this.correu = correu;
        this.cpostal = cpostal;
       
    }
    
    public static String generateRandomAlies() {
        String alies = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 10; i++) {
            alies += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        return alies;
    }
    
    public static String generateRandomCorreu() {
        String correu = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 10; i++) {
            correu += alphabet.charAt((int) (Math.random() * alphabet.length()));
        }
        correu += "@gmail.com";
        return correu;
    }
    
    public static int generateRandomCpostal() {
        int cpostal = 0;
        for (int i = 0; i < 9; i++) {
            cpostal += (int) (Math.random() * 10);
        }
        return cpostal;
    }
    
    public String getAlies() { //getter
        return alies;
    }

    public String getCorreu(){   //getter
        return correu;
    }

    public int getCpostal(){  //getter
        return cpostal;
    }

    public void setAlies( String noualies){ //setter
        this.alies = noualies;
    }

    public void setCorreu( String noucorreu){ //setter
        this.correu = noucorreu;
    }
    public void setCpostal( int noucpostal){ //setter
        this.cpostal = noucpostal;
    }

    public String toString() {   // metodo toString
        String usuario;
        usuario = "Usuario: " + alies + " " + correu + " " + cpostal;
        return usuario;
    }

    public Usuario copia(){    //metodo Copia
        return(new Usuario (this.alies, this.correu, this.cpostal));
}
}