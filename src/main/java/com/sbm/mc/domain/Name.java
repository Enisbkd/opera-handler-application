package com.sbm.mc.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Name.
 */
@Entity
@Table(name = "name")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Name implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_id")
    private Integer nameId;

    @Column(name = "name_code")
    private String nameCode;

    @Column(name = "insert_user")
    private Integer insertUser;

    @Column(name = "insert_date")
    private LocalDate insertDate;

    @Column(name = "update_user")
    private Integer updateUser;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "primary_name_id")
    private Integer primaryNameId;

    @Column(name = "repeat_guest_id")
    private String repeatGuestId;

    @Column(name = "mail_list")
    private String mailList;

    @Column(name = "mail_type")
    private String mailType;

    @Column(name = "follow_on")
    private String followOn;

    @Column(name = "business_title")
    private String businessTitle;

    @Column(name = "inactive_date")
    private LocalDate inactiveDate;

    @Column(name = "arc_update_date")
    private LocalDate arcUpdateDate;

    @Column(name = "update_fax_date")
    private LocalDate updateFaxDate;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "collection_user_id")
    private Integer collectionUserId;

    @Column(name = "company")
    private String company;

    @Column(name = "sound_ex_company")
    private String soundExCompany;

    @Column(name = "legal_company")
    private String legalCompany;

    @Column(name = "first")
    private String first;

    @Column(name = "middle")
    private String middle;

    @Column(name = "last")
    private String last;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "title")
    private String title;

    @Column(name = "sound_ex_last")
    private String soundExLast;

    @Column(name = "external_reference_requ")
    private String externalReferenceRequ;

    @Column(name = "vip_status")
    private String vipStatus;

    @Column(name = "vip_authorization")
    private String vipAuthorization;

    @Column(name = "billing_profile_code")
    private String billingProfileCode;

    @Column(name = "rate_structure")
    private String rateStructure;

    @Column(name = "name_comment")
    private String nameComment;

    @Column(name = "tour_operator_type")
    private String tourOperatorType;

    @Column(name = "region")
    private String region;

    @Column(name = "type_of_1099")
    private String typeOf1099;

    @Column(name = "tax_1_no")
    private String tax1No;

    @Column(name = "company_name_id")
    private Integer companyNameId;

    @Column(name = "external_reference_required")
    private String externalReferenceRequired;

    @Column(name = "vendor_id")
    private Integer vendorId;

    @Column(name = "vendor_site_id")
    private Integer vendorSiteId;

    @Column(name = "arc_office_type")
    private String arcOfficeType;

    @Column(name = "tax_2_no")
    private String tax2No;

    @Column(name = "arc_mail_flag")
    private String arcMailFlag;

    @Column(name = "name_2")
    private String name2;

    @Column(name = "name_3")
    private String name3;

    @Column(name = "salesrep")
    private String salesrep;

    @Column(name = "tracecode")
    private String tracecode;

    @Column(name = "geographic_region")
    private String geographicRegion;

    @Column(name = "guest_classification")
    private String guestClassification;

    @Column(name = "primary_address_id")
    private Integer primaryAddressId;

    @Column(name = "primary_phone_id")
    private Integer primaryPhoneId;

    @Column(name = "tax_exempt_status")
    private String taxExemptStatus;

    @Column(name = "gds_name")
    private String gdsName;

    @Column(name = "gds_transaction_no")
    private String gdsTransactionNo;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "language")
    private String language;

    @Column(name = "salutation")
    private String salutation;

    @Column(name = "passport")
    private String passport;

    @Column(name = "history_yn")
    private String historyYn;

    @Column(name = "resv_contact")
    private String resvContact;

    @Column(name = "contract_no")
    private String contractNo;

    @Column(name = "contract_recv_date")
    private LocalDate contractRecvDate;

    @Column(name = "acct_contact")
    private String acctContact;

    @Column(name = "priority")
    private String priority;

    @Column(name = "industry_code")
    private String industryCode;

    @Column(name = "rooms_potential")
    private String roomsPotential;

    @Column(name = "competition_code")
    private String competitionCode;

    @Column(name = "jhi_scope")
    private String scope;

    @Column(name = "scope_city")
    private String scopeCity;

    @Column(name = "territory")
    private String territory;

    @Column(name = "actioncode")
    private String actioncode;

    @Column(name = "active_yn")
    private String activeYn;

    @Column(name = "master_account_yn")
    private String masterAccountYn;

    @Column(name = "name_type")
    private String nameType;

    @Column(name = "sname")
    private String sname;

    @Column(name = "name_tax_type")
    private String nameTaxType;

    @Column(name = "sfirst")
    private String sfirst;

    @Column(name = "ar_no")
    private String arNo;

    @Column(name = "availability_override")
    private String availabilityOverride;

    @Column(name = "billing_code")
    private String billingCode;

    @Column(name = "cash_bl_ind")
    private String cashBlInd;

    @Column(name = "bl_msg")
    private String blMsg;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "commission_code")
    private String commissionCode;

    @Column(name = "hold_code")
    private String holdCode;

    @Column(name = "interest")
    private String interest;

    @Column(name = "summ_ref_cc")
    private String summRefCc;

    @Column(name = "iata_comp_type")
    private String iataCompType;

    @Column(name = "srep_code")
    private String srepCode;

    @Column(name = "accountsource")
    private String accountsource;

    @Column(name = "markets")
    private String markets;

    @Column(name = "product_interest")
    private String productInterest;

    @Column(name = "keyword")
    private String keyword;

    @Column(name = "letter_greeting")
    private String letterGreeting;

    @Column(name = "influence")
    private String influence;

    @Column(name = "dept_id")
    private String deptId;

    @Column(name = "department")
    private String department;

    @Column(name = "contact_yn")
    private String contactYn;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "download_resort")
    private String downloadResort;

    @Column(name = "download_srep")
    private Integer downloadSrep;

    @Column(name = "download_date")
    private LocalDate downloadDate;

    @Column(name = "upload_date")
    private LocalDate uploadDate;

    @Column(name = "laptop_change")
    private Integer laptopChange;

    @Column(name = "crs_nameid")
    private Integer crsNameid;

    @Column(name = "comm_pay_central")
    private String commPayCentral;

    @Column(name = "cc_profile_yn")
    private String ccProfileYn;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "birth_country")
    private String birthCountry;

    @Column(name = "profession")
    private String profession;

    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "id_date")
    private LocalDate idDate;

    @Column(name = "id_place")
    private String idPlace;

    @Column(name = "id_country")
    private String idCountry;

    @Column(name = "udfc_01")
    private String udfc01;

    @Column(name = "udfc_02")
    private String udfc02;

    @Column(name = "udfc_03")
    private String udfc03;

    @Column(name = "udfc_04")
    private String udfc04;

    @Column(name = "udfc_05")
    private String udfc05;

    @Column(name = "udfc_06")
    private String udfc06;

    @Column(name = "udfc_07")
    private String udfc07;

    @Column(name = "udfc_08")
    private String udfc08;

    @Column(name = "udfc_09")
    private String udfc09;

    @Column(name = "udfc_10")
    private String udfc10;

    @Column(name = "udfc_11")
    private String udfc11;

    @Column(name = "udfc_12")
    private String udfc12;

    @Column(name = "udfc_13")
    private String udfc13;

    @Column(name = "udfc_14")
    private String udfc14;

    @Column(name = "udfc_15")
    private String udfc15;

    @Column(name = "udfc_16")
    private String udfc16;

    @Column(name = "udfc_17")
    private String udfc17;

    @Column(name = "udfc_18")
    private String udfc18;

    @Column(name = "udfc_19")
    private String udfc19;

    @Column(name = "udfc_20")
    private String udfc20;

    @Column(name = "udfc_21")
    private String udfc21;

    @Column(name = "udfc_22")
    private String udfc22;

    @Column(name = "udfc_23")
    private String udfc23;

    @Column(name = "udfc_24")
    private String udfc24;

    @Column(name = "udfc_25")
    private String udfc25;

    @Column(name = "udfc_26")
    private String udfc26;

    @Column(name = "udfc_27")
    private String udfc27;

    @Column(name = "udfc_28")
    private String udfc28;

    @Column(name = "udfc_29")
    private String udfc29;

    @Column(name = "udfc_30")
    private String udfc30;

    @Column(name = "udfc_31")
    private String udfc31;

    @Column(name = "udfc_32")
    private String udfc32;

    @Column(name = "udfc_33")
    private String udfc33;

    @Column(name = "udfc_34")
    private String udfc34;

    @Column(name = "udfc_35")
    private String udfc35;

    @Column(name = "udfc_36")
    private String udfc36;

    @Column(name = "udfc_37")
    private String udfc37;

    @Column(name = "udfc_38")
    private String udfc38;

    @Column(name = "udfc_39")
    private String udfc39;

    @Column(name = "udfc_40")
    private String udfc40;

    @Column(name = "udfn_01")
    private Integer udfn01;

    @Column(name = "udfn_02")
    private Integer udfn02;

    @Column(name = "udfn_03")
    private Integer udfn03;

    @Column(name = "udfn_04")
    private Integer udfn04;

    @Column(name = "udfn_05")
    private Integer udfn05;

    @Column(name = "udfn_06")
    private Integer udfn06;

    @Column(name = "udfn_07")
    private Integer udfn07;

    @Column(name = "udfn_08")
    private Integer udfn08;

    @Column(name = "udfn_09")
    private Integer udfn09;

    @Column(name = "udfn_10")
    private Integer udfn10;

    @Column(name = "udfn_11")
    private Integer udfn11;

    @Column(name = "udfn_12")
    private Integer udfn12;

    @Column(name = "udfn_13")
    private Integer udfn13;

    @Column(name = "udfn_14")
    private Integer udfn14;

    @Column(name = "udfn_15")
    private Integer udfn15;

    @Column(name = "udfn_16")
    private Integer udfn16;

    @Column(name = "udfn_17")
    private Integer udfn17;

    @Column(name = "udfn_18")
    private Integer udfn18;

    @Column(name = "udfn_19")
    private Integer udfn19;

    @Column(name = "udfn_20")
    private Integer udfn20;

    @Column(name = "udfn_21")
    private Integer udfn21;

    @Column(name = "udfn_22")
    private Integer udfn22;

    @Column(name = "udfn_23")
    private Integer udfn23;

    @Column(name = "udfn_24")
    private Integer udfn24;

    @Column(name = "udfn_25")
    private Integer udfn25;

    @Column(name = "udfn_26")
    private Integer udfn26;

    @Column(name = "udfn_27")
    private Integer udfn27;

    @Column(name = "udfn_28")
    private Integer udfn28;

    @Column(name = "udfn_29")
    private Integer udfn29;

    @Column(name = "udfn_30")
    private Integer udfn30;

    @Column(name = "udfn_31")
    private Integer udfn31;

    @Column(name = "udfn_32")
    private Integer udfn32;

    @Column(name = "udfn_33")
    private Integer udfn33;

    @Column(name = "udfn_34")
    private Integer udfn34;

    @Column(name = "udfn_35")
    private Integer udfn35;

    @Column(name = "udfn_36")
    private Integer udfn36;

    @Column(name = "udfn_37")
    private Integer udfn37;

    @Column(name = "udfn_38")
    private Integer udfn38;

    @Column(name = "udfn_39")
    private Integer udfn39;

    @Column(name = "udfn_40")
    private Integer udfn40;

    @Column(name = "udfd_01")
    private LocalDate udfd01;

    @Column(name = "udfd_02")
    private LocalDate udfd02;

    @Column(name = "udfd_03")
    private LocalDate udfd03;

    @Column(name = "udfd_04")
    private LocalDate udfd04;

    @Column(name = "udfd_05")
    private LocalDate udfd05;

    @Column(name = "udfd_06")
    private LocalDate udfd06;

    @Column(name = "udfd_07")
    private LocalDate udfd07;

    @Column(name = "udfd_08")
    private LocalDate udfd08;

    @Column(name = "udfd_09")
    private LocalDate udfd09;

    @Column(name = "udfd_10")
    private LocalDate udfd10;

    @Column(name = "udfd_11")
    private LocalDate udfd11;

    @Column(name = "udfd_12")
    private LocalDate udfd12;

    @Column(name = "udfd_13")
    private LocalDate udfd13;

    @Column(name = "udfd_14")
    private LocalDate udfd14;

    @Column(name = "udfd_15")
    private LocalDate udfd15;

    @Column(name = "udfd_16")
    private LocalDate udfd16;

    @Column(name = "udfd_17")
    private LocalDate udfd17;

    @Column(name = "udfd_18")
    private LocalDate udfd18;

    @Column(name = "udfd_19")
    private LocalDate udfd19;

    @Column(name = "udfd_20")
    private LocalDate udfd20;

    @Column(name = "payment_due_days")
    private Integer paymentDueDays;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "guest_priv_yn")
    private String guestPrivYn;

    @Column(name = "email_yn")
    private String emailYn;

    @Column(name = "mail_yn")
    private String mailYn;

    @Column(name = "index_name")
    private String indexName;

    @Column(name = "xlast_name")
    private String xlastName;

    @Column(name = "xfirst_name")
    private String xfirstName;

    @Column(name = "xcompany_name")
    private String xcompanyName;

    @Column(name = "xtitle")
    private String xtitle;

    @Column(name = "xsalutation")
    private String xsalutation;

    @Column(name = "sxname")
    private String sxname;

    @Column(name = "sxfirst_name")
    private String sxfirstName;

    @Column(name = "last_updated_resort")
    private String lastUpdatedResort;

    @Column(name = "envelope_greeting")
    private String envelopeGreeting;

    @Column(name = "xenvelope_greeting")
    private String xenvelopeGreeting;

    @Column(name = "direct_bill_batch_type")
    private String directBillBatchType;

    @Column(name = "resort_registered")
    private String resortRegistered;

    @Column(name = "tax_office")
    private String taxOffice;

    @Column(name = "tax_type")
    private String taxType;

    @Column(name = "tax_category")
    private String taxCategory;

    @Column(name = "preferred_room_no")
    private String preferredRoomNo;

    @Column(name = "phone_yn")
    private String phoneYn;

    @Column(name = "sms_yn")
    private String smsYn;

    @Column(name = "is_protected")
    private String isProtected;

    @Column(name = "xlanguage")
    private String xlanguage;

    @Column(name = "market_research_yn")
    private String marketResearchYn;

    @Column(name = "third_party_yn")
    private String thirdPartyYn;

    @Column(name = "autoenroll_member_yn")
    private String autoenrollMemberYn;

    @Column(name = "chain_code")
    private String chainCode;

    @Column(name = "company_group_id")
    private String companyGroupId;

    @Column(name = "include_in_1099_yn")
    private String includeIn1099Yn;

    @Column(name = "credit_rating")
    private String creditRating;

    @Column(name = "title_suffix")
    private Integer titleSuffix;

    @Column(name = "inactive_reason")
    private String inactiveReason;

    @Column(name = "iata_consortia")
    private String iataConsortia;

    @Column(name = "psuedo_profile_yn")
    private String psuedoProfileYn;

    @Column(name = "profile_privacy_flg")
    private String profilePrivacyFlg;

    @Column(name = "replace_address")
    private String replaceAddress;

    @Column(name = "alien_registration_no")
    private String alienRegistrationNo;

    @Column(name = "immigration_status")
    private String immigrationStatus;

    @Column(name = "visa_validity_type")
    private String visaValidityType;

    @Column(name = "id_document_attach_id")
    private Integer idDocumentAttachId;

    @Column(name = "super_search_index_text")
    private String superSearchIndexText;

    @Column(name = "birth_date_str")
    private String birthDateStr;

    @Column(name = "orig_name_id")
    private Integer origNameId;

    @Column(name = "d_opt_in_mail_list_flg")
    private String dOptInMailListFlg;

    @Column(name = "d_opt_in_market_research_flg")
    private String dOptInMarketResearchFlg;

    @Column(name = "d_opt_in_third_party_flg")
    private String dOptInThirdPartyFlg;

    @Column(name = "d_opt_in_autoenroll_member_flg")
    private String dOptInAutoenrollMemberFlg;

    @Column(name = "d_opt_in_email_flg")
    private String dOptInEmailFlg;

    @Column(name = "d_opt_in_phone_flg")
    private String dOptInPhoneFlg;

    @Column(name = "d_opt_in_sms_flg")
    private String dOptInSmsFlg;

    @Column(name = "d_opt_in_guest_priv_flg")
    private String dOptInGuestPrivFlg;

    @Column(name = "ar_credit_limit_yn")
    private String arCreditLimitYn;

    @Column(name = "profile_credit_limit")
    private Integer profileCreditLimit;

    @Column(name = "xmiddle_name")
    private String xmiddleName;

    @Column(name = "e_invoice_liable_yn")
    private String eInvoiceLiableYn;

    @Column(name = "e_inv_liable_last_updated")
    private LocalDate eInvLiableLastUpdated;

    @Column(name = "internal_bill_yn")
    private String internalBillYn;

    @Column(name = "comp_pre_approval_required_yn")
    private String compPreApprovalRequiredYn;

    @Column(name = "anonymization_status")
    private String anonymizationStatus;

    @Column(name = "anonymization_date")
    private LocalDate anonymizationDate;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Integer getId() {
        return this.id;
    }

    public Name id(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNameId() {
        return this.nameId;
    }

    public Name nameId(Integer nameId) {
        this.setNameId(nameId);
        return this;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public String getNameCode() {
        return this.nameCode;
    }

    public Name nameCode(String nameCode) {
        this.setNameCode(nameCode);
        return this;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }

    public Integer getInsertUser() {
        return this.insertUser;
    }

    public Name insertUser(Integer insertUser) {
        this.setInsertUser(insertUser);
        return this;
    }

    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    public LocalDate getInsertDate() {
        return this.insertDate;
    }

    public Name insertDate(LocalDate insertDate) {
        this.setInsertDate(insertDate);
        return this;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getUpdateUser() {
        return this.updateUser;
    }

    public Name updateUser(Integer updateUser) {
        this.setUpdateUser(updateUser);
        return this;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDate getUpdateDate() {
        return this.updateDate;
    }

    public Name updateDate(LocalDate updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getPrimaryNameId() {
        return this.primaryNameId;
    }

    public Name primaryNameId(Integer primaryNameId) {
        this.setPrimaryNameId(primaryNameId);
        return this;
    }

    public void setPrimaryNameId(Integer primaryNameId) {
        this.primaryNameId = primaryNameId;
    }

    public String getRepeatGuestId() {
        return this.repeatGuestId;
    }

    public Name repeatGuestId(String repeatGuestId) {
        this.setRepeatGuestId(repeatGuestId);
        return this;
    }

    public void setRepeatGuestId(String repeatGuestId) {
        this.repeatGuestId = repeatGuestId;
    }

    public String getMailList() {
        return this.mailList;
    }

    public Name mailList(String mailList) {
        this.setMailList(mailList);
        return this;
    }

    public void setMailList(String mailList) {
        this.mailList = mailList;
    }

    public String getMailType() {
        return this.mailType;
    }

    public Name mailType(String mailType) {
        this.setMailType(mailType);
        return this;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getFollowOn() {
        return this.followOn;
    }

    public Name followOn(String followOn) {
        this.setFollowOn(followOn);
        return this;
    }

    public void setFollowOn(String followOn) {
        this.followOn = followOn;
    }

    public String getBusinessTitle() {
        return this.businessTitle;
    }

    public Name businessTitle(String businessTitle) {
        this.setBusinessTitle(businessTitle);
        return this;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public LocalDate getInactiveDate() {
        return this.inactiveDate;
    }

    public Name inactiveDate(LocalDate inactiveDate) {
        this.setInactiveDate(inactiveDate);
        return this;
    }

    public void setInactiveDate(LocalDate inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public LocalDate getArcUpdateDate() {
        return this.arcUpdateDate;
    }

    public Name arcUpdateDate(LocalDate arcUpdateDate) {
        this.setArcUpdateDate(arcUpdateDate);
        return this;
    }

    public void setArcUpdateDate(LocalDate arcUpdateDate) {
        this.arcUpdateDate = arcUpdateDate;
    }

    public LocalDate getUpdateFaxDate() {
        return this.updateFaxDate;
    }

    public Name updateFaxDate(LocalDate updateFaxDate) {
        this.setUpdateFaxDate(updateFaxDate);
        return this;
    }

    public void setUpdateFaxDate(LocalDate updateFaxDate) {
        this.updateFaxDate = updateFaxDate;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public Name birthDate(LocalDate birthDate) {
        this.setBirthDate(birthDate);
        return this;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getCollectionUserId() {
        return this.collectionUserId;
    }

    public Name collectionUserId(Integer collectionUserId) {
        this.setCollectionUserId(collectionUserId);
        return this;
    }

    public void setCollectionUserId(Integer collectionUserId) {
        this.collectionUserId = collectionUserId;
    }

    public String getCompany() {
        return this.company;
    }

    public Name company(String company) {
        this.setCompany(company);
        return this;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSoundExCompany() {
        return this.soundExCompany;
    }

    public Name soundExCompany(String soundExCompany) {
        this.setSoundExCompany(soundExCompany);
        return this;
    }

    public void setSoundExCompany(String soundExCompany) {
        this.soundExCompany = soundExCompany;
    }

    public String getLegalCompany() {
        return this.legalCompany;
    }

    public Name legalCompany(String legalCompany) {
        this.setLegalCompany(legalCompany);
        return this;
    }

    public void setLegalCompany(String legalCompany) {
        this.legalCompany = legalCompany;
    }

    public String getFirst() {
        return this.first;
    }

    public Name first(String first) {
        this.setFirst(first);
        return this;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return this.middle;
    }

    public Name middle(String middle) {
        this.setMiddle(middle);
        return this;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return this.last;
    }

    public Name last(String last) {
        this.setLast(last);
        return this;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Name nickname(String nickname) {
        this.setNickname(nickname);
        return this;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return this.title;
    }

    public Name title(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSoundExLast() {
        return this.soundExLast;
    }

    public Name soundExLast(String soundExLast) {
        this.setSoundExLast(soundExLast);
        return this;
    }

    public void setSoundExLast(String soundExLast) {
        this.soundExLast = soundExLast;
    }

    public String getExternalReferenceRequ() {
        return this.externalReferenceRequ;
    }

    public Name externalReferenceRequ(String externalReferenceRequ) {
        this.setExternalReferenceRequ(externalReferenceRequ);
        return this;
    }

    public void setExternalReferenceRequ(String externalReferenceRequ) {
        this.externalReferenceRequ = externalReferenceRequ;
    }

    public String getVipStatus() {
        return this.vipStatus;
    }

    public Name vipStatus(String vipStatus) {
        this.setVipStatus(vipStatus);
        return this;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

    public String getVipAuthorization() {
        return this.vipAuthorization;
    }

    public Name vipAuthorization(String vipAuthorization) {
        this.setVipAuthorization(vipAuthorization);
        return this;
    }

    public void setVipAuthorization(String vipAuthorization) {
        this.vipAuthorization = vipAuthorization;
    }

    public String getBillingProfileCode() {
        return this.billingProfileCode;
    }

    public Name billingProfileCode(String billingProfileCode) {
        this.setBillingProfileCode(billingProfileCode);
        return this;
    }

    public void setBillingProfileCode(String billingProfileCode) {
        this.billingProfileCode = billingProfileCode;
    }

    public String getRateStructure() {
        return this.rateStructure;
    }

    public Name rateStructure(String rateStructure) {
        this.setRateStructure(rateStructure);
        return this;
    }

    public void setRateStructure(String rateStructure) {
        this.rateStructure = rateStructure;
    }

    public String getNameComment() {
        return this.nameComment;
    }

    public Name nameComment(String nameComment) {
        this.setNameComment(nameComment);
        return this;
    }

    public void setNameComment(String nameComment) {
        this.nameComment = nameComment;
    }

    public String getTourOperatorType() {
        return this.tourOperatorType;
    }

    public Name tourOperatorType(String tourOperatorType) {
        this.setTourOperatorType(tourOperatorType);
        return this;
    }

    public void setTourOperatorType(String tourOperatorType) {
        this.tourOperatorType = tourOperatorType;
    }

    public String getRegion() {
        return this.region;
    }

    public Name region(String region) {
        this.setRegion(region);
        return this;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTypeOf1099() {
        return this.typeOf1099;
    }

    public Name typeOf1099(String typeOf1099) {
        this.setTypeOf1099(typeOf1099);
        return this;
    }

    public void setTypeOf1099(String typeOf1099) {
        this.typeOf1099 = typeOf1099;
    }

    public String getTax1No() {
        return this.tax1No;
    }

    public Name tax1No(String tax1No) {
        this.setTax1No(tax1No);
        return this;
    }

    public void setTax1No(String tax1No) {
        this.tax1No = tax1No;
    }

    public Integer getCompanyNameId() {
        return this.companyNameId;
    }

    public Name companyNameId(Integer companyNameId) {
        this.setCompanyNameId(companyNameId);
        return this;
    }

    public void setCompanyNameId(Integer companyNameId) {
        this.companyNameId = companyNameId;
    }

    public String getExternalReferenceRequired() {
        return this.externalReferenceRequired;
    }

    public Name externalReferenceRequired(String externalReferenceRequired) {
        this.setExternalReferenceRequired(externalReferenceRequired);
        return this;
    }

    public void setExternalReferenceRequired(String externalReferenceRequired) {
        this.externalReferenceRequired = externalReferenceRequired;
    }

    public Integer getVendorId() {
        return this.vendorId;
    }

    public Name vendorId(Integer vendorId) {
        this.setVendorId(vendorId);
        return this;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getVendorSiteId() {
        return this.vendorSiteId;
    }

    public Name vendorSiteId(Integer vendorSiteId) {
        this.setVendorSiteId(vendorSiteId);
        return this;
    }

    public void setVendorSiteId(Integer vendorSiteId) {
        this.vendorSiteId = vendorSiteId;
    }

    public String getArcOfficeType() {
        return this.arcOfficeType;
    }

    public Name arcOfficeType(String arcOfficeType) {
        this.setArcOfficeType(arcOfficeType);
        return this;
    }

    public void setArcOfficeType(String arcOfficeType) {
        this.arcOfficeType = arcOfficeType;
    }

    public String getTax2No() {
        return this.tax2No;
    }

    public Name tax2No(String tax2No) {
        this.setTax2No(tax2No);
        return this;
    }

    public void setTax2No(String tax2No) {
        this.tax2No = tax2No;
    }

    public String getArcMailFlag() {
        return this.arcMailFlag;
    }

    public Name arcMailFlag(String arcMailFlag) {
        this.setArcMailFlag(arcMailFlag);
        return this;
    }

    public void setArcMailFlag(String arcMailFlag) {
        this.arcMailFlag = arcMailFlag;
    }

    public String getName2() {
        return this.name2;
    }

    public Name name2(String name2) {
        this.setName2(name2);
        return this;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return this.name3;
    }

    public Name name3(String name3) {
        this.setName3(name3);
        return this;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getSalesrep() {
        return this.salesrep;
    }

    public Name salesrep(String salesrep) {
        this.setSalesrep(salesrep);
        return this;
    }

    public void setSalesrep(String salesrep) {
        this.salesrep = salesrep;
    }

    public String getTracecode() {
        return this.tracecode;
    }

    public Name tracecode(String tracecode) {
        this.setTracecode(tracecode);
        return this;
    }

    public void setTracecode(String tracecode) {
        this.tracecode = tracecode;
    }

    public String getGeographicRegion() {
        return this.geographicRegion;
    }

    public Name geographicRegion(String geographicRegion) {
        this.setGeographicRegion(geographicRegion);
        return this;
    }

    public void setGeographicRegion(String geographicRegion) {
        this.geographicRegion = geographicRegion;
    }

    public String getGuestClassification() {
        return this.guestClassification;
    }

    public Name guestClassification(String guestClassification) {
        this.setGuestClassification(guestClassification);
        return this;
    }

    public void setGuestClassification(String guestClassification) {
        this.guestClassification = guestClassification;
    }

    public Integer getPrimaryAddressId() {
        return this.primaryAddressId;
    }

    public Name primaryAddressId(Integer primaryAddressId) {
        this.setPrimaryAddressId(primaryAddressId);
        return this;
    }

    public void setPrimaryAddressId(Integer primaryAddressId) {
        this.primaryAddressId = primaryAddressId;
    }

    public Integer getPrimaryPhoneId() {
        return this.primaryPhoneId;
    }

    public Name primaryPhoneId(Integer primaryPhoneId) {
        this.setPrimaryPhoneId(primaryPhoneId);
        return this;
    }

    public void setPrimaryPhoneId(Integer primaryPhoneId) {
        this.primaryPhoneId = primaryPhoneId;
    }

    public String getTaxExemptStatus() {
        return this.taxExemptStatus;
    }

    public Name taxExemptStatus(String taxExemptStatus) {
        this.setTaxExemptStatus(taxExemptStatus);
        return this;
    }

    public void setTaxExemptStatus(String taxExemptStatus) {
        this.taxExemptStatus = taxExemptStatus;
    }

    public String getGdsName() {
        return this.gdsName;
    }

    public Name gdsName(String gdsName) {
        this.setGdsName(gdsName);
        return this;
    }

    public void setGdsName(String gdsName) {
        this.gdsName = gdsName;
    }

    public String getGdsTransactionNo() {
        return this.gdsTransactionNo;
    }

    public Name gdsTransactionNo(String gdsTransactionNo) {
        this.setGdsTransactionNo(gdsTransactionNo);
        return this;
    }

    public void setGdsTransactionNo(String gdsTransactionNo) {
        this.gdsTransactionNo = gdsTransactionNo;
    }

    public String getNationality() {
        return this.nationality;
    }

    public Name nationality(String nationality) {
        this.setNationality(nationality);
        return this;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLanguage() {
        return this.language;
    }

    public Name language(String language) {
        this.setLanguage(language);
        return this;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSalutation() {
        return this.salutation;
    }

    public Name salutation(String salutation) {
        this.setSalutation(salutation);
        return this;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getPassport() {
        return this.passport;
    }

    public Name passport(String passport) {
        this.setPassport(passport);
        return this;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getHistoryYn() {
        return this.historyYn;
    }

    public Name historyYn(String historyYn) {
        this.setHistoryYn(historyYn);
        return this;
    }

    public void setHistoryYn(String historyYn) {
        this.historyYn = historyYn;
    }

    public String getResvContact() {
        return this.resvContact;
    }

    public Name resvContact(String resvContact) {
        this.setResvContact(resvContact);
        return this;
    }

    public void setResvContact(String resvContact) {
        this.resvContact = resvContact;
    }

    public String getContractNo() {
        return this.contractNo;
    }

    public Name contractNo(String contractNo) {
        this.setContractNo(contractNo);
        return this;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public LocalDate getContractRecvDate() {
        return this.contractRecvDate;
    }

    public Name contractRecvDate(LocalDate contractRecvDate) {
        this.setContractRecvDate(contractRecvDate);
        return this;
    }

    public void setContractRecvDate(LocalDate contractRecvDate) {
        this.contractRecvDate = contractRecvDate;
    }

    public String getAcctContact() {
        return this.acctContact;
    }

    public Name acctContact(String acctContact) {
        this.setAcctContact(acctContact);
        return this;
    }

    public void setAcctContact(String acctContact) {
        this.acctContact = acctContact;
    }

    public String getPriority() {
        return this.priority;
    }

    public Name priority(String priority) {
        this.setPriority(priority);
        return this;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getIndustryCode() {
        return this.industryCode;
    }

    public Name industryCode(String industryCode) {
        this.setIndustryCode(industryCode);
        return this;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getRoomsPotential() {
        return this.roomsPotential;
    }

    public Name roomsPotential(String roomsPotential) {
        this.setRoomsPotential(roomsPotential);
        return this;
    }

    public void setRoomsPotential(String roomsPotential) {
        this.roomsPotential = roomsPotential;
    }

    public String getCompetitionCode() {
        return this.competitionCode;
    }

    public Name competitionCode(String competitionCode) {
        this.setCompetitionCode(competitionCode);
        return this;
    }

    public void setCompetitionCode(String competitionCode) {
        this.competitionCode = competitionCode;
    }

    public String getScope() {
        return this.scope;
    }

    public Name scope(String scope) {
        this.setScope(scope);
        return this;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getScopeCity() {
        return this.scopeCity;
    }

    public Name scopeCity(String scopeCity) {
        this.setScopeCity(scopeCity);
        return this;
    }

    public void setScopeCity(String scopeCity) {
        this.scopeCity = scopeCity;
    }

    public String getTerritory() {
        return this.territory;
    }

    public Name territory(String territory) {
        this.setTerritory(territory);
        return this;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getActioncode() {
        return this.actioncode;
    }

    public Name actioncode(String actioncode) {
        this.setActioncode(actioncode);
        return this;
    }

    public void setActioncode(String actioncode) {
        this.actioncode = actioncode;
    }

    public String getActiveYn() {
        return this.activeYn;
    }

    public Name activeYn(String activeYn) {
        this.setActiveYn(activeYn);
        return this;
    }

    public void setActiveYn(String activeYn) {
        this.activeYn = activeYn;
    }

    public String getMasterAccountYn() {
        return this.masterAccountYn;
    }

    public Name masterAccountYn(String masterAccountYn) {
        this.setMasterAccountYn(masterAccountYn);
        return this;
    }

    public void setMasterAccountYn(String masterAccountYn) {
        this.masterAccountYn = masterAccountYn;
    }

    public String getNameType() {
        return this.nameType;
    }

    public Name nameType(String nameType) {
        this.setNameType(nameType);
        return this;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getSname() {
        return this.sname;
    }

    public Name sname(String sname) {
        this.setSname(sname);
        return this;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getNameTaxType() {
        return this.nameTaxType;
    }

    public Name nameTaxType(String nameTaxType) {
        this.setNameTaxType(nameTaxType);
        return this;
    }

    public void setNameTaxType(String nameTaxType) {
        this.nameTaxType = nameTaxType;
    }

    public String getSfirst() {
        return this.sfirst;
    }

    public Name sfirst(String sfirst) {
        this.setSfirst(sfirst);
        return this;
    }

    public void setSfirst(String sfirst) {
        this.sfirst = sfirst;
    }

    public String getArNo() {
        return this.arNo;
    }

    public Name arNo(String arNo) {
        this.setArNo(arNo);
        return this;
    }

    public void setArNo(String arNo) {
        this.arNo = arNo;
    }

    public String getAvailabilityOverride() {
        return this.availabilityOverride;
    }

    public Name availabilityOverride(String availabilityOverride) {
        this.setAvailabilityOverride(availabilityOverride);
        return this;
    }

    public void setAvailabilityOverride(String availabilityOverride) {
        this.availabilityOverride = availabilityOverride;
    }

    public String getBillingCode() {
        return this.billingCode;
    }

    public Name billingCode(String billingCode) {
        this.setBillingCode(billingCode);
        return this;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getCashBlInd() {
        return this.cashBlInd;
    }

    public Name cashBlInd(String cashBlInd) {
        this.setCashBlInd(cashBlInd);
        return this;
    }

    public void setCashBlInd(String cashBlInd) {
        this.cashBlInd = cashBlInd;
    }

    public String getBlMsg() {
        return this.blMsg;
    }

    public Name blMsg(String blMsg) {
        this.setBlMsg(blMsg);
        return this;
    }

    public void setBlMsg(String blMsg) {
        this.blMsg = blMsg;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public Name currencyCode(String currencyCode) {
        this.setCurrencyCode(currencyCode);
        return this;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCommissionCode() {
        return this.commissionCode;
    }

    public Name commissionCode(String commissionCode) {
        this.setCommissionCode(commissionCode);
        return this;
    }

    public void setCommissionCode(String commissionCode) {
        this.commissionCode = commissionCode;
    }

    public String getHoldCode() {
        return this.holdCode;
    }

    public Name holdCode(String holdCode) {
        this.setHoldCode(holdCode);
        return this;
    }

    public void setHoldCode(String holdCode) {
        this.holdCode = holdCode;
    }

    public String getInterest() {
        return this.interest;
    }

    public Name interest(String interest) {
        this.setInterest(interest);
        return this;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getSummRefCc() {
        return this.summRefCc;
    }

    public Name summRefCc(String summRefCc) {
        this.setSummRefCc(summRefCc);
        return this;
    }

    public void setSummRefCc(String summRefCc) {
        this.summRefCc = summRefCc;
    }

    public String getIataCompType() {
        return this.iataCompType;
    }

    public Name iataCompType(String iataCompType) {
        this.setIataCompType(iataCompType);
        return this;
    }

    public void setIataCompType(String iataCompType) {
        this.iataCompType = iataCompType;
    }

    public String getSrepCode() {
        return this.srepCode;
    }

    public Name srepCode(String srepCode) {
        this.setSrepCode(srepCode);
        return this;
    }

    public void setSrepCode(String srepCode) {
        this.srepCode = srepCode;
    }

    public String getAccountsource() {
        return this.accountsource;
    }

    public Name accountsource(String accountsource) {
        this.setAccountsource(accountsource);
        return this;
    }

    public void setAccountsource(String accountsource) {
        this.accountsource = accountsource;
    }

    public String getMarkets() {
        return this.markets;
    }

    public Name markets(String markets) {
        this.setMarkets(markets);
        return this;
    }

    public void setMarkets(String markets) {
        this.markets = markets;
    }

    public String getProductInterest() {
        return this.productInterest;
    }

    public Name productInterest(String productInterest) {
        this.setProductInterest(productInterest);
        return this;
    }

    public void setProductInterest(String productInterest) {
        this.productInterest = productInterest;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public Name keyword(String keyword) {
        this.setKeyword(keyword);
        return this;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLetterGreeting() {
        return this.letterGreeting;
    }

    public Name letterGreeting(String letterGreeting) {
        this.setLetterGreeting(letterGreeting);
        return this;
    }

    public void setLetterGreeting(String letterGreeting) {
        this.letterGreeting = letterGreeting;
    }

    public String getInfluence() {
        return this.influence;
    }

    public Name influence(String influence) {
        this.setInfluence(influence);
        return this;
    }

    public void setInfluence(String influence) {
        this.influence = influence;
    }

    public String getDeptId() {
        return this.deptId;
    }

    public Name deptId(String deptId) {
        this.setDeptId(deptId);
        return this;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDepartment() {
        return this.department;
    }

    public Name department(String department) {
        this.setDepartment(department);
        return this;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContactYn() {
        return this.contactYn;
    }

    public Name contactYn(String contactYn) {
        this.setContactYn(contactYn);
        return this;
    }

    public void setContactYn(String contactYn) {
        this.contactYn = contactYn;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public Name accountType(String accountType) {
        this.setAccountType(accountType);
        return this;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDownloadResort() {
        return this.downloadResort;
    }

    public Name downloadResort(String downloadResort) {
        this.setDownloadResort(downloadResort);
        return this;
    }

    public void setDownloadResort(String downloadResort) {
        this.downloadResort = downloadResort;
    }

    public Integer getDownloadSrep() {
        return this.downloadSrep;
    }

    public Name downloadSrep(Integer downloadSrep) {
        this.setDownloadSrep(downloadSrep);
        return this;
    }

    public void setDownloadSrep(Integer downloadSrep) {
        this.downloadSrep = downloadSrep;
    }

    public LocalDate getDownloadDate() {
        return this.downloadDate;
    }

    public Name downloadDate(LocalDate downloadDate) {
        this.setDownloadDate(downloadDate);
        return this;
    }

    public void setDownloadDate(LocalDate downloadDate) {
        this.downloadDate = downloadDate;
    }

    public LocalDate getUploadDate() {
        return this.uploadDate;
    }

    public Name uploadDate(LocalDate uploadDate) {
        this.setUploadDate(uploadDate);
        return this;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getLaptopChange() {
        return this.laptopChange;
    }

    public Name laptopChange(Integer laptopChange) {
        this.setLaptopChange(laptopChange);
        return this;
    }

    public void setLaptopChange(Integer laptopChange) {
        this.laptopChange = laptopChange;
    }

    public Integer getCrsNameid() {
        return this.crsNameid;
    }

    public Name crsNameid(Integer crsNameid) {
        this.setCrsNameid(crsNameid);
        return this;
    }

    public void setCrsNameid(Integer crsNameid) {
        this.crsNameid = crsNameid;
    }

    public String getCommPayCentral() {
        return this.commPayCentral;
    }

    public Name commPayCentral(String commPayCentral) {
        this.setCommPayCentral(commPayCentral);
        return this;
    }

    public void setCommPayCentral(String commPayCentral) {
        this.commPayCentral = commPayCentral;
    }

    public String getCcProfileYn() {
        return this.ccProfileYn;
    }

    public Name ccProfileYn(String ccProfileYn) {
        this.setCcProfileYn(ccProfileYn);
        return this;
    }

    public void setCcProfileYn(String ccProfileYn) {
        this.ccProfileYn = ccProfileYn;
    }

    public String getGender() {
        return this.gender;
    }

    public Name gender(String gender) {
        this.setGender(gender);
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthPlace() {
        return this.birthPlace;
    }

    public Name birthPlace(String birthPlace) {
        this.setBirthPlace(birthPlace);
        return this;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthCountry() {
        return this.birthCountry;
    }

    public Name birthCountry(String birthCountry) {
        this.setBirthCountry(birthCountry);
        return this;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getProfession() {
        return this.profession;
    }

    public Name profession(String profession) {
        this.setProfession(profession);
        return this;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIdType() {
        return this.idType;
    }

    public Name idType(String idType) {
        this.setIdType(idType);
        return this;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public Name idNumber(String idNumber) {
        this.setIdNumber(idNumber);
        return this;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getIdDate() {
        return this.idDate;
    }

    public Name idDate(LocalDate idDate) {
        this.setIdDate(idDate);
        return this;
    }

    public void setIdDate(LocalDate idDate) {
        this.idDate = idDate;
    }

    public String getIdPlace() {
        return this.idPlace;
    }

    public Name idPlace(String idPlace) {
        this.setIdPlace(idPlace);
        return this;
    }

    public void setIdPlace(String idPlace) {
        this.idPlace = idPlace;
    }

    public String getIdCountry() {
        return this.idCountry;
    }

    public Name idCountry(String idCountry) {
        this.setIdCountry(idCountry);
        return this;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public String getUdfc01() {
        return this.udfc01;
    }

    public Name udfc01(String udfc01) {
        this.setUdfc01(udfc01);
        return this;
    }

    public void setUdfc01(String udfc01) {
        this.udfc01 = udfc01;
    }

    public String getUdfc02() {
        return this.udfc02;
    }

    public Name udfc02(String udfc02) {
        this.setUdfc02(udfc02);
        return this;
    }

    public void setUdfc02(String udfc02) {
        this.udfc02 = udfc02;
    }

    public String getUdfc03() {
        return this.udfc03;
    }

    public Name udfc03(String udfc03) {
        this.setUdfc03(udfc03);
        return this;
    }

    public void setUdfc03(String udfc03) {
        this.udfc03 = udfc03;
    }

    public String getUdfc04() {
        return this.udfc04;
    }

    public Name udfc04(String udfc04) {
        this.setUdfc04(udfc04);
        return this;
    }

    public void setUdfc04(String udfc04) {
        this.udfc04 = udfc04;
    }

    public String getUdfc05() {
        return this.udfc05;
    }

    public Name udfc05(String udfc05) {
        this.setUdfc05(udfc05);
        return this;
    }

    public void setUdfc05(String udfc05) {
        this.udfc05 = udfc05;
    }

    public String getUdfc06() {
        return this.udfc06;
    }

    public Name udfc06(String udfc06) {
        this.setUdfc06(udfc06);
        return this;
    }

    public void setUdfc06(String udfc06) {
        this.udfc06 = udfc06;
    }

    public String getUdfc07() {
        return this.udfc07;
    }

    public Name udfc07(String udfc07) {
        this.setUdfc07(udfc07);
        return this;
    }

    public void setUdfc07(String udfc07) {
        this.udfc07 = udfc07;
    }

    public String getUdfc08() {
        return this.udfc08;
    }

    public Name udfc08(String udfc08) {
        this.setUdfc08(udfc08);
        return this;
    }

    public void setUdfc08(String udfc08) {
        this.udfc08 = udfc08;
    }

    public String getUdfc09() {
        return this.udfc09;
    }

    public Name udfc09(String udfc09) {
        this.setUdfc09(udfc09);
        return this;
    }

    public void setUdfc09(String udfc09) {
        this.udfc09 = udfc09;
    }

    public String getUdfc10() {
        return this.udfc10;
    }

    public Name udfc10(String udfc10) {
        this.setUdfc10(udfc10);
        return this;
    }

    public void setUdfc10(String udfc10) {
        this.udfc10 = udfc10;
    }

    public String getUdfc11() {
        return this.udfc11;
    }

    public Name udfc11(String udfc11) {
        this.setUdfc11(udfc11);
        return this;
    }

    public void setUdfc11(String udfc11) {
        this.udfc11 = udfc11;
    }

    public String getUdfc12() {
        return this.udfc12;
    }

    public Name udfc12(String udfc12) {
        this.setUdfc12(udfc12);
        return this;
    }

    public void setUdfc12(String udfc12) {
        this.udfc12 = udfc12;
    }

    public String getUdfc13() {
        return this.udfc13;
    }

    public Name udfc13(String udfc13) {
        this.setUdfc13(udfc13);
        return this;
    }

    public void setUdfc13(String udfc13) {
        this.udfc13 = udfc13;
    }

    public String getUdfc14() {
        return this.udfc14;
    }

    public Name udfc14(String udfc14) {
        this.setUdfc14(udfc14);
        return this;
    }

    public void setUdfc14(String udfc14) {
        this.udfc14 = udfc14;
    }

    public String getUdfc15() {
        return this.udfc15;
    }

    public Name udfc15(String udfc15) {
        this.setUdfc15(udfc15);
        return this;
    }

    public void setUdfc15(String udfc15) {
        this.udfc15 = udfc15;
    }

    public String getUdfc16() {
        return this.udfc16;
    }

    public Name udfc16(String udfc16) {
        this.setUdfc16(udfc16);
        return this;
    }

    public void setUdfc16(String udfc16) {
        this.udfc16 = udfc16;
    }

    public String getUdfc17() {
        return this.udfc17;
    }

    public Name udfc17(String udfc17) {
        this.setUdfc17(udfc17);
        return this;
    }

    public void setUdfc17(String udfc17) {
        this.udfc17 = udfc17;
    }

    public String getUdfc18() {
        return this.udfc18;
    }

    public Name udfc18(String udfc18) {
        this.setUdfc18(udfc18);
        return this;
    }

    public void setUdfc18(String udfc18) {
        this.udfc18 = udfc18;
    }

    public String getUdfc19() {
        return this.udfc19;
    }

    public Name udfc19(String udfc19) {
        this.setUdfc19(udfc19);
        return this;
    }

    public void setUdfc19(String udfc19) {
        this.udfc19 = udfc19;
    }

    public String getUdfc20() {
        return this.udfc20;
    }

    public Name udfc20(String udfc20) {
        this.setUdfc20(udfc20);
        return this;
    }

    public void setUdfc20(String udfc20) {
        this.udfc20 = udfc20;
    }

    public String getUdfc21() {
        return this.udfc21;
    }

    public Name udfc21(String udfc21) {
        this.setUdfc21(udfc21);
        return this;
    }

    public void setUdfc21(String udfc21) {
        this.udfc21 = udfc21;
    }

    public String getUdfc22() {
        return this.udfc22;
    }

    public Name udfc22(String udfc22) {
        this.setUdfc22(udfc22);
        return this;
    }

    public void setUdfc22(String udfc22) {
        this.udfc22 = udfc22;
    }

    public String getUdfc23() {
        return this.udfc23;
    }

    public Name udfc23(String udfc23) {
        this.setUdfc23(udfc23);
        return this;
    }

    public void setUdfc23(String udfc23) {
        this.udfc23 = udfc23;
    }

    public String getUdfc24() {
        return this.udfc24;
    }

    public Name udfc24(String udfc24) {
        this.setUdfc24(udfc24);
        return this;
    }

    public void setUdfc24(String udfc24) {
        this.udfc24 = udfc24;
    }

    public String getUdfc25() {
        return this.udfc25;
    }

    public Name udfc25(String udfc25) {
        this.setUdfc25(udfc25);
        return this;
    }

    public void setUdfc25(String udfc25) {
        this.udfc25 = udfc25;
    }

    public String getUdfc26() {
        return this.udfc26;
    }

    public Name udfc26(String udfc26) {
        this.setUdfc26(udfc26);
        return this;
    }

    public void setUdfc26(String udfc26) {
        this.udfc26 = udfc26;
    }

    public String getUdfc27() {
        return this.udfc27;
    }

    public Name udfc27(String udfc27) {
        this.setUdfc27(udfc27);
        return this;
    }

    public void setUdfc27(String udfc27) {
        this.udfc27 = udfc27;
    }

    public String getUdfc28() {
        return this.udfc28;
    }

    public Name udfc28(String udfc28) {
        this.setUdfc28(udfc28);
        return this;
    }

    public void setUdfc28(String udfc28) {
        this.udfc28 = udfc28;
    }

    public String getUdfc29() {
        return this.udfc29;
    }

    public Name udfc29(String udfc29) {
        this.setUdfc29(udfc29);
        return this;
    }

    public void setUdfc29(String udfc29) {
        this.udfc29 = udfc29;
    }

    public String getUdfc30() {
        return this.udfc30;
    }

    public Name udfc30(String udfc30) {
        this.setUdfc30(udfc30);
        return this;
    }

    public void setUdfc30(String udfc30) {
        this.udfc30 = udfc30;
    }

    public String getUdfc31() {
        return this.udfc31;
    }

    public Name udfc31(String udfc31) {
        this.setUdfc31(udfc31);
        return this;
    }

    public void setUdfc31(String udfc31) {
        this.udfc31 = udfc31;
    }

    public String getUdfc32() {
        return this.udfc32;
    }

    public Name udfc32(String udfc32) {
        this.setUdfc32(udfc32);
        return this;
    }

    public void setUdfc32(String udfc32) {
        this.udfc32 = udfc32;
    }

    public String getUdfc33() {
        return this.udfc33;
    }

    public Name udfc33(String udfc33) {
        this.setUdfc33(udfc33);
        return this;
    }

    public void setUdfc33(String udfc33) {
        this.udfc33 = udfc33;
    }

    public String getUdfc34() {
        return this.udfc34;
    }

    public Name udfc34(String udfc34) {
        this.setUdfc34(udfc34);
        return this;
    }

    public void setUdfc34(String udfc34) {
        this.udfc34 = udfc34;
    }

    public String getUdfc35() {
        return this.udfc35;
    }

    public Name udfc35(String udfc35) {
        this.setUdfc35(udfc35);
        return this;
    }

    public void setUdfc35(String udfc35) {
        this.udfc35 = udfc35;
    }

    public String getUdfc36() {
        return this.udfc36;
    }

    public Name udfc36(String udfc36) {
        this.setUdfc36(udfc36);
        return this;
    }

    public void setUdfc36(String udfc36) {
        this.udfc36 = udfc36;
    }

    public String getUdfc37() {
        return this.udfc37;
    }

    public Name udfc37(String udfc37) {
        this.setUdfc37(udfc37);
        return this;
    }

    public void setUdfc37(String udfc37) {
        this.udfc37 = udfc37;
    }

    public String getUdfc38() {
        return this.udfc38;
    }

    public Name udfc38(String udfc38) {
        this.setUdfc38(udfc38);
        return this;
    }

    public void setUdfc38(String udfc38) {
        this.udfc38 = udfc38;
    }

    public String getUdfc39() {
        return this.udfc39;
    }

    public Name udfc39(String udfc39) {
        this.setUdfc39(udfc39);
        return this;
    }

    public void setUdfc39(String udfc39) {
        this.udfc39 = udfc39;
    }

    public String getUdfc40() {
        return this.udfc40;
    }

    public Name udfc40(String udfc40) {
        this.setUdfc40(udfc40);
        return this;
    }

    public void setUdfc40(String udfc40) {
        this.udfc40 = udfc40;
    }

    public Integer getUdfn01() {
        return this.udfn01;
    }

    public Name udfn01(Integer udfn01) {
        this.setUdfn01(udfn01);
        return this;
    }

    public void setUdfn01(Integer udfn01) {
        this.udfn01 = udfn01;
    }

    public Integer getUdfn02() {
        return this.udfn02;
    }

    public Name udfn02(Integer udfn02) {
        this.setUdfn02(udfn02);
        return this;
    }

    public void setUdfn02(Integer udfn02) {
        this.udfn02 = udfn02;
    }

    public Integer getUdfn03() {
        return this.udfn03;
    }

    public Name udfn03(Integer udfn03) {
        this.setUdfn03(udfn03);
        return this;
    }

    public void setUdfn03(Integer udfn03) {
        this.udfn03 = udfn03;
    }

    public Integer getUdfn04() {
        return this.udfn04;
    }

    public Name udfn04(Integer udfn04) {
        this.setUdfn04(udfn04);
        return this;
    }

    public void setUdfn04(Integer udfn04) {
        this.udfn04 = udfn04;
    }

    public Integer getUdfn05() {
        return this.udfn05;
    }

    public Name udfn05(Integer udfn05) {
        this.setUdfn05(udfn05);
        return this;
    }

    public void setUdfn05(Integer udfn05) {
        this.udfn05 = udfn05;
    }

    public Integer getUdfn06() {
        return this.udfn06;
    }

    public Name udfn06(Integer udfn06) {
        this.setUdfn06(udfn06);
        return this;
    }

    public void setUdfn06(Integer udfn06) {
        this.udfn06 = udfn06;
    }

    public Integer getUdfn07() {
        return this.udfn07;
    }

    public Name udfn07(Integer udfn07) {
        this.setUdfn07(udfn07);
        return this;
    }

    public void setUdfn07(Integer udfn07) {
        this.udfn07 = udfn07;
    }

    public Integer getUdfn08() {
        return this.udfn08;
    }

    public Name udfn08(Integer udfn08) {
        this.setUdfn08(udfn08);
        return this;
    }

    public void setUdfn08(Integer udfn08) {
        this.udfn08 = udfn08;
    }

    public Integer getUdfn09() {
        return this.udfn09;
    }

    public Name udfn09(Integer udfn09) {
        this.setUdfn09(udfn09);
        return this;
    }

    public void setUdfn09(Integer udfn09) {
        this.udfn09 = udfn09;
    }

    public Integer getUdfn10() {
        return this.udfn10;
    }

    public Name udfn10(Integer udfn10) {
        this.setUdfn10(udfn10);
        return this;
    }

    public void setUdfn10(Integer udfn10) {
        this.udfn10 = udfn10;
    }

    public Integer getUdfn11() {
        return this.udfn11;
    }

    public Name udfn11(Integer udfn11) {
        this.setUdfn11(udfn11);
        return this;
    }

    public void setUdfn11(Integer udfn11) {
        this.udfn11 = udfn11;
    }

    public Integer getUdfn12() {
        return this.udfn12;
    }

    public Name udfn12(Integer udfn12) {
        this.setUdfn12(udfn12);
        return this;
    }

    public void setUdfn12(Integer udfn12) {
        this.udfn12 = udfn12;
    }

    public Integer getUdfn13() {
        return this.udfn13;
    }

    public Name udfn13(Integer udfn13) {
        this.setUdfn13(udfn13);
        return this;
    }

    public void setUdfn13(Integer udfn13) {
        this.udfn13 = udfn13;
    }

    public Integer getUdfn14() {
        return this.udfn14;
    }

    public Name udfn14(Integer udfn14) {
        this.setUdfn14(udfn14);
        return this;
    }

    public void setUdfn14(Integer udfn14) {
        this.udfn14 = udfn14;
    }

    public Integer getUdfn15() {
        return this.udfn15;
    }

    public Name udfn15(Integer udfn15) {
        this.setUdfn15(udfn15);
        return this;
    }

    public void setUdfn15(Integer udfn15) {
        this.udfn15 = udfn15;
    }

    public Integer getUdfn16() {
        return this.udfn16;
    }

    public Name udfn16(Integer udfn16) {
        this.setUdfn16(udfn16);
        return this;
    }

    public void setUdfn16(Integer udfn16) {
        this.udfn16 = udfn16;
    }

    public Integer getUdfn17() {
        return this.udfn17;
    }

    public Name udfn17(Integer udfn17) {
        this.setUdfn17(udfn17);
        return this;
    }

    public void setUdfn17(Integer udfn17) {
        this.udfn17 = udfn17;
    }

    public Integer getUdfn18() {
        return this.udfn18;
    }

    public Name udfn18(Integer udfn18) {
        this.setUdfn18(udfn18);
        return this;
    }

    public void setUdfn18(Integer udfn18) {
        this.udfn18 = udfn18;
    }

    public Integer getUdfn19() {
        return this.udfn19;
    }

    public Name udfn19(Integer udfn19) {
        this.setUdfn19(udfn19);
        return this;
    }

    public void setUdfn19(Integer udfn19) {
        this.udfn19 = udfn19;
    }

    public Integer getUdfn20() {
        return this.udfn20;
    }

    public Name udfn20(Integer udfn20) {
        this.setUdfn20(udfn20);
        return this;
    }

    public void setUdfn20(Integer udfn20) {
        this.udfn20 = udfn20;
    }

    public Integer getUdfn21() {
        return this.udfn21;
    }

    public Name udfn21(Integer udfn21) {
        this.setUdfn21(udfn21);
        return this;
    }

    public void setUdfn21(Integer udfn21) {
        this.udfn21 = udfn21;
    }

    public Integer getUdfn22() {
        return this.udfn22;
    }

    public Name udfn22(Integer udfn22) {
        this.setUdfn22(udfn22);
        return this;
    }

    public void setUdfn22(Integer udfn22) {
        this.udfn22 = udfn22;
    }

    public Integer getUdfn23() {
        return this.udfn23;
    }

    public Name udfn23(Integer udfn23) {
        this.setUdfn23(udfn23);
        return this;
    }

    public void setUdfn23(Integer udfn23) {
        this.udfn23 = udfn23;
    }

    public Integer getUdfn24() {
        return this.udfn24;
    }

    public Name udfn24(Integer udfn24) {
        this.setUdfn24(udfn24);
        return this;
    }

    public void setUdfn24(Integer udfn24) {
        this.udfn24 = udfn24;
    }

    public Integer getUdfn25() {
        return this.udfn25;
    }

    public Name udfn25(Integer udfn25) {
        this.setUdfn25(udfn25);
        return this;
    }

    public void setUdfn25(Integer udfn25) {
        this.udfn25 = udfn25;
    }

    public Integer getUdfn26() {
        return this.udfn26;
    }

    public Name udfn26(Integer udfn26) {
        this.setUdfn26(udfn26);
        return this;
    }

    public void setUdfn26(Integer udfn26) {
        this.udfn26 = udfn26;
    }

    public Integer getUdfn27() {
        return this.udfn27;
    }

    public Name udfn27(Integer udfn27) {
        this.setUdfn27(udfn27);
        return this;
    }

    public void setUdfn27(Integer udfn27) {
        this.udfn27 = udfn27;
    }

    public Integer getUdfn28() {
        return this.udfn28;
    }

    public Name udfn28(Integer udfn28) {
        this.setUdfn28(udfn28);
        return this;
    }

    public void setUdfn28(Integer udfn28) {
        this.udfn28 = udfn28;
    }

    public Integer getUdfn29() {
        return this.udfn29;
    }

    public Name udfn29(Integer udfn29) {
        this.setUdfn29(udfn29);
        return this;
    }

    public void setUdfn29(Integer udfn29) {
        this.udfn29 = udfn29;
    }

    public Integer getUdfn30() {
        return this.udfn30;
    }

    public Name udfn30(Integer udfn30) {
        this.setUdfn30(udfn30);
        return this;
    }

    public void setUdfn30(Integer udfn30) {
        this.udfn30 = udfn30;
    }

    public Integer getUdfn31() {
        return this.udfn31;
    }

    public Name udfn31(Integer udfn31) {
        this.setUdfn31(udfn31);
        return this;
    }

    public void setUdfn31(Integer udfn31) {
        this.udfn31 = udfn31;
    }

    public Integer getUdfn32() {
        return this.udfn32;
    }

    public Name udfn32(Integer udfn32) {
        this.setUdfn32(udfn32);
        return this;
    }

    public void setUdfn32(Integer udfn32) {
        this.udfn32 = udfn32;
    }

    public Integer getUdfn33() {
        return this.udfn33;
    }

    public Name udfn33(Integer udfn33) {
        this.setUdfn33(udfn33);
        return this;
    }

    public void setUdfn33(Integer udfn33) {
        this.udfn33 = udfn33;
    }

    public Integer getUdfn34() {
        return this.udfn34;
    }

    public Name udfn34(Integer udfn34) {
        this.setUdfn34(udfn34);
        return this;
    }

    public void setUdfn34(Integer udfn34) {
        this.udfn34 = udfn34;
    }

    public Integer getUdfn35() {
        return this.udfn35;
    }

    public Name udfn35(Integer udfn35) {
        this.setUdfn35(udfn35);
        return this;
    }

    public void setUdfn35(Integer udfn35) {
        this.udfn35 = udfn35;
    }

    public Integer getUdfn36() {
        return this.udfn36;
    }

    public Name udfn36(Integer udfn36) {
        this.setUdfn36(udfn36);
        return this;
    }

    public void setUdfn36(Integer udfn36) {
        this.udfn36 = udfn36;
    }

    public Integer getUdfn37() {
        return this.udfn37;
    }

    public Name udfn37(Integer udfn37) {
        this.setUdfn37(udfn37);
        return this;
    }

    public void setUdfn37(Integer udfn37) {
        this.udfn37 = udfn37;
    }

    public Integer getUdfn38() {
        return this.udfn38;
    }

    public Name udfn38(Integer udfn38) {
        this.setUdfn38(udfn38);
        return this;
    }

    public void setUdfn38(Integer udfn38) {
        this.udfn38 = udfn38;
    }

    public Integer getUdfn39() {
        return this.udfn39;
    }

    public Name udfn39(Integer udfn39) {
        this.setUdfn39(udfn39);
        return this;
    }

    public void setUdfn39(Integer udfn39) {
        this.udfn39 = udfn39;
    }

    public Integer getUdfn40() {
        return this.udfn40;
    }

    public Name udfn40(Integer udfn40) {
        this.setUdfn40(udfn40);
        return this;
    }

    public void setUdfn40(Integer udfn40) {
        this.udfn40 = udfn40;
    }

    public LocalDate getUdfd01() {
        return this.udfd01;
    }

    public Name udfd01(LocalDate udfd01) {
        this.setUdfd01(udfd01);
        return this;
    }

    public void setUdfd01(LocalDate udfd01) {
        this.udfd01 = udfd01;
    }

    public LocalDate getUdfd02() {
        return this.udfd02;
    }

    public Name udfd02(LocalDate udfd02) {
        this.setUdfd02(udfd02);
        return this;
    }

    public void setUdfd02(LocalDate udfd02) {
        this.udfd02 = udfd02;
    }

    public LocalDate getUdfd03() {
        return this.udfd03;
    }

    public Name udfd03(LocalDate udfd03) {
        this.setUdfd03(udfd03);
        return this;
    }

    public void setUdfd03(LocalDate udfd03) {
        this.udfd03 = udfd03;
    }

    public LocalDate getUdfd04() {
        return this.udfd04;
    }

    public Name udfd04(LocalDate udfd04) {
        this.setUdfd04(udfd04);
        return this;
    }

    public void setUdfd04(LocalDate udfd04) {
        this.udfd04 = udfd04;
    }

    public LocalDate getUdfd05() {
        return this.udfd05;
    }

    public Name udfd05(LocalDate udfd05) {
        this.setUdfd05(udfd05);
        return this;
    }

    public void setUdfd05(LocalDate udfd05) {
        this.udfd05 = udfd05;
    }

    public LocalDate getUdfd06() {
        return this.udfd06;
    }

    public Name udfd06(LocalDate udfd06) {
        this.setUdfd06(udfd06);
        return this;
    }

    public void setUdfd06(LocalDate udfd06) {
        this.udfd06 = udfd06;
    }

    public LocalDate getUdfd07() {
        return this.udfd07;
    }

    public Name udfd07(LocalDate udfd07) {
        this.setUdfd07(udfd07);
        return this;
    }

    public void setUdfd07(LocalDate udfd07) {
        this.udfd07 = udfd07;
    }

    public LocalDate getUdfd08() {
        return this.udfd08;
    }

    public Name udfd08(LocalDate udfd08) {
        this.setUdfd08(udfd08);
        return this;
    }

    public void setUdfd08(LocalDate udfd08) {
        this.udfd08 = udfd08;
    }

    public LocalDate getUdfd09() {
        return this.udfd09;
    }

    public Name udfd09(LocalDate udfd09) {
        this.setUdfd09(udfd09);
        return this;
    }

    public void setUdfd09(LocalDate udfd09) {
        this.udfd09 = udfd09;
    }

    public LocalDate getUdfd10() {
        return this.udfd10;
    }

    public Name udfd10(LocalDate udfd10) {
        this.setUdfd10(udfd10);
        return this;
    }

    public void setUdfd10(LocalDate udfd10) {
        this.udfd10 = udfd10;
    }

    public LocalDate getUdfd11() {
        return this.udfd11;
    }

    public Name udfd11(LocalDate udfd11) {
        this.setUdfd11(udfd11);
        return this;
    }

    public void setUdfd11(LocalDate udfd11) {
        this.udfd11 = udfd11;
    }

    public LocalDate getUdfd12() {
        return this.udfd12;
    }

    public Name udfd12(LocalDate udfd12) {
        this.setUdfd12(udfd12);
        return this;
    }

    public void setUdfd12(LocalDate udfd12) {
        this.udfd12 = udfd12;
    }

    public LocalDate getUdfd13() {
        return this.udfd13;
    }

    public Name udfd13(LocalDate udfd13) {
        this.setUdfd13(udfd13);
        return this;
    }

    public void setUdfd13(LocalDate udfd13) {
        this.udfd13 = udfd13;
    }

    public LocalDate getUdfd14() {
        return this.udfd14;
    }

    public Name udfd14(LocalDate udfd14) {
        this.setUdfd14(udfd14);
        return this;
    }

    public void setUdfd14(LocalDate udfd14) {
        this.udfd14 = udfd14;
    }

    public LocalDate getUdfd15() {
        return this.udfd15;
    }

    public Name udfd15(LocalDate udfd15) {
        this.setUdfd15(udfd15);
        return this;
    }

    public void setUdfd15(LocalDate udfd15) {
        this.udfd15 = udfd15;
    }

    public LocalDate getUdfd16() {
        return this.udfd16;
    }

    public Name udfd16(LocalDate udfd16) {
        this.setUdfd16(udfd16);
        return this;
    }

    public void setUdfd16(LocalDate udfd16) {
        this.udfd16 = udfd16;
    }

    public LocalDate getUdfd17() {
        return this.udfd17;
    }

    public Name udfd17(LocalDate udfd17) {
        this.setUdfd17(udfd17);
        return this;
    }

    public void setUdfd17(LocalDate udfd17) {
        this.udfd17 = udfd17;
    }

    public LocalDate getUdfd18() {
        return this.udfd18;
    }

    public Name udfd18(LocalDate udfd18) {
        this.setUdfd18(udfd18);
        return this;
    }

    public void setUdfd18(LocalDate udfd18) {
        this.udfd18 = udfd18;
    }

    public LocalDate getUdfd19() {
        return this.udfd19;
    }

    public Name udfd19(LocalDate udfd19) {
        this.setUdfd19(udfd19);
        return this;
    }

    public void setUdfd19(LocalDate udfd19) {
        this.udfd19 = udfd19;
    }

    public LocalDate getUdfd20() {
        return this.udfd20;
    }

    public Name udfd20(LocalDate udfd20) {
        this.setUdfd20(udfd20);
        return this;
    }

    public void setUdfd20(LocalDate udfd20) {
        this.udfd20 = udfd20;
    }

    public Integer getPaymentDueDays() {
        return this.paymentDueDays;
    }

    public Name paymentDueDays(Integer paymentDueDays) {
        this.setPaymentDueDays(paymentDueDays);
        return this;
    }

    public void setPaymentDueDays(Integer paymentDueDays) {
        this.paymentDueDays = paymentDueDays;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public Name suffix(String suffix) {
        this.setSuffix(suffix);
        return this;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public Name externalId(String externalId) {
        this.setExternalId(externalId);
        return this;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getGuestPrivYn() {
        return this.guestPrivYn;
    }

    public Name guestPrivYn(String guestPrivYn) {
        this.setGuestPrivYn(guestPrivYn);
        return this;
    }

    public void setGuestPrivYn(String guestPrivYn) {
        this.guestPrivYn = guestPrivYn;
    }

    public String getEmailYn() {
        return this.emailYn;
    }

    public Name emailYn(String emailYn) {
        this.setEmailYn(emailYn);
        return this;
    }

    public void setEmailYn(String emailYn) {
        this.emailYn = emailYn;
    }

    public String getMailYn() {
        return this.mailYn;
    }

    public Name mailYn(String mailYn) {
        this.setMailYn(mailYn);
        return this;
    }

    public void setMailYn(String mailYn) {
        this.mailYn = mailYn;
    }

    public String getIndexName() {
        return this.indexName;
    }

    public Name indexName(String indexName) {
        this.setIndexName(indexName);
        return this;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getXlastName() {
        return this.xlastName;
    }

    public Name xlastName(String xlastName) {
        this.setXlastName(xlastName);
        return this;
    }

    public void setXlastName(String xlastName) {
        this.xlastName = xlastName;
    }

    public String getXfirstName() {
        return this.xfirstName;
    }

    public Name xfirstName(String xfirstName) {
        this.setXfirstName(xfirstName);
        return this;
    }

    public void setXfirstName(String xfirstName) {
        this.xfirstName = xfirstName;
    }

    public String getXcompanyName() {
        return this.xcompanyName;
    }

    public Name xcompanyName(String xcompanyName) {
        this.setXcompanyName(xcompanyName);
        return this;
    }

    public void setXcompanyName(String xcompanyName) {
        this.xcompanyName = xcompanyName;
    }

    public String getXtitle() {
        return this.xtitle;
    }

    public Name xtitle(String xtitle) {
        this.setXtitle(xtitle);
        return this;
    }

    public void setXtitle(String xtitle) {
        this.xtitle = xtitle;
    }

    public String getXsalutation() {
        return this.xsalutation;
    }

    public Name xsalutation(String xsalutation) {
        this.setXsalutation(xsalutation);
        return this;
    }

    public void setXsalutation(String xsalutation) {
        this.xsalutation = xsalutation;
    }

    public String getSxname() {
        return this.sxname;
    }

    public Name sxname(String sxname) {
        this.setSxname(sxname);
        return this;
    }

    public void setSxname(String sxname) {
        this.sxname = sxname;
    }

    public String getSxfirstName() {
        return this.sxfirstName;
    }

    public Name sxfirstName(String sxfirstName) {
        this.setSxfirstName(sxfirstName);
        return this;
    }

    public void setSxfirstName(String sxfirstName) {
        this.sxfirstName = sxfirstName;
    }

    public String getLastUpdatedResort() {
        return this.lastUpdatedResort;
    }

    public Name lastUpdatedResort(String lastUpdatedResort) {
        this.setLastUpdatedResort(lastUpdatedResort);
        return this;
    }

    public void setLastUpdatedResort(String lastUpdatedResort) {
        this.lastUpdatedResort = lastUpdatedResort;
    }

    public String getEnvelopeGreeting() {
        return this.envelopeGreeting;
    }

    public Name envelopeGreeting(String envelopeGreeting) {
        this.setEnvelopeGreeting(envelopeGreeting);
        return this;
    }

    public void setEnvelopeGreeting(String envelopeGreeting) {
        this.envelopeGreeting = envelopeGreeting;
    }

    public String getXenvelopeGreeting() {
        return this.xenvelopeGreeting;
    }

    public Name xenvelopeGreeting(String xenvelopeGreeting) {
        this.setXenvelopeGreeting(xenvelopeGreeting);
        return this;
    }

    public void setXenvelopeGreeting(String xenvelopeGreeting) {
        this.xenvelopeGreeting = xenvelopeGreeting;
    }

    public String getDirectBillBatchType() {
        return this.directBillBatchType;
    }

    public Name directBillBatchType(String directBillBatchType) {
        this.setDirectBillBatchType(directBillBatchType);
        return this;
    }

    public void setDirectBillBatchType(String directBillBatchType) {
        this.directBillBatchType = directBillBatchType;
    }

    public String getResortRegistered() {
        return this.resortRegistered;
    }

    public Name resortRegistered(String resortRegistered) {
        this.setResortRegistered(resortRegistered);
        return this;
    }

    public void setResortRegistered(String resortRegistered) {
        this.resortRegistered = resortRegistered;
    }

    public String getTaxOffice() {
        return this.taxOffice;
    }

    public Name taxOffice(String taxOffice) {
        this.setTaxOffice(taxOffice);
        return this;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getTaxType() {
        return this.taxType;
    }

    public Name taxType(String taxType) {
        this.setTaxType(taxType);
        return this;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxCategory() {
        return this.taxCategory;
    }

    public Name taxCategory(String taxCategory) {
        this.setTaxCategory(taxCategory);
        return this;
    }

    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
    }

    public String getPreferredRoomNo() {
        return this.preferredRoomNo;
    }

    public Name preferredRoomNo(String preferredRoomNo) {
        this.setPreferredRoomNo(preferredRoomNo);
        return this;
    }

    public void setPreferredRoomNo(String preferredRoomNo) {
        this.preferredRoomNo = preferredRoomNo;
    }

    public String getPhoneYn() {
        return this.phoneYn;
    }

    public Name phoneYn(String phoneYn) {
        this.setPhoneYn(phoneYn);
        return this;
    }

    public void setPhoneYn(String phoneYn) {
        this.phoneYn = phoneYn;
    }

    public String getSmsYn() {
        return this.smsYn;
    }

    public Name smsYn(String smsYn) {
        this.setSmsYn(smsYn);
        return this;
    }

    public void setSmsYn(String smsYn) {
        this.smsYn = smsYn;
    }

    public String getIsProtected() {
        return this.isProtected;
    }

    public Name isProtected(String isProtected) {
        this.setIsProtected(isProtected);
        return this;
    }

    public void setIsProtected(String isProtected) {
        this.isProtected = isProtected;
    }

    public String getXlanguage() {
        return this.xlanguage;
    }

    public Name xlanguage(String xlanguage) {
        this.setXlanguage(xlanguage);
        return this;
    }

    public void setXlanguage(String xlanguage) {
        this.xlanguage = xlanguage;
    }

    public String getMarketResearchYn() {
        return this.marketResearchYn;
    }

    public Name marketResearchYn(String marketResearchYn) {
        this.setMarketResearchYn(marketResearchYn);
        return this;
    }

    public void setMarketResearchYn(String marketResearchYn) {
        this.marketResearchYn = marketResearchYn;
    }

    public String getThirdPartyYn() {
        return this.thirdPartyYn;
    }

    public Name thirdPartyYn(String thirdPartyYn) {
        this.setThirdPartyYn(thirdPartyYn);
        return this;
    }

    public void setThirdPartyYn(String thirdPartyYn) {
        this.thirdPartyYn = thirdPartyYn;
    }

    public String getAutoenrollMemberYn() {
        return this.autoenrollMemberYn;
    }

    public Name autoenrollMemberYn(String autoenrollMemberYn) {
        this.setAutoenrollMemberYn(autoenrollMemberYn);
        return this;
    }

    public void setAutoenrollMemberYn(String autoenrollMemberYn) {
        this.autoenrollMemberYn = autoenrollMemberYn;
    }

    public String getChainCode() {
        return this.chainCode;
    }

    public Name chainCode(String chainCode) {
        this.setChainCode(chainCode);
        return this;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public String getCompanyGroupId() {
        return this.companyGroupId;
    }

    public Name companyGroupId(String companyGroupId) {
        this.setCompanyGroupId(companyGroupId);
        return this;
    }

    public void setCompanyGroupId(String companyGroupId) {
        this.companyGroupId = companyGroupId;
    }

    public String getIncludeIn1099Yn() {
        return this.includeIn1099Yn;
    }

    public Name includeIn1099Yn(String includeIn1099Yn) {
        this.setIncludeIn1099Yn(includeIn1099Yn);
        return this;
    }

    public void setIncludeIn1099Yn(String includeIn1099Yn) {
        this.includeIn1099Yn = includeIn1099Yn;
    }

    public String getCreditRating() {
        return this.creditRating;
    }

    public Name creditRating(String creditRating) {
        this.setCreditRating(creditRating);
        return this;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public Integer getTitleSuffix() {
        return this.titleSuffix;
    }

    public Name titleSuffix(Integer titleSuffix) {
        this.setTitleSuffix(titleSuffix);
        return this;
    }

    public void setTitleSuffix(Integer titleSuffix) {
        this.titleSuffix = titleSuffix;
    }

    public String getInactiveReason() {
        return this.inactiveReason;
    }

    public Name inactiveReason(String inactiveReason) {
        this.setInactiveReason(inactiveReason);
        return this;
    }

    public void setInactiveReason(String inactiveReason) {
        this.inactiveReason = inactiveReason;
    }

    public String getIataConsortia() {
        return this.iataConsortia;
    }

    public Name iataConsortia(String iataConsortia) {
        this.setIataConsortia(iataConsortia);
        return this;
    }

    public void setIataConsortia(String iataConsortia) {
        this.iataConsortia = iataConsortia;
    }

    public String getPsuedoProfileYn() {
        return this.psuedoProfileYn;
    }

    public Name psuedoProfileYn(String psuedoProfileYn) {
        this.setPsuedoProfileYn(psuedoProfileYn);
        return this;
    }

    public void setPsuedoProfileYn(String psuedoProfileYn) {
        this.psuedoProfileYn = psuedoProfileYn;
    }

    public String getProfilePrivacyFlg() {
        return this.profilePrivacyFlg;
    }

    public Name profilePrivacyFlg(String profilePrivacyFlg) {
        this.setProfilePrivacyFlg(profilePrivacyFlg);
        return this;
    }

    public void setProfilePrivacyFlg(String profilePrivacyFlg) {
        this.profilePrivacyFlg = profilePrivacyFlg;
    }

    public String getReplaceAddress() {
        return this.replaceAddress;
    }

    public Name replaceAddress(String replaceAddress) {
        this.setReplaceAddress(replaceAddress);
        return this;
    }

    public void setReplaceAddress(String replaceAddress) {
        this.replaceAddress = replaceAddress;
    }

    public String getAlienRegistrationNo() {
        return this.alienRegistrationNo;
    }

    public Name alienRegistrationNo(String alienRegistrationNo) {
        this.setAlienRegistrationNo(alienRegistrationNo);
        return this;
    }

    public void setAlienRegistrationNo(String alienRegistrationNo) {
        this.alienRegistrationNo = alienRegistrationNo;
    }

    public String getImmigrationStatus() {
        return this.immigrationStatus;
    }

    public Name immigrationStatus(String immigrationStatus) {
        this.setImmigrationStatus(immigrationStatus);
        return this;
    }

    public void setImmigrationStatus(String immigrationStatus) {
        this.immigrationStatus = immigrationStatus;
    }

    public String getVisaValidityType() {
        return this.visaValidityType;
    }

    public Name visaValidityType(String visaValidityType) {
        this.setVisaValidityType(visaValidityType);
        return this;
    }

    public void setVisaValidityType(String visaValidityType) {
        this.visaValidityType = visaValidityType;
    }

    public Integer getIdDocumentAttachId() {
        return this.idDocumentAttachId;
    }

    public Name idDocumentAttachId(Integer idDocumentAttachId) {
        this.setIdDocumentAttachId(idDocumentAttachId);
        return this;
    }

    public void setIdDocumentAttachId(Integer idDocumentAttachId) {
        this.idDocumentAttachId = idDocumentAttachId;
    }

    public String getSuperSearchIndexText() {
        return this.superSearchIndexText;
    }

    public Name superSearchIndexText(String superSearchIndexText) {
        this.setSuperSearchIndexText(superSearchIndexText);
        return this;
    }

    public void setSuperSearchIndexText(String superSearchIndexText) {
        this.superSearchIndexText = superSearchIndexText;
    }

    public String getBirthDateStr() {
        return this.birthDateStr;
    }

    public Name birthDateStr(String birthDateStr) {
        this.setBirthDateStr(birthDateStr);
        return this;
    }

    public void setBirthDateStr(String birthDateStr) {
        this.birthDateStr = birthDateStr;
    }

    public Integer getOrigNameId() {
        return this.origNameId;
    }

    public Name origNameId(Integer origNameId) {
        this.setOrigNameId(origNameId);
        return this;
    }

    public void setOrigNameId(Integer origNameId) {
        this.origNameId = origNameId;
    }

    public String getdOptInMailListFlg() {
        return this.dOptInMailListFlg;
    }

    public Name dOptInMailListFlg(String dOptInMailListFlg) {
        this.setdOptInMailListFlg(dOptInMailListFlg);
        return this;
    }

    public void setdOptInMailListFlg(String dOptInMailListFlg) {
        this.dOptInMailListFlg = dOptInMailListFlg;
    }

    public String getdOptInMarketResearchFlg() {
        return this.dOptInMarketResearchFlg;
    }

    public Name dOptInMarketResearchFlg(String dOptInMarketResearchFlg) {
        this.setdOptInMarketResearchFlg(dOptInMarketResearchFlg);
        return this;
    }

    public void setdOptInMarketResearchFlg(String dOptInMarketResearchFlg) {
        this.dOptInMarketResearchFlg = dOptInMarketResearchFlg;
    }

    public String getdOptInThirdPartyFlg() {
        return this.dOptInThirdPartyFlg;
    }

    public Name dOptInThirdPartyFlg(String dOptInThirdPartyFlg) {
        this.setdOptInThirdPartyFlg(dOptInThirdPartyFlg);
        return this;
    }

    public void setdOptInThirdPartyFlg(String dOptInThirdPartyFlg) {
        this.dOptInThirdPartyFlg = dOptInThirdPartyFlg;
    }

    public String getdOptInAutoenrollMemberFlg() {
        return this.dOptInAutoenrollMemberFlg;
    }

    public Name dOptInAutoenrollMemberFlg(String dOptInAutoenrollMemberFlg) {
        this.setdOptInAutoenrollMemberFlg(dOptInAutoenrollMemberFlg);
        return this;
    }

    public void setdOptInAutoenrollMemberFlg(String dOptInAutoenrollMemberFlg) {
        this.dOptInAutoenrollMemberFlg = dOptInAutoenrollMemberFlg;
    }

    public String getdOptInEmailFlg() {
        return this.dOptInEmailFlg;
    }

    public Name dOptInEmailFlg(String dOptInEmailFlg) {
        this.setdOptInEmailFlg(dOptInEmailFlg);
        return this;
    }

    public void setdOptInEmailFlg(String dOptInEmailFlg) {
        this.dOptInEmailFlg = dOptInEmailFlg;
    }

    public String getdOptInPhoneFlg() {
        return this.dOptInPhoneFlg;
    }

    public Name dOptInPhoneFlg(String dOptInPhoneFlg) {
        this.setdOptInPhoneFlg(dOptInPhoneFlg);
        return this;
    }

    public void setdOptInPhoneFlg(String dOptInPhoneFlg) {
        this.dOptInPhoneFlg = dOptInPhoneFlg;
    }

    public String getdOptInSmsFlg() {
        return this.dOptInSmsFlg;
    }

    public Name dOptInSmsFlg(String dOptInSmsFlg) {
        this.setdOptInSmsFlg(dOptInSmsFlg);
        return this;
    }

    public void setdOptInSmsFlg(String dOptInSmsFlg) {
        this.dOptInSmsFlg = dOptInSmsFlg;
    }

    public String getdOptInGuestPrivFlg() {
        return this.dOptInGuestPrivFlg;
    }

    public Name dOptInGuestPrivFlg(String dOptInGuestPrivFlg) {
        this.setdOptInGuestPrivFlg(dOptInGuestPrivFlg);
        return this;
    }

    public void setdOptInGuestPrivFlg(String dOptInGuestPrivFlg) {
        this.dOptInGuestPrivFlg = dOptInGuestPrivFlg;
    }

    public String getArCreditLimitYn() {
        return this.arCreditLimitYn;
    }

    public Name arCreditLimitYn(String arCreditLimitYn) {
        this.setArCreditLimitYn(arCreditLimitYn);
        return this;
    }

    public void setArCreditLimitYn(String arCreditLimitYn) {
        this.arCreditLimitYn = arCreditLimitYn;
    }

    public Integer getProfileCreditLimit() {
        return this.profileCreditLimit;
    }

    public Name profileCreditLimit(Integer profileCreditLimit) {
        this.setProfileCreditLimit(profileCreditLimit);
        return this;
    }

    public void setProfileCreditLimit(Integer profileCreditLimit) {
        this.profileCreditLimit = profileCreditLimit;
    }

    public String getXmiddleName() {
        return this.xmiddleName;
    }

    public Name xmiddleName(String xmiddleName) {
        this.setXmiddleName(xmiddleName);
        return this;
    }

    public void setXmiddleName(String xmiddleName) {
        this.xmiddleName = xmiddleName;
    }

    public String geteInvoiceLiableYn() {
        return this.eInvoiceLiableYn;
    }

    public Name eInvoiceLiableYn(String eInvoiceLiableYn) {
        this.seteInvoiceLiableYn(eInvoiceLiableYn);
        return this;
    }

    public void seteInvoiceLiableYn(String eInvoiceLiableYn) {
        this.eInvoiceLiableYn = eInvoiceLiableYn;
    }

    public LocalDate geteInvLiableLastUpdated() {
        return this.eInvLiableLastUpdated;
    }

    public Name eInvLiableLastUpdated(LocalDate eInvLiableLastUpdated) {
        this.seteInvLiableLastUpdated(eInvLiableLastUpdated);
        return this;
    }

    public void seteInvLiableLastUpdated(LocalDate eInvLiableLastUpdated) {
        this.eInvLiableLastUpdated = eInvLiableLastUpdated;
    }

    public String getInternalBillYn() {
        return this.internalBillYn;
    }

    public Name internalBillYn(String internalBillYn) {
        this.setInternalBillYn(internalBillYn);
        return this;
    }

    public void setInternalBillYn(String internalBillYn) {
        this.internalBillYn = internalBillYn;
    }

    public String getCompPreApprovalRequiredYn() {
        return this.compPreApprovalRequiredYn;
    }

    public Name compPreApprovalRequiredYn(String compPreApprovalRequiredYn) {
        this.setCompPreApprovalRequiredYn(compPreApprovalRequiredYn);
        return this;
    }

    public void setCompPreApprovalRequiredYn(String compPreApprovalRequiredYn) {
        this.compPreApprovalRequiredYn = compPreApprovalRequiredYn;
    }

    public String getAnonymizationStatus() {
        return this.anonymizationStatus;
    }

    public Name anonymizationStatus(String anonymizationStatus) {
        this.setAnonymizationStatus(anonymizationStatus);
        return this;
    }

    public void setAnonymizationStatus(String anonymizationStatus) {
        this.anonymizationStatus = anonymizationStatus;
    }

    public LocalDate getAnonymizationDate() {
        return this.anonymizationDate;
    }

    public Name anonymizationDate(LocalDate anonymizationDate) {
        this.setAnonymizationDate(anonymizationDate);
        return this;
    }

    public void setAnonymizationDate(LocalDate anonymizationDate) {
        this.anonymizationDate = anonymizationDate;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        return getId() != null && getId().equals(((Name) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Name{" +
            "id=" + getId() +
            ", nameId=" + getNameId() +
            ", nameCode='" + getNameCode() + "'" +
            ", insertUser=" + getInsertUser() +
            ", insertDate='" + getInsertDate() + "'" +
            ", updateUser=" + getUpdateUser() +
            ", updateDate='" + getUpdateDate() + "'" +
            ", primaryNameId=" + getPrimaryNameId() +
            ", repeatGuestId='" + getRepeatGuestId() + "'" +
            ", mailList='" + getMailList() + "'" +
            ", mailType='" + getMailType() + "'" +
            ", followOn='" + getFollowOn() + "'" +
            ", businessTitle='" + getBusinessTitle() + "'" +
            ", inactiveDate='" + getInactiveDate() + "'" +
            ", arcUpdateDate='" + getArcUpdateDate() + "'" +
            ", updateFaxDate='" + getUpdateFaxDate() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", collectionUserId=" + getCollectionUserId() +
            ", company='" + getCompany() + "'" +
            ", soundExCompany='" + getSoundExCompany() + "'" +
            ", legalCompany='" + getLegalCompany() + "'" +
            ", first='" + getFirst() + "'" +
            ", middle='" + getMiddle() + "'" +
            ", last='" + getLast() + "'" +
            ", nickname='" + getNickname() + "'" +
            ", title='" + getTitle() + "'" +
            ", soundExLast='" + getSoundExLast() + "'" +
            ", externalReferenceRequ='" + getExternalReferenceRequ() + "'" +
            ", vipStatus='" + getVipStatus() + "'" +
            ", vipAuthorization='" + getVipAuthorization() + "'" +
            ", billingProfileCode='" + getBillingProfileCode() + "'" +
            ", rateStructure='" + getRateStructure() + "'" +
            ", nameComment='" + getNameComment() + "'" +
            ", tourOperatorType='" + getTourOperatorType() + "'" +
            ", region='" + getRegion() + "'" +
            ", typeOf1099='" + getTypeOf1099() + "'" +
            ", tax1No='" + getTax1No() + "'" +
            ", companyNameId=" + getCompanyNameId() +
            ", externalReferenceRequired='" + getExternalReferenceRequired() + "'" +
            ", vendorId=" + getVendorId() +
            ", vendorSiteId=" + getVendorSiteId() +
            ", arcOfficeType='" + getArcOfficeType() + "'" +
            ", tax2No='" + getTax2No() + "'" +
            ", arcMailFlag='" + getArcMailFlag() + "'" +
            ", name2='" + getName2() + "'" +
            ", name3='" + getName3() + "'" +
            ", salesrep='" + getSalesrep() + "'" +
            ", tracecode='" + getTracecode() + "'" +
            ", geographicRegion='" + getGeographicRegion() + "'" +
            ", guestClassification='" + getGuestClassification() + "'" +
            ", primaryAddressId=" + getPrimaryAddressId() +
            ", primaryPhoneId=" + getPrimaryPhoneId() +
            ", taxExemptStatus='" + getTaxExemptStatus() + "'" +
            ", gdsName='" + getGdsName() + "'" +
            ", gdsTransactionNo='" + getGdsTransactionNo() + "'" +
            ", nationality='" + getNationality() + "'" +
            ", language='" + getLanguage() + "'" +
            ", salutation='" + getSalutation() + "'" +
            ", passport='" + getPassport() + "'" +
            ", historyYn='" + getHistoryYn() + "'" +
            ", resvContact='" + getResvContact() + "'" +
            ", contractNo='" + getContractNo() + "'" +
            ", contractRecvDate='" + getContractRecvDate() + "'" +
            ", acctContact='" + getAcctContact() + "'" +
            ", priority='" + getPriority() + "'" +
            ", industryCode='" + getIndustryCode() + "'" +
            ", roomsPotential='" + getRoomsPotential() + "'" +
            ", competitionCode='" + getCompetitionCode() + "'" +
            ", scope='" + getScope() + "'" +
            ", scopeCity='" + getScopeCity() + "'" +
            ", territory='" + getTerritory() + "'" +
            ", actioncode='" + getActioncode() + "'" +
            ", activeYn='" + getActiveYn() + "'" +
            ", masterAccountYn='" + getMasterAccountYn() + "'" +
            ", nameType='" + getNameType() + "'" +
            ", sname='" + getSname() + "'" +
            ", nameTaxType='" + getNameTaxType() + "'" +
            ", sfirst='" + getSfirst() + "'" +
            ", arNo='" + getArNo() + "'" +
            ", availabilityOverride='" + getAvailabilityOverride() + "'" +
            ", billingCode='" + getBillingCode() + "'" +
            ", cashBlInd='" + getCashBlInd() + "'" +
            ", blMsg='" + getBlMsg() + "'" +
            ", currencyCode='" + getCurrencyCode() + "'" +
            ", commissionCode='" + getCommissionCode() + "'" +
            ", holdCode='" + getHoldCode() + "'" +
            ", interest='" + getInterest() + "'" +
            ", summRefCc='" + getSummRefCc() + "'" +
            ", iataCompType='" + getIataCompType() + "'" +
            ", srepCode='" + getSrepCode() + "'" +
            ", accountsource='" + getAccountsource() + "'" +
            ", markets='" + getMarkets() + "'" +
            ", productInterest='" + getProductInterest() + "'" +
            ", keyword='" + getKeyword() + "'" +
            ", letterGreeting='" + getLetterGreeting() + "'" +
            ", influence='" + getInfluence() + "'" +
            ", deptId='" + getDeptId() + "'" +
            ", department='" + getDepartment() + "'" +
            ", contactYn='" + getContactYn() + "'" +
            ", accountType='" + getAccountType() + "'" +
            ", downloadResort='" + getDownloadResort() + "'" +
            ", downloadSrep=" + getDownloadSrep() +
            ", downloadDate='" + getDownloadDate() + "'" +
            ", uploadDate='" + getUploadDate() + "'" +
            ", laptopChange=" + getLaptopChange() +
            ", crsNameid=" + getCrsNameid() +
            ", commPayCentral='" + getCommPayCentral() + "'" +
            ", ccProfileYn='" + getCcProfileYn() + "'" +
            ", gender='" + getGender() + "'" +
            ", birthPlace='" + getBirthPlace() + "'" +
            ", birthCountry='" + getBirthCountry() + "'" +
            ", profession='" + getProfession() + "'" +
            ", idType='" + getIdType() + "'" +
            ", idNumber='" + getIdNumber() + "'" +
            ", idDate='" + getIdDate() + "'" +
            ", idPlace='" + getIdPlace() + "'" +
            ", idCountry='" + getIdCountry() + "'" +
            ", udfc01='" + getUdfc01() + "'" +
            ", udfc02='" + getUdfc02() + "'" +
            ", udfc03='" + getUdfc03() + "'" +
            ", udfc04='" + getUdfc04() + "'" +
            ", udfc05='" + getUdfc05() + "'" +
            ", udfc06='" + getUdfc06() + "'" +
            ", udfc07='" + getUdfc07() + "'" +
            ", udfc08='" + getUdfc08() + "'" +
            ", udfc09='" + getUdfc09() + "'" +
            ", udfc10='" + getUdfc10() + "'" +
            ", udfc11='" + getUdfc11() + "'" +
            ", udfc12='" + getUdfc12() + "'" +
            ", udfc13='" + getUdfc13() + "'" +
            ", udfc14='" + getUdfc14() + "'" +
            ", udfc15='" + getUdfc15() + "'" +
            ", udfc16='" + getUdfc16() + "'" +
            ", udfc17='" + getUdfc17() + "'" +
            ", udfc18='" + getUdfc18() + "'" +
            ", udfc19='" + getUdfc19() + "'" +
            ", udfc20='" + getUdfc20() + "'" +
            ", udfc21='" + getUdfc21() + "'" +
            ", udfc22='" + getUdfc22() + "'" +
            ", udfc23='" + getUdfc23() + "'" +
            ", udfc24='" + getUdfc24() + "'" +
            ", udfc25='" + getUdfc25() + "'" +
            ", udfc26='" + getUdfc26() + "'" +
            ", udfc27='" + getUdfc27() + "'" +
            ", udfc28='" + getUdfc28() + "'" +
            ", udfc29='" + getUdfc29() + "'" +
            ", udfc30='" + getUdfc30() + "'" +
            ", udfc31='" + getUdfc31() + "'" +
            ", udfc32='" + getUdfc32() + "'" +
            ", udfc33='" + getUdfc33() + "'" +
            ", udfc34='" + getUdfc34() + "'" +
            ", udfc35='" + getUdfc35() + "'" +
            ", udfc36='" + getUdfc36() + "'" +
            ", udfc37='" + getUdfc37() + "'" +
            ", udfc38='" + getUdfc38() + "'" +
            ", udfc39='" + getUdfc39() + "'" +
            ", udfc40='" + getUdfc40() + "'" +
            ", udfn01=" + getUdfn01() +
            ", udfn02=" + getUdfn02() +
            ", udfn03=" + getUdfn03() +
            ", udfn04=" + getUdfn04() +
            ", udfn05=" + getUdfn05() +
            ", udfn06=" + getUdfn06() +
            ", udfn07=" + getUdfn07() +
            ", udfn08=" + getUdfn08() +
            ", udfn09=" + getUdfn09() +
            ", udfn10=" + getUdfn10() +
            ", udfn11=" + getUdfn11() +
            ", udfn12=" + getUdfn12() +
            ", udfn13=" + getUdfn13() +
            ", udfn14=" + getUdfn14() +
            ", udfn15=" + getUdfn15() +
            ", udfn16=" + getUdfn16() +
            ", udfn17=" + getUdfn17() +
            ", udfn18=" + getUdfn18() +
            ", udfn19=" + getUdfn19() +
            ", udfn20=" + getUdfn20() +
            ", udfn21=" + getUdfn21() +
            ", udfn22=" + getUdfn22() +
            ", udfn23=" + getUdfn23() +
            ", udfn24=" + getUdfn24() +
            ", udfn25=" + getUdfn25() +
            ", udfn26=" + getUdfn26() +
            ", udfn27=" + getUdfn27() +
            ", udfn28=" + getUdfn28() +
            ", udfn29=" + getUdfn29() +
            ", udfn30=" + getUdfn30() +
            ", udfn31=" + getUdfn31() +
            ", udfn32=" + getUdfn32() +
            ", udfn33=" + getUdfn33() +
            ", udfn34=" + getUdfn34() +
            ", udfn35=" + getUdfn35() +
            ", udfn36=" + getUdfn36() +
            ", udfn37=" + getUdfn37() +
            ", udfn38=" + getUdfn38() +
            ", udfn39=" + getUdfn39() +
            ", udfn40=" + getUdfn40() +
            ", udfd01='" + getUdfd01() + "'" +
            ", udfd02='" + getUdfd02() + "'" +
            ", udfd03='" + getUdfd03() + "'" +
            ", udfd04='" + getUdfd04() + "'" +
            ", udfd05='" + getUdfd05() + "'" +
            ", udfd06='" + getUdfd06() + "'" +
            ", udfd07='" + getUdfd07() + "'" +
            ", udfd08='" + getUdfd08() + "'" +
            ", udfd09='" + getUdfd09() + "'" +
            ", udfd10='" + getUdfd10() + "'" +
            ", udfd11='" + getUdfd11() + "'" +
            ", udfd12='" + getUdfd12() + "'" +
            ", udfd13='" + getUdfd13() + "'" +
            ", udfd14='" + getUdfd14() + "'" +
            ", udfd15='" + getUdfd15() + "'" +
            ", udfd16='" + getUdfd16() + "'" +
            ", udfd17='" + getUdfd17() + "'" +
            ", udfd18='" + getUdfd18() + "'" +
            ", udfd19='" + getUdfd19() + "'" +
            ", udfd20='" + getUdfd20() + "'" +
            ", paymentDueDays=" + getPaymentDueDays() +
            ", suffix='" + getSuffix() + "'" +
            ", externalId='" + getExternalId() + "'" +
            ", guestPrivYn='" + getGuestPrivYn() + "'" +
            ", emailYn='" + getEmailYn() + "'" +
            ", mailYn='" + getMailYn() + "'" +
            ", indexName='" + getIndexName() + "'" +
            ", xlastName='" + getXlastName() + "'" +
            ", xfirstName='" + getXfirstName() + "'" +
            ", xcompanyName='" + getXcompanyName() + "'" +
            ", xtitle='" + getXtitle() + "'" +
            ", xsalutation='" + getXsalutation() + "'" +
            ", sxname='" + getSxname() + "'" +
            ", sxfirstName='" + getSxfirstName() + "'" +
            ", lastUpdatedResort='" + getLastUpdatedResort() + "'" +
            ", envelopeGreeting='" + getEnvelopeGreeting() + "'" +
            ", xenvelopeGreeting='" + getXenvelopeGreeting() + "'" +
            ", directBillBatchType='" + getDirectBillBatchType() + "'" +
            ", resortRegistered='" + getResortRegistered() + "'" +
            ", taxOffice='" + getTaxOffice() + "'" +
            ", taxType='" + getTaxType() + "'" +
            ", taxCategory='" + getTaxCategory() + "'" +
            ", preferredRoomNo='" + getPreferredRoomNo() + "'" +
            ", phoneYn='" + getPhoneYn() + "'" +
            ", smsYn='" + getSmsYn() + "'" +
            ", isProtected='" + getIsProtected() + "'" +
            ", xlanguage='" + getXlanguage() + "'" +
            ", marketResearchYn='" + getMarketResearchYn() + "'" +
            ", thirdPartyYn='" + getThirdPartyYn() + "'" +
            ", autoenrollMemberYn='" + getAutoenrollMemberYn() + "'" +
            ", chainCode='" + getChainCode() + "'" +
            ", companyGroupId='" + getCompanyGroupId() + "'" +
            ", includeIn1099Yn='" + getIncludeIn1099Yn() + "'" +
            ", creditRating='" + getCreditRating() + "'" +
            ", titleSuffix=" + getTitleSuffix() +
            ", inactiveReason='" + getInactiveReason() + "'" +
            ", iataConsortia='" + getIataConsortia() + "'" +
            ", psuedoProfileYn='" + getPsuedoProfileYn() + "'" +
            ", profilePrivacyFlg='" + getProfilePrivacyFlg() + "'" +
            ", replaceAddress='" + getReplaceAddress() + "'" +
            ", alienRegistrationNo='" + getAlienRegistrationNo() + "'" +
            ", immigrationStatus='" + getImmigrationStatus() + "'" +
            ", visaValidityType='" + getVisaValidityType() + "'" +
            ", idDocumentAttachId=" + getIdDocumentAttachId() +
            ", superSearchIndexText='" + getSuperSearchIndexText() + "'" +
            ", birthDateStr='" + getBirthDateStr() + "'" +
            ", origNameId=" + getOrigNameId() +
            ", dOptInMailListFlg='" + getdOptInMailListFlg() + "'" +
            ", dOptInMarketResearchFlg='" + getdOptInMarketResearchFlg() + "'" +
            ", dOptInThirdPartyFlg='" + getdOptInThirdPartyFlg() + "'" +
            ", dOptInAutoenrollMemberFlg='" + getdOptInAutoenrollMemberFlg() + "'" +
            ", dOptInEmailFlg='" + getdOptInEmailFlg() + "'" +
            ", dOptInPhoneFlg='" + getdOptInPhoneFlg() + "'" +
            ", dOptInSmsFlg='" + getdOptInSmsFlg() + "'" +
            ", dOptInGuestPrivFlg='" + getdOptInGuestPrivFlg() + "'" +
            ", arCreditLimitYn='" + getArCreditLimitYn() + "'" +
            ", profileCreditLimit=" + getProfileCreditLimit() +
            ", xmiddleName='" + getXmiddleName() + "'" +
            ", eInvoiceLiableYn='" + geteInvoiceLiableYn() + "'" +
            ", eInvLiableLastUpdated='" + geteInvLiableLastUpdated() + "'" +
            ", internalBillYn='" + getInternalBillYn() + "'" +
            ", compPreApprovalRequiredYn='" + getCompPreApprovalRequiredYn() + "'" +
            ", anonymizationStatus='" + getAnonymizationStatus() + "'" +
            ", anonymizationDate='" + getAnonymizationDate() + "'" +
            "}";
    }
}
