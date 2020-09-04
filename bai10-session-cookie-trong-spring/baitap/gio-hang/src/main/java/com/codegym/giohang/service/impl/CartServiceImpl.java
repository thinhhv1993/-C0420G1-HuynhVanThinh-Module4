//package com.codegym.giohang.service.impl;
//
//import com.codegym.giohang.model.Cart;
//import com.codegym.giohang.model.Product;
//import com.codegym.giohang.repository.CartRepository;
//import com.codegym.giohang.service.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import java.util.List;
//
//
//@Service
//public class CartServiceImpl implements CartService {
//
//    @Autowired
//    CartRepository cartRepository;
//
//    @Override
//    public List<Cart> findAll() {
//        return this.cartRepository.findAll();
//    }
//
//    @Override
//    public Cart findById(Long id) {
//        return this.cartRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void save(Cart cart) {
//        this.cartRepository.save(cart);
//    }
//
//    @Override
//    public void remove(Long id) {
//        this.cartRepository.deleteById(id);
//    }
//
//    @Override
//    public Iterable<Cart> findAllCart(Cart cart) {
//        return null;
//    }
//
//    @Override
//    public List<Cart> findAllByFirstNameContaining(String firstname) {
//        return null;
//    }
//}
