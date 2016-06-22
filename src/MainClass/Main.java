package MainClass;

import FilesTreatment.XmlTreatment;
import FilesTreatment.ZipTreatment;
import Objects.Program;
import Objects.Teacher;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main 
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
    {
        XmlTreatment xmlfile = new XmlTreatment();
        Program program = new Program(args[0]);
        xmlfile.BuildSearchLinesWithTeachersByXML(program);
        ZipTreatment zipfile = new ZipTreatment();
        zipfile.AddResumeToTeacherByDownloadingZipFile(program);
        xmlfile.WriteXML(program);
    }
}
