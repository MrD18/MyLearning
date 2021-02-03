
package com.dhao.webservice.entry.oabo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.dhao.webservice.service.impl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RestoaInfoResponse_QNAME = new QName("http://impl.service.webservice.dhao.com/", "restoaInfoResponse");
    private final static QName _RestoaInfo_QNAME = new QName("http://impl.service.webservice.dhao.com/", "restoaInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dhao.webservice.service.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RestoaInfo }
     * 
     */
    public RestoaInfo createRestoaInfo() {
        return new RestoaInfo();
    }

    /**
     * Create an instance of {@link RestoaInfoResponse }
     * 
     */
    public RestoaInfoResponse createRestoaInfoResponse() {
        return new RestoaInfoResponse();
    }

    /**
     * Create an instance of {@link CreateOASignDTO }
     * 
     */
    public CreateOASignDTO createCreateOASignDTO() {
        return new CreateOASignDTO();
    }

    /**
     * Create an instance of {@link Attachments }
     * 
     */
    public Attachments createAttachments() {
        return new Attachments();
    }

    /**
     * Create an instance of {@link CreateSignSaveDO }
     * 
     */
    public CreateSignSaveDO createCreateSignSaveDO() {
        return new CreateSignSaveDO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestoaInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.webservice.dhao.com/", name = "restoaInfoResponse")
    public JAXBElement<RestoaInfoResponse> createRestoaInfoResponse(RestoaInfoResponse value) {
        return new JAXBElement<RestoaInfoResponse>(_RestoaInfoResponse_QNAME, RestoaInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestoaInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.webservice.dhao.com/", name = "restoaInfo")
    public JAXBElement<RestoaInfo> createRestoaInfo(RestoaInfo value) {
        return new JAXBElement<RestoaInfo>(_RestoaInfo_QNAME, RestoaInfo.class, null, value);
    }

}
