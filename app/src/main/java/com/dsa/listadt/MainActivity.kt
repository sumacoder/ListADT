package com.dsa.listadt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dsa.listadt.adt.SinglyLinkedList
import com.dsa.listadt.adt.SinglyLinkedList.Node

private val TAG = MainActivity::class.simpleName!!

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Main Activity onCreate")
        val linkedList = SinglyLinkedList<Int>()
        linkedList.insertAtPosition(Node(7), 0)
        linkedList.insertFirst(Node(5))
        linkedList.insertLast(Node(10))
        linkedList.insertFirst(Node(2))
        linkedList.insertAtPosition(Node(1), 3)

        Log.d(TAG, "Size of the list after add: ${linkedList.size}")
        printList(linkedList)

        linkedList.deleteFirst()
        // this should return false as we don't have node with 2 value
        Log.d(TAG, "Deleted value ${linkedList.deleteGivenNode(Node(2))}")
        // Node with value 7 is present in the list so it should return true
        Log.d(TAG, "Deleted value2 ${linkedList.deleteGivenNode(Node(7))}")
        linkedList.deleteLast()

        Log.d(TAG, "Node with value 5 contains in list: ${linkedList.contains(Node(5))}")
        Log.d(TAG, "Node with value 12 contains in list: ${linkedList.contains(Node(12))}")
        Log.d(TAG, "Size of the list after delete: ${linkedList.size}")
        printList(linkedList)
    }

    private fun printList(linkedList: SinglyLinkedList<Int>) {
        var currentNode = linkedList.dataList
        while (currentNode != null) {
            Log.d(TAG, "Value: ${currentNode.data}")
            currentNode = currentNode.next
        }
    }

/*    private fun hanoi(n: Int, fromPeg: Char, auxPeg: Char, toPeg: Char) {
        if (n == 1) {
            Log.d("@@@", "Move disk 1 from $fromPeg to $toPeg")
            return
        } else {
            hanoi(n - 1, fromPeg, toPeg, auxPeg)
            Log.d("@@@", "Move disk $n from $fromPeg to $toPeg")
            hanoi(n - 1, auxPeg, fromPeg, toPeg)
        }
    }*/
}
