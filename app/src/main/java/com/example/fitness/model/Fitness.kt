package com.example.fitness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Fitness(
@StringRes val titleId: Int,
    @StringRes val headingId: Int,
    @DrawableRes val imageId : Int,
    @StringRes val detailId: Int
)
