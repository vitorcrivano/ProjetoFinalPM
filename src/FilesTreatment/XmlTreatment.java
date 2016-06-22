/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilesTreatment;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
    
public void WriteXML(Program program) throws IOException{
    //gravar arquivo no disco
    FileWriter arq = new FileWriter("C:\\"+ program.getName() + ".txt");
    PrintWriter gravarArq = new PrintWriter(arq);
    
    int orientationsAtFineshedFinalGraduationProject = 0;
    int orientationsAtFinishedMasterDegree = 0;
    int orientationsAtFinishedDoctorship = 0;
    int orientationsAtInProgressFinalGraduationProject = 0;
    int orientationsAtMasterDegreeInProgress = 0;
    int orientationsAtDoctorshipInProgress = 0;
    int participationsAtFinalGraduationProject = 0;
    int participationsAtMasterDegree = 0;
    int participationsAtDoctorship = 0;
    
    int orientationsAtFineshedFinalGraduationProjectBySearchLine = 0;
    int orientationsAtFinishedMasterDegreeBySearchLine = 0;
    int orientationsAtFinishedDoctorshipBySearchLine = 0;
    int orientationsAtInProgressFinalGraduationProjectBySearchLine = 0;
    int orientationsAtMasterDegreeInProgressBySearchLine = 0;
    int orientationsAtDoctorshipInProgressBySearchLine = 0;
    int participationsAtFinalGraduationProjectBySearchLine = 0;
    int participationsAtMasterDegreeBySearchLine = 0;
    int participationsAtDoctorshipBySearchLine = 0;
    
    //pega todas as linhas do programa  
    for(SearchLine line : program.getLinhas()){
        //pega todos os professores da linha
        for(Teacher teacher : line.getTeachers()){
            
            orientationsAtFineshedFinalGraduationProject = orientationsAtFineshedFinalGraduationProject + teacher.getResume().getOrientationsAtFineshedFinalGraduationProject();
            orientationsAtFinishedMasterDegree = orientationsAtFinishedMasterDegree + teacher.getResume().getOrientationsAtFinishedMasterDegree();
            orientationsAtFinishedDoctorship = orientationsAtFinishedDoctorship + teacher.getResume().getOrientationsAtFinishedDoctorship();
            orientationsAtInProgressFinalGraduationProject = orientationsAtInProgressFinalGraduationProject + teacher.getResume().getOrientationsAtInProgressFinalGraduationProject();
            orientationsAtMasterDegreeInProgress = orientationsAtMasterDegreeInProgress + teacher.getResume().getOrientationsAtMasterDegreeInProgress();
            orientationsAtDoctorshipInProgress = orientationsAtDoctorshipInProgress + teacher.getResume().getOrientationsAtDoctorshipInProgress();
            participationsAtFinalGraduationProject = participationsAtFinalGraduationProject + teacher.getResume().getParticipationsAtFinalGraduationProject();
            participationsAtMasterDegree = participationsAtMasterDegree + teacher.getResume().getParticipationsAtMasterDegree();
            participationsAtDoctorship = participationsAtDoctorship + teacher.getResume().getParticipationsAtDoctorship();
            
            //imprime professores no txt
            gravarArq.printf("\r\n"+"Nome: "+teacher.getName()); 
            gravarArq.printf("\t"+"Orientações em Projetos Finais Concluídos: "+teacher.getResume().getOrientationsAtFineshedFinalGraduationProject()); 
            gravarArq.printf("\t"+"Orientações em Mestrados Concluídos: "+teacher.getResume().getOrientationsAtFinishedMasterDegree()); 
            gravarArq.printf("\t"+"Orientações em Doutorados Concluídos: "+teacher.getResume().getOrientationsAtFinishedDoctorship());
            gravarArq.printf("\t"+"Orientações em Projetos Finais em Andamento: "+teacher.getResume().getOrientationsAtInProgressFinalGraduationProject()); 
            gravarArq.printf("\t"+"Orientações em Mestrados em Andamento: "+teacher.getResume().getOrientationsAtMasterDegreeInProgress()); 
            gravarArq.printf("\t"+"Orientações em Doutorados em Andamento: "+teacher.getResume().getOrientationsAtDoctorshipInProgress()); 
            gravarArq.printf("\t"+"Participações em Projetos Finais: "+teacher.getResume().getParticipationsAtFinalGraduationProject()); 
            gravarArq.printf("\t"+"Participações em Mestrados: "+teacher.getResume().getParticipationsAtMasterDegree());
            gravarArq.printf("\t"+"Participações em Doutorados: "+teacher.getResume().getParticipationsAtDoctorship());
        }
        orientationsAtFineshedFinalGraduationProjectBySearchLine = orientationsAtFineshedFinalGraduationProjectBySearchLine + orientationsAtFineshedFinalGraduationProject;
        orientationsAtFinishedMasterDegreeBySearchLine = orientationsAtFinishedMasterDegreeBySearchLine + orientationsAtFinishedMasterDegree;
        orientationsAtFinishedDoctorshipBySearchLine = orientationsAtFinishedDoctorshipBySearchLine + orientationsAtFinishedDoctorship;
        orientationsAtInProgressFinalGraduationProjectBySearchLine = orientationsAtInProgressFinalGraduationProjectBySearchLine + orientationsAtInProgressFinalGraduationProject;
        orientationsAtMasterDegreeInProgressBySearchLine = orientationsAtMasterDegreeInProgressBySearchLine + orientationsAtMasterDegreeInProgress;
        orientationsAtDoctorshipInProgressBySearchLine = orientationsAtDoctorshipInProgressBySearchLine + orientationsAtDoctorshipInProgress;
        participationsAtFinalGraduationProjectBySearchLine = participationsAtFinalGraduationProjectBySearchLine + participationsAtFinalGraduationProject;
        participationsAtMasterDegreeBySearchLine = participationsAtMasterDegreeBySearchLine + participationsAtMasterDegree;
        participationsAtDoctorshipBySearchLine = participationsAtDoctorshipBySearchLine + participationsAtDoctorship;
        //imprime linha no txt
        gravarArq.printf("\r\n"+"Linha de pesquisa: "+line.getName());
        gravarArq.printf("\t"+"Orientações em Projetos Finais Concluídos: "+orientationsAtFineshedFinalGraduationProject); 
        gravarArq.printf("\t"+"Orientações em Mestrados Concluídos: "+orientationsAtFinishedMasterDegree); 
        gravarArq.printf("\t"+"Orientações em Doutorados Concluídos: "+orientationsAtFinishedDoctorship);
        gravarArq.printf("\t"+"Orientações em Projetos Finais em Andamento: "+orientationsAtInProgressFinalGraduationProject); 
        gravarArq.printf("\t"+"Orientações em Mestrados em Andamento: "+orientationsAtMasterDegreeInProgress); 
        gravarArq.printf("\t"+"Orientações em Doutorados em Andamento: "+orientationsAtDoctorshipInProgress); 
        gravarArq.printf("\t"+"Participações em Projetos Finais: "+participationsAtFinalGraduationProject); 
        gravarArq.printf("\t"+"Participações em Mestrados: "+participationsAtMasterDegree);
        gravarArq.printf("\t"+"Participações em Doutorados: "+participationsAtDoctorship);
        
        orientationsAtFineshedFinalGraduationProject = 0;
        orientationsAtFinishedMasterDegree = 0;
        orientationsAtFinishedDoctorship = 0;
        orientationsAtInProgressFinalGraduationProject = 0;
        orientationsAtMasterDegreeInProgress = 0;
        orientationsAtDoctorshipInProgress = 0;
        participationsAtFinalGraduationProject = 0;
        participationsAtMasterDegree = 0;
        participationsAtDoctorship = 0;
    }
    //imprime programa no txt
    gravarArq.printf("\r\n"+"Programa: "+program.getName());
    gravarArq.printf("\t"+"Orientações em Projetos Finais Concluídos: "+orientationsAtFineshedFinalGraduationProjectBySearchLine); 
    gravarArq.printf("\t"+"Orientações em Mestrados Concluídos: "+orientationsAtFinishedMasterDegreeBySearchLine); 
    gravarArq.printf("\t"+"Orientações em Doutorados Concluídos: "+orientationsAtFinishedDoctorshipBySearchLine);
    gravarArq.printf("\t"+"Orientações em Projetos Finais em Andamento: "+orientationsAtInProgressFinalGraduationProjectBySearchLine); 
    gravarArq.printf("\t"+"Orientações em Mestrados em Andamento: "+orientationsAtMasterDegreeInProgressBySearchLine); 
    gravarArq.printf("\t"+"Orientações em Doutorados em Andamento: "+orientationsAtDoctorshipInProgressBySearchLine); 
    gravarArq.printf("\t"+"Participações em Projetos Finais: "+participationsAtFinalGraduationProjectBySearchLine); 
    gravarArq.printf("\t"+"Participações em Mestrados: "+participationsAtMasterDegreeBySearchLine);
    gravarArq.printf("\t"+"Participações em Doutorados: "+participationsAtDoctorshipBySearchLine);
    arq.close();
}
    
