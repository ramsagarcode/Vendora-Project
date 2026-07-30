package com.zosh.service.impl;


import com.zosh.payload.dto.*;
import com.zosh.repository.InventoryRepository;
import com.zosh.repository.OrderItemRepository;
import com.zosh.repository.OrderRepository;
import com.zosh.service.BranchAnalyticsService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BranchAnalyticsServiceImpl implements BranchAnalyticsService {


    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final InventoryRepository inventoryRepository;



    public BranchAnalyticsServiceImpl(
            OrderRepository orderRepository,
            OrderItemRepository orderItemRepository,
            InventoryRepository inventoryRepository
    ) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.inventoryRepository = inventoryRepository;
    }




    @Override
    public List<DailySalesDTO> getDailySalesChart(Long branchId, int days) {

        LocalDate today = LocalDate.now();

        LocalDate startDate =
                today.minusDays(days - 1);


        List<DailySalesDTO> salesChart =
                new ArrayList<>();


        for(int i=0;i<days;i++){

            LocalDate currentDate =
                    startDate.plusDays(i);


            LocalDateTime start =
                    currentDate.atStartOfDay();


            LocalDateTime end =
                    currentDate.atTime(LocalTime.MAX);



            BigDecimal total =
                    orderRepository
                            .getTotalSalesBetween(
                                    branchId,
                                    start,
                                    end
                            )
                            .orElse(BigDecimal.ZERO);



            DailySalesDTO dto =
                    new DailySalesDTO();

            dto.setDate(currentDate);
            dto.setTotalSales(total);


            salesChart.add(dto);
        }


        return salesChart;
    }





    @Override
    public List<ProductPerformanceDTO>
    getTopProductsByQuantityWithPercentage(Long branchId) {


        List<Object[]> rawData =
                orderItemRepository
                        .getTopProductsByQuantity(branchId);



        long totalQuantity =
                rawData.stream()
                        .mapToLong(obj -> (Long)obj[2])
                        .sum();



        return rawData.stream()
                .limit(5)
                .map(obj -> {


                    String name =
                            (String)obj[1];


                    Long quantity =
                            (Long)obj[2];


                    double percentage =
                            totalQuantity == 0 ?
                                    0 :
                                    ((double)quantity /
                                            totalQuantity) * 100;



                    ProductPerformanceDTO dto =
                            new ProductPerformanceDTO();


                    dto.setProductName(name);
                    dto.setQuantitySold(quantity);
                    dto.setPercentage(
                            Math.round(percentage * 10.0)
                                    / 10.0
                    );


                    return dto;


                })
                .collect(Collectors.toList());
    }





    @Override
    public List<CashierPerformanceDTO>
    getTopCashierPerformanceByOrders(Long branchId) {


        List<Object[]> rawData =
                orderRepository
                        .getTopCashiersByRevenue(branchId);



        return rawData.stream()
                .limit(5)
                .map(obj -> {


                    CashierPerformanceDTO dto =
                            new CashierPerformanceDTO();


                    dto.setCashierId((Long)obj[0]);
                    dto.setCashierName((String)obj[1]);
                    dto.setTotalRevenue((Double)obj[2]);


                    return dto;


                })
                .collect(Collectors.toList());
    }





    @Override
    public List<CategorySalesDTO>
    getCategoryWiseSalesBreakdown(
            Long branchId,
            LocalDate date
    ) {


        LocalDateTime start =
                date.atStartOfDay();


        LocalDateTime end =
                date.atTime(LocalTime.MAX);



        List<Object[]> rawData =
                orderItemRepository
                        .getCategoryWiseSales(
                                branchId,
                                start,
                                end
                        );



        return rawData.stream()
                .map(obj -> {


                    CategorySalesDTO dto =
                            new CategorySalesDTO();


                    dto.setCategoryName((String)obj[0]);
                    dto.setTotalSales((Double)obj[1]);
                    dto.setQuantitySold((Long)obj[2]);


                    return dto;


                })
                .collect(Collectors.toList());
    }





    

    @Override
    public BranchDashboardOverviewDTO getBranchOverview(Long branchId) {


        LocalDate today =
                LocalDate.now();


        LocalDate yesterday =
                today.minusDays(1);



        BigDecimal todaySales =
                orderRepository.getTotalSalesBetween(
                        branchId,
                        today.atStartOfDay(),
                        today.atTime(LocalTime.MAX)
                )
                .orElse(BigDecimal.ZERO);



        BigDecimal yesterdaySales =
                orderRepository.getTotalSalesBetween(
                        branchId,
                        yesterday.atStartOfDay(),
                        yesterday.atTime(LocalTime.MAX)
                )
                .orElse(BigDecimal.ZERO);



        double salesGrowth =
                calculateGrowth(
                        todaySales,
                        yesterdaySales
                );



        int todayOrders =
                orderRepository.countOrdersByBranchAndDate(
                        branchId,
                        today
                );


        int yesterdayOrders =
                orderRepository.countOrdersByBranchAndDate(
                        branchId,
                        yesterday
                );



        double orderGrowth =
                calculateGrowth(
                        todayOrders,
                        yesterdayOrders
                );



        int todayCashiers =
                orderRepository.countDistinctCashiersByBranchAndDate(
                        branchId,
                        today
                );


        int yesterdayCashiers =
                orderRepository.countDistinctCashiersByBranchAndDate(
                        branchId,
                        yesterday
                );



        double cashierGrowth =
                calculateGrowth(
                        todayCashiers,
                        yesterdayCashiers
                );



        int todayLowStock =
                inventoryRepository.countLowStockItems(branchId);



        int yesterdayLowStock = 12;



        double lowStockGrowth =
                calculateGrowth(
                        todayLowStock,
                        yesterdayLowStock
                );



        BranchDashboardOverviewDTO dto =
                new BranchDashboardOverviewDTO();


        dto.setTotalSales(todaySales);
        dto.setSalesGrowth(salesGrowth);
        dto.setOrdersToday(todayOrders);
        dto.setOrderGrowth(orderGrowth);
        dto.setActiveCashiers(todayCashiers);
        dto.setCashierGrowth(cashierGrowth);
        dto.setLowStockItems(todayLowStock);
        dto.setLowStockGrowth(lowStockGrowth);



        return dto;
    }





    private double calculateGrowth(
            Number today,
            Number yesterday
    ) {

        if(yesterday == null ||
                yesterday.doubleValue()==0.0){

            return 0.0;
        }


        return (
                (today.doubleValue()
                - yesterday.doubleValue())
                /
                yesterday.doubleValue()
        ) * 100;
    }
}