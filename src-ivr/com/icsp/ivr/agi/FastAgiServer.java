package com.icsp.ivr.agi;

import java.io.IOException;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import org.asteriskjava.fastagi.DefaultAgiServer;
import org.asteriskjava.fastagi.internal.AgiConnectionHandler;
import org.asteriskjava.fastagi.internal.FastAgiConnectionHandler;
import org.asteriskjava.util.ServerSocketFacade;
import org.asteriskjava.util.SocketConnectionFacade;
import org.asteriskjava.util.internal.ServerSocketFacadeImpl;

/**
 * <p>
 * Java class for anonymous complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mappingstrategy">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="callflowscript">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="factory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="issherad" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="port" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="poolSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maximumPoolSize" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"mappingstrategy"})
@XmlRootElement(name = "server")
public class FastAgiServer extends DefaultAgiServer {

	@XmlElement(required = true)
	protected XMLMappingStrategy mappingstrategy;
	@XmlAttribute(name = "maximumPoolSize")
	private int maximumPoolSize;
	@XmlAttribute(name = "poolSize")
	private int poolSize;
	@XmlAttribute(name = "port")
	private int port;

	/**
	 *
	 */
	public FastAgiServer() {

		super();
	}

	@Override
	protected ServerSocketFacade createServerSocket() throws IOException {

		return new ServerSocketFacadeImpl(getPort(), 0, null);
	}

	/**
	 * Gets the value of the mappingstrategy property.
	 *
	 * @return possible object is {@link Mappingstrategy }
	 *
	 */
	public XMLMappingStrategy getMappingstrategy() {

		return mappingstrategy;
	}

	/**
	 * Gets the value of the maximumPoolSize property.
	 *
	 * @return possible object is {@link Integer }
	 *
	 */
	public int getMaximumPoolSize() {

		return maximumPoolSize;
	}

	/**
	 * Gets the value of the poolSize property.
	 *
	 * @return possible object is {@link Integer }
	 *
	 */
	public int getPoolSize() {

		return poolSize;
	}

	/**
	 * Gets the value of the port property.
	 *
	 * @return possible object is {@link Integer }
	 *
	 */
	@Override
	public int getPort() {

		return this.port;
	}

	/**
	 * Sets the value of the mappingstrategy property.
	 *
	 * @param value
	 *            allowed object is {@link Mappingstrategy }
	 *
	 */
	public void setMappingstrategy(XMLMappingStrategy value) {

		this.mappingstrategy = value;
	}

	/**
	 * Sets the value of the maximumPoolSize property.
	 *
	 * @param value
	 *            allowed object is {@link Integer }
	 *
	 */
	@Override
	public void setMaximumPoolSize(int maximumPoolSize) {

		this.maximumPoolSize = maximumPoolSize;
	}

	/**
	 * Sets the value of the poolSize property.
	 *
	 * @param value
	 *            allowed object is {@link Integer }
	 *
	 */
	public void setPoolSize(Integer poolSize) {

		this.poolSize = poolSize;
	}

	/**
	 * Sets the value of the port property.
	 *
	 * @param value
	 *            allowed object is {@link Integer }
	 *
	 */
	@Override
	public void setPort(int port) {

		this.port = port;
	}

	@Override
	public void startup() throws IOException, IllegalStateException {

		SocketConnectionFacade socket;
		AgiConnectionHandler connectionHandler;
		ServerSocketFacade serverSocket;
		try {
			serverSocket = createServerSocket();
		} catch (IOException e) {
			// logger.error("Unable start AgiServer: cannot to bind to *:" +
			// port + ".", e);
			System.out.println("Unable start AgiServer: cannot to bind to *:" + port + ".\n" + e);
			throw e;
		}
		// logger.info("Listening on *:" + port + ".");
		System.out.println("Listening on *:" + port + ".");
		// loop will be terminated by accept() throwing an IOException when the
		// ServerSocket is closed.
		while (true) {
			try {
				socket = serverSocket.accept();
				// logger.info("Received connection from " +
				// socket.getRemoteAddress());
				connectionHandler = new FastAgiConnectionHandler(getMappingstrategy(), socket, getAgiChannelFactory());
				execute(connectionHandler);
			} catch (IOException e) {
				e.printStackTrace();
				// swallow only if shutdown
				if (isDie()) {
					break;
				} else {
					handleException("IOException while waiting for connections.", e);
					// handle exception but continue to run
				}
			}
		}
		// logger.info("AgiServer shut down.");
	}
}