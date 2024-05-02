package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A NameAddress.
 */
@Entity
@Table(name = "name_address")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class NameAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "address_3")
    private String address3;

    @Column(name = "address_4")
    private String address4;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "chain_code")
    private String chainCode;

    @Column(name = "city")
    private String city;

    @Column(name = "city_ext")
    private String cityExt;

    @Column(name = "cleansed_datetime")
    private LocalDate cleansedDatetime;

    @Column(name = "cleansed_errormsg")
    private String cleansedErrormsg;

    @Column(name = "cleansed_matchstatus")
    private String cleansedMatchstatus;

    @Column(name = "cleansed_status")
    private String cleansedStatus;

    @Column(name = "cleansed_validationstatus")
    private String cleansedValidationstatus;

    @Column(name = "country")
    private String country;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "foreign_country")
    private String foreignCountry;

    @Column(name = "in_care_of")
    private String inCareOf;

    @Column(name = "inactive_date")
    private LocalDate inactiveDate;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "language_code")
    private String languageCode;

    @Column(name = "laptop_change")
    private Integer laptopChange;

    @Column(name = "last_updated_resort")
    private String lastUpdatedResort;

    @Column(name = "name_id")
    private Integer nameId;

    @Column(name = "primary_yn")
    private String primaryYn;

    @Column(name = "province")
    private String province;

    @Column(name = "state")
    private String state;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "zip_code")
    private String zipCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getId() {
        return this.id;
    }

    public NameAddress id(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddressId() {
        return this.addressId;
    }

    public NameAddress addressId(Integer addressId) {
        this.setAddressId(addressId);
        return this;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressType() {
        return this.addressType;
    }

    public NameAddress addressType(String addressType) {
        this.setAddressType(addressType);
        return this;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress1() {
        return this.address1;
    }

    public NameAddress address1(String address1) {
        this.setAddress1(address1);
        return this;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public NameAddress address2(String address2) {
        this.setAddress2(address2);
        return this;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return this.address3;
    }

    public NameAddress address3(String address3) {
        this.setAddress3(address3);
        return this;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return this.address4;
    }

    public NameAddress address4(String address4) {
        this.setAddress4(address4);
        return this;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public NameAddress barcode(String barcode) {
        this.setBarcode(barcode);
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public LocalDate getBeginDate() {
        return this.beginDate;
    }

    public NameAddress beginDate(LocalDate beginDate) {
        this.setBeginDate(beginDate);
        return this;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public String getChainCode() {
        return this.chainCode;
    }

    public NameAddress chainCode(String chainCode) {
        this.setChainCode(chainCode);
        return this;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getCity() {
        return this.city;
    }

    public NameAddress city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityExt() {
        return this.cityExt;
    }

    public NameAddress cityExt(String cityExt) {
        this.setCityExt(cityExt);
        return this;
    }

    public void setCityExt(String cityExt) {
        this.cityExt = cityExt;
    }

    public LocalDate getCleansedDatetime() {
        return this.cleansedDatetime;
    }

    public NameAddress cleansedDatetime(LocalDate cleansedDatetime) {
        this.setCleansedDatetime(cleansedDatetime);
        return this;
    }

    public void setCleansedDatetime(LocalDate cleansedDatetime) {
        this.cleansedDatetime = cleansedDatetime;
    }

    public String getCleansedErrormsg() {
        return this.cleansedErrormsg;
    }

    public NameAddress cleansedErrormsg(String cleansedErrormsg) {
        this.setCleansedErrormsg(cleansedErrormsg);
        return this;
    }

    public void setCleansedErrormsg(String cleansedErrormsg) {
        this.cleansedErrormsg = cleansedErrormsg;
    }

    public String getCleansedMatchstatus() {
        return this.cleansedMatchstatus;
    }

    public NameAddress cleansedMatchstatus(String cleansedMatchstatus) {
        this.setCleansedMatchstatus(cleansedMatchstatus);
        return this;
    }

    public void setCleansedMatchstatus(String cleansedMatchstatus) {
        this.cleansedMatchstatus = cleansedMatchstatus;
    }

    public String getCleansedStatus() {
        return this.cleansedStatus;
    }

    public NameAddress cleansedStatus(String cleansedStatus) {
        this.setCleansedStatus(cleansedStatus);
        return this;
    }

    public void setCleansedStatus(String cleansedStatus) {
        this.cleansedStatus = cleansedStatus;
    }

    public String getCleansedValidationstatus() {
        return this.cleansedValidationstatus;
    }

    public NameAddress cleansedValidationstatus(String cleansedValidationstatus) {
        this.setCleansedValidationstatus(cleansedValidationstatus);
        return this;
    }

    public void setCleansedValidationstatus(String cleansedValidationstatus) {
        this.cleansedValidationstatus = cleansedValidationstatus;
    }

    public String getCountry() {
        return this.country;
    }

    public NameAddress country(String country) {
        this.setCountry(country);
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public NameAddress endDate(LocalDate endDate) {
        this.setEndDate(endDate);
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getForeignCountry() {
        return this.foreignCountry;
    }

    public NameAddress foreignCountry(String foreignCountry) {
        this.setForeignCountry(foreignCountry);
        return this;
    }

    public void setForeignCountry(String foreignCountry) {
        this.foreignCountry = foreignCountry;
    }

    public String getInCareOf() {
        return this.inCareOf;
    }

    public NameAddress inCareOf(String inCareOf) {
        this.setInCareOf(inCareOf);
        return this;
    }

    public void setInCareOf(String inCareOf) {
        this.inCareOf = inCareOf;
    }

    public LocalDate getInactiveDate() {
        return this.inactiveDate;
    }

    public NameAddress inactiveDate(LocalDate inactiveDate) {
        this.setInactiveDate(inactiveDate);
        return this;
    }

    public void setInactiveDate(LocalDate inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public NameAddress insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public NameAddress insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public NameAddress languageCode(String languageCode) {
        this.setLanguageCode(languageCode);
        return this;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Integer getLaptopChange() {
        return this.laptopChange;
    }

    public NameAddress laptopChange(Integer laptopChange) {
        this.setLaptopChange(laptopChange);
        return this;
    }

    public void setLaptopChange(Integer laptopChange) {
        this.laptopChange = laptopChange;
    }

    public String getLastUpdatedResort() {
        return this.lastUpdatedResort;
    }

    public NameAddress lastUpdatedResort(String lastUpdatedResort) {
        this.setLastUpdatedResort(lastUpdatedResort);
        return this;
    }

    public void setLastUpdatedResort(String lastUpdatedResort) {
        this.lastUpdatedResort = lastUpdatedResort;
    }

    public Integer getNameId() {
        return this.nameId;
    }

    public NameAddress nameId(Integer nameId) {
        this.setNameId(nameId);
        return this;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public String getPrimaryYn() {
        return this.primaryYn;
    }

    public NameAddress primaryYn(String primaryYn) {
        this.setPrimaryYn(primaryYn);
        return this;
    }

    public void setPrimaryYn(String primaryYn) {
        this.primaryYn = primaryYn;
    }

    public String getProvince() {
        return this.province;
    }

    public NameAddress province(String province) {
        this.setProvince(province);
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getState() {
        return this.state;
    }

    public NameAddress state(String state) {
        this.setState(state);
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public NameAddress updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public NameAddress updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public NameAddress zipCode(String zipCode) {
        this.setZipCode(zipCode);
        return this;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NameAddress)) {
            return false;
        }
        return getId() != null && getId().equals(((NameAddress) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NameAddress{" +
            "id=" + getId() +
            ", addressId=" + getAddressId() +
            ", addressType='" + getAddressType() + "'" +
            ", address1='" + getAddress1() + "'" +
            ", address2='" + getAddress2() + "'" +
            ", address3='" + getAddress3() + "'" +
            ", address4='" + getAddress4() + "'" +
            ", barcode='" + getBarcode() + "'" +
            ", beginDate='" + getBeginDate() + "'" +
            ", chainCode='" + getChainCode() + "'" +
            ", city='" + getCity() + "'" +
            ", cityExt='" + getCityExt() + "'" +
            ", cleansedDatetime='" + getCleansedDatetime() + "'" +
            ", cleansedErrormsg='" + getCleansedErrormsg() + "'" +
            ", cleansedMatchstatus='" + getCleansedMatchstatus() + "'" +
            ", cleansedStatus='" + getCleansedStatus() + "'" +
            ", cleansedValidationstatus='" + getCleansedValidationstatus() + "'" +
            ", country='" + getCountry() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", foreignCountry='" + getForeignCountry() + "'" +
            ", inCareOf='" + getInCareOf() + "'" +
            ", inactiveDate='" + getInactiveDate() + "'" +
            ", insertDate='" + getInsertDate() + "'" +
            ", insertUser=" + getInsertUser() +
            ", languageCode='" + getLanguageCode() + "'" +
            ", laptopChange=" + getLaptopChange() +
            ", lastUpdatedResort='" + getLastUpdatedResort() + "'" +
            ", nameId=" + getNameId() +
            ", primaryYn='" + getPrimaryYn() + "'" +
            ", province='" + getProvince() + "'" +
            ", state='" + getState() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", updateUser=" + getUpdateUser() +
            ", zipCode='" + getZipCode() + "'" +
            "}";
    }
}
