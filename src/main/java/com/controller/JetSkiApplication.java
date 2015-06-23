package com.controller;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
public class JetSkiApplication
{
	public String create(JetSki j)
    {
    	String mensagem = "";
    	try
    	{
            MongoClientURI uri  = new MongoClientURI("mongodb://petrovick:senha123@ds043002.mongolab.com:43002/nodepivii");
    		MongoClient mongo = new MongoClient(uri); 
           // MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("nodepivii"); 
	        DBCollection col = db.getCollection("nodepivii");
	        
	        //create user
	        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
	        ObjectId id = new ObjectId();
	        docBuilder.add("_id", id);
	        docBuilder.append("descricao", j.getDescricao());
	        docBuilder.append("hp", j.getHp());
	        docBuilder.append("peso", j.getPeso());
	        
	        DBObject doc = docBuilder.get();
	        WriteResult result = col.insert(doc);
	        System.out.println(result.getUpsertedId());
	        System.out.println(result.getN());
	        System.out.println(result.isUpdateOfExisting());
	        System.out.println(result.getLastConcern());
	        j.set_id(id);
	        mongo.close();
    	}
    	catch(Exception ex)
    	{
    		mensagem = ex.getMessage();
    	}
    	return mensagem;
    }
	
	public List<JetSki> todos() throws Exception
    {
        MongoClientURI uri  = new MongoClientURI("mongodb://petrovick:senha123@ds043002.mongolab.com:43002/nodepivii");
		MongoClient mongo = new MongoClient(uri);
        //MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("nodepivii"); 
        DBCollection col = db.getCollection("nodepivii");
        //read example
        DBCursor cursor = col.find();
        List<JetSki> jetskies = new ArrayList<JetSki>();
        while(cursor.hasNext())
        {
    		Gson gson = new Gson();
    		DBObject current = cursor.next();
    		JetSki j = gson.fromJson(current.toString(), JetSki.class);
            jetskies.add(j);
        }
        //close resources
        mongo.close();
    	return jetskies;
    }
	
	public boolean validar(String descricao, String hp, String peso, StringBuffer mensagem)
	{
		if(descricao == null || descricao.equals("") || descricao.length() < 10)
			mensagem.append("Descrição está vazio ou menor que 10 caracteres.");
		if(hp == null || hp.equals(""))
			mensagem.append("HP está vazio.");
		if(peso == null || peso.equals(""))
			mensagem.append("Peso está vazio.");
		if(hp != null && !hp.matches("-?\\d+(\\.\\d+)?"))
			mensagem.append("HP deve ser um número.");
		if(peso != null && !peso.matches("-?\\d+(\\.\\d+)?"))
			mensagem.append("Peso deve ser um número.");
//		try
//		{
//			Integer.parseInt(hp);
//			Integer.parseInt(peso);
//		}
//		catch(Exception ex)
//		{
//			System.out.println("Entrou no exception do validar!!!" + ex);
//			mensagem.append(ex.getMessage());
//		}
		if(mensagem.toString().isEmpty())
			return true;
		return false;
	}
}

