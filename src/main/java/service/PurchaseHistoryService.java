package service;

import Model.PurchaseHistory;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IPurchaseHistoryRepository;
import repository.projection.IPurchaseItem;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseHistoryService implements  IPurchaseHistoryService{


    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryService(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory)
    {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);

    }
    public List<IPurchaseItem> findPurchaseItemOfUser(Long userId){
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }

}
