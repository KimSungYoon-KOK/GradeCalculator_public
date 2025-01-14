package com.kok.grade_calculator.mypage

import android.os.Parcel
import android.os.Parcelable

data class MyPageItem(
    var semester: Int,
    var className: String,      //과목명
    var credit:Int,             //이수 학점
    var grade:Float,            //현재 성적
    var category: Boolean,      //수업 분류(전공:true, 교양:false)
    var retakeGrade:Float       //재수강 후 학점
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readByte() != 0.toByte(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(semester)
        parcel.writeString(className)
        parcel.writeInt(credit)
        parcel.writeFloat(grade)
        parcel.writeByte(if (category) 1 else 0)
        parcel.writeFloat(retakeGrade)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyPageItem> {
        override fun createFromParcel(parcel: Parcel): MyPageItem {
            return MyPageItem(parcel)
        }

        override fun newArray(size: Int): Array<MyPageItem?> {
            return arrayOfNulls(size)
        }
    }

}