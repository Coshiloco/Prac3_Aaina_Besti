//Lucas Domínguez
import java.util.concurrent.atomic.AtomicInteger;
    
 public class Activitats {
        private static final AtomicInteger count = new AtomicInteger(100); // Para generar códigos únicos
        private String codi;
        private String nom;
        private String lloc;
        private String codiPostal;
        private int data; // fecha dia 1-30
        private Entitat entitat;
    
        // Constructor
        public Activitats(String nom, String lloc, String codiPostal, int data, Entitat entitat) {
            this.codi = generateUniqueCode(entitat.getNomEntitat());
            this.nom = nom;
            this.lloc = lloc;
            this.codiPostal = codiPostal;
            this.data = data;
            this.entitat = entitat;
        }
        
        
        // Generate a public method to get the next value of the counter
        /**
         * mètode per obtenir el valor del contador
         * @return valor del contador
         */
        public static int getNextValue() {
            return count.get();
        }
        
        // Generate a public method for generate a ramdom code atributte
        /**
         * mètode per generar un codi aleatori
         * @param entitatNom nom de l'entitat
         * @return codi aleatori
         */
        public static String generateRandomCode(String entitatNom) {
            String codi = "";
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < 10; i++) {
                codi += alphabet.charAt((int) (Math.random() * alphabet.length()));
            }
            return codi;
        }
        
        public static String generateRandomName() {
            String nom = "";
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < 10; i++) {
                nom += alphabet.charAt((int) (Math.random() * alphabet.length()));
            }
            return nom;
        }
        
        public static String generateRandomLloc() {
            String lloc = "";
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < 10; i++) {
                lloc += alphabet.charAt((int) (Math.random() * alphabet.length()));
            }
            return lloc;
        }
        
        public static String generateRandomCodiPostal() {
            String codiPostal = "";
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < 10; i++) {
                codiPostal += alphabet.charAt((int) (Math.random() * alphabet.length()));
            }
            return codiPostal;
        }
        
        public static int generateRandomData() {
            int data = (int) (Math.random() * 30) + 1;
            return data;
        }
        
        public static Entitat generateRandomEntitat() {
            String nomEntitat = "";
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < 10; i++) {
                nomEntitat += alphabet.charAt((int) (Math.random() * alphabet.length()));
            }
            int telefon = (int) (Math.random() * 100000000);
            String correu = "";
            for (int i = 0; i < 10; i++) {
                correu += alphabet.charAt((int) (Math.random() * alphabet.length()));
            }
            return new Entitat(nomEntitat, telefon, correu);
        }
    
        // Getters y setters
        public String getCodi() {
            return codi;
        }
    
        public String getNom() {
            return nom;
        }
    
        public void setNom(String nom) {
            this.nom = nom;
        }
    
        public String getLloc() {
            return lloc;
        }
    
        public void setLloc(String lloc) {
            this.lloc = lloc;
        }
    
        public String getCodiPostal() {
            return codiPostal;
        }
    
        public void setCodiPostal(String codiPostal) {
            this.codiPostal = codiPostal;
        }
    
        public int getData() {
            return data;
        }
    
        public void setData(int data) {
            this.data = data;
        }
    
        public Entitat getEntitat() {
            return entitat;
        }
    
        public void setEntitat(Entitat entitat) {
            this.entitat = entitat;
        }
    
        // Método privado para generar códigos únicos
        private String generateUniqueCode(String entitatNom) {
            return entitatNom.substring(0, Math.min(3, entitatNom.length())).toUpperCase() +
                   count.getAndIncrement();
        }


        public String toString() {   // metodo toString
            String activitat;
            activitat = "Actividad: " + codi + " " + nom + " " + lloc + " " + codiPostal + " " + data + " " + entitat.toString() ;
            return activitat;
        }
        public Activitats copia() {
            return(new Activitats(nom, lloc, codiPostal, data, entitat));
        }
        
   
    }
    



