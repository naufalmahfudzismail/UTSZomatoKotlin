package naufalmahfudz.uts.zomato.kategori

interface KategoriView {

    fun onLoading()
    fun onStopLoading()
    fun getData(data : List<Kategori>?)
}