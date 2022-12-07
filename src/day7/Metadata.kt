package day7


enum class Type{
    Dir,
    File
}
data class Metadata(val name:String, val type:Type, var size: Long) {

    fun addSize(size: Long){
        this.size += size
    }

    fun isDir():Boolean{
        return type == Type.Dir
    }
    override fun toString():String{
        return if(isDir()){
            "$name (dir, size=$size)"
        }else{
            "$name (file, size=$size)"
        }
    }

}