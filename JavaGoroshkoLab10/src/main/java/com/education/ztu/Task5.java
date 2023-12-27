package com.education.ztu;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Task5 {
    public static void main(String[] args) {
        try {
            Product product = new Product("Laptop", "Dell", 999.99, 5);

            writeToXML(product, "product.xml");

            Product loadedProduct = readFromXML("product.xml");
            System.out.println(loadedProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeToXML(Object object, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, new File(filePath));
    }

    private static <T> T readFromXML(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Product.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new File(filePath));
    }
}