public void BuildSearchLinesWithTeachersByXML(Program program)throws ParserConfigurationException, SAXException, IOException {
    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        //constroi link pra download  
        String firstSplit = "https://s3.amazonaws.com/posgraduacao/";
        String finalLink = firstSplit.concat(program.getName()).concat("/contents.xml");
        
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse(finalLink);
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        Element rootElement = jdomDocument.getRootElement();
        
        List<Element> searchLineList = rootElement.getChildren();
        
        //pega todas as linhas de pesquisa e preenche a classe SearchLine
        for(int i=0; i < searchLineList.size(); i++) {
            SearchLine searchLine = new SearchLine();
            //seta nome da linha
            searchLine.setName(searchLineList.get(i).getAttributeValue("nome"));
            List<Element> teacherList = searchLineList.get(i).getChildren();
            //pega todos os professores e preenche a classe Teacher
            for(int j=0; j< teacherList.size(); j++){
                Teacher teacher = new Teacher();
                //seta nome e codigo do professor
                teacher.setName(teacherList.get(j).getAttributeValue("nome"));
                teacher.setCode(teacherList.get(j).getAttributeValue("codigo"));
                //adicionar professor na linha
                searchLine.addTeacher(teacher);
            }
            //adiciona linha no programa
            program.addLine(searchLine);
        }
}

        

public Resume BuildResumeByXML() throws ParserConfigurationException, SAXException, IOException{
    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        //pega arquivo xml pra leitura do curriculo
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("curriculo.xml");
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        Element rootElement = jdomDocument.getRootElement();
        
        List<Element> arrayList = rootElement.getChildren();
        Resume resume = new Resume();
        //variaveis que serão incrementadas sempre que valor for obtido
        int orientationsAtFinishedMasterDegree = 0;
        int orientationsAtFinishedDoctorship = 0;
        int orientationsAtFineshedFinalGraduationProject = 0;
        int orientationsAtDoctorshipInProgress = 0;
        int orientationsAtMasterDegreeInProgress = 0;
        int orientationsAtInProgressFinalGraduationProject = 0;
        int participationsAtDoctorship = 0;
        int participationsAtMasterDegree = 0;
        int participationsAtFinalGraduationProject = 0;

        //descascar xml pra pegar os dados
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
        //seta informações pegas no xml pro curriculo do professor
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