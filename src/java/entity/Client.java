/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utente_javaee7
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByContactEmail", query = "SELECT c FROM Client c WHERE c.contactEmail = :contactEmail"),
    @NamedQuery(name = "Client.findByContactPassword", query = "SELECT c FROM Client c WHERE c.contactPassword = :contactPassword"),
    @NamedQuery(name = "Client.findByClientName", query = "SELECT c FROM Client c WHERE c.clientPK.clientName = :clientName"),
    @NamedQuery(name = "Client.findByClientDepartmentNumber", query = "SELECT c FROM Client c WHERE c.clientPK.clientDepartmentNumber = :clientDepartmentNumber")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientPK clientPK;
    @Size(max = 255)
    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;
    @Size(max = 255)
    @Column(name = "CONTACT_PASSWORD")
    private String contactPassword;
    @OneToMany(mappedBy = "client")
    private List<Recruiter> recruiterList;
    @JoinColumn(name = "BILLING_ADDRESS", referencedColumnName = "ADDRESS_ID")
    @ManyToOne
    private Address billingAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Project> projectList;

    public Client() {
    }

    public Client(ClientPK clientPK) {
        this.clientPK = clientPK;
    }

    public Client(String clientName, short clientDepartmentNumber) {
        this.clientPK = new ClientPK(clientName, clientDepartmentNumber);
    }

    public ClientPK getClientPK() {
        return clientPK;
    }

    public void setClientPK(ClientPK clientPK) {
        this.clientPK = clientPK;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPassword() {
        return contactPassword;
    }

    public void setContactPassword(String contactPassword) {
        this.contactPassword = contactPassword;
    }

    @XmlTransient
    public List<Recruiter> getRecruiterList() {
        return recruiterList;
    }

    public void setRecruiterList(List<Recruiter> recruiterList) {
        this.recruiterList = recruiterList;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @XmlTransient
    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientPK != null ? clientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientPK == null && other.clientPK != null) || (this.clientPK != null && !this.clientPK.equals(other.clientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Client[ clientPK=" + clientPK + " ]";
    }
    
}
