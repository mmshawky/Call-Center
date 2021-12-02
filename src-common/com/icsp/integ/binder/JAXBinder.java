/**
 *
 */
package com.icsp.integ.binder;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * @author Mustafa
 *
 */
public class JAXBinder {

	/**
	 * This method for marshal Object to output stream for XML according to JBIX
	 * Binder
	 *
	 * @param classToPound
	 * @param jaxbObject
	 * @return String with xml after parsing
	 * @throws JAXBException
	 */
	public static String marshall(Class<?> classToPound, Object jaxbObject) throws JAXBException {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		marshall(classToPound, jaxbObject, outputStream);
		return outputStream.toString();
	}

	/**
	 * This method for marshall Object to output stream for XML according to
	 * JBIX Binder
	 *
	 * @param factory
	 * @param instance
	 * @param out
	 * @throws JiBXException
	 * @throws JAXBException
	 */
	public static void marshall(Class<?> classToPound, Object jaxbObject, OutputStream out) throws JAXBException {

		JAXBContext jc = JAXBContext.newInstance(classToPound);
		Marshaller mctx = jc.createMarshaller();
		// mctx.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		mctx.marshal(jaxbObject, out);
	}

	/**
	 * This method for marshall Object to output stream for XML according to
	 * JBIX Binder
	 *
	 * @param factory
	 * @param instance
	 * @param out
	 * @throws JiBXException
	 * @throws JAXBException
	 */
	public static void marshall(String packagePath, OutputStream out) throws JAXBException {

		JAXBContext jc = JAXBContext.newInstance(packagePath);
		Marshaller mctx = jc.createMarshaller();
		// mctx.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		mctx.marshal(packagePath, out);
	}

	/**
	 * This method for parse input stream for object according to JBIX Binder
	 *
	 * @param factory
	 * @param in
	 * @return
	 * @throws JiBXException
	 * @throws JAXBException
	 */
	public static Object unmarshall(InputStream in, Class<?>... classToPound) throws JAXBException {

		JAXBContext jc = JAXBContext.newInstance(classToPound);
		Unmarshaller uctx = jc.createUnmarshaller();
		return uctx.unmarshal(in);
	}

	/**
	 * This method for parse input stream for object according to JBIX Binder
	 *
	 * @param factory
	 * @param in
	 * @return
	 * @throws JiBXException
	 * @throws JAXBException
	 */
	public static Object unmarshall(String context, InputStream in) throws JAXBException {

		JAXBContext jc = JAXBContext.newInstance(context);
		Unmarshaller uctx = jc.createUnmarshaller();
		return uctx.unmarshal(in);
	}

	/**
	 *
	 */
	public JAXBinder() {

		super();
	}
}