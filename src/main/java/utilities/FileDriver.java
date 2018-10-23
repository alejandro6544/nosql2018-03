/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import mongotest.app.MongoTest;

/**
 *
 * @author oarcila
 */
public class FileDriver
{
    public static DBObject leerArchivo ( String nomArch)
    {
        String cad_json = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(nomArch));
            String line = null;
            while ((line = br.readLine()) != null)
            {
                cad_json += line;
            }
        } catch (FileNotFoundException ex)
        {
            //Logger.getLogger(MongoTest.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex)
        {
            //Logger.getLogger(MongoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (DBObject)JSON.parse(cad_json);
    }
}
