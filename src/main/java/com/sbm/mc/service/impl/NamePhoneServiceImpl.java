package com.sbm.mc.service.impl;

import com.sbm.mc.domain.NamePhone;
import com.sbm.mc.repository.NamePhoneRepository;
import com.sbm.mc.service.NamePhoneService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.NamePhone}.
 */
@Service
@Transactional
public class NamePhoneServiceImpl implements NamePhoneService {

    private final Logger log = LoggerFactory.getLogger(NamePhoneServiceImpl.class);

    private final NamePhoneRepository namePhoneRepository;

    public NamePhoneServiceImpl(NamePhoneRepository namePhoneRepository) {
        this.namePhoneRepository = namePhoneRepository;
    }

    @Override
    public NamePhone save(NamePhone namePhone) {
        log.debug("Request to save NamePhone : {}", namePhone);
        return namePhoneRepository.save(namePhone);
    }

    @Override
    public NamePhone update(NamePhone namePhone) {
        log.debug("Request to update NamePhone : {}", namePhone);
        return namePhoneRepository.save(namePhone);
    }

    @Override
    public Optional<NamePhone> partialUpdate(NamePhone namePhone) {
        log.debug("Request to partially update NamePhone : {}", namePhone);

        return namePhoneRepository
            .findById(namePhone.getId())
            .map(existingNamePhone -> {
                if (namePhone.getPhoneId() != null) {
                    existingNamePhone.setPhoneId(namePhone.getPhoneId());
                }
                if (namePhone.getNameId() != null) {
                    existingNamePhone.setNameId(namePhone.getNameId());
                }
                if (namePhone.getPhoneType() != null) {
                    existingNamePhone.setPhoneType(namePhone.getPhoneType());
                }
                if (namePhone.getPhoneRole() != null) {
                    existingNamePhone.setPhoneRole(namePhone.getPhoneRole());
                }
                if (namePhone.getPhoneNumber() != null) {
                    existingNamePhone.setPhoneNumber(namePhone.getPhoneNumber());
                }
                if (namePhone.getInsertDate() != null) {
                    existingNamePhone.setInsertDate(namePhone.getInsertDate());
                }
                if (namePhone.getInsertUser() != null) {
                    existingNamePhone.setInsertUser(namePhone.getInsertUser());
                }
                if (namePhone.getUpdateDate() != null) {
                    existingNamePhone.setUpdateDate(namePhone.getUpdateDate());
                }
                if (namePhone.getUpdateUser() != null) {
                    existingNamePhone.setUpdateUser(namePhone.getUpdateUser());
                }
                if (namePhone.getInactiveDate() != null) {
                    existingNamePhone.setInactiveDate(namePhone.getInactiveDate());
                }
                if (namePhone.getEndDate() != null) {
                    existingNamePhone.setEndDate(namePhone.getEndDate());
                }
                if (namePhone.getBeginDate() != null) {
                    existingNamePhone.setBeginDate(namePhone.getBeginDate());
                }
                if (namePhone.getAddressId() != null) {
                    existingNamePhone.setAddressId(namePhone.getAddressId());
                }
                if (namePhone.getPrimaryYn() != null) {
                    existingNamePhone.setPrimaryYn(namePhone.getPrimaryYn());
                }
                if (namePhone.getDisplaySeq() != null) {
                    existingNamePhone.setDisplaySeq(namePhone.getDisplaySeq());
                }
                if (namePhone.getLaptopChange() != null) {
                    existingNamePhone.setLaptopChange(namePhone.getLaptopChange());
                }
                if (namePhone.getIndexPhone() != null) {
                    existingNamePhone.setIndexPhone(namePhone.getIndexPhone());
                }
                if (namePhone.getExtension() != null) {
                    existingNamePhone.setExtension(namePhone.getExtension());
                }
                if (namePhone.getEmailFormat() != null) {
                    existingNamePhone.setEmailFormat(namePhone.getEmailFormat());
                }
                if (namePhone.getShareEmailYn() != null) {
                    existingNamePhone.setShareEmailYn(namePhone.getShareEmailYn());
                }
                if (namePhone.getDefaultConfirmationYn() != null) {
                    existingNamePhone.setDefaultConfirmationYn(namePhone.getDefaultConfirmationYn());
                }
                if (namePhone.getEmailLanguage() != null) {
                    existingNamePhone.setEmailLanguage(namePhone.getEmailLanguage());
                }
                if (namePhone.getMobileAudioKeyYn() != null) {
                    existingNamePhone.setMobileAudioKeyYn(namePhone.getMobileAudioKeyYn());
                }
                if (namePhone.getCountryDialingCode() != null) {
                    existingNamePhone.setCountryDialingCode(namePhone.getCountryDialingCode());
                }
                if (namePhone.getValidYn() != null) {
                    existingNamePhone.setValidYn(namePhone.getValidYn());
                }
                if (namePhone.getPhoneCountryCode() != null) {
                    existingNamePhone.setPhoneCountryCode(namePhone.getPhoneCountryCode());
                }
                if (namePhone.getChainCode() != null) {
                    existingNamePhone.setChainCode(namePhone.getChainCode());
                }
                if (namePhone.getValidateDate() != null) {
                    existingNamePhone.setValidateDate(namePhone.getValidateDate());
                }
                if (namePhone.getValidateStatus() != null) {
                    existingNamePhone.setValidateStatus(namePhone.getValidateStatus());
                }

                return existingNamePhone;
            })
            .map(namePhoneRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NamePhone> findAll(Pageable pageable) {
        log.debug("Request to get all NamePhones");
        return namePhoneRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NamePhone> findOne(Integer id) {
        log.debug("Request to get NamePhone : {}", id);
        return namePhoneRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete NamePhone : {}", id);
        namePhoneRepository.deleteById(id);
    }
}
