/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.api.ErrorListener;
import com.sun.tools.xjc.api.S2JJAXBModel;
import com.sun.tools.xjc.api.SchemaCompiler;
import com.sun.tools.xjc.api.XJC;
import java.io.File;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/**
 *
 * @author ThanhHV
 */
public class UnmarshallingProducts {

    public static void GenerateJavaObj(String packagename, File schema) {
        try {
            String output = "src/java/";
            SchemaCompiler sc = XJC.createSchemaCompiler();
            sc.setErrorListener(new ErrorListener() {

                public void error(SAXParseException saxpe) {
                    System.out.println("Error " + saxpe.getMessage());
                }

                public void fatalError(SAXParseException saxpe) {
                    System.out.println("Fatal " + saxpe.getMessage());
                }

                public void warning(SAXParseException saxpe) {
                    System.out.println("Warning " + saxpe.getMessage());
                }

                public void info(SAXParseException saxpe) {
                    System.out.println("Info " + saxpe.getMessage());
                }
            });
            sc.forcePackageName("generate.jaxb." + packagename);
            InputSource is = new InputSource(schema.toURI().toString());
            sc.parseSchema(is);
            S2JJAXBModel model = sc.bind();
            JCodeModel code = model.generateCode(null, null);
            code.build(new File(output));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//end GenerateJavaObj

    public static void main(String[] args) {
        //Đưa đường dẫn vào từ từ
        File schemaProduct = new File("src/java/schema/Products.xsd");
        GenerateJavaObj("product", schemaProduct);
    }

}
