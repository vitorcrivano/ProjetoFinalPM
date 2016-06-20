/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.List;

/**
 *
 * @author Crivano
 */
public class Resume {
    
    private int participationsAtDoctorship;
    private int participationsAtMasterDegree;
    private int participationsAtFinalGraduationProject;
    private int orientationsAtFinishedDoctorship;
    private int orientationsAtFinishedMasterDegree;
    private int orientationsAtFineshedFinalGraduationProject;
    private int orientationsAtDoctorshipInProgress;
    private int orientationsAtMasterDegreeInProgress;
    private int orientationsAtInProgressFinalGraduationProject;
    
    public Resume(int participationsAtDoctorship, int participationsAtMasterDegree, int participationsAtFinalGraduationProject,
    int orientationsAtFinishedDoctorship, int orientationsAtFinishedMasterDegree, int orientationsAtFineshedFinalGraduationProject,
    int orientationsAtDoctorshipInProgress, int orientationsAtMasterDegreeInProgress, int orientationsAtInProgressFinalGraduationProject) {
        this.participationsAtDoctorship = participationsAtDoctorship;
        this.participationsAtMasterDegree = participationsAtMasterDegree;
        this.participationsAtFinalGraduationProject = participationsAtFinalGraduationProject;
        this.orientationsAtFinishedDoctorship = orientationsAtFinishedDoctorship;
        this.orientationsAtFinishedMasterDegree = orientationsAtFinishedMasterDegree;
        this.orientationsAtFineshedFinalGraduationProject = orientationsAtFineshedFinalGraduationProject;
        this.orientationsAtDoctorshipInProgress = orientationsAtDoctorshipInProgress;
        this.orientationsAtMasterDegreeInProgress = orientationsAtMasterDegreeInProgress;
        this.orientationsAtInProgressFinalGraduationProject = orientationsAtInProgressFinalGraduationProject;
    }
    
    public Resume(){
        this(0,0,0,0,0,0,0,0,0);
    }
    
    public int getParticipationsAtDoctorship() {
        return participationsAtDoctorship;
    }
    
    public void setParticipationsAtDoctorship(int participationsAtDoctorship) {
        this.participationsAtDoctorship = participationsAtDoctorship;
    }

    public int getParticipationsAtMasterDegree(){
        return participationsAtMasterDegree;
    }
    
    public void setParticipationsAtMasterDegree(int participationsAtMasterDegree) {
        this.participationsAtMasterDegree = participationsAtMasterDegree;
    }
    
    public int getParticipationsAtFinalGraduationProject() {
        return participationsAtFinalGraduationProject;
    }
    
    public void setParticipationsAtFinalGraduationProject(int participationsAtFinalGraduationProject){
        this.participationsAtFinalGraduationProject = participationsAtFinalGraduationProject;
    }
    
    public int getOrientationsAtFinishedDoctorship() {
        return orientationsAtFinishedDoctorship;
    }
    
    public void setOrientationsAtFinishedDoctorship(int orientationsAtFinishedDoctorship){
        this.orientationsAtFinishedDoctorship = orientationsAtFinishedDoctorship;
    }
    
    public int getOrientationsAtFinishedMasterDegree() {
        return orientationsAtFinishedMasterDegree;
    }
    
    public void setOrientationsAtFinishedMasterDegree(int orientationsAtFinishedMasterDegree){
        this.orientationsAtFinishedMasterDegree = orientationsAtFinishedMasterDegree;
    }
    
    public int getOrientationsAtFineshedFinalGraduationProject() {
        return orientationsAtFineshedFinalGraduationProject;
    }
    
    public void setOrientationsAtFineshedFinalGraduationProject(int orientationsAtFineshedFinalGraduationProject){
        this.orientationsAtFineshedFinalGraduationProject = orientationsAtFineshedFinalGraduationProject;
    }
    
    public int getOrientationsAtDoctorshipInProgress() {
        return orientationsAtDoctorshipInProgress;
    }
    
    public void setOrientationsAtDoctorshipInProgress(int orientationsAtDoctorshipInProgress){
        this.orientationsAtDoctorshipInProgress = orientationsAtDoctorshipInProgress;
    }
    
    public int getOrientationsAtMasterDegreeInProgress() {
        return orientationsAtMasterDegreeInProgress;
    }
    
    public void setOrientationsAtMasterDegreeInProgress(int orientationsAtMasterDegreeInProgress){
        this.orientationsAtMasterDegreeInProgress = orientationsAtMasterDegreeInProgress;
    }
    
    public int getOrientationsAtInProgressFinalGraduationProject() {
        return orientationsAtInProgressFinalGraduationProject;
    }
    
    public void setOrientationsAtInProgressFinalGraduationProject(int orientationsAtInProgressFinalGraduationProject){
        this.orientationsAtInProgressFinalGraduationProject = orientationsAtInProgressFinalGraduationProject;
    }
    
}
