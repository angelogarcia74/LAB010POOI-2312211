package lab10poi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import lab10poi.Medico;

public class Gestionh {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rd = new Random();
    private ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private ArrayList<Medico> listaMedicos = new ArrayList<>();

    //LISTA DE MEDICOS
    Medico medico1 = new Medico(rd.nextInt(10000), generarNombreAleatorio(),generarEspecialidadAleatoria());
    
    //LISTA DE PACIENTES
    Paciente paciente1 = new Paciente(rd.nextInt(90000000) + 10000000, generarNombreAleatorio(), generarDistritoAleatorio()+ " - Calle " + (rd.nextInt(20)+1) +", Mz " + generarMzAleatoria() +" Lt. " + rd.nextInt(301), rd.nextDouble(111) + 10, rd.nextDouble(5) + 35);    
    
    public void iniciarDatos(){
        //MEDICOS
        listaMedicos.add(medico1);

        //PACIENTES
        listaPacientes.add(paciente1);
        

        // ASIGNAR MEDICOS A LOS PACIENTES ACTUALES
        for (Paciente paciente : listaPacientes) {
            Medico medicoAleatorio = listaMedicos.get(rd.nextInt(listaMedicos.size()));
            paciente.setMedicoAtendiente(medicoAleatorio);
        }
    }

    public void menu() {
        int opcion;
        int i = 0;
        System.out.println("Bienvenido al hospital Marino Molina");

        do {
            if (i != 0) {
                System.out.println("\n¿Desea realizar otra operacion?\n");
            }
            System.out.println("1. Registrar a paciente");
            System.out.println("2. Eliminar al paciente");
            System.out.println("3. Modificar el paciente");
            System.out.println("4. Mostrar el peso más repetido");
            System.out.println("5. Mostrar la cantidad de pacientes por peso");
            System.out.println("6. Mostrar el peso mayor y menor");
            System.out.println("7. Mostrar la antidad de pacientes por rango de peso");
            System.out.println("8. Mostrar lista de pacientes ordenados por nombres");
            System.out.println("9. Mostrar médico de un paciente");
            System.out.println("10. Buscar médicos por especialidad");
            System.out.println("0. Salir");

            System.out.print("\nOpción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    imprimirListaPacientes();
                    registrarPaciente();
                    System.out.println("Lista de pacientes actualizado");
                    imprimirListaPacientes();
                    break;
                case 2:
                    imprimirListaPacientes();
                    eliminarPaciente();
                    System.out.println("Lista de pacientes actualizado");
                    imprimirListaPacientes();
                    break;
                case 3:
                    imprimirListaPacientes();
                    modificarPaciente();
                    System.out.println("Lista de pacientes actualizado");
                    imprimirListaPacientes();
                    break;
                case 4:
                    imprimirListaPacientes();
                    mostrarPesoMasRepetido();
                    break;
                case 5:
                    imprimirListaPacientes();
                    mostrarCantidadPacientesPesoRepetido();
                    break;
                case 6:
                    imprimirListaPacientes();
                    mostrarPesoMayorYMenor();
                    break;
                case 7:
                    imprimirListaPacientes();
                    mostrarCantidadPacientesPorRangoPeso();
                    break;
                case 8:
                    mostrarListaPacientesOrdenadosNombre();
                    break;
                case 9:
                    imprimirListaPacientes();
                    mostrarMedicoDePaciente();
                    break;
                case 10:
                    imprimirListaMedicos();
                    buscarMedicosEspecialidad();
                    break;
                case 0:
                    System.out.println("Vuelva pronto");
                    break;
                default:
                    System.out.println("Intente de nuevo.");
            }
            i++;
        } while (opcion != 0);
    }
    
    //GENERAMOS NOMBRES ALEATORIOS
    public String generarNombreAleatorio() {
        String[] nombres = {"Mateo", "Sebastian", "Alejandro", "Ana", "Sofia", };
        return nombres[rd.nextInt(nombres.length)];
    }
    
        
    //GENERAMOS ESPECIALIDADES ALEATORIAS
    public String generarEspecialidadAleatoria() {
        String[] especialidades = {"Dermatologia", "Traumatologia", "Medicina General", "Endocrinologia","Pediatria"};
        return especialidades[rd.nextInt(especialidades.length)];
    }
    
