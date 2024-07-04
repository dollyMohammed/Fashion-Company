package com.example.lastgradutionproject.navigation

import com.example.lastgradutionproject.screans.startScrean.StartScrean

enum class MillanoScreans {
        //ClientScreans
        SplashScrean,
        OnBordingScrean,
        StartScrean,
        LoginScrean,
        SignUpScrean,
        HomeScrean,
        SearchScrean,
        WomenScrean,
        MenScrean,
        KidsScrean,
        OrderScrean,
        ShosesScrean,
    nextorderscrean,
        Historyscrean,
    orderscrean2,
    prossingscrean,
    shipingscrean,
    favouritescrean,
    profilescrean,
    editprofile,
    reportscrean,
    forgetpasswoed,
    aftersignUpscrean,
    codescrean,
    shipedscrean,
    confirmscrean,
    beforeorder,

        //DesignerScreans
        DesignerHomeScrean,
        myDesignsScreans,
        HistoryScrean,
    designerScrean,
    newscrean,
    // ManagerScrean
    controlscreen,
    designScrean,
    mangprofile,

        ChangeHowToChangeHowToRateScrean;


        companion object {
            fun getScreenName(screen: MillanoScreans): String {
                return when (screen) {
                    SplashScrean -> SplashScrean.name
                    OnBordingScrean -> OnBordingScrean.name
                    StartScrean -> StartScrean.name
                    OrderScrean -> OrderScrean.name
                        WomenScrean -> WomenScrean.name
                    LoginScrean -> LoginScrean.name
                        MenScrean -> MenScrean.name
                        KidsScrean -> KidsScrean.name
                        ShosesScrean-> ShosesScrean.name
                    SignUpScrean -> SignUpScrean.name
                    Historyscrean -> Historyscrean.name
                    confirmscrean -> confirmscrean.name
                    prossingscrean -> prossingscrean.name
                    orderscrean2 -> orderscrean2.name
                    beforeorder -> beforeorder.name
                    DesignerHomeScrean -> DesignerHomeScrean.name
                    shipingscrean -> shipingscrean.name
                    mangprofile -> mangprofile.name
                    HomeScrean -> HomeScrean.name
                    profilescrean -> profilescrean.name
                    shipedscrean -> shipedscrean.name
                    editprofile -> editprofile.name
                    forgetpasswoed -> forgetpasswoed.name
                    designerScrean -> designerScrean.name
                    aftersignUpscrean -> aftersignUpscrean.name
                    myDesignsScreans -> myDesignsScreans.name
                    nextorderscrean -> nextorderscrean.name
                    codescrean -> codescrean.name
                    reportscrean -> reportscrean.name
                    newscrean -> newscrean.name
                    controlscreen -> controlscreen.name
                    favouritescrean -> favouritescrean.name
                    designScrean -> designScrean.name
                    SearchScrean -> SearchScrean.name
                    null -> "null"


                    else -> throw IllegalArgumentException("Screan not found")
                }
            }
        }
    }


