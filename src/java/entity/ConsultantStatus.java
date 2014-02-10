/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utente_javaee7
 */
@Entity
@Table(name = "CONSULTANT_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultantStatus.findAll", query = "SELECT c FROM ConsultantStatus c"),
    @NamedQuery(name = "ConsultantStatus.findByStatusId", query = "SELECT c FROM ConsultantStatus c WHERE c.statusId = :statusId"),
    @NamedQuery(name = "ConsultantStatus.findByDescription", query = "SELECT c FROM ConsultantStatus c WHERE c.description = :description")})
public class ConsultantStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS_ID")
    private String statusId;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "statusId")
    private List<Consultant> consultantList;

    public ConsultantStatus() {
    }

    public ConsultantStatus(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Consultant> getConsultantList() {
        return consultantList;
    }

    public void setConsultantList(List<Consultant> consultantList) {
        this.consultantList = consultantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultantStatus)) {
            return false;
        }
        ConsultantStatus other = (ConsultantStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ConsultantStatus[ statusId=" + statusId + " ]";
    }
    
}