    public char generarMzAleatoria() {
        char[] especialidades = {'F', 'C', 'H', 'J', 'K', 'N', 'Z', 'U'};
        return especialidades[rd.nextInt(especialidades.length)];
    
    }
    //GENERAMOS DISTRITOS-CIUDAD ALEATORIA
    public String generarDistritoAleatorio() {
        String[] ciudad = {"Cercado de Lima", "Pueblo Libre", "La Victoria", "Callao", "San Miguel", "La Molina", "Surco", "San Juan de Lurigancho", "Ate" , "Santa Anita", "Miraflores", "San Isidro"};
        return ciudad [rd.nextInt(ciudad.length)];
    }

    //METODO PARA ASIGNAR MEDICO A UN PACIENTE
    public void asignarMedicoAPer(Paciente paciente){
        Medico medicoAleatorio = listaMedicos.get(rd.nextInt(listaMedicos.size()));
        paciente.setMedicoAtendiente(medicoAleatorio);
    
        System.out.println("Su médico es " + paciente.getMedicoAtendiente().getNombre() + " al paciente " + paciente.getNombre() + ".");
    }

    public void imprimirListaMedicos() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%-20s%-25s%-25s%n", "N° COLEGIATURA  ", "     NOMBRE-MEDICO  ", "          ESPECIALIDAD      ");
        System.out.println("-------------------------------------------------------------------------------");
        for (Medico medico : listaMedicos) {
            System.out.printf("%-25d%-30s%-30s%n", medico.getColegiatura(), medico.getNombre(), medico.getEspecialidad());
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void imprimirListaPacientes(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-7s%-10s%-20s%-55s%-10s%-5s%-5s%n", "POS  ", "  DNI   ", "     NOMBRE-PACIENTE  ", "         DIRECCIÓN      ", "   PESO   ", "      TEMPERATURA   ", "   MEDICO-ASIGNADO  ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        int pos = 0;
        for (Paciente paciente : listaPacientes) {
            System.out.printf("%-7d%-15.0f%-20s%-55s%-15.1f%-18.1f%-23s%n", pos, paciente.getDni(), paciente.getNombre(), paciente.getDireccion(), paciente.getPeso(), paciente.getTemperatura(), paciente.getMedicoAtendiente().getNombre());
            pos++;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    //VERIFICACION
    private double obtenerDniValido() {
        double dni;
        while (true) {
            try {
                dni = sc.nextDouble();
                if (dni >= 10000000 && dni <= 99999999) {
                    break;
                } else {
                    System.out.print("Digita un DNI válido (ocho digitos): ");
                }
            } catch (Exception e) {
                System.out.print("Digita un DNI válido (ocho dígitos): ");
                sc.nextLine();
            }
        }
        return dni;
    }
    
    //INGRESO DE NOMBRES VALIDOS
    private String obtenerNombreValido() {
        String nom = "";
        boolean nombreValido = false;

        while (!nombreValido) {
            try {
                nom = sc.next();
                nombreValido = true; 
            } catch (Exception e) {
                System.out.print("Digite solamente un nombre valido: ");
                sc.nextLine();
            }
        }

        return nom;
    }
    
    //PESO SOLAMENTE VÁLIDO
    private double obtenerPesoValido() {
        double peso;
        while (true) {
            try {
                peso = sc.nextDouble();
                if (peso > 0 && peso < 150) {
                    break;
                } else {
                    System.out.print("Digite un peso valido: ");
                }
            } catch (Exception e) {
                System.out.print("Digite un peso válido: ");
                sc.nextLine();
            }
        }
        return peso;
    }
    
    //DISPONIBILIDAD DE LA TEMPERATURA
    private double obtenerTemperaturaValida() {
        double temp;
        while (true) {
            try {
                temp = sc.nextDouble();
                if (temp > 25 && temp < 45) {
                    break;
                } else {
                    System.out.print("Digite una temperatura válida: ");
                }
            } catch (Exception e) {
                System.out.print("Digite una temperatura válida: ");
                sc.nextLine();
            }
        }
        return temp;
    }

    // OPERACION 1
    public void registrarPaciente() {
        System.out.println("\n**** Digite los datos del paciente ****");
        System.out.print("DNI: ");
        double dni = obtenerDniValido();

        System.out.print("Nombre: ");
        String nom = obtenerNombreValido();

        System.out.print("Dirección (Terminar con ' [control]p'): ");
        sc.nextLine();  
        String direccionCompleta = sc.nextLine();
        int index = direccionCompleta.lastIndexOf(" ");
        String numeroDireccion = direccionCompleta.substring(index + 1);
        String dc = direccionCompleta.substring(0, index);

        System.out.print("Peso: ");
        double peso = obtenerPesoValido();

        System.out.print("Temperatura: ");
        double temp = obtenerTemperaturaValida();
        System.out.println();
        
        Paciente nuevoPaciente = new Paciente(dni, nom, dc, peso, temp);
        listaPacientes.add(nuevoPaciente);
        System.out.println("El paciente se registró.");

        asignarMedicoAPer(nuevoPaciente);
        System.out.println();
    }
    
    //OPERACION 2
    public void eliminarPaciente() {
        System.out.print("\nPosicion del paciente a eliminar: ");
        int pos = sc.nextInt();

        if (pos >= 0 && pos < listaPacientes.size()) {
            listaPacientes.remove(pos);
            System.out.println("\nEliminado con exito.");
        } else {
            System.out.println("\nPosición no disponible. No se eliminó a nadie.");
        }
    }
    
    //OPERACION 3
    public void modificarPaciente() {
        System.out.print("\nIngrese la posición del paciente a modificar: ");
        int pos = sc.nextInt();

        if (pos >= 0 && pos < listaPacientes.size()) {
            Paciente pacienteModificado = listaPacientes.get(pos);

            System.out.println("Ingrese los datos modificados:");
            System.out.print("DNI: ");
            double dni = obtenerDniValido();
            pacienteModificado.setDni(dni);

            System.out.print("Nombre: ");
            String nom = obtenerNombreValido();
            pacienteModificado.setNombre(nom);

            System.out.print("Dirección (Terminar con ' [control]p'): ");
            sc.nextLine();  
            String direccionCompleta = sc.nextLine();
            int index = direccionCompleta.lastIndexOf(" ");
            String numeroDireccion = direccionCompleta.substring(index + 1);
            String dc = direccionCompleta.substring(0, index);
            pacienteModificado.setDireccion(dc);

            System.out.print("Peso: ");
            double peso = obtenerPesoValido();
            pacienteModificado.setPeso(peso);

            System.out.print("Temperatura: ");
            double temp = obtenerTemperaturaValida();
            pacienteModificado.setTemperatura(temp);

            System.out.println("\nEl paciente se ha modificado.");
        } else {
            System.out.println("\nPosición no válida. No se modificó ningún paciente.");
        }
    }

    public void mostrarPesoMasRepetido() {
        List<Double> pesos = new ArrayList<>();

        for (Paciente paciente : listaPacientes) {
            pesos.add(paciente.getPeso());
        }

        double pesoMasRepetido = 0.0;
        int iPersonasPeso = 0;

        for (Double peso : pesos) {
            int frecuencia = Collections.frequency(pesos, peso);
            if (frecuencia > iPersonasPeso) {
                iPersonasPeso = frecuencia;
                pesoMasRepetido = peso;
            }
        }

        System.out.printf("\nEl peso más repetido es: %.1f kg", pesoMasRepetido);
        System.out.println();
    }

    public void mostrarCantidadPacientesPesoRepetido() {
        List<Double> pesos = new ArrayList<>();

        for (Paciente paciente : listaPacientes) {
            pesos.add(paciente.getPeso());
        }

        int iPersonasPeso = 0;

        for (Double peso : pesos) {
            int frecuencia = Collections.frequency(pesos, peso);
            if (frecuencia > iPersonasPeso) {
                iPersonasPeso = frecuencia;
            }
        }

        System.out.println("\nEl peso con la cantidad más repetida es: " + iPersonasPeso + " paciente(s).");
        System.out.println();
    }

    public void mostrarPesoMayorYMenor() {
        double mayorPeso = 0.0;
        double menorPeso = 1000.0;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getPeso() > mayorPeso) {
                mayorPeso = paciente.getPeso();
            }
            if (paciente.getPeso() < menorPeso) {
                menorPeso = paciente.getPeso();
            }
        }

        System.out.printf("\nEl mayor peso en los pacientes es: %.1f kg.", mayorPeso);
        System.out.printf("\nEl menor peso en los pacientes es: %.1f kg.", menorPeso);
        System.out.println();
    }

    public void mostrarCantidadPacientesPorRangoPeso() {
        double mayorPeso = 0.0;
        double menorPeso = 1000.0;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getPeso() > mayorPeso) {
                mayorPeso = paciente.getPeso();
            }
            if (paciente.getPeso() < menorPeso) {
                menorPeso = paciente.getPeso();
            }
        }

