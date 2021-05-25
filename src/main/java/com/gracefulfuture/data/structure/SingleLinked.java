package com.gracefulfuture.data.structure;

/**
* @description      单向链表
* @author           chenkun
* @create           2021/5/24 16:43
* @version          1.0
*/
public class SingleLinked<T> {
    private SNode<T> head;

    private int nodeCount;

    private class SNode<T> {
        public SNode next;
        public T data;

        public SNode(SNode next, T data) {
            this.next = next;
            this.data = data;
        }
    }

    public SingleLinked() {
        this.head = new SNode<>(null,null);
        this.nodeCount = 0;
    }
    /**
    * @description  获取链表节点个数
    * @author       chenkun
    * @param
    * @date         2021/5/24 17:22
    * @return		int
    */
    public int size(){
        return nodeCount;
    }
    /**
    * @description  判断链表是否为空
    * @author       chenkun
    * @param
    * @date         2021/5/24 17:22
    * @return		boolean
    */
    public boolean isEmpty(){
        return nodeCount == 0;
    }
    /**
    * @description  获取链表指定位置的节点
    * @author       chenkun
    * @param		index
    * @date         2021/5/24 17:21
    * @return		com.gracefulfuture.data.structure.SingleLinkedTable<T>.SNode
    */
    private SNode<T> getNode(int index){
        SNode node = head.next;
        if(index < 0 || index >= nodeCount){
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index;i++) {
            node = node.next;
        }
        return node;
    }
    /**
    * @description  在链表指定位置插入节点
    * @author       chenkun
    * @param		index
    * @param		data
    * @date         2021/5/24 17:21
    * @return		void
    */
    public void insert(int index,T data){
        if(index > nodeCount || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            SNode node = new SNode(head.next,data);
            head.next = node;
            nodeCount++;
//            return;
        }else if(index == nodeCount){
            //插入位置的前一个节点
            SNode before = getNode(index - 1);
            //新插入的节点
            SNode insertion = new SNode(null,data);
            before.next = insertion;
            nodeCount++;
//            return;
        }else{
            //插入位置的前一个节点
            SNode before = getNode(index - 1);
            //插入位置的原节点
            SNode origin = getNode(index);
            //新插入的节点
            SNode insertion = new SNode(origin,data);
            //前驱节点指向新插入节点
            before.next = insertion;
            nodeCount++;
//            return;
        }
    }
    /**
    * @description  在链表头部插入节点
    * @author       chenkun
    * @param		data
    * @date         2021/5/24 17:20
    * @return		void
    */
    public void insertAtFirst(T data){
        insert(0,data);
    }
    /**
    * @description  在链表尾部插入节点
    * @author       chenkun
    * @param		data
    * @date         2021/5/24 17:37
    * @return		void
    */
    public void insertAtLast(T data){
        SNode insertion = new SNode(null,data);
        if(nodeCount == 0){
            head.next = insertion;
            nodeCount++;
            return;
        }
        SNode before = getNode(nodeCount - 1);
        before.next = insertion;
        nodeCount++;
        return;
    }
    /**
    * @description  删除链表指定位置上的节点
    * @author       chenkun
    * @param		index
    * @date         2021/5/24 17:37
    * @return		void
    */
    public void delete(int index){
        if(index < 0 || index >= nodeCount){
            throw new IndexOutOfBoundsException();
        }
        SNode origin = getNode(index);
        if(index == 0){
            head.next = origin.next;
        }else{
            SNode before = getNode(index - 1);
            before.next = origin.next;
        }
        origin = null;
        nodeCount--;
    }
    /**
    * @description  获取指定位置上节点的数据
    * @author       chenkun
    * @param		index
    * @date         2021/5/25 10:46
    * @return		T
    */
    public T getData(int index){
        if(index < 0 || index >= nodeCount){
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).data;
    }
    /**
    * @description  获取第一个节点的值
    * @author       chenkun
    * @param		
    * @date         2021/5/24 17:40
    * @return		T
    */
    public T getFirstData(){
        return getData(0);
    }
    /**
    * @description  获取最后一个节点的值
    * @author       chenkun
    * @param		
    * @date         2021/5/24 17:41
    * @return		T
    */
    public T getLastData(){
        return getData(nodeCount - 1);
    }
    /**
    * @description  删除链表第一个节点
    * @author       chenkun
    * @param		
    * @date         2021/5/24 17:49
    * @return		void
    */
    public void deleteFirst(){
        delete(0);
    }
    /**
    * @description  删除链表最后一个节点
    * @author       chenkun
    * @param		
    * @date         2021/5/24 17:51
    * @return		void
    */
    public void deleteLast(){
        delete(nodeCount - 1);
    }
}
