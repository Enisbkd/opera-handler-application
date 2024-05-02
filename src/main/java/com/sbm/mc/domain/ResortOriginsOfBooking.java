package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ResortOriginsOfBooking.
 */
@Entity
@Table(name = "resort_origins_of_booking")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ResortOriginsOfBooking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "resort")
    private String resort;

    @Column(name = "source_code")
    private String sourceCode;

    @Column(name = "parent_source_code")
    private String parentSourceCode;

    @Column(name = "description")
    private String description;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "inactive_date")
    private LocalDate inactiveDate;

    @Column(name = "sell_sequence")
    private Integer sellSequence;

    @Column(name = "sc_orderby")
    private Integer scOrderby;

    @Column(name = "internet_sales_yn")
    private String internetSalesYn;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ResortOriginsOfBooking id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResort() {
        return this.resort;
    }

    public ResortOriginsOfBooking resort(String resort) {
        this.setResort(resort);
        return this;
    }

    public void setResort(String resort) {
        this.resort = resort;
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    public ResortOriginsOfBooking sourceCode(String sourceCode) {
        this.setSourceCode(sourceCode);
        return this;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getParentSourceCode() {
        return this.parentSourceCode;
    }

    public ResortOriginsOfBooking parentSourceCode(String parentSourceCode) {
        this.setParentSourceCode(parentSourceCode);
        return this;
    }

    public void setParentSourceCode(String parentSourceCode) {
        this.parentSourceCode = parentSourceCode;
    }

    public String getDescription() {
        return this.description;
    }

    public ResortOriginsOfBooking description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public ResortOriginsOfBooking insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public ResortOriginsOfBooking insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public ResortOriginsOfBooking updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public ResortOriginsOfBooking updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDate getInactiveDate() {
        return this.inactiveDate;
    }

    public ResortOriginsOfBooking inactiveDate(LocalDate inactiveDate) {
        this.setInactiveDate(inactiveDate);
        return this;
    }

    public void setInactiveDate(LocalDate inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public Integer getSellSequence() {
        return this.sellSequence;
    }

    public ResortOriginsOfBooking sellSequence(Integer sellSequence) {
        this.setSellSequence(sellSequence);
        return this;
    }

    public void setSellSequence(Integer sellSequence) {
        this.sellSequence = sellSequence;
    }

    public Integer getScOrderby() {
        return this.scOrderby;
    }

    public ResortOriginsOfBooking scOrderby(Integer scOrderby) {
        this.setScOrderby(scOrderby);
        return this;
    }

    public void setScOrderby(Integer scOrderby) {
        this.scOrderby = scOrderby;
    }

    public String getInternetSalesYn() {
        return this.internetSalesYn;
    }

    public ResortOriginsOfBooking internetSalesYn(String internetSalesYn) {
        this.setInternetSalesYn(internetSalesYn);
        return this;
    }

    public void setInternetSalesYn(String internetSalesYn) {
        this.internetSalesYn = internetSalesYn;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResortOriginsOfBooking)) {
            return false;
        }
        return getId() != null && getId().equals(((ResortOriginsOfBooking) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ResortOriginsOfBooking{" +
            "id=" + getId() +
            ", resort='" + getResort() + "'" +
            ", sourceCode='" + getSourceCode() + "'" +
            ", parentSourceCode='" + getParentSourceCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", insertUser=" + getInsertUser() +
            ", insertDate='" + getInsertDate() + "'" +
            ", updateUser=" + getUpdateUser() +
            ", updateDate='" + getUpdateDate() + "'" +
            ", inactiveDate='" + getInactiveDate() + "'" +
            ", sellSequence=" + getSellSequence() +
            ", scOrderby=" + getScOrderby() +
            ", internetSalesYn='" + getInternetSalesYn() + "'" +
            "}";
    }
}
