package com.openbank;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;
import com.openbank.database.DBCliente;
import com.openbank.database.DBGestor;
import com.openbank.database.DBMensaje;
import com.openbank.database.DBPrestamo;
import com.openbank.database.DBTransferencia;
import com.openbank.model.Cliente;
import com.openbank.model.Gestor;
import com.openbank.model.Mensaje;
import com.openbank.model.Prestamo;
import com.openbank.model.Transferencia;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        boolean programaActivo = true;

        // <---------- Menu principal --------------------->

        do {
            System.out.println("----------\n" + "OpenBank - Escoje una categoria\n" + "----------");
            System.out.println("[1] - Clientes");
            System.out.println("[2] - Gestores");
            System.out.println("[3] - Prestamos");
            System.out.println("[4] - Transferencias");
            System.out.println("[5] - Mensajes");
            System.out.println("[6] - Terminar programa");

            int opcion = lector.nextInt();

            // <---------- Clientes --------------------->

            if (opcion == 1) {

                boolean submenu = true;

                DBCliente dbCliente = new DBCliente();

                do {
                    System.out.println("----------\n" + "OpenBank - ¿Que desea realizar?\n" + "----------");
                    System.out.println("[1] - Nuevo cliente");
                    System.out.println("[2] - Consultar un cliente");
                    System.out.println("[3] - Ver todos los clientes");
                    System.out.println("[4] - Actualizar un cliente");
                    System.out.println("[5] - Eliminar un cliente");
                    System.out.println("[6] - Volver al menu principal");

                    int opcionSubmenu = lector.nextInt();


                    if (opcionSubmenu == 1) {
                        System.out.println("----------\n" + "[1] - Nuevo cliente\n" + "----------");
                        System.out.print("Introduce el usuario: ");
                        String usuario = lector.next();
                        System.out.print("Introduce el password: ");
                        String password = lector.next();
                        System.out.print("Introduce el correo: ");
                        String correo = lector.next();
                        System.out.print("Introduce el saldo: ");
                        int saldo = lector.nextInt();
                        System.out.print("Introduce el ID del gestor asociado: ");
                        int id_gestor = lector.nextInt();

                        Cliente cliente = new Cliente(id_gestor, usuario, password, correo, saldo);
                        dbCliente.insertCliente(cliente);
                        System.out.println("----------\n" + "Cliente ingresado: " + cliente + "----------");

                    } else if (opcionSubmenu == 2) {
                        System.out.println("----------\n" + "[2] - Consultar un cliente\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();

                        System.out.println("----------\n" + "Cliente solicitado: \n");
                        dbCliente.getCliente(id);
                        System.out.println("----------");
                        

                    } else if (opcionSubmenu == 3) {
                        System.out.println("----------\n" + "[3] - Ver todos los clientes\n" + "----------");
                        dbCliente.getClientes();

                    } else if (opcionSubmenu == 4) {
                        System.out.println("----------\n" + "[4] - Actualizar cliente\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();
                        System.out.print("Introduce el usuario: ");
                        String usuario = lector.next();
                        System.out.print("Introduce el password: ");
                        String password = lector.next();
                        System.out.print("Introduce el correo: ");
                        String correo = lector.next();
                        System.out.print("Introduce el saldo: ");
                        int saldo = lector.nextInt();
                        System.out.print("Introduce el ID del gestor asociado: ");
                        int id_gestor = lector.nextInt();

                        Cliente cliente = new Cliente(id, id_gestor, usuario, password, correo, saldo);
                        dbCliente.updateCliente(cliente);
                        System.out.println("----------\n" + "Cliente actualizado: " + cliente + "----------");

                    } else if (opcionSubmenu == 5) {
                        System.out.println("----------\n" + "[5] - Eliminar un cliente\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();

                        dbCliente.deleteCliente(id);

                        System.out.println("----------\n" + "Cliente eliminado: \n" + "" + "----------");

                    } else if (opcionSubmenu == 6) {
                        submenu = false;
                    } else {
                        System.out.println("No has escogido correctamente");
                    }
                } while (submenu);

            // <---------- Gestores --------------------->

            } else if (opcion == 2) {

                boolean submenu = true;               

                DBGestor dbGestor = new DBGestor();

                do {
                    System.out.println("----------\n" + "OpenBank - ¿Que desea realizar?\n" + "----------");
                    System.out.println("[1] - Nuevo gestor");
                    System.out.println("[2] - Consultar un gestor");
                    System.out.println("[3] - Ver todos los gestores");
                    System.out.println("[4] - Actualizar un gestor");
                    System.out.println("[5] - Eliminar un gestor");
                    System.out.println("[6] - Volver al menu principal");

                    int opcionSubmenu = lector.nextInt();

                    if (opcionSubmenu == 1) {

                        System.out.println("----------\n" + "[1] - Nuevo gestor\n" + "----------");
                        System.out.print("Introduce el usuario: ");
                        String usuario = lector.next();
                        System.out.print("Introduce el password: ");
                        String password = lector.next();
                        System.out.print("Introduce el correo: ");
                        String correo = lector.next();

                        Gestor gestor = new Gestor(usuario, password, correo);
                        dbGestor.insertGestor(gestor);
                        System.out.println("----------\n" + "Gestor ingresado: " + gestor + "----------");

                        
                    } else if (opcionSubmenu == 2) {

                        System.out.println("----------\n" + "[2] - Consultar un gestor\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();

                        System.out.println("----------\n" + "Gestor solicitado: ");
                        dbGestor.getGestor(id);
                        System.out.println("----------");

                    } else if (opcionSubmenu == 3) {
                        System.out.println("----------\n" + "[3] - Ver todos los gestores\n" + "----------");
                        dbGestor.getGestores();

                    } else if (opcionSubmenu == 4) {

                        System.out.println("----------\n" + "[4] - Actualizar gestor\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();
                        System.out.print("Introduce el usuario: ");
                        String usuario = lector.next();
                        System.out.print("Introduce el password: ");
                        String password = lector.next();
                        System.out.print("Introduce el correo: ");
                        String correo = lector.next();

                        Gestor gestor = new Gestor(id, usuario, password, correo);
                        System.out.println("----------\n" + "Gestor actualizado: " + gestor + "----------");

                    } else if (opcionSubmenu == 5) {
                        System.out.println("----------\n" + "[5] - Eliminar un gestor\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();

                        dbGestor.deleteGestor(id);
                        System.out.println("----------\n" + "Gestor eliminado: \n" + "----------");

                    } else if (opcionSubmenu == 6) {
                        submenu = false;
                    } else {
                        System.out.println("No has escogido correctamente");
                    }
                } while (submenu);

            // <---------- Prestamos --------------------->

            } else if (opcion == 3) {

                boolean submenu = true;

                DBPrestamo dbPrestamo = new DBPrestamo();

                do {
                    System.out.println("----------\n" + "OpenBank - ¿Que desea realizar?\n" + "----------");
                    System.out.println("[1] - Nuevo prestamo");
                    System.out.println("[2] - Consultar un prestamo");
                    System.out.println("[3] - Consultar todos los prestamos");
                    System.out.println("[4] - Eliminar un prestamo");
                    System.out.println("[5] - Volver al menu principal");

                    int opcionSubmenu = lector.nextInt();

                    if (opcionSubmenu == 1) {

                        System.out.println("----------\n" + "[1] - Nuevo Prestamo\n" + "----------");
                        System.out.print("Introduce el nombre: ");
                        String nombre = lector.next();
                        System.out.print("Introduce la comision: ");
                        Long importe = lector.nextLong();
                        System.out.print("Introduce los meses: ");
                        int concepto = lector.nextInt();
                                 
                        Prestamo prestamo = new Prestamo(nombre, importe, concepto);
                        dbPrestamo.insertPrestamo(prestamo);
                        System.out.println("----------\n" + "Prestamo ingresado: " + prestamo + "----------");

                        
                    } else if (opcionSubmenu == 2) {

                        System.out.println("----------\n" + "[2] - Consultar un prestamo\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();

                        dbPrestamo.getPrestamo(id);
                        System.out.println("----------\n" + "Prestamo solicitado: " + "" + "----------");

                    } else if (opcionSubmenu == 3) {
                        System.out.println("----------\n" + "[3] - Consultar todos los prestamos\n" + "----------");
                        dbPrestamo.getPrestamos();

                    } else if (opcionSubmenu == 4) {
                        System.out.println("----------\n" + "[4] - Eliminar un prestamo\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();
                        dbPrestamo.deletePrestamo(id);
                        System.out.println("----------\n" + "Prestamo eliminado: \n" + "----------");

                    } else if (opcionSubmenu == 5) {
                        submenu = false;
                    } else {
                        System.out.println("No has escogido correctamente");
                    }
                } while (submenu);
            
            // <---------- Transferencias --------------------->

            } else if (opcion == 4) {

                boolean submenu = true;

                DBTransferencia dbTransferencia = new DBTransferencia();

                do {
                    System.out.println("----------\n" + "OpenBank - ¿Que desea realizar?\n" + "----------");
                    System.out.println("[1] - Nueva transferencia");
                    System.out.println("[2] - Consultar una transferencia");
                    System.out.println("[3] - Consultar todas las transferencias");
                    System.out.println("[4] - Eliminar una transferencia");
                    System.out.println("[5] - Volver al menu principal");

                    int opcionSubmenu = lector.nextInt();

                    if (opcionSubmenu == 1) {
                        
                        System.out.println("----------\n" + "[1] - Nueva Transferencia\n" + "----------");
                        System.out.print("Introduce el ID del usuario ordenante: ");
                        int id_ordenante = lector.nextInt();
                        System.out.print("Introduce el ID del usuario beneficiario: ");
                        int id_beneficiario = lector.nextInt();
                        System.out.print("Introduce el importe: $ ");
                        Float importe = lector.nextFloat();
                        System.out.print("Introduce el concepto: ");
                        String concepto = lector.next();

                        System.out.print("Introduce la fecha: ");
                        String fechaComoTexto = lector.next();                        
                        Date fecha = Date.valueOf(fechaComoTexto);
                         
                        // LocalDateTime fecha = java.time.LocalDateTime.now();               

                        Transferencia transferencia = new Transferencia(id_ordenante, id_beneficiario, importe, concepto, fecha);
                        dbTransferencia.insertTransferencia(transferencia);
                        System.out.println("----------\n" + "Transferencia ingresada: " + transferencia + "----------");

                        
                    } else if (opcionSubmenu == 2) {

                        System.out.println("----------\n" + "[2] - Consultar una transferencia\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();

                        dbTransferencia.getTransferencia(id);
                        System.out.println("----------\n" + "Transferencia solicitada: " + "\n" + "----------");

                    } else if (opcionSubmenu == 3) {
                        System.out.println("----------\n" + "[3] - Ver todas las transferencias\n" + "----------");
                        dbTransferencia.getTransferencias();

                    } else if (opcionSubmenu == 4) {
                        System.out.println("----------\n" + "[4] - Eliminar una transferencia\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();

                        dbTransferencia.deleteTransferencia(id);
                        System.out.println("----------\n" + "Transferencia eliminada: " + "" + "----------");

                    } else if (opcionSubmenu == 5) {
                        submenu = false;
                    } else {
                        System.out.println("No has escogido correctamente");
                    }
                } while (submenu);

            // <---------- Mensajes --------------------->

            } else if (opcion == 5) {

                boolean submenu = true;

                DBMensaje dbMensaje = new DBMensaje();

                do {
                    System.out.println("----------\n" + "OpenBank - ¿Que desea realizar?\n" + "----------");
                    System.out.println("[1] - Nuevo mensaje");
                    System.out.println("[2] - Consultar un mensaje");
                    System.out.println("[3] - Consultar todos los mensajes");
                    System.out.println("[4] - Eliminar un mensaje");
                    System.out.println("[5] - Volver al menu principal");

                    int opcionSubmenu = lector.nextInt();

                    if (opcionSubmenu == 1) {
                        
                        System.out.println("----------\n" + "[1] - Nuevo mensaje\n" + "----------");
                        System.out.print("Introduce el ID del usuario que envia: ");
                        int id_origen = lector.nextInt();
                        System.out.print("Introduce el ID del usuario festino: ");
                        int id_destino = lector.nextInt();
                        System.out.print("Introduce el mensaje: ");
                        String texto = lector.next();
                         
                        // System.out.print("Introduce la fecha: ");
                        // String fechaComoTexto = lector.next();                        
                        // Date fecha = Date.valueOf(fechaComoTexto);

                        // java.sql.Date fecha = new java.sql.Date(java.util.Calendar.getTime());
                        java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                         
                        // LocalDateTime fecha = java.time.LocalDateTime.now();               

                        Mensaje mensaje = new Mensaje(id_origen, id_destino, texto, fecha);
                        dbMensaje.insertMensaje(mensaje);
                        System.out.println("----------\n" + "Mensaje ingresado: " + mensaje + "----------");

                        
                    } else if (opcionSubmenu == 2) {

                        System.out.println("----------\n" + "[2] - Consultar un mensaje\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();

                        System.out.println("----------\n" + "Mensaje solicitado: ");
                        dbMensaje.getMensaje(id);
                        System.out.println("----------");

                    } else if (opcionSubmenu == 3) {
                        System.out.println("----------\n" + "[3] - Consultar todos los mensajes\n" + "----------");
                        dbMensaje.getMensajes();
                    } else if (opcionSubmenu == 4) {
                        System.out.println("----------\n" + "[4] - Eliminar un mensaje\n" + "----------");
                        System.out.print("Introduce el id: ");
                        int id = lector.nextInt();

                        dbMensaje.deleteMensaje(id);
                        System.out.println("----------\n" + "Mensaje eliminado: \n" + "----------");

                    } else if (opcionSubmenu == 5) {
                        submenu = false;
                    } else {
                        System.out.println("No has escogido correctamente");
                    }
                } while (submenu);
            } else if (opcion == 6) {
                programaActivo = false;
            } else {
                System.out.println("No has escogido correctamente");
            }

        } while (programaActivo);


    }
}
