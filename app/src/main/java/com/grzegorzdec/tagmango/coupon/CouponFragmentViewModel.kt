package com.grzegorzdec.tagmango.coupon

import androidx.databinding.Bindable
import com.grzegorzdec.tagmango.BR
import com.grzegorzdec.tagmango.BaseViewModel
import com.grzegorzdec.tagmango.R
import com.grzegorzdec.tagmango.model.User
import com.grzegorzdec.tagmango.repository.Repository
import com.grzegorzdec.tagmango.tools.databinding.bindable
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CouponFragmentViewModel(repository: Repository) : BaseViewModel() {

    @get:Bindable
    var user: User? by bindable(null)

    init {
        scope.launch {
            user = repository.getUser("088cb73d-af4b-4b99-97c2-87a150c6b5b4")
            notifyPropertyChanged(BR.user)
        }
    }

    @get:Bindable("user")
    val stamp0
        get() = user?.stamps?.firstOrNull()

    @get:Bindable("user")
    val stamp1
        get() = user?.stamps?.getOrNull(1)

    @get:Bindable("user")
    val stamp2
        get() = user?.stamps?.getOrNull(2)

    @get:Bindable("user")
    val stamp3
        get() = user?.stamps?.getOrNull(3)

    @get:Bindable("user")
    val stamp4
        get() = user?.stamps?.getOrNull(4)

    @get:Bindable("user")
    val stamp5
        get() = user?.stamps?.getOrNull(5)

    @get:Bindable("user")
    val stamp6
        get() = user?.stamps?.getOrNull(6)

    @get:Bindable("user")
    val stamp7
        get() = user?.stamps?.getOrNull(7)

    @get:Bindable("stamp0")
    val stamp0Date
        get() = stamp0?.date?.toDateString()

    @get:Bindable("stamp1")
    val stamp1Date
        get() = stamp1?.date?.toDateString()

    @get:Bindable("stamp2")
    val stamp2Date
        get() = stamp2?.date?.toDateString()

    @get:Bindable("stamp3")
    val stamp3Date
        get() = stamp3?.date?.toDateString()

    @get:Bindable("stamp4")
    val stamp4Date
        get() = stamp4?.date?.toDateString()

    @get:Bindable("stamp5")
    val stamp5Date
        get() = stamp5?.date?.toDateString()

    @get:Bindable("stamp6")
    val stamp6Date
        get() = stamp6?.date?.toDateString()

    @get:Bindable("stamp7")
    val stamp7Date
        get() = stamp7?.date?.toDateString()

    @get:Bindable("stamp0")
    val stamp0Background
        get() = if (stamp0 != null) R.drawable.ic_coupon_stamp else R.drawable.ic_coupon_empty

    @get:Bindable("stamp1")
    val stamp1Background
        get() = if (stamp1 != null) R.drawable.ic_coupon_stamp else R.drawable.ic_coupon_empty

    @get:Bindable("stamp2")
    val stamp2Background
        get() = if (stamp2 != null) R.drawable.ic_coupon_stamp else R.drawable.ic_coupon_empty

    @get:Bindable("stamp3")
    val stamp3Background
        get() = if (stamp3 != null) R.drawable.ic_coupon_stamp else R.drawable.ic_coupon_empty

    @get:Bindable("stamp4")
    val stamp4Background
        get() = if (stamp4 != null) R.drawable.ic_coupon_stamp else R.drawable.ic_coupon_empty

    @get:Bindable("stamp5")
    val stamp5Background
        get() = if (stamp5 != null) R.drawable.ic_coupon_stamp else R.drawable.ic_coupon_empty

    @get:Bindable("stamp6")
    val stamp6Background
        get() = if (stamp6 != null) R.drawable.ic_coupon_stamp else R.drawable.ic_coupon_empty

    @get:Bindable("stamp7")
    val stamp7Background
        get() = if (stamp7 != null) R.drawable.ic_coupon_stamp else R.drawable.ic_coupon_empty
}

fun Long.toDateString(): String {
    val outputMonthFormat = SimpleDateFormat("dd/MM")
    outputMonthFormat.timeZone = TimeZone.getDefault()

    return outputMonthFormat.format(Date(this))
}