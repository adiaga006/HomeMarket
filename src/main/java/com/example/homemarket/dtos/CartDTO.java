package com.example.homemarket.dtos;

import com.example.homemarket.entities.Cart;
import com.example.homemarket.entities.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Integer cartId;
    private Integer userId;
    private List<CartItemDTO> itemList;

    public static class Builder {
        private Integer cartId;
        private Integer userId;
        private List<CartItemDTO> itemList;

        public Builder withCartId(Integer cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder withItemList(List<CartItemDTO> itemList) {
            this.itemList = itemList;
            return this;
        }

        public CartDTO build() {
            return new CartDTO(cartId, userId, itemList);
        }
    }

    public CartDTO(Cart cart) {
        this.cartId = cart.getCartID();
        this.userId = cart.getUser().getUserID();
        List<CartItemDTO> itemDTOS = new ArrayList<>();
        for (CartItem singleItem : cart.getItems()){
            CartItemDTO itemDTO = new CartItemDTO(singleItem);
            itemDTOS.add(itemDTO);
        }
        this.itemList = itemDTOS;
    }
}
