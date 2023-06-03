package com.example.homemarket.controller;

import com.example.homemarket.dtos.CartDTO;
import com.example.homemarket.dtos.request.PlaceOrderRequestDTO;
import com.example.homemarket.dtos.request.ItemEditRequestDTO;
import com.example.homemarket.dtos.request.ItemRequestDTO;
import com.example.homemarket.dtos.response.BaseResponse;
import com.example.homemarket.facade.CartFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartFacade cartFacade;

    public CartController(CartFacade cartFacade) {
        this.cartFacade = cartFacade;
    }

    @CrossOrigin
    @GetMapping("/items")
    public ResponseEntity<CartDTO> getCart(@RequestParam("key") Integer userId){
        return cartFacade.getCart(userId);
    }

    @CrossOrigin
    @GetMapping("/checkout")
    public ResponseEntity<BaseResponse> checkout(@RequestParam("key") List<Integer> cartItemId) {
        return cartFacade.checkout(cartItemId);
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> createItem(@RequestBody ItemRequestDTO itemRequestDTO){
        return cartFacade.createItem(itemRequestDTO);
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse> delete(@RequestParam("key") Integer itemId){
        return cartFacade.deleteItem(itemId);
    }

    @CrossOrigin
    @PostMapping("/edit")
    public ResponseEntity<BaseResponse> update(@RequestBody ItemEditRequestDTO itemEditRequestDTO){
        return cartFacade.updateItemQuantity(itemEditRequestDTO);
    }

    @CrossOrigin
    @PostMapping("/place_order")
    public ResponseEntity<BaseResponse> placeOrder(@RequestBody PlaceOrderRequestDTO placeOrderRequestDTO){
        return cartFacade.placeOrder(placeOrderRequestDTO);
    }
}
