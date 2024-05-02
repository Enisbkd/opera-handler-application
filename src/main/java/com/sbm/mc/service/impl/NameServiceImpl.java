package com.sbm.mc.service.impl;

import com.sbm.mc.domain.Name;
import com.sbm.mc.repository.NameRepository;
import com.sbm.mc.service.NameService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.Name}.
 */
@Service
@Transactional
public class NameServiceImpl implements NameService {

    private final Logger log = LoggerFactory.getLogger(NameServiceImpl.class);

    private final NameRepository nameRepository;

    public NameServiceImpl(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @Override
    public Name save(Name name) {
        log.debug("Request to save Name : {}", name);
        return nameRepository.save(name);
    }

    @Override
    public Name update(Name name) {
        log.debug("Request to update Name : {}", name);
        return nameRepository.save(name);
    }

    @Override
    public Optional<Name> partialUpdate(Name name) {
        log.debug("Request to partially update Name : {}", name);

        return nameRepository
            .findById(name.getId())
            .map(existingName -> {
                if (name.getNameId() != null) {
                    existingName.setNameId(name.getNameId());
                }
                if (name.getNameCode() != null) {
                    existingName.setNameCode(name.getNameCode());
                }
                if (name.getInsertUser() != null) {
                    existingName.setInsertUser(name.getInsertUser());
                }
                if (name.getInsertDate() != null) {
                    existingName.setInsertDate(name.getInsertDate());
                }
                if (name.getUpdateUser() != null) {
                    existingName.setUpdateUser(name.getUpdateUser());
                }
                if (name.getUpdateDate() != null) {
                    existingName.setUpdateDate(name.getUpdateDate());
                }
                if (name.getPrimaryNameId() != null) {
                    existingName.setPrimaryNameId(name.getPrimaryNameId());
                }
                if (name.getRepeatGuestId() != null) {
                    existingName.setRepeatGuestId(name.getRepeatGuestId());
                }
                if (name.getMailList() != null) {
                    existingName.setMailList(name.getMailList());
                }
                if (name.getMailType() != null) {
                    existingName.setMailType(name.getMailType());
                }
                if (name.getFollowOn() != null) {
                    existingName.setFollowOn(name.getFollowOn());
                }
                if (name.getBusinessTitle() != null) {
                    existingName.setBusinessTitle(name.getBusinessTitle());
                }
                if (name.getInactiveDate() != null) {
                    existingName.setInactiveDate(name.getInactiveDate());
                }
                if (name.getArcUpdateDate() != null) {
                    existingName.setArcUpdateDate(name.getArcUpdateDate());
                }
                if (name.getUpdateFaxDate() != null) {
                    existingName.setUpdateFaxDate(name.getUpdateFaxDate());
                }
                if (name.getBirthDate() != null) {
                    existingName.setBirthDate(name.getBirthDate());
                }
                if (name.getCollectionUserId() != null) {
                    existingName.setCollectionUserId(name.getCollectionUserId());
                }
                if (name.getCompany() != null) {
                    existingName.setCompany(name.getCompany());
                }
                if (name.getSoundExCompany() != null) {
                    existingName.setSoundExCompany(name.getSoundExCompany());
                }
                if (name.getLegalCompany() != null) {
                    existingName.setLegalCompany(name.getLegalCompany());
                }
                if (name.getFirst() != null) {
                    existingName.setFirst(name.getFirst());
                }
                if (name.getMiddle() != null) {
                    existingName.setMiddle(name.getMiddle());
                }
                if (name.getLast() != null) {
                    existingName.setLast(name.getLast());
                }
                if (name.getNickname() != null) {
                    existingName.setNickname(name.getNickname());
                }
                if (name.getTitle() != null) {
                    existingName.setTitle(name.getTitle());
                }
                if (name.getSoundExLast() != null) {
                    existingName.setSoundExLast(name.getSoundExLast());
                }
                if (name.getExternalReferenceRequ() != null) {
                    existingName.setExternalReferenceRequ(name.getExternalReferenceRequ());
                }
                if (name.getVipStatus() != null) {
                    existingName.setVipStatus(name.getVipStatus());
                }
                if (name.getVipAuthorization() != null) {
                    existingName.setVipAuthorization(name.getVipAuthorization());
                }
                if (name.getBillingProfileCode() != null) {
                    existingName.setBillingProfileCode(name.getBillingProfileCode());
                }
                if (name.getRateStructure() != null) {
                    existingName.setRateStructure(name.getRateStructure());
                }
                if (name.getNameComment() != null) {
                    existingName.setNameComment(name.getNameComment());
                }
                if (name.getTourOperatorType() != null) {
                    existingName.setTourOperatorType(name.getTourOperatorType());
                }
                if (name.getRegion() != null) {
                    existingName.setRegion(name.getRegion());
                }
                if (name.getTypeOf1099() != null) {
                    existingName.setTypeOf1099(name.getTypeOf1099());
                }
                if (name.getTax1No() != null) {
                    existingName.setTax1No(name.getTax1No());
                }
                if (name.getCompanyNameId() != null) {
                    existingName.setCompanyNameId(name.getCompanyNameId());
                }
                if (name.getExternalReferenceRequired() != null) {
                    existingName.setExternalReferenceRequired(name.getExternalReferenceRequired());
                }
                if (name.getVendorId() != null) {
                    existingName.setVendorId(name.getVendorId());
                }
                if (name.getVendorSiteId() != null) {
                    existingName.setVendorSiteId(name.getVendorSiteId());
                }
                if (name.getArcOfficeType() != null) {
                    existingName.setArcOfficeType(name.getArcOfficeType());
                }
                if (name.getTax2No() != null) {
                    existingName.setTax2No(name.getTax2No());
                }
                if (name.getArcMailFlag() != null) {
                    existingName.setArcMailFlag(name.getArcMailFlag());
                }
                if (name.getName2() != null) {
                    existingName.setName2(name.getName2());
                }
                if (name.getName3() != null) {
                    existingName.setName3(name.getName3());
                }
                if (name.getSalesrep() != null) {
                    existingName.setSalesrep(name.getSalesrep());
                }
                if (name.getTracecode() != null) {
                    existingName.setTracecode(name.getTracecode());
                }
                if (name.getGeographicRegion() != null) {
                    existingName.setGeographicRegion(name.getGeographicRegion());
                }
                if (name.getGuestClassification() != null) {
                    existingName.setGuestClassification(name.getGuestClassification());
                }
                if (name.getPrimaryAddressId() != null) {
                    existingName.setPrimaryAddressId(name.getPrimaryAddressId());
                }
                if (name.getPrimaryPhoneId() != null) {
                    existingName.setPrimaryPhoneId(name.getPrimaryPhoneId());
                }
                if (name.getTaxExemptStatus() != null) {
                    existingName.setTaxExemptStatus(name.getTaxExemptStatus());
                }
                if (name.getGdsName() != null) {
                    existingName.setGdsName(name.getGdsName());
                }
                if (name.getGdsTransactionNo() != null) {
                    existingName.setGdsTransactionNo(name.getGdsTransactionNo());
                }
                if (name.getNationality() != null) {
                    existingName.setNationality(name.getNationality());
                }
                if (name.getLanguage() != null) {
                    existingName.setLanguage(name.getLanguage());
                }
                if (name.getSalutation() != null) {
                    existingName.setSalutation(name.getSalutation());
                }
                if (name.getPassport() != null) {
                    existingName.setPassport(name.getPassport());
                }
                if (name.getHistoryYn() != null) {
                    existingName.setHistoryYn(name.getHistoryYn());
                }
                if (name.getResvContact() != null) {
                    existingName.setResvContact(name.getResvContact());
                }
                if (name.getContractNo() != null) {
                    existingName.setContractNo(name.getContractNo());
                }
                if (name.getContractRecvDate() != null) {
                    existingName.setContractRecvDate(name.getContractRecvDate());
                }
                if (name.getAcctContact() != null) {
                    existingName.setAcctContact(name.getAcctContact());
                }
                if (name.getPriority() != null) {
                    existingName.setPriority(name.getPriority());
                }
                if (name.getIndustryCode() != null) {
                    existingName.setIndustryCode(name.getIndustryCode());
                }
                if (name.getRoomsPotential() != null) {
                    existingName.setRoomsPotential(name.getRoomsPotential());
                }
                if (name.getCompetitionCode() != null) {
                    existingName.setCompetitionCode(name.getCompetitionCode());
                }
                if (name.getScope() != null) {
                    existingName.setScope(name.getScope());
                }
                if (name.getScopeCity() != null) {
                    existingName.setScopeCity(name.getScopeCity());
                }
                if (name.getTerritory() != null) {
                    existingName.setTerritory(name.getTerritory());
                }
                if (name.getActioncode() != null) {
                    existingName.setActioncode(name.getActioncode());
                }
                if (name.getActiveYn() != null) {
                    existingName.setActiveYn(name.getActiveYn());
                }
                if (name.getMasterAccountYn() != null) {
                    existingName.setMasterAccountYn(name.getMasterAccountYn());
                }
                if (name.getNameType() != null) {
                    existingName.setNameType(name.getNameType());
                }
                if (name.getSname() != null) {
                    existingName.setSname(name.getSname());
                }
                if (name.getNameTaxType() != null) {
                    existingName.setNameTaxType(name.getNameTaxType());
                }
                if (name.getSfirst() != null) {
                    existingName.setSfirst(name.getSfirst());
                }
                if (name.getArNo() != null) {
                    existingName.setArNo(name.getArNo());
                }
                if (name.getAvailabilityOverride() != null) {
                    existingName.setAvailabilityOverride(name.getAvailabilityOverride());
                }
                if (name.getBillingCode() != null) {
                    existingName.setBillingCode(name.getBillingCode());
                }
                if (name.getCashBlInd() != null) {
                    existingName.setCashBlInd(name.getCashBlInd());
                }
                if (name.getBlMsg() != null) {
                    existingName.setBlMsg(name.getBlMsg());
                }
                if (name.getCurrencyCode() != null) {
                    existingName.setCurrencyCode(name.getCurrencyCode());
                }
                if (name.getCommissionCode() != null) {
                    existingName.setCommissionCode(name.getCommissionCode());
                }
                if (name.getHoldCode() != null) {
                    existingName.setHoldCode(name.getHoldCode());
                }
                if (name.getInterest() != null) {
                    existingName.setInterest(name.getInterest());
                }
                if (name.getSummRefCc() != null) {
                    existingName.setSummRefCc(name.getSummRefCc());
                }
                if (name.getIataCompType() != null) {
                    existingName.setIataCompType(name.getIataCompType());
                }
                if (name.getSrepCode() != null) {
                    existingName.setSrepCode(name.getSrepCode());
                }
                if (name.getAccountsource() != null) {
                    existingName.setAccountsource(name.getAccountsource());
                }
                if (name.getMarkets() != null) {
                    existingName.setMarkets(name.getMarkets());
                }
                if (name.getProductInterest() != null) {
                    existingName.setProductInterest(name.getProductInterest());
                }
                if (name.getKeyword() != null) {
                    existingName.setKeyword(name.getKeyword());
                }
                if (name.getLetterGreeting() != null) {
                    existingName.setLetterGreeting(name.getLetterGreeting());
                }
                if (name.getInfluence() != null) {
                    existingName.setInfluence(name.getInfluence());
                }
                if (name.getDeptId() != null) {
                    existingName.setDeptId(name.getDeptId());
                }
                if (name.getDepartment() != null) {
                    existingName.setDepartment(name.getDepartment());
                }
                if (name.getContactYn() != null) {
                    existingName.setContactYn(name.getContactYn());
                }
                if (name.getAccountType() != null) {
                    existingName.setAccountType(name.getAccountType());
                }
                if (name.getDownloadResort() != null) {
                    existingName.setDownloadResort(name.getDownloadResort());
                }
                if (name.getDownloadSrep() != null) {
                    existingName.setDownloadSrep(name.getDownloadSrep());
                }
                if (name.getDownloadDate() != null) {
                    existingName.setDownloadDate(name.getDownloadDate());
                }
                if (name.getUploadDate() != null) {
                    existingName.setUploadDate(name.getUploadDate());
                }
                if (name.getLaptopChange() != null) {
                    existingName.setLaptopChange(name.getLaptopChange());
                }
                if (name.getCrsNameid() != null) {
                    existingName.setCrsNameid(name.getCrsNameid());
                }
                if (name.getCommPayCentral() != null) {
                    existingName.setCommPayCentral(name.getCommPayCentral());
                }
                if (name.getCcProfileYn() != null) {
                    existingName.setCcProfileYn(name.getCcProfileYn());
                }
                if (name.getGender() != null) {
                    existingName.setGender(name.getGender());
                }
                if (name.getBirthPlace() != null) {
                    existingName.setBirthPlace(name.getBirthPlace());
                }
                if (name.getBirthCountry() != null) {
                    existingName.setBirthCountry(name.getBirthCountry());
                }
                if (name.getProfession() != null) {
                    existingName.setProfession(name.getProfession());
                }
                if (name.getIdType() != null) {
                    existingName.setIdType(name.getIdType());
                }
                if (name.getIdNumber() != null) {
                    existingName.setIdNumber(name.getIdNumber());
                }
                if (name.getIdDate() != null) {
                    existingName.setIdDate(name.getIdDate());
                }
                if (name.getIdPlace() != null) {
                    existingName.setIdPlace(name.getIdPlace());
                }
                if (name.getIdCountry() != null) {
                    existingName.setIdCountry(name.getIdCountry());
                }
                if (name.getUdfc01() != null) {
                    existingName.setUdfc01(name.getUdfc01());
                }
                if (name.getUdfc02() != null) {
                    existingName.setUdfc02(name.getUdfc02());
                }
                if (name.getUdfc03() != null) {
                    existingName.setUdfc03(name.getUdfc03());
                }
                if (name.getUdfc04() != null) {
                    existingName.setUdfc04(name.getUdfc04());
                }
                if (name.getUdfc05() != null) {
                    existingName.setUdfc05(name.getUdfc05());
                }
                if (name.getUdfc06() != null) {
                    existingName.setUdfc06(name.getUdfc06());
                }
                if (name.getUdfc07() != null) {
                    existingName.setUdfc07(name.getUdfc07());
                }
                if (name.getUdfc08() != null) {
                    existingName.setUdfc08(name.getUdfc08());
                }
                if (name.getUdfc09() != null) {
                    existingName.setUdfc09(name.getUdfc09());
                }
                if (name.getUdfc10() != null) {
                    existingName.setUdfc10(name.getUdfc10());
                }
                if (name.getUdfc11() != null) {
                    existingName.setUdfc11(name.getUdfc11());
                }
                if (name.getUdfc12() != null) {
                    existingName.setUdfc12(name.getUdfc12());
                }
                if (name.getUdfc13() != null) {
                    existingName.setUdfc13(name.getUdfc13());
                }
                if (name.getUdfc14() != null) {
                    existingName.setUdfc14(name.getUdfc14());
                }
                if (name.getUdfc15() != null) {
                    existingName.setUdfc15(name.getUdfc15());
                }
                if (name.getUdfc16() != null) {
                    existingName.setUdfc16(name.getUdfc16());
                }
                if (name.getUdfc17() != null) {
                    existingName.setUdfc17(name.getUdfc17());
                }
                if (name.getUdfc18() != null) {
                    existingName.setUdfc18(name.getUdfc18());
                }
                if (name.getUdfc19() != null) {
                    existingName.setUdfc19(name.getUdfc19());
                }
                if (name.getUdfc20() != null) {
                    existingName.setUdfc20(name.getUdfc20());
                }
                if (name.getUdfc21() != null) {
                    existingName.setUdfc21(name.getUdfc21());
                }
                if (name.getUdfc22() != null) {
                    existingName.setUdfc22(name.getUdfc22());
                }
                if (name.getUdfc23() != null) {
                    existingName.setUdfc23(name.getUdfc23());
                }
                if (name.getUdfc24() != null) {
                    existingName.setUdfc24(name.getUdfc24());
                }
                if (name.getUdfc25() != null) {
                    existingName.setUdfc25(name.getUdfc25());
                }
                if (name.getUdfc26() != null) {
                    existingName.setUdfc26(name.getUdfc26());
                }
                if (name.getUdfc27() != null) {
                    existingName.setUdfc27(name.getUdfc27());
                }
                if (name.getUdfc28() != null) {
                    existingName.setUdfc28(name.getUdfc28());
                }
                if (name.getUdfc29() != null) {
                    existingName.setUdfc29(name.getUdfc29());
                }
                if (name.getUdfc30() != null) {
                    existingName.setUdfc30(name.getUdfc30());
                }
                if (name.getUdfc31() != null) {
                    existingName.setUdfc31(name.getUdfc31());
                }
                if (name.getUdfc32() != null) {
                    existingName.setUdfc32(name.getUdfc32());
                }
                if (name.getUdfc33() != null) {
                    existingName.setUdfc33(name.getUdfc33());
                }
                if (name.getUdfc34() != null) {
                    existingName.setUdfc34(name.getUdfc34());
                }
                if (name.getUdfc35() != null) {
                    existingName.setUdfc35(name.getUdfc35());
                }
                if (name.getUdfc36() != null) {
                    existingName.setUdfc36(name.getUdfc36());
                }
                if (name.getUdfc37() != null) {
                    existingName.setUdfc37(name.getUdfc37());
                }
                if (name.getUdfc38() != null) {
                    existingName.setUdfc38(name.getUdfc38());
                }
                if (name.getUdfc39() != null) {
                    existingName.setUdfc39(name.getUdfc39());
                }
                if (name.getUdfc40() != null) {
                    existingName.setUdfc40(name.getUdfc40());
                }
                if (name.getUdfn01() != null) {
                    existingName.setUdfn01(name.getUdfn01());
                }
                if (name.getUdfn02() != null) {
                    existingName.setUdfn02(name.getUdfn02());
                }
                if (name.getUdfn03() != null) {
                    existingName.setUdfn03(name.getUdfn03());
                }
                if (name.getUdfn04() != null) {
                    existingName.setUdfn04(name.getUdfn04());
                }
                if (name.getUdfn05() != null) {
                    existingName.setUdfn05(name.getUdfn05());
                }
                if (name.getUdfn06() != null) {
                    existingName.setUdfn06(name.getUdfn06());
                }
                if (name.getUdfn07() != null) {
                    existingName.setUdfn07(name.getUdfn07());
                }
                if (name.getUdfn08() != null) {
                    existingName.setUdfn08(name.getUdfn08());
                }
                if (name.getUdfn09() != null) {
                    existingName.setUdfn09(name.getUdfn09());
                }
                if (name.getUdfn10() != null) {
                    existingName.setUdfn10(name.getUdfn10());
                }
                if (name.getUdfn11() != null) {
                    existingName.setUdfn11(name.getUdfn11());
                }
                if (name.getUdfn12() != null) {
                    existingName.setUdfn12(name.getUdfn12());
                }
                if (name.getUdfn13() != null) {
                    existingName.setUdfn13(name.getUdfn13());
                }
                if (name.getUdfn14() != null) {
                    existingName.setUdfn14(name.getUdfn14());
                }
                if (name.getUdfn15() != null) {
                    existingName.setUdfn15(name.getUdfn15());
                }
                if (name.getUdfn16() != null) {
                    existingName.setUdfn16(name.getUdfn16());
                }
                if (name.getUdfn17() != null) {
                    existingName.setUdfn17(name.getUdfn17());
                }
                if (name.getUdfn18() != null) {
                    existingName.setUdfn18(name.getUdfn18());
                }
                if (name.getUdfn19() != null) {
                    existingName.setUdfn19(name.getUdfn19());
                }
                if (name.getUdfn20() != null) {
                    existingName.setUdfn20(name.getUdfn20());
                }
                if (name.getUdfn21() != null) {
                    existingName.setUdfn21(name.getUdfn21());
                }
                if (name.getUdfn22() != null) {
                    existingName.setUdfn22(name.getUdfn22());
                }
                if (name.getUdfn23() != null) {
                    existingName.setUdfn23(name.getUdfn23());
                }
                if (name.getUdfn24() != null) {
                    existingName.setUdfn24(name.getUdfn24());
                }
                if (name.getUdfn25() != null) {
                    existingName.setUdfn25(name.getUdfn25());
                }
                if (name.getUdfn26() != null) {
                    existingName.setUdfn26(name.getUdfn26());
                }
                if (name.getUdfn27() != null) {
                    existingName.setUdfn27(name.getUdfn27());
                }
                if (name.getUdfn28() != null) {
                    existingName.setUdfn28(name.getUdfn28());
                }
                if (name.getUdfn29() != null) {
                    existingName.setUdfn29(name.getUdfn29());
                }
                if (name.getUdfn30() != null) {
                    existingName.setUdfn30(name.getUdfn30());
                }
                if (name.getUdfn31() != null) {
                    existingName.setUdfn31(name.getUdfn31());
                }
                if (name.getUdfn32() != null) {
                    existingName.setUdfn32(name.getUdfn32());
                }
                if (name.getUdfn33() != null) {
                    existingName.setUdfn33(name.getUdfn33());
                }
                if (name.getUdfn34() != null) {
                    existingName.setUdfn34(name.getUdfn34());
                }
                if (name.getUdfn35() != null) {
                    existingName.setUdfn35(name.getUdfn35());
                }
                if (name.getUdfn36() != null) {
                    existingName.setUdfn36(name.getUdfn36());
                }
                if (name.getUdfn37() != null) {
                    existingName.setUdfn37(name.getUdfn37());
                }
                if (name.getUdfn38() != null) {
                    existingName.setUdfn38(name.getUdfn38());
                }
                if (name.getUdfn39() != null) {
                    existingName.setUdfn39(name.getUdfn39());
                }
                if (name.getUdfn40() != null) {
                    existingName.setUdfn40(name.getUdfn40());
                }
                if (name.getUdfd01() != null) {
                    existingName.setUdfd01(name.getUdfd01());
                }
                if (name.getUdfd02() != null) {
                    existingName.setUdfd02(name.getUdfd02());
                }
                if (name.getUdfd03() != null) {
                    existingName.setUdfd03(name.getUdfd03());
                }
                if (name.getUdfd04() != null) {
                    existingName.setUdfd04(name.getUdfd04());
                }
                if (name.getUdfd05() != null) {
                    existingName.setUdfd05(name.getUdfd05());
                }
                if (name.getUdfd06() != null) {
                    existingName.setUdfd06(name.getUdfd06());
                }
                if (name.getUdfd07() != null) {
                    existingName.setUdfd07(name.getUdfd07());
                }
                if (name.getUdfd08() != null) {
                    existingName.setUdfd08(name.getUdfd08());
                }
                if (name.getUdfd09() != null) {
                    existingName.setUdfd09(name.getUdfd09());
                }
                if (name.getUdfd10() != null) {
                    existingName.setUdfd10(name.getUdfd10());
                }
                if (name.getUdfd11() != null) {
                    existingName.setUdfd11(name.getUdfd11());
                }
                if (name.getUdfd12() != null) {
                    existingName.setUdfd12(name.getUdfd12());
                }
                if (name.getUdfd13() != null) {
                    existingName.setUdfd13(name.getUdfd13());
                }
                if (name.getUdfd14() != null) {
                    existingName.setUdfd14(name.getUdfd14());
                }
                if (name.getUdfd15() != null) {
                    existingName.setUdfd15(name.getUdfd15());
                }
                if (name.getUdfd16() != null) {
                    existingName.setUdfd16(name.getUdfd16());
                }
                if (name.getUdfd17() != null) {
                    existingName.setUdfd17(name.getUdfd17());
                }
                if (name.getUdfd18() != null) {
                    existingName.setUdfd18(name.getUdfd18());
                }
                if (name.getUdfd19() != null) {
                    existingName.setUdfd19(name.getUdfd19());
                }
                if (name.getUdfd20() != null) {
                    existingName.setUdfd20(name.getUdfd20());
                }
                if (name.getPaymentDueDays() != null) {
                    existingName.setPaymentDueDays(name.getPaymentDueDays());
                }
                if (name.getSuffix() != null) {
                    existingName.setSuffix(name.getSuffix());
                }
                if (name.getExternalId() != null) {
                    existingName.setExternalId(name.getExternalId());
                }
                if (name.getGuestPrivYn() != null) {
                    existingName.setGuestPrivYn(name.getGuestPrivYn());
                }
                if (name.getEmailYn() != null) {
                    existingName.setEmailYn(name.getEmailYn());
                }
                if (name.getMailYn() != null) {
                    existingName.setMailYn(name.getMailYn());
                }
                if (name.getIndexName() != null) {
                    existingName.setIndexName(name.getIndexName());
                }
                if (name.getXlastName() != null) {
                    existingName.setXlastName(name.getXlastName());
                }
                if (name.getXfirstName() != null) {
                    existingName.setXfirstName(name.getXfirstName());
                }
                if (name.getXcompanyName() != null) {
                    existingName.setXcompanyName(name.getXcompanyName());
                }
                if (name.getXtitle() != null) {
                    existingName.setXtitle(name.getXtitle());
                }
                if (name.getXsalutation() != null) {
                    existingName.setXsalutation(name.getXsalutation());
                }
                if (name.getSxname() != null) {
                    existingName.setSxname(name.getSxname());
                }
                if (name.getSxfirstName() != null) {
                    existingName.setSxfirstName(name.getSxfirstName());
                }
                if (name.getLastUpdatedResort() != null) {
                    existingName.setLastUpdatedResort(name.getLastUpdatedResort());
                }
                if (name.getEnvelopeGreeting() != null) {
                    existingName.setEnvelopeGreeting(name.getEnvelopeGreeting());
                }
                if (name.getXenvelopeGreeting() != null) {
                    existingName.setXenvelopeGreeting(name.getXenvelopeGreeting());
                }
                if (name.getDirectBillBatchType() != null) {
                    existingName.setDirectBillBatchType(name.getDirectBillBatchType());
                }
                if (name.getResortRegistered() != null) {
                    existingName.setResortRegistered(name.getResortRegistered());
                }
                if (name.getTaxOffice() != null) {
                    existingName.setTaxOffice(name.getTaxOffice());
                }
                if (name.getTaxType() != null) {
                    existingName.setTaxType(name.getTaxType());
                }
                if (name.getTaxCategory() != null) {
                    existingName.setTaxCategory(name.getTaxCategory());
                }
                if (name.getPreferredRoomNo() != null) {
                    existingName.setPreferredRoomNo(name.getPreferredRoomNo());
                }
                if (name.getPhoneYn() != null) {
                    existingName.setPhoneYn(name.getPhoneYn());
                }
                if (name.getSmsYn() != null) {
                    existingName.setSmsYn(name.getSmsYn());
                }
                if (name.getIsProtected() != null) {
                    existingName.setIsProtected(name.getIsProtected());
                }
                if (name.getXlanguage() != null) {
                    existingName.setXlanguage(name.getXlanguage());
                }
                if (name.getMarketResearchYn() != null) {
                    existingName.setMarketResearchYn(name.getMarketResearchYn());
                }
                if (name.getThirdPartyYn() != null) {
                    existingName.setThirdPartyYn(name.getThirdPartyYn());
                }
                if (name.getAutoenrollMemberYn() != null) {
                    existingName.setAutoenrollMemberYn(name.getAutoenrollMemberYn());
                }
                if (name.getChainCode() != null) {
                    existingName.setChainCode(name.getChainCode());
                }
                if (name.getCompanyGroupId() != null) {
                    existingName.setCompanyGroupId(name.getCompanyGroupId());
                }
                if (name.getIncludeIn1099Yn() != null) {
                    existingName.setIncludeIn1099Yn(name.getIncludeIn1099Yn());
                }
                if (name.getCreditRating() != null) {
                    existingName.setCreditRating(name.getCreditRating());
                }
                if (name.getTitleSuffix() != null) {
                    existingName.setTitleSuffix(name.getTitleSuffix());
                }
                if (name.getInactiveReason() != null) {
                    existingName.setInactiveReason(name.getInactiveReason());
                }
                if (name.getIataConsortia() != null) {
                    existingName.setIataConsortia(name.getIataConsortia());
                }
                if (name.getPsuedoProfileYn() != null) {
                    existingName.setPsuedoProfileYn(name.getPsuedoProfileYn());
                }
                if (name.getProfilePrivacyFlg() != null) {
                    existingName.setProfilePrivacyFlg(name.getProfilePrivacyFlg());
                }
                if (name.getReplaceAddress() != null) {
                    existingName.setReplaceAddress(name.getReplaceAddress());
                }
                if (name.getAlienRegistrationNo() != null) {
                    existingName.setAlienRegistrationNo(name.getAlienRegistrationNo());
                }
                if (name.getImmigrationStatus() != null) {
                    existingName.setImmigrationStatus(name.getImmigrationStatus());
                }
                if (name.getVisaValidityType() != null) {
                    existingName.setVisaValidityType(name.getVisaValidityType());
                }
                if (name.getIdDocumentAttachId() != null) {
                    existingName.setIdDocumentAttachId(name.getIdDocumentAttachId());
                }
                if (name.getSuperSearchIndexText() != null) {
                    existingName.setSuperSearchIndexText(name.getSuperSearchIndexText());
                }
                if (name.getBirthDateStr() != null) {
                    existingName.setBirthDateStr(name.getBirthDateStr());
                }
                if (name.getOrigNameId() != null) {
                    existingName.setOrigNameId(name.getOrigNameId());
                }
                if (name.getdOptInMailListFlg() != null) {
                    existingName.setdOptInMailListFlg(name.getdOptInMailListFlg());
                }
                if (name.getdOptInMarketResearchFlg() != null) {
                    existingName.setdOptInMarketResearchFlg(name.getdOptInMarketResearchFlg());
                }
                if (name.getdOptInThirdPartyFlg() != null) {
                    existingName.setdOptInThirdPartyFlg(name.getdOptInThirdPartyFlg());
                }
                if (name.getdOptInAutoenrollMemberFlg() != null) {
                    existingName.setdOptInAutoenrollMemberFlg(name.getdOptInAutoenrollMemberFlg());
                }
                if (name.getdOptInEmailFlg() != null) {
                    existingName.setdOptInEmailFlg(name.getdOptInEmailFlg());
                }
                if (name.getdOptInPhoneFlg() != null) {
                    existingName.setdOptInPhoneFlg(name.getdOptInPhoneFlg());
                }
                if (name.getdOptInSmsFlg() != null) {
                    existingName.setdOptInSmsFlg(name.getdOptInSmsFlg());
                }
                if (name.getdOptInGuestPrivFlg() != null) {
                    existingName.setdOptInGuestPrivFlg(name.getdOptInGuestPrivFlg());
                }
                if (name.getArCreditLimitYn() != null) {
                    existingName.setArCreditLimitYn(name.getArCreditLimitYn());
                }
                if (name.getProfileCreditLimit() != null) {
                    existingName.setProfileCreditLimit(name.getProfileCreditLimit());
                }
                if (name.getXmiddleName() != null) {
                    existingName.setXmiddleName(name.getXmiddleName());
                }
                if (name.geteInvoiceLiableYn() != null) {
                    existingName.seteInvoiceLiableYn(name.geteInvoiceLiableYn());
                }
                if (name.geteInvLiableLastUpdated() != null) {
                    existingName.seteInvLiableLastUpdated(name.geteInvLiableLastUpdated());
                }
                if (name.getInternalBillYn() != null) {
                    existingName.setInternalBillYn(name.getInternalBillYn());
                }
                if (name.getCompPreApprovalRequiredYn() != null) {
                    existingName.setCompPreApprovalRequiredYn(name.getCompPreApprovalRequiredYn());
                }
                if (name.getAnonymizationStatus() != null) {
                    existingName.setAnonymizationStatus(name.getAnonymizationStatus());
                }
                if (name.getAnonymizationDate() != null) {
                    existingName.setAnonymizationDate(name.getAnonymizationDate());
                }

                return existingName;
            })
            .map(nameRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Name> findAll(Pageable pageable) {
        log.debug("Request to get all Names");
        return nameRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Name> findOne(Integer id) {
        log.debug("Request to get Name : {}", id);
        return nameRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete Name : {}", id);
        nameRepository.deleteById(id);
    }
}
