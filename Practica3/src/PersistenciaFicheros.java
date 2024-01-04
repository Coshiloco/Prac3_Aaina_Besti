import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PersistenciaFicheros {
    
    
    private static String nombreFiechero = ".txt";
    
    
    private static final String SEPARADOR = ";";
    
    
    
    private static File fichero;
    
    
    
    public static void escribirUsuarios(String ficheroUsuarios,llistaUsuarios llistaUsuarios) {
    
        // Nombre del fichero que pasamos por parametros mas la extension
        String nombreFichero = ficheroUsuarios + nombreFiechero;
    
        // Cremos el fichero especifico de usuarios
        fichero = new File(nombreFichero);
    
        // Nos creamos un BufferedWriter que escribirá en el fichero
        BufferedWriter bw = null;
        
        try {
            bw = new BufferedWriter(new FileWriter(fichero));
            for (int i = 0; i < llistaUsuarios.getUsuarios().length; i++) {
                Usuario usuario = llistaUsuarios.getUsuarios()[i];
                if (usuario != null) {
                    System.out.println(usuario.toString());
                    bw.write(usuario.getAlies() + SEPARADOR + usuario.getCorreu() + SEPARADOR + usuario.getCpostal());
                    bw.newLine();
                } else {
                    System.out.println("Usuario en posición " + i + " es null");
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el BufferedWriter");
            }
        }
        
    }
    
    
    
    public static void escribirActividades(String ficheroActividades,LlistaActivitats llistaActivitats) {
    
        // Nombre del fichero que pasamos por parametros mas la extension
        String nombreFichero = ficheroActividades + nombreFiechero;
    
        // Creamos el fichero especifico de actividades
        fichero = new File(nombreFichero);
    
        // Nos creamos un BufferedWriter que escribirá en el fichero
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fichero));
            for (int i = 0; i < llistaActivitats.getLlistaActivitats().length; i++) {
                Activitats actividad = llistaActivitats.getLlistaActivitats()[i];
                if (actividad != null) {
                    System.out.println(actividad.toString());
                    bw.write(actividad.getCodi() + SEPARADOR + actividad.getNom() + SEPARADOR + actividad.getLloc() + SEPARADOR + actividad.getCodiPostal() + SEPARADOR + actividad.getData() + SEPARADOR + actividad.getEntitat().getCorreu() + SEPARADOR + actividad.getEntitat().getNomEntitat() + SEPARADOR + actividad.getEntitat().getTelefon());
                    bw.newLine();
                } else {
                    System.out.println("Actividad en posición " + i + " es null");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el BufferedWriter");
            }
        }
    }
    
    public static void escribirEntidades(String ficheroEntidades,LlistaEntitats llistaEntitats) {
    
        // Nombre del fichero que pasamos por parametros mas la extension
        String nombreFichero = ficheroEntidades + nombreFiechero;
        
    
        // Creamos el fichero especifico de entidades
        fichero = new File(nombreFichero);
    
        // Nos creamos un BufferedWriter que escribirá en el fichero
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fichero));
            for (int i = 0; i < llistaEntitats.getLlista().length; i++) {
                Entitat entidad = llistaEntitats.getLlista()[i];
                if (entidad != null) {
                    System.out.println(entidad.toString());
                    bw.write(entidad.getNomEntitat() + SEPARADOR + entidad.getTelefon() + SEPARADOR + entidad.getCorreu());
                    bw.newLine();
                } else {
                    System.out.println("Entidad en posición " + i + " es null");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el BufferedWriter");
            }
        }
    }
    
    
    
    public static void escribirDatos(String nombreFicheroUsuarios, String nombreFicheroActividad, String nombreFicheroEntidad, llistaUsuarios llistaUsuarios, LlistaActivitats llistaActivitats, LlistaEntitats llistaEntitats) {
        escribirUsuarios(nombreFicheroUsuarios, llistaUsuarios);
        escribirActividades(nombreFicheroActividad, llistaActivitats);
        escribirEntidades(nombreFicheroEntidad, llistaEntitats);
    }
    
    public static void guardarDatos(String nombreFicheroUsuarios, String nombreFicheroActividad, String nombreFicheroEntidad, llistaUsuarios llistaUsuarios, LlistaActivitats llistaActivitats, LlistaEntitats llistaEntitats) {
        // Escribimos los datos en el fichero
        escribirDatos(nombreFicheroUsuarios ,nombreFicheroActividad , nombreFicheroEntidad, llistaUsuarios, llistaActivitats, llistaEntitats);
    }
    
    public static String getNombreFiechero() {
        return nombreFiechero;
    }
    
    public static void setNombreFiechero(String nombreFiechero) {
        PersistenciaFicheros.nombreFiechero = nombreFiechero;
    }
    
}
