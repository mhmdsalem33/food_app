package com.salem.foodapp.presentation.extentions

fun generateRandomPrice(): Double {
    // Generate a random price between 5.00 and 50.00
    val price = (500..5000).random() / 100.0
    return String.format("%.2f", price).toDouble() // Ensures 2 decimal places
}
