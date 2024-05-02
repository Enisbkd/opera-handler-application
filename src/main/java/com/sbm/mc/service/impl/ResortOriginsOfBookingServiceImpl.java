package com.sbm.mc.service.impl;

import com.sbm.mc.domain.ResortOriginsOfBooking;
import com.sbm.mc.repository.ResortOriginsOfBookingRepository;
import com.sbm.mc.service.ResortOriginsOfBookingService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.ResortOriginsOfBooking}.
 */
@Service
@Transactional
public class ResortOriginsOfBookingServiceImpl implements ResortOriginsOfBookingService {

    private final Logger log = LoggerFactory.getLogger(ResortOriginsOfBookingServiceImpl.class);

    private final ResortOriginsOfBookingRepository resortOriginsOfBookingRepository;

    public ResortOriginsOfBookingServiceImpl(ResortOriginsOfBookingRepository resortOriginsOfBookingRepository) {
        this.resortOriginsOfBookingRepository = resortOriginsOfBookingRepository;
    }

    @Override
    public ResortOriginsOfBooking save(ResortOriginsOfBooking resortOriginsOfBooking) {
        log.debug("Request to save ResortOriginsOfBooking : {}", resortOriginsOfBooking);
        return resortOriginsOfBookingRepository.save(resortOriginsOfBooking);
    }

    @Override
    public ResortOriginsOfBooking update(ResortOriginsOfBooking resortOriginsOfBooking) {
        log.debug("Request to update ResortOriginsOfBooking : {}", resortOriginsOfBooking);
        return resortOriginsOfBookingRepository.save(resortOriginsOfBooking);
    }

    @Override
    public Optional<ResortOriginsOfBooking> partialUpdate(ResortOriginsOfBooking resortOriginsOfBooking) {
        log.debug("Request to partially update ResortOriginsOfBooking : {}", resortOriginsOfBooking);

        return resortOriginsOfBookingRepository
            .findById(resortOriginsOfBooking.getId())
            .map(existingResortOriginsOfBooking -> {
                if (resortOriginsOfBooking.getResort() != null) {
                    existingResortOriginsOfBooking.setResort(resortOriginsOfBooking.getResort());
                }
                if (resortOriginsOfBooking.getSourceCode() != null) {
                    existingResortOriginsOfBooking.setSourceCode(resortOriginsOfBooking.getSourceCode());
                }
                if (resortOriginsOfBooking.getParentSourceCode() != null) {
                    existingResortOriginsOfBooking.setParentSourceCode(resortOriginsOfBooking.getParentSourceCode());
                }
                if (resortOriginsOfBooking.getDescription() != null) {
                    existingResortOriginsOfBooking.setDescription(resortOriginsOfBooking.getDescription());
                }
                if (resortOriginsOfBooking.getInsertUser() != null) {
                    existingResortOriginsOfBooking.setInsertUser(resortOriginsOfBooking.getInsertUser());
                }
                if (resortOriginsOfBooking.getInsertDate() != null) {
                    existingResortOriginsOfBooking.setInsertDate(resortOriginsOfBooking.getInsertDate());
                }
                if (resortOriginsOfBooking.getUpdateUser() != null) {
                    existingResortOriginsOfBooking.setUpdateUser(resortOriginsOfBooking.getUpdateUser());
                }
                if (resortOriginsOfBooking.getUpdateDate() != null) {
                    existingResortOriginsOfBooking.setUpdateDate(resortOriginsOfBooking.getUpdateDate());
                }
                if (resortOriginsOfBooking.getInactiveDate() != null) {
                    existingResortOriginsOfBooking.setInactiveDate(resortOriginsOfBooking.getInactiveDate());
                }
                if (resortOriginsOfBooking.getSellSequence() != null) {
                    existingResortOriginsOfBooking.setSellSequence(resortOriginsOfBooking.getSellSequence());
                }
                if (resortOriginsOfBooking.getScOrderby() != null) {
                    existingResortOriginsOfBooking.setScOrderby(resortOriginsOfBooking.getScOrderby());
                }
                if (resortOriginsOfBooking.getInternetSalesYn() != null) {
                    existingResortOriginsOfBooking.setInternetSalesYn(resortOriginsOfBooking.getInternetSalesYn());
                }

                return existingResortOriginsOfBooking;
            })
            .map(resortOriginsOfBookingRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ResortOriginsOfBooking> findAll(Pageable pageable) {
        log.debug("Request to get all ResortOriginsOfBookings");
        return resortOriginsOfBookingRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ResortOriginsOfBooking> findOne(Long id) {
        log.debug("Request to get ResortOriginsOfBooking : {}", id);
        return resortOriginsOfBookingRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ResortOriginsOfBooking : {}", id);
        resortOriginsOfBookingRepository.deleteById(id);
    }
}
