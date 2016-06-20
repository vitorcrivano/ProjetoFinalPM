/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass;

import FilesTreatment.XmlTreatment;
import FilesTreatment.ZipTreatment;
import Objects.Program;
import Objects.Teacher;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Crivano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        XmlTreatment xmlfile = new XmlTreatment();
        Program program = new Program("PPGI-UNIRIO");
        xmlfile.BuildSearchLinesWithTeachersByXML(program);
        ZipTreatment zipfile = new ZipTreatment();
        xmlfile.WriteXML(zipfile.DownloadZipFile(program),program);
    }
    
}
