package com.sbm.mc.service.impl;

import com.sbm.mc.domain.ResortRoomCategory;
import com.sbm.mc.repository.ResortRoomCategoryRepository;
import com.sbm.mc.service.ResortRoomCategoryService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.ResortRoomCategory}.
 */
@Service
@Transactional
public class ResortRoomCategoryServiceImpl implements ResortRoomCategoryService {

    private final Logger log = LoggerFactory.getLogger(ResortRoomCategoryServiceImpl.class);

    private final ResortRoomCategoryRepository resortRoomCategoryRepository;

    public ResortRoomCategoryServiceImpl(ResortRoomCategoryRepository resortRoomCategoryRepository) {
        this.resortRoomCategoryRepository = resortRoomCategoryRepository;
    }

    @Override
    public ResortRoomCategory save(ResortRoomCategory resortRoomCategory) {
        log.debug("Request to save ResortRoomCategory : {}", resortRoomCategory);
        return resortRoomCategoryRepository.save(resortRoomCategory);
    }

    @Override
    public ResortRoomCategory update(ResortRoomCategory resortRoomCategory) {
        log.debug("Request to update ResortRoomCategory : {}", resortRoomCategory);
        return resortRoomCategoryRepository.save(resortRoomCategory);
    }

    @Override
    public Optional<ResortRoomCategory> partialUpdate(ResortRoomCategory resortRoomCategory) {
        log.debug("Request to partially update ResortRoomCategory : {}", resortRoomCategory);

        return resortRoomCategoryRepository
            .findById(resortRoomCategory.getId())
            .map(existingResortRoomCategory -> {
                if (resortRoomCategory.getResort() != null) {
                    existingResortRoomCategory.setResort(resortRoomCategory.getResort());
                }
                if (resortRoomCategory.getRoomCategory() != null) {
                    existingResortRoomCategory.setRoomCategory(resortRoomCategory.getRoomCategory());
                }
                if (resortRoomCategory.getRoomClass() != null) {
                    existingResortRoomCategory.setRoomClass(resortRoomCategory.getRoomClass());
                }
                if (resortRoomCategory.getNumberRooms() != null) {
                    existingResortRoomCategory.setNumberRooms(resortRoomCategory.getNumberRooms());
                }
                if (resortRoomCategory.getShortDescription() != null) {
                    existingResortRoomCategory.setShortDescription(resortRoomCategory.getShortDescription());
                }
                if (resortRoomCategory.getLongDescription() != null) {
                    existingResortRoomCategory.setLongDescription(resortRoomCategory.getLongDescription());
                }
                if (resortRoomCategory.getCompiled() != null) {
                    existingResortRoomCategory.setCompiled(resortRoomCategory.getCompiled());
                }
                if (resortRoomCategory.getPsuedoRoomType() != null) {
                    existingResortRoomCategory.setPsuedoRoomType(resortRoomCategory.getPsuedoRoomType());
                }
                if (resortRoomCategory.getActiveDate() != null) {
                    existingResortRoomCategory.setActiveDate(resortRoomCategory.getActiveDate());
                }
                if (resortRoomCategory.getInactiveDate() != null) {
                    existingResortRoomCategory.setInactiveDate(resortRoomCategory.getInactiveDate());
                }
                if (resortRoomCategory.getReplacesCategory() != null) {
                    existingResortRoomCategory.setReplacesCategory(resortRoomCategory.getReplacesCategory());
                }
                if (resortRoomCategory.getOrderBy() != null) {
                    existingResortRoomCategory.setOrderBy(resortRoomCategory.getOrderBy());
                }
                if (resortRoomCategory.getMaxOccupancy() != null) {
                    existingResortRoomCategory.setMaxOccupancy(resortRoomCategory.getMaxOccupancy());
                }
                if (resortRoomCategory.getMaxRollaways() != null) {
                    existingResortRoomCategory.setMaxRollaways(resortRoomCategory.getMaxRollaways());
                }
                if (resortRoomCategory.getRateCategory() != null) {
                    existingResortRoomCategory.setRateCategory(resortRoomCategory.getRateCategory());
                }
                if (resortRoomCategory.getLabel() != null) {
                    existingResortRoomCategory.setLabel(resortRoomCategory.getLabel());
                }
                if (resortRoomCategory.getGenericFlag() != null) {
                    existingResortRoomCategory.setGenericFlag(resortRoomCategory.getGenericFlag());
                }
                if (resortRoomCategory.getSuiteYn() != null) {
                    existingResortRoomCategory.setSuiteYn(resortRoomCategory.getSuiteYn());
                }
                if (resortRoomCategory.getMeetingroomYn() != null) {
                    existingResortRoomCategory.setMeetingroomYn(resortRoomCategory.getMeetingroomYn());
                }
                if (resortRoomCategory.getInsertUser() != null) {
                    existingResortRoomCategory.setInsertUser(resortRoomCategory.getInsertUser());
                }
                if (resortRoomCategory.getInsertDate() != null) {
                    existingResortRoomCategory.setInsertDate(resortRoomCategory.getInsertDate());
                }
                if (resortRoomCategory.getUpdateUser() != null) {
                    existingResortRoomCategory.setUpdateUser(resortRoomCategory.getUpdateUser());
                }
                if (resortRoomCategory.getUpdateDate() != null) {
                    existingResortRoomCategory.setUpdateDate(resortRoomCategory.getUpdateDate());
                }
                if (resortRoomCategory.getRateCode() != null) {
                    existingResortRoomCategory.setRateCode(resortRoomCategory.getRateCode());
                }
                if (resortRoomCategory.getRateAmount() != null) {
                    existingResortRoomCategory.setRateAmount(resortRoomCategory.getRateAmount());
                }
                if (resortRoomCategory.getDefOccupancy() != null) {
                    existingResortRoomCategory.setDefOccupancy(resortRoomCategory.getDefOccupancy());
                }
                if (resortRoomCategory.getImageId() != null) {
                    existingResortRoomCategory.setImageId(resortRoomCategory.getImageId());
                }
                if (resortRoomCategory.getPseudoYn() != null) {
                    existingResortRoomCategory.setPseudoYn(resortRoomCategory.getPseudoYn());
                }
                if (resortRoomCategory.getSendToInterfaceYn() != null) {
                    existingResortRoomCategory.setSendToInterfaceYn(resortRoomCategory.getSendToInterfaceYn());
                }
                if (resortRoomCategory.getYieldableYn() != null) {
                    existingResortRoomCategory.setYieldableYn(resortRoomCategory.getYieldableYn());
                }
                if (resortRoomCategory.getYieldCategory() != null) {
                    existingResortRoomCategory.setYieldCategory(resortRoomCategory.getYieldCategory());
                }
                if (resortRoomCategory.getHousekeeping() != null) {
                    existingResortRoomCategory.setHousekeeping(resortRoomCategory.getHousekeeping());
                }
                if (resortRoomCategory.getCanDeleteYn() != null) {
                    existingResortRoomCategory.setCanDeleteYn(resortRoomCategory.getCanDeleteYn());
                }
                if (resortRoomCategory.getRoominfoUrl() != null) {
                    existingResortRoomCategory.setRoominfoUrl(resortRoomCategory.getRoominfoUrl());
                }
                if (resortRoomCategory.getOwnerYn() != null) {
                    existingResortRoomCategory.setOwnerYn(resortRoomCategory.getOwnerYn());
                }
                if (resortRoomCategory.getAutoIncludeYn() != null) {
                    existingResortRoomCategory.setAutoIncludeYn(resortRoomCategory.getAutoIncludeYn());
                }
                if (resortRoomCategory.getInitialRoundUp() != null) {
                    existingResortRoomCategory.setInitialRoundUp(resortRoomCategory.getInitialRoundUp());
                }
                if (resortRoomCategory.getIncrements() != null) {
                    existingResortRoomCategory.setIncrements(resortRoomCategory.getIncrements());
                }
                if (resortRoomCategory.getRotationGroup() != null) {
                    existingResortRoomCategory.setRotationGroup(resortRoomCategory.getRotationGroup());
                }
                if (resortRoomCategory.getSalesFlag() != null) {
                    existingResortRoomCategory.setSalesFlag(resortRoomCategory.getSalesFlag());
                }
                if (resortRoomCategory.getAutoRoomAssignYn() != null) {
                    existingResortRoomCategory.setAutoRoomAssignYn(resortRoomCategory.getAutoRoomAssignYn());
                }
                if (resortRoomCategory.getUpsellYn() != null) {
                    existingResortRoomCategory.setUpsellYn(resortRoomCategory.getUpsellYn());
                }
                if (resortRoomCategory.getOrmsUpsellRank() != null) {
                    existingResortRoomCategory.setOrmsUpsellRank(resortRoomCategory.getOrmsUpsellRank());
                }
                if (resortRoomCategory.getOrmsUpsellAmt() != null) {
                    existingResortRoomCategory.setOrmsUpsellAmt(resortRoomCategory.getOrmsUpsellAmt());
                }
                if (resortRoomCategory.getOrmsDrxtraAdult() != null) {
                    existingResortRoomCategory.setOrmsDrxtraAdult(resortRoomCategory.getOrmsDrxtraAdult());
                }
                if (resortRoomCategory.getOrmsDrxtraChild() != null) {
                    existingResortRoomCategory.setOrmsDrxtraChild(resortRoomCategory.getOrmsDrxtraChild());
                }
                if (resortRoomCategory.getMaxOccupancyAdults() != null) {
                    existingResortRoomCategory.setMaxOccupancyAdults(resortRoomCategory.getMaxOccupancyAdults());
                }
                if (resortRoomCategory.getMaxOccupancyChildren() != null) {
                    existingResortRoomCategory.setMaxOccupancyChildren(resortRoomCategory.getMaxOccupancyChildren());
                }
                if (resortRoomCategory.getRoomPool() != null) {
                    existingResortRoomCategory.setRoomPool(resortRoomCategory.getRoomPool());
                }
                if (resortRoomCategory.getMemberAwardRoomGrp() != null) {
                    existingResortRoomCategory.setMemberAwardRoomGrp(resortRoomCategory.getMemberAwardRoomGrp());
                }
                if (resortRoomCategory.getOrmsDrxtra2ndAdult() != null) {
                    existingResortRoomCategory.setOrmsDrxtra2ndAdult(resortRoomCategory.getOrmsDrxtra2ndAdult());
                }
                if (resortRoomCategory.getOrmsDrtier1() != null) {
                    existingResortRoomCategory.setOrmsDrtier1(resortRoomCategory.getOrmsDrtier1());
                }
                if (resortRoomCategory.getOrmsDrtier2() != null) {
                    existingResortRoomCategory.setOrmsDrtier2(resortRoomCategory.getOrmsDrtier2());
                }
                if (resortRoomCategory.getOrmsDrtier3() != null) {
                    existingResortRoomCategory.setOrmsDrtier3(resortRoomCategory.getOrmsDrtier3());
                }
                if (resortRoomCategory.getAutoCheckinYn() != null) {
                    existingResortRoomCategory.setAutoCheckinYn(resortRoomCategory.getAutoCheckinYn());
                }
                if (resortRoomCategory.getRateFloor() != null) {
                    existingResortRoomCategory.setRateFloor(resortRoomCategory.getRateFloor());
                }
                if (resortRoomCategory.getMaxFixBedOccupancy() != null) {
                    existingResortRoomCategory.setMaxFixBedOccupancy(resortRoomCategory.getMaxFixBedOccupancy());
                }
                if (resortRoomCategory.getMaintenanceYn() != null) {
                    existingResortRoomCategory.setMaintenanceYn(resortRoomCategory.getMaintenanceYn());
                }
                if (resortRoomCategory.getSmokingPreference() != null) {
                    existingResortRoomCategory.setSmokingPreference(resortRoomCategory.getSmokingPreference());
                }
                if (resortRoomCategory.getsLabel() != null) {
                    existingResortRoomCategory.setsLabel(resortRoomCategory.getsLabel());
                }
                if (resortRoomCategory.getsBedtype() != null) {
                    existingResortRoomCategory.setsBedtype(resortRoomCategory.getsBedtype());
                }
                if (resortRoomCategory.getSellThruRuleYn() != null) {
                    existingResortRoomCategory.setSellThruRuleYn(resortRoomCategory.getSellThruRuleYn());
                }
                if (resortRoomCategory.getCrsDescription() != null) {
                    existingResortRoomCategory.setCrsDescription(resortRoomCategory.getCrsDescription());
                }
                if (resortRoomCategory.getEvisitorFacilityId() != null) {
                    existingResortRoomCategory.setEvisitorFacilityId(resortRoomCategory.getEvisitorFacilityId());
                }
                if (resortRoomCategory.getMinOccupancy() != null) {
                    existingResortRoomCategory.setMinOccupancy(resortRoomCategory.getMinOccupancy());
                }
                if (resortRoomCategory.getAccessibleYn() != null) {
                    existingResortRoomCategory.setAccessibleYn(resortRoomCategory.getAccessibleYn());
                }

                return existingResortRoomCategory;
            })
            .map(resortRoomCategoryRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ResortRoomCategory> findAll(Pageable pageable) {
        log.debug("Request to get all ResortRoomCategories");
        return resortRoomCategoryRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ResortRoomCategory> findOne(Long id) {
        log.debug("Request to get ResortRoomCategory : {}", id);
        return resortRoomCategoryRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ResortRoomCategory : {}", id);
        resortRoomCategoryRepository.deleteById(id);
    }
}