        double rango = (mayorPeso - menorPeso) / 4;
        int[] contadorRango = new int[4];

        for (Paciente paciente : listaPacientes) {
            double peso = paciente.getPeso();
            for (int i = 0; i < 4; i++) {
                double rangoMenor = menorPeso + i * rango;
                double rangoMayor = menorPeso + (i + 1) * rango;
                if (peso >= rangoMenor && peso < rangoMayor) {
                    contadorRango[i]++;
                    break;
                }
            }
        }

        System.out.println("\nCantidad de pacientes por rango de peso:");
        for (int i = 0; i < 4; i++) {
            double rangoMenor = menorPeso + i * rango;
            double rangoMayor = menorPeso + (i + 1) * rango;
            System.out.printf("Rango %.0f - %.0f kg: %d pacientes\n", rangoMenor, rangoMayor, contadorRango[i]);
        }
    }

    public void mostrarListaPacientesOrdenadosNombre() {
        Collections.sort(listaPacientes, Comparator.comparing(Paciente::getNombre));

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-7s%-10s%-20s%-55s%-10s%-5s%-5s%n", "POS  ", "  DNI   ", "     NOMBRE-PACIENTE  ", "         DIRECCIÓN      ", "   PESO   ", "      TEMPERATURA   ", "   MEDICO-ASIGNADO  ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        int pos = 0;
        for (Paciente paciente : listaPacientes) {
        System.out.printf("%-7d%-15.0f%-20s%-55s%-15.2f%-18.2f%-23s%n", pos, paciente.getDni(), paciente.getNombre(), paciente.getDireccion(), paciente.getPeso(), paciente.getTemperatura(), paciente.getMedicoAtendiente().getNombre()); 
        pos++;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void mostrarMedicoDePaciente() {
        System.out.print("\nIngrese el DNI del paciente: ");
        int dni = sc.nextInt();

        for (Paciente paciente : listaPacientes) {
            if (paciente.getDni() == dni) {
                System.out.println("\nEl médico que se ha asignado para "+ paciente.getNombre() + " con dni " + dni + " es: "+ paciente.getMedicoAtendiente().getNombre() + " - Médico de " + paciente.getMedicoAtendiente().getEspecialidad());
                return;
            }
        }

        System.out.println("\nNo se ha encontrado al paciente.");
    }

    public void buscarMedicosEspecialidad() {
        System.out.println("\nHospital Marino Molina - Especialidades:\n> Dermatologia:\n> Traumatologia:\n Medicina\n> General\n> Endocrinologia\n> Pediatria");
        System.out.print("Digite la especialidad a buscar: ");
        String especialidad = sc.next();

        boolean encontrado = false;

        for (Medico medico : listaMedicos) {
            if (medico.getEspecialidad().equalsIgnoreCase(especialidad)) {
                System.out.println("\nMédico de " + especialidad + ": " + medico.getNombre());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\nNo hay médicos de " + especialidad +" en estos momentos.");
        }
    }

}
    

