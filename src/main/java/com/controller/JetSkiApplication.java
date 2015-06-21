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
	public String Salvar(JetSki j)
	{
		String mensagem = "Salvo!";
		
		return mensagem;
	}
	
	public String create(JetSki j)
    {
    	String mensagem = null;
    	try
    	{
            MongoClientURI uri  = new MongoClientURI("mongodb://petrovick:123@ds043002.mongolab.com:43002/nodepivii"); 
            MongoClient mongo = new MongoClient(uri);
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
	
	public List<JetSki> todos()
    {
    	try
    	{
            MongoClientURI uri  = new MongoClientURI("mongodb://petrovick:123@ds043002.mongolab.com:43002/nodepivii"); 
            MongoClient mongo = new MongoClient(uri);
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
    	catch(Exception ex)
    	{
    		return null;
    	}
    }
}
