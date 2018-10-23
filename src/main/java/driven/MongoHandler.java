/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package driven;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import connect.ConnectFactory;
import connect.MongoData;

/**
 *
 * @author oarcila
 */
public class MongoHandler {

    private DB db;

    public MongoHandler(String key) throws UnknownHostException {
        MongoData data = ConnectFactory.loadConnectionData(key);

        db = ConnectFactory.createConnection(data, true);

    }

    public void insert(BasicDBObject object) {
        DBCollection collection = db.getCollection(object.getClass().getSimpleName());
        try {
            collection.insert(object);
        } catch (MongoException ex) {
        }
    }

    public void update(Class<? extends BasicDBObject> aClass, CriterioActualizacion criterioActualizacion) {
        String cadCriterio = criterioActualizacion.getNombreCriterio();
        String valCriterio = criterioActualizacion.getValorCriterio();
        LinkedList<? extends BasicDBObject> r = (LinkedList<? extends BasicDBObject>) find(aClass, cadCriterio, valCriterio);

        if (r.size() == 1) {
            BasicDBObject e = r.get(0);
            BasicDBObject cp = (BasicDBObject) e.clone();
            String cadAtributo = criterioActualizacion.getNombreAtributo();
            Object valAtributo = criterioActualizacion.getValorAtributo();
            cp.put(cadAtributo, valAtributo);
            cp.markAsPartialObject();

            DBCollection collection = db.getCollection(aClass.getSimpleName());
            collection.update(e, cp);
        }
    }

    public LinkedList<? extends BasicDBObject> findAll(Class<? extends BasicDBObject> clase) {
        LinkedList<BasicDBObject> r = new LinkedList<BasicDBObject>();
        DBCollection collection = db.getCollection(clase.getSimpleName());
        collection.setObjectClass(clase);
        DBCursor cursor = collection.find();
        while (cursor.hasNext()) {
            DBObject objectAux = cursor.next();
            r.add((BasicDBObject) objectAux);
        }
        return r;
    }

    public LinkedList<? extends BasicDBObject> find(Class<? extends BasicDBObject> aClass, String atribute, Object data) {
        LinkedList<BasicDBObject> r = new LinkedList<BasicDBObject>();
        BasicDBObject query = new BasicDBObject(atribute, data);
        DBCollection collection = db.getCollection(aClass.getSimpleName());
        collection.setObjectClass(aClass);
        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            DBObject objectAux = cursor.next();
            r.add((BasicDBObject) objectAux);
        }
        return r;
    }

    public LinkedList<? extends BasicDBObject> find(Class<? extends BasicDBObject> aClass, String atribute, Number min, Number max) {
        LinkedList<BasicDBObject> r = new LinkedList<BasicDBObject>();
        BasicDBObject query = new BasicDBObject(atribute, new BasicDBObject("$gt", min).append("$lte", max));
        DBCollection collection = db.getCollection(aClass.getSimpleName());
        collection.setObjectClass(aClass);
        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            DBObject objectAux = cursor.next();
            r.add((BasicDBObject) objectAux);
        }
        return r;
    }
}
