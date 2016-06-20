/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesTreatment;

import Objects.Program;
import Objects.Resume;
import Objects.SearchLine;
import Objects.Teacher;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.Attribute;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Crivano
 */
public class XmlTreatment {
    
public SearchLine BuildSearchLinesWithTeachersByXML(Program program)throws ParserConfigurationException, SAXException, IOException {
    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        
        String firstSplit = "https://s3.amazonaws.com/posgraduacao/";
        String finalLink = firstSplit.concat(program.getName()).concat("/contents.xml");
        
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse(finalLink);
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        Element rootElement = jdomDocument.getRootElement();
        
        List<Element> searchLineList = rootElement.getChildren();
        SearchLine searchLine = new SearchLine();
        //pega todas as linhas de pesquisa e preenche a classe SearchLine
        for(int i=0; i < searchLineList.size(); i++) {
            searchLine.setName(searchLineList.get(i).getAttributeValue("nome"));
            program.addLine(searchLine);
            //System.out.println("Program:" + searchLine.getName() + "\n");
            List<Element> teacherList = searchLineList.get(i).getChildren();
            //pega todos os professores e preenche a classe Teacher
            for(int j=0; j< teacherList.size(); j++){
                Teacher teacher = new Teacher();
                teacher.setName(teacherList.get(j).getAttributeValue("nome"));
                teacher.setCode(teacherList.get(j).getAttributeValue("codigo"));
                searchLine.addTeacher(teacher);
                //System.out.println("Teachers name:" + teacher.getName() + "\n");
            }
        }
        return searchLine; 
}
        

public Resume BuildResumeByXML() throws ParserConfigurationException, SAXException, IOException{
    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("curriculo.xml");
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        Element rootElement = jdomDocument.getRootElement();
        
        List<Element> arrayList = rootElement.getChildren();
        Resume resume = new Resume();
        int orientationsAtFinishedMasterDegree = 0;
        int orientationsAtFinishedDoctorship = 0;
        int orientationsAtFineshedFinalGraduationProject = 0;
        int orientationsAtDoctorshipInProgress = 0;
        int orientationsAtMasterDegreeInProgress = 0;
        int orientationsAtInProgressFinalGraduationProject = 0;
        int participationsAtDoctorship = 0;
        int participationsAtMasterDegree = 0;
        int participationsAtFinalGraduationProject = 0;
        
        for(int i=0; i<arrayList.size(); i++) {
            if(arrayList.get(i).getName().equals("OUTRA-PRODUCAO")) {
                List<Element> orientationsProdList = arrayList.get(i).getChildren();
                for(int j=0; j<orientationsProdList.size(); j++) {
                    if(orientationsProdList.get(j).getName().equals("ORIENTACOES-CONCLUIDAS")) {
                        List<Element> finishedOrientationsList = orientationsProdList.get(j).getChildren();
                        for(int k=0; k<finishedOrientationsList.size(); k++) {
                            if(finishedOrientationsList.get(k).getName().equals("ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")) {
                                List<Element> finishedMasterDegreeOrientationsList = finishedOrientationsList.get(k).getChildren();                            
                                for(int l=0; l<finishedMasterDegreeOrientationsList.size(); l++) {
                                    if(finishedMasterDegreeOrientationsList.get(l).getName().equals("DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")) {
                                        List<Attribute> finishedMasterDegreeOrientationsAttributesList = finishedMasterDegreeOrientationsList.get(l).getAttributes();
                                        for(int m=0; m<finishedMasterDegreeOrientationsAttributesList.size(); m++) {
                                            if(finishedMasterDegreeOrientationsAttributesList.get(m).getName().equals("ANO")){
                                                if(finishedMasterDegreeOrientationsAttributesList.get(m).getValue().equals("2013") ||
                                                finishedMasterDegreeOrientationsAttributesList.get(m).getValue().equals("2014") ||
                                                finishedMasterDegreeOrientationsAttributesList.get(m).getValue().equals("2015")){
                                                    orientationsAtFinishedMasterDegree++;
                                                }
                                            }
                                        }
                                    }        
                                }
                            }                       
                            if(finishedOrientationsList.get(k).getName().equals("ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO")) {
                                List<Element> finishedDoctorShipOrientationsList = finishedOrientationsList.get(k).getChildren();                            
                                for(int l=0; l<finishedDoctorShipOrientationsList.size(); l++) {
                                    if(finishedDoctorShipOrientationsList.get(l).getName().equals("DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")) {
                                        List<Attribute> finishedDoctorShipOrientationsAttributesList = finishedDoctorShipOrientationsList.get(l).getAttributes();
                                        for(int m=0; m<finishedDoctorShipOrientationsAttributesList.size(); m++) {
                                            if(finishedDoctorShipOrientationsAttributesList.get(m).getName().equals("ANO")){
                                                if(finishedDoctorShipOrientationsAttributesList.get(m).getValue().equals("2013") ||
                                                finishedDoctorShipOrientationsAttributesList.get(m).getValue().equals("2014") ||
                                                finishedDoctorShipOrientationsAttributesList.get(m).getValue().equals("2015")){
                                                    orientationsAtFinishedDoctorship++;
                                                }
                                            }
                                        }
                                    }        
                                }
                            }
                            if(finishedOrientationsList.get(k).getName().equals("OUTRAS-ORIENTACOES-CONCLUIDAS")) {
                                List<Element> finishedDifferentOrientationsList = finishedOrientationsList.get(k).getChildren();                            
                                for(int l=0; l<finishedDifferentOrientationsList.size(); l++) {
                                    if(finishedDifferentOrientationsList.get(l).getName().equals("DADOS-BASICOS-DE-OUTRAS-ORIENTACOES-CONCLUIDAS")) {
                                        List<Attribute> finishedDifferentOrientationsAttributesList = finishedDifferentOrientationsList.get(l).getAttributes();
                                        for(int m=0; m<finishedDifferentOrientationsAttributesList.size(); m++) {
                                            if(finishedDifferentOrientationsAttributesList.get(m).getName().equals("ANO")){
                                                if(finishedDifferentOrientationsAttributesList.get(m).getValue().equals("2013") ||
                                                finishedDifferentOrientationsAttributesList.get(m).getValue().equals("2014") ||
                                                finishedDifferentOrientationsAttributesList.get(m).getValue().equals("2015")){
                                                    orientationsAtFineshedFinalGraduationProject++;
                                                }
                                            }
                                        }
                                    }        
                                }
                            }
                        }
                    }
                }
            }
            if(arrayList.get(i).getName().equals("DADOS-COMPLEMENTARES")) {
                List<Element> orientationsCompList = arrayList.get(i).getChildren();
                for(int a=0; a<orientationsCompList.size(); a++) {
                    if(orientationsCompList.get(a).getName().equals("ORIENTACOES-EM-ANDAMENTO")) {
                        List<Element> finishedOrientationsList = orientationsCompList.get(a).getChildren();
                        for(int b=0; b<finishedOrientationsList.size(); b++) {
                            if(finishedOrientationsList.get(b).getName().equals("ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO")) {
                                List<Element> finishedMasterDegreeOrientationsList = finishedOrientationsList.get(b).getChildren();                            
                                for(int c=0; c<finishedMasterDegreeOrientationsList.size(); c++) {
                                    if(finishedMasterDegreeOrientationsList.get(c).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO")) {
                                        List<Attribute> finishedMasterDegreeOrientationsAttributesList = finishedMasterDegreeOrientationsList.get(c).getAttributes();
                                        for(int d=0; d<finishedMasterDegreeOrientationsAttributesList.size(); d++) {
                                            if(finishedMasterDegreeOrientationsAttributesList.get(d).getName().equals("ANO")){
                                                if(finishedMasterDegreeOrientationsAttributesList.get(d).getValue().equals("2013") ||
                                                finishedMasterDegreeOrientationsAttributesList.get(d).getValue().equals("2014") ||
                                                finishedMasterDegreeOrientationsAttributesList.get(d).getValue().equals("2015")){
                                                orientationsAtMasterDegreeInProgress++;
                                                }
                                            }
                                        }
                                    }        
                                }
                            }                       
                            if(finishedOrientationsList.get(b).getName().equals("ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO")) {
                                List<Element> finishedDoctorShipOrientationsList = finishedOrientationsList.get(b).getChildren();                            
                                    for(int c=0; c<finishedDoctorShipOrientationsList.size(); c++) {
                                        if(finishedDoctorShipOrientationsList.get(c).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO")) {
                                            List<Attribute> finishedDoctorShipOrientationsAttributesList = finishedDoctorShipOrientationsList.get(c).getAttributes();
                                            for(int d=0; d<finishedDoctorShipOrientationsAttributesList.size(); d++) {
                                                if(finishedDoctorShipOrientationsAttributesList.get(d).getName().equals("ANO")){
                                                    if(finishedDoctorShipOrientationsAttributesList.get(d).getValue().equals("2013") ||
                                                    finishedDoctorShipOrientationsAttributesList.get(d).getValue().equals("2014") ||
                                                    finishedDoctorShipOrientationsAttributesList.get(d).getValue().equals("2015")){
                                                        orientationsAtDoctorshipInProgress++;
                                                    }
                                                }
                                            }
                                        }        
                                    }
                                }
                            if(finishedOrientationsList.get(b).getName().equals("ORIENTACAO-EM-ANDAMENTO-DE-APERFEICOAMENTO-ESPECIALIZACAO")) {
                                List<Element> finishedDifferentOrientationsList = finishedOrientationsList.get(b).getChildren();                            
                                    for(int c=0; c<finishedDifferentOrientationsList.size(); c++) {
                                        if(finishedDifferentOrientationsList.get(c).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-APERFEICOAMENTO-ESPECIALIZACAO")) {
                                            List<Attribute> finishedDifferentOrientationsAttributesList = finishedDifferentOrientationsList.get(c).getAttributes();
                                            for(int d=0; d<finishedDifferentOrientationsAttributesList.size(); d++) {
                                                if(finishedDifferentOrientationsAttributesList.get(d).getName().equals("ANO")){
                                                    if(finishedDifferentOrientationsAttributesList.get(d).getValue().equals("2013") ||
                                                    finishedDifferentOrientationsAttributesList.get(d).getValue().equals("2014") ||
                                                    finishedDifferentOrientationsAttributesList.get(d).getValue().equals("2015")){
                                                        orientationsAtInProgressFinalGraduationProject++;
                                                    }
                                                }
                                            }
                                        }        
                                    }
                                }
                            }
                        }
                    if(orientationsCompList.get(a).getName().equals("PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO")) {
                        List<Element> finishedOrientationsList = orientationsCompList.get(a).getChildren();
                        for(int b=0; b<finishedOrientationsList.size(); b++) {
                            if(finishedOrientationsList.get(b).getName().equals("PARTICIPACAO-EM-BANCA-DE-MESTRADO")) {
                                List<Element> finishedMasterDegreeOrientationsList = finishedOrientationsList.get(b).getChildren();                            
                                for(int c=0; c<finishedMasterDegreeOrientationsList.size(); c++) {
                                    if(finishedMasterDegreeOrientationsList.get(c).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-MESTRADO")) {
                                        List<Attribute> finishedMasterDegreeOrientationsAttributesList = finishedMasterDegreeOrientationsList.get(c).getAttributes();
                                        for(int d=0; d<finishedMasterDegreeOrientationsAttributesList.size(); d++) {
                                            if(finishedMasterDegreeOrientationsAttributesList.get(d).getName().equals("ANO")){
                                                if(finishedMasterDegreeOrientationsAttributesList.get(d).getValue().equals("2013") ||
                                                finishedMasterDegreeOrientationsAttributesList.get(d).getValue().equals("2014") ||
                                                finishedMasterDegreeOrientationsAttributesList.get(d).getValue().equals("2015")){
                                                participationsAtMasterDegree++;
                                                }
                                            }
                                        }
                                    }        
                                }
                            }                       
                            if(finishedOrientationsList.get(b).getName().equals("PARTICIPACAO-EM-BANCA-DE-DOUTORADO")) {
                                List<Element> finishedDoctorShipOrientationsList = finishedOrientationsList.get(b).getChildren();                            
                                    for(int c=0; c<finishedDoctorShipOrientationsList.size(); c++) {
                                        if(finishedDoctorShipOrientationsList.get(c).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-DOUTORADO")) {
                                            List<Attribute> finishedDoctorShipOrientationsAttributesList = finishedDoctorShipOrientationsList.get(c).getAttributes();
                                            for(int d=0; d<finishedDoctorShipOrientationsAttributesList.size(); d++) {
                                                if(finishedDoctorShipOrientationsAttributesList.get(d).getName().equals("ANO")){
                                                    if(finishedDoctorShipOrientationsAttributesList.get(d).getValue().equals("2013") ||
                                                    finishedDoctorShipOrientationsAttributesList.get(d).getValue().equals("2014") ||
                                                    finishedDoctorShipOrientationsAttributesList.get(d).getValue().equals("2015")){
                                                        participationsAtDoctorship++;
                                                    }
                                                }
                                            }
                                        }        
                                    }
                                }
                            if(finishedOrientationsList.get(b).getName().equals("PARTICIPACAO-EM-BANCA-DE-GRADUACAO")) {
                                List<Element> finishedDifferentOrientationsList = finishedOrientationsList.get(b).getChildren();                            
                                    for(int c=0; c<finishedDifferentOrientationsList.size(); c++) {
                                        if(finishedDifferentOrientationsList.get(c).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-GRADUACAO")) {
                                            List<Attribute> finishedDifferentOrientationsAttributesList = finishedDifferentOrientationsList.get(c).getAttributes();
                                            for(int d=0; d<finishedDifferentOrientationsAttributesList.size(); d++) {
                                                if(finishedDifferentOrientationsAttributesList.get(d).getName().equals("ANO")){
                                                    if(finishedDifferentOrientationsAttributesList.get(d).getValue().equals("2013") ||
                                                    finishedDifferentOrientationsAttributesList.get(d).getValue().equals("2014") ||
                                                    finishedDifferentOrientationsAttributesList.get(d).getValue().equals("2015")){
                                                        participationsAtFinalGraduationProject++;
                                                    }
                                                }
                                            }
                                        }        
                                    }
                                }
                            }
                        }
                    }
                }    
        }
        resume.setOrientationsAtFinishedMasterDegree(orientationsAtFinishedMasterDegree);
        resume.setOrientationsAtFinishedDoctorship(orientationsAtFinishedDoctorship);
        resume.setOrientationsAtFineshedFinalGraduationProject(orientationsAtFineshedFinalGraduationProject);
        resume.setOrientationsAtMasterDegreeInProgress(orientationsAtMasterDegreeInProgress);
        resume.setOrientationsAtDoctorshipInProgress(orientationsAtDoctorshipInProgress);
        resume.setOrientationsAtInProgressFinalGraduationProject(orientationsAtInProgressFinalGraduationProject);
        resume.setParticipationsAtMasterDegree(participationsAtMasterDegree);
        resume.setParticipationsAtDoctorship(participationsAtDoctorship);
        resume.setParticipationsAtFinalGraduationProject(participationsAtFinalGraduationProject);

        return resume;
}

}
