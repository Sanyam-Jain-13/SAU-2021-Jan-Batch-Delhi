import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ValidInvalid {

    private static Document document;
    private static Document validDocument;
    private static Document invalidDocument;
    private static Element csr_body;



    private static List<Element> createValidInvalid_csr_report(NodeList producerList1, Element valid_csr_body, Element invalid_csr_body){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        Element validLicense, invalidLicense;

        //List 1
        for(int i=0; i<producerList1.getLength(); i++){

            Element currentProducer = (Element) producerList1.item(i);
            Element validProducerEl = validDocument.createElement("CSR_Producer") ;
            Element invalidProducerEl = invalidDocument.createElement("CSR_Producer") ;
            validProducerEl = createElementAttributes(validProducerEl, currentProducer);
            invalidProducerEl = createElementAttributes(invalidProducerEl, currentProducer);

            NodeList listLicenses = currentProducer.getElementsByTagName("License");

            for(int j=0; j < listLicenses.getLength(); j++){

                Element currLicense =(Element) listLicenses.item(j);
                String expireDateStr = currLicense.getAttribute("License_Expiration_Date");

                LocalDate licenseExpirationDate = LocalDate.parse(expireDateStr,dateTimeFormatter);
                boolean valid = today.isBefore(licenseExpirationDate);
//                    System.out.println(valid);

                if(valid){
//                    validLicense = validDocument.createElement("License");
                    validLicense = copyLicense(validDocument, currLicense);
                    validProducerEl.appendChild(validLicense);
                }
                else{
//                    invalidLicense = invalidDocument.createElement("License");
                    invalidLicense = copyLicense(invalidDocument, currLicense);
                    invalidProducerEl.appendChild(invalidLicense);
                }

            }
            valid_csr_body.appendChild(validProducerEl);
            invalid_csr_body.appendChild(invalidProducerEl);
        }

        List<Element> body = new ArrayList<>();
        body.add(valid_csr_body);
        body.add(invalid_csr_body);

        return body;
    }


   private static void createValid(Document doc1, Document doc2) {

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();

            Element sourceHeader = (Element) doc1.getElementsByTagName("CSR_Report_Header").item(0);

            //FOR VALID LICENSE DOCUMENT
            validDocument = documentBuilder.newDocument();
            Element csr_report1 = validDocument.createElement("CSR_Report");
//            validDocument.appendChild(csr_report1);
            Element csr_report_header1 = validDocument.createElement("CSR_Report_Header");
            csr_report_header1 = createElementAttributes(csr_report_header1, sourceHeader);
            csr_report1.appendChild(csr_report_header1);
            Element valid_csr_body = validDocument.createElement("CSR_Report_Body");


            //FOR INVALID LICENSE DOCUMENT
            invalidDocument = documentBuilder.newDocument();
            Element csr_report2 = invalidDocument.createElement("CSR_Report");
//            invalidDocument.appendChild(csr_report2);
            Element csr_report_header2 = invalidDocument.createElement("CSR_Report_Header");
            csr_report_header2 = createElementAttributes(csr_report_header2, sourceHeader);
            csr_report2.appendChild(csr_report_header2);
            Element invalid_csr_body = invalidDocument.createElement("CSR_Report_Body");

            NodeList producerList1 = doc1.getElementsByTagName("CSR_Producer");
            NodeList producerList2 = doc2.getElementsByTagName("CSR_Producer");


            List<Element> body = createValidInvalid_csr_report(producerList1 , valid_csr_body, invalid_csr_body );
            valid_csr_body = body.get(0);
            invalid_csr_body = body.get(1);

            body = createValidInvalid_csr_report(producerList2 , valid_csr_body, invalid_csr_body );
            valid_csr_body = body.get(0);
            invalid_csr_body = body.get(1);


            csr_report1.appendChild(valid_csr_body); // append valid body
            csr_report2.appendChild(invalid_csr_body); // append invalid body

            validDocument.appendChild(csr_report1);
            invalidDocument.appendChild(csr_report2);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            //valid write to file
            DOMSource validSource = new DOMSource(validDocument);
            StreamResult validStream = new StreamResult(new File("src/validLicenses.xml"));
            transformer.transform(validSource, validStream);

            //invalid write to file
            DOMSource invalidSource = new DOMSource(invalidDocument);
            StreamResult invalidStream = new StreamResult(new File("src/invalidLicenses.xml"));
            transformer.transform(invalidSource, invalidStream);

        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

   }

   private static Element createElementAttributes(Element destination, Element source){

       NamedNodeMap sourceAttributes = source.getAttributes();
        for(int i=0; i< sourceAttributes.getLength(); i++){
            destination.setAttribute(sourceAttributes.item(i).getNodeName(), sourceAttributes.item(i).getNodeValue());
        }
        return destination;
   }

   private static Element copyLicense(Document doc, Element sourceLicense){

       Element destLicense= doc.createElement(sourceLicense.getNodeName());
       destLicense = createElementAttributes(destLicense,sourceLicense);

       NodeList Loas = sourceLicense.getElementsByTagName("LOA");
       for(int i=0;i<Loas.getLength();i++)
       {
           Element currLoa=(Element)Loas.item(i);
           Element newLoa = doc.createElement(currLoa.getNodeName());
           newLoa = createElementAttributes(newLoa,currLoa);
           destLicense.appendChild(newLoa);
       }
       return destLicense;

   }


    public static Element matchLicense(NodeList firstNode,NodeList secondNode,String key,String key1,String key2,Element cisr_producer)
    {
        try {
            //System.out.println(firstNode.getLength());
            for(int i=0;i<firstNode.getLength();i++)
            {
                Element firstNodeElement=(Element) firstNode.item(i);
                for(int j=0;j<secondNode.getLength();j++)
                {
                    Element secondNodeElement=(Element) secondNode.item(j);
                    if(firstNodeElement.getAttribute(key).equals(secondNodeElement.getAttribute(key))
                            && firstNodeElement.getAttribute(key1).equals(secondNodeElement.getAttribute(key1))
                            && firstNodeElement.getAttribute(key2).equals(secondNodeElement.getAttribute(key2)))
                    {
                        Element License=document.createElement("License");
                        createElementAttributes(License,firstNodeElement);

                        NodeList Loa=firstNodeElement.getElementsByTagName("LOA");
                        NodeList Loa2=secondNodeElement.getElementsByTagName("LOA");

                        for(int k=0;k<Loa.getLength();k++)
                        {
                            Element newLoa=document.createElement(Loa.item(k).getNodeName());
                            createElementAttributes(newLoa,(Element)Loa.item(k));
                            License.appendChild(newLoa);
                        }
                        for(int k=0;k<Loa2.getLength();k++)
                        {
                            Element newLoa=document.createElement(Loa2.item(k).getNodeName());
                            createElementAttributes(newLoa,(Element)Loa2.item(k));
                            License.appendChild(newLoa);
                        }
                        cisr_producer.appendChild(License);
                    }
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cisr_producer;
    }


    public static void  matchCreateProducer (NodeList first,NodeList second,String Key) {

        NodeList firstLicense, secondLicense;

        for (int i = 0; i < first.getLength(); i++) {

            Element firstElement = (Element) first.item(i);
            for (int j = 0; j < second.getLength(); j++) {

                Element cisr_producer = document.createElement("CISR_PRODUCER");

                Element secondElement = (Element) second.item(j);
                String firstNipr = (firstElement.getAttribute(Key));
                String secondNipr = secondElement.getAttribute(Key);

                if (firstNipr.equals(secondNipr)) {
                    cisr_producer = createElementAttributes(cisr_producer, firstElement);
                    firstLicense = firstElement.getElementsByTagName("License");
                    secondLicense = secondElement.getElementsByTagName("License");
                    cisr_producer = matchLicense(firstLicense, secondLicense , "Date_Status_Effective", "State_Code", "License_Number", cisr_producer);
                    csr_body.appendChild(cisr_producer);
                }
            }
        }
    }


   private static void mergeFiles(Document doc1, Document doc2){

        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            document = documentBuilder.newDocument();
            Element csr_report = document.createElement("CSR_Report");
            document.appendChild(csr_report);
            Element csr_report_header = document.createElement("CSR_Report_Header");

            Element sourceHeader = (Element) doc1.getElementsByTagName("CSR_Report_Header").item(0);
            csr_report_header = createElementAttributes(csr_report_header, sourceHeader);
            csr_report.appendChild(csr_report_header);

            csr_body = document.createElement("CSR_Report_Body");
            csr_report.appendChild(csr_body);

            NodeList producerList1 = doc1.getElementsByTagName("CSR_Producer");
            NodeList producerList2 = doc2.getElementsByTagName("CSR_Producer");

            matchCreateProducer(producerList1, producerList2, "NIPR_Number");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("src/mergedFiles.xml"));
            transformer.transform(domSource, streamResult);

        }
        catch (Exception e){
            e.printStackTrace();
        }
   }


    public static void main(String[] args){

        try
        {
            //Parsing file1 & file2
            File input1 = new File("src/file1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc1 = dBuilder.parse(input1);
            doc1.getDocumentElement().normalize();

            File input2 = new File("src/file2.xml");
//           DocumentBuilderFactory dbFactory2 = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder2 = dbFactory.newDocumentBuilder();
            Document doc2 = dBuilder2.parse(input2);
            doc2.getDocumentElement().normalize();

            createValid(doc1, doc1);

            mergeFiles(doc1, doc2);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
