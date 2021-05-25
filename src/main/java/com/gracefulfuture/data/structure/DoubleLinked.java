package com.gracefulfuture.data.structure;

/**
* @description      双链表类
* @author           chenkun
* @create           2021/5/25 10:16
* @version          1.0
*/
public class DoubleLinked<T> {
    private DNode head;
    private int nodeCount;

    public DoubleLinked() {
        this.head = new DNode(null,null,null);
        head.prev = head.next = head;
        this.nodeCount = 0;
    }

    private class DNode{
        private DNode prev;
        private DNode next;
        private T data;

        public DNode(DNode prev, DNode next,T data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }
    /**
    * @description  获取链表的节点数
    * @author       chenkun
    * @param
    * @date         2021/5/25 10:41
    * @return		int
    */
    public int size(){
        return nodeCount;
    }
    /**
    * @description  判断链表是否为空
    * @author       chenkun
    * @param
    * @date         2021/5/25 10:41
    * @return		boolean
    */
    public boolean isEmpty(){
        return nodeCount == 0;
    }
    /**
    * @description  在链表指定位置插入节点
    * @author       chenkun
    * @param		index
    * @param		data
    * @date         2021/5/25 11:00
    * @return		void
    */
    public void insert(int index, T data){
        if(index == 0){
            DNode node = new DNode(head,head.next,data);
            head.next.prev = node;
            head.next = node;
            nodeCount++;
            return;
        }
        DNode origin = getNode(index);
        DNode insertion = new DNode(origin.prev,origin,data);
        origin.prev.next = insertion;
        origin.prev = insertion;
        nodeCount++;
        return ;
    }
    /**
    * @description  在链表头部插入节点
    * @author       chenkun
    * @param		data
    * @date         2021/5/25 11:06
    * @return		void
    */
    public void insertAtFirst(T data){
        insert(0,data);
    }
    /**
    * @description  在链表尾部插入节点
    * @author       chenkun
    * @param		data
    * @date         2021/5/25 11:05
    * @return		void
    */
    public void insertAtLast(T data){
        DNode node = new DNode(head.prev,head,data);
        head.prev.next = node;
        head.prev = node;
        node.next = head;
        nodeCount++;
    }
    
    /**
    * @description  获取指定位置的节点
    * @author       chenkun
    * @param		index 节点的索引
    * @date         2021/5/25 10:27
    * @return		com.gracefulfuture.data.structure.DoubleLinked<T>.DNode
    */
    private DNode getNode(int index){
        if (index < 0 || index >= nodeCount){
            throw new IndexOutOfBoundsException();
        }
        int middle = nodeCount / 2;
        if(index <= middle){
            DNode node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        int endIndex = nodeCount - index - 1;
        DNode node = head.prev;
        for (int j = 0; j < endIndex; j++) {
            node = node.prev;
        }
        return node;
    }
    /**
    * @description  获取指定位置上节点的数据
    * @author       chenkun
    * @param		index
    * @date         2021/5/25 10:44
    * @return		T
    */
    public T getData(int index){
        return getNode(index).data;
    }
    /**
    * @description  获取第一个节点的数据
    * @author       chenkun
    * @param		
    * @date         2021/5/25 10:48
    * @return		T
    */
    public T getFirstData(){
        return getData(0);
    }
    /**
    * @description  获取最后一个节点的数据
    * @author       chenkun
    * @param		
    * @date         2021/5/25 10:48
    * @return		T
    */
    public T getLastData(){
        return getData(nodeCount - 1);
    }
    /**
    * @description  删除指定位置的节点
    * @author       chenkun
    * @param		index
    * @date         2021/5/25 11:10
    * @return		void
    */
    public void delete(int index){
        DNode node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
        nodeCount--;
    }
    /**
    * @description  删除链表的第一个节点
    * @author       chenkun
    * @param
    * @date         2021/5/25 11:10
    * @return		void
    */
    public void deleteFirst(){
        delete(0);
    }
    /**
    * @description  删除链表的最后一个节点
    * @author       chenkun
    * @param
    * @date         2021/5/25 11:10
    * @return		void
    */
    public void deleteLast(){
        delete(nodeCount - 1);
    }
}
