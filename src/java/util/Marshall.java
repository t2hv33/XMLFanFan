/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author ThanhHV
 */
public class Marshall {

    public static void marshall(String fileName, Object obj) {
        System.out.println("Marshall thành công object -> xml");
        try {
            JAXBContext jaxb = JAXBContext.newInstance(obj.getClass());
            Marshaller mar = jaxb.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            mar.marshal(obj, new File(fileName));

        } catch (JAXBException ex) {
            System.out.println("Chưa tạo thư mục xml trong web");
            ex.printStackTrace();
        }
    }

}
