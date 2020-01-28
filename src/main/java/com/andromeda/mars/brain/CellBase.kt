package com.andromeda.mars.brain

abstract class CellBase(i:Int, u:Int, size:Int) {
    val index = i
    val unitSize = u
    var finalData = 0

    val data = arrayListOf<Int>()
    val cells = arrayListOf<CellBase>()
    init {
        val sizeSplit =unitSize / 2
        var indexParse = index
        while (indexParse != index + unitSize){
            indexParse = indexParse + 1
            if (indexParse <= 0){
            }
            else if(indexParse == size) {
                break
            }
            else{
                cells.add(Cell(index = indexParse, size = size, unitWidth = u))
            }
        }
        println("done")
    }
    open fun dataToCell(newData:Int){

        data.add(newData)
        if (data.size == unitSize){
            data.forEach {
                finalData = if (finalData == 0) it
                else finalData.xor(it)
                dataOutOfCell(finalData)

            }
            data.clear()

        }

    }
    fun setNewDataListener(run:Runnable){
        run.run()
    }
    open fun dataOutOfCell(toSend:Int){
        println(toSend)
        cells.forEach {
            it.dataToCell(toSend)
        }
    }
}