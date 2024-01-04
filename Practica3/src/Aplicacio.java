//Esther Batalla y Lucas Domínguez
public class Aplicacio {
public static void main(String[] args) {

    // Començarem validant la clase Usuario, els getters, setters i toStrings
    System.out.println("VALIDACIO USUARIO ->");
    Usuario hola = new Usuario("javi", "javi@", 2923);
    Usuario arbre = new Usuario("carmen", "carmen@", 2309);
    System.out.println("El codi postal es " + hola.getCpostal() );
    hola.setAlies("andreu");
    System.out.println("Despres de modificar alguns valors obtenim: " + hola.toString());

    //Validació classe llistaUsuarios
    System.out.println("VALIDACIO LLISTA USUARIO ->");
    llistaUsuarios llistUsuari = new llistaUsuarios(9);
    llistUsuari.afegirU("arnau", "arnaugmail", 76);
    llistUsuari.afegirU("agulema", "pepephoner", 86);
    llistUsuari.afegirU("izulema", "maricarmer", 96);
    llistUsuari.afegirU("marialema", "doñaascension", 136);
    llistUsuari.afegirU("condesona", "palomito", 126);
    System.out.println("La llista es: " + llistUsuari);

    //Validació classe entitat
    System.out.println("VALIDACIO ENTITAT ->");
    Entitat apple = new Entitat("APPLE", 343434 , "apple@");
    Entitat samsung = new Entitat("Samsung", 78364870, "samsung@");
    Entitat nesle = new Entitat("nesle", 48792870, "nesle@2");
    System.out.println("La entitat utilitzada es: " + apple.getNomEntitat()+ " amb el tel " + apple.getTelefon());
    apple.setCorreu("apple.com");
    System.out.println("Les noves dades de la entitat son " +apple.toString());

    //Validació classe llistaEntitats
    System.out.println("VALIDACIO LLISTA ENTITATS ->");
    LlistaEntitats llistEntitat = new LlistaEntitats(10);
    llistEntitat.afegir("APPLE", 343434 , "apple@");
    llistEntitat.afegir("AMC", 3445436 , "conel@");
    llistEntitat.afegir("LINUS", 34454644 , "odonnel@");
    llistEntitat.afegir("WINDOUS", 341323231 , "pepionel@");
    llistEntitat.afegir("COMPUTEDORE", 123123213 , "maripollel@");
    System.out.println("La llista es: " + llistEntitat);

    //Validació clase activitats
    System.out.println("VALIDACIO ACTIVITATS ->");
    Visites museu = new Visites("musblau", "barna", "98934", 1, apple, true, false);
    Xerrades mobils = new Xerrades("conf sams", "alemania", "983847", 9, samsung, "julia");
    Tallers cuina = new Tallers("nesleCuina", "italia", "28974", 9, nesle, "15", "12", 4, 100);

    System.out.println("La activitat es tracta de: " + museu.getCodi());
    System.out.println("També es disposa d'un altre activitat: " + mobils.getCodi() + " la qual l'exposa: " +mobils.getnomPersona());
    System.out.println("Per ultim creem una instància de taller: " +cuina.getCodi()+" el dia "+cuina.getData()+" a les "+cuina.getHora());

    //Validació classe llistaActivitats
    System.out.println("VALIDACIO LLISTA ACTIVITATS ->");
    LlistaActivitats llistActivitats = new LlistaActivitats(10);
    llistActivitats.afegirActivitat("nesleCuina", "italia", "28974", 9, nesle);
    llistActivitats.afegirActivitat("marolina", "nmariodad", "28974", 9, nesle);
    llistActivitats.afegirActivitat("nessadasdsa", "iasfasdsc", "28974", 9, nesle);
    llistActivitats.afegirActivitat("nesdasdsjdsajnc", "iassadasd", "28974", 9, nesle);
    llistActivitats.afegirActivitat("guiloca", "isdasdasdsa", "28974", 9, nesle);
    System.out.println("La llista es: " + llistActivitats);
    
    
    PersistenciaFicheros.guardarDatos("usuarios", "actividades", "entidades", llistUsuari, llistActivitats, llistEntitat);


    //Validació reserves
    System.out.println("VALIDACIÓ RESERVES->");
    Reserves primera = new Reserves(32, hola, cuina);
    Reserves segona = new Reserves(33, arbre, cuina);
    System.out.println("Obtenim el codi de la reserva: "+primera.getCodiReserva());
    primera.setValoracio((33));
    primera.setValoracio(1);
    segona.setValoracio(8);
    System.out.println("La valoracio de la activitat cuina total es de "+cuina.getPuntuacio());

    //Validació classe llista reserves
    System.out.println("VALIDACIO LLISTA RESERVES ->");
    LlistaReserves llistaReserves = new LlistaReserves(10);
    llistaReserves.afegirReserva(primera);
    llistaReserves.afegirReserva(segona);
    System.out.println("La llista es: " + llistaReserves);
    }
}