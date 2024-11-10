package com.projectone.librarymanagement.service;

import com.projectone.librarymanagement.entity.Orders;
import com.projectone.librarymanagement.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository orderRepository;

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    public Orders updateOrder(Long id, Orders orderDetails) {
        Optional<Orders> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Orders order = existingOrder.get();
            order.setCustomerName(orderDetails.getCustomerName());
            order.setBookTitle(orderDetails.getBookTitle());
            order.setTotalAmount(orderDetails.getTotalAmount());
            order.setStatus(orderDetails.getStatus());
            order.setRemarks(orderDetails.getRemarks());
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found with id " + id);
        }
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
