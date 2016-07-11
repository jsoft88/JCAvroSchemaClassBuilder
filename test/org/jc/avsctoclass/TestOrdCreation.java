/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jc.avsctoclass;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.avro.Schema;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cespedjo
 */
public class TestOrdCreation {
    
    public TestOrdCreation() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void ordClassGeneration() throws IOException, Exception {
        String avroJsonSchema = Files.readAllLines(
                Paths.get("c:\\Downloads\\json_schema.json"), 
                Charset.forName("UTF-8")).get(0);
        
        Schema avroSc = new Schema.Parser().parse(avroJsonSchema);
        ClassFromAvro cfa = new ClassFromAvroFactory().getInstance();
        cfa.init(avroSc, Paths.get("c:\\Downloads"), Paths.get("c:\\Downloads"), "py.net.personal.entity");
        Class clazz = cfa.generateClass(null, null, "{super();}", "public DB_ADMIN_ORD_MODIF(){super();}");
        assertTrue(clazz.getName().equals("py.net.personal.entity.DB_ADMIN_ORD_MODIF"));
    }
}
