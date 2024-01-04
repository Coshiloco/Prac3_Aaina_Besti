import java.io.FileNotFoundException;
import java.util.Scanner;

public class AplicacioConsola {
	static Scanner teclat = new Scanner(System.in);
	static String[] dataset;
	
	static llistaUsuarios llistaUsuarios;
	static LlistaActivitats llistaActivitats;
	static LlistaEntitats llistaEntitats;
	static LlistaReserves llistaReserves;
		
		// Mostrar el menú
        public static void main(String[] args) throws FileNotFoundException {
		boolean menu = true;
		generateFakeData();
		while (menu) {
            System.out.println("Menú Principal:");
            System.out.println("1. Mostrar les dades de qualsevol llista que tingueu definida(Enseñar los datos de cualquier lista definida).");
            System.out.println("2. Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta.");
            System.out.println("3. Obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat(Obtener y mostrar la lista de las actividades que se llevan a cabo en un dia indicado por teclado).");
			System.out.println("4. Obtenir i mostrar la llista dels tallers que tenen places disponibles.");
            System.out.println("5. Afegir una nova activitat");
            System.out.println("6. Registrar la petició d’un usuari per reservar un taller.");
			System.out.println("7. Mostrar els usuaris que s’han apuntat a un taller.");
            System.out.println("8. Calcular l’usuari que s’ha apuntat a més tallers.");
            System.out.println("9. Registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop s’ha fet.");
            System.out.println("10. Calcular la nota mitja que ha rebut un taller.");
            System.out.println("11. Quin és el taller que ha tingut més èxit? Calcularem l’èxit segons el taller que ha tingut una ocupació més alta en proporció a les places que oferia.");
			System.out.println("12. Obtenir i mostrar les dades de la llista de visites ofertes per una entitat (per teclat s’indicarà si es vol audioguia o si cal que estigui adaptada per persones cegues).");
            System.out.println("13. Mostrar les dades de les xerrades que farà una persona concreta.");
            System.out.println("14. Donar de baixa un taller sempre que no hi hagi usuaris apuntats.");
            System.out.println("15. Sortir de l’aplicació.");

            // Obtenir l'opció de l'usuari
            int opcio = teclat.nextInt();

            // Executar
            switch (opcio) {
                case 1:
                    ex1();
                    break;
                case 2:
                    //ex2();
                    break;
                case 3:
                    ex3();
                    break;
				case 4:
                    //ex4();
                    break;
                case 5:
                    //ex5();
                    break;
                case 6:
                    //ex6();
                    break;
				case 7:
                    //ex7();
                    break;
                case 8:
                    //ex8();
                    break;
                case 9:
                    //ex9();
                    break;
                case 10:
                    //ex10();
                    break;
                case 11:
                    //ex11();
                    break;
				case 12:
                    //ex12();
                    break;
                case 13:
                    //ex13();
                    break;
                case 14:
                    //ex14();
                    break;
                case 15:
                    ex15();
					menu = false;
					break;
                default:
                    System.out.println("Opció no vàlida.");
					break;
            }
		}

}

//1. Mostrar les dades de qualsevol llista
private static void ex1(){
    System.out.println("Indica la llista: \n 1.Llista d'activitats \n 2.Llista d'entitats \n 3.Llista de reserves \n 4.Llista d'usuaris");
    teclat.nextLine();
    String dadesLlista = teclat.nextLine();
    switch (dadesLlista) {
        case "1":
            System.out.println("Llista d'activitats: ");
            recorrerListaActividad();
            break;
            case "2":
            System.out.println("Llista d'entitats: ");
            recorrerListaEntidad();
            break;
                    case "3":
            System.out.println("Llista d'reserves: ");
            recorrerListaReservas();
            break;
                    case "4":
            System.out.println("Llista d'usuaris: ");
            recorrerListaUsuarios();
            break;
        default:
            break;
    }

}


private static void ex3() {
    System.out.println("Introduce el dia para saber la lista de actividades");
    teclat.nextLine();
    int dia = teclat.nextInt();
    
    // Algoritmo de busqueda basico(Basiquisimo GOMINOLA)
    for (int i = 0; i < llistaActivitats.getNElem(); i++) {
        Activitats actividad = llistaActivitats.getLlistaActivitats()[i];
        if (dia == actividad.getData()) {
            System.out.println(actividad.toString());
        } else {
            System.out.println("No hay actividades para ese dia");
        }
    }
    
}

//15. Sortir del programa
private static void ex15(){
    System.out.println("Has sortit del programa");
    }
    
    
    private static void generateFakeData() {
        llistaUsuarios = new llistaUsuarios(15);
        llistaActivitats = new LlistaActivitats(15);
        llistaEntitats = new LlistaEntitats(15);
        llistaReserves = new LlistaReserves(15);
        for (int i = 0; i < llistaUsuarios.getUsuarios().length; i++) {
            llistaUsuarios.afegirU(Usuario.generateRandomAlies(), Usuario.generateRandomCorreu(), Usuario.generateRandomCpostal());
        }
        for (int i = 0; i < llistaActivitats.getLlistaActivitats().length; i++) {
            llistaActivitats.afegirActivitat(Activitats.generateRandomName(), Activitats.generateRandomLloc(), Activitats.generateRandomCodiPostal(), Activitats.generateRandomData(), Activitats.generateRandomEntitat());
        }
        for (int i = 0; i < llistaEntitats.getLlista().length; i++) {
            llistaEntitats.afegir(Entitat.generateRandomName(), Entitat.generateRandomTelefon(), Entitat.generateRandomCorreu());
        }
        for (int i = 0; i < llistaReserves.getLlista().length; i++) {
            llistaReserves.afegirReserva(Reserves.generateRandomReserves());
        }
    }
    
    
    private static void recorrerListaUsuarios() {
        for (int i = 0; i < llistaUsuarios.getUsuarios().length; i++) {
            System.out.println(llistaUsuarios.getUsuarios()[i].toString());
        }
    }
    
    private static void recorrerListaActividad() {
        for (int i = 0; i < llistaActivitats.getLlistaActivitats().length; i++) {
            System.out.println(llistaActivitats.getLlistaActivitats()[i].toString());
        }
    }
    private static void recorrerListaEntidad() {
        for (int i = 0; i < llistaEntitats.getLlista().length; i++) {
            System.out.println(llistaEntitats.getLlista()[i].toString());
        }
    }
    private static void recorrerListaReservas() {
        for (int i = 0; i < llistaReserves.getLlista().length; i++) {
            System.out.println(llistaReserves.getLlista()[i].toString());
        }
    }
}