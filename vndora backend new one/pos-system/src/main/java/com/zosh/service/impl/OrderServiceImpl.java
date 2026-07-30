package com.zosh.service.impl;

import com.zosh.domain.OrderStatus;

import com.zosh.exception.UserException;
import com.zosh.mapper.OrderMapper;
import com.zosh.modal.*;
import com.zosh.payload.dto.OrderDTO;
import com.zosh.repository.*;

import com.zosh.service.OrderService;
import com.zosh.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;
    private final UserService userService;


    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository,
                            BranchRepository branchRepository,
                            UserService userService) {

        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
        this.userService = userService;
    }


    @Override
    public OrderDTO createOrder(OrderDTO dto) throws UserException {

        User cashier = userService.getCurrentUser();

        Branch branch = cashier.getBranch();

        if (branch == null) {
            throw new UserException("cashier's branch is null");
        }


        Order order = new Order();

        order.setBranch(branch);
        order.setCashier(cashier);
        order.setCustomer(dto.getCustomer());
       

        List<OrderItem>orderItems = dto.getItems()
                .stream()
                .map(itemDto -> {

                    Product product = productRepository.findById(itemDto.getProductId())
                            .orElseThrow(() ->
                                    new EntityNotFoundException("Product not found"));

                    OrderItem orderItem = new OrderItem();

                    orderItem.setProduct(product);
                    orderItem.setQuantity(itemDto.getQuantity());
                    orderItem.setPrice(
                            product.getSellingPrice() * itemDto.getQuantity());
                    orderItem.setOrder(order);

                    return orderItem;
                })
                .collect(Collectors.toList());


        double total = orderItems.stream()
                .mapToDouble(OrderItem::getPrice)
                .sum();


        order.setTotalAmount(total);
        order.setItems(orderItems);


        return OrderMapper.toDto(orderRepository.save(order));
    }



    @Override
    public OrderDTO getOrderById(Long id) {

        return orderRepository.findById(id)
                .map(OrderMapper::toDto)
                .orElseThrow(() ->
                        new EntityNotFoundException("Order not found"));
    }



    @Override
    public List<OrderDTO> getOrdersByBranch(Long branchId,
                                            Long customerId,
                                            Long cashierId,
                                            OrderStatus status) {


        return orderRepository.findByBranchId(branchId)
                .stream()

                .filter(order ->
                        customerId == null ||
                                (order.getCustomer() != null &&
                                        order.getCustomer().getId().equals(customerId)))


                .filter(order ->
                        cashierId == null ||
                                (order.getCashier() != null &&
                                        order.getCashier().getId().equals(cashierId)))


                


                .map(OrderMapper::toDto)


                .sorted((o1, o2) ->
                        o2.getCreatedAt().compareTo(o1.getCreatedAt()))


                .collect(Collectors.toList());
    }
    @Override
    public List<OrderDTO> getOrdersByCashier(Long cashierId) {

        return orderRepository.findByCashierId(cashierId)
                .stream()
                .map(OrderMapper::toDto)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteOrder(Long id) {

        if (!orderRepository.existsById(id)) {

            throw new EntityNotFoundException("Order not found");
        }

        orderRepository.deleteById(id);
    }



    @Override
    public List<OrderDTO> getTodayOrdersByBranch(Long branchId) {

        LocalDate today = LocalDate.now();

        LocalDateTime start = today.atStartOfDay();

        LocalDateTime end = today.plusDays(1).atStartOfDay();


        return orderRepository
                .findByBranchIdAndCreatedAtBetween(branchId, start, end)

                .stream()

                .map(OrderMapper::toDto)

                .collect(Collectors.toList());
    }



    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) {

        List<Order> orders = orderRepository.findByCustomerId(customerId);


        return orders.stream()

                .map(OrderMapper::toDto)

                .collect(Collectors.toList());
    }



    @Override
    public List<OrderDTO> getTop5RecentOrdersByBranchId(Long branchId) {


        branchRepository.findById(branchId)

                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Branch not found with ID: " + branchId
                        ));



        List<Order> orders =
                orderRepository.findTop5ByBranchIdOrderByCreatedAtDesc(branchId);



        return orders.stream()

                .map(OrderMapper::toDto)

                .collect(Collectors.toList());
    }

}