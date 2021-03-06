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
import org.xml.sax.SAXException;

/**
 *
 * @author Crivano
 */
public class ZipTreatment {
    
public void AddResumeToTeacherByDownloadingZipFile(Program program) throws ParserConfigurationException, MalformedURLException, IOException, SAXException{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
    DocumentBuilder dombuilder = factory.newDocumentBuilder();
    String txtFile="";  
    //primeira parte do link
    String firstSplit = "https://s3.amazonaws.com/posgraduacao/";
    XmlTreatment xmlfile = new XmlTreatment(); 
    //pega link completo pra cada codigo de cada professor de cada linha
    for(SearchLine line : program.getLinhas()){
        for(Teacher teacher : line.getTeachers()){
            String finalSplit = firstSplit.concat(program.getName()).concat("/").concat(teacher.getCode()).concat(".zip");
            //conexao pra fazer download
            URL url = new URL(finalSplit);
            URLConnection con =  url.openConnection();
            File file = new File(teacher.getCode()+".zip");
            FileOutputStream fileOut = new FileOutputStream(file);
         
            int aux=0;
            //escrita no disco
            do{
                aux=con.getInputStream().read();
                fileOut.write(aux);

            }while(aux !=-1);
               fileOut.close();
            //unzipa arquivo zip    
            UnzipFile(file);
            //seta curriculo dezipado para professor correspondente
            teacher.setResume(xmlfile.BuildResumeByXML());
         }
    }
}

public File UnzipFile(File zipFile) throws IOException{
    byte[] buffer = new byte[1024];
        
    ZipFile zip = new ZipFile(zipFile);
    ZipEntry entry = zip.getEntry("curriculo.xml");
    File xmlFile = new File(entry.getName());

    InputStream is = zip.getInputStream(entry);
    OutputStream os = new FileOutputStream(xmlFile);
    
    //escreve o xml no disco
    int bytesLidos = 0;
    while ((bytesLidos = is.read(buffer)) > 0) {
    os.write(buffer, 0, bytesLidos);
    }
    //fecha as conexões    
    is.close();
    os.close();
    zip.close();
        
    //deleta o zip
    zipFile.delete();
    return xmlFile;
    }
}