package com.yss.other.数据结构与算法.链表;

/**
 * @author: duhao
 * @date: 2020/8/26 17:23
 */
public class MyLinkedList {
    //定义个一个头节点
    Node head;
    //链表的长度
    int size;

    // 创建节点
    class Node {

        //结点数据
        int data;
        //结点指针
        Node next;

        //无参构造函数
        public Node(int data) {
            this.data = data;
        }
    }


    /*增加节点,顺序插入, 也就是尾部追加数据*/
    public void addNode(int data) {
        // 先对头结点处理
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }
        // 遍历到尾节点
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 找到为节点,赋值
        temp.next = new Node(data);
        size++;
    }

    /*删除节点,我们得考虑依据什么来删除，我们之前定义了一个size来代表链表的长度，增加一个节点就加一，
    你想是不是可以看做这些链表节点根据加入的先后顺序被编号了，也就是有了索引，
    那么我们这里删除的时候就根据这个索引来删除。*/
    public Node deleteNode(int index) {
        //处理空链表
        if (size == 0) {
            return null;
        }
        //处理异常索引
        if (index < 1 || index > size) {
            return null;
        }
        //删除头结点
        if (index == 1) {
            Node temp = head;
            head = head.next;
            size--;
            return temp;
        }
        //删除非头结点
        //从头结点的下一个节点开始遍历
        Node cureNode = head.next;
        //记录当前循环的节点的上一个节点用于删除当前节点
        Node preNode = head;
        int i = 2;
        while (cureNode != null) {
            if (i == index) {
                // 要删除的就是次节点
                preNode.next = cureNode.next;
                size--;
                break;
            } else {
                preNode = cureNode;
                cureNode = cureNode.next;
                i++;
            }
        }
        return cureNode;
    }
/*打印链表*/
    public  void printList(){
        Node curNode = this.head;
        //循环遍历
        while (curNode!=null){
            System.out.print(curNode.data+" ");
            curNode=curNode.next;
        }
        System.out.println();
    }
    /*返回聊表的长度*/
    public  int getSize(){
        return  size;
    }

}
