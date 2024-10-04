package com.example.fitness.data

import com.example.fitness.R
import com.example.fitness.model.Fitness

object DataSource {
    val fitnessData = listOf(
        Fitness(R.string.day_1, R.string.chest_day, R.drawable.chestimg, R.string.chest_details),
        Fitness(R.string.day_2, R.string.back_day, R.drawable.backimg, R.string.back_details),
        Fitness(R.string.day_3, R.string.legs_day, R.drawable.legsimg, R.string.legs_details),
        Fitness(R.string.day_4, R.string.shoulder_day, R.drawable.shoulderimg, R.string.shoulder_details),
        Fitness(R.string.day_5, R.string.abs_day, R.drawable.absimg, R.string.abs_details),
        Fitness(R.string.day_6, R.string.arm_day, R.drawable.armimg, R.string.arms_details)
    )
}