package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Navegador extends JFrame {

    private JTextField barraDireccion;
    private JEditorPane monitor;

    private JMenuBar barraMenu;

    private JMenu archivo;
    private JMenuItem nuevo;
    private JMenuItem abrir;
    private JMenuItem guardar;
    private JMenuItem guardarComo;
    private JMenuItem configurarPagina;
    private JMenuItem imprimir;
    private JMenuItem salir;

    private JMenu edicion;
    private JMenuItem deshacer;
    private JMenuItem cortar;
    private JMenuItem pegar;
    private JMenuItem copiar;
    private JMenuItem eliminar;
    private JMenuItem buscar;
    private JMenuItem buscarSiguiente;
    private JMenuItem Reemplazar;
    private JMenuItem irA;
    private JMenuItem seleccionarTodo;
    private JMenuItem horaYfecha;

    private JMenu historial;
    private JMenuItem borrarHistorial;
    private JMenuItem mostrarTodoElHistorial;

    private JMenu ver;
    private JMenuItem barraDeHerramientas;
    private JMenuItem barraLateral;
    private JMenuItem pantallaCompleta;

    private JMenu marcadores;
    private JMenuItem mostrarMarcadores;
    private JMenuItem marcarPagina;

    private JMenu herramientas;
    private JMenuItem descargas;
    private JMenuItem complementos;
    private JMenuItem sincronizarAhora;
    private JMenuItem Opciones;


    private JMenu ayuda;
    private JMenuItem verLaAyuda;


    public Navegador() {
        super("Navegador Web");


        barraMenu = new JMenuBar();
        archivo = new JMenu("Archivo");
        nuevo = new JMenuItem("Nuevo");
        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        guardarComo = new JMenuItem("Guardar Como");
        configurarPagina = new JMenuItem("Configurar pagina");
        imprimir = new JMenuItem("Imprimir");
        salir = new JMenuItem("Salir");

        edicion = new JMenu("Editar");
        deshacer = new JMenuItem("Deshacer");
        cortar = new JMenuItem("Corrtar");
        pegar = new JMenuItem("Pegar");
        copiar = new JMenuItem("Copiar");
        eliminar = new JMenuItem("Eliminar");
        buscar = new JMenuItem("Buscar");
        buscarSiguiente = new JMenuItem("Buscar Siguiente");
        Reemplazar = new JMenuItem("Reemplazar");
        irA = new JMenuItem("Ir A");
        seleccionarTodo = new JMenuItem("Seleccionar todo");
        horaYfecha = new JMenuItem("Hora y Fecha");

        ver = new JMenu("Ver");
        barraDeHerramientas = new JMenuItem("Barra de Herramientas");
        barraLateral = new JMenuItem("Barra lateral");
        pantallaCompleta = new JMenuItem("Pantalla Completa");

        historial = new JMenu("Historial");
        mostrarTodoElHistorial = new JMenuItem("Mostrar todo el historial");
        borrarHistorial = new JMenuItem("Borrar el historial reciente");

        marcadores = new JMenu("Marcadores");
        mostrarMarcadores = new JMenuItem("Mostrar marcadores");
        marcarPagina = new JMenuItem("Marcar esta pagina");

        herramientas = new JMenu("Herramientas");
        descargas = new JMenuItem("Descargas");
        complementos = new JMenuItem("Complementos");
        sincronizarAhora = new JMenuItem("Sincronizar ahora");
        Opciones = new JMenuItem("Opciones");

        ayuda = new JMenu("Ayuda");
        verLaAyuda = new JMenuItem("Ver la ayuda");

        setJMenuBar(barraMenu);
        barraMenu.add(archivo);
        archivo.add(nuevo);
        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(guardarComo);
        archivo.add(configurarPagina);
        archivo.add(imprimir);
        archivo.add(salir);

        barraMenu.add(edicion);
        edicion.add(deshacer);
        edicion.add(cortar);
        edicion.add(pegar);
        edicion.add(copiar);
        edicion.add(eliminar);
        edicion.add(buscar);
        edicion.add(buscarSiguiente);
        edicion.add(Reemplazar);
        edicion.add(irA);
        edicion.add(seleccionarTodo);
        edicion.add(horaYfecha);

        barraMenu.add(ver);
        ver.add(barraDeHerramientas);
        ver.add(barraLateral);
        ver.add(pantallaCompleta);

        barraMenu.add(historial);
        historial.add(mostrarTodoElHistorial);
        historial.add(borrarHistorial);

        barraMenu.add(marcadores);
        marcadores.add(mostrarMarcadores);
        marcadores.add(marcarPagina);

        barraMenu.add(herramientas);
        herramientas.add(descargas);
        herramientas.add(complementos);
        herramientas.add(sincronizarAhora);
        herramientas.add(Opciones);

        barraMenu.add(ayuda);
        ayuda.add(verLaAyuda);

        barraDireccion = new JTextField("Ingresa el URL!");
        barraDireccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                errores(event.getActionCommand());

            }
        });

        add(barraDireccion, BorderLayout.NORTH);

        monitor = new JEditorPane();
        monitor.setEditable(false);
        monitor.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent event) {
                if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    errores(event.getURL().toString());
                }
            }
        });
        add(new JScrollPane(monitor), BorderLayout.CENTER);
        setSize(600, 400);
        setVisible(true);
    }

    private void errores(String userText) {
        try {
            monitor.setPage(userText);
            barraDireccion.setText(userText);
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
