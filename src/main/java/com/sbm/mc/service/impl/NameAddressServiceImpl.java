package com.sbm.mc.service.impl;

import com.sbm.mc.domain.NameAddress;
import com.sbm.mc.repository.NameAddressRepository;
import com.sbm.mc.service.NameAddressService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.NameAddress}.
 */
@Service
@Transactional
public class NameAddressServiceImpl implements NameAddressService {

    private final Logger log = LoggerFactory.getLogger(NameAddressServiceImpl.class);

    private final NameAddressRepository nameAddressRepository;

    public NameAddressServiceImpl(NameAddressRepository nameAddressRepository) {
        this.nameAddressRepository = nameAddressRepository;
    }

    @Override
    public NameAddress save(NameAddress nameAddress) {
        log.debug("Request to save NameAddress : {}", nameAddress);
        return nameAddressRepository.save(nameAddress);
    }

    @Override
    public NameAddress update(NameAddress nameAddress) {
        log.debug("Request to update NameAddress : {}", nameAddress);
        return nameAddressRepository.save(nameAddress);
    }

    @Override
    public Optional<NameAddress> partialUpdate(NameAddress nameAddress) {
        log.debug("Request to partially update NameAddress : {}", nameAddress);

        return nameAddressRepository
            .findById(nameAddress.getId())
            .map(existingNameAddress -> {
                if (nameAddress.getAddressId() != null) {
                    existingNameAddress.setAddressId(nameAddress.getAddressId());
                }
                if (nameAddress.getAddressType() != null) {
                    existingNameAddress.setAddressType(nameAddress.getAddressType());
                }
                if (nameAddress.getAddress1() != null) {
                    existingNameAddress.setAddress1(nameAddress.getAddress1());
                }
                if (nameAddress.getAddress2() != null) {
                    existingNameAddress.setAddress2(nameAddress.getAddress2());
                }
                if (nameAddress.getAddress3() != null) {
                    existingNameAddress.setAddress3(nameAddress.getAddress3());
                }
                if (nameAddress.getAddress4() != null) {
                    existingNameAddress.setAddress4(nameAddress.getAddress4());
                }
                if (nameAddress.getBarcode() != null) {
                    existingNameAddress.setBarcode(nameAddress.getBarcode());
                }
                if (nameAddress.getBeginDate() != null) {
                    existingNameAddress.setBeginDate(nameAddress.getBeginDate());
                }
                if (nameAddress.getChainCode() != null) {
                    existingNameAddress.setChainCode(nameAddress.getChainCode());
                }
                if (nameAddress.getCity() != null) {
                    existingNameAddress.setCity(nameAddress.getCity());
                }
                if (nameAddress.getCityExt() != null) {
                    existingNameAddress.setCityExt(nameAddress.getCityExt());
                }
                if (nameAddress.getCleansedDatetime() != null) {
                    existingNameAddress.setCleansedDatetime(nameAddress.getCleansedDatetime());
                }
                if (nameAddress.getCleansedErrormsg() != null) {
                    existingNameAddress.setCleansedErrormsg(nameAddress.getCleansedErrormsg());
                }
                if (nameAddress.getCleansedMatchstatus() != null) {
                    existingNameAddress.setCleansedMatchstatus(nameAddress.getCleansedMatchstatus());
                }
                if (nameAddress.getCleansedStatus() != null) {
                    existingNameAddress.setCleansedStatus(nameAddress.getCleansedStatus());
                }
                if (nameAddress.getCleansedValidationstatus() != null) {
                    existingNameAddress.setCleansedValidationstatus(nameAddress.getCleansedValidationstatus());
                }
                if (nameAddress.getCountry() != null) {
                    existingNameAddress.setCountry(nameAddress.getCountry());
                }
                if (nameAddress.getEndDate() != null) {
                    existingNameAddress.setEndDate(nameAddress.getEndDate());
                }
                if (nameAddress.getForeignCountry() != null) {
                    existingNameAddress.setForeignCountry(nameAddress.getForeignCountry());
                }
                if (nameAddress.getInCareOf() != null) {
                    existingNameAddress.setInCareOf(nameAddress.getInCareOf());
                }
                if (nameAddress.getInactiveDate() != null) {
                    existingNameAddress.setInactiveDate(nameAddress.getInactiveDate());
                }
                if (nameAddress.getInsertDate() != null) {
                    existingNameAddress.setInsertDate(nameAddress.getInsertDate());
                }
                if (nameAddress.getInsertUser() != null) {
                    existingNameAddress.setInsertUser(nameAddress.getInsertUser());
                }
                if (nameAddress.getLanguageCode() != null) {
                    existingNameAddress.setLanguageCode(nameAddress.getLanguageCode());
                }
                if (nameAddress.getLaptopChange() != null) {
                    existingNameAddress.setLaptopChange(nameAddress.getLaptopChange());
                }
                if (nameAddress.getLastUpdatedResort() != null) {
                    existingNameAddress.setLastUpdatedResort(nameAddress.getLastUpdatedResort());
                }
                if (nameAddress.getNameId() != null) {
                    existingNameAddress.setNameId(nameAddress.getNameId());
                }
                if (nameAddress.getPrimaryYn() != null) {
                    existingNameAddress.setPrimaryYn(nameAddress.getPrimaryYn());
                }
                if (nameAddress.getProvince() != null) {
                    existingNameAddress.setProvince(nameAddress.getProvince());
                }
                if (nameAddress.getState() != null) {
                    existingNameAddress.setState(nameAddress.getState());
                }
                if (nameAddress.getUpdateDate() != null) {
                    existingNameAddress.setUpdateDate(nameAddress.getUpdateDate());
                }
                if (nameAddress.getUpdateUser() != null) {
                    existingNameAddress.setUpdateUser(nameAddress.getUpdateUser());
                }
                if (nameAddress.getZipCode() != null) {
                    existingNameAddress.setZipCode(nameAddress.getZipCode());
                }

                return existingNameAddress;
            })
            .map(nameAddressRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NameAddress> findAll(Pageable pageable) {
        log.debug("Request to get all NameAddresses");
        return nameAddressRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NameAddress> findOne(Integer id) {
        log.debug("Request to get NameAddress : {}", id);
        return nameAddressRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete NameAddress : {}", id);
        nameAddressRepository.deleteById(id);
    }
}
