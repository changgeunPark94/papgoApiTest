package com.example.papgoapitest

import com.google.gson.annotations.SerializedName

data class BitcoinDTO (
    @SerializedName("name") var name:String,                                    // 코인 이름
    @SerializedName("opening_price") val opening_price:String,                     // 시가 00시 기준
    @SerializedName("closing_price") val closing_price:String,                     // 종가 00시 기준
    @SerializedName("min_price") val min_price:String,                             // 저가 00시 기준
    @SerializedName("max_price") val max_price:String,                             // 고가 00시 기준
    @SerializedName("units_traded") val units_traded:String,                       // 거래량 00시 기준
    @SerializedName("acc_trade_value") val acc_trade_value:String,                 // 거래금액 00시 기준
    @SerializedName("prev_closing_price") val prev_closing_price:String,           // 전일 종가
    @SerializedName("units_traded_24H") val units_traded_24H:String,               // 24시간 거래량
    @SerializedName("acc_trade_value_24H") val acc_trade_value_24H:String,         // 24시간 거래금액
    @SerializedName("fluctate_24H") val fluctate_24H:String,                       // 24시간 변동가
    @SerializedName("fluctate_rate_24H") val fluctate_rate_24H:String,             // 24시간 변동률
    @SerializedName("date") val date:String                                        // 타임스탬프
)
data class BithumbStatue(
    @SerializedName("status") val status:String
)