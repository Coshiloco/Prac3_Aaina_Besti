import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ActivitatsGUI extends JFrame {

    private LlistaActivitats llistaActivitats;
    private DefaultListModel<String> model;
    private Map<Integer, JButton> botonesDias;
    private Map<String, JButton> botonesTipos;
    private LocalDate fechaInicial;

    public ActivitatsGUI() {
        llistaActivitats = new LlistaActivitats(100);
        model = new DefaultListModel<>();
        botonesDias = new HashMap<>();
        botonesTipos = new HashMap<>();
        fechaInicial = LocalDate.now();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Gestor d'Activitats");
        setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JList<String> listActivities = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(listActivities);
        mainPanel.add(scrollPane);

        JPanel inputPanel = new JPanel();
        JTextField nomField = new JTextField(10);
        JTextField llocField = new JTextField(10);
        JTextField codiPostalField = new JTextField(5);
        JTextField dataField = new JTextField(2);
        inputPanel.add(new JLabel("Nom:"));
        inputPanel.add(nomField);
        inputPanel.add(new JLabel("Lloc:"));
        inputPanel.add(llocField);
        inputPanel.add(new JLabel("Codi Postal:"));
        inputPanel.add(codiPostalField);
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(dataField);
        mainPanel.add(inputPanel);

        JPanel daysPanel = new JPanel(new GridLayout(2, 5));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (int i = 0; i < 10; i++) {
            LocalDate day = fechaInicial.plusDays(i);
            JButton dayButton = new JButton(day.format(formatter));
            dayButton.addActionListener(e -> mostrarActividadesDia(day));
            daysPanel.add(dayButton);
            botonesDias.put(day.getDayOfMonth(), dayButton);
        }
        mainPanel.add(daysPanel);

        JPanel filterPanel = new JPanel(new GridLayout(1, 3));
        String[] tipos = {"Tipo1", "Tipo2", "Tipo3"};
        for (String tipo : tipos) {
            JButton filterButton = new JButton(tipo);
            filterButton.addActionListener(e -> filtrarActividadesPorTipo(tipo));
            filterPanel.add(filterButton);
            botonesTipos.put(tipo, filterButton);
        }
        mainPanel.add(filterPanel);

        JButton addButton = new JButton("Afegir Activitat");
        addButton.addActionListener(e -> afegirActivitat(nomField.getText(), llocField.getText(), codiPostalField.getText(), Integer.parseInt(dataField.getText())));
        JButton loadButton = new JButton("Cargar Actividades");
        loadButton.addActionListener(e -> cargarDatos());
        JButton filterTodayButton = new JButton("Activitats Avui");
        filterTodayButton.addActionListener(e -> filtrarActivitatsAvui());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(filterTodayButton);
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    private void mostrarActividadesDia(LocalDate day) {
        model.clear();
        botonesTipos.values().forEach(button -> button.setBackground(null));
        for (Activitats activitat : llistaActivitats.getLlistaActivitats()) {
            if (activitat != null && activitat.getData() == day.getDayOfMonth()) {
                model.addElement(activitat.toString());
                JButton buttonTipo = botonesTipos.get(activitat.getEntitat().getNomEntitat());
                if (buttonTipo != null) {
                    buttonTipo.setBackground(Color.GREEN);
                }
            }
        }
    }

    private void filtrarActividadesPorTipo(String tipo) {
        model.clear();
        for (Activitats activitat : llistaActivitats.getLlistaActivitats()) {
            if (activitat != null && activitat.getEntitat().getNomEntitat().equals(tipo)) {
                model.addElement(activitat.toString());
            }
        }
    }

    private void afegirActivitat(String nom, String lloc, String codiPostal, int data) {
        Entitat entitat = Activitats.generateRandomEntitat();
        Activitats activitat = new Activitats(nom, lloc, codiPostal, data, entitat);
        llistaActivitats.afegirActivitat(nom, lloc, codiPostal, data, entitat);
        model.addElement(activitat.toString());
    }

    private void cargarDatos() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(ActivitatsGUI.this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length < 8) {
                        JOptionPane.showMessageDialog(this, "Línea incompleta o con formato incorrecto: " + line);
                        continue; // Salta esta línea y continúa con la siguiente
                    }
                    String codi = parts[0];
                    String nom = parts[1];
                    String lloc = parts[2];
                    String codiPostal = parts[3];
                    String dataString = parts[4]; // Necesitarás convertir esto a un formato de fecha o un entero
                    String email = parts[5];
                    String nomEntitat = parts[6];
                    String telefon = parts[7];
    
                    // Parsear la fecha si es necesario, asumiendo formato dd/MM/yy
                    String[] fechaPartes = dataString.split("/");
                    int data = Integer.parseInt(fechaPartes[0]); // Esto solo toma el día, ajustar según tu modelo de datos
    
                    // Crear la entidad
                    Entitat entitat = new Entitat(nomEntitat, Integer.parseInt(telefon), email);
    
                    // Crear la actividad
                    Activitats activitat = new Activitats(nom, lloc, codiPostal, data, entitat);
                    llistaActivitats.afegirActivitat(nom, lloc, codiPostal, data, entitat);
                    model.addElement(activitat.toString());
                }
            } catch (IOException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
            }
        }
    }

    private void filtrarActivitatsAvui() {
        mostrarActividadesDia(LocalDate.now());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ActivitatsGUI());
    }
}

// Añadir aquí las clases Entitat, LlistaActivitats y Activitats...
