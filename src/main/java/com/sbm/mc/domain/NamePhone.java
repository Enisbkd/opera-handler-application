package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A NamePhone.
 */
@Entity
@Table(name = "name_phone")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class NamePhone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "phone_id")
    private Integer phoneId;

    @Column(name = "name_id")
    private Integer nameId;

    @Column(name = "phone_type")
    private String phoneType;

    @Column(name = "phone_role")
    private String phoneRole;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "inactive_date")
    private LocalDate inactiveDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "primary_yn")
    private String primaryYn;

    @Column(name = "display_seq")
    private Integer displaySeq;

    @Column(name = "laptop_change")
    private Integer laptopChange;

    @Column(name = "index_phone")
    private String indexPhone;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email_format")
    private String emailFormat;

    @Column(name = "share_email_yn")
    private String shareEmailYn;

    @Column(name = "default_confirmation_yn")
    private String defaultConfirmationYn;

    @Column(name = "email_language")
    private String emailLanguage;

    @Column(name = "mobile_audio_key_yn")
    private String mobileAudioKeyYn;

    @Column(name = "country_dialing_code")
    private Integer countryDialingCode;

    @Column(name = "valid_yn")
    private String validYn;

    @Column(name = "phone_country_code")
    private String phoneCountryCode;

    @Column(name = "chain_code")
    private String chainCode;

    @Column(name = "validate_date")
    private LocalDate validateDate;

    @Column(name = "validate_status")
    private String validateStatus;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getId() {
        return this.id;
    }

    public NamePhone id(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhoneId() {
        return this.phoneId;
    }

    public NamePhone phoneId(Integer phoneId) {
        this.setPhoneId(phoneId);
        return this;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Integer getNameId() {
        return this.nameId;
    }

    public NamePhone nameId(Integer nameId) {
        this.setNameId(nameId);
        return this;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public NamePhone phoneType(String phoneType) {
        this.setPhoneType(phoneType);
        return this;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneRole() {
        return this.phoneRole;
    }

    public NamePhone phoneRole(String phoneRole) {
        this.setPhoneRole(phoneRole);
        return this;
    }

    public void setPhoneRole(String phoneRole) {
        this.phoneRole = phoneRole;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public NamePhone phoneNumber(String phoneNumber) {
        this.setPhoneNumber(phoneNumber);
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public NamePhone insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public NamePhone insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public NamePhone updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public NamePhone updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getInactiveDate() {
        return this.inactiveDate;
    }

    public NamePhone inactiveDate(LocalDate inactiveDate) {
        this.setInactiveDate(inactiveDate);
        return this;
    }

    public void setInactiveDate(LocalDate inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public NamePhone endDate(LocalDate endDate) {
        this.setEndDate(endDate);
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getBeginDate() {
        return this.beginDate;
    }

    public NamePhone beginDate(LocalDate beginDate) {
        this.setBeginDate(beginDate);
        return this;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getAddressId() {
        return this.addressId;
    }

    public NamePhone addressId(Integer addressId) {
        this.setAddressId(addressId);
        return this;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getPrimaryYn() {
        return this.primaryYn;
    }

    public NamePhone primaryYn(String primaryYn) {
        this.setPrimaryYn(primaryYn);
        return this;
    }

    public void setPrimaryYn(String primaryYn) {
        this.primaryYn = primaryYn;
    }

    public Integer getDisplaySeq() {
        return this.displaySeq;
    }

    public NamePhone displaySeq(Integer displaySeq) {
        this.setDisplaySeq(displaySeq);
        return this;
    }

    public void setDisplaySeq(Integer displaySeq) {
        this.displaySeq = displaySeq;
    }

    public Integer getLaptopChange() {
        return this.laptopChange;
    }

    public NamePhone laptopChange(Integer laptopChange) {
        this.setLaptopChange(laptopChange);
        return this;
    }

    public void setLaptopChange(Integer laptopChange) {
        this.laptopChange = laptopChange;
    }

    public String getIndexPhone() {
        return this.indexPhone;
    }

    public NamePhone indexPhone(String indexPhone) {
        this.setIndexPhone(indexPhone);
        return this;
    }

    public void setIndexPhone(String indexPhone) {
        this.indexPhone = indexPhone;
    }

    public String getExtension() {
        return this.extension;
    }

    public NamePhone extension(String extension) {
        this.setExtension(extension);
        return this;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmailFormat() {
        return this.emailFormat;
    }

    public NamePhone emailFormat(String emailFormat) {
        this.setEmailFormat(emailFormat);
        return this;
    }

    public void setEmailFormat(String emailFormat) {
        this.emailFormat = emailFormat;
    }

    public String getShareEmailYn() {
        return this.shareEmailYn;
    }

    public NamePhone shareEmailYn(String shareEmailYn) {
        this.setShareEmailYn(shareEmailYn);
        return this;
    }

    public void setShareEmailYn(String shareEmailYn) {
        this.shareEmailYn = shareEmailYn;
    }

    public String getDefaultConfirmationYn() {
        return this.defaultConfirmationYn;
    }

    public NamePhone defaultConfirmationYn(String defaultConfirmationYn) {
        this.setDefaultConfirmationYn(defaultConfirmationYn);
        return this;
    }

    public void setDefaultConfirmationYn(String defaultConfirmationYn) {
        this.defaultConfirmationYn = defaultConfirmationYn;
    }

    public String getEmailLanguage() {
        return this.emailLanguage;
    }

    public NamePhone emailLanguage(String emailLanguage) {
        this.setEmailLanguage(emailLanguage);
        return this;
    }

    public void setEmailLanguage(String emailLanguage) {
        this.emailLanguage = emailLanguage;
    }

    public String getMobileAudioKeyYn() {
        return this.mobileAudioKeyYn;
    }

    public NamePhone mobileAudioKeyYn(String mobileAudioKeyYn) {
        this.setMobileAudioKeyYn(mobileAudioKeyYn);
        return this;
    }

    public void setMobileAudioKeyYn(String mobileAudioKeyYn) {
        this.mobileAudioKeyYn = mobileAudioKeyYn;
    }

    public Integer getCountryDialingCode() {
        return this.countryDialingCode;
    }

    public NamePhone countryDialingCode(Integer countryDialingCode) {
        this.setCountryDialingCode(countryDialingCode);
        return this;
    }

    public void setCountryDialingCode(Integer countryDialingCode) {
        this.countryDialingCode = countryDialingCode;
    }

    public String getValidYn() {
        return this.validYn;
    }

    public NamePhone validYn(String validYn) {
        this.setValidYn(validYn);
        return this;
    }

    public void setValidYn(String validYn) {
        this.validYn = validYn;
    }

    public String getPhoneCountryCode() {
        return this.phoneCountryCode;
    }

    public NamePhone phoneCountryCode(String phoneCountryCode) {
        this.setPhoneCountryCode(phoneCountryCode);
        return this;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public String getChainCode() {
        return this.chainCode;
    }

    public NamePhone chainCode(String chainCode) {
        this.setChainCode(chainCode);
        return this;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public LocalDate getValidateDate() {
        return this.validateDate;
    }

    public NamePhone validateDate(LocalDate validateDate) {
        this.setValidateDate(validateDate);
        return this;
    }

    public void setValidateDate(LocalDate validateDate) {
        this.validateDate = validateDate;
    }

    public String getValidateStatus() {
        return this.validateStatus;
    }

    public NamePhone validateStatus(String validateStatus) {
        this.setValidateStatus(validateStatus);
        return this;
    }

    public void setValidateStatus(String validateStatus) {
        this.validateStatus = validateStatus;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NamePhone)) {
            return false;
        }
        return getId() != null && getId().equals(((NamePhone) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NamePhone{" +
            "id=" + getId() +
            ", phoneId=" + getPhoneId() +
            ", nameId=" + getNameId() +
            ", phoneType='" + getPhoneType() + "'" +
            ", phoneRole='" + getPhoneRole() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", insertDate='" + getInsertDate() + "'" +
            ", insertUser=" + getInsertUser() +
            ", updateDate='" + getUpdateDate() + "'" +
            ", updateUser=" + getUpdateUser() +
            ", inactiveDate='" + getInactiveDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", beginDate='" + getBeginDate() + "'" +
            ", addressId=" + getAddressId() +
            ", primaryYn='" + getPrimaryYn() + "'" +
            ", displaySeq=" + getDisplaySeq() +
            ", laptopChange=" + getLaptopChange() +
            ", indexPhone='" + getIndexPhone() + "'" +
            ", extension='" + getExtension() + "'" +
            ", emailFormat='" + getEmailFormat() + "'" +
            ", shareEmailYn='" + getShareEmailYn() + "'" +
            ", defaultConfirmationYn='" + getDefaultConfirmationYn() + "'" +
            ", emailLanguage='" + getEmailLanguage() + "'" +
            ", mobileAudioKeyYn='" + getMobileAudioKeyYn() + "'" +
            ", countryDialingCode=" + getCountryDialingCode() +
            ", validYn='" + getValidYn() + "'" +
            ", phoneCountryCode='" + getPhoneCountryCode() + "'" +
            ", chainCode='" + getChainCode() + "'" +
            ", validateDate='" + getValidateDate() + "'" +
            ", validateStatus='" + getValidateStatus() + "'" +
            "}";
    }
}
