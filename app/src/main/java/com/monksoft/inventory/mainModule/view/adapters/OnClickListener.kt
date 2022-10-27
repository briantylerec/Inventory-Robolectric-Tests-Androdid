package com.monksoft.inventory.mainModule.view.adapters

import com.monksoft.inventory.entities.Product

interface OnClickListener {
    fun onClick(product: Product)
    fun onLongClick(product: Product)
}