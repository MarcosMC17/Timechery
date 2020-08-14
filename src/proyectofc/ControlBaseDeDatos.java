/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofc;

import java.io.File;

/**
 *
 * @author Usuario
 */
public class ControlBaseDeDatos {

    private File carpeta;
    private File bd;
    static private String databaseRuta = ".\\data";
    static private String database = "Archery.db";

    public ControlBaseDeDatos() {
        carpeta = new File(".\\data");
        if (!carpeta.exists()) {
            try {
                carpeta.mkdir();
            } catch (Exception e) {
                System.out.println("Error creacion de base de datos");
            }
        }
        bd = new File(".\\data\\Archery.db");
        if (!bd.exists()) {
            try {
                crearBDyTablas();
            } catch (Exception e) {
                System.out.println("Error creacion de base de datos");
            }
        }
    }
    
    public void crearBDyTablas(){
        proyectofc.GestionConexionSQLite consqlite = new proyectofc.GestionConexionSQLite();
        consqlite.ConexionCrear(databaseRuta, database);
        consqlite.EjecutarActualizacion("create table Arqueros (Licencia integer primary key not null, Nombre varchar(60), Apellidos varchar(80), Club varchar(80));");
        consqlite.EjecutarActualizacion("create table Competiciones (IdCompeticion varchar(20) primary key not null, Nombre varchar(60), Club varchar(80), Fecha date, Localizacion varchar(80));");
        consqlite.EjecutarActualizacion("create table Puntuaciones (NParticipacion long primary key not null, Licencia Integer, IdCompeticion varchar(20), Round1 integer, Round2 integer, n10 integer, n9 integer, Categoria varchar(80));");
        consqlite.ConexionCerrar();
    }

}
