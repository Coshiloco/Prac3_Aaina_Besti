import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class InterfazGrafica extends JFrame implements ActionListener {

    public InterfazGrafica() {
        // Configuración inicial del marco (frame)
        setTitle("Interfaz con Botón");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrar la ventana en la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 3, height / 3);    
        setLocationRelativeTo(null); // esto centra la ventana

        // Crear un botón y agregarlo al marco
        JButton boton = new JButton("Presiona Aquí");
        boton.addActionListener(this); // Usar 'this' aquí
        this.getContentPane().add(boton, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        InterfazGrafica ventana = new InterfazGrafica();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("¡Me presionaste!");
    }
}
