package day3

data class Interval constructor(private val start:Int, private val end:Int){
    fun contains(other: Interval):Boolean {
        return this.start <= other.start && this.end >= other.end
    }

    fun overlaps(other: Interval):Boolean {
        return (this.start <= other.start && this.end >= other.start) ||
                (this.start <= other.end && this.end >= other.end) ||
                (this.start > other.start && this.end < other.end)
    }

    companion object {
        fun fromString(intervalStr:String): Interval {
            val intervalStrParts = intervalStr.split("-")
            return Interval(intervalStrParts[0].toInt(), intervalStrParts[1].toInt())
        }
    }

}