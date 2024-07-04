package com.example.lastgradutionproject.module

import com.example.lastgradutionproject.R

data class Movie2(
    val ud:String,
    val name:String,
    val type:String,
    val description:String,
    val images: List<Int>,
    val price:String,
    val color:String

)
fun getmovies2(): List<Movie2> {
    return listOf(
        Movie2(
            ud="ProductCode : 897ba",
            name ="Product Name : Sulibt for child",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            images = listOf(R.drawable.img_77,
                R.drawable.img_19,
                R.drawable.img_71,R.drawable.img_55)
            ,
            price = "Product Price : 233$",
            color = "Red /Black/mintgreen/white"

        ),
        Movie2(
            ud="ProductCode : 113kk",

            name ="Product Name : shimis",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            images = listOf(R.drawable.img_39,
                R.drawable.img_48,
                R.drawable.img_88,R.drawable.img_102),
            price = "Product Price : 133$",
            color = "Red /Black/mintgreen/white/blue"

        ),
        Movie2(
            ud="ProductCode : 900mm",

            name ="Product Name : T-shirt",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            images = listOf(R.drawable.img_60,
                R.drawable.img_69,
                R.drawable.img_53,R.drawable.img_30),
            price = "Product Price : 114$",
            color = "Red /Black/cafee/white"

        ),
        Movie2(
            ud="ProductCode : 443bb",

            name ="Product Name : Cotch",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            images = listOf(R.drawable.img_30,
                R.drawable.img_31,
                R.drawable.img_32,R.drawable.img_33),
            price = "Product Price : 114$",
            color = "Red /Black/cafee/white"

        ),
        Movie2(
            ud="ProductCode : 443bb",

            name ="Product Name : Cotch",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            images = listOf(R.drawable.img_40,
                R.drawable.img_41,
                R.drawable.img_34,R.drawable.img_42),
            price = "Product Price : 114$",
            color = "Red /Black/cafee/white"

        ),



        )

}

