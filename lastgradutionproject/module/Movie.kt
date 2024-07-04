package com.example.lastgradutionproject.module

import com.example.lastgradutionproject.R

data class Movie(
    val id:String,
    val name:String,
    val type:String,
    val description:String,
    val image: List<Int>,
    val price:String,
    val color:String

    )
fun getmovies():List<Movie>{
    return listOf(
        Movie(
            id="ProductCode : 223aa",
            name ="Product Name : Swishirt",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            image = listOf(R.drawable.img_8,
                R.drawable.img_9,
                R.drawable.img_10,R.drawable.img_11)
            ,
            price = "Product Price : 233$",
            color = "Red /Black/mintgreen/white"

        ),
        Movie(
            id="ProductCode : 113aa",

            name ="Product Name : Womensuit",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            image = listOf(R.drawable.img_33,
                R.drawable.img_40,
                R.drawable.img_77,R.drawable.img_81),
            price = "Product Price : 133$",
            color = "Red /Black/mintgreen/white/blue"

        ),
        Movie(
            id="ProductCode : 443bb",

            name ="Product Name : Cotch",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            image = listOf(R.drawable.img_13,
                R.drawable.img_63,
                R.drawable.img_52,R.drawable.img_18),
            price = "Product Price : 114$",
            color = "Red /Black/cafee/white"

        ),
        Movie(
            id="ProductCode : 444dd",

            name ="Product Name : Jacket",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            image = listOf(R.drawable.img_17,
                R.drawable.img_62,
                R.drawable.img_71,R.drawable.img_19),
            price = "Product Price : 330$",
            color = "Red /Black/lavandre/white,babyblue"

        ),
        Movie(
            id="ProductCode : 432cc",

            name ="Product Name : Babysuit",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            image = listOf(R.drawable.img_80,
                R.drawable.img_57,
                R.drawable.img_58,R.drawable.img_14),
            price = "Product Price : 421$",
            color = "Red /Black/purple/white,yellow"

        ),
        Movie(
            id="ProductCode : 900cc",

            name ="Product Name : Babysuit",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            image = listOf(R.drawable.img_81,
                R.drawable.img_59,
                R.drawable.img_66,R.drawable.img_30),
            price = "Product Price : 210$",
            color = "Red /Black/gray/white"

        ),
        Movie(
            id="ProductCode : 467cc",

            name ="Product Name : Bag",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            image = listOf(R.drawable.img_90,
                R.drawable.img_101,
                R.drawable.img_82,R.drawable.img_20),
            price = "Product Price : 100$",
            color = "Red /Black/Darkgray/white"

        ),
        Movie(
            id="ProductCode : 432cc",

            name ="Product Name : heils",
            type = "men jersy",
            description ="cotton shirt for men made in china",
            image = listOf(R.drawable.img_101,
                R.drawable.img_44,
                R.drawable.img_88,R.drawable.img_17),
            price = "Product Price : 421$",
            color = "Red /Black/Brown/white,sky"

        ),



        )

}
