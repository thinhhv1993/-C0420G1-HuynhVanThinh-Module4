package com.codegym.giohang.controller;

import com.codegym.giohang.model.Cart;
import com.codegym.giohang.model.Product;
//import com.codegym.giohang.service.CartService;
import com.codegym.giohang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    ProductService productService;

//    @Autowired
//    CartService cartService;

    @ModelAttribute("cart")
    public Cart setUpUserForm() {
        return new Cart();
    }

    @GetMapping("/products")
    public ModelAndView listProduct(){
        productService.findAll();
        return new ModelAndView("a/product/list","products", productService.findAll());
    }

    @GetMapping("/view-product/{id}")
    public ModelAndView viewProduct(@PathVariable Long id){
        Product product = productService.findById(id);
        return new ModelAndView("a/product/views","product",product);
    }

    @PostMapping("/view-product/{id}")
    public ModelAndView addViewProduct(@ModelAttribute("cart") Cart cart,@PathVariable("id") Long id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("a/product/views");
        modelAndView.addObject("product",product);
        if(product == null){
            modelAndView.addObject("message","Error");
        }else {
            cart.addToCart(product);
            modelAndView.addObject("message","Thêm " +product.getProductName()+" thành công");
        }
        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView saveCart(@ModelAttribute("cart") Cart cart, Model model){
        model.addAttribute("total",cart.totalProduct());
      return new ModelAndView("a/carts/cart","list",cart.getCart());
    }
    @GetMapping("/cart/{id}")
    public ModelAndView removeProduct(@ModelAttribute("cart") Cart cart, @PathVariable Long id, RedirectAttributes redirect){
        redirect.addFlashAttribute("message", cart.removeProduct(productService.findById(id)));
        return new ModelAndView("redirect:/cart");
    }
    @PostMapping("/cart-update/{id}")
    public ModelAndView updateProduct(@ModelAttribute("cart") Cart cart, @PathVariable Long id, RedirectAttributes redirect,@RequestParam("number") Integer number){
        redirect.addFlashAttribute("message", cart.updateProduct(productService.findById(id),number));
        return new ModelAndView("redirect:/cart");
    }
}
