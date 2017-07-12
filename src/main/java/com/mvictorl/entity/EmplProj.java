package com.mvictorl.entity;

/**
 * Created by mvictorl on 7/11/17.
 */
public class EmplProj {

    private Long employeeId;
    private Long projectId;

    public EmplProj() { }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplProj emplProj = (EmplProj) o;

        if (getEmployeeId() != null ? !getEmployeeId().equals(emplProj.getEmployeeId()) : emplProj.getEmployeeId() != null)
            return false;
        return getProjectId() != null ? getProjectId().equals(emplProj.getProjectId()) : emplProj.getProjectId() == null;
    }

    @Override
    public int hashCode() {
        int result = getEmployeeId() != null ? getEmployeeId().hashCode() : 0;
        result = 31 * result + (getProjectId() != null ? getProjectId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmplProj{" +
                "employeeId=" + employeeId +
                ", projectId=" + projectId +
                '}';
    }
}
