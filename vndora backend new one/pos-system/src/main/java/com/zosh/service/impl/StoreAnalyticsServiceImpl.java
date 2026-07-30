package com.zosh.service.impl;

import com.zosh.domain.UserRole;
import com.zosh.modal.Order;
import com.zosh.payload.StoreAnalysis.*;
import com.zosh.repository.*;
import com.zosh.service.StoreAnalyticsService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class StoreAnalyticsServiceImpl implements StoreAnalyticsService {

    private final BranchRepository branchRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
   
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;


    // Constructor Injection (Replacement of @RequiredArgsConstructor)
    public StoreAnalyticsServiceImpl(
            BranchRepository branchRepository,
            OrderRepository orderRepository,
            ProductRepository productRepository,
           
            UserRepository userRepository,
            CustomerRepository customerRepository
    ) {
        this.branchRepository = branchRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
     
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public StoreOverviewDTO getStoreOverview(Long storeAdminId) {

        List<UserRole> roles = new ArrayList<>();

        roles.add(UserRole.ROLE_STORE_MANAGER);
        roles.add(UserRole.ROLE_CUSTOMER);
        roles.add(UserRole.ROLE_BRANCH_CASHIER);
        roles.add(UserRole.ROLE_BRANCH_MANAGER);


        StoreOverviewDTO dto = new StoreOverviewDTO();

        dto.setTotalBranches(
                branchRepository.countByStoreAdminId(storeAdminId));

        dto.setTotalSales(
                orderRepository.sumTotalSalesByStoreAdmin(storeAdminId)
                        .orElse(0.0));

        dto.setTotalOrders(
                orderRepository.countByStoreAdminId(storeAdminId));

        dto.setTotalEmployees(
                userRepository.countByStoreAdminIdAndRoles(
                        storeAdminId,
                        roles));

        dto.setTotalCustomers(
                customerRepository.countByStoreAdminId(storeAdminId));

      
        

        dto.setTotalProducts(
                productRepository.countByStoreAdminId(storeAdminId));

        return dto;
    }


    @Override
    public TimeSeriesDataDTO getSalesTrends(
            Long storeAdminId,
            String period
    ) {
        return null;
    }


    @Override
    public List<TimeSeriesPointDTO> getMonthlySalesGraph(
            Long storeAdminId
    ) {

        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusDays(365);


        List<Order> orders =
                orderRepository.findAllByStoreAdminAndCreatedAtBetween(
                        storeAdminId,
                        start,
                        end
                );


        Map<YearMonth, Double> grouped =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                order -> YearMonth.from(
                                        order.getCreatedAt()
                                ),
                                Collectors.summingDouble(order ->
                                        order.getTotalAmount() != null
                                                ?
                                        order.getTotalAmount().doubleValue()
                                                :
                                        0.0
                                )
                        ));


        return grouped.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry ->
                        new TimeSeriesPointDTO(
                                entry.getKey()
                                        .atDay(1)
                                        .atStartOfDay(),
                                entry.getValue()
                        )
                )
                .collect(Collectors.toList());
    }


    @Override
    public List<TimeSeriesPointDTO> getDailySalesGraph(
            Long storeAdminId
    ) {

        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusDays(6);

        return orderRepository.getDailySales(
                storeAdminId,
                start,
                end
        );
    }


    @Override
    public List<CategorySalesDTO> getSalesByCategory(
            Long storeAdminId
    ) {

        return productRepository.getSalesGroupedByCategory(
                storeAdminId
        );
    }


   

    @Override
    public List<BranchSalesDTO> getSalesByBranch(
            Long storeAdminId
    ) {

        return orderRepository.getSalesByBranch(
                storeAdminId
        );
    }




    @Override
    public BranchPerformanceDTO getBranchPerformance(
            Long storeAdminId
    ) {

    	BranchPerformanceDTO dto = new BranchPerformanceDTO();

    	dto.setBranchSales(
    	        orderRepository.getSalesByBranch(storeAdminId));

    	dto.setNewBranchesThisMonth(
    	        branchRepository.countNewBranchesThisMonth(storeAdminId));

    	return dto;
    }


    @Override
    public StoreAlertDTO getStoreAlerts(
            Long storeAdminId
    ) {

        LocalDateTime sevenDaysAgo =
                LocalDateTime.now().minusDays(7);


        StoreAlertDTO dto = new StoreAlertDTO();

        dto.setLowStockAlerts(
                productRepository.findLowStockProducts(storeAdminId));

        dto.setNoSalesToday(
                branchRepository.findBranchesWithNoSalesToday(storeAdminId));

    

        dto.setInactiveCashiers(
                userRepository.findInactiveCashiers(
                        storeAdminId,
                        sevenDaysAgo));

        return dto;
    }
}