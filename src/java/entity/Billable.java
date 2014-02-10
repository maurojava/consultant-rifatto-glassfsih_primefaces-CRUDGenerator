/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utente_javaee7
 */
@Entity
@Table(name = "BILLABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billable.findAll", query = "SELECT b FROM Billable b"),
    @NamedQuery(name = "Billable.findByBillableId", query = "SELECT b FROM Billable b WHERE b.billableId = :billableId"),
    @NamedQuery(name = "Billable.findByBillableHourlyRate", query = "SELECT b FROM Billable b WHERE b.billableHourlyRate = :billableHourlyRate"),
    @NamedQuery(name = "Billable.findByDescription", query = "SELECT b FROM Billable b WHERE b.description = :description"),
    @NamedQuery(name = "Billable.findByEndDate", query = "SELECT b FROM Billable b WHERE b.endDate = :endDate"),
    @NamedQuery(name = "Billable.findByHourlyRate", query = "SELECT b FROM Billable b WHERE b.hourlyRate = :hourlyRate"),
    @NamedQuery(name = "Billable.findByHours", query = "SELECT b FROM Billable b WHERE b.hours = :hours"),
    @NamedQuery(name = "Billable.findByStartDate", query = "SELECT b FROM Billable b WHERE b.startDate = :startDate")})
public class Billable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BILLABLE_ID")
    private Long billableId;
    @Lob
    @Column(name = "ARTIFACTS")
    private String artifacts;
    @Column(name = "BILLABLE_HOURLY_RATE")
    private Long billableHourlyRate;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "HOURLY_RATE")
    private Long hourlyRate;
    @Column(name = "HOURS")
    private Short hours;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @JoinColumns({
        @JoinColumn(name = "CLIENT_NAME", referencedColumnName = "CLIENT_NAME"),
        @JoinColumn(name = "CLIENT_DEPARTMENT_NUMBER", referencedColumnName = "CLIENT_DEPARTMENT_NUMBER"),
        @JoinColumn(name = "PROJECT_NAME", referencedColumnName = "PROJECT_NAME")})
    @ManyToOne
    private Project project;
    @JoinColumn(name = "CONSULTANT_ID", referencedColumnName = "CONSULTANT_ID")
    @ManyToOne
    private Consultant consultantId;

    public Billable() {
    }

    public Billable(Long billableId) {
        this.billableId = billableId;
    }

    public Long getBillableId() {
        return billableId;
    }

    public void setBillableId(Long billableId) {
        this.billableId = billableId;
    }

    public String getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(String artifacts) {
        this.artifacts = artifacts;
    }

    public Long getBillableHourlyRate() {
        return billableHourlyRate;
    }

    public void setBillableHourlyRate(Long billableHourlyRate) {
        this.billableHourlyRate = billableHourlyRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Long hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Short getHours() {
        return hours;
    }

    public void setHours(Short hours) {
        this.hours = hours;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Consultant getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Consultant consultantId) {
        this.consultantId = consultantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billableId != null ? billableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billable)) {
            return false;
        }
        Billable other = (Billable) object;
        if ((this.billableId == null && other.billableId != null) || (this.billableId != null && !this.billableId.equals(other.billableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Billable[ billableId=" + billableId + " ]";
    }
    
}
