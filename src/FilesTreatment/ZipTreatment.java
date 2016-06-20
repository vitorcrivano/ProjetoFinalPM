/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesTreatment;

import Objects.Program;
import Objects.SearchLine;
import Objects.Teacher;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Crivano
 */
public class ZipTreatment {
    
public void DownloadZipFile(Program program) throws ParserConfigurationException, MalformedURLException, IOException, SAXException{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
    DocumentBuilder dombuilder = factory.newDocumentBuilder();
        
    //Cria link para receber o xml dos curriculos
    String firstSplit = "https://s3.amazonaws.com/posgraduacao/";
    XmlTreatment xmlfile = new XmlTreatment();    
    for(SearchLine line : program.getLinhas()){
        for(Teacher teacher : line.getTeachers()){
            String finalSplit = firstSplit.concat(program.getName()).concat("/").concat(teacher.getCode()).concat(".zip");
            
            URL url = new URL(finalSplit);
            URLConnection con =  url.openConnection();
            
            File file = new File(teacher.getCode()+".zip");
            FileOutputStream fileOut = new FileOutputStream(file);
         
            int aux=0;
         
            do{
                aux=con.getInputStream().read();
                fileOut.write(aux);

            }while(aux !=-1);
               fileOut.close();
               
            System.out.println("Nome" + "    " + "p.Dout" + "    " + "p.Mestr" + " " + "part.Grad"
               + "  " + "o.Dout.c" + "    " + "o.Mestr.c" + "   " + "o.Grad.c" + "    " + "o.Dout.and" 
               + "  " + "o.Mestr.and" + "   " + "o.Grad.and");   
            UnzipFile(file);
            teacher.setResume(xmlfile.BuildResumeByXML());
            System.out.println(teacher.getName() + "    " + teacher.getResume().getParticipationsAtDoctorship() + " " 
               + teacher.getResume().getParticipationsAtMasterDegree() + "  " + teacher.getResume().getParticipationsAtFinalGraduationProject()
               + "  " + teacher.getResume().getOrientationsAtFinishedDoctorship() + "   " + teacher.getResume().getOrientationsAtFinishedMasterDegree()
               + "  " + teacher.getResume().getOrientationsAtFineshedFinalGraduationProject() + "   " + teacher.getResume().getOrientationsAtDoctorshipInProgress() 
               + "  " + teacher.getResume().getOrientationsAtMasterDegreeInProgress() + "   " + teacher.getResume().getOrientationsAtInProgressFinalGraduationProject());              
         }
    System.out.println(line.getName());
    }
}

public File UnzipFile(File zipFile) throws IOException{
    byte[] buffer = new byte[1024];
        
    ZipFile zip = new ZipFile(zipFile);
    ZipEntry entry = zip.getEntry("curriculo.xml");
    File xmlFile = new File(entry.getName());

    InputStream is = zip.getInputStream(entry);
    OutputStream os = new FileOutputStream(xmlFile);
        
    //Escreve o xml no disco
    int bytesLidos = 0;
    while ((bytesLidos = is.read(buffer)) > 0) {
    os.write(buffer, 0, bytesLidos);
    }
        
    is.close();
    os.close();
    zip.close();
        
    //Deleta o arquivo zip
    zipFile.delete();
    return xmlFile;
    }
}
