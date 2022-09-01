package kz.arctan.composestateflow

object ItemsRepository {
    private val items: ArrayList<Item> = arrayListOf(
        Item(
            title = "Hellohrewilfkrlkwklfewhifhwilfhwfewewhfewli",
            content = "Worldfwefewfefewfewfewfewfewfewfwefwwefewfewfewfewfewfew",
            id = 0,
            completed = false
        ),
        Item(
            title = "Hello",
            content = "World",
            id = 0,
            completed = false
        ),
        Item(
            title = "Hello",
            content = "World",
            id = 0,
            completed = false
        )
    )

    fun addItem(item: Item) {
        items.add(item)
    }

    fun updateItem(item: Item) {
        val itemToChange = items.find { it.id == item.id }
        val itemIndex = items.indexOf(itemToChange)
        items[itemIndex] = item
    }

    fun deleteItem(item: Item) {
        val itemToDelete = items.find { it.id == item.id }
        val itemIndex = items.indexOf(itemToDelete)
        items.removeAt(itemIndex)
    }

    fun getAllItems() = items

    fun getItemById(id: Int) = items.find { it.id == id }
}