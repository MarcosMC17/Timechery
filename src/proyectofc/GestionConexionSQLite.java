package proyectofc;

/*
Uso de SGBD SQLite.
Las bases de datos se guardan en ficheros, por lo que es fácil trasladarla con la aplicación.
Descargar: http://www.sqlite.org/download.html
    Versión windows sqlite-tools-win32-x86-3300100.zip
Ejecutar sqlite3.exe para acceder al shell

(también se requiere descargar el conector JDBC para SQLite)
Descargar: https://bitbucket.org/xerial/sqlite-jdbc/downloads/

(para acceder a la base de datos)
sqlite> .open Alumnos.db

(se puede acceder directamente a la bd al cargar la aplicación desde la línea de comando:)
(c:\sqlite3 c:\...\Alumnos.db)

(****Sentencias sql)
(Si necesitamos campo autonumérico, autoincrement debe ir con primary key)
sqlite> create table Alumno (id integer primary key autoincrement not null, nombre varchar(60), nacimiento date);
(si necesitamos clave primaria doble, ningún campo puede ser autoincrement)
sqlite> create table Alumno (id integer not null, id2 integer not null, nombre varchar(60), nacimiento date, primary key(id,id2));
[NOTA: SQLite guarda los campos fecha como cadena de caracteres]

çsqlite> insert into Alumno values (null, 'Pepe', '2000-01-02');

(para ver las tablas creadas) sqlite> .tables
(para ver la estructura de la tabla) sqlite> .schema tabla
(para salir) sqlite> .exit
 */

import java.sql.*;

public class GestionConexionSQLite {

    String DriverSQLite="jdbc:sqlite:";
    Connection conexion;

    public void ConexionCrear (String RutaDB, String DB) {
        try {
            conexion = DriverManager.getConnection(DriverSQLite + RutaDB + "\\" + DB);
            if (conexion != null) {
                System.out.println("Conexión con la BD correcta.");
            }
        } catch (SQLException esql) {
            esql.printStackTrace();
        }
    }
    public void ConexionCerrar () {
        try {
            conexion.close();
            System.out.println("Desconexión con la BD correcta.");
        } catch (SQLException esqlclose) {
            esqlclose.printStackTrace();
        }
    }

    public ResultSet EjecutarSQL(String CadenaSQL) {
        Statement statconcons = null;
        ResultSet rsESQL = null;
        try {
            statconcons = conexion.createStatement();
            rsESQL = statconcons.executeQuery(CadenaSQL);
            return rsESQL;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void EjecutarActualizacion(String CadenaSQL) {
        Statement statconact = null;
        try {
            statconact = conexion.createStatement();
            statconact.executeUpdate(CadenaSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statconact.close();
            } catch (Exception e) {
            }
        }
    }

    //Constructores
    public GestionConexionSQLite() {
    }
    public GestionConexionSQLite(Connection conexion) {
        this.conexion = conexion;
    }
    public GestionConexionSQLite(String driverSQLite, Connection conexion) {
        DriverSQLite = driverSQLite;
        this.conexion = conexion;
    }

}
