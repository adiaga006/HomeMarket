package com.example.homemarket.facade;

import com.example.homemarket.dtos.CartDTO;
import com.example.homemarket.dtos.request.ItemEditRequestDTO;
import com.example.homemarket.dtos.request.ItemRequestDTO;
import com.example.homemarket.dtos.request.PlaceOrderRequestDTO;
import com.example.homemarket.dtos.response.BaseResponse;
import com.example.homemarket.service.cart.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartFacade {
    private final CartService cartService;

    public CartFacade(CartService cartService) {
        this.cartService = cartService;
    }

    public ResponseEntity<CartDTO> getCart(Integer userId) {
        return ResponseEntity.ok(cartService.getCart(userId));
    }

    public ResponseEntity<BaseResponse> checkout(List<Integer> cartItemId) {
        BaseResponse response = cartService.checkout(cartItemId);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<BaseResponse> createItem(ItemRequestDTO itemRequestDTO) {
        try {
            return ResponseEntity.ok(cartService.createItem(itemRequestDTO));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse(false, e.getMessage()));
        }
    }

    public ResponseEntity<BaseResponse> deleteItem(Integer itemId) {
        try {
            return ResponseEntity.ok(cartService.deleteItem(itemId));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse(false, e.getMessage()));
        }
    }

    public ResponseEntity<BaseResponse> updateItemQuantity(ItemEditRequestDTO itemEditRequestDTO) {
        try {
            return ResponseEntity.ok(cartService.updateItemQuantity(itemEditRequestDTO));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse(false, e.getMessage()));
        }
    }

    public ResponseEntity<BaseResponse> placeOrder(PlaceOrderRequestDTO placeOrderRequestDTO) {
        try {
            return ResponseEntity.ok(cartService.placeOrder(placeOrderRequestDTO));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponse(false, e.getMessage()));
        }
    }
}
