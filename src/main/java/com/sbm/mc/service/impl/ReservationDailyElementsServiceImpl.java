package com.sbm.mc.service.impl;

import com.sbm.mc.domain.ReservationDailyElements;
import com.sbm.mc.repository.ReservationDailyElementsRepository;
import com.sbm.mc.service.ReservationDailyElementsService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.ReservationDailyElements}.
 */
@Service
@Transactional
public class ReservationDailyElementsServiceImpl implements ReservationDailyElementsService {

    private final Logger log = LoggerFactory.getLogger(ReservationDailyElementsServiceImpl.class);

    private final ReservationDailyElementsRepository reservationDailyElementsRepository;

    public ReservationDailyElementsServiceImpl(ReservationDailyElementsRepository reservationDailyElementsRepository) {
        this.reservationDailyElementsRepository = reservationDailyElementsRepository;
    }

    @Override
    public ReservationDailyElements save(ReservationDailyElements reservationDailyElements) {
        log.debug("Request to save ReservationDailyElements : {}", reservationDailyElements);
        return reservationDailyElementsRepository.save(reservationDailyElements);
    }

    @Override
    public ReservationDailyElements update(ReservationDailyElements reservationDailyElements) {
        log.debug("Request to update ReservationDailyElements : {}", reservationDailyElements);
        return reservationDailyElementsRepository.save(reservationDailyElements);
    }

