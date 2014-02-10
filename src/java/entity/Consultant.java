/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utente_javaee7
 */
@Entity
@Table(name = "CONSULTANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultant.findAll", query = "SELECT c FROM Consultant c"),
    @NamedQuery(name = "Consultant.findByConsultantId", query = "SELECT c FROM Consultant c WHERE c.consultantId = :consultantId"),
    @NamedQuery(name = "Consultant.findByBillableHourlyRate", query = "SELECT c FROM Consultant c WHERE c.billableHourlyRate = :billableHourlyRate"),
    @NamedQuery(name = "Consultant.findByEmail", query = "SELECT c FROM Consultant c WHERE c.email = :email"),
    @NamedQuery(name = "Consultant.findByHireDate", query = "SELECT c FROM Consultant c WHERE c.hireDate = :hireDate"),
    @NamedQuery(name = "Consultant.findByHourlyRate", query = "SELECT c FROM Consultant c WHERE c.hourlyRate = :hourlyRate"),
    @NamedQuery(name = "Consultant.findByPassword", query = "SELECT c FROM Consultant c WHERE c.password = :password")})
public class Consultant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CONSULTANT_ID")
    private Integer consultantId;
    @Column(name = "BILLABLE_HOURLY_RATE")
    private Long billableHourlyRate;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Column(name = "HOURLY_RATE")
    private Long hourlyRate;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Lob
    @Column(name = "RESUME")
    private String resume;
    @JoinTable(name = "PROJECT_CONSULTANT", joinColumns = {
        @JoinColumn(name = "CONSULTANT_ID", referencedColumnName = "CONSULTANT_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CLIENT_NAME", referencedColumnName = "CLIENT_NAME"),
        @JoinColumn(name = "CLIENT_DEPARTMENT_NUMBER", referencedColumnName = "CLIENT_DEPARTMENT_NUMBER"),
        @JoinColumn(name = "PROJECT_NAME", referencedColumnName = "PROJECT_NAME")})
    @ManyToMany
    private List<Project> projectList;
    @OneToMany(mappedBy = "consultantId")
    private List<Billable> billableList;
    @JoinColumn(name = "RECRUITER_ID", referencedColumnName = "RECRUITER_ID")
    @ManyToOne
    private Recruiter recruiterId;
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "STATUS_ID")
    @ManyToOne
    private ConsultantStatus statusId;

    public Consultant() {
    }

    public Consultant(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public Integer getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public Long getBillableHourlyRate() {
        return billableHourlyRate;
    }

    public void setBillableHourlyRate(Long billableHourlyRate) {
        this.billableHourlyRate = billableHourlyRate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Long getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Long hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @XmlTransient
    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @XmlTransient
    public List<Billable> getBillableList() {
        return billableList;
    }

    public void setBillableList(List<Billable> billableList) {
        this.billableList = billableList;
    }

    public Recruiter getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(Recruiter recruiterId) {
        this.recruiterId = recruiterId;
    }

    public ConsultantStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(ConsultantStatus statusId) {
        this.statusId = statusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultantId != null ? consultantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultant)) {
            return false;
        }
        Consultant other = (Consultant) object;
        if ((this.consultantId == null && other.consultantId != null) || (this.consultantId != null && !this.consultantId.equals(other.consultantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Consultant[ consultantId=" + consultantId + " ]";
    }
    
}
