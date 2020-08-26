package com.yss.other.数据结构与算法.链表;

/**测试
 * @author: duhao
 * @date: 2020/8/26 17:49
 */
public class TestLinkedList
{
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(10);
        myLinkedList.addNode(20);
        myLinkedList.addNode(30);
        myLinkedList.printList();
        System.out.println("链表长度:"+myLinkedList.size);
        //删除节点
        myLinkedList.deleteNode(1);
        myLinkedList.printList();
        System.out.println("链表长度:"+myLinkedList.size);

    }
}
