package com.sbm.mc.service.impl;

import com.sbm.mc.domain.FinancialTransactions;
import com.sbm.mc.repository.FinancialTransactionsRepository;
import com.sbm.mc.service.FinancialTransactionsService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sbm.mc.domain.FinancialTransactions}.
 */
@Service
@Transactional
public class FinancialTransactionsServiceImpl implements FinancialTransactionsService {

    private final Logger log = LoggerFactory.getLogger(FinancialTransactionsServiceImpl.class);

    private final FinancialTransactionsRepository financialTransactionsRepository;

    public FinancialTransactionsServiceImpl(FinancialTransactionsRepository financialTransactionsRepository) {
        this.financialTransactionsRepository = financialTransactionsRepository;
    }

    @Override
    public FinancialTransactions save(FinancialTransactions financialTransactions) {
        log.debug("Request to save FinancialTransactions : {}", financialTransactions);
        return financialTransactionsRepository.save(financialTransactions);
    }

    @Override
    public FinancialTransactions update(FinancialTransactions financialTransactions) {
        log.debug("Request to update FinancialTransactions : {}", financialTransactions);
        return financialTransactionsRepository.save(financialTransactions);
    }

    @Override
    public Optional<FinancialTransactions> partialUpdate(FinancialTransactions financialTransactions) {
        log.debug("Request to partially update FinancialTransactions : {}", financialTransactions);

        return financialTransactionsRepository
            .findById(financialTransactions.getId())
            .map(existingFinancialTransactions -> {
                if (financialTransactions.getTrxNo() != null) {
                    existingFinancialTransactions.setTrxNo(financialTransactions.getTrxNo());
                }
                if (financialTransactions.getFtSubtype() != null) {
                    existingFinancialTransactions.setFtSubtype(financialTransactions.getFtSubtype());
                }
                if (financialTransactions.getInvoiceCloseDate() != null) {
                    existingFinancialTransactions.setInvoiceCloseDate(financialTransactions.getInvoiceCloseDate());
                }
                if (financialTransactions.getArTransferDate() != null) {
                    existingFinancialTransactions.setArTransferDate(financialTransactions.getArTransferDate());
                }
                if (financialTransactions.getTrxDate() != null) {
                    existingFinancialTransactions.setTrxDate(financialTransactions.getTrxDate());
                }
                if (financialTransactions.getBusinessDate() != null) {
                    existingFinancialTransactions.setBusinessDate(financialTransactions.getBusinessDate());
                }
                if (financialTransactions.getInsertDate() != null) {
                    existingFinancialTransactions.setInsertDate(financialTransactions.getInsertDate());
                }
                if (financialTransactions.getUpdateDate() != null) {
                    existingFinancialTransactions.setUpdateDate(financialTransactions.getUpdateDate());
                }
                if (financialTransactions.getTrnsActivityDate() != null) {
                    existingFinancialTransactions.setTrnsActivityDate(financialTransactions.getTrnsActivityDate());
                }
                if (financialTransactions.getApprovalDate() != null) {
                    existingFinancialTransactions.setApprovalDate(financialTransactions.getApprovalDate());
                }
                if (financialTransactions.getPostingDate() != null) {
                    existingFinancialTransactions.setPostingDate(financialTransactions.getPostingDate());
                }
                if (financialTransactions.getExchangeDate() != null) {
                    existingFinancialTransactions.setExchangeDate(financialTransactions.getExchangeDate());
                }
                if (financialTransactions.getRoutingDate() != null) {
                    existingFinancialTransactions.setRoutingDate(financialTransactions.getRoutingDate());
                }
                if (financialTransactions.getEffectiveDate() != null) {
                    existingFinancialTransactions.setEffectiveDate(financialTransactions.getEffectiveDate());
                }
                if (financialTransactions.getCustomChargeDate() != null) {
                    existingFinancialTransactions.setCustomChargeDate(financialTransactions.getCustomChargeDate());
                }
                if (financialTransactions.getRecptNo() != null) {
                    existingFinancialTransactions.setRecptNo(financialTransactions.getRecptNo());
                }
                if (financialTransactions.getTrxNoAdjust() != null) {
                    existingFinancialTransactions.setTrxNoAdjust(financialTransactions.getTrxNoAdjust());
                }
                if (financialTransactions.getTrxNoAddedBy() != null) {
                    existingFinancialTransactions.setTrxNoAddedBy(financialTransactions.getTrxNoAddedBy());
                }
                if (financialTransactions.getTrxNoAgainstPackage() != null) {
                    existingFinancialTransactions.setTrxNoAgainstPackage(financialTransactions.getTrxNoAgainstPackage());
                }
                if (financialTransactions.getTrxNoHeader() != null) {
                    existingFinancialTransactions.setTrxNoHeader(financialTransactions.getTrxNoHeader());
                }
                if (financialTransactions.getArNumber() != null) {
                    existingFinancialTransactions.setArNumber(financialTransactions.getArNumber());
                }
                if (financialTransactions.getResvNameId() != null) {
                    existingFinancialTransactions.setResvNameId(financialTransactions.getResvNameId());
                }
                if (financialTransactions.getCashierId() != null) {
                    existingFinancialTransactions.setCashierId(financialTransactions.getCashierId());
                }
                if (financialTransactions.getCreditCardId() != null) {
                    existingFinancialTransactions.setCreditCardId(financialTransactions.getCreditCardId());
                }
                if (financialTransactions.getNameId() != null) {
                    existingFinancialTransactions.setNameId(financialTransactions.getNameId());
                }
                if (financialTransactions.getTranActionId() != null) {
                    existingFinancialTransactions.setTranActionId(financialTransactions.getTranActionId());
                }
                if (financialTransactions.getFinDmlSeqNo() != null) {
                    existingFinancialTransactions.setFinDmlSeqNo(financialTransactions.getFinDmlSeqNo());
                }
                if (financialTransactions.getRoutingInstrnId() != null) {
                    existingFinancialTransactions.setRoutingInstrnId(financialTransactions.getRoutingInstrnId());
                }
                if (financialTransactions.getFromResvId() != null) {
                    existingFinancialTransactions.setFromResvId(financialTransactions.getFromResvId());
                }
                if (financialTransactions.getGenCashierId() != null) {
                    existingFinancialTransactions.setGenCashierId(financialTransactions.getGenCashierId());
                }
                if (financialTransactions.getFolioNo() != null) {
                    existingFinancialTransactions.setFolioNo(financialTransactions.getFolioNo());
                }
                if (financialTransactions.getInvoiceNo() != null) {
                    existingFinancialTransactions.setInvoiceNo(financialTransactions.getInvoiceNo());
                }
                if (financialTransactions.getInsertUser() != null) {
                    existingFinancialTransactions.setInsertUser(financialTransactions.getInsertUser());
                }
                if (financialTransactions.getUpdateUser() != null) {
                    existingFinancialTransactions.setUpdateUser(financialTransactions.getUpdateUser());
                }
                if (financialTransactions.getArrangementId() != null) {
                    existingFinancialTransactions.setArrangementId(financialTransactions.getArrangementId());
                }
                if (financialTransactions.getTrnsFromAcct() != null) {
                    existingFinancialTransactions.setTrnsFromAcct(financialTransactions.getTrnsFromAcct());
                }
                if (financialTransactions.getTrnsToAcct() != null) {
                    existingFinancialTransactions.setTrnsToAcct(financialTransactions.getTrnsToAcct());
                }
                if (financialTransactions.getBillNo() != null) {
                    existingFinancialTransactions.setBillNo(financialTransactions.getBillNo());
                }
                if (financialTransactions.getRevisionNo() != null) {
                    existingFinancialTransactions.setRevisionNo(financialTransactions.getRevisionNo());
                }
                if (financialTransactions.getResvDepositId() != null) {
                    existingFinancialTransactions.setResvDepositId(financialTransactions.getResvDepositId());
                }
                if (financialTransactions.getLinkTrxNo() != null) {
                    existingFinancialTransactions.setLinkTrxNo(financialTransactions.getLinkTrxNo());
                }
                if (financialTransactions.getAuthorizerId() != null) {
                    existingFinancialTransactions.setAuthorizerId(financialTransactions.getAuthorizerId());
                }
                if (financialTransactions.getCompLinkTrxNo() != null) {
                    existingFinancialTransactions.setCompLinkTrxNo(financialTransactions.getCompLinkTrxNo());
                }
                if (financialTransactions.getMtrxNoAgainstPackage() != null) {
                    existingFinancialTransactions.setMtrxNoAgainstPackage(financialTransactions.getMtrxNoAgainstPackage());
                }
                if (financialTransactions.getForexCommPerc() != null) {
                    existingFinancialTransactions.setForexCommPerc(financialTransactions.getForexCommPerc());
                }
                if (financialTransactions.getForexCommAmount() != null) {
                    existingFinancialTransactions.setForexCommAmount(financialTransactions.getForexCommAmount());
                }
                if (financialTransactions.getArticleId() != null) {
                    existingFinancialTransactions.setArticleId(financialTransactions.getArticleId());
                }
                if (financialTransactions.getToResvNameId() != null) {
                    existingFinancialTransactions.setToResvNameId(financialTransactions.getToResvNameId());
                }
                if (financialTransactions.getRoomNts() != null) {
                    existingFinancialTransactions.setRoomNts(financialTransactions.getRoomNts());
                }
                if (financialTransactions.getOrgArLedDebit() != null) {
                    existingFinancialTransactions.setOrgArLedDebit(financialTransactions.getOrgArLedDebit());
                }
                if (financialTransactions.getClosureNo() != null) {
                    existingFinancialTransactions.setClosureNo(financialTransactions.getClosureNo());
                }
                if (financialTransactions.getOriginalResvNameId() != null) {
                    existingFinancialTransactions.setOriginalResvNameId(financialTransactions.getOriginalResvNameId());
                }
                if (financialTransactions.getOrgBillNo() != null) {
                    existingFinancialTransactions.setOrgBillNo(financialTransactions.getOrgBillNo());
                }
                if (financialTransactions.getMembershipId() != null) {
                    existingFinancialTransactions.setMembershipId(financialTransactions.getMembershipId());
                }
                if (financialTransactions.getInstallments() != null) {
                    existingFinancialTransactions.setInstallments(financialTransactions.getInstallments());
                }
                if (financialTransactions.getContractGuestDebit() != null) {
                    existingFinancialTransactions.setContractGuestDebit(financialTransactions.getContractGuestDebit());
                }
                if (financialTransactions.getContractGuestCredit() != null) {
                    existingFinancialTransactions.setContractGuestCredit(financialTransactions.getContractGuestCredit());
                }
                if (financialTransactions.getContractNetAmount() != null) {
                    existingFinancialTransactions.setContractNetAmount(financialTransactions.getContractNetAmount());
                }
                if (financialTransactions.getContractGrossAmount() != null) {
                    existingFinancialTransactions.setContractGrossAmount(financialTransactions.getContractGrossAmount());
                }
                if (financialTransactions.getPostitNo() != null) {
                    existingFinancialTransactions.setPostitNo(financialTransactions.getPostitNo());
                }
                if (financialTransactions.getCcTrxFeeAmount() != null) {
                    existingFinancialTransactions.setCcTrxFeeAmount(financialTransactions.getCcTrxFeeAmount());
                }
                if (financialTransactions.getChangeDue() != null) {
                    existingFinancialTransactions.setChangeDue(financialTransactions.getChangeDue());
                }
                if (financialTransactions.getPostingSourceNameId() != null) {
                    existingFinancialTransactions.setPostingSourceNameId(financialTransactions.getPostingSourceNameId());
                }
                if (financialTransactions.getBonusCheckId() != null) {
                    existingFinancialTransactions.setBonusCheckId(financialTransactions.getBonusCheckId());
                }
                if (financialTransactions.getRoundLinkTrxno() != null) {
                    existingFinancialTransactions.setRoundLinkTrxno(financialTransactions.getRoundLinkTrxno());
                }
                if (financialTransactions.getReversePaymentTrxNo() != null) {
                    existingFinancialTransactions.setReversePaymentTrxNo(financialTransactions.getReversePaymentTrxNo());
                }
                if (financialTransactions.getElectronicVoucherNo() != null) {
                    existingFinancialTransactions.setElectronicVoucherNo(financialTransactions.getElectronicVoucherNo());
                }
                if (financialTransactions.getThresholdDiversionId() != null) {
                    existingFinancialTransactions.setThresholdDiversionId(financialTransactions.getThresholdDiversionId());
                }
                if (financialTransactions.getThresholdEntityQty() != null) {
                    existingFinancialTransactions.setThresholdEntityQty(financialTransactions.getThresholdEntityQty());
                }
                if (financialTransactions.getTrxNoSplit() != null) {
                    existingFinancialTransactions.setTrxNoSplit(financialTransactions.getTrxNoSplit());
                }
                if (financialTransactions.getExchDiffTrxNo() != null) {
                    existingFinancialTransactions.setExchDiffTrxNo(financialTransactions.getExchDiffTrxNo());
                }
                if (financialTransactions.getAssociatedTrxNo() != null) {
                    existingFinancialTransactions.setAssociatedTrxNo(financialTransactions.getAssociatedTrxNo());
                }
                if (financialTransactions.getTaxRate() != null) {
                    existingFinancialTransactions.setTaxRate(financialTransactions.getTaxRate());
                }
                if (financialTransactions.getPropChargeId() != null) {
                    existingFinancialTransactions.setPropChargeId(financialTransactions.getPropChargeId());
                }
                if (financialTransactions.getQuantity() != null) {
                    existingFinancialTransactions.setQuantity(financialTransactions.getQuantity());
                }
                if (financialTransactions.getNetAmount() != null) {
                    existingFinancialTransactions.setNetAmount(financialTransactions.getNetAmount());
                }
                if (financialTransactions.getGrossAmount() != null) {
                    existingFinancialTransactions.setGrossAmount(financialTransactions.getGrossAmount());
                }
                if (financialTransactions.getCashierOpeningBalance() != null) {
                    existingFinancialTransactions.setCashierOpeningBalance(financialTransactions.getCashierOpeningBalance());
                }
                if (financialTransactions.getPricePerUnit() != null) {
                    existingFinancialTransactions.setPricePerUnit(financialTransactions.getPricePerUnit());
                }
                if (financialTransactions.getTrxAmount() != null) {
                    existingFinancialTransactions.setTrxAmount(financialTransactions.getTrxAmount());
                }
                if (financialTransactions.getPostedAmount() != null) {
                    existingFinancialTransactions.setPostedAmount(financialTransactions.getPostedAmount());
                }
                if (financialTransactions.getGuestAccountCredit() != null) {
                    existingFinancialTransactions.setGuestAccountCredit(financialTransactions.getGuestAccountCredit());
                }
                if (financialTransactions.getExchangeRate() != null) {
                    existingFinancialTransactions.setExchangeRate(financialTransactions.getExchangeRate());
                }
                if (financialTransactions.getGuestAccountDebit() != null) {
                    existingFinancialTransactions.setGuestAccountDebit(financialTransactions.getGuestAccountDebit());
                }
                if (financialTransactions.getCashierCredit() != null) {
                    existingFinancialTransactions.setCashierCredit(financialTransactions.getCashierCredit());
                }
                if (financialTransactions.getCashierDebit() != null) {
                    existingFinancialTransactions.setCashierDebit(financialTransactions.getCashierDebit());
                }
                if (financialTransactions.getPackageCredit() != null) {
                    existingFinancialTransactions.setPackageCredit(financialTransactions.getPackageCredit());
                }
                if (financialTransactions.getPackageDebit() != null) {
                    existingFinancialTransactions.setPackageDebit(financialTransactions.getPackageDebit());
                }
                if (financialTransactions.getDepLedCredit() != null) {
                    existingFinancialTransactions.setDepLedCredit(financialTransactions.getDepLedCredit());
                }
                if (financialTransactions.getDepLedDebit() != null) {
                    existingFinancialTransactions.setDepLedDebit(financialTransactions.getDepLedDebit());
                }
                if (financialTransactions.getRevenueAmt() != null) {
                    existingFinancialTransactions.setRevenueAmt(financialTransactions.getRevenueAmt());
                }
                if (financialTransactions.getArLedCredit() != null) {
                    existingFinancialTransactions.setArLedCredit(financialTransactions.getArLedCredit());
                }
                if (financialTransactions.getArLedDebit() != null) {
                    existingFinancialTransactions.setArLedDebit(financialTransactions.getArLedDebit());
                }
                if (financialTransactions.getEuroExchangeRate() != null) {
                    existingFinancialTransactions.setEuroExchangeRate(financialTransactions.getEuroExchangeRate());
                }
                if (financialTransactions.getInhDebit() != null) {
                    existingFinancialTransactions.setInhDebit(financialTransactions.getInhDebit());
                }
                if (financialTransactions.getInhCredit() != null) {
                    existingFinancialTransactions.setInhCredit(financialTransactions.getInhCredit());
                }
                if (financialTransactions.getPackageAllowance() != null) {
                    existingFinancialTransactions.setPackageAllowance(financialTransactions.getPackageAllowance());
                }
                if (financialTransactions.getParallelGuestCredit() != null) {
                    existingFinancialTransactions.setParallelGuestCredit(financialTransactions.getParallelGuestCredit());
                }
                if (financialTransactions.getParallelGuestDebit() != null) {
                    existingFinancialTransactions.setParallelGuestDebit(financialTransactions.getParallelGuestDebit());
                }
                if (financialTransactions.getParallelNetAmount() != null) {
                    existingFinancialTransactions.setParallelNetAmount(financialTransactions.getParallelNetAmount());
                }
                if (financialTransactions.getParallelGrossAmount() != null) {
                    existingFinancialTransactions.setParallelGrossAmount(financialTransactions.getParallelGrossAmount());
                }
                if (financialTransactions.getOrgPostedAmount() != null) {
                    existingFinancialTransactions.setOrgPostedAmount(financialTransactions.getOrgPostedAmount());
                }
                if (financialTransactions.getRoomNtsEffective() != null) {
                    existingFinancialTransactions.setRoomNtsEffective(financialTransactions.getRoomNtsEffective());
                }
                if (financialTransactions.getPaymentSurchargeAmt() != null) {
                    existingFinancialTransactions.setPaymentSurchargeAmt(financialTransactions.getPaymentSurchargeAmt());
                }
                if (financialTransactions.getFolioView() != null) {
                    existingFinancialTransactions.setFolioView(financialTransactions.getFolioView());
                }
                if (financialTransactions.getTaxInclusiveYn() != null) {
                    existingFinancialTransactions.setTaxInclusiveYn(financialTransactions.getTaxInclusiveYn());
                }
                if (financialTransactions.getDeferredYn() != null) {
                    existingFinancialTransactions.setDeferredYn(financialTransactions.getDeferredYn());
                }
                if (financialTransactions.getIndAdjustmentYn() != null) {
                    existingFinancialTransactions.setIndAdjustmentYn(financialTransactions.getIndAdjustmentYn());
                }
                if (financialTransactions.getFixedChargesYn() != null) {
                    existingFinancialTransactions.setFixedChargesYn(financialTransactions.getFixedChargesYn());
                }
                if (financialTransactions.getTaCommissionableYn() != null) {
                    existingFinancialTransactions.setTaCommissionableYn(financialTransactions.getTaCommissionableYn());
                }
                if (financialTransactions.getTaxGeneratedYn() != null) {
                    existingFinancialTransactions.setTaxGeneratedYn(financialTransactions.getTaxGeneratedYn());
                }
                if (financialTransactions.getCompressedYn() != null) {
                    existingFinancialTransactions.setCompressedYn(financialTransactions.getCompressedYn());
                }
                if (financialTransactions.getDisplayYn() != null) {
                    existingFinancialTransactions.setDisplayYn(financialTransactions.getDisplayYn());
                }
                if (financialTransactions.getCollAgentPostingYn() != null) {
                    existingFinancialTransactions.setCollAgentPostingYn(financialTransactions.getCollAgentPostingYn());
                }
                if (financialTransactions.getFiscalTrxCodeType() != null) {
                    existingFinancialTransactions.setFiscalTrxCodeType(financialTransactions.getFiscalTrxCodeType());
                }
                if (financialTransactions.getDeferredTaxesYn() != null) {
                    existingFinancialTransactions.setDeferredTaxesYn(financialTransactions.getDeferredTaxesYn());
                }
                if (financialTransactions.getAdvancedGenerateYn() != null) {
                    existingFinancialTransactions.setAdvancedGenerateYn(financialTransactions.getAdvancedGenerateYn());
                }
                if (financialTransactions.getForexType() != null) {
                    existingFinancialTransactions.setForexType(financialTransactions.getForexType());
                }
                if (financialTransactions.getTaCommissionNetYn() != null) {
                    existingFinancialTransactions.setTaCommissionNetYn(financialTransactions.getTaCommissionNetYn());
                }
                if (financialTransactions.getSourceCommissionNetYn() != null) {
                    existingFinancialTransactions.setSourceCommissionNetYn(financialTransactions.getSourceCommissionNetYn());
                }
                if (financialTransactions.getSettlementFlag() != null) {
                    existingFinancialTransactions.setSettlementFlag(financialTransactions.getSettlementFlag());
                }
                if (financialTransactions.getAccTypeFlag() != null) {
                    existingFinancialTransactions.setAccTypeFlag(financialTransactions.getAccTypeFlag());
                }
                if (financialTransactions.getProfitLossFlag() != null) {
                    existingFinancialTransactions.setProfitLossFlag(financialTransactions.getProfitLossFlag());
                }
                if (financialTransactions.getProformaYn() != null) {
                    existingFinancialTransactions.setProformaYn(financialTransactions.getProformaYn());
                }
                if (financialTransactions.getHoldYn() != null) {
                    existingFinancialTransactions.setHoldYn(financialTransactions.getHoldYn());
                }
                if (financialTransactions.getExchangeDifferenceYn() != null) {
                    existingFinancialTransactions.setExchangeDifferenceYn(financialTransactions.getExchangeDifferenceYn());
                }
                if (financialTransactions.getCalcPointsYn() != null) {
                    existingFinancialTransactions.setCalcPointsYn(financialTransactions.getCalcPointsYn());
                }
                if (financialTransactions.getArChargeTransferYn() != null) {
                    existingFinancialTransactions.setArChargeTransferYn(financialTransactions.getArChargeTransferYn());
                }
                if (financialTransactions.getProcessed8300Yn() != null) {
                    existingFinancialTransactions.setProcessed8300Yn(financialTransactions.getProcessed8300Yn());
                }
                if (financialTransactions.getAsbFlag() != null) {
                    existingFinancialTransactions.setAsbFlag(financialTransactions.getAsbFlag());
                }
                if (financialTransactions.getPostitYn() != null) {
                    existingFinancialTransactions.setPostitYn(financialTransactions.getPostitYn());
                }
                if (financialTransactions.getAutoSettleYn() != null) {
                    existingFinancialTransactions.setAutoSettleYn(financialTransactions.getAutoSettleYn());
                }
                if (financialTransactions.getDepTaxTransferedYn() != null) {
                    existingFinancialTransactions.setDepTaxTransferedYn(financialTransactions.getDepTaxTransferedYn());
                }
                if (financialTransactions.getAutoCreditbillYn() != null) {
                    existingFinancialTransactions.setAutoCreditbillYn(financialTransactions.getAutoCreditbillYn());
                }
                if (financialTransactions.getAsbOnlyPostTaxesOnceYn() != null) {
                    existingFinancialTransactions.setAsbOnlyPostTaxesOnceYn(financialTransactions.getAsbOnlyPostTaxesOnceYn());
                }
                if (financialTransactions.getRoundFactorYn() != null) {
                    existingFinancialTransactions.setRoundFactorYn(financialTransactions.getRoundFactorYn());
                }
                if (financialTransactions.getDepPostingFlag() != null) {
                    existingFinancialTransactions.setDepPostingFlag(financialTransactions.getDepPostingFlag());
                }
                if (financialTransactions.getCorrectionYn() != null) {
                    existingFinancialTransactions.setCorrectionYn(financialTransactions.getCorrectionYn());
                }
                if (financialTransactions.getRoutedYn() != null) {
                    existingFinancialTransactions.setRoutedYn(financialTransactions.getRoutedYn());
                }
                if (financialTransactions.getUpsellChargeYn() != null) {
                    existingFinancialTransactions.setUpsellChargeYn(financialTransactions.getUpsellChargeYn());
                }
                if (financialTransactions.getAdvanceBillYn() != null) {
                    existingFinancialTransactions.setAdvanceBillYn(financialTransactions.getAdvanceBillYn());
                }
                if (financialTransactions.getAdvanceBillReversedYn() != null) {
                    existingFinancialTransactions.setAdvanceBillReversedYn(financialTransactions.getAdvanceBillReversedYn());
                }
                if (financialTransactions.getIncTaxDeductedYn() != null) {
                    existingFinancialTransactions.setIncTaxDeductedYn(financialTransactions.getIncTaxDeductedYn());
                }
                if (financialTransactions.getGpAwardCancelledYn() != null) {
                    existingFinancialTransactions.setGpAwardCancelledYn(financialTransactions.getGpAwardCancelledYn());
                }
                if (financialTransactions.getServiceRecoveryAdjustmentYn() != null) {
                    existingFinancialTransactions.setServiceRecoveryAdjustmentYn(financialTransactions.getServiceRecoveryAdjustmentYn());
                }
                if (financialTransactions.getSplitType() != null) {
                    existingFinancialTransactions.setSplitType(financialTransactions.getSplitType());
                }
                if (financialTransactions.getBucketRedempYn() != null) {
                    existingFinancialTransactions.setBucketRedempYn(financialTransactions.getBucketRedempYn());
                }
                if (financialTransactions.getVatOffsetYn() != null) {
                    existingFinancialTransactions.setVatOffsetYn(financialTransactions.getVatOffsetYn());
                }
                if (financialTransactions.getForexTaxYn() != null) {
                    existingFinancialTransactions.setForexTaxYn(financialTransactions.getForexTaxYn());
                }
                if (financialTransactions.getStampDutyYn() != null) {
                    existingFinancialTransactions.setStampDutyYn(financialTransactions.getStampDutyYn());
                }
                if (financialTransactions.getCovers() != null) {
                    existingFinancialTransactions.setCovers(financialTransactions.getCovers());
                }
                if (financialTransactions.getAdvGenerateAdjustment() != null) {
                    existingFinancialTransactions.setAdvGenerateAdjustment(financialTransactions.getAdvGenerateAdjustment());
                }
                if (financialTransactions.getExpInvoiceType() != null) {
                    existingFinancialTransactions.setExpInvoiceType(financialTransactions.getExpInvoiceType());
                }
                if (financialTransactions.getFolioType() != null) {
                    existingFinancialTransactions.setFolioType(financialTransactions.getFolioType());
                }
                if (financialTransactions.getOrgFolioType() != null) {
                    existingFinancialTransactions.setOrgFolioType(financialTransactions.getOrgFolioType());
                }
                if (financialTransactions.getInvoiceType() != null) {
                    existingFinancialTransactions.setInvoiceType(financialTransactions.getInvoiceType());
                }
                if (financialTransactions.getArState() != null) {
                    existingFinancialTransactions.setArState(financialTransactions.getArState());
                }
                if (financialTransactions.getExchangeType() != null) {
                    existingFinancialTransactions.setExchangeType(financialTransactions.getExchangeType());
                }
                if (financialTransactions.getRecptType() != null) {
                    existingFinancialTransactions.setRecptType(financialTransactions.getRecptType());
                }
                if (financialTransactions.getRoomClass() != null) {
                    existingFinancialTransactions.setRoomClass(financialTransactions.getRoomClass());
                }
                if (financialTransactions.getResort() != null) {
                    existingFinancialTransactions.setResort(financialTransactions.getResort());
                }
                if (financialTransactions.getTcGroup() != null) {
                    existingFinancialTransactions.setTcGroup(financialTransactions.getTcGroup());
                }
                if (financialTransactions.getTcSubgroup() != null) {
                    existingFinancialTransactions.setTcSubgroup(financialTransactions.getTcSubgroup());
                }
                if (financialTransactions.getTrxCode() != null) {
                    existingFinancialTransactions.setTrxCode(financialTransactions.getTrxCode());
                }
                if (financialTransactions.getRoom() != null) {
                    existingFinancialTransactions.setRoom(financialTransactions.getRoom());
                }
                if (financialTransactions.getTclCode1() != null) {
                    existingFinancialTransactions.setTclCode1(financialTransactions.getTclCode1());
                }
                if (financialTransactions.getCurrency() != null) {
                    existingFinancialTransactions.setCurrency(financialTransactions.getCurrency());
                }
                if (financialTransactions.getFtGeneratedType() != null) {
                    existingFinancialTransactions.setFtGeneratedType(financialTransactions.getFtGeneratedType());
                }
                if (financialTransactions.getTclCode2() != null) {
                    existingFinancialTransactions.setTclCode2(financialTransactions.getTclCode2());
                }
                if (financialTransactions.getMarketCode() != null) {
                    existingFinancialTransactions.setMarketCode(financialTransactions.getMarketCode());
                }
                if (financialTransactions.getSourceCode() != null) {
                    existingFinancialTransactions.setSourceCode(financialTransactions.getSourceCode());
                }
                if (financialTransactions.getRateCode() != null) {
                    existingFinancialTransactions.setRateCode(financialTransactions.getRateCode());
                }
                if (financialTransactions.getHotelAcct() != null) {
                    existingFinancialTransactions.setHotelAcct(financialTransactions.getHotelAcct());
                }
                if (financialTransactions.getReasonCode() != null) {
                    existingFinancialTransactions.setReasonCode(financialTransactions.getReasonCode());
                }
                if (financialTransactions.getProduct() != null) {
                    existingFinancialTransactions.setProduct(financialTransactions.getProduct());
                }
                if (financialTransactions.getTargetResort() != null) {
                    existingFinancialTransactions.setTargetResort(financialTransactions.getTargetResort());
                }
                if (financialTransactions.getNameTaxType() != null) {
                    existingFinancialTransactions.setNameTaxType(financialTransactions.getNameTaxType());
                }
                if (financialTransactions.getTaxInvNo() != null) {
                    existingFinancialTransactions.setTaxInvNo(financialTransactions.getTaxInvNo());
                }
                if (financialTransactions.getApprovalCode() != null) {
                    existingFinancialTransactions.setApprovalCode(financialTransactions.getApprovalCode());
                }
                if (financialTransactions.getApprovalStatus() != null) {
                    existingFinancialTransactions.setApprovalStatus(financialTransactions.getApprovalStatus());
                }
                if (financialTransactions.getCompLinkTrxCode() != null) {
                    existingFinancialTransactions.setCompLinkTrxCode(financialTransactions.getCompLinkTrxCode());
                }
                if (financialTransactions.getCompTypeCode() != null) {
                    existingFinancialTransactions.setCompTypeCode(financialTransactions.getCompTypeCode());
                }
                if (financialTransactions.getCouponNo() != null) {
                    existingFinancialTransactions.setCouponNo(financialTransactions.getCouponNo());
                }
                if (financialTransactions.getOriginalRoom() != null) {
                    existingFinancialTransactions.setOriginalRoom(financialTransactions.getOriginalRoom());
                }
                if (financialTransactions.getAllowanceType() != null) {
                    existingFinancialTransactions.setAllowanceType(financialTransactions.getAllowanceType());
                }
                if (financialTransactions.getAdvGenerateTrxCode() != null) {
                    existingFinancialTransactions.setAdvGenerateTrxCode(financialTransactions.getAdvGenerateTrxCode());
                }
                if (financialTransactions.getTrxServiceType() != null) {
                    existingFinancialTransactions.setTrxServiceType(financialTransactions.getTrxServiceType());
                }
                if (financialTransactions.getPostingType() != null) {
                    existingFinancialTransactions.setPostingType(financialTransactions.getPostingType());
                }
                if (financialTransactions.getParallelCurrency() != null) {
                    existingFinancialTransactions.setParallelCurrency(financialTransactions.getParallelCurrency());
                }
                if (financialTransactions.getContractCurrency() != null) {
                    existingFinancialTransactions.setContractCurrency(financialTransactions.getContractCurrency());
                }
                if (financialTransactions.getFbaCertificateNumber() != null) {
                    existingFinancialTransactions.setFbaCertificateNumber(financialTransactions.getFbaCertificateNumber());
                }
                if (financialTransactions.getPostingRhythm() != null) {
                    existingFinancialTransactions.setPostingRhythm(financialTransactions.getPostingRhythm());
                }
                if (financialTransactions.getAsbTaxFlag() != null) {
                    existingFinancialTransactions.setAsbTaxFlag(financialTransactions.getAsbTaxFlag());
                }
                if (financialTransactions.getPackageArrangementCode() != null) {
                    existingFinancialTransactions.setPackageArrangementCode(financialTransactions.getPackageArrangementCode());
                }
                if (financialTransactions.getGpAwardCode() != null) {
                    existingFinancialTransactions.setGpAwardCode(financialTransactions.getGpAwardCode());
                }
                if (financialTransactions.getGpAwardCancelCode() != null) {
                    existingFinancialTransactions.setGpAwardCancelCode(financialTransactions.getGpAwardCancelCode());
                }
                if (financialTransactions.getServiceRecoveryDeptCode() != null) {
                    existingFinancialTransactions.setServiceRecoveryDeptCode(financialTransactions.getServiceRecoveryDeptCode());
                }
                if (financialTransactions.getBucketCode() != null) {
                    existingFinancialTransactions.setBucketCode(financialTransactions.getBucketCode());
                }
                if (financialTransactions.getTaxRateType() != null) {
                    existingFinancialTransactions.setTaxRateType(financialTransactions.getTaxRateType());
                }
                if (financialTransactions.getChequeNumber() != null) {
                    existingFinancialTransactions.setChequeNumber(financialTransactions.getChequeNumber());
                }
                if (financialTransactions.getPasserByName() != null) {
                    existingFinancialTransactions.setPasserByName(financialTransactions.getPasserByName());
                }
                if (financialTransactions.getEsignedReceiptName() != null) {
                    existingFinancialTransactions.setEsignedReceiptName(financialTransactions.getEsignedReceiptName());
                }
                if (financialTransactions.getRemark() != null) {
                    existingFinancialTransactions.setRemark(financialTransactions.getRemark());
                }
                if (financialTransactions.getReference() != null) {
                    existingFinancialTransactions.setReference(financialTransactions.getReference());
                }
                if (financialTransactions.getoTrxDesc() != null) {
                    existingFinancialTransactions.setoTrxDesc(financialTransactions.getoTrxDesc());
                }
                if (financialTransactions.getComments() != null) {
                    existingFinancialTransactions.setComments(financialTransactions.getComments());
                }
                if (financialTransactions.getFiscalBillNo() != null) {
                    existingFinancialTransactions.setFiscalBillNo(financialTransactions.getFiscalBillNo());
                }
                if (financialTransactions.getExtSysResultMsg() != null) {
                    existingFinancialTransactions.setExtSysResultMsg(financialTransactions.getExtSysResultMsg());
                }
                if (financialTransactions.getQueueName() != null) {
                    existingFinancialTransactions.setQueueName(financialTransactions.getQueueName());
                }
                if (financialTransactions.getPaymentType() != null) {
                    existingFinancialTransactions.setPaymentType(financialTransactions.getPaymentType());
                }
                if (financialTransactions.getCcRefundPosting() != null) {
                    existingFinancialTransactions.setCcRefundPosting(financialTransactions.getCcRefundPosting());
                }
                if (financialTransactions.getThresholdEntityType() != null) {
                    existingFinancialTransactions.setThresholdEntityType(financialTransactions.getThresholdEntityType());
                }
                if (financialTransactions.getThresholdTreatmentFlag() != null) {
                    existingFinancialTransactions.setThresholdTreatmentFlag(financialTransactions.getThresholdTreatmentFlag());
                }
                if (financialTransactions.getPaymentSurchargeType() != null) {
                    existingFinancialTransactions.setPaymentSurchargeType(financialTransactions.getPaymentSurchargeType());
                }
                if (financialTransactions.getPropertyBillPrefix() != null) {
                    existingFinancialTransactions.setPropertyBillPrefix(financialTransactions.getPropertyBillPrefix());
                }
                if (financialTransactions.getTaxElements() != null) {
                    existingFinancialTransactions.setTaxElements(financialTransactions.getTaxElements());
                }
                if (financialTransactions.getNumberDialed() != null) {
                    existingFinancialTransactions.setNumberDialed(financialTransactions.getNumberDialed());
                }
                if (financialTransactions.getCheckFileId() != null) {
                    existingFinancialTransactions.setCheckFileId(financialTransactions.getCheckFileId());
                }
                if (financialTransactions.getExtTrxId() != null) {
                    existingFinancialTransactions.setExtTrxId(financialTransactions.getExtTrxId());
                }
                if (financialTransactions.getPackageTrxType() != null) {
                    existingFinancialTransactions.setPackageTrxType(financialTransactions.getPackageTrxType());
                }
                if (financialTransactions.getExpOriginalInvoice() != null) {
                    existingFinancialTransactions.setExpOriginalInvoice(financialTransactions.getExpOriginalInvoice());
                }
                if (financialTransactions.getDepositTransactionId() != null) {
                    existingFinancialTransactions.setDepositTransactionId(financialTransactions.getDepositTransactionId());
                }

                return existingFinancialTransactions;
            })
            .map(financialTransactionsRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<FinancialTransactions> findAll(Pageable pageable) {
        log.debug("Request to get all FinancialTransactions");
        return financialTransactionsRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FinancialTransactions> findOne(Integer id) {
        log.debug("Request to get FinancialTransactions : {}", id);
        return financialTransactionsRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete FinancialTransactions : {}", id);
        financialTransactionsRepository.deleteById(id);
    }
}