    @Override
    public Optional<ReservationDailyElements> partialUpdate(ReservationDailyElements reservationDailyElements) {
        log.debug("Request to partially update ReservationDailyElements : {}", reservationDailyElements);

        return reservationDailyElementsRepository
            .findById(reservationDailyElements.getId())
            .map(existingReservationDailyElements -> {
                if (reservationDailyElements.getResort() != null) {
                    existingReservationDailyElements.setResort(reservationDailyElements.getResort());
                }
                if (reservationDailyElements.getReservationDate() != null) {
                    existingReservationDailyElements.setReservationDate(reservationDailyElements.getReservationDate());
                }
                if (reservationDailyElements.getResvDailyElSeq() != null) {
                    existingReservationDailyElements.setResvDailyElSeq(reservationDailyElements.getResvDailyElSeq());
                }
                if (reservationDailyElements.getResvStatus() != null) {
                    existingReservationDailyElements.setResvStatus(reservationDailyElements.getResvStatus());
                }
                if (reservationDailyElements.getExternalReference() != null) {
                    existingReservationDailyElements.setExternalReference(reservationDailyElements.getExternalReference());
                }
                if (reservationDailyElements.getRoomClass() != null) {
                    existingReservationDailyElements.setRoomClass(reservationDailyElements.getRoomClass());
                }
                if (reservationDailyElements.getRoomCategory() != null) {
                    existingReservationDailyElements.setRoomCategory(reservationDailyElements.getRoomCategory());
                }
                if (reservationDailyElements.getBookedRoomCategory() != null) {
                    existingReservationDailyElements.setBookedRoomCategory(reservationDailyElements.getBookedRoomCategory());
                }
                if (reservationDailyElements.getRoom() != null) {
                    existingReservationDailyElements.setRoom(reservationDailyElements.getRoom());
                }
                if (reservationDailyElements.getCancellationNo() != null) {
                    existingReservationDailyElements.setCancellationNo(reservationDailyElements.getCancellationNo());
                }
                if (reservationDailyElements.getCancellationDate() != null) {
                    existingReservationDailyElements.setCancellationDate(reservationDailyElements.getCancellationDate());
                }
                if (reservationDailyElements.getCancellationCode() != null) {
                    existingReservationDailyElements.setCancellationCode(reservationDailyElements.getCancellationCode());
                }
                if (reservationDailyElements.getCancellationReasonDesc() != null) {
                    existingReservationDailyElements.setCancellationReasonDesc(reservationDailyElements.getCancellationReasonDesc());
                }
                if (reservationDailyElements.getGuaranteeCode() != null) {
                    existingReservationDailyElements.setGuaranteeCode(reservationDailyElements.getGuaranteeCode());
                }
                if (reservationDailyElements.getMarketCode() != null) {
                    existingReservationDailyElements.setMarketCode(reservationDailyElements.getMarketCode());
                }
                if (reservationDailyElements.getOriginOfBooking() != null) {
                    existingReservationDailyElements.setOriginOfBooking(reservationDailyElements.getOriginOfBooking());
                }
                if (reservationDailyElements.getExchangeRate() != null) {
                    existingReservationDailyElements.setExchangeRate(reservationDailyElements.getExchangeRate());
                }
                if (reservationDailyElements.getOriginalBaseRate() != null) {
                    existingReservationDailyElements.setOriginalBaseRate(reservationDailyElements.getOriginalBaseRate());
                }
                if (reservationDailyElements.getBaseRateAmount() != null) {
                    existingReservationDailyElements.setBaseRateAmount(reservationDailyElements.getBaseRateAmount());
                }
                if (reservationDailyElements.getRateAmount() != null) {
                    existingReservationDailyElements.setRateAmount(reservationDailyElements.getRateAmount());
                }
                if (reservationDailyElements.getRoomCost() != null) {
                    existingReservationDailyElements.setRoomCost(reservationDailyElements.getRoomCost());
                }
                if (reservationDailyElements.getQuantity() != null) {
                    existingReservationDailyElements.setQuantity(reservationDailyElements.getQuantity());
                }
                if (reservationDailyElements.getAdults() != null) {
                    existingReservationDailyElements.setAdults(reservationDailyElements.getAdults());
                }
                if (reservationDailyElements.getChildren() != null) {
                    existingReservationDailyElements.setChildren(reservationDailyElements.getChildren());
                }
                if (reservationDailyElements.getPhysicalQuantity() != null) {
                    existingReservationDailyElements.setPhysicalQuantity(reservationDailyElements.getPhysicalQuantity());
                }
                if (reservationDailyElements.getAllotmentHeaderId() != null) {
                    existingReservationDailyElements.setAllotmentHeaderId(reservationDailyElements.getAllotmentHeaderId());
                }
                if (reservationDailyElements.getDayUseYn() != null) {
                    existingReservationDailyElements.setDayUseYn(reservationDailyElements.getDayUseYn());
                }
                if (reservationDailyElements.getDueOutYn() != null) {
                    existingReservationDailyElements.setDueOutYn(reservationDailyElements.getDueOutYn());
                }
                if (reservationDailyElements.getInsertUser() != null) {
                    existingReservationDailyElements.setInsertUser(reservationDailyElements.getInsertUser());
                }
                if (reservationDailyElements.getInsertDate() != null) {
                    existingReservationDailyElements.setInsertDate(reservationDailyElements.getInsertDate());
                }
                if (reservationDailyElements.getUpdateUser() != null) {
                    existingReservationDailyElements.setUpdateUser(reservationDailyElements.getUpdateUser());
                }
                if (reservationDailyElements.getUpdateDate() != null) {
                    existingReservationDailyElements.setUpdateDate(reservationDailyElements.getUpdateDate());
                }
                if (reservationDailyElements.getInsertActionInstanceId() != null) {
                    existingReservationDailyElements.setInsertActionInstanceId(reservationDailyElements.getInsertActionInstanceId());
                }
                if (reservationDailyElements.getDmlSeqNo() != null) {
                    existingReservationDailyElements.setDmlSeqNo(reservationDailyElements.getDmlSeqNo());
                }
                if (reservationDailyElements.getExtSeqNo() != null) {
                    existingReservationDailyElements.setExtSeqNo(reservationDailyElements.getExtSeqNo());
                }
                if (reservationDailyElements.getExtSegNo() != null) {
                    existingReservationDailyElements.setExtSegNo(reservationDailyElements.getExtSegNo());
                }
                if (reservationDailyElements.getCribs() != null) {
                    existingReservationDailyElements.setCribs(reservationDailyElements.getCribs());
                }
                if (reservationDailyElements.getExtraBeds() != null) {
                    existingReservationDailyElements.setExtraBeds(reservationDailyElements.getExtraBeds());
                }
                if (reservationDailyElements.getAllotmentRecordType() != null) {
                    existingReservationDailyElements.setAllotmentRecordType(reservationDailyElements.getAllotmentRecordType());
                }
                if (reservationDailyElements.getBlockResort() != null) {
                    existingReservationDailyElements.setBlockResort(reservationDailyElements.getBlockResort());
                }
                if (reservationDailyElements.getBlockId() != null) {
                    existingReservationDailyElements.setBlockId(reservationDailyElements.getBlockId());
                }
                if (reservationDailyElements.getTurndownStatus() != null) {
                    existingReservationDailyElements.setTurndownStatus(reservationDailyElements.getTurndownStatus());
                }
                if (reservationDailyElements.getAwdUpgrFrom() != null) {
                    existingReservationDailyElements.setAwdUpgrFrom(reservationDailyElements.getAwdUpgrFrom());
                }
                if (reservationDailyElements.getAwdUpgrTo() != null) {
                    existingReservationDailyElements.setAwdUpgrTo(reservationDailyElements.getAwdUpgrTo());
                }
                if (reservationDailyElements.getHkExpectedServiceTime() != null) {
                    existingReservationDailyElements.setHkExpectedServiceTime(reservationDailyElements.getHkExpectedServiceTime());
                }
                if (reservationDailyElements.getRoomInstructions() != null) {
                    existingReservationDailyElements.setRoomInstructions(reservationDailyElements.getRoomInstructions());
                }

                return existingReservationDailyElements;
            })
            .map(reservationDailyElementsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ReservationDailyElements> findAll(Pageable pageable) {
        log.debug("Request to get all ReservationDailyElements");
        return reservationDailyElementsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ReservationDailyElements> findOne(Long id) {
        log.debug("Request to get ReservationDailyElements : {}", id);
        return reservationDailyElementsRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ReservationDailyElements : {}", id);
        reservationDailyElementsRepository.deleteById(id);
    }
}
