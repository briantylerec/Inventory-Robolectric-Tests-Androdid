package com.monksoft.inventory.addModule.model

import com.monksoft.inventory.common.MyDataBase
import com.monksoft.inventory.entities.Product

class AddRepository {
    private val myDataBase by lazy { MyDataBase.getInstance() }

    fun addProduct(product: Product, callback: (isSuccess: Boolean) -> Unit){
        callback(myDataBase.add(product))
    }
}