package net.straycalico.ecsample.domain.cart

import net.straycalico.ecsample.domain.item.ItemId
import org.junit.Test

import org.junit.Assert.*

class CartTest {

    @Test
    fun createCartId() {
        val cartId = CartId()
        assertNotNull(cartId.value)
    }

    @Test
    fun createCart() {
        val cart = Cart()
        assertNotNull(cart.cartId.value)
    }

    @Test
    fun currentItems() {
        val cart = Cart()
        assertEquals(0, cart.currentItems().size)
    }

    @Test
    fun addItem() {
        val cart = Cart()
        cart.addItem(ItemId("item1"))
        cart.addItem(ItemId("item2"))
        cart.addItem(ItemId("item2"))
        assertEquals(2, cart.currentItems().size)
    }

    @Test
    fun removeItem() {
        val cart = Cart()
        cart.addItem(ItemId("item1"))
        cart.addItem(ItemId("item2"))
        cart.addItem(ItemId("item3"))
        assertEquals(3, cart.currentItems().size)
        cart.removeItem(ItemId("item3"))
        assertEquals(2, cart.currentItems().size)
    }

}