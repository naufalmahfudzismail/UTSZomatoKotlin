package naufalmahfudz.uts.zomato.restoran

interface RestoranView {

    fun onLoading()
    fun onStopLoading()
    fun getData(data : List<Restoran>?)
}