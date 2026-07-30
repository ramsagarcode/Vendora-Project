package com.zosh.service.impl;

import com.zosh.domain.StoreStatus;
import com.zosh.payload.AdminAnalysis.DashboardSummaryDTO;
import com.zosh.payload.AdminAnalysis.StoreRegistrationStatDTO;
import com.zosh.payload.AdminAnalysis.StoreStatusDistributionDTO;
import com.zosh.repository.StoreRepository;
import com.zosh.service.AdminDashboardService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class AdminDashboardServiceImpl implements AdminDashboardService {


    private final StoreRepository storeRepository;


    // Constructor injection (replacement of @RequiredArgsConstructor)
    public AdminDashboardServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }



    @Override
    public DashboardSummaryDTO getDashboardSummary() {

        Long total = storeRepository.count();
        Long active = storeRepository.countByStatus(StoreStatus.ACTIVE);
        Long pending = storeRepository.countByStatus(StoreStatus.PENDING);
        Long blocked = storeRepository.countByStatus(StoreStatus.BLOCKED);


        DashboardSummaryDTO response =
                new DashboardSummaryDTO();

        response.setTotalStores(total);
        response.setActiveStores(active);
        response.setPendingStores(pending);
        response.setBlockedStores(blocked);


        return response;
    }



    @Override
    public List<StoreRegistrationStatDTO> getLast7DayRegistrationStats() {

        LocalDateTime today = LocalDateTime.now();

        LocalDateTime sevenDaysAgo =
                today.minusDays(6);


        List<Object[]> rawStats =
                storeRepository.getStoreRegistrationStats(sevenDaysAgo);



        Map<String, Long> dataMap =
                new LinkedHashMap<>();


        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");



        // Initialize 0 counts for 7 days
        for (int i = 0; i < 7; i++) {

            LocalDateTime date =
                    sevenDaysAgo.plusDays(i);

            dataMap.put(
                    date.format(formatter),
                    0L
            );
        }



        for (Object[] row : rawStats) {

            LocalDateTime date =
                    (LocalDateTime) row[0];

            Long count =
                    (Long) row[1];


            dataMap.put(
                    date.format(formatter),
                    count
            );
        }



        List<StoreRegistrationStatDTO> result =
                new ArrayList<>();


        dataMap.forEach((date, count) -> {

            StoreRegistrationStatDTO dto =
                    new StoreRegistrationStatDTO();

            dto.setDate(date);
            dto.setCount(count);

            result.add(dto);
        });


        return result;
    }




    @Override
    public StoreStatusDistributionDTO getStoreStatusDistribution() {

        Long active =
                storeRepository.countByStatus(StoreStatus.ACTIVE);

        Long blocked =
                storeRepository.countByStatus(StoreStatus.BLOCKED);

        Long pending =
                storeRepository.countByStatus(StoreStatus.PENDING);



        StoreStatusDistributionDTO response =
                new StoreStatusDistributionDTO();


        response.setActive(active);
        response.setBlocked(blocked);
        response.setPending(pending);


        return response;
    }
}