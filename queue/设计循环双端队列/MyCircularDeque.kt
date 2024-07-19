package queue.设计循环双端队列

class MyCircularDeque(k: Int) {

    var l = 0
    var r = 0
    var size = 0
    val limit = k
    var arr = IntArray(k)

    fun insertFront(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            if (isEmpty()) {
                l = 0
                r = 0
                arr[0] = value
            } else {
                l = if (l == 0) limit - 1 else l - 1
                arr[l] = value
            }
            size++
            true
        }
    }

    fun insertLast(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            if (isEmpty()) {
                l = 0
                r = 0
                arr[0] = value
            } else {
                r = if (r == limit - 1) 0 else r + 1
                arr[r] = value
            }
            size++
            true
        }
    }

    fun deleteFront(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            l = if (l == limit - 1) 0 else l + 1
            size--
            true
        }
    }

    fun deleteLast(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            r = if (r == 0) limit - 1 else r - 1
            size--
            true
        }
    }

    fun getFront(): Int {
        return if (isEmpty()) {
            -1
        } else {
            arr[l]
        }
    }

    fun getRear(): Int {
        return if (isEmpty()) {
            -1
        } else {
            arr[r]
        }
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == limit
    }

}

/**
 * Your queue.设计循环双端队列.MyCircularDeque object will be instantiated and called as such:
 * var obj = queue.设计循环双端队列.MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */