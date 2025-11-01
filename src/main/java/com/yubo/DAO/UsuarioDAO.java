package com.yubo.DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.yubo.domain.Paciente;
import org.bson.Document;
import com.yubo.util.ConnectionDB;

public class UsuarioDAO {


    public static Paciente buscarPorDato(String nombre, String password) {
        MongoClient con = ConnectionDB.conectar();
        MongoDatabase db = con.getDatabase("centro_medico");
        MongoCollection<Document> col = db.getCollection("pacientes");
        Document doc = col.find(new Document("nombre", nombre)
                .append("password", password)).first();
        Paciente paciente = null;
        if (doc != null) {
            paciente = new Paciente();
            paciente.setIdPaciente(doc.getInteger("idPaciente", 0));
            paciente.setDni(doc.getString("dni"));
            paciente.setNombre(doc.getString("nombre"));
            paciente.setPassword(doc.getString("password"));
            paciente.setDireccion(doc.getString("direccion"));
            paciente.setTelefono(doc.getInteger("telefono", 0));
        }
        con.close();
        return paciente;
    }
